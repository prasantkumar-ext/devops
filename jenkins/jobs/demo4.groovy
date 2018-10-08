pipelineJob('demo_app5') {
  description '''
        <b>This job is managed by the devops in <code>jenkins/jobs/pipeline/demo.groovy</code>, DO NOT MODIFY</b>
    '''
  logRotator 30
  parameters {
    stringParam 'GIT_BRANCH', '$gitlabBranch', 'OPTIONAL: Branch Name to build the job.'

  definition {
    cps {
      script(readFileFromWorkspace('jenkins/jobs/pipeline/demo_app.groovy'))
      sandbox()
    }
  }
}
}
