environment {
  imageName = 'fdlessard/spring-boot-repository-rest-resource'
  registryCredentialSet = 'dockerhub'
}

pipeline {
    agent any
    tools { jdk 'openjdk-15.0.2' }
    stages {
        stage('Compilation') {
            steps { withGradle { sh './gradlew clean integrationTestClasses' } }
        }
        stage('Tests') {
            steps {
                parallel (
                    "Unit Tests": { withGradle { sh './gradlew test' } },
                    "Integration Tests": { withGradle { sh './gradlew integrationTest' } }
                )
            }
        }
        stage('Code Coverage Verification') {
            steps { withGradle { sh './gradlew jacocoTestCoverageVerification' } }
        }
        stage('Code Analysis') {
            steps {
              parallel (
                    "CheckStyle" : { withGradle { sh './gradlew checkstyleMain ' } },
                    "PMD" : { withGradle { sh './gradlew pmdMain' } },
                    "CPD" : { withGradle { sh './gradlew cpd'  } },
                    "SpotBugs" : { withGradle { sh './gradlew  spotbugsMain' } },
                    "SonarQube" : { withGradle { sh './gradlew  sonarqube' } },
                    "DependencyCheck" : { withGradle { sh './gradlew dependencyCheckAnalyze' } }
              )
            }
        }
        stage('Build & Publish Docker Image') {
            steps { withGradle { sh './gradlew bootBuildImage' } }
       }
    }
    post {
        always {
            junit 'build/test-results/unitTest/*.xml'
            junit 'build/test-results/integrationTest/*.xml'
             step([
                  $class: 'JacocoPublisher',
                  execPattern: 'build/jacoco/*.exec',
                  classPattern: 'build/classes',
                  sourcePattern: 'src/main/java',
                  exclusionPattern: 'src/test*'
            ])
            dependencyCheckPublisher pattern: 'build/reports/dependency-check-report.xml'
            recordIssues enabledForFailure: true, tool: checkStyle(pattern: 'build/reports/checkstyle/*.xml')
            recordIssues enabledForFailure: true, tool: pmdParser(pattern: 'build/reports/pmd/*.xml')
            recordIssues enabledForFailure: true, tool: cpd(pattern: 'build/reports/cpd/*.xml')
            recordIssues enabledForFailure: true, tool: spotBugs(pattern: 'build/reports/spotbugs/*.xml')
        }
    }
}