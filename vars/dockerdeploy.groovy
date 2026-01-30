import com.example.jenkins.DockerDeploy
def call(Map configure = [:]){

new DockerDeploy(this,config).deploy()
}
