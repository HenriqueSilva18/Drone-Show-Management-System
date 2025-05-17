#!/usr/bin/env bash

echo "📢 make sure JAVA_HOME is set to your JDK folder"
echo "📢 make sure Maven is on the system PATH"

# Executa o Maven com argumentos opcionais (ex: clean)
mvn "$@" dependency:copy-dependencies package
