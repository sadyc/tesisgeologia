cls
set dpro=%cd%
set djav="C:\Program Files\Java\jdk1.6.0_23"
set dlib=%dpro%\lib


cd classes

set classpath=.
set classpath=%classpath%;%dlib%\jdo2-api-2.3-eb.jar
set classpath=%classpath%;%dlib%\datanucleus-core-2.2.0-m1.jar
set classpath=%classpath%;%dlib%\datanucleus-rdbms-2.2.0-m1.jar
set classpath=%classpath%;%dlib%\log4j-1.2.7.jar
set classpath=%classpath%;%dlib%\mysql-connector-java-5.1.12-bin.jar
set classpath=%classpath%;%dlib%\jfreechart-1.0.13.jar
set classpath=%classpath%;%dlib%\jcommon-1.0.16.jar

set classpath=%classpath%;%dpro%\classes

cd..
rem ejecuta 

%djav%\bin\java -cp %classpath%  persistencia.domain.CargaDatosMain

pause

