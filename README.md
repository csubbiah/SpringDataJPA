# SpringDataJPA
Explore the concept of SpringDataJPA - usage of JPA within the Spring ecosystem <br/>

Hello World Project of SpringDataJPA. Purely to illustrate the JPA working. Mock not used in this feature explore project.

<b>What is Spring Data JPA ?</b>
Spring Data JPA simplifies the implementation of data access layers using the Java Persistence API (JPA)

<b>Prerequisite</b>
MySQL is installed and Customer database exist in mysql server.
Default tcp port 3306 used to establish connection
Remember to update username and password in application.properties file

<b>Things To Remember</b>
SpringBootTests are in same package as repository
TestLoader with AutoContextAware added to cleanup the db before everyrun for our test - We've to get CustomerRepository Bean prior to test run & cleanup.

Reference:
Baeldung Spring Concepts
