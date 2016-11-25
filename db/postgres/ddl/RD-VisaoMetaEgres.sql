/* Como existem multiplas versões da tabela usuário (e elas não estão iguais), optei  apenas utilizar o atributo CPF.
	A tabela só será criada se a versão definitiva ainda não tiver sido criada.*/
CREATE TABLE IF NOT EXISTS Usuario
(
	cpf				INTEGER NOT NULL UNIQUE,
	PRIMARY KEY (cpf)	
);


CREATE TABLE IF NOT EXISTS ConsPredef
(
	sigla_consulta 			VARCHAR(100) NOT NULL,		
	visibilidade_publica		BOOLEAN NOT NULL,		
	expressao_booleana 		VARCHAR(100) NOT NULL, 		
	data_ultima_modificao 		DATE, 			
	data_ultima_execucao 		DATE,			
	usuario_responsavel 		INTEGER NOT NULL,		
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
	ordem				VARCHAR(12),
	prioridade_ordenacao		INTEGER,
	PRIMARY KEY (identificador),
	FOREIGN KEY (consulta_ID) REFERENCES ConsPredef (sigla_consulta),
	FOREIGN KEY (atributo_ID) REFERENCES Atributo (nome_atributo)	
);

CREATE TABLE IF NOT EXISTS Atributo_Desvia_Para_Atributo
(
    identificador			VARCHAR(100) NOT NULL UNIQUE,
    atributo_origem			VARCHAR(100) NOT NULL  UNIQUE,
    atributo_destino		VARCHAR(100) NOT NULL,
    valor_atributo_origem	VARCHAR(100) NOT NULL,
    PRIMARY KEY (identificador),
    FOREIGN KEY (atributo_origem) REFERENCES Atributo(nome_atributo),
    FOREIGN KEY (atributo_destino) REFERENCES Atributo(nome_atributo)
);

CREATE TABLE IF NOT EXISTS Entidade_Agrupa_Entidade
(
    identificador			VARCHAR(100) NOT NULL UNIQUE,
    entidade_agrupadora		VARCHAR(100) NOT NULL,
    entidade_agrupada		VARCHAR(100) NOT NULL,
    PRIMARY KEY (identificador),
    FOREIGN KEY (entidade_agrupadora) REFERENCES Entidade (nome_entidade),
    FOREIGN KEY (entidade_agrupada) REFERENCES Entidade (nome_entidade)
);

ALTER TABLE Usuario ADD COLUMN tipo_divulgacao VARCHAR(12) NOT NULL;
ALTER TABLE Usuario ADD CONSTRAINT check_divulgacao CHECK(tipo_divulgacao = 'cada_evento' OR  tipo_divulgacao = 'diaria' OR tipo_divulgacao = 'semanal' OR tipo_divulgacao = 'mensal' OR tipo_divulgacao = 'nao_recebe'); 

ALTER TABLE Consulta_Mostra_Atributo ADD CONSTRAINT check_ordenacao CHECK(ordem = 'ascendente' OR  ordem = 'descendente' OR ordem = 'nenhum'); 
