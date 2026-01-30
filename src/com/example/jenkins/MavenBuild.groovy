package com.example.jenkins
class MavenBuild{
boolean skipTests

	MavenBuild(Map config){
		this.skipTests=config.skipTests ?: 'false'
	}
	def mavenBuild(){

	def cmd = "mvn clean package"
	if(skipTests){

	cmd+= "-DskipTests"
	}
	sh cmd
	}
}
