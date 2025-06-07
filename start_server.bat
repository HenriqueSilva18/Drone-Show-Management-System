@echo off
title Servidor HTTP
echo A iniciar o servidor na porta 8080...
echo.

REM

REM
java -cp "shodrone.app.customer.server\target\classes;shodrone.core\target\shodrone.core-1.4.0-SNAPSHOT.jar" lapr4.CustomerAppServer 8080

echo.
echo O servidor foi terminado.
pause