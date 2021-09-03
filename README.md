### Описание:

Инструмент, предназначенный для автоматизации UiAutoTestsTracker тестирования для проекта https://hub.crtweb.ru основанный на фреймворках: TestNG, Selenide(Java/Selenium), BDD Cucumber(Gherkin) и Allure.

### Локальная настройка окружения

###### Для Mac OS
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

В случае если Allure при запуске выдаёт ошибку `Permission denied` то выполните следующее для файла Allure из папки bin:
    ```
    chmod +x allure
    ```

###### Для Ubuntu (Debian GNU/Linux)
1. Необходимо установить и настроить переменные окружения для OpenJDK 8 (основной стек)
    ```
    sudo apt install openjdk-8-jdk
   ```
   - добавить переменные окружения:
    ```
    export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
    export PATH=$PATH:$JAVA_HOME/bin
    ```
    - проверить работу переменных и OpenJDK 8: 
    ```
    echo $JAVA_HOME
    echo $PATH
    java -version
    ```
2. Установить Maven (сборщик зависимостей)
    ```
    sudo apt install maven
   ```
    - проверить работу Maven: 
    ```
    mvn -version
    ```
    
3. Настроить переменные окружения для Allure (фреймворк для отчетов)
   Вместо userName необходимо указать имя вашего пользователя в системе.
    ```
    cd $HOME
    nano .bashrc
    в конец файла добавить:
    export PATH=$PATH:C:\Users\user\IdeaProjects\UiAutoTestsTracker\.allure\allure\bin
    ```
4. Необходимо обязательно перезапустить консоль/терминал.
    - проверить работу Allure: 
    ```
    allure --version
    ```
###### Для Windows OS
1. Необходимо перейти по ссылке, скачать и установить Git for Windows
    ```
    https://git-scm.com/download/win
   ```
2. Необходимо перейти по ссылке, скачать и установить Amazon Corretto 8
   ```
    https://docs.aws.amazon.com/corretto/latest/corretto-8-ug/downloads-list.html
   ```
   переменные окружения будут настроены автоматически при установке, в случае если этого не произошло, то настроить их можно следующим образом:
   - Кликнуть правой кнопкой мыши на "мой компьютер" ->свойства->дополнительные параметры->переменные среды->системные переменные и далее:
   - Установить переменную `JAVA_HOME` как `C:\Program Files\Amazon Corretto\jdk1.8.0_252` (по умолчанию это путь установки Amazon Corretto 8) 
   - Добавить `%JAVA_HOME%\bin` в текущую переменную `PATH`.
   - проверить работу Amazon Corretto 8: 
   ```
   java -version
   ```
3. Необходимо перейти по ссылке, скачать и распаковать исполняемые файлы Maven в любую папку. Например: `C:\Program Files\apache-maven-3.6.3\`
    ```
    http://maven.apache.org/download.cgi
    ```
    добавить переменную окружения следующим образом:
    - Кликнуть правой кнопкой мыши на "мой компьютер" ->свойства->дополнительные параметры->переменные среды->системные переменные и далее:
    - Установить переменную `M2_HOME` как `C:\Program Files\apache-maven-3.6.3` (по умолчанию это путь распаковки Maven) 
    - Добавить `%M2_HOME%\bin` в текущую переменную `PATH`.
    - проверить работу Maven: 
    ``` 
    mvn -version
    ```
   

### Локальный запуск тестов

Перед запуском локальных тестов обязательно нужно убедиться в наличии установленных последних версий всех необходимых браузеров для тестирования.

###### Mac OS

1. Склонировать себе проект, создать папку на рабочем столе c названием проекта, перейти в нее, открыть правой кнопкой мыши "Git bush here" и выполнить следующую команду
``` 
git clone https://git.crtweb.ru/creative.qa/anarchy/nip/uitestingsampleproject.git
``` 
2. Открыть проект в IDEA перейти в консоль и выполнить команду

```
mvn clean test
```

###### Для Ubuntu (Debian GNU/Linux)

1. Склонировать себе проект, создать папку на рабочем столе c названием проекта, перейти в нее, открыть правой кнопкой мыши "Git bush here" и выполнить следующую команду
``` 
git clone https://git.crtweb.ru/creative.qa/anarchy/nip/uitestingsampleproject.git
``` 
  
2. Открыть проект в IDEA перейти в консоль и выполнить команду

```
mvn clean test
```

###### Для Windows OS

1. Склонировать себе проект, создать папку на рабочем столе c названием проекта, перейти в нее, открыть правой кнопкой мыши "Git Bash Here" и выполнить следующую команду
``` 
git clone https://git.crtweb.ru/creative.qa/anarchy/nip/uitestingsampleproject.git
``` 
2. Открыть проект в IDEA перейти в консоль и выполнить команду

```
mvn clean test
```


###### Запуск тестов на Safari из под Mac OS

Для успешного запуска тестов на Safari, необходимо сначала перейти в сам Safari - Разработка - Разрешить удалённую автоматизацию.


###### Просмотр Allure отчета для Windows OS
1.Прописать данную команду в терминале  IDEA 

```
allure serve target/allure-results

```

### Запуск тестов из под Docker

###### Mac OS

1. Склонировать себе проект, создать папку на рабочем столе c названием проекта, перейти в нее, открыть правой кнопкой мыши "Git Bash Here" и выполнить следующую команду
``` 
git clone https://git.crtweb.ru/creative.qa/anarchy/nip/uitestingsampleproject.git
``` 
 2. Открыть проект в IDEA перейти в консоль и выполнить команду

    ``` 
    docker build -f "имя образа"
    ``` 

    ``` 
    docker run "имя образа" 
    ``` 

###### Для Ubuntu (Debian GNU/Linux)

1. Склонировать себе проект, создать папку на рабочем столе c названием проекта, перейти в нее, открыть правой кнопкой мыши "Git Bash Here" и выполнить следующую команду
``` 
git clone https://git.crtweb.ru/creative.qa/anarchy/nip/uitestingsampleproject.git
``` 
 2. Открыть проект в IDEA перейти в консоль и выполнить команду

    ``` 
    docker build -f "имя образа"
    ``` 

    ``` 
    docker run "имя образа" 
    ```

Если после запуска тестов в SeleniumHub программа выводит ошибку "Не найден SeleniumHub", 
то необходимо заново перезапустить программу и на экране приветствия необходимо включить возможность пересылки пакетов в основной системе, 
для этого необходимо выполнить в отдельном терминале: 

    sudo su
    sysctl net.ipv4.ip_forward=1
    iptables -D ciscovpn  -i cscotun0 -j DROP && iptables -D ciscovpn -o cscotun0 -j DROP
    
После чего продолжить запуск тестов.


###### Для Windows OS

1. Склонировать себе проект, создать папку на рабочем столе c названием проекта, перейти в нее, открыть правой кнопкой мыши "Git Bash Here" и выполнить следующую команду
``` 
git clone https://git.crtweb.ru/creative.qa/anarchy/nip/uitestingsampleproject.git
``` 
 2. Открыть проект в IDEA перейти в консоль и выполнить команду сборки контейнера

    ``` 
    docker build -f "имя образа"
    ``` 
3. Команда запуска контейнера
    ``` 
    docker run "имя образа" 
    ```


