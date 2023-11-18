pipeline {
    agent any

    tools {
        gradle "GRADLE_HOME"
    }
    stages {
        stage('Clean') {
                    steps {
                        script {
                            // Wykonaj clean przed budową
                            sh "./gradlew clean"
                        }
                    }
                }
        stage('Build') {
            steps {
                script {
                    sh "./gradlew build"
                }
            }
        }
        stage('Test') {
                    steps {
                        script {
                            // Wykonaj testy po budowie
                            sh "./gradlew test"
                        }
                    }
                }
}

