

-- Table: localizacao_geografica

-- DROP TABLE IF EXISTS localizacao_geografica CASCADE;

CREATE TABLE `localizacao_geografica` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`cidade` VARCHAR(150) NOT NULL,
	`unidade_federativa` VARCHAR(150) NOT NULL,
	`pais` VARCHAR(150) NOT NULL,
	`sigla_unid_federativa` VARCHAR(2) NOT NULL,
	`latitude` FLOAT NULL DEFAULT NULL,
	`longitude` FLOAT NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `cidade` (`cidade`, `unidade_federativa`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;

-- Table: egresso

-- DROP TABLE IF EXISTS egresso CASCADE;

CREATE TABLE `egresso` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`matricula` INT(11) NOT NULL,
	`nome_oficial` VARCHAR(150) NOT NULL,
	`nome_mae` VARCHAR(150) NOT NULL,
	`data_nascimento` DATE NOT NULL,
	`sexo` ENUM('masculino','feminino') NULL DEFAULT NULL,
	`email_alternativo` VARCHAR(150) NULL DEFAULT NULL,
	`foto_principal` VARBINARY(100) NULL DEFAULT NULL,
	`fotos_adicionais` VARBINARY(300) NULL DEFAULT NULL,
	`visibilidade_dados` ENUM('Público','Privado','Só Egressos') NOT NULL,
	`naturalidade` BIGINT(20) NOT NULL,
	PRIMARY KEY (`id`),
	INDEX `fk_localizacao` (`naturalidade`),
	CONSTRAINT `fk_localizacao` FOREIGN KEY (`naturalidade`) REFERENCES `localizacao_geografica` (`id`) ON UPDATE CASCADE
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;

-- Table: residencia

-- DROP TABLE IF EXISTS residencia CASCADE;

CREATE TABLE `residencia` (
	`data_inicio` DATE NOT NULL,
	`data_fim` DATE NULL DEFAULT NULL,
	`endereco` VARCHAR(150) NOT NULL,
	`id_egresso` BIGINT(20) NOT NULL,
	`naturalidade` BIGINT(20) NOT NULL,
	PRIMARY KEY (`data_inicio`),
	UNIQUE INDEX `uq_pk_composta_residencia` (`id_egresso`, `naturalidade`, `data_inicio`),
	INDEX `fk_localizacao_ress` (`naturalidade`),
	CONSTRAINT `fk_egresso` FOREIGN KEY (`id_egresso`) REFERENCES `egresso` (`id`) ON UPDATE CASCADE,
	CONSTRAINT `fk_localizacao_ress` FOREIGN KEY (`naturalidade`) REFERENCES `localizacao_geografica` (`id`) ON UPDATE CASCADE
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;
