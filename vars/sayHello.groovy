// vars/gitFlowDeploy.groovy
def call(Map config = [:]) {
    // Determine the environment based on the current branch name
    def targetEnv = ""
    def branch = env.BRANCH_NAME

    if (branch == 'main' || branch == 'master') {
        targetEnv = "production"
    } else if (branch == 'develop') {
        targetEnv = "development"
    } else if (branch.startsWith('release/')) {
        targetEnv = "staging"
    } else {
        echo "Skipping deployment for feature/bugfix branch: ${branch}"
        return
    }

    // Wrap the deployment in a stage
    stage("Deploy to ${targetEnv.capitalize()}") {
        echo "Deploying application: ${config.appName ?: 'Unknown App'}"
        echo "Target Environment: ${targetEnv}"
        
        // Add your actual deployment commands here
        // sh "./deploy.sh --env ${targetEnv}"
    }
}
