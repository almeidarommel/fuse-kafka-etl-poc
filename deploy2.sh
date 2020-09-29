#!/bin/bash

export JENKINS_PROJECT=redhat-sample-cicd-tools
export PROJECT_NAMESPACE=redhat-sample-poc


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
