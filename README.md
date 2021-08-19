# qa-auto-assignment
[![CircleCI](https://circleci.com/gh/getcarlos22/qa-auto-assignment.svg?style=svg)](https://circleci.com/gh/getcarlos22/qa-auto-assignment)

##### About:
REST API-testing in Java for website : http://api.weatherstack.com

The project is built with the following:
* Java 1.8 and above
* Serenity BDD test framework 2.0.76
* REST-assured
* Cucumber
* Maven

##### how to run:
* make sure right versions of Java and Maven are installed
* run maven command : mvn verify
* SerenityBDD reports should  be generated at /target/site/index.html

##### tested on:
* os : windows 10
* Maven 3.6.3

To run specific checks use cucumber tags feature 
```bash
## to run all scenarios
mvn clean verify -Dcucumber.filter.tags="@End2End" 

## to run individual feature based scenarios
mvn clean verify -Dcucumber.filter.tags="@Id=1.1" 
```
