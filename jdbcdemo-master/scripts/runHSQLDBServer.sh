#!/bin/bash

java -cp ~/TestowanieApJava/jdbcdemo-master/hsqldb.jar org.hsqldb.server.Server --database.0 mem:mydb --dbname.0 workdb
