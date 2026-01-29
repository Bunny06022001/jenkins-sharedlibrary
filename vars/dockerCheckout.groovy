def call(Map config = [:]){
String branch = config.branch ?: '*/main'
String repourl =  config.repourl
checkout([
	$class: 'GitSCM',
	branches: [[name: branch]],
	userRemoteConfigs: [[
		url: repourl,
		credentialsId: 'git'
	]]
])
}
