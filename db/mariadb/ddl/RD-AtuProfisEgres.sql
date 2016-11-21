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
create table AREA_CONHECIMENTO
(
IDAREA_CONHECIMENTO integer not null primary key,
NMAREA_CONHECIMENTO character(100),
COD_AREA_CONHECIMENTO numeric(10)
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
IDAREA_CONHECIMENTO integer references AREA_CONHECIMENTO(IDAREA_CONHECIMENTO),
IDORGANIZACAO integer references ORGANIZACAO(IDORGANIZACAO)
);
