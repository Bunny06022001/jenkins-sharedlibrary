import com.example.jenkins.DockerDeploy
def call(Map config = [:]){

new DockerDeploy(this,config).deploy()
}
