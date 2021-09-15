#!/bin/bash
 echo "Список тегов:

@test - все тесты
@positive - позитивные тесты
"
#read -p "Введите названия тегов: " TAGS
mvn clean test -Dsurefire.suiteXmlFiles=testng.xml -Dcucumber.filter.tags="$TAGS"

 #mvn clean test -DcucumberOptions.tags=@test
