/*
 * Copyright 2010-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.idea.parameterInfo.custom

import com.intellij.openapi.editor.*
import com.intellij.openapi.editor.markup.TextAttributes
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.*
import org.jetbrains.kotlin.idea.KotlinLanguage

class ReturnHintLinePainter : EditorLinePainter() {
    override fun getLineExtensions(project: Project, file: VirtualFile, lineNumber: Int): List<LineExtensionInfo>? {
        val psiFile = PsiManager.getInstance(project).findFile(file) ?: return null
        if (psiFile.language != KotlinLanguage.INSTANCE) {
            return nullResult(112, lineNumber)
        }

        val doc = FileDocumentManager.getInstance().getDocument(file) ?: return nullResult(111, lineNumber)
        val editors = EditorFactory.getInstance().getEditors(doc)
        if (editors.isEmpty()) return nullResult(114, lineNumber)

        val hint = getReturnHintText(project, lineNumber, editors, doc) ?: return nullResult(10, lineNumber)

        val hintLineInfo = LineExtensionInfo(" $hint", TextAttributes())
        return listOf(hintLineInfo)
    }

    private fun getReturnHintText(
        project: Project,
        lineNumber: Int,
        editors: Array<Editor>,
        doc: Document
    ): String? {
        val lineEndOffset = try {
            doc.getLineEndOffset(lineNumber)
        } catch (ex: IndexOutOfBoundsException) {
            return nullResult(0, lineNumber)
        }

        val rangeHint = KotlinCodeHintsModel.getInstance(project)
            .getExtensionInfo(editors.first(), lineEndOffset)
        if (rangeHint != null) {
            return rangeHint
        }

        return nullResult(5, lineNumber)
    }

    private fun <T: Any> nullResult(i: Int, lineNumber: Int): T? {
        return null
    }
}