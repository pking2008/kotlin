/*
 * Copyright 2010-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license 
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.idea.parameterInfo.custom

import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.EditorFactory
import com.intellij.openapi.editor.RangeMarker
import com.intellij.openapi.editor.event.EditorFactoryEvent
import com.intellij.openapi.editor.event.EditorFactoryListener
import com.intellij.openapi.editor.ex.DocumentEx
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.util.containers.ContainerUtil
import org.jetbrains.kotlin.idea.conversion.copy.range
import org.jetbrains.kotlin.psi.psiUtil.endOffset
import java.util.concurrent.ConcurrentHashMap

class KotlinCodeHintsModel(val project: Project) : EditorFactoryListener {
    companion object {
        fun getInstance(project: Project): KotlinCodeHintsModel =
            project.getComponent(KotlinCodeHintsModel::class.java) ?: error("Component `KotlinCodeHintsModel` is expected to be registered")
    }

    private class EditorExtensionInfoModel(val editor: Editor) {
        val lineEndMarkers = ConcurrentHashMap<RangeMarker, String>()

        fun dispose() {
            for (marker in lineEndMarkers.keys()) {
                marker.dispose()
            }
        }
    }

    private val editorsModels =
        ContainerUtil.createConcurrentSoftMap<Editor, EditorExtensionInfoModel>()

    init {
        val editorFactory = EditorFactory.getInstance()
        editorFactory.addEditorFactoryListener(this, project)
    }

    override fun editorReleased(event: EditorFactoryEvent) {
        editorsModels.remove(event.editor)?.dispose()
    }

    fun getExtensionInfoAtOffset(editor: Editor): String? {
        return getExtensionInfo(editor, editor.caretModel.offset)
    }

    fun getExtensionInfo(editor: Editor, offset: Int): String? {
        return editorsModels[editor]?.lineEndMarkers
            ?.entries
            ?.firstOrNull { (rangeMarker, _) ->
                val textRange = rangeMarker.range ?: return@firstOrNull false
                val hasNewLine = rangeMarker.document.getText(textRange).contains('\n')

                if (hasNewLine) {
                    textRange.startOffset == offset
                } else {
                    textRange.endOffset == offset
                }
            }
            ?.value
    }

    fun removeAll(editor: Editor) {
        editorsModels.remove(editor)?.dispose()
    }

    fun update(editor: Editor, actualHints: Map<PsiElement, String>) {
        if (actualHints.isEmpty()) {
            removeAll(editor)
            return
        }

        val document = editor.document as? DocumentEx ?: return

        val actualizedModel = EditorExtensionInfoModel(editor)
        for ((element, hint) in actualHints) {
            val lineNumber = document.getLineNumber(element.endOffset)
            val lineEndOffset = document.getLineEndOffset(lineNumber)

            val linePreciseMarker = document.createRangeMarker(lineEndOffset, lineEndOffset)
            linePreciseMarker.isGreedyToRight = true
            actualizedModel.lineEndMarkers[linePreciseMarker] = hint
        }

        editorsModels.put(editor, actualizedModel)?.dispose()
    }
}