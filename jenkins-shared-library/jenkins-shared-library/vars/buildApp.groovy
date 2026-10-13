def call(Map config = [:]) {
    def appName = config.appName ?: 'MyApplication'

    stage('Build Application') {
        echo "Building ${appName}"
        sh 'mvn clean package'
    }
}
