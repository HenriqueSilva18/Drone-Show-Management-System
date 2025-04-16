#!/usr/bin/env bash

#REM set the class path,
#REM assumes the build was executed with maven copy-dependencies
export BASE_CP=shodrone.app.customer.console/target/shodrone.app.user.console-1.4.0-SNAPSHOT.jar:shodrone.app.utente.console/target/dependency/*;

#REM call the java VM, e.g,
java -cp $BASE_CP lapr4.app.customer.console.CustomerApp
