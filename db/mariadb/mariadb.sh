#!/bin/sh
# Script para popular o mariadb com os dados necessarios para rodar os testes

set -e

echo "Exectando em : $(pwd)"

export MARIAFOLDER='db/mariadb'
export MYSQL_DATABASE='sempreufg'
export MYSQL_USER='sempreufg'
export MYSQL_PASSWORD='sempreufg'

mysql -h localhost < $MARIAFOLDER/ddl/RD-AtuProfisEgres.sql
