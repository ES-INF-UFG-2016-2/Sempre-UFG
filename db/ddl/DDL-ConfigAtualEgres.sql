
-- Executar instrucao por vez.


-- Sequence id_entidade


CREATE SEQUENCE id_entidade_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
  ALTER TABLE id_entidade_seq
  OWNER TO postgres;
  COMMENT ON SEQUENCE id_entidade_seq
IS 'Sequence utilizada para geração de id''s da tabela ''entidade''.';

-- tabela entidade


CREATE TABLE entidade
(
  id_entidade integer NOT NULL DEFAULT nextval('id_entidade_seq'::regclass) primary key,
  nome character varying(300) NOT NULL,
  titulo_grupo_questoes character varying(300),
  titulo_grupo_campos  character varying(300),
  antecessor_id integer references entidade(id_entidade)
);

-- Sequence id_atributo




CREATE SEQUENCE id_atributo_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
  ALTER TABLE id_atributo_seq
  OWNER TO postgres;
  COMMENT ON SEQUENCE id_atributo_seq
IS 'Sequence utilizada para geração de id''s da tabela ''atributo''.';




CREATE TABLE atributo
(
  id_atributo integer NOT NULL DEFAULT nextval('id_atributo_seq'::regclass) primary key,
  nome character varying(300) NOT NULL,
  titulo_questao character varying(300),
  titulo_campo  character varying(300),
  antecessor_id integer references atributo(id_atributo),
  entidade_id integer references entidade(id_entidade)
);

