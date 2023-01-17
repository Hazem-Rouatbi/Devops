pipeline{
    agent any
    environment {
        DOCKERHUB_CREDENTIALS = credentials('dh_cred')
    }
    stages {            
        stage('get'){
                agent any
                steps{
                       git branch: 'main', url: 'https://github.com/Hazem-Rouatbi/Devops.git'
                }
            }
        stage("login"){
                steps{
                    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                }
        }
        stage("build maven w/o tests"){
                steps {
                dir('BlogBack'){
                    sh 'mvn clean install -DskipTests .'
                }
                }
                }
        stage("build angular"){
                steps {
                dir('SimpleBlog'){
                    sh 'npm install --save --legacy-peer-deps'
                    sh 'npm run build --prod'
                }
        }
        }
        stage("docker maven"){
                steps{
                    dir('BlogBack'){
                sh 'docker build -t hazemr/blogBack:$BUILD_ID -f Dockerfile .'
                sh 'docker push  -t hazemr/blogBack:$BUILD_ID -f Dockerfile .'
                }
            }
        }
        stage("docker angular"){
                steps{
                         dir('SimpleBlog'){
                sh 'docker build -t hazemr/blogFront:$BUILD_ID -f Dockerfile .'
                sh 'docker push  -t hazemr/blogFront:$BUILD_ID -f Dockerfile .'
                }
            }
        }
        stage("logout"){
                steps{
                sh 'docker logout'
                }
            }
        }   
}
