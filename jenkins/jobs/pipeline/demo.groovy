  node {

          git branch: env.GIT_BRANCH,

          credentialsId: 'gitlab_user',

          url: 'https://github.com/prasantkumar-ext/devops.git'


          stage('Build') {

               sh"""
               echo "Hi This is Demo Stage"
               """
	  }

}
