CREATE TABLE localizacao_geografica
(
  cidade varchar(100) not null,
  unidade_federativa varchar(45) not null,
  pais varchar(45) not null,
  latitude float null,
  longitude float null,
  primary key (cidade, unidade_federativa, pais)
);

CREATE TABLE regional_ufg
(
  id int not null,
  nome varchar(100) not null,
  localizacao_geografica_cidade varchar(100) not null,
  localizacao_geografica_unidade_federativa varchar(50) not null,
  localizacao_geografica_pais varchar(100) not null,
  primary key (id),
  constraint fk_regional_localizacao_geografica foreign key (localizacao_geografica_cidade, localizacao_geografica_unidade_federativa, localizacao_geografica_pais) references localizacao_geografica(cidade, unidade_federativa, pais)
);

CREATE TABLE unidade_academica_ufg
(
  id int not null,
  nome varchar(100) not null,
  localizacao_geografica_cidade varchar(100) not null,
  localizacao_geografica_unidade_federativa varchar(50) not null,
  localizacao_geografica_pais varchar(100) not null,
  regional_ufg_id int null,
  primary key (id),
  constraint fk_regional_ufg_id foreign key (regional_ufg_id) references regional_ufg(id),
  constraint fk_unid_localizacao_geografica foreign key (localizacao_geografica_cidade, localizacao_geografica_unidade_federativa, localizacao_geografica_pais) references localizacao_geografica(cidade, unidade_federativa, pais)
);

CREATE TABLE area_conhecimento
(
  nome_area varchar(100) not null,
  codigo_area numeric(10) not null,
  area_conhecimento_nome varchar(100) null,
  area_conhecimento_codigo numeric(10) null,
  primary key (nome_area, codigo_area),
  constraint fk_area_conhecimento foreign key (area_conhecimento_nome, area_conhecimento_codigo) references area_conhecimento(nome_area, codigo_area)
);


CREATE TABLE curso_ufg
(
  nivel varchar(10) not null,
  tipo_resolucao varchar(10) not null,
  numero_resolucao int not null,
  e_presencial boolean not null,
  turno varchar(10) not null,
  unidade_academica_ufg_id int not null,
  area_conhecimento_nome varchar(100) not null,
  area_conhecimento_codigo numeric(10) not null,
  primary key (numero_resolucao),
  constraint fk_unidade_academica foreign key (unidade_academica_ufg_id) references unidade_academica_ufg(id),
  constraint fk_area_conhecimento_curso foreign key (area_conhecimento_nome, area_conhecimento_codigo) references area_conhecimento(nome_area, codigo_area)
);

CREATE TABLE curso_outra_ies
(
  nome_curso varchar(100) not null,
  nivel varchar(10) not null,
  nome_unidade_academica varchar(100) null,
  ies_curso varchar(100) not null,
  tipo_instituicao varchar(10) not null,
  area_conhecimento_nome varchar(100) null,
  area_conhecimento_codigo numeric(10) null,  
  primary key (nome_curso));
/*RD-AtuProfisEgres*/
/*---Tabelas criada somente para execução do script---*/
create table LOCALIZACAO
(
IDLOCALIZACAO integer not null primary key
);
create table EGRESSO
(
IDEGRESSO integer not null primary key
);
/*----------------------------------------------------*/
create table ORGANIZACAO 
(
IDORGANIZACAO integer not null primary key,
RAZAO_SOCIAL character(60) not null,
ENDERECO_COMERCIAL character(200),
NATUREZA smallint not null,--1 = Publica, 2 = Privada, 3 = Trabalho autônomo;
PAGINA_WEB character(100),
IDLOCALIZACAO integer references LOCALIZACAO(IDLOCALIZACAO)
);

create table ATUACAO
(
IDATUACAO integer not null primary key,
DATA_INICIO timestamp not null,
DATA_FIM timestamp,
FORMA_INGRESSO smallint, -- Concurso Público, Seleção Interna, Indicação, Voluntário, Outra;
RENDA_MENSAL_MEDIA float, 
SATISFACAO_RENDA smallint, -- Valor 0 a 10;
PERSPECTIVA_SOBRE_FUTURO_AREA smallint, -- Valor de 0 a 10;
COMENTARIO character(200),
IDEGRESSO integer references EGRESSO(IDEGRESSO),
IDORGANIZACAO integer references ORGANIZACAO(IDORGANIZACAO)
);
