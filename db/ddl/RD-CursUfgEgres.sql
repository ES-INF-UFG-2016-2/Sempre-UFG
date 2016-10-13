CREATE TYPE turno AS ENUM ( 'Matutino', 'Vespertino', 'Integral');
CREATE TYPE nivel AS ENUM ( 'Bacharelado', 'Licenciatura', 'Aperfeicoamento', 'Especializacao', 'Mestrado', 'Doutorado');
CREATE TYPE tipo_resolucao AS ENUM ('CEPEC', 'CONSUNI');
CREATE TYPE motivacao AS ENUM ('Qualidade/Reputacao do Curso', 'Qualidade/Reputacao da IES', 'Gratuidade', 'Outra');
CREATE TYPE tipo_programa_academico AS ENUM ('Iniciacao_Cientifica', 'Monitoria', 'Extensao', 'Intercambio');

CREATE TABLE AREA_DE_CONHECIMENTO
(
NOME   			VARCHAR(300)     		NOT NULL,
CODIGO     			INTEGER	    		PRIMARY KEY  NOT NULL,
SUPER_AREA		INTEGER REFERENCES AREA_DE_CONHECIMENTO (CODIGO)
);

CREATE TABLE CURSO_DA_UFG
(
NIVEL 	 				nivel   				NOT NULL,
TIPO_DE_RESOLUCAO		tipo_resolucao 			NOT NULL,
NUMERO_DA_RESOLUCAO		INTEGER 			PRIMARY KEY NOT NULL,
E_PRESENCIAL 			BOOLEAN 			NOT NULL,
TURNO 				turno 				NOT NULL,
UNIDADE_ACADEMICA 		VARCHAR(200) REFERENCES UNIDADE_ACADEMICA_UFG (NOME) NOT NULL,
AREA_DE_CONHECIMENTO INTEGER REFERENCES AREA_DE_CONHECIMENTO (CODIGO) NOT NULL
);

CREATE TABLE HISTORICO_NA_UFG
(
NUMERO_MATRICULA_CURSO	INTEGER		PRIMARY KEY NOT NULL,
MES_DE_INICIO 			INTEGER		NOT NULL,
ANO_DE_INICIO 			INTEGER		NOT NULL,
MES_DE_FIM 				INTEGER		NOT NULL,
ANO_DE_FIM 				INTEGER		NOT NULL,  
TITULO_DO_TRABALHO_FINAL 	VARCHAR(500),
CURSO INTEGER REFERENCES CURSO_DA_UFG (NUMERO_DA_RESOLUCAO) NOT NULL
);

CREATE TABLE AVALIACAO_DO_CURSO_PELO_EGRESSO
(
HISTORICO INTEGER REFERENCES HISTORICO_NA_UFG (NUMERO_MATRICULA_CURSO) NOT NULL,
DATA_AVALIACAO 						DATE 		NOT NULL,
MOTIVACAO_ESCOLHA					motivacao	NOT NULL,
SATISFACAO_CURSO					INTEGER	NOT NULL,
CHECK (SATISFACAO_CURSO >= 0 AND SATISFACAO_CURSO <=10),
CONCEITO_GLOBAL_CURSO				INTEGER	NOT NULL,
CHECK (CONCEITO_GLOBAL_CURSO >= 0 AND CONCEITO_GLOBAL_CURSO <=10),
PREPARACAO_PARA_MERCADO 				INTEGER	NOT NULL,
CHECK (PREPARACAO_PARA_MERCADO >= 0 AND PREPARACAO_PARA_MERCADO <=10),
MELHORIA_CAPACIDADE_COMUNICACAO 		 INTEGER	NOT NULL,
CHECK (MELHORIA_CAPACIDADE_COMUNICACAO >= 0 AND MELHORIA_CAPACIDADE_COMUNICACAO <=10),
CAPACIDADE_ETICA_RESPONSABILIADE 		 INTEGER 	NOT NULL,
CHECK (CAPACIDADE_ETICA_RESPONSABILIADE >= 0 AND CAPACIDADE_ETICA_RESPONSABILIADE <=10),
CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO 	 INTEGER 	NOT NULL,
CHECK (CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO >= 0 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO <=10),
COMENTARIO 						VARCHAR(300)
);

CREATE TABLE REALIZACAO_DE_PROGRAMA_ACADEMICO
(
HISTORICO INTEGER REFERENCES HISTORICO_NA_UFG (NUMERO_MATRICULA_CURSO) NOT NULL,
TIPO 					tipo_programa_academico 	NOT NULL,
DATA_INICIO 			DATE 				NOT NULL,
DATA_FIM 				DATE 				NOT NULL,
DESCRICAO 				VARCHAR(300) 		NOT NULL
);
