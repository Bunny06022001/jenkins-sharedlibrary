def call(){
  sh '''
  mvn clean compile
  mvn clean package
  '''
}
