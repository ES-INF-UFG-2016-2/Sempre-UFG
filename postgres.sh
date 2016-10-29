#!/bin/sh

psql -h localhost -U postgres -a -f create-user-and-db.sql
#cat create-user-and-db.sql | sudo su - postgres -c psql
#TODO: separar no script the gera o banco de dados e no que poula os badados

export PGDATABASE='sempreufg'
export PGUSER='sempreufg'
export PGPASSWORD='sempreufg'

#psql -h localhost -U sempreufg -a -f create-user-and-db.sql

psql -h localhost -a -f db/ddl/CursoOutrasIesEgres.sql
psql -h localhost -a -f db/ddl/ddl_RD-GestImport.sql
psql -h localhost -a -f db/ddl/RD-CursSup-RD-AtuProfisEgres.sql
psql -h localhost -a -f db/ddl/RD-CursSup.sql
psql -h localhost -a -f db/ddl/RD-CursUfgEgres.sql
psql -h localhost -a -f db/ddl/RD-DivulgInfo.sql
psql -h localhost -a -f db/ddl/RD-EnsMedioEgres.sql
psql -h localhost -a -f db/ddl/RD-GestSis.sql
psql -h localhost -a -f db/ddl/RD-GestUsu.sql
psql -h localhost -a -f db/ddl/RD-MetaEgres.sql
psql -h localhost -a -f db/ddl/RD-PessoaEgress.sql
psql -h localhost -a -f db/ddl/RF-MetaEgres.sql
psql -h localhost -a -f db/ddl/VisaoDaDivulgacaoDeInformacoes.sql
psql -h localhost -a -f db/ddl/VisaoEgressoOutrasInstEnsino.sql
