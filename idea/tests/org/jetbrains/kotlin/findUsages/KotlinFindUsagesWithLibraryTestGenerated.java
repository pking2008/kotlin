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

package org.jetbrains.kotlin.findUsages;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.JetTestUtils;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("idea/testData/findUsages/libraryUsages")
@TestDataPath("$PROJECT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
public class KotlinFindUsagesWithLibraryTestGenerated extends AbstractKotlinFindUsagesWithLibraryTest {
    public void testAllFilesPresentInLibraryUsages() throws Exception {
        JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/findUsages/libraryUsages"), Pattern.compile("^(.+)\\.0\\.kt$"), true);
    }

    @TestMetadata("idea/testData/findUsages/libraryUsages/javaLibrary")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class JavaLibrary extends AbstractKotlinFindUsagesWithLibraryTest {
        public void testAllFilesPresentInJavaLibrary() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/findUsages/libraryUsages/javaLibrary"), Pattern.compile("^(.+)\\.0\\.kt$"), true);
        }

        @TestMetadata("LibraryClassUsages.0.kt")
        public void testLibraryClassUsages() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/findUsages/libraryUsages/javaLibrary/LibraryClassUsages.0.kt");
            doTest(fileName);
        }

        @TestMetadata("LibraryConstructorUsages.0.kt")
        public void testLibraryConstructorUsages() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/findUsages/libraryUsages/javaLibrary/LibraryConstructorUsages.0.kt");
            doTest(fileName);
        }

        @TestMetadata("LibraryFieldUsages.0.kt")
        public void testLibraryFieldUsages() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/findUsages/libraryUsages/javaLibrary/LibraryFieldUsages.0.kt");
            doTest(fileName);
        }

        @TestMetadata("LibraryMethodUsages.0.kt")
        public void testLibraryMethodUsages() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/findUsages/libraryUsages/javaLibrary/LibraryMethodUsages.0.kt");
            doTest(fileName);
        }

        @TestMetadata("LibraryStaticFieldUsages.0.kt")
        public void testLibraryStaticFieldUsages() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/findUsages/libraryUsages/javaLibrary/LibraryStaticFieldUsages.0.kt");
            doTest(fileName);
        }

        @TestMetadata("LibraryStaticMethodUsages.0.kt")
        public void testLibraryStaticMethodUsages() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/findUsages/libraryUsages/javaLibrary/LibraryStaticMethodUsages.0.kt");
            doTest(fileName);
        }
    }

    @TestMetadata("idea/testData/findUsages/libraryUsages/kotlinLibrary")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class KotlinLibrary extends AbstractKotlinFindUsagesWithLibraryTest {
        public void testAllFilesPresentInKotlinLibrary() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/findUsages/libraryUsages/kotlinLibrary"), Pattern.compile("^(.+)\\.0\\.kt$"), true);
        }

        @TestMetadata("LibraryClassUsages.0.kt")
        public void testLibraryClassUsages() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/findUsages/libraryUsages/kotlinLibrary/LibraryClassUsages.0.kt");
            doTest(fileName);
        }

        @TestMetadata("LibraryCompanionObjectUsages.0.kt")
        public void testLibraryCompanionObjectUsages() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/findUsages/libraryUsages/kotlinLibrary/LibraryCompanionObjectUsages.0.kt");
            doTest(fileName);
        }

        @TestMetadata("LibraryEnumEntryUsages.0.kt")
        public void testLibraryEnumEntryUsages() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/findUsages/libraryUsages/kotlinLibrary/LibraryEnumEntryUsages.0.kt");
            doTest(fileName);
        }

        @TestMetadata("LibraryFunctionUsages.0.kt")
        public void testLibraryFunctionUsages() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/findUsages/libraryUsages/kotlinLibrary/LibraryFunctionUsages.0.kt");
            doTest(fileName);
        }

        @TestMetadata("LibraryMemberFunctionUsages.0.kt")
        public void testLibraryMemberFunctionUsages() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/findUsages/libraryUsages/kotlinLibrary/LibraryMemberFunctionUsages.0.kt");
            doTest(fileName);
        }

        @TestMetadata("LibraryNestedClassMemberFunctionUsages.0.kt")
        public void testLibraryNestedClassMemberFunctionUsages() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/findUsages/libraryUsages/kotlinLibrary/LibraryNestedClassMemberFunctionUsages.0.kt");
            doTest(fileName);
        }

        @TestMetadata("LibraryNestedClassPrimaryConstructorUsages.0.kt")
        public void testLibraryNestedClassPrimaryConstructorUsages() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/findUsages/libraryUsages/kotlinLibrary/LibraryNestedClassPrimaryConstructorUsages.0.kt");
            doTest(fileName);
        }

        @TestMetadata("LibraryNestedClassSecondaryConstructorUsages.0.kt")
        public void testLibraryNestedClassSecondaryConstructorUsages() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/findUsages/libraryUsages/kotlinLibrary/LibraryNestedClassSecondaryConstructorUsages.0.kt");
            doTest(fileName);
        }

        @TestMetadata("LibraryNestedClassUsages.0.kt")
        public void testLibraryNestedClassUsages() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/findUsages/libraryUsages/kotlinLibrary/LibraryNestedClassUsages.0.kt");
            doTest(fileName);
        }

        @TestMetadata("LibraryObjectUsages.0.kt")
        public void testLibraryObjectUsages() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/findUsages/libraryUsages/kotlinLibrary/LibraryObjectUsages.0.kt");
            doTest(fileName);
        }

        @TestMetadata("LibraryPrimaryConstructorUsages.0.kt")
        public void testLibraryPrimaryConstructorUsages() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/findUsages/libraryUsages/kotlinLibrary/LibraryPrimaryConstructorUsages.0.kt");
            doTest(fileName);
        }

        @TestMetadata("LibrarySecondaryConstructorUsages.0.kt")
        public void testLibrarySecondaryConstructorUsages() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("idea/testData/findUsages/libraryUsages/kotlinLibrary/LibrarySecondaryConstructorUsages.0.kt");
            doTest(fileName);
        }
    }

    @TestMetadata("idea/testData/findUsages/libraryUsages/_library")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class _library extends AbstractKotlinFindUsagesWithLibraryTest {
        public void testAllFilesPresentIn_library() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/findUsages/libraryUsages/_library"), Pattern.compile("^(.+)\\.0\\.kt$"), true);
        }

    }
}
