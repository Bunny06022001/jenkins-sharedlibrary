import com.example.jenkins.MavenBuild
def call(Map config = [:]){
 new MavenBuild(config).mavenBuild()
}
