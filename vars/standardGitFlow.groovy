def call(Map config = [:]) {
    pipeline {
        agent any
        stages {
            stage('Build & Test') {
                steps {
                    echo "Building ${config.appName}..."
                    // Add build commands
                }
            }
            stage('Deploy') {
                when { branch pattern: "develop|main|release/.*", comparator: "REGEXP" }
                steps {
                    // This calls your other library script for the logic
                    gitFlowDeploy(appName: config.appName)
                }
            }
        }
    }
}
