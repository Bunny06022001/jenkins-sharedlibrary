package com.example.jenkins
class GitService{
	def script
 String branch
 String repourl

	GitService(def script,Map config){
		this.script = script
	this.branch = config.branch ?: '*/main'
         this.repourl =  config.repourl		
	}
	def gitverify(){
		script.checkout([
	$class: 'GitSCM',
	branches: [[name: branch]],
	userRemoteConfigs: [[
		url: repourl,
		credentialsId: 'git'
	]]
        ])
	
	}

}
