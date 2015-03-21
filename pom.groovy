project(modelVersion: '4.0.0') {

    groupId 'com.devskiller.maven'
    artifactId 'sample-groovy-maven'
    version '1.0-SNAPSHOT'

    properties {
        'project.build.sourceEncoding' 'UTF-8'
    }

    dependencies {
        dependency(groupId: 'org.codehaus.groovy', artifactId: 'groovy-all', version: '2.4.2', classifier: 'indy')
        dependency(groupId: 'org.spockframework', artifactId: 'spock-core', version: '1.0-groovy-2.4') {
            exclusions {
                exclusion(groupId: 'org.codehaus.groovy', artifactId: 'groovy-all')
            }
        }
    }

    build {
        plugins {
            plugin(groupId: 'org.codehaus.gmavenplus', artifactId: 'gmavenplus-plugin', version: 1.5) {
                executions {
                    execution {
                        goals {
                            goal 'compile'
                            goal 'testCompile'
                        }
                    }
                }
                configuration {
                    invokeDynamic true
                }
            }
            plugin(artifactId: 'maven-surefire-plugin', version: '2.18.1') {
                configuration {
                    includes {
                        include '**/*Spec.java'
                    }
                }
            }
        }
    }
}