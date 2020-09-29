#!/bin/bash

export JENKINS_PROJECT=redhat-sample-cicd-tools
export PROJECT_NAMESPACE=redhat-sample-poc

oc project ${PROJECT_NAMESPACE}
oc policy add-role-to-user admin system:serviceaccount:${JENKINS_PROJECT}:jenkins -n ${PROJECT_NAMESPACE}
oc policy add-role-to-user view system:serviceaccount:${PROJECT_NAMESPACE}:mysql-extractor
oc policy add-role-to-user view system:serviceaccount:${PROJECT_NAMESPACE}:person-transformer
oc policy add-role-to-user view system:serviceaccount:${PROJECT_NAMESPACE}:postgres-extractor
oc policy add-role-to-user view system:serviceaccount:${PROJECT_NAMESPACE}:default

## Criar Template
	
oc create -f ./mysql-extractor/openshift/mysql-extractor-template.yaml
oc create -f ./person-transformer/openshift/person-transformer-template.yaml
oc create -f ./postgres-extractor/openshift/postgress-extractor-template.yaml

## Criar pipeline
	
#oc project ${JENKINS_PROJECT}
#oc process --filename=./mysql-extractor/openshift/pipeline.yaml -p BASE_PROJECT_NAME=${PROJECT_NAMESPACE} -p APP_NAME=mysql-extractor -p PIPELINE_NAME=cicd-tools | oc create -f -
#oc process --filename=./person-transformer/openshift/pipeline.yaml -p BASE_PROJECT_NAME=${PROJECT_NAMESPACE} -p APP_NAME=person-transformer -p PIPELINE_NAME=cicd-tools | oc create -f -
#oc process --filename=./postgres-extractor/openshift/pipeline.yaml -p BASE_PROJECT_NAME=${PROJECT_NAMESPACE} -p APP_NAME=postgres-extractor -p PIPELINE_NAME=cicd-tools | oc create -f -	

	
## Deploy Without jenkins

oc ${PROJECT_NAMESPACE}

cd ./mysql-extractor/
mvn  fabric8:deploy -Popenshift
cd ..

cd ./person-transformer/
mvn  fabric8:deploy -Popenshift
cd ..

cd ./postgres-extractor/
mvn  fabric8:deploy -Popenshift
cd ..
