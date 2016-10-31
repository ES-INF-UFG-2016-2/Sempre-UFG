﻿CREATE ROLE sempreufg LOGIN
  UNENCRYPTED PASSWORD 'sempreufg'
  SUPERUSER INHERIT CREATEDB CREATEROLE REPLICATION;

CREATE DATABASE sempreufg
  WITH OWNER = sempreufg
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'en_US.UTF-8'
       LC_CTYPE = 'en_US.UTF-8'
       CONNECTION LIMIT = -1;

--TODO: mudar o locale para PT-BR!
