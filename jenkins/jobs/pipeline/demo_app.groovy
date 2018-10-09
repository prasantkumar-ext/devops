  node {

          git branch: env.GIT_BRANCH,

          credentialsId: 'gitlab_user',

          url: 'https://github.com/prasantkumar-ext/devops.git'


          stage('Gradle Build') {

               sh"""
               ./gradlew clean build --refresh-dependencies
               """
	      }

	      stage('Gradle Test') {
               sh"""
                 ./gradlew check

               """
          }
          stage('Publish TestReport') {
               sh 'echo "Hi This is Demo test Project."'
          }

}
