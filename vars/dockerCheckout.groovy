
import com.example.jenkins.GitService
def call(Map config = [:]){
new GitService(this,config).gitverify()
}
