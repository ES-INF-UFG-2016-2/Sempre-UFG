DROP TABLE IF EXISTS usuario_processo_importacao, instancia_administrativa_ufg_processo_importacao, processo_importacao, instancia_administrativa_ufg, usuario ;

-- -----------------------------------------------------
-- Table `usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS usuario (
  id INT NOT NULL UNIQUE,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `processo_importacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS processo_importacao (
  id INT NOT NULL UNIQUE,
  momento_execucao DATE NOT NULL,
  inicio_periodo DATE NOT NULL,
  fim_periodo DATE NOT NULL,
  quantidade_importados_sucesso INT NOT NULL,
  quantidade_importados_dados_incorretos INT NOT NULL,
  quantidade_importados_replicados INT NOT NULL,
  id_usuario_autorizador INT NOT NULL,
  PRIMARY KEY (id, momento_execucao)
 ,
  CONSTRAINT fk_processo_importacao_usuario1
    FOREIGN KEY (id_usuario_autorizador)
    REFERENCES usuario (id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
;

CREATE INDEX fk_processo_importacao_usuario1_idx ON processo_importacao (id_usuario_autorizador ASC);


-- -----------------------------------------------------
-- Table `usuario_processo_importacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS usuario_processo_importacao (
  id_egresso INT NOT NULL,
  id_processo_importacao INT NOT NULL,
  PRIMARY KEY (id_egresso, id_processo_importacao),
  CONSTRAINT fk_usuario_processo_importacao_usuario1
    FOREIGN KEY (id_egresso)
    REFERENCES usuario (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_usuario_processo_importacao_processo_importacao1
    FOREIGN KEY (id_processo_importacao)
    REFERENCES processo_importacao (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
;

CREATE INDEX fk_usuario_processo_importacao_processo_importacao1_idx ON usuario_processo_importacao (id_processo_importacao ASC);
CREATE INDEX fk_usuario_processo_importacao_usuario1_idx ON usuario_processo_importacao (id_egresso ASC);


-- -----------------------------------------------------
-- Table `instancia_administrativa_ufg`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS instancia_administrativa_ufg (
  id INT NOT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `instancia_administrativa_ufg_processo_importacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS instancia_administrativa_ufg_processo_importacao (
  id_instancia_administrativa_ufg INT NOT NULL,
  id_processo_importacao INT NOT NULL,
  PRIMARY KEY (id_instancia_administrativa_ufg, id_processo_importacao),
  CONSTRAINT fk_instancia_administrativa_ufg_processo_importacao_insta1
    FOREIGN KEY (id_instancia_administrativa_ufg)
    REFERENCES instancia_administrativa_ufg (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_instancia_administrativa_ufg_processo_importacao_proce1
    FOREIGN KEY (id_processo_importacao)
    REFERENCES processo_importacao (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
;

CREATE INDEX fk_instancia_administrativa_ufg_processo_importacao_pro_idx ON instancia_administrativa_ufg_processo_importacao (id_processo_importacao ASC);
CREATE INDEX fk_instancia_administrativa_ufg_processo_importacao_ins_idx ON instancia_administrativa_ufg_processo_importacao (id_instancia_administrativa_ufg ASC);

