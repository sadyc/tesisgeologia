cls
set dpro=%cd%
set djav="C:\Program Files\Java\jre1.6.0_20"
set dlib=%dpro%\lib


cd classes

set classpath=.
set classpath=%classpath%;%dlib%\datanucleus-enhancer-2.1.0-release.jar
set classpath=%classpath%;%dlib%\jdo2-api-2.3-eb.jar
set classpath=%classpath%;%dlib%\datanucleus-core-2.2.0-m1.jar
set classpath=%classpath%;%dlib%\log4j-1.2.7.jar
set classpath=%classpath%;%dlib%\asm-3.1.jar
set classpath=%classpath%;%dpro%\classes

rem ejecuta el enhancer de los .class de la persistencia

cd..

%djav%\bin\java -cp %classpath%  -Dlog4j.configuration=file:log4j.properties org.datanucleus.enhancer.DataNucleusEnhancer %dpro%\classes\Domain\*.class


pause

