#!/bin/bash

echo "Content-type: text/html"
echo ""

gcc -o map map.c
chmod 777 map
./map

gcc -o calcul calcul.c
chmod 777 calcul
./calcul