#!/bin/bash

clear

echo "running makefile\n"

make

echo "\nrunning testfile\n"

./grun antlr.Basic program -gui < testfile.txt
