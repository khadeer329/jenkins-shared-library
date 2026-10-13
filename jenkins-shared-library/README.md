# Jenkins Shared Library

Repository structure:

```text
jenkins-shared-library/
├── vars/
│   └── buildApp.groovy
└── src/
    └── org/
        └── example/
            └── BuildUtils.groovy
```

## Configure in Jenkins

Add this repository under **Manage Jenkins → System → Global Pipeline Libraries**.

- **Name:** `jenkins-shared-library`
- **Default version:** `main`
- **SCM:** Git
- **Repository URL:** your GitHub repository URL

## Use in a Jenkinsfile

```groovy
@Library('jenkins-shared-library') _

pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'YOUR_APPLICATION_REPOSITORY_URL'
            }
        }

        stage('Build') {
            steps {
                buildApp(appName: 'MyApplication')
            }
        }
    }
}
```

Replace `YOUR_APPLICATION_REPOSITORY_URL` with your application's Git URL.
The library step runs `mvn clean package`, so configure Maven in Jenkins or ensure `mvn` is on the agent PATH.
