CREATE TABLE Atributo
(
    nome_atributo            VARCHAR(300) NOT NULL  UNIQUE,
    id_interno            VARCHAR(14)  NOT NULL,
    identificador            BIGINT NOT NULL  UNIQUE,
    tipo_questao            VARCHAR(100),
    tipo_campo            VARCHAR(100),
    PRIMARY KEY (identificador)
);


CREATE TABLE Entidade
(
    nome_entidade            VARCHAR(300) NOT NULL  UNIQUE,
    id_interno             VARCHAR(14)  NOT NULL,
    identificador            BIGINT NOT NULL references Atributo,
    tipo_grupo_questoes        VARCHAR(100),
    tipo_grupo_campos        VARCHAR(100)
);

