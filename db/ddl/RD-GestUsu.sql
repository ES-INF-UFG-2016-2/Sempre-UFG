
-- -----------------------------------------------------
-- Table `Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Usuario (
  idUsuario INT NOT NULL,
  email_principal CHAR(100) NOT NULL,
  senha CHAR(32) NOT NULL,
  nome_social CHAR(100) NOT NULL,
  CPF INT NOT NULL,
  foto_pessoal BYTEA NULL,
  recebe_divulgacao CHAR(2) NOT NULL,
  timestamp_cadastramento DATE NOT NULL,
  timestamp_ultima_atualizacao DATE NULL,
  timestamp_exclusao_logica DATE NULL,
  PRIMARY KEY (idUsuario))
;


-- -----------------------------------------------------
-- Table `Papel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Papel (
  idPapel INT NOT NULL,
  sigla_papel CHAR(3) NOT NULL,
  nome_papel CHAR(20) NOT NULL,
  PRIMARY KEY (idPapel))
;


-- -----------------------------------------------------
-- Table `mydb`.`Recurso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Recurso (
  idRecurso VARCHAR(45) NOT NULL,
  sigla_recurso CHAR(2) NOT NULL,
  descricao CHAR(400) NOT NULL,
  PRIMARY KEY (idRecurso))
;


-- -----------------------------------------------------
-- Table `mydb`.`Usuario_has_Papel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Usuario_has_Papel (
  Usuario_idUsuario INT NOT NULL,
  Papel_idPapel INT NOT NULL,
  PRIMARY KEY (Usuario_idUsuario, Papel_idPapel)
 ,
  CONSTRAINT fk_Usuario_has_Papel_Usuario1
    FOREIGN KEY (Usuario_idUsuario)
    REFERENCES Usuario (idUsuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Usuario_has_Papel_Papel1
    FOREIGN KEY (Papel_idPapel)
    REFERENCES Papel (idPapel)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

CREATE INDEX fk_Usuario_has_Papel_Papel1_idx ON Usuario_has_Papel (Papel_idPapel ASC);
CREATE INDEX fk_Usuario_has_Papel_Usuario1_idx ON Usuario_has_Papel (Usuario_idUsuario ASC);


-- -----------------------------------------------------
-- Table `Papel_has_Recurso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Papel_has_Recurso (
  Papel_idPapel INT NOT NULL,
  Recurso_idRecurso VARCHAR(45) NOT NULL,
  PRIMARY KEY (Papel_idPapel, Recurso_idRecurso)
 ,
  CONSTRAINT fk_Papel_has_Recurso_Papel1
    FOREIGN KEY (Papel_idPapel)
    REFERENCES Papel (idPapel)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Papel_has_Recurso_Recurso1
    FOREIGN KEY (Recurso_idRecurso)
    REFERENCES Recurso (idRecurso)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

CREATE INDEX fk_Papel_has_Recurso_Recurso1_idx ON Papel_has_Recurso (Recurso_idRecurso ASC);
CREATE INDEX fk_Papel_has_Recurso_Papel1_idx ON Papel_has_Recurso (Papel_idPapel ASC);


