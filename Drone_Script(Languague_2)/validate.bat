@echo off
java -cp "Drone_Script(Languague_2)/target/classes;Drone_Script(Languague_2)/target/dependency/antlr4-runtime-4.13.0.jar" drone_plugin.DroneValidator %*
