javac game/*.java game/models/*.java game/controllers/*.java game/ui/*.java -cp game/matadorgui-3.1.6.jar
jar cmvf game/META-INF/MANIFEST.MF test.jar game/*
java -jar test.jar
pause