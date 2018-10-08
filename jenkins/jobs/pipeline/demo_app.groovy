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
                 ./gradlew check && \
                 ./gradlew jacocoTestReport && \
                 ./gradlew sonarqube
               """
          }
          stage('Publish TestReport') {
               junit 'build/test-results/test/*.xml'
               publishHTML([allowMissing: false,
                 alwaysLinkToLastBuild: false,
                 keepAll: false,
                 reportDir: 'build/reports/tests/test/',
                 reportFiles: 'index.html',
                 reportName: 'Coverage Report'])
          }

}
