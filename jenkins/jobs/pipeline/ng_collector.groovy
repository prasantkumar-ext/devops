  node {

          git branch: env.GIT_BRANCH,

          credentialsId: 'github',

          url: 'https://github.com/prasantkumar-ext/ng-collector.git'

          currentBuild.description = "BranchName: ${env.GIT_BRANCH}"
          stage('Gradle Build') {

               sh"""
               rm -rf build && \
               ./build.sh
               """
	      }

}