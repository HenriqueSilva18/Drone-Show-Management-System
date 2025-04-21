REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET BASE_CP=shodrone.app.customer.console\target\shodrone.app.customer.console-1.4.0-SNAPSHOT.jar;shodrone.app.customer.console\target\dependency\*;

REM call the java VM, e.g, 
java -cp %BASE_CP% lapr4.app.customer.console.CustomerApp
