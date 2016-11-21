// CORREÇÃO DO RELACIONAMENTO ENTRE ENTIDADE E ATRIBUTO,
// ALÉM DE CORRIGIR O NOME DAS ENTIDADES PARA QUE O SCRIPT SIRVA NO POSTGRES E NO MARIADB

// TODO Tem que acrescentar a entidade subordinada
// Todo FALTOU ENTIDADE DESVIA_PARA

/* Como existem multiplas versÃµes da tabela usuÃ¡rio (e elas nÃ£o estÃ£o iguais), optei  apenas utilizar o atributo CPF.
	A tabela sÃ³ serÃ¡ criada se a versÃ£o definitiva ainda nÃ£o tiver sido criada.*/
CREATE TABLE IF NOT EXISTS usuario
(
  cpf INTEGER NOT NULL UNIQUE,
  PRIMARY KEY (cpf)
);


CREATE TABLE IF NOT EXISTS cons_pre_def
(
  sigla_consulta        VARCHAR(100) NOT NULL,
  visibilidade_publica  BOOLEAN      NOT NULL,
  expressao_booleana    VARCHAR(100) NOT NULL,
  data_ultima_modificao DATE,
  data_ultima_execucao  DATE,
  usuario_responsavel   INTEGER      NOT NULL,
  PRIMARY KEY (sigla_consulta),
  FOREIGN KEY (usuario_responsavel) REFERENCES usuario (cpf)
);

CREATE TABLE IF NOT EXISTS entidade
(
  nome_entidade         VARCHAR(100) NOT NULL  UNIQUE,
  id_interno            VARCHAR(100) NOT NULL,
  titulo_grupo_questoes VARCHAR(100),
  titulo_grupo_campos   VARCHAR(100),
  entidade_sucessora    VARCHAR(100),
  PRIMARY KEY (nome_entidade),
  FOREIGN KEY (entidade_sucessora) REFERENCES entidade (nome_entidade)
);

CREATE TABLE IF NOT EXISTS atributo
(
  nome_atributo         VARCHAR(100) NOT NULL  UNIQUE,
  identificador_interno VARCHAR(100) NOT NULL,
  titulo_da_questao     VARCHAR(100),
  titulo_do_campo       VARCHAR(100),
  atributo_sucessor     VARCHAR(100),
  nome_entidade         VARCHAR(100) NOT NULL,
  PRIMARY KEY (nome_atributo),
  FOREIGN KEY (nome_entidade) REFERENCES entidade(nome_entidade),
  FOREIGN KEY (atributo_sucessor) REFERENCES atributo (nome_atributo)
);

CREATE TABLE IF NOT EXISTS consulta_mostra_atributo
(
  identificador        VARCHAR(100) NOT NULL,
  consulta_ID          VARCHAR(100) NOT NULL,
  atributo_ID          VARCHAR(100) NOT NULL,
  posicao              INTEGER,
  ordem                VARCHAR(12),
  prioridade_ordenacao INTEGER,
  PRIMARY KEY (identificador),
  FOREIGN KEY (consulta_ID) REFERENCES cons_pre_def (sigla_consulta),
  FOREIGN KEY (atributo_ID) REFERENCES atributo (nome_atributo)
);

ALTER TABLE usuario
  ADD COLUMN tipo_divulgacao VARCHAR(12) NOT NULL;
ALTER TABLE usuario
  ADD CONSTRAINT check_divulgacao CHECK (
  tipo_divulgacao = 'cada_evento' OR tipo_divulgacao = 'diaria' OR tipo_divulgacao = 'semanal' OR
  tipo_divulgacao = 'mensal' OR tipo_divulgacao = 'nao_recebe');

ALTER TABLE consulta_mostra_atributo
  ADD CONSTRAINT check_ordenacao CHECK (ordem = 'ascendente' OR ordem = 'descendente' OR ordem = 'nenhum');
