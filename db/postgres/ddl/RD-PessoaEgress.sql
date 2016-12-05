DROP TYPE IF EXISTS sexo CASCADE;
DROP TYPE IF EXISTS visibilidade CASCADE;

CREATE TYPE sexo AS ENUM('masculino','feminino');
CREATE TYPE visibilidade AS ENUM('privado','publico','so egressos');

-- Sequence: egresso_id_seq

DROP SEQUENCE IF EXISTS egresso_id_seq CASCADE;

CREATE SEQUENCE egresso_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
  ALTER TABLE egresso_id_seq
  OWNER TO postgres;
  COMMENT ON SEQUENCE egresso_id_seq
  IS 'Sequence utilizada para geração de id''s da tabela ''egresso''.';

-- Sequence: localizacao_geografica_id_seq

DROP SEQUENCE IF EXISTS localizacao_geografica_id_seq CASCADE;

CREATE SEQUENCE localizacao_geografica_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
  ALTER TABLE localizacao_geografica_id_seq
  OWNER TO postgres;
  COMMENT ON SEQUENCE localizacao_geografica_id_seq
  IS 'Sequence utilizada para geração de id''s da tabela ''localizacao_geografica''.';

-- Table: localizacao_geografica

DROP TABLE IF EXISTS localizacao_geografica CASCADE;

CREATE TABLE localizacao_geografica
(
  id integer NOT NULL DEFAULT nextval('localizacao_geografica_id_seq'::regclass),
  nome_cidade character varying(300) NOT NULL,
  nome_unidade_federativa character varying(300) NOT NULL,
  nome_pais character varying(300) NOT NULL,
  sigla character varying(50) NOT NULL,
  latitude real,
  longitude real,
  
  CONSTRAINT pk_localizacao PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE localizacao_geografica
  OWNER TO postgres;

-- Table: egresso

DROP TABLE IF EXISTS egresso CASCADE;

CREATE TABLE egresso
(
  id integer NOT NULL DEFAULT nextval('egresso_id_seq'::regclass),
  nome character varying(300) NOT NULL,
  nome_mae character varying(300) NOT NULL,
  data_nascimento date NOT NULL,
  foto_principal bytea,
  foto_adicionais bytea[],
  visibilidade visibilidade NOT NULL,
  sexo sexo,
  naturalidade integer NOT NULL,
  
  CONSTRAINT pk PRIMARY KEY (id),
  CONSTRAINT fk_localizacao FOREIGN KEY (naturalidade)
      REFERENCES localizacao_geografica (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE RESTRICT
)
WITH (
  OIDS=FALSE
);
ALTER TABLE egresso
  OWNER TO postgres;

-- Index: fk_id_localizacao_idx

-- DROP INDEX fk_id_localizacao_idx;

CREATE INDEX fk_id_localizacao_idx
  ON egresso
  USING btree
  (naturalidade);

-- Table: residencia

DROP TABLE IF EXISTS residencia CASCADE;

CREATE TABLE residencia
(
  data_inicio date NOT NULL,
  data_fim date,
  endereco character varying(300) NOT NULL,
  id_egresso integer NOT NULL,
  naturalidade integer NOT NULL,
   
  CONSTRAINT pk_residencia PRIMARY KEY (data_inicio),
  CONSTRAINT fk_egresso FOREIGN KEY (id_egresso)
      REFERENCES egresso (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT fk_localizacao FOREIGN KEY (naturalidade)
      REFERENCES localizacao_geografica (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT uq_pk_composta_residencia UNIQUE (id_egresso, naturalidade, data_inicio)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE residencia
  OWNER TO postgres;