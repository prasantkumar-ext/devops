  node {

          git branch: env.GIT_BRANCH,
          credentialsId: 'github',
          url: 'https://github.com/prasantkumar-ext/ng-collector.git'

          stage('Add Job Description') {

              def userEmail = sh(
                            script: 'git log -1 --pretty=format:"UserName: %ae"',
                            returnStdout: true)
                  dp = userEmail + " Branch: ${env.GIT_BRANCH}"
              currentBuild.description = dp
          }

          stage('Gradle Build') {

               sh"""
               rm -rf build && \
               ./build.sh
               """
	      }
}