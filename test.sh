#!/bin/bash
 echo "Список тегов:

@test - все тесты
@positive - позитивные тесты
@negative - негативные тесты
"
#read -p "Введите названия тегов: " TAGS
mvn clean test -Dsurefire.suiteXmlFiles=testng.xml -Dcucumber.filter.tags=@negative

mvn allure:serve -Dallure.serve.port=9996 -Dallure.serve.host=0.0.0.0
 #mvn clean test -q -DcucumberOptions.tags=@test

 #mvn clean test -DcucumberOptions.tags=@positive
 #mvn clean test -DcucumberOptions.tags=@negative