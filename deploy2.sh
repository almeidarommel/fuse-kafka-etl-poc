#!/bin/bash


export JENKINS_PROJECT=redhat-sample-cicd-tools
export PROJECT_NAMESPACE=redhat-sample-poc

oc project ${PROJECT_NAMESPACE}
oc create sa mysql-extractor
oc create sa postgres-extractor
oc create sa person-transformer

oc policy add-role-to-user view system:serviceaccount:${PROJECT_NAMESPACE}:mysql-extractor
oc policy add-role-to-user view system:serviceaccount:${PROJECT_NAMESPACE}:person-transformer
oc policy add-role-to-user view system:serviceaccount:${PROJECT_NAMESPACE}:postgres-extractor
oc policy add-role-to-user view system:serviceaccount:${PROJECT_NAMESPACE}:default

## Deploy Without jenkins

oc project ${PROJECT_NAMESPACE}

cd ./mysql-extractor/
mvn  fabric8:deploy -Popenshift
cd ..

cd ./person-transformer/
#mvn  fabric8:deploy -Popenshift
cd ..

cd ./postgres-extractor/
#mvn  fabric8:deploy -Popenshift
cd ..
