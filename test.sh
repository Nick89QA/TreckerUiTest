#!/bin/bash
 echo "Список тегов:

@test - все тесты
@positive - позитивные тесты
"

mvn clean test -DcucumberOptions.tags=@test
