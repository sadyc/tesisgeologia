cls
set dpro=%cd%
set djav="C:\Program Files\Java\jdk1.6.0_23"
set dlib=%dpro%\lib


cd classes

set classpath=.
set classpath=%classpath%;%dlib%\datanucleus-enhancer-2.1.0-release.jar
set classpath=%classpath%;%dlib%\jdo2-api-2.3-eb.jar
set classpath=%classpath%;%dlib%\datanucleus-core-2.2.0-m1.jar
set classpath=%classpath%;%dlib%\log4j-1.2.7.jar
set classpath=%classpath%;%dlib%\asm-3.1.jar
set classpath=%classpath%;%dlib%\jfreechart-1.0.13.jar
set classpath=%classpath%;%dlib%\jcommon-1.0.16.jar
set classpath=%classpath%;%dlib%\ant-1.5.1.jar
set classpath=%classpath%;%dlib%\antlr-2.7.5.jar
set classpath=%classpath%;%dlib%\bsh-2.0b4.jar
set classpath=%classpath%;%dlib%\commons-beanutils-1.7.jar
set classpath=%classpath%;%dlib%\commons-collections-2.1.jar
set classpath=%classpath%;%dlib%\commons-dbcp-1.2.1.jar
set classpath=%classpath%;%dlib%\commons-digester-1.7.jar
set classpath=%classpath%;%dlib%\commons-javaflow-20060411.jar
set classpath=%classpath%;%dlib%\commons-logging-1.0.2.jar
set classpath=%classpath%;%dlib%\commons-logging-api-1.0.2.jar
set classpath=%classpath%;%dlib%\groovy-all-1.0.jar
set classpath=%classpath%;%dlib%\hibernate3.jar
set classpath=%classpath%;%dlib%\hsqldb-1.7.1.jar
set classpath=%classpath%;%dlib%\itext-1.3.1.jar
set classpath=%classpath%;%dlib%\jakarta-bcel-20050813.jar
set classpath=%classpath%;%dlib%\JasperBabylon-1.0.0.jar
set classpath=%classpath%;%dlib%\jasperreports-2.0.1.jar
set classpath=%classpath%;%dlib%\jasperreports-2.0.1-applet.jar
set classpath=%classpath%;%dlib%\jasperreports-2.0.1-javaflow.jar
set classpath=%classpath%;%dlib%\jaxen-1.1.1.jar
set classpath=%classpath%;%dlib%\jcommon-1.0.0.jar
set classpath=%classpath%;%dlib%\jdt-compiler-3.1.1.jar
set classpath=%classpath%;%dlib%\jfreechart-1.0.0.jar
set classpath=%classpath%;%dlib%\jpa.jar
set classpath=%classpath%;%dlib%\jxl-2.6.jar
set classpath=%classpath%;%dlib%\mondrian-2.3.2.8944.jar
set classpath=%classpath%;%dlib%\png-encoder-1.5.jar
set classpath=%classpath%;%dlib%\poi-3.0.1-FINAL-20070705.jar
set classpath=%classpath%;%dlib%\saaj-api-1.3.jar
set classpath=%classpath%;%dlib%\servlet.jar
set classpath=%classpath%;%dlib%\xalan.jar
set classpath=%classpath%;%dlib%\xercesImpl.jar
set classpath=%classpath%;%dlib%\xml-apis.jar
set classpath=%classpath%;%dpro%\classes

rem ejecuta el enhancer de los .class de la persistencia

cd..

%djav%\bin\java -cp %classpath%  -Dlog4j.configuration=file:log4j.properties org.datanucleus.enhancer.DataNucleusEnhancer %dpro%\classes\persistencia\domain\*.class


pause

