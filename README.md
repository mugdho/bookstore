# STARTER SCALA - FINATRA -SLICK #

### Introduction ###


----------


This app is a very basic version to get running on the Scala / Finatra / Slick stack. To get the app running simply run ServerMain from the Server.scala file.

### Environment

----------


#### Development
* Java 8
* Scala 2.11

#### Database
* Postgres - > 9.2


### Setup


----------


#### Database setup
* create user bookstore password 'bookstore';
* create database bookstore owner bookstore;
* create table book (id int, name varchar(255), author varchar(255))
* insert into book values (1, 'A Table of Two Cities', 'Charles Dickens');