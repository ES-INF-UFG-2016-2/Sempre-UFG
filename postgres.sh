#!/bin/sh

psql -h localhost -U postgres -a -f create-user-and-db.sql
#cat create-user-and-db.sql | sudo su - postgres -c psql

export PGDATABASE='sempreufg'
export PGUSER='sempreufg'
export PGPASSWORD='sempreufg'

psql -h localhost -U sempreufg -a -f create-user-and-db.sql
