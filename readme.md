

# fuse-kafka-etl-poc

 1. This proof of concept connects to two databases: (POSTGRES e  MYSQL).	 
 2. Send data to KAFKA BROKER   
 3. Unify the information sent to KAFKA in a  table in MYSQL

## Data Model

### POSTGRES 

    CREATE TABLE public.pessoa (
       id_pessoa integer NULL,
    	nome varchar NULL,
    	cpf varchar NULL,
    	data_criacao timestamp NULL,
    	ultimo_update timestamp NULL
    );

### MYSQL

    CREATE TABLE `pessoa` (
      `id_pessoa` int DEFAULT NULL,
      `nome` varchar(50) DEFAULT NULL,
      `cpf` varchar(11) DEFAULT NULL,
      `telefone` varchar(20) DEFAULT NULL,
      `data_criacao` datetime DEFAULT NULL,  
      `ultimo_update` datetime DEFAULT NULL,
      `data_nascimento` date DEFAULT NULL  
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

    insert into pessoa  (id_pessoa, nome, cpf, telefone, data_criacao, ultimo_update, data_nascimento) values (2,'b','c','4', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_DATE);
    

###  Unified table (MYSQL) 
    CREATE TABLE `person_processed` (
      `id` int NOT NULL AUTO_INCREMENT,
      `id_postgres` int DEFAULT NULL,
      `id_mysql` int DEFAULT NULL,
      `name` varchar(100) DEFAULT NULL,
      `birth_date` date DEFAULT NULL,
      `social_security` varchar(50) DEFAULT NULL,
      `cellphone` varchar(30) DEFAULT NULL,
      `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
      `update_date` datetime DEFAULT CURRENT_TIMESTAMP,
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


## NOTES/TIPS

Access database on OCP locally.

    oc port-forward <POD> <PORT>:<PORT>
    
    EX: 	oc port-forward postgresql-1-wdvnn 5432:5432
    
Create jenkins pipeline 

	oc process --filename='fuse-kafka-etl-poc/pipeline.yaml' -p BASE_PROJECT_NAME=fuse-etl-project -p APP_NAME=postgres-extractor -p PIPELINE_NAME=fuse-person-transformer-pipeline| oc create -f -

To Jenkins pipeline:

	oc policy add-role-to-user admin system:serviceaccount:<JENKINS-PROJECT>:<JENKINS-USER> -n <FUSE PROJECT>
	
To configMaps:

	oc policy add-role-to-user view system:serviceaccount:<FUSE-PROJECT>:default	 

 
Optionnaly, is possible uses fabric8 plugin insted of Jenkins to deploy on Openshift.

	oc project

	cd <MODULE FOLDER>
	
	mvn  fabric8:deploy -Popenshift
 
This project was tested on Openshift and outside (RHEL 7/Fedora 30)
 


