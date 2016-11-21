/*==========================================*/
/*	Table: egresso							*/
/*	Data de criação: 12/10/2016				*/
/*==========================================*/

DROP TABLE IF EXISTS egresso;

CREATE TABLE egresso
(
	id_egresso				BIGINT 			NOT NULL PRIMARY KEY AUTO_INCREMENT,
	matricula				INTEGER	    	NOT NULL,
	nome_oficial			VARCHAR(150)	NOT NULL,
	nome_mae				VARCHAR(150)	NOT NULL,
	data_nascimento			DATE			NOT NULL,
	sexo					ENUM ('masculino', 'feminino'),
	email_alternativo		VARCHAR(150),
	foto_principal			BIT(1),
	fotos_adicionais		BIT(5),
	visibilidade_dados		ENUM ('Público', 'Privado', 'Só Egressos')	NOT NULL
);

/*==========================================*/
/*	Table: localizacao_geografica			*/
/*	Data de criação: 12/10/2016				*/
/*==========================================*/

DROP TABLE IF EXISTS localizacao_geografica;

CREATE TABLE localizacao_geografica
(
	id_localizacao_geo		BIGINT 			NOT NULL PRIMARY KEY AUTO_INCREMENT,
	cidade 					VARCHAR(150) 	NOT NULL,
	unidade_federativa 		VARCHAR(150) 	NOT NULL,
	pais 					VARCHAR(150) 	NOT NULL,
	sigla_unid_federativa 	VARCHAR(2)	 	NOT NULL,
	latitude 				FLOAT 			NOT NULL,
	longitude 				FLOAT 			NOT NULL,
	UNIQUE (cidade, unidade_federativa)
);

/*==========================================*/
/*	Table: inst_ensino_medio				*/
/*	Data de criação: 12/10/2016				*/
/*==========================================*/

DROP TABLE IF EXISTS inst_ensino_medio;

CREATE TABLE inst_ensino_medio
(
	id_inst_ensino_medio	BIGINT			NOT NULL PRIMARY KEY AUTO_INCREMENT,
	id_localizacao 			BIGINT 			NOT NULL,
	nome_inst_ensino_medio 	VARCHAR(150) 	NOT NULL,
	tipo_inst_ensino_medio 	ENUM ('Federal', 'Estadual', 'Municipal', 'Particular') NOT NULL,
	CONSTRAINT fk_hist_localizacao FOREIGN KEY (id_localizacao) REFERENCES localizacao_geografica (id_localizacao_geo) ON DELETE RESTRICT ON UPDATE CASCADE
);

/*==========================================*/
/*	Table: historico_ensino_medio			*/
/*	Data de criação: 12/10/2016				*/
/*==========================================*/

DROP TABLE IF EXISTS historico_ensino_medio;

CREATE TABLE historico_ensino_medio
(
	id_hist_ens_medio		BIGINT			NOT NULL PRIMARY KEY AUTO_INCREMENT,
	id_egresso 				BIGINT 			NOT NULL,
	id_inst_ensino_medio	BIGINT			NOT NULL,
	mes_inicio 				INTEGER 		NOT NULL,
	ano_inicio 				INTEGER 		NOT NULL,
	mes_fim 				INTEGER 		NOT NULL,
	ano_fim 				INTEGER 		NOT NULL,
	UNIQUE(id_egresso, id_hist_ens_medio),
	CONSTRAINT fk_hist_ens_medio FOREIGN KEY (id_egresso) REFERENCES egresso (id_egresso) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT fk_hist_inst_ens_medio FOREIGN KEY (id_inst_ensino_medio) REFERENCES inst_ensino_medio (id_inst_ensino_medio) ON DELETE RESTRICT ON UPDATE CASCADE
);

/*==========================================*/
/*	Table: curso_outra_ies					*/
/*	Data de criação: 12/10/2016				*/
/*==========================================*/

DROP TABLE IF EXISTS curso_outra_ies;

CREATE TABLE curso_outra_ies
(
	id_curso_outra_ies		BIGINT			NOT NULL PRIMARY KEY AUTO_INCREMENT,
	id_localizacao 			BIGINT 			NOT NULL,
	nome_pt					VARCHAR(150)	NOT NULL,
	nome_original			VARCHAR(150)	NOT NULL,
	codigo					INTEGER			NOT NULL,
	nivel					ENUM ('Bacharelado', 'Licenciatura', 'Aperfeiçoamento', 'Especialização', 'Mestrado', 'Doutorado')			NOT NULL,
	nome_unid_academica_pt 	VARCHAR(150),
	nome_unid_academica_original 	VARCHAR(150),
	nome_ies_pt				VARCHAR(150)	NOT NULL,
	nome_ies_original		VARCHAR(150)	NOT NULL,
	tipo_ies				ENUM ('Federal', 'Estadual', 'Municipal', 'Particular') NOT NULL,
	url_institucional		VARCHAR(150),
	UNIQUE(nome_original, nome_ies_original),
	CONSTRAINT fk_inst_localizacao FOREIGN KEY (id_localizacao) REFERENCES localizacao_geografica (id_localizacao_geo) ON DELETE RESTRICT ON UPDATE CASCADE
);

/*==========================================*/
/*	Table: historico_outra_ies				*/
/*	Data de criação: 12/10/2016				*/
/*==========================================*/

DROP TABLE IF EXISTS historico_outra_ies;

CREATE TABLE historico_outra_ies
(
	id_historico_outra_ies	BIGINT		NOT NULL PRIMARY KEY AUTO_INCREMENT,
	id_egresso				BIGINT		NOT NULL,
	id_curso_outra_ies		BIGINT		NOT NULL,
	mes_inicio				INTEGER		NOT NULL,
	ano_inicio				INTEGER		NOT NULL,
	mes_fm					INTEGER		NOT NULL,
	ano_fim					INTEGER		NOT NULL,
	UNIQUE(id_egresso, id_curso_outra_ies),
	CONSTRAINT fk_hist_ies FOREIGN KEY (id_egresso) REFERENCES egresso (id_egresso) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT fk_hist_outra_ies FOREIGN KEY (id_curso_outra_ies) REFERENCES curso_outra_ies (id_curso_outra_ies) ON DELETE RESTRICT ON UPDATE CASCADE
);