// vars/buildApp.groovy
def call(String branch, String repoUrl) {
    node {
        stage('Checkout') {
            git branch: branch, url: repoUrl
        }

        stage('Build') {
            sh 'mvn clean package'
        }

        stage('Archive') {
            archiveArtifacts artifacts: '**/target/*.war',
                             fingerprint: true
        }
    }
}
