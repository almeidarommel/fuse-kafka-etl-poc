
## Project
	
	oc project fuse-etl

## service account
	
	oc policy add-role-to-user admin system:serviceaccount:cicd-tools:jenkins -n fuse-etl
	oc policy add-role-to-user view system:serviceaccount:fuse-etl:mysql-extractor
	oc policy add-role-to-user view system:serviceaccount:fuse-etl:default

## Criar Template
	
	oc create -f ./openshift/mysql-extractor-template.yaml

## Criar pipeline
	
	oc project cicd-tools
	oc process --filename=./openshift/pipeline.yaml -p BASE_PROJECT_NAME=fuse-etl-p APP_NAME=mysql-extractor -p PIPELINE_NAME=cicd-tools | oc create -f -
	