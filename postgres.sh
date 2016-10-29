#!/bin/sh

#psql -h 127.0.0.1 < create-user-and-db.sql
cat create-user-and-db.sql | sudo su - postgres -c psql

export PGDATABASE='sempreufg'
export PGUSER='sempreufg'
export PGPASSWORD='sempreufg'
