#!/bin/sh

psql -h localhost -U postgres -a -f db/ddl/create-user-and-db.sql
#cat create-user-and-db.sql | sudo su - postgres -c psql
#TODO: separar no script que gera o banco de dados e no que popula

export PGDATABASE='sempreufg'
export PGUSER='sempreufg'
export PGPASSWORD='sempreufg'
