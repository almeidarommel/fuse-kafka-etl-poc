## Project
	
	oc project fuse-etl

## service account
	
	oc policy add-role-to-user admin system:serviceaccount:cicd-tools:jenkins -n fuse-etl
	oc policy add-role-to-user view system:serviceaccount:fuse-etl:postgres-extractor
	oc policy add-role-to-user view system:serviceaccount:fuse-etl:default

## Criar Template
	
	oc create -f ./openshift/postgress-extractor-template.yaml

## Create pipeline. (Jenkins) 
	
	oc project cicd-tools
	oc process --filename=./openshift/pipeline.yaml -p BASE_PROJECT_NAME=fuse-etl -p APP_NAME=postgres-extractor -p PIPELINE_NAME=cicd-tools | oc create -f -
	
## Deploy Without jenkins

	oc project
	mvn  fabric8:deploy -Popenshift


