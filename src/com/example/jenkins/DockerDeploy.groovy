package com.example.jenkins
class DockerDeploy{
  def script
  String image
  String tag

  DockerDeploy(def script,Map config){
    this.script=script
    this.image=config.image
    this.tag=config.tag
  }
  def deploy(){
    if(params.ENV == 'prod'){
  script.input(
    message: "are u sure to launch",
    ok: "launch now",
    submitter: "admin"
  )
script.sh """
docker run -d --name=app-${tag} -p \${APP_PORT}:8080 ${image}:${tag}
"""
}
  }
}
