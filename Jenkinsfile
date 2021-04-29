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
                parallel {
                    withGradle { sh './gradlew test' },
                    withGradle { sh './gradlew integrationTest' }
                }
            }
        }
        stage('Code Coverage Verification') {
            steps { withGradle { sh './gradlew jacocoTestCoverageVerification' } }
        }
        stage('Code Analysis') {
            steps { withGradle { sh './gradlew checkstyleMain pmdMain cpd spotbugsMain sonarqube dependencyCheckAnalyze' } }
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