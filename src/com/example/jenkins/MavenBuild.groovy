package com.example.jenkins

class MavenBuild{
	def script
boolean skipTests

	MavenBuild(def script,Map config){
		this.script=script
		this.skipTests=config.skipTests ?: false
	}
	def mavenBuild(){

	def cmd = "mvn clean package"
	if(skipTests){

	cmd+= " -DskipTests"
	}
	script.sh cmd
	}
}
