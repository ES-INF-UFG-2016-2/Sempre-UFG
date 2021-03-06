CREATE TYPE VISIBILIDADE AS ENUM('Público', 'Privado', 'Só Egressos');
CREATE TYPE SEXO AS ENUM ('masculino', 'feminino');
CREATE TYPE TIPO_INSTANCIA_ADM AS ENUM ('REGIONAL', 'UNIDADE', 'CURSO');
CREATE TYPE NIVEL_CURSO_UFG AS ENUM ( 'BACHARELADO', 'LICENCIATURA', 'APERFEICOAMENTO', 'ESPECIALIZACAO', 'MESTRADO', 'DOUTORADO');
CREATE TYPE TIPO_RESOLUCAO_CURSO_UFG AS ENUM ('CEPEC', 'CONSUNI');
CREATE TYPE TURNO_CURSO_UFG AS ENUM ('MATUTINO', 'VESPERTINO', 'INTEGRAL');
CREATE TYPE MOTIVACAO_ESCOLHA_CURSO AS ENUM ('Qualidade/Reputacao do Curso', 'Qualidade/Reputacao da IES', 'Gratuidade', 'Outra');
CREATE TYPE TIPO_PROGRAMA_ACADEMICO AS ENUM ('Iniciacao_Cientifica', 'Monitoria', 'Extensao', 'Intercambio');
CREATE TYPE TIPO_INST_ENS_MEDIO AS ENUM ('Federal', 'Estadual', 'Municipal', 'Particular');
CREATE TYPE TIPO_IES AS ENUM ('Federal', 'Estadual', 'Municipal', 'Particular');
CREATE TYPE NATUREZA_ORGANIZACAO AS ENUM ('Público', 'Privado', 'Trabalho autônomo');
CREATE TYPE FORMA_INGRESSO_INSTITUICAO AS ENUM ('Concurso Público', 'Seleção Interna', 'Indicação', 'Voluntário', 'Outra');
CREATE TYPE TIPO_EVENTO AS ENUM ('NOTICIA', 'PALESTRA', 'CURSO', 'OPORTUNIDADE DE EMPREGO', 'DIVERSOS');
CREATE TYPE FORMA_DIVULGACAO AS ENUM ('MENSAGEM', 'NOTICIA', 'AMBOS', 'NENHUMA');
CREATE TYPE ESCOPO_DIVULGACAO AS ENUM ('APENAS EGRESSOS', 'COMUNIDADE', 'FORA DE ESCOPO');
CREATE TYPE FORMA_RECEBIMENTO AS ENUM ('CADA EVENTO', 'DIARIA', 'SEMANAL','MENSAL', 'NÃO RECEBE');
CREATE TYPE ORDENACAO AS ENUM ('Ascendente', 'Descendente', 'Nenhuma');
CREATE TYPE TIPO_PARAMETRO AS ENUM('BACKUP', 'LOG', 'GLOBAL');

DROP TABLE IF EXISTS egresso;
CREATE TABLE egresso
(
   id SERIAL NOT NULL, 
   nome varchar(150) NOT NULL, 
   nome_mae varchar(150) NOT NULL, 
   data_nascimento date NOT NULL, 
   foto_principal bytea, 
   foto_adicionais bytea[], 
   visibilidade VISIBILIDADE NOT NULL,
   sexo SEXO, 
  
   CONSTRAINT pk_egresso PRIMARY KEY (id)
);

DROP TABLE IF EXISTS residencia;
CREATE TABLE residencia
(
  data_inicio date NOT NULL,
  data_fim date,
  endereco varchar(300) NOT NULL,
  
  CONSTRAINT pk_residencia PRIMARY KEY (data_inicio)
);

DROP TABLE IF EXISTS localizacao_geografica;
CREATE TABLE localizacao_geografica
(
	id SERIAL NOT NULL, 		
	nome_cidade varchar(150) NOT NULL,
	nome_unidade_federativa varchar(150) NOT NULL,
	nome_pais varchar(150) NOT NULL,
	sigla varchar(2) NOT NULL,
	latitude real,
	longitude real,

	  
	CONSTRAINT pk_localizacao_geografica PRIMARY KEY (id)
);

DROP TABLE IF EXISTS area_conhecimento;
CREATE TABLE area_conhecimento
(
  nome_area 				 varchar(150) not null,
  codigo_area 				 integer not null,
  area_conhecimento_nome	 varchar(150) null,
  area_conhecimento_codigo	 integer null,
  
  CONSTRAINT pk_area_conhecimento PRIMARY KEY (nome_area, codigo_area),
  CONSTRAINT fk_area_conhecimento foreign key (area_conhecimento_nome, area_conhecimento_codigo) references area_conhecimento(nome_area, codigo_area)
);

DROP TABLE IF EXISTS regional_ufg;
CREATE TABLE regional_ufg
(
  id 										SERIAL NOT NULL,
  nome 										varchar(150) not null,
  id_localizacao_geografica		 			BIGINT NOT NULL,
  
  CONSTRAINT pk_regional_ufg PRIMARY KEY (id),
  CONSTRAINT fk_regional_localizacao_geografica foreign key (id_localizacao_geografica) references localizacao_geografica(id)
);

DROP TABLE IF EXISTS unidade_academica_ufg;
CREATE TABLE unidade_academica_ufg
(
  id 										SERIAL NOT NULL,
  nome 										varchar(150) NOT NULL,
  id_localizacao_geografica		 			BIGINT NOT NULL,
  regional_ufg_id bigint NOT NULL,
  
  CONSTRAINT pk_unidade_acad_ufg PRIMARY KEY (id),
  CONSTRAINT fk_unidade_academica_regional foreign key (regional_ufg_id) references regional_ufg(id),
  CONSTRAINT fk_unidade_academica_localizacao foreign key (id_localizacao_geografica) references localizacao_geografica(id)
);

DROP TABLE IF EXISTS instancia_administrativa_ufg;
CREATE TABLE instancia_administrativa_ufg
(
	sigla_instancia					VARCHAR(10)	NOT NULL,
	nome							VARCHAR(150)	NOT NULL,
	tipo						TIPO_INSTANCIA_ADM NOT NULL,
	data_criacao					DATE NOT NULL,
	data_encerra					DATE,
	email_institucional				VARCHAR(100) NOT NULL,
	url_institucional				VARCHAR(100) NOT NULL,
	
	CONSTRAINT pk_instancia_adm_ufg PRIMARY KEY (sigla_instancia)
);

DROP TABLE IF EXISTS curso_da_ufg;
CREATE TABLE curso_da_ufg
(
	nivel 						NIVEL_CURSO_UFG NOT NULL,
	tipo_de_resolucao 				TIPO_RESOLUCAO_CURSO_UFG NOT NULL,
	numero_da_resolucao 			INTEGER NOT NULL,
	e_presencial 					BOOLEAN NOT NULL,
	turno 							TURNO_CURSO_UFG NOT NULL,
	unidade_academica 				BIGINT NOT NULL,
  area_conhecimento_nome            VARCHAR(150) NOT NULL,
  area_conhecimento_codigo 			INTEGER NOT NULL,
	instancia_administrativa 		VARCHAR(10)	NOT NULL,

    CONSTRAINT pk_curso_ufg PRIMARY KEY (numero_da_resolucao),
    CONSTRAINT fk_unidade_academica foreign key (unidade_academica) references unidade_academica_ufg(ID),
    CONSTRAINT fk_curso_area_conhecimento foreign key (area_conhecimento_nome, area_conhecimento_codigo) references area_conhecimento(nome_area, codigo_area),
    CONSTRAINT fk_curso_instancia_adm foreign key (instancia_administrativa) references instancia_administrativa_ufg(sigla_instancia)
);

DROP TABLE IF EXISTS historico_na_ufg;
CREATE TABLE historico_na_ufg
(
numero_matricula_curso INTEGER PRIMARY KEY NOT NULL,
mes_de_inicio INTEGER NOT NULL,
ano_de_inicio INTEGER NOT NULL,
mes_de_fim INTEGER NOT NULL,
ano_de_fim INTEGER NOT NULL,  
titulo_do_trabalho_final VARCHAR(500),
curso INTEGER REFERENCES CURSO_DA_UFG (NUMERO_DA_RESOLUCAO),
id_egresso BIGINT REFERENCES EGRESSO (ID) 
);

DROP TABLE IF EXISTS avaliacao_do_curso_pelo_egresso;
CREATE TABLE avaliacao_do_curso_pelo_egresso
(
historico INTEGER REFERENCES HISTORICO_NA_UFG (NUMERO_MATRICULA_CURSO),
data_avaliacao DATE NOT NULL,
motivacao_escolha MOTIVACAO_ESCOLHA_CURSO NOT NULL,
satisfacao_curso INTEGER NOT NULL,
	CHECK (SATISFACAO_CURSO >= 0 AND SATISFACAO_CURSO <=10),
conceito_global_curso INTEGER NOT NULL,
	CHECK (CONCEITO_GLOBAL_CURSO >= 0 AND CONCEITO_GLOBAL_CURSO <=10),
preparacao_para_mercado INTEGER NOT NULL,
	CHECK (PREPARACAO_PARA_MERCADO >= 0 AND PREPARACAO_PARA_MERCADO <=10),
melhoria_capacidade_comunicacao INTEGER NOT NULL,
	CHECK (MELHORIA_CAPACIDADE_COMUNICACAO >= 0 AND MELHORIA_CAPACIDADE_COMUNICACAO <=10),
capacidade_etica_responsabiliade INTEGER NOT NULL,
	CHECK (CAPACIDADE_ETICA_RESPONSABILIADE >= 0 AND CAPACIDADE_ETICA_RESPONSABILIADE <=10),
capacidade_habilidades_area_conhecimento INTEGER NOT NULL,
	CHECK (CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO >= 0 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO <=10),
comentario VARCHAR(300)
);

DROP TABLE IF EXISTS realizacao_de_programa_academico;
CREATE TABLE realizacao_de_programa_academico
(
historico INTEGER REFERENCES HISTORICO_NA_UFG (NUMERO_MATRICULA_CURSO),
tipo TIPO_PROGRAMA_ACADEMICO NOT NULL,
data_inicio DATE NOT NULL,
data_fim  DATE NOT NULL,
descricao VARCHAR(300) NOT NULL
);

DROP TABLE IF EXISTS inst_ensino_medio;
CREATE TABLE inst_ensino_medio
(
	id						SERIAL NOT NULL,
	id_localizacao 			BIGINT NOT NULL,
	nome_inst_ensino_medio 	VARCHAR(150) NOT NULL,
	tipo_inst_ensino_medio 	TIPO_INST_ENS_MEDIO NOT NULL,

	CONSTRAINT pk_inst_ens_medio PRIMARY KEY (id),
	CONSTRAINT fk_hist_localizacao FOREIGN KEY (id_localizacao) REFERENCES localizacao_geografica (id) ON DELETE RESTRICT ON UPDATE CASCADE
);

DROP TABLE IF EXISTS historico_ensino_medio;
CREATE TABLE historico_ensino_medio
(
	id					SERIAL NOT NULL,
	id_egresso 				BIGINT 			NOT NULL,
	id_inst_ensino_medio	BIGINT			NOT NULL,
	mes_inicio 				INTEGER 		NOT NULL,
	ano_inicio 				INTEGER 		NOT NULL,
	mes_fim 				INTEGER 		NOT NULL,
	ano_fim 				INTEGER 		NOT NULL,
	
	UNIQUE(id_egresso, id),
	CONSTRAINT pk_hist_ens_medio PRIMARY KEY (id),
	CONSTRAINT fk_hist_ens_medio FOREIGN KEY (id_egresso) REFERENCES egresso (id) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT fk_hist_inst_ens_medio FOREIGN KEY (id_inst_ensino_medio) REFERENCES inst_ensino_medio (id) ON DELETE RESTRICT ON UPDATE CASCADE
);

DROP TABLE IF EXISTS curso_outra_ies;
CREATE TABLE curso_outra_ies
(
	id				SERIAL NOT NULL,
	id_localizacao 			BIGINT 			NOT NULL,
	nome_pt					VARCHAR(150)	NOT NULL,
	nome_original			VARCHAR(150)	NOT NULL,
	codigo					INTEGER			NOT NULL,
	nivel					NIVEL_CURSO_UFG NOT NULL,
	nome_unid_academica_pt 	VARCHAR(150),
	nome_unid_academica_original 	VARCHAR(150),
	nome_ies_pt				VARCHAR(150)	NOT NULL,
	nome_ies_original		VARCHAR(150)	NOT NULL,
	tipo_ies				TIPO_IES NOT NULL,
	url_institucional		VARCHAR(150),
	
	UNIQUE(nome_original, nome_ies_original),
	CONSTRAINT pk_curso_outra_ies PRIMARY KEY (id),
	CONSTRAINT fk_inst_localizacao FOREIGN KEY (id_localizacao) REFERENCES localizacao_geografica (id) ON DELETE RESTRICT ON UPDATE CASCADE
);

DROP TABLE IF EXISTS historico_outra_ies;
CREATE TABLE historico_outra_ies
(
	id				SERIAL NOT NULL,
	id_egresso			BIGINT		NOT NULL,
	id_curso_outra_ies		BIGINT		NOT NULL,
	mes_inicio				INTEGER		NOT NULL,
	ano_inicio				INTEGER		NOT NULL,
	mes_fm					INTEGER		NOT NULL,
	ano_fim					INTEGER		NOT NULL,
	
	UNIQUE(id_egresso, id_curso_outra_ies),
	CONSTRAINT pk_hist_outra_ies PRIMARY KEY (id),
	CONSTRAINT fk_hist_ies FOREIGN KEY (id_egresso) REFERENCES egresso (id) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT fk_hist_outra_ies FOREIGN KEY (id_curso_outra_ies) REFERENCES curso_outra_ies (id) ON DELETE RESTRICT ON UPDATE CASCADE
);

DROP TABLE IF EXISTS organizacao;
CREATE TABLE organizacao 
(
	id 				SERIAL NOT NULL,
	razao_social 			varchar(150) not null,
	endereco_comercial 		varchar(200),
	natureza 			NATUREZA_ORGANIZACAO NOT NULL,
	pagina_web 			varchar(100),
	id_localizacao 			BIGINT NOT NULL,
	
	CONSTRAINT pk_organizacao PRIMARY KEY (id, razao_social),
	CONSTRAINT fk_organizacao_localizacao foreign key (id_localizacao) references localizacao_geografica(id)
);

DROP TABLE IF EXISTS atuacao;
CREATE TABLE atuacao
(
	id 								SERIAL NOT NULL,
	data_inicio 					date NOT NULL, 
	data_fim 						date,
	forma_ingresso 					FORMA_INGRESSO_INSTITUICAO NOT NULL,
	renda_mensal_media 				float, 
	satisfacao_renda 				integer,
	perspectiva_sobre_futuro_area 	integer,
	comentario 						varchar(200),
	id_egresso 						BIGINT,
	id_organizacao 					BIGINT NOT NULL,
	razao_social_organizacao 			varchar(150) NOT NULL,
	
	CONSTRAINT pk_atuacao PRIMARY KEY (id, data_inicio),
	CONSTRAINT fk_atuacao_egresso foreign key (id_egresso) references egresso(id),
	CONSTRAINT fk_atuacao_organizacao foreign key (id_organizacao, razao_social_organizacao) references organizacao(id, razao_social)
);

DROP TABLE IF EXISTS evento;
CREATE TABLE evento
(
	assunto							VARCHAR(100) UNIQUE NOT NULL,
	tipo							TIPO_EVENTO NOT NULL,
	descricao						VARCHAR(500)	NOT NULL,
	data_solicita_divulgacao		DATE	NOT NULL,
	solicitante_divulgacao			VARCHAR(150)	NOT NULL,
	solicitante_email				VARCHAR(100)	NOT NULL,
	forma_divulgacao				FORMA_DIVULGACAO NOT NULL,
	escopo_divulgacao				ESCOPO_DIVULGACAO NOT NULL,
	data_expiracao					DATE,
	
	CONSTRAINT pk_evento PRIMARY KEY (assunto)
);

DROP TABLE IF EXISTS evento_relacionado_a_area;
CREATE TABLE EVENTO_RELACIONADO_A_AREA
(
	evento							VARCHAR(100) NOT NULL,
	nome_area_conhecimento			VARCHAR(150) NOT NULL,
	codigo_area_conhecimento		INTEGER NOT NULL,
	
	CONSTRAINT fk_evento_relacionado_area foreign key (evento) references evento(assunto),
	CONSTRAINT fk_nome_area_conhecimento foreign key (nome_area_conhecimento, codigo_area_conhecimento) references area_conhecimento(nome_area, codigo_area)
);

DROP TABLE IF EXISTS evento_interessa_a_instancia;
CREATE TABLE evento_interessa_a_instancia
(
	evento							VARCHAR(100) NOT NULL,
	instancia_administrativa		VARCHAR(10)	NOT NULL,
	
	CONSTRAINT fk_evento_relacionado_instancia foreign key (evento) references evento(assunto),
	CONSTRAINT fk_evento_instancia_adm foreign key (instancia_administrativa) references instancia_administrativa_ufg(sigla_instancia)
);

DROP TABLE IF EXISTS usuario;
CREATE TABLE usuario
(
	email_principal					VARCHAR(100) NOT NULL,
	senha							VARCHAR(100) NOT NULL,
	nome_social						VARCHAR(150) NOT NULL,
	cpf								BIGINT NOT NULL,
	foto_pessoal					bytea,
	recebe_divulgacao				FORMA_RECEBIMENTO NOT NULL,
	timestamp_de_cadastramento		DATE NOT NULL,
	timestamp_de_ultima_atualizacao	DATE NOT NULL,
	timestamp_de_exclusao_logica	DATE NOT NULL,
	instancia_administrativa		VARCHAR(10)	NOT NULL,
	tipo_divulgacao 				FORMA_RECEBIMENTO NOT NULL,
	
	CONSTRAINT pk_usuario PRIMARY KEY (email_principal, cpf),
	CONSTRAINT fk_usuario_instancia_adm foreign key (instancia_administrativa) references instancia_administrativa_ufg(sigla_instancia)
);

DROP TABLE IF EXISTS aprovacao_de_divulgacao;
CREATE TABLE aprovacao_de_divulgacao
(
	divulgacao_aprovada				BOOLEAN NOT NULL,
	parecer_sobre_divulgacao		VARCHAR(100) NOT NULL,
	data_aprovacao_ou_rejeicao		DATE NOT NULL,
	evento							VARCHAR(100) NOT NULL,
	usuario_email					VARCHAR(100) NOT NULL,
	usuario_cpf						BIGINT NOT NULL,
	
	CONSTRAINT fk_aprovacao_evento foreign key (evento) references evento(assunto),
	CONSTRAINT fk_aprovacao_usuario foreign key (usuario_email, usuario_cpf) references usuario(email_principal, cpf)
);

DROP TABLE IF EXISTS consPredef;
CREATE TABLE consPredef
(
	sigla_consulta 					VARCHAR(100) NOT NULL,		
	visibilidade_publica			BOOLEAN NOT NULL,		
	expressao_booleana 				VARCHAR(100) NOT NULL, 		
	data_ultima_modificao 			DATE, 			
	data_ultima_execucao 			DATE,			
	usuario_responsavel_cpf			BIGINT NOT NULL,
	usuario_responsavel_email		VARCHAR(100) NOT NULL,
	
	CONSTRAINT pk_cons_predef PRIMARY KEY (sigla_consulta),
	CONSTRAINT fk_cons_predef_usuario foreign key (usuario_responsavel_email, usuario_responsavel_cpf) references usuario(email_principal, cpf)
);

DROP TABLE IF EXISTS atributo;
CREATE TABLE atributo
(
	nome_atributo 					VARCHAR(150) NOT NULL,
	identificador_interno 			VARCHAR(100) NOT NULL,
	titulo_da_questao            	VARCHAR(100),
	titulo_do_campo            		VARCHAR(100),
	atributo_sucessor				VARCHAR(150),
	
	CONSTRAINT pk_atributo PRIMARY KEY (nome_atributo),
	CONSTRAINT fk_atributo_atributo foreign key (atributo_sucessor) references atributo(nome_atributo)
);

DROP TABLE IF EXISTS entidade;
CREATE TABLE entidade
(
	nome_entidade 		           	VARCHAR(150) NOT NULL,
	id_interno          	   		VARCHAR(100) NOT NULL,
	titulo_grupo_questoes        	VARCHAR(100),
	titulo_grupo_campos     	  	VARCHAR(100),
	entidade_sucessora				VARCHAR(150),
	atributo						VARCHAR(150),
	
	CONSTRAINT pk_entidade PRIMARY KEY (nome_entidade),
	CONSTRAINT fk_entidade_atributo foreign key (atributo) references atributo(nome_atributo),
	CONSTRAINT fk_entidade_entidade foreign key (entidade_sucessora) references entidade(nome_entidade)
);

DROP TABLE IF EXISTS consulta_mostra_atributo;
CREATE TABLE consulta_mostra_atributo
(
	id								SERIAL NOT NULL, 
	consulta						VARCHAR(100) NOT NULL,
	atributo						VARCHAR(150) NOT NULL,
	posicao							INTEGER,
	ordem							ORDENACAO NOT NULL,
	prioridade_ordenacao			INTEGER,
	
	CONSTRAINT pk_consulta_mostra_atributo PRIMARY KEY (id),
	CONSTRAINT fk_consulta_mostra_atributo_consulta foreign key (consulta) references consPredef(sigla_consulta),
	CONSTRAINT fk_consulta_mostra_atributo_atributo foreign key (atributo) references atributo(nome_atributo)
);

DROP TABLE IF EXISTS atributo_desvia_para_atributo;
CREATE TABLE atributo_desvia_para_atributo
(
	id								SERIAL NOT NULL, 
    atributo_origem					VARCHAR(150) NOT NULL  UNIQUE,
    atributo_destino				VARCHAR(150) NOT NULL,
    valor_atributo_origem			VARCHAR(100) NOT NULL,
	
	CONSTRAINT pk_atributo_desvia_atributo PRIMARY KEY (id),
	CONSTRAINT fk_atributo_desvia_atribuo_origem foreign key (atributo_origem) references atributo(nome_atributo),
	CONSTRAINT fk_atributo_desvia_atribuo_destino foreign key (atributo_destino) references atributo(nome_atributo)
);

DROP TABLE IF EXISTS entidade_agrupa_entidade;
CREATE TABLE entidade_agrupa_entidade
(
	id								SERIAL NOT NULL, 
    entidade_agrupadora				VARCHAR(150) NOT NULL,
    entidade_agrupada				VARCHAR(150) NOT NULL,
	
	CONSTRAINT pk_entidade_agrupa_entidade PRIMARY KEY (id),
    CONSTRAINT fk_entidade_agrupadora_entidade foreign key (entidade_agrupadora) references entidade(nome_entidade),
	CONSTRAINT fk_entidade_agrupada_entidade foreign key (entidade_agrupada) references entidade(nome_entidade)
);

DROP TABLE IF EXISTS processo_importacao;
CREATE TABLE processo_importacao
(
	id 					SERIAL NOT NULL, 
	momento_execucao			DATE NOT NULL,
	inicio_periodo 				DATE NOT NULL,
	fim_periodo 				DATE NOT NULL,
	quantidade_importados_sucesso 		INTEGER NOT NULL,
	qntd_importados_incorretos	 	INTEGER NOT NULL,
	qntd_importados_replicados		INTEGER NOT NULL,
	usuario_email	 			VARCHAR(100) NOT NULL,
	usuario_cpf				BIGINT NOT NULL,

	CONSTRAINT pk_processo_importacao PRIMARY KEY (id, momento_execucao),
	CONSTRAINT fk_processo_importacao_usuario foreign key (usuario_email, usuario_cpf) references usuario(email_principal, cpf)
 );

 DROP TABLE IF EXISTS usuario_processo_importacao;
 CREATE TABLE usuario_processo_importacao
(
	usuario_email	 				VARCHAR(100) NOT NULL,
	usuario_cpf					BIGINT NOT NULL,
	id_processo_importacao			 	BIGINT NOT NULL,
	momento_execucao_processo_import		DATE NOT NULL,

	CONSTRAINT pk_usuario_processo_importacao PRIMARY KEY (usuario_email, usuario_cpf, id_processo_importacao),
	CONSTRAINT fk_usuario_processo_importacao_usuario foreign key (usuario_email, usuario_cpf) references usuario(email_principal, cpf),
	CONSTRAINT fk_usuario_processo_importacao_processo foreign key (id_processo_importacao, momento_execucao_processo_import) references processo_importacao(id, momento_execucao)
);

DROP TABLE IF EXISTS instancia_administrativa_ufg_processo_importacao;
CREATE TABLE instancia_administrativa_ufg_processo_importacao
(
	instancia_administrativa_ufg	VARCHAR(10)	NOT NULL,
	id_processo_importacao			 	BIGINT NOT NULL,
	momento_execucao_processo_import		DATE NOT NULL,

	CONSTRAINT pk_instancia_adm_processo_importacao PRIMARY KEY (instancia_administrativa_ufg, id_processo_importacao),
	CONSTRAINT fk_instancia_adm_importacao_instancia foreign key (instancia_administrativa_ufg) references instancia_administrativa_ufg(sigla_instancia),
	CONSTRAINT fk_instancia_adm_importacao_processo foreign key (id_processo_importacao, momento_execucao_processo_import) references processo_importacao(id, momento_execucao)
);

DROP TABLE IF EXISTS papel;
CREATE TABLE papel
(
	id								SERIAL NOT NULL, 
	sigla_papel	 					VARCHAR(3) NOT NULL,
	nome_papel	 					VARCHAR(20) NOT NULL,

	CONSTRAINT pk_papel PRIMARY KEY (id)
);

DROP TABLE IF EXISTS recurso;
CREATE TABLE recurso 
(
 	id								SERIAL NOT NULL, 
	sigla_recurso				    VARCHAR(2) NOT NULL,
	descricao	 					VARCHAR(400) NOT NULL,

	CONSTRAINT pk_recurso PRIMARY KEY (id)
);

DROP TABLE IF EXISTS usuario_tem_papel;
CREATE TABLE usuario_tem_papel
(
	usuario_email	 				VARCHAR(100) NOT NULL,
	usuario_cpf						BIGINT NOT NULL,
	papel_id		 				BIGINT NOT NULL,

	CONSTRAINT pk_usuario_tem_papel PRIMARY KEY (usuario_email, usuario_cpf, papel_id),
	CONSTRAINT fk_usuario_tem_papel_usuario foreign key (usuario_email, usuario_cpf) references usuario(email_principal, cpf),
	CONSTRAINT fk_usuario_tem_papel_papel foreign key (papel_id) references papel(id)
);

DROP TABLE IF EXISTS papel_tem_recurso;
CREATE TABLE papel_tem_recurso
(
	papel_id		 				BIGINT NOT NULL,
	recurso_id					 	BIGINT NOT NULL,

	CONSTRAINT pk_papel_tem_recurso PRIMARY KEY (papel_id, recurso_id),
	CONSTRAINT fk_papel_tem_recurso_papel foreign key (papel_id) references papel(id),
	CONSTRAINT fk_papel_tem_recurso_recurso foreign key (recurso_id) references recurso(id)
);

DROP TABLE IF EXISTS sempreufg;
CREATE TABLE sempreufg 
(
 	id								SERIAL NOT NULL, 
	nome_sistema	 				VARCHAR(255) NOT NULL,
	timestamp_isstalacao 			DATE NOT NULL,
	usuario_email	 				VARCHAR(100) NOT NULL,
	usuario_cpf						BIGINT NOT NULL,

	CONSTRAINT pk_sempre_ufg PRIMARY KEY (id),
	CONSTRAINT fk_sempreufg_usuario foreign key (usuario_email, usuario_cpf) references usuario(email_principal, cpf)
);

DROP TABLE IF EXISTS parametro;
CREATE TABLE parametro
(
 	id								SERIAL NOT NULL, 
	sigla_parametro		 			VARCHAR(20) NOT NULL,
	nome_sistema 		 			VARCHAR(255) NOT NULL,
	tipo 							TIPO_PARAMETRO NOT NULL,
	descricao_parametro	 			VARCHAR(255) NOT NULL,
	valor 			 				VARCHAR(100) NOT NULL,
	idSempreUFG 					BIGINT NOT NULL,

	CONSTRAINT pk_parametro PRIMARY KEY (id),
	CONSTRAINT fk_parametro_sempreufg foreign key (idSempreUFG) references sempreufg(id)
);

DROP TABLE IF EXISTS backup;
CREATE TABLE backup
(
 	id								SERIAL NOT NULL, 
	usuario_email	 				VARCHAR(100) NOT NULL,
	usuario_cpf						BIGINT NOT NULL,
	timestamp_inicio 				DATE NOT NULL,
	timestamp_fim 					DATE NOT NULL,
	local_de_armazenamento 			VARCHAR(255) NOT NULL,
	timestamp_restauracao 			DATE,

	CONSTRAINT pk_backup PRIMARY KEY (id),
	CONSTRAINT fk_backup_usuario foreign key (usuario_email, usuario_cpf) references usuario(email_principal, cpf)
);

DROP TABLE IF EXISTS restauracao; 
CREATE TABLE restauracao 
(
 	id								SERIAL NOT NULL, 
	backup 							BIGINT NOT NULL,
	usuario_email	 				VARCHAR(100) NOT NULL,
	usuario_cpf						BIGINT NOT NULL,
	timestamp_restauracao 			DATE NOT NULL,
	motivo				 			VARCHAR(255) NOT NULL,

	CONSTRAINT pk_restauracao PRIMARY KEY (id),
	CONSTRAINT fk_restauracao_backup foreign key (backup) references backup(id),
	CONSTRAINT fk_restauracao_usuario foreign key (usuario_email, usuario_cpf) references usuario(email_principal, cpf)
);
