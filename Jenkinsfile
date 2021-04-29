environment {
  imageName = 'fdlessard/spring-boot-repository-rest-resource'
  registryCredentialSet = 'dockerhub'
}

pipeline {
    agent any
    tools { jdk 'openjdk-15.0.2' }
    stages {
        stage('Compiling') {
            steps {
                withGradle {
                    sh './gradlew clean'
                    sh './gradlew integrationTestClasses'
                }
            }
        }
        stage('Unit Tests') {
            steps {
                withGradle { sh './gradlew test' }
            }
        }
        stage('Integration Tests') {
            steps {
                withGradle { sh './gradlew integrationTest' }
            }
        }
        stage('Code Coverage Verification') {
            steps {
                withGradle { sh './gradlew jacocoTestCoverageVerification' }
            }
        }
        stage('Code Analysis') {
            steps {
                withGradle {
                    sh './gradlew checkstyleMain'
                    sh './gradlew pmdMain'
                    sh './gradlew cpd'
                    sh './gradlew spotbugsMain'
                    sh './gradlew sonarqube'
                    sh './gradlew dependencyCheckAnalyze'
                }
            }
        }
        stage('Build & Publish Docker Imag') {
            steps {
                withGradle { sh './gradlew bootBuildImage' }
            }
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