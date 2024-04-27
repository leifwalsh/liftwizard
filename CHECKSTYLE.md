# Checkstyle Configuration for Liftwizard

This document outlines the Checkstyle configuration for the Liftwizard project. The configuration is based on the Google Checks with modifications to align with the existing codebase.

## Configuration File

The Checkstyle configuration file is `google_checks.xml` located at the root of the project.

## Disabled Checks

The following checks have been disabled to conform to the existing code without requiring any changes:

- AbbreviationAsWordInName
- ClassTypeParameterName
- LocalVariableName
- ParameterName
- PatternVariableName
- MissingJavadocMethod

These rules were disabled because they generated warnings that the existing code did not conform to.

## Running Checkstyle

To run Checkstyle with this configuration, use the following command from the root directory of the project:

```bash
java -cp "/usr/share/java/checkstyle.jar:/usr/share/java/picocli-3.9.6.jar:/usr/share/java/commons-logging-1.2.jar:/usr/share/java/commons-collections3-3.2.2.jar:/usr/share/java/Saxon-HE-9.9.1.5.jar:/usr/share/java/antlr4-runtime-4.7.2.jar" com.puppycrawl.tools.checkstyle.Main -c google_checks.xml .
```

This command includes all necessary JARs in the classpath and specifies the main class to execute Checkstyle.

## Output

The output of the Checkstyle analysis is redirected to a file named `checkstyle_output.txt` in the root directory. This file contains all warnings and information about code style issues detected by Checkstyle.

For any further customizations or to re-enable certain checks, modify the `google_checks.xml` file accordingly.
