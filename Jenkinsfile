pipeline {
    agent any

    tools {
        jdk 'openjdk-15.0.2'

    }
    stages {
        stage('Clean') {
            steps {
                withGradle {
                    sh './gradlew clean'
                }
            }
        }
        stage('Compiling') {
            steps {
                withGradle {
                    sh './gradlew integrationTestClasses'
                }
            }
        }
        stage('Unit Tests') {
            steps {
                withGradle {
                    sh './gradlew test'
                }
            }
        }
        stage('Integration Tests') {
            steps {
                withGradle {
                    sh './gradlew integrationTest'
                }
            }
        }
        stage('Code Coverage') {
            steps {
                withGradle {
                    sh './gradlew jacocoTestCoverageVerification'
                    sh './gradlew sonarqube'
                }
            }
        }
        stage('Static Code Analysis') {
            steps {
                withGradle {
                    sh './gradlew checkstyleMain'
                    sh './gradlew pmdMain'
                    sh './gradlew cpd'
                    sh './gradlew spotbugsMain'
        //           sh './gradlew sonarqube'
        //            sh './gradlew dependencyCheckAnalyze'
                }
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
            recordIssues enabledForFailure: false, tools: [
                checkStyle(pattern: 'build/reports/checkstyle/*.xml'),
                pmdParser(pattern: 'build/reports/pmd/*.xml'),
                cpd(pattern: 'build/reports/cpd/*.xml'),
      //          spotBugs(pattern: 'build/reports/spotbugs/*.xml')
     //           dependencyCheckPublisher(pattern: 'build/reports/dependency-check-report.xml')
            ]
        }
    }
}