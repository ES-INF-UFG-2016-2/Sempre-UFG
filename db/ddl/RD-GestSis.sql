/*CREATE TABLE Usuario (
                idUsuario INT AUTO_INCREMENT NOT NULL,
                PRIMARY KEY (idUsuario)
);*/

CREATE TYPE tipo_parametro AS ENUM ('BACKUP', 'LOG', 'GLOBAL');

CREATE TABLE SempreUFG (
                idSempreUFG SERIAL,
                nome_sistema VARCHAR(255) NOT NULL,
                timestamp_isstalacao DATE NOT NULL,
                id_Usuario INT NOT NULL,
                PRIMARY KEY (idSempreUFG)
);


CREATE TABLE Parametro (
                idParametro SERIAL,
                sigla_parametro VARCHAR(20) NOT NULL,
                idSempreUFG VARCHAR(255) NOT NULL,
                tipo tipo_parametro NOT NULL,
                descricao_parametro VARCHAR(255) NOT NULL,
                valor VARCHAR(100) NOT NULL,
                PRIMARY KEY (idParametro, idSempreUFG)
);


CREATE TABLE Backup (
                idBackup SERIAL,
                idUsuario INT NOT NULL,
                timestamp_inicio DATE NOT NULL,
                timestamp_fim DATE NOT NULL,
                local_de_armazenamento VARCHAR(255) NOT NULL,
                timestamp_restauracao DATE,
                PRIMARY KEY (idBackup, idUsuario)
);


CREATE TABLE Restauracao (
                idRestauracao SERIAL,
                idBackup INT NOT NULL,
                idUsuario INT NOT NULL,
                timestamp_restauracao DATE NOT NULL,
                motivo VARCHAR(255) NOT NULL,
                PRIMARY KEY (idRestauracao, idBackup, idUsuario)
);


ALTER TABLE Backup ADD CONSTRAINT usuario_backup_fk
FOREIGN KEY (idUsuario)
REFERENCES Usuario (idUsuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Restauracao ADD CONSTRAINT usuario_restauracao_fk
FOREIGN KEY (idUsuario)
REFERENCES Usuario (idUsuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE SempreUFG ADD CONSTRAINT usuario_sempreufg_fk
FOREIGN KEY (id_Usuario)
REFERENCES Usuario (idUsuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Parametro ADD CONSTRAINT sempreufg_parametro_fk
FOREIGN KEY (idSempreUFG)
REFERENCES SempreUFG (idSempreUFG)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Restauracao ADD CONSTRAINT backup_restauracao_fk
FOREIGN KEY (idBackup, idUsuario)
REFERENCES Backup (idBackup, idUsuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
