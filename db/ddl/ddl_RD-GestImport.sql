-- -----------------------------------------------------
-- Sequence: `usuario_id_seq`
-- -----------------------------------------------------

DROP SEQUENCE IF EXISTS usuario_id_seq CASCADE;

CREATE SEQUENCE usuario_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
  ALTER TABLE usuario_id_seq
  OWNER TO postgres;
  COMMENT ON SEQUENCE usuario_id_seq
  IS 'Sequence utilizada para geração de id''s da tabela ''usuario''.'
;


-- -----------------------------------------------------
-- Sequence: `foto_adicional_egresso_id_seq`
-- -----------------------------------------------------

DROP SEQUENCE IF EXISTS foto_adicional_egresso_id_seq CASCADE;

CREATE SEQUENCE foto_adicional_egresso_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
  ALTER TABLE foto_adicional_egresso_id_seq
  OWNER TO postgres;
  COMMENT ON SEQUENCE foto_adicional_egresso_id_seq
  IS 'Sequence utilizada para geração de id''s da tabela ''foto_adicional_egresso''.'
;

-- -----------------------------------------------------
-- Sequence: `processo_importacao_id_seq`
-- -----------------------------------------------------

DROP SEQUENCE IF EXISTS processo_importacao_id_seq CASCADE;

CREATE SEQUENCE processo_importacao_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
  ALTER TABLE processo_importacao_id_seq
  OWNER TO postgres;
  COMMENT ON SEQUENCE processo_importacao_id_seq
  IS 'Sequence utilizada para geração de id''s da tabela ''processo_importacao''.'
;


-- -----------------------------------------------------
-- Sequence: `instancia_administrativa_ufg_id_seq`
-- -----------------------------------------------------

DROP SEQUENCE IF EXISTS instancia_administrativa_ufg_id_seq CASCADE;

CREATE SEQUENCE instancia_administrativa_ufg_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
  ALTER TABLE instancia_administrativa_ufg_id_seq
  OWNER TO postgres;
  COMMENT ON SEQUENCE instancia_administrativa_ufg_id_seq
  IS 'Sequence utilizada para geração de id''s da tabela ''instancia_administrativa_ufg''.'
;


-- -----------------------------------------------------
-- Enums
-- -----------------------------------------------------
DROP TYPE IF EXISTS enum_frequencia_divulgacao CASCADE;
CREATE TYPE enum_frequencia_divulgacao AS ENUM('cada evento', 'diária', 'semanal', 'mensal', 'nao recebe');

DROP TYPE IF EXISTS enum_sexo CASCADE;
CREATE TYPE enum_sexo AS ENUM('masculino','feminino');

DROP TYPE IF EXISTS enum_visibilidade_dados CASCADE;
CREATE TYPE enum_visibilidade_dados AS ENUM('Público', 'Privado', 'Só Egressos');

DROP TYPE IF EXISTS enum_tipo_instancia_administrativa_ufg CASCADE;
CREATE TYPE enum_tipo_instancia_administrativa_ufg AS ENUM('Regional', 'Unidade', 'Curso');


DROP TABLE IF EXISTS egresso_processo_importacao, 
  instancia_administrativa_ufg_processo_importacao, 
  foto_adicional_egresso, 
  egresso, 
  processo_importacao, 
  instancia_administrativa_ufg, 
  usuario;

-- -----------------------------------------------------
-- Table `usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS usuario (
  id INT NOT NULL UNIQUE DEFAULT nextval('usuario_id_seq'::regclass),
  email_principal VARCHAR(150) NOT NULL UNIQUE,
  senha VARCHAR(100) NOT NULL,
  nome_social VARCHAR(100) NOT NULL,
  cpf BIGINT NOT NULL UNIQUE,
  foto_pessoal TEXT NULL,
  recebimento_divulgacao enum_frequencia_divulgacao NOT NULL,
  timestamp_cadastramento TIMESTAMP WITH TIME ZONE NOT NULL,
  timestamp_ultima_atualizacao TIMESTAMP WITH TIME ZONE NULL,
  timestamp_exclusao_logica TIMESTAMP WITH TIME ZONE NULL,
  PRIMARY KEY (id, email_principal, cpf))
;


-- -----------------------------------------------------
-- Table `egresso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS egresso (
  id INT NOT NULL UNIQUE,
  nome_oficial VARCHAR(150) NOT NULL,
  nome_mae VARCHAR(150) NOT NULL,
  data_nascimento TIMESTAMP WITH TIME ZONE NOT NULL,
  sexo enum_sexo NULL,
  email_alternativo VARCHAR(150) NULL,
  foto_principal TEXT NULL,
  visibilidade_dados enum_visibilidade_dados NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_egresso_usuario
    FOREIGN KEY (id)
    REFERENCES usuario (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
;


-- -----------------------------------------------------
-- Table `foto_adicional_egresso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS foto_adicional_egresso (
  id INT NOT NULL UNIQUE DEFAULT nextval('foto_adicional_egresso_id_seq'::regclass),
  id_egresso INT NOT NULL,
  arquivo TEXT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_foto_adicional_egresso_egresso
    FOREIGN KEY (id_egresso)
    REFERENCES egresso (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
;


-- -----------------------------------------------------
-- Table `processo_importacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS processo_importacao (
  id INT NOT NULL UNIQUE DEFAULT nextval('processo_importacao_id_seq'::regclass),
  momento_execucao TIMESTAMP WITH TIME ZONE NOT NULL,
  inicio_periodo TIMESTAMP WITH TIME ZONE NOT NULL,
  fim_periodo TIMESTAMP WITH TIME ZONE NOT NULL,
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
-- Table `egresso_processo_importacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS egresso_processo_importacao (
  id_egresso INT NOT NULL,
  id_processo_importacao INT NOT NULL,
  PRIMARY KEY (id_egresso, id_processo_importacao),
  CONSTRAINT fk_egresso_processo_importacao_egresso
    FOREIGN KEY (id_egresso)
    REFERENCES egresso (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_egresso_processo_importacao_processo_importacao
    FOREIGN KEY (id_processo_importacao)
    REFERENCES processo_importacao (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
;

CREATE INDEX fk_egresso_processo_importacao_processo_importacao1_idx ON egresso_processo_importacao (id_processo_importacao ASC);
CREATE INDEX fk_egresso_processo_importacao_usuario1_idx ON egresso_processo_importacao (id_egresso ASC);


-- -----------------------------------------------------
-- Table `instancia_administrativa_ufg`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS instancia_administrativa_ufg (
  id INT NOT NULL UNIQUE DEFAULT nextval('instancia_administrativa_ufg_id_seq'::regclass),
  sigla_instancia VARCHAR(50) NOT NULL UNIQUE,
  nome VARCHAR(150) NOT NULL,
  tipo enum_tipo_instancia_administrativa_ufg NOT NULL,
  data_criacao TIMESTAMP WITH TIME ZONE NOT NULL,
  data_encerramento TIMESTAMP WITH TIME ZONE NULL,
  email_institucional VARCHAR(150) NOT NULL,
  url_institucional VARCHAR(150) NOT NULL,
  id_responsavel INT NOT NULL,
  PRIMARY KEY (id, sigla_instancia),
  CONSTRAINT instancia_administrativa_ufg_usuario
    FOREIGN KEY (id_responsavel)
    REFERENCES usuario (id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
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

