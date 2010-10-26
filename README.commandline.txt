DataNucleus Tutorial for JDO at the CommandLine
===============================================
Download the necessary jars and put them into the lib/ directory
You will need :-
datanucleus-core.jar
datanucleus-enhancer.jar
datanucleus-rdbms.jar
asm.jar (3.0)
log4j.jar (1.2.*)
jdo2-api.jar (2.3)
(your-jdbc-driver.jar)


1. Compile the classes (using javac as normal) putting the compiled classes into target/classes


2. Copy datanucleus.properties into target/classes


3. JDO Enhance the classes
on Linux/Unix :
java -cp target/classes:lib/datanucleus-enhancer.jar:lib/jdo2-api.jar:lib/datanucleus-core.jar:lib/log4j.jar:lib/asm.jar
     -Dlog4j.configuration=file:log4j.properties
     org.datanucleus.enhancer.DataNucleusEnhancer
     target/classes/org/datanucleus/samples/jdo/tutorial/*.class

on Windows :
java -cp target\classes;lib\datanucleus-enhancer.jar;lib\jdo2-api.jar;lib\datanucleus-core.jar;lib\log4j.jar;lib\asm.jar
     -Dlog4j.configuration=file:log4j.properties
     org.datanucleus.enhancer.DataNucleusEnhancer
     target\classes\org\datanucleus\samples\jdo\tutorial\*.class


4. Run the tutorial, using a command like this
java -cp lib/jdo2-api.jar:lib/datanucleus-core.jar:lib/datanucleus-rdbms.jar:lib/log4j.jar:lib/(your-jdbc-driver.jar):target/classes/:. org.datanucleus.samples.jdo.tutorial.Main



(c) Copyright 2008-2010 DataNucleus
