def call(Map configure = [:]){
String image = configure.image
  String tag =  configure.tag ?: 'latest'

if(params.ENV == 'prod'){
  input(
    message: "are u sure to launch",
    ok: "launch now",
    submitter: "admin"
  )
sh """
docker run -d --name=app:${tag} -p \${APP_PORT}:8080 ${image}:${tag}
"""
}
  
}
