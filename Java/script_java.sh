#!/bin/bash

echo "Content-type: text/html"
echo ""


javac Main_map.java RandomMap.java MapToFile.java
chmod 777 Main_map.class
chmod 777 RandomMap.class
chmod 777 MapToFile.class


java Main_map


javac Main_calcul.java MaxValue.java MeanValue.java MinValue.java StandardDeviation.java

chmod 777 Main_calcul.class
chmod 777 MaxValue.class
chmod 777 MeanValue.class
chmod 777 MinValue.class
chmod 777 StandardDeviation.class

java Main_calcul