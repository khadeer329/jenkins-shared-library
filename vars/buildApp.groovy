// vars/buildApp.groovy
def call(String branch, String repoUrl) {
    node {
        stage('Checkout') {
            git branch: branch, url: repoUrl
        }

        stage('Build') {
            def mvnHome = tool 'Maven'

            withEnv(["PATH+MAVEN=${mvnHome}/bin"]) {
                sh 'mvn -version'
                sh 'mvn clean package'
            }
        }

        stage('Archive') {
            archiveArtifacts(
                artifacts: '**/target/*.war',
                fingerprint: true
            )
        }
    }
}
