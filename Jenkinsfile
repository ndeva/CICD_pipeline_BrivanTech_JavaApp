pipeline{
    agent any
    environment{
        VERSION = "${env.BUILD_ID}"
    }
    stages{
        stage("Sonar Quality Check"){
            agent {
                docker {
                    image 'openjdk:11'
                }
            }
            steps{
                script{
                    withSonarQubeEnv(credentialsid: 'sonar-token'){
                        sh 'chmod +x gradlew'
                        sh './gradlew sonarqube'
                    }
                    timeout(time: 1, unit: 'HOURS'){
                        def qg = waitForQualityGate()
                        if (qg.status != 'OK'){
                            error 'Pipeline stopped due to quality gate failure: ${qg.status}'
                        }
                    }
                    
                }
            }
            
        }
        stage("Docker image build & push"){
            steps{
                script{
                    withCredentials([string(credentialsId: 'docker_password', variable: 'docker_password')]) {
                        sh '''
                           docker build -t 36.128.214.178:8083/brivan:${VERSION} .
                           docker login -u admin -p $docker_password 36.128.214.178:8083
                           docker push 36.128.214.178:8083/brivan:${VERSION}
                           docker rmi 36.128.214.178:8083/brivan:${VERSION}

                        '''
                    }
                    
                }
            }
        }
    }
    
}