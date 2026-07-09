#!/bin/bash

/opt/mssql-tols18/bin/sqlcmd -s localhost sa -P "Password12345678" -i
/usr/src/app/schema.sql -C