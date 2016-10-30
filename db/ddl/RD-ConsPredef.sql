/*--------------------CREATE DA TABELA PARA REQUISITO RD-ConsPredef--------------------------------------------*/
/*-------------------------------------------------------------------------------------------------------------
Observações da tabela:
É FUNDAMENTAL que a tabela USUARIO já tenha sido criado e sua restrição de PK(ID) definida.
Embora o requisito tenha especificado que precisa do "...histórico de modificações e execuções da consulta",
o diagrama proposto pelo Juliano registra apenas a última data de modificação e execução. A data da última
modificação é nullable porque o usuário pode criar uma consulta e não executá-la.
-------------------------------------------------------------------------------------------------------------*/
CREATE TABLE CONSPREDEF
(
SIGLACONSULTA VARCHAR(100) NOT NULL,		--SIGLA QUE IDENTIFICA A CONSULTA. IDENTIFICADOR DO REGISTRO.
VISIBILIDADE NUMERIC(1) NOT NULL,		--TIPO DE VISIBILIDADE 0 - PÚBLICA, 1 - PRIVADA
EXPRESSAOBOOLEANA VARCHAR(100) NOT NULL, 	--EXPRESSÃO BOOLEANA QUE DETERMINA AS CONDIÇÕES PARA QUE OS DADOS DE UM DETERMINADO EGRESSO APAREÇAM
DATAULTIMAMODIFICACAO DATE NOT NULL, 		--DATA DA ÚLTIMA MODIFICAÇÃO. 
DATAULTIMAEXECUCAO DATE NULL,			--DATA DA ÚLTIMA EXECUÇÃO. 
IDUSUARIORESPONSAVEL VARCHAR(40) NOT NULL	--IDENTIFICADOR DO USUÁRIO RESPONSÁVEL POR CRIAR A CONSULTA
);

/*--------------------CREATE DAS PK - PRIMARY KEY DA TABELA CONSPREDEF----------------------------------------*/
ALTER TABLE CONSPREDEF ADD CONSTRAINT PK_SIGLACONSULTA
	PRIMARY KEY (SIGLACONSULTA);

/*--------------------CREATE DAS FK - FOREIGN KEY DA TABELA CONSPREDEF----------------------------------------*/
ALTER TABLE CONSPREDEF ADD CONSTRAINT FK_IDUSUARIORESPONSAVEL
	FOREIGN KEY (IDUSUARIORESPONSAVEL) REFERENCES USUARIO (ID);

