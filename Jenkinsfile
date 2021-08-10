pipeline {
  agent any
  stages {
    stage('step1') {
      parallel {
        stage('step1') {
          steps {
            sh 'echo "step1"'
            sh 'echo "hh"'
          }
        }

        stage('step1-1') {
          steps {
            sh 'echo "hello"'
          }
        }

      }
    }

  }
}