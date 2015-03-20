project {
    modelVersion '4.0.0'

    groupId 'com.devskiller.maven'
    artifactId 'sample-groovy-maven'
    version '1.0-SNAPSHOT'

    properties {
        'project.build.sourceEncoding'('UTF-8')
    }
    
    dependencies {
        dependency(groupId: 'org.codehaus.groovy', artifactId: 'groovy-all', version: '2.4.2', classifier: 'indy')
    }

    build {
        plugins {
            plugin(groupId: 'org.codehaus.gmavenplus', artifactId: 'gmavenplus-plugin', version: 1.5) {
                executions {
                    execution {
                        goals {
                            goal('compile')
                            goal('testCompile')
                        }
                    }
                }
                configuration {
                    invokeDynamic(true)
                }
            }
        }
    }
}