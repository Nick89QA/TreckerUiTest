### Описание:

Инструмент, предназначенный для автоматизации UiAutoTestsTracker тестирования для проекта https://hub.crtweb.ru
основанный на фреймворках: TestNG, Selenide(Java/Selenium), BDD Cucumber(Gherkin) и Allure.

### Локальная настройка окружения


1. Необходимо установить Git.
2. Необходимо перейти по ссылке, скачать и установить Amazon Corretto 8
   ```
    https://docs.aws.amazon.com/corretto/latest/corretto-8-ug/downloads-list.html
   ```
    - проверить работу OpenJDK 8:
       ```
       java -version
       ``` 
3. Установить Maven (сборщик зависимостей)
     ```
    brew install maven
    ```
    - проверить работу Maven:
      ```
      mvn -version
      ```  


4. Настроить переменные окружения для Allure (фреймворк для отчетов)
   Вместо userName необходимо указать имя вашего пользователя в системе.
    ```
    cd $home
    nano ~/.bash_profile
    в конец файла добавить:
    PATH=$PATH:C:\Users\user\IdeaProjects\UiAutoTestsTracker\.allure\allure\bin
    ```
5. Необходимо обязательно перезапустить консоль/терминал.
    - проверить работу Allure:
    ```
    allure --version
    ```

### Перед локальным запуском тестов

Перед локальным запуском тестов убедитесь в том что в трекере "Creative Integrator" нет заведенных задач. Потому как может возникнуть конфликт при заведении задач на одни и те же временные промежутки. 

### Локальный запуск тестов

1. Перед запуском локальных тестов обязательно нужно убедиться в наличии установленных последних версий всех необходимых
браузеров для тестирования.


``` 
git clone https://git.crtweb.ru/creative.qa/anarchy/nip/uitestingsampleproject.git
``` 

2. Открыть проект в IDEA перейти в консоль и выполнить команду

```
mvn clean test
```



###### Просмотр Allure отчета

1. Прописать данную команду в терминале IDEA

```
allure serve target/allure-results

```

### Запуск тестов из под Docker


 1. Клонировать себе проект, создать папку на рабочем столе c названием проекта, перейти в нее, открыть правой кнопкой
   мыши "Git Bash Here" и выполнить следующую команду

``` 
git clone https://git.crtweb.ru/creative.qa/anarchy/nip/uitestingsampleproject.git
``` 
2. Для скачивания образа для работы с браузером Google Chrome из "DockerHub" выполните команду


   ``` 
docker run -d -p 4444:4444 --shm-size="2g" selenium/standalone-chrome:4.0.0-rc-2-prerelease-20210908

   ``` 
3. После загрузки контейнера пропишите команду для проверки запущенных контейнеров   
   

``` 
docker ps
``` 

4. Далее выполните команду для запуска тестов

   ``` 
    mvn clean test

   ```


### Запуск по тегам

Для ручного запуска тестов необходимо выполнить команду в корневой папке проекта:

Эта команда запустит все тесты
```
mvn clean test -DcucumberOptions.tags=@test
```



- `@test`  - все тесты
- `@positive`  - позитивные тесты
- `@negative`  - негативные тесты
