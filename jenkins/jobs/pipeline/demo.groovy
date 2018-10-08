  node {

          git branch: env.GIT_BRANCH,

          credentialsId: 'pk',

          url: 'https://github.com/prasantkumar-ext/devops.git'


          stage('Build') {

               sh"""
               echo "Hi this is demo stage."
               """
	  }

}
