
oc project fuse-etl
oc create -f  ./fuse-kafka-etl-poc/postgres-extractor/openshift/fuse-postgres-extractor.yaml
oc policy add-role-to-user admin system:serviceaccount:cicd-tools:jenkins -n fuse-etl
oc policy add-role-to-user view system:serviceaccount:fuse-etl:postgres-extractor
oc policy add-role-to-user view system:serviceaccount:fuse-etl:default


oc process --filename='/home/rosantos/Documents/notes/daily/pipeline.yaml' -p BASE_PROJECT_NAME=fuse-etl -p APP_NAME=postgres-extractor | oc create -f -
