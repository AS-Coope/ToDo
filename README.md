# ToDo
A Java app that allows the user to create, view, check as complete and delete ToDos from a ToDo List.

## Overview
This project involves Java and PostgreSQL. The user interacts with the Java program and manages their ToDos, while their ToDo data is stored in PostgreSQL on the backend.

## Prerequisites
1. You will need [PostgreSQL JDBC Driver](https://jdbc.postgresql.org/).
2. Create a folder named `lib`, unless already present, in the root directory and store your driver there.

## Usage

**NOTE**:  
1. The classpath separator on Linux is a ":" not ";" (It is ";" for Windows systems). 
2. If you have a different version of the postgresql jar file, type that version instead.

Compile First:
- To compile source files and store them in the bin directory: `javac -d bin -cp "src;lib/postgresql-42.6.0.jar" src/*.java`  

Run:
- To execute the class files use the following command:  
`java -cp "bin;lib/postgresql-42.6.0.jar App`