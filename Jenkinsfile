pipeline{
    agent any
    environment {
        DOCKERHUB_CREDENTIALS = credentials('dh_cred')
    }
    stages {            
        stage('get'){
                agent any
                steps{
                       git branch: 'main', url: 'https://github.com/Hazem-Rouatbi/BlogBack.git'
                }
            }
        stage("login"){
                steps{
                    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                }
        }
        stage("build_no_test"){
                steps{
                    sh 'mvn package -Dmaven.test.skip=true'
                }
        }
            stage("docker_build"){
                steps{
                sh 'docker build -t hazemr/blogback:$BUILD_ID -f Dockerfile .'
            }
            }
            stage("docker_push"){
                steps{
                 sh 'docker push hazemr/blogback:$BUILD_ID'
                }
            }
            stage("logout"){
                steps{
                sh 'docker logout'
                }
            }
        }   
}
