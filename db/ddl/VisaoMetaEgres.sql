CREATE TYPE DIVULGACAO AS ENUM('cada_evento', 'diaria', 'semanal', 'mensal', 'nao_recebe');
CREATE TYPE ORDENACAO AS ENUM('ascendente', 'descendente', 'nenhum');

CREATE TABLE IF NOT EXISTS Usuario
(
	cpf				CHAR(11) NOT NULL UNIQUE,
	nome_social			VARCHAR(100) NOT NULL,	
	email_principal			VARCHAR(100) NOT NULL,
	senha				VARCHAR(100) NOT NULL,
	foto_pessoal			BIT VARYING,
	tipo_divulgacao			DIVULGACAO NOT NULL,
	timestamp_cadastramento		DATE NOT NULL,
	timestamp_ultima_atualizacao	DATE,
	timestamp_exclusao_logica	DATE,
	PRIMARY KEY (cpf)	
);

CREATE TABLE IF NOT EXISTS ConsPredef
(
	sigla_consulta 			VARCHAR(100) NOT NULL,		
	visibilidade_publica		BOOLEAN NOT NULL,		
	expressao_booleana 		VARCHAR(100) NOT NULL, 		
	data_ultima_modificao 		DATE, 			
	data_ultima_execucao 		DATE,			
	usuario_responsavel 		VARCHAR(40) NOT NULL,		
	PRIMARY KEY (sigla_consulta),
	FOREIGN KEY (usuario_responsavel) REFERENCES Usuario(cpf)
);

CREATE TABLE IF NOT EXISTS Atributo
(
	nome_atributo 			VARCHAR(100) NOT NULL  UNIQUE,
	identificador_interno 		VARCHAR(100)  NOT NULL,
	titulo_da_questao            	VARCHAR(100),
	titulo_do_campo            	VARCHAR(100),
	atributo_sucessor		VARCHAR(100),
	PRIMARY KEY (nome_atributo),
	FOREIGN KEY (atributo_sucessor) REFERENCES Atributo(nome_atributo)
);


CREATE TABLE IF NOT EXISTS Entidade
(
	nome_entidade            	VARCHAR(100) NOT NULL  UNIQUE,
	id_interno             		VARCHAR(100)  NOT NULL,
	titulo_grupo_questoes        	VARCHAR(100),
	titulo_grupo_campos       	VARCHAR(100),
	entidade_sucessora		VARCHAR(100),
	atributo_ID			VARCHAR(100),
	PRIMARY KEY (nome_entidade),
	FOREIGN KEY (atributo_ID) REFERENCES Atributo (nome_atributo),
	FOREIGN KEY (entidade_sucessora) REFERENCES Entidade(nome_entidade)
);

CREATE TABLE IF NOT EXISTS Consulta_Mostra_Atributo
(
	identificador			VARCHAR(100) NOT NULL,
	consulta_ID			VARCHAR(100) NOT NULL,
	atributo_ID			VARCHAR(100) NOT NULL,
	posicao				INTEGER,
	ordem				ORDENACAO,
	prioridade_ordenacao		INTEGER,
	PRIMARY KEY (identificador),
	FOREIGN KEY (consulta_ID) REFERENCES ConsPredef (sigla_consulta),
	FOREIGN KEY (atributo_ID) REFERENCES Atributo (nome_atributo)	
);