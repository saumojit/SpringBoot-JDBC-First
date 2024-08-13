Starter SpringBoot JDBC App < JDBCApp >	Go to Spring Initializer and add dependcies jdbc api and h2 database
H2 Database : It is an in-memory db -- Required files : schema.sql , data.sql
H2 Database : It internally manages the url and other configurations unlike Postgresql

Postgresql : External DB - Required files : maven dependecy add to pom.xml and application.properties 
For external db , add external db dependency and then change the application.properties for configuration

* As of now , Code supports only one connection to one DB


JDBC Template --> 1. query() <RowMapper> 2.update()

