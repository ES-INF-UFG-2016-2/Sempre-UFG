/*--------------------CREATE DA TABELA PARA REQUISITO RD-ConsPredef--------------------------------------------*/
/*-------------------------------------------------------------------------------------------------------------
Observações da tabela:
Table USUARIO e sua primary Key foi criada apenas para esse script funcionar.
Está em SQL puro então roda em MariaDB e Postgree.
-------------------------------------------------------------------------------------------------------------*/
CREATE TABLE USUARIO
(
	ID 	VARCHAR(40)	NOT NULL
);

CREATE TABLE CONSPREDEF
(
	SIGLACONSULTA VARCHAR(100) NOT NULL,		
	VISIBILIDADE NUMERIC(1) NOT NULL,		
	EXPRESSAOBOOLEANA VARCHAR(100) NOT NULL,
	DATAULTIMAMODIFICACAO DATE NOT NULL, 	
	DATAULTIMAEXECUCAO DATE NULL,			
	IDUSUARIORESPONSAVEL VARCHAR(40) NOT NULL
);

/*--------------------CREATE DAS PK - PRIMARY KEY DA TABELA CONSPREDEF----------------------------------------*/
ALTER TABLE CONSPREDEF ADD CONSTRAINT PK_SIGLACONSULTA
	PRIMARY KEY (SIGLACONSULTA);

ALTER TABLE USUARIO ADD CONSTRAINT PK_ID
	PRIMARY KEY (ID);

/*--------------------CREATE DAS FK - FOREIGN KEY DA TABELA CONSPREDEF----------------------------------------*/
ALTER TABLE CONSPREDEF ADD CONSTRAINT FK_IDUSUARIORESPONSAVEL
	FOREIGN KEY (IDUSUARIORESPONSAVEL) REFERENCES USUARIO (ID);

