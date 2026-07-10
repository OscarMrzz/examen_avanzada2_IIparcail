#!/bin/bash

SQLCMD="/opt/mssql-tools18/bin/sqlcmd"
SA_PASSWORD="Password12345678"

echo "Esperando a que SQL Server este listo..."

for i in $(seq 1 60); do
  $SQLCMD -S localhost -U sa -P "$SA_PASSWORD" -C -Q "SELECT 1" &>/dev/null && break
  sleep 2
done

echo "Ejecutando schema.sql..."
$SQLCMD -S localhost -U sa -P "$SA_PASSWORD" -C -i /usr/src/app/schema.sql

echo "Base de datos inicializada correctamente."
