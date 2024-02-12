@Library('my-shared-library') _

pipeline {
    agent any

    stages {
        stage('Greet') {
            steps {
                greet 'John' // Use custom step from shared library
            }
        }
    }
}
