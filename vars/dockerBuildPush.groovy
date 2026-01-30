import com.example.jenkins.DockerBuildPush
def call(Map config = [:] ){
  new DockerBuildPush(this,config).buildPush()
}
