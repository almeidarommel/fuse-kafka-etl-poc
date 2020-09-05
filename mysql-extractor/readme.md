
oc project fuse-etl
oc create -f  /home/rosantos/workspace-jb421/fuse-etl-poc/postgres-extractor/openshift/fuse-postgres-extractor.yaml
oc policy add-role-to-user admin system:serviceaccount:cicd-tools:jenkins -n fuse-etl
oc policy add-role-to-user view system:serviceaccount:fuse-etl:postgres-extractor
oc policy add-role-to-user view system:serviceaccount:fuse-etl:default


oc process --filename='/home/rosantos/workspace-jb421/fuse-kafka-etl-poc/pipeline.yaml' -p BASE_PROJECT_NAME=fuse-etl -p APP_NAME=postgres-extractor | oc create -f -

oc port-forward postgresql-1-wdvnn 5432:5432


CREATE TABLE public.pessoa (
	nome varchar NULL,
	cpf varchar NULL,
	id_pessoa integer NULL,
	data_criacao timestamp NULL,
	ultimo_update timestamp NULL
);


oc port-forward database-1-9xv8n 15432:5432