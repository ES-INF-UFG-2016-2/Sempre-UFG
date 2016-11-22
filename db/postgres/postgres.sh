#!/bin/sh
# Script para popular o postgres cm os dados necessarios para rodar os testes

set -e

echo "Exectando em : $(pwd)"

export PGFOLDER='db/postgres'

# Assumindo que já foi executado pelo Travis como um passo base
#psql -h localhost -U postgres -a -f $PGFOLDER/ddl/create-user-and-db.sql

export PGDATABASE='sempreufg'
export PGUSER='sempreufg'
export PGPASSWORD='sempreufg'

# Pull request #50
psql -h localhost -a -f $PGFOLDER/ddl/VisaoDaDivulgacaoDeInformacoes.sql
