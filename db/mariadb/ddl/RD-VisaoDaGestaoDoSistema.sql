CREATE TABLE IF NOT EXISTS EGRESSO
(
id	INT NOT NULL,

PRIMARY KEY (id)
);

/*-----------------------------------------------------
 Table `Usuario`
 -----------------------------------------------------*/
 CREATE TABLE IF NOT EXISTS USUARIO
(
 idUsuario 			INT NOT NULL,
 email_principal 		CHAR(100) NOT NULL,
 senha 				CHAR(32) NOT NULL,
 nome_social 			CHAR(100) NOT NULL,
 CPF 				INT NOT NULL,
 foto_pessoal 			BINARY NULL,
 recebe_divulgacao 		CHAR(2) NOT NULL,
 timestamp_cadastramento	DATE NOT NULL,
 timestamp_ultima_atualizacao 	DATE NULL,
 timestamp_exclusao_logica 	DATE NULL,

 PRIMARY KEY (idUsuario)
);
 
/*-----------------------------------------------------
Table `processo_importacao`
-----------------------------------------------------*/
CREATE TABLE IF NOT EXISTS PROCESSO_IMPORTACAO
(
  id 						INT NOT NULL UNIQUE,
  momento_execucao 				DATE NOT NULL,
  inicio_periodo 				DATE NOT NULL,
  fim_periodo 					DATE NOT NULL,
  quantidade_importados_sucesso 		INT NOT NULL,
  quantidade_importados_dados_incorretos 	INT NOT NULL,
  quantidade_importados_replicados 		INT NOT NULL,
  id_usuario_autorizador 			INT NOT NULL,

  PRIMARY KEY (id, momento_execucao)
 );

/*-----------------------------------------------------
Table `usuario_processo_importacao`
-----------------------------------------------------*/
CREATE TABLE IF NOT EXISTS USUARIO_PROCESSO_IMPORTACAO
(
  id_egresso 			INT NOT NULL,
  id_processo_importacao 	INT NOT NULL,

  PRIMARY KEY (id_egresso, id_processo_importacao)
);

/*-----------------------------------------------------
Table `instancia_administrativa_ufg`
-----------------------------------------------------*/
CREATE TABLE IF NOT EXISTS INSTANCIA_ADMINISTRATIVA_UFG 
(
  id 	INT NOT NULL,

  PRIMARY KEY (id)
);

/*-----------------------------------------------------
Table `instancia_administrativa_ufg_processo_importacao`
-----------------------------------------------------*/
CREATE TABLE IF NOT EXISTS INSTANCIA_ADMINISTRATIVA_UFG_PROCESSO_IMPORTACAO
(
  id_instancia_administrativa_ufg 	INT NOT NULL,
  id_processo_importacao 		INT NOT NULL,

  PRIMARY KEY (id_instancia_administrativa_ufg, id_processo_importacao)
);

/*-----------------------------------------------------
 Table `Papel`
 -----------------------------------------------------*/
 CREATE TABLE IF NOT EXISTS PAPEL
 (
 idPapel	 INT NOT NULL,
 sigla_papel	 CHAR(3) NOT NULL,
 nome_papel	 CHAR(20) NOT NULL,

 PRIMARY KEY (idPapel)
 );

 /*-----------------------------------------------------
 Table `mydb`.`Recurso`
 -----------------------------------------------------*/
 CREATE TABLE IF NOT EXISTS RECURSO 
 (
 idRecurso	 INT NOT NULL,
 sigla_recurso	 CHAR(2) NOT NULL,
 descricao	 VARCHAR(400) NOT NULL,

 PRIMARY KEY (idRecurso)
 );

/*-----------------------------------------------------
Table `mydb`.`Usuario_has_Papel`
-----------------------------------------------------*/
CREATE TABLE IF NOT EXISTS USUARIO_HAS_PAPEL
(
Usuario_idUsuario	 INT NOT NULL,
Papel_idPapel		 INT NOT NULL,

PRIMARY KEY (Usuario_idUsuario, Papel_idPapel)
);
 
/*-----------------------------------------------------
Table `Papel_has_Recurso`
-----------------------------------------------------*/
CREATE TABLE IF NOT EXISTS PAPEL_HAS_RECURSO
(
Papel_idPapel 		INT NOT NULL,
Recurso_idRecurso 	INT NOT NULL,

PRIMARY KEY (Papel_idPapel, Recurso_idRecurso)
);

/*-----------------------------------------------------
 Table `SempreUFG`
 -----------------------------------------------------*/
 CREATE TABLE IF NOT EXISTS SEMPREUFG 
(
idSempreUFG SERIAL,
nome_sistema	 	CHAR(255) NOT NULL,
timestamp_isstalacao 	DATE NOT NULL,
id_Usuario	        INT NOT NULL,

PRIMARY KEY (idSempreUFG)
);

/*-----------------------------------------------------
 Table `Parametro`
 -----------------------------------------------------*/
CREATE TABLE IF NOT EXISTS PARAMETRO 
(
idParametro SERIAL,
sigla_parametro		 CHAR(20) NOT NULL,
nome_sistema 		 CHAR(255) NOT NULL,
tipo ENUM ('BACKUP', 'LOG', 'GLOBAL') NOT NULL,
descricao_parametro	 CHAR(255) NOT NULL,
valor 			 CHAR(100) NOT NULL,
idSempreUFG BIGINT UNSIGNED NOT NULL,

PRIMARY KEY (idParametro, idSempreUFG)
);

/*-----------------------------------------------------
 Table `Backup`
 -----------------------------------------------------*/
CREATE TABLE IF NOT EXISTS BACKUP
(
idBackup SERIAL,
idUsuario 		INT NOT NULL,
timestamp_inicio 	DATE NOT NULL,
timestamp_fim 		DATE NOT NULL,
local_de_armazenamento 	CHAR(255) NOT NULL,
timestamp_restauracao 	DATE,

PRIMARY KEY (idBackup)
);

/*-----------------------------------------------------
 Table `Restauracao`
 -----------------------------------------------------*/
CREATE TABLE IF NOT EXISTS RESTAURACAO 
(
idRestauracao SERIAL,
idBackup 		BIGINT UNSIGNED NOT NULL,
idUsuario 		INT NOT NULL,
timestamp_restauracao 	DATE NOT NULL,
motivo 			CHAR(255) NOT NULL,

PRIMARY KEY (idRestauracao)
);

/*-----------------------------------------------------
			FOREIGN KEYS
 -----------------------------------------------------*/
ALTER TABLE PROCESSO_IMPORTACAO ADD CONSTRAINT fk_processo_importacao_usuario
FOREIGN KEY (id_usuario_autorizador)
REFERENCES USUARIO(idUsuario)
ON DELETE RESTRICT
ON UPDATE CASCADE;

CREATE INDEX fk_processo_importacao_usuario1_idx ON PROCESSO_IMPORTACAO (id_usuario_autorizador ASC);

ALTER TABLE USUARIO_PROCESSO_IMPORTACAO ADD CONSTRAINT fk_usuario_processo_importacao_usuario1
FOREIGN KEY (id_egresso)
REFERENCES USUARIO (idUsuario)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE USUARIO_PROCESSO_IMPORTACAO ADD CONSTRAINT fk_usuario_processo_importacao_processo_importacao1
FOREIGN KEY (id_processo_importacao)
REFERENCES PROCESSO_IMPORTACAO (id)
ON DELETE CASCADE
ON UPDATE CASCADE;

CREATE INDEX fk_usuario_processo_importacao_processo_importacao1_idx ON USUARIO_PROCESSO_IMPORTACAO (id_processo_importacao ASC);
CREATE INDEX fk_usuario_processo_importacao_usuario1_idx ON USUARIO_PROCESSO_IMPORTACAO (id_egresso ASC);

ALTER TABLE INSTANCIA_ADMINISTRATIVA_UFG_PROCESSO_IMPORTACAO ADD CONSTRAINT fk_instancia_administrativa_ufg_processo_importacao_insta1
FOREIGN KEY (id_instancia_administrativa_ufg)
REFERENCES INSTANCIA_ADMINISTRATIVA_UFG (id)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE INSTANCIA_ADMINISTRATIVA_UFG_PROCESSO_IMPORTACAO ADD CONSTRAINT fk_instancia_administrativa_ufg_processo_importacao_proce1
FOREIGN KEY(id_processo_importacao)
REFERENCES PROCESSO_IMPORTACAO(id)
ON DELETE CASCADE
ON UPDATE CASCADE;

CREATE INDEX fk_instancia_administrativa_ufg_processo_importacao_pro_idx ON INSTANCIA_ADMINISTRATIVA_UFG_PROCESSO_IMPORTACAO (id_processo_importacao ASC);
CREATE INDEX fk_instancia_administrativa_ufg_processo_importacao_ins_idx ON INSTANCIA_ADMINISTRATIVA_UFG_PROCESSO_IMPORTACAO (id_instancia_administrativa_ufg ASC);

ALTER TABLE USUARIO_HAS_PAPEL ADD CONSTRAINT fk_Usuario_has_Papel_Usuario1
FOREIGN KEY (Usuario_idUsuario)
REFERENCES USUARIO (idUsuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE USUARIO_HAS_PAPEL ADD CONSTRAINT fk_Usuario_has_Papel_Papel1
FOREIGN KEY (Papel_idPapel)
REFERENCES PAPEL (idPapel)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

CREATE INDEX fk_Usuario_has_Papel_Papel1_idx ON USUARIO_HAS_PAPEL (Papel_idPapel ASC);
CREATE INDEX fk_Usuario_has_Papel_Usuario1_idx ON USUARIO_HAS_PAPEL (Usuario_idUsuario ASC);

ALTER TABLE PAPEL_HAS_RECURSO ADD CONSTRAINT fk_Papel_has_Recurso_Papel1
FOREIGN KEY (Papel_idPapel)
REFERENCES PAPEL (idPapel)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE PAPEL_HAS_RECURSO ADD CONSTRAINT fk_Papel_has_Recurso_Recurso1
FOREIGN KEY (Recurso_idRecurso)
REFERENCES RECURSO (idRecurso)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

CREATE INDEX fk_Papel_has_Recurso_Recurso1_idx ON PAPEL_HAS_RECURSO (Recurso_idRecurso ASC);
CREATE INDEX fk_Papel_has_Recurso_Papel1_idx ON PAPEL_HAS_RECURSO (Papel_idPapel ASC);

ALTER TABLE BACKUP ADD CONSTRAINT fk_usuario_backup
FOREIGN KEY (idUsuario)
REFERENCES USUARIO (idUsuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE SEMPREUFG ADD CONSTRAINT fk_usuario_sempreufg
FOREIGN KEY (id_Usuario)
REFERENCES USUARIO (idUsuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE PARAMETRO ADD CONSTRAINT fk_sempreufg_parametro
FOREIGN KEY (idSempreUFG)
REFERENCES SEMPREUFG (idSempreUFG)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE RESTAURACAO ADD CONSTRAINT fk_backup_restauracao
FOREIGN KEY (idBackup)
REFERENCES BACKUP (idBackup)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE RESTAURACAO ADD CONSTRAINT fk_backup_usuario
FOREIGN KEY (idUsuario)
REFERENCES USUARIO (idUsuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION;




