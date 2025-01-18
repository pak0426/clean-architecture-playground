package io.refactoring.bank.archunit;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;

import java.util.List;

import static com.tngtech.archunit.base.DescribedPredicate.greaterThanOrEqualTo;
import static com.tngtech.archunit.lang.conditions.ArchConditions.containNumberOfElements;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

abstract class ArchitectureElement {

  final String basePackage;

  public ArchitectureElement(String basePackage) {
    this.basePackage = basePackage;
  }

  String fullQualifiedPackage(String relativePackage) {
    return this.basePackage + "." + relativePackage;
  }

  static void denyDependency(String fromPackageName, String toPackageName, JavaClasses classes) {
    noClasses()
        .that()
        .resideInAPackage(fromPackageName)
        .should()
        .dependOnClassesThat()
        .resideInAnyPackage(toPackageName)
        .check(classes);
  }

  static void denyAnyDependency(
      List<String> fromPackages, List<String> toPackages, JavaClasses classes) {
    for (String fromPackage : fromPackages) {
      for (String toPackage : toPackages) {
        noClasses()
            .that()
            .resideInAPackage(matchAllClassesInPackage(fromPackage))
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage(matchAllClassesInPackage(toPackage))
            .check(classes);
      }
    }
  }

  static String matchAllClassesInPackage(String packageName) {
    return packageName + "..";
  }

  void denyEmptyPackage(String packageName) {
    JavaClasses packageClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages(packageName);

    classes()
            .that()
            .resideInAPackage(matchAllClassesInPackage(packageName))
            .should(containNumberOfElements(greaterThanOrEqualTo(1)))
            .check(packageClasses);
  }

  private JavaClasses classesInPackage(String packageName) {
    return new ClassFileImporter().importPackages(packageName);
  }

  void denyEmptyPackages(List<String> packages) {
    for (String packageName : packages) {
      denyEmptyPackage(packageName);
    }
  }
}
