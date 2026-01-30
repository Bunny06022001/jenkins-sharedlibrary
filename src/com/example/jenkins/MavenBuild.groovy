package com.example.jenkins
def script
class MavenBuild{
boolean skipTests

	MavenBuild(def script,Map config){
		this.script=script
		this.skipTests=config.skipTests ?: 'false'
	}
	def mavenBuild(){

	def cmd = "mvn clean package"
	if(skipTests){

	cmd+= "-DskipTests"
	}
	script.sh cmd
	}
}
