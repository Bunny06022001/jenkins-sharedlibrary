def call(Map config = [:] ){
  echo "CONFIG MAP => ${config}"
  String image = config.image
  String tag = config.tag ?: 'latest'


sh """
docker rm -f $(docker ps -aq) || true
docker rmi -f $(docker images -q) || true
docker build -t ${image}:${tag} .

"""
  withCredentials([
      usernamePassword(
        credentialsId: 'docker',
      usernameVariable: 'DOCKER_USER',
        passwordVariable: 'DOCKER_PASS'
    )
    
  ]){
    sh """
    echo ${DOCKER_PASS} | docker login -u ${DOCKER_USER} --password-stdin
    docker push ${image}:${tag}
    """
  }

}
