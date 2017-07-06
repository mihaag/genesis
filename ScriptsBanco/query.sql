
----- criacao banco ---------------


  Create tablespace GENESIS 
  datafile 'C:\oracle\oraclexe\app\oracle\oradata\XE\GENESIS.dbf' 
  size 100m 
  autoextend on 
  next 100m 
  maxsize 2048m;

Create user GENESIS identified by GENESIS default tablespace GENESIS;
grant connect, resource, create view to AULAJAVA;