package io.refactoring.bank;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

public class DependencyRuleTests {

    private final JavaClasses classes = new ClassFileImporter()
            .importPackages("io.refactoring.bank.account");

    @Test
    void domain_should_not_depend_on_application() {
        ArchRule rule = classes()
                .that().resideInAPackage("io.refactoring.bank.account.domain..") // domain 패키지의 모든 클래스들은
                .should().onlyDependOnClassesThat()                              // 의존해야 한다
                .resideOutsideOfPackages("io.refactoring.bank.account.application.."); // application 패키지 외의 다른 패키지에만

        rule.check(classes);
    }
}
