Jenkins_Shared_Libraries:
--------------------------
Go to Jenkins → Manage Jenkins → Configure System → Global Pipeline Libraries
Add or confirm:

    Name: my-shared-lib (can be anything, use same in Jenkinsfile)

    Default version: main or master

    Source Code Management: Git

    Project Repository: URL of your shared library Git repo
    
slack_job:
---------

@Library('my-shared-lib') _

pipeline {
    agent any

    stages {
        stage('Example') {
            steps {
                echo 'Building...'
            }
        }
    }

    post {
        success {
            script {
                sendNotification("SUCCESS")
            }
        }
        failure {
            script {
                sendNotification("FAILED")
            }
        }
    }
}
