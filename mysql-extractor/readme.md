
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
	
## Deploy Without jenkins

	oc project
	mvn  fabric8:deploy -Popenshift	
	
	
	
#MYSQL TIP	

In case of error:  Access denied for user 'root'@'localhost' (using password: YES).
Considering username = mysql

	mysql> ALTER USER 'mysql'@'%' IDENTIFIED BY 'mysql';
	Query OK, 0 rows affected (0.00 sec)
	
	mysql> GRANT ALL PRIVILEGES ON *.* to 'mysql'@'%' WITH GRANT OPTION;
	Query OK, 0 rows affected (0.01 sec)
	
	mysql> FLUSH PRIVILEGES;
	Query OK, 0 rows affected (0.01 sec)
