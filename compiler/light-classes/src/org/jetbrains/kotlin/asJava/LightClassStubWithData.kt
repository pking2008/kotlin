/*
 * Copyright 2010-2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.asJava

import com.intellij.psi.impl.java.stubs.PsiJavaFileStub
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.psi.JetClassOrObject
import org.jetbrains.kotlin.resolve.diagnostics.Diagnostics
import org.jetbrains.kotlin.name.FqName

interface LightClassData

interface WithFileStubAndExtraDiagnostics {
    val javaFileStub: PsiJavaFileStub
    val extraDiagnostics: Diagnostics
}

interface LightClassDataForKotlinClass: LightClassData {
    val classOrObject: JetClassOrObject
    val descriptor: ClassDescriptor?
    val jvmQualifiedName: FqName
}

data class KotlinPackageLightClassData(
        override val javaFileStub: PsiJavaFileStub,
        override val extraDiagnostics: Diagnostics
): LightClassData, WithFileStubAndExtraDiagnostics

data class InnerKotlinClassLightClassData(
        override val jvmQualifiedName: FqName,
        override val classOrObject: JetClassOrObject,
        override val descriptor: ClassDescriptor?
): LightClassDataForKotlinClass

data class OutermostKotlinClassLightClassData(
        override val javaFileStub: PsiJavaFileStub,
        override val extraDiagnostics: Diagnostics,
        override val jvmQualifiedName: FqName,
        override val classOrObject: JetClassOrObject,
        override val descriptor: ClassDescriptor?,
        val allInnerClasses: Map<JetClassOrObject, InnerKotlinClassLightClassData>
): LightClassDataForKotlinClass, WithFileStubAndExtraDiagnostics
