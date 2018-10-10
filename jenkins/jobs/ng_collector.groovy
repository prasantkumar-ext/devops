pipelineJob('ng-collector') {
  description '''
        <b>This job is managed by the devops in <code>jenkins/jobs/pipeline/ng_collector.groovy</code>, DO NOT MODIFY</b>
    '''
  logRotator 30
  parameters {

    stringParam 'GIT_BRANCH', '*/**', 'OPTIONAL: Branch Name to build the job.'

  triggers {
        githubPush()
    }

  definition {
    cps {
      script(readFileFromWorkspace('jenkins/jobs/pipeline/ng_collector.groovy'))
      sandbox()
    }
  }
}
}
