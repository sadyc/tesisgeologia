DataNucleus Tutorial for JDO using Ant
======================================

1. Set the database configuration in the "datanucleus.properties" file.

2. Copy the required jar files to the folder /lib
   /lib/jdo2-api.jar
   /lib/datanucleus-core.jar
   /lib/datanucleus-rdbms.jar
   /lib/datanucleus-enhancer.jar
   /lib/log4j.jar (version 1.2.*)
   /lib/asm.jar (version 3.0)
   /lib/Your database driver jar file(s).

3. run the commands
   a). "ant compile" - compiles the source code
   b). "ant enhance" - enhances the classes
   c). "ant createschema" - creates the tables in the datastore
   d). "ant runtutorial" - run the tutorial
   e). "ant deleteschema" - deletes the tables in the datastore (if reqd)


(c) Copyright 2008-2010 DataNucleus
