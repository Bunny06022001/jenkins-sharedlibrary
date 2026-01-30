package com.example.jenkins
class GitService{
 String branch
 String repourl

	GitService(Map config){
	this.branch = config.branch ?: '*/main'
         this.repourl =  config.repourl		
	}
	def gitverify(){
		checkout([
	$class: 'GitSCM',
	branches: [[name: branch]],
	userRemoteConfigs: [[
		url: repourl,
		credentialsId: 'git'
	]]
        ])
	
	}

}
