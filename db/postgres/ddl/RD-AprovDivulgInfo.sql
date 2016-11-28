CREATE TYPE recebe_divulgacao AS ENUM ('CADA EVENTO', 'DIARIA', 'SEMANAL',
'MENSAL', 'NÃO RECEBE');
 
CREATE TYPE nivel AS ENUM ('BACHARELADO', 'LICENCIATURA', 'APERFEIÇOAMENTO',
'ESPECIALIZAÇÃO', 'MESTRADO', 'DOUTORADO');
 
CREATE TYPE tipo_de_resolucao AS ENUM ('CEPEC', 'CONSUN');
 
CREATE TYPE turno AS ENUM ('MATUTINO', 'VESPERTINO', 'INTEGRAL'); 
  
CREATE TABLE USUARIO
(
  EMAIL_PRINCIPAL                                 	          VARCHAR(100) NOT NULL,
  SENHA                             	                          VARCHAR(100)   NOT NULL,
  NOME_SOCIAL                       	                          VARCHAR(100) NOT NULL,
  CPF  	                                           	          INTEGER     	PRIMARY KEY NOT NULL,
  FOTO_PESSOAL                      	              	          BYTEA,
  RECEBE_DIVULGACAO                 	            		  recebe_divulgacao NOT NULL,
  TIMESTAMP_DE_CADASTRAMENTO                  			  TIMESTAMP NOT NULL,
  TIMESTAMP_DE_ULTIMA_ATUALIZACAO          			  TIMESTAMP NOT NULL,
  TIMESTAMP_DE_EXCLUSAO_LOGICA                 			  TIMESTAMP NOT NULL
);
 
CREATE TABLE APROVACAO_DE_DIVULGACAO
(
  DIVULGACAO_APROVADA               	            		  BOOLEAN NOT NULL,
  PARECER_SOBRE_DIVULGACAO          	            		  VARCHAR(100) NOT NULL,
  DATA_APROVACAO_OU_REJEICAO        	            		  DATE NOT NULL
);
 
CREATE TABLE CURSO_DA_UFG
(
  NIVEL             	                                       	  nivel NOT NULL,
  TIPO_DE_RESOLUCAO       		            		  tipo_de_resolucao NOT NULL,
  NUMERO_DA_RESOLUCAO     	        	          	  INTEGER     	PRIMARY KEY NOT NULL,
  PRESENCIAL                    	        	          BOOLEAN NOT NULL,
  TURNO                         		             	  turno NOT NULL
);