package com.example.jenkins
class DockerBuildPush{
String image
String tag
def script

DockerBuildPush(def script,Map config){
this.script=script
this.image=config.image
this.tag=config.tag ?: 'latest'
}
def buildPush(){

script.sh """
docker rm -f \$(docker ps -aq) || true
docker rmi -f \$(docker images -q) || true
docker build -t ${image}:${tag} .

"""
  script.withCredentials([
      usernamePassword(
        credentialsId: 'docker',
      usernameVariable: 'DOCKER_USER',
        passwordVariable: 'DOCKER_PASS'
    )
    
  ]){
    script.sh """
    echo \${DOCKER_PASS} | docker login -u \${DOCKER_USER} --password-stdin
    docker push ${image}:${tag}
    """
  }

}

}
