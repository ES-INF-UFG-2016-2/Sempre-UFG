#!/bin/sh
# Script para popular o mariadb com os dados necessarios para rodar os testes

set -e

echo "Exectando em : $(pwd)"

export MARIAFOLDER='db/mariadb'

# Assumindo que já foi executado pelo Travis como um passo base
# mysql -h localhost -u root < db/mariadb/cria-usuario-e-db.sql

export MYSQL_DATABASE='sempreufg'
export MYSQL_USER='sempreufg'
export MYSQL_PASSWORD='sempreufg'

mysql -B -v -D $MYSQL_DATABASE -u$MYSQL_PASSWORD -p$MYSQL_PASSWORD < $MARIAFOLDER/ddl/RD-TodasVisoesIntegradas.sql
