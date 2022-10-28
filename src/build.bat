@echo off
IF NOT EXIST "miniMatador.jar" (
	javac game/*.java game/models/*.java game/controllers/*.java game/ui/*.java -cp game/matadorgui-3.1.6.jar
	jar cmf game/META-INF/MANIFEST.MF miniMatador.jar game/*
)
exit /b