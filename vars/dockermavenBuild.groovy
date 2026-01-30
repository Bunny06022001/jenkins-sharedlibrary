import com.example.jenkins.MavenBuild
def call(Map config = [:]){
 new MavenBuild(this,config).mavenBuild()
}
