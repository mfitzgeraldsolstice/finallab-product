pipeline {
     agent any


     stages {
        stage('Build') {
           steps {
              sh 'gradle clean compileJava'
              sh './gradlew clean assemble'
           }
        }
        stage('Deploy'){
                   steps{
                       sh 'cf push product -p ./build/libs/product-0.0.1-SNAPSHOT.jar'
                   }
        }
     }
 }