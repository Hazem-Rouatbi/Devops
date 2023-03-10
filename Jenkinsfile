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
                    sh 'mvn package -DskipTests'
                }
                }
                }
        stage("build angular"){
            agent any
            steps{
                dir('SimpleBlog')
                {
                    sh 'npm install --save --legacy-peer-deps'
                    sh 'npm run build --prod'
                    sh 'docker build -t hazemr/blogfront:$BUILD_ID -f Dockerfile .'
                    sh 'docker push hazemr/blogfront:$BUILD_ID'
                }
            }
        }
        stage("docker maven"){
            agent any
                steps{
                    dir('BlogBack'){
                sh 'docker build -t hazemr/blogback:$BUILD_ID -f Dockerfile .'
                sh 'docker push hazemr/blogback:$BUILD_ID'
                }
            }
        }
        stage("cleanup"){
                steps{
                sh 'docker rmi hazemr/blogfront:$BUILD_ID'
                sh 'docker rmi hazemr/blogback:$BUILD_ID'
                }
            }
        stage("logout"){
                steps{
                sh 'docker logout'
                }
            }
        }   
}
