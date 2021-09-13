# language: ru
@test

Функционал:Creative Integrator

  Контекст:
    Дано Пользователь авторизуется на сайте трекера


# тест проходит корректно
  Сценарий: Пользователь создает задачу с минимальным промежутком времени
    Когда Пользователь создает задачу с параметрами
      | Название         | Создание отчета по автотестам        |
      | Время начала     | 11:00                                |
      | Время конец      | 11:01                                |
      | Проект           | Песок                                |
      | Ссылка на задачу | https://hub.crtweb.ru/tracker        |
      | Описание задачи  | Автотестирование внутреннего трекера |
    Тогда задача создана корректно

# тест проходит корректно
  Сценарий: Пользователь создает задачу с некоррекной URl ссылкой
    Когда Пользователь создает задачу с параметрами
      | Название         | Текст для названия задачи |
      | Время начала     | 09:00                     |
      | Время конец      | 10:00                     |
      | Проект           | Песок                     |
      | Ссылка на задачу | 67868686879789            |
    Тогда пользователь получает уведомление о некорректной ссылке

# тест проходит корректно
  Сценарий: Пользователь создает задачу без выбора проекта
    Когда Пользователь создает задачу с параметрами
      | Название         | Текст для названия задачи            |
      | Время начала     | 09:00                                |
      | Время конец      | 10:00                                |
      | Проект           |                                      |
      | Ссылка на задачу | https://hub.crtweb.ru/tracker        |
      | Описание задачи  | Автотестирование внутреннего трекера |
    Тогда пользователь получает уведомление о необходимости выбора проекта
# Сценарий проходит корректно
  Сценарий: Пользователь просматривает общую информацию о проекте
    Когда Пользователь заходит на страницу с проектами
    Тогда Пользователь может просматривать информацию о проекте

  # Сценарий проходит корректно
  Сценарий: Пользователь создает новый проект с данными
    Когда Пользователь создает новый проект
      | Название проекта      | Разработка планов     |
      | Описание              | Новый план по проекту |
      | Подрядчик/Исполнитель | цукцук                |
    Тогда Пользователь убеждается об успешном создании проекта
     # ТЕСТ проходит корректно
  Сценарий: Авторизация пользователя и создание задачи
    Когда Пользователь создает задачу с параметрами
      | Название         | Текст для названия задачи            |
      | Время начала     | 11:00                                |
      | Время конец      | 13:00                                |
      | Проект           | Песок                                |
      | Ссылка на задачу | https://hub.crtweb.ru/tracker        |
      | Описание задачи  | Автотестирование внутреннего трекера |
    Тогда задача создана корректно
   # ТЕСТ проходит корректно
  Сценарий:  Пользователь ищет сотрудника по фамилии и email
    Когда Пользователь переходит на страницу Пользователи
    Тогда пользователь ищет по параметрам и убеждается в успехе
      | Петрыч        |
      | nip@crtweb.ru |
# ТЕСТ проходит корректно
  Сценарий: Пользователь создает задачу с максимальным промежутком времени
    Когда Пользователь создает задачу с параметрами
      | Название         | Текст для названия задачи            |
      | Время начала     | 09:00                                |
      | Время конец      | 21:00                                |
      | Проект           | Песок                                |
      | Ссылка на задачу | https://hub.crtweb.ru/tracker        |
      | Описание задачи  | Автотестирование внутреннего трекера |
    Тогда задача создана корректно
# ТЕСТ проходит корректно
  Сценарий: Пользователь просматривает информацию о своем проекте
    Когда Пользователь заходит на страницу с проектами
    Тогда Пользователь может просматривать информацию о проекте
# ТЕСТ проходит корректно
  Сценарий: Пользователь просматривает информацию о подрядчиках
    Когда Пользователь заходит на страницу с подрядчиками
    Тогда Пользователь убеждается о доступности подрядчиков на странице
    # ТЕСТ проходит корректно
  Сценарий: Пользователь просматривает детальную отчетность за прошлый месяц
    Когда Пользователь заходит на страницу отчетности
    Тогда Пользователь убеждается о доступности отчетности за прошлый месяц
     # ТЕСТ проходит корректно
  Сценарий: Пользователь добавляет свой проект в архив
    Когда Пользователь добавляет свой проект в архив
    Тогда Пользователь убеждается об успешном добавлении проекта в архив
   # ТЕСТ проходит корректно
  Сценарий: Пользователь создает подряд
    Когда Пользователь создает подряд на странице с подрядами
      | Полное название   | Разработка планов      |
      | Короткое название | Новый план по проектув |
    Тогда пользователь видит созданный подряд в списке подрядчиков

 # ТЕСТ проходит корректно
  Сценарий: Пользователь добавляет задачу в трекер задним числом
    Когда Пользователь создает задачу используя прошлый временной промежуток
      | Название         | Текст для названия задачи            |
      | Время начала     | 09:00                                |
      | Время конец      | 10:00                                |
      | Проект           | Песок                                |
      | Ссылка на задачу | https://hub.crtweb.ru/tracker        |
      | Описание задачи  | Автотестирование внутреннего трекера |
    Тогда Пользователь убеждается об успешном создании задач
    # ТЕСТ проходит корректно
  Сценарий: Пользователь ищет свою фамилию на странице пользователя
    Когда Пользователь заходит на страницу Пользователя и ищет свою фамилию
      | Фамилия | Абдуллаев |
    Тогда Пользователь убеждается об успешном нахождении данной фамилии
    # тест проходит корректно
    # Пользователь в роли менеджера, может один раз добавить к себе на проект пользователя(удалить не может)Нужна роль администратора.
  Сценарий: Пользователь добавляет менеджера в свой проект
    Когда Пользователь заходит в свой проект и добавляет туда менеджера
      | Добавление пользователей | Икрин Дмитрий |
    Тогда Пользователь убеждается об успешном добавлении менеджера в свой проект
   # ТЕСТ проходит корректно(Роль менеджера или главного менеджера)
  Сценарий: Пользователь получает отчет по проекту за прошлый месяц
    Когда Пользователь заходит на страницу с проектами AlfaDirect и открывает отчет за прошлый месяц
    Тогда Пользователь убеждается об успешном просмотре отчета по проекту
# тест проходит корректно/тест удаляет конкретный проект.
  Сценарий: Пользователь удаляет подряд на странице Подрядчики
    Когда Пользователь заходит на страницу с подрядами и удаляет подряд
    Тогда Пользователь убеждается об успешном удалении подряда
  # ТЕСТ проходит корректно
  Сценарий: Пользователь редактирует информацию о подряде
    Когда Пользователь редактирует информацию о подрядчике
      | Добавление информации | Разработка |
    Тогда Пользователь убеждается об успешном редактировании информации о подрядчике
# ТЕСТ проходит корректно(Роль менеджера или главного менеджера)
  Сценарий: Пользователь просматривает свою роль на странице профиль
    Когда Пользователь заходит на страницу Профиль
    Тогда Пользователь убеждается о досупном просмотре своей роли на странице Профиль

  Сценарий: Пользователь заполняет данные на странице Профиль
    Когда Пользователь заполняет данные на странице Профиля
      | Имя               | Николай       |
      | Фамилия           | Петрыч        |
      | Отчество          | Николаевич    |
      | Электронная почта | nip@crtweb.ru |
      | Формат даты       | ММ/ДД/ГГГГ    |
      | Формат времени    | 12ч           |
    Тогда Пользователь убеждется что данные профиля заполнились корректно
      | Имя               | Николай       |
      | Фамилия           | Петрыч        |
      | Отчество          | Николаевич    |
      | Электронная почта | nip@crtweb.ru |
      | Формат даты       | ММ/ДД/ГГГГ    |
      | Формат времени    | 12ч           |


    # ТЕСТ проходит корректно(Роль разработчика)
  Сценарий: Пользователь создает две задачи на границах временных промежутков
    Когда Пользователь создает задачу с параметрами
      | Название         | Написание автотестов на трекер       |
      | Время начала     | 08:00                                |
      | Время конец      | 08:30                                |
      | Проект           | Песок                                |
      | Ссылка на задачу | https://hub.crtweb.ru/tracker        |
      | Описание задачи  | Автотестирование внутреннего трекера |
    Когда Пользователь создает задачу с параметрами
      | Название         | Написание тестов на трекер       |
      | Время начала     | 08:30                            |
      | Время конец      | 08:32                            |
      | Проект           | Песок                            |
      | Ссылка на задачу | https://hub.crtweb.ru/tracker    |
      | Описание задачи  | Тестирование внутреннего трекера |
    Тогда Пользователь убеждается об успешном создании задач

  Сценарий: Пользователь вносит задачу в уже существующую задачу
    Когда Пользователь создает задачу с параметрами
      | Название         | Написание автотестов на трекер       |
      | Время начала     | 11:00                                |
      | Время конец      | 11:12                                |
      | Проект           | Песок                                |
      | Ссылка на задачу | https://hub.crtweb.ru/tracker        |
      | Описание задачи  | Автотестирование внутреннего трекера |
    Тогда Пользователь убеждается об успешном создании задач
    И Пользователь создает задачу с параметрами
      | Название         | Добавление Allure репорта           |
      | Время начала     | 09:00                               |
      | Время конец      | 09:30                               |
      | Проект           | Песок                               |
      | Ссылка на задачу | https://hub.crtweb.ru/tracker       |
      | Описание задачи  | Добавление Allure репорта к проекту |
    Тогда Пользователь убеждается об успешном создании задач

    Когда Пользователь создает задачу с параметрами
      | Название         | Добавление логирование на проект |
      | Время начала     | 11:00                            |
      | Время конец      | 11:10                            |
      | Проект           | Песок                            |
      | Ссылка на задачу | https://hub.crtweb.ru/tracker    |
      | Описание задачи  | Добавление логов на проект       |
    Тогда Пользователь убеждается об успешном создании задач
# ТЕСТ работает корректно
  Сценарий: Пользователь переходит с главной страницы Creative Tracker на страницу База знаний
    Когда Пользователь переходит с главной страницы трекера на страницу База знаний
    Тогда Пользователь убеждается об успешном переходе на страницу База знаний
# ТЕСТ работает корректно
  Сценарий: Пользователь переходит с главной страницы Creative Tracker на страницу Лонгриды
    Когда Пользователь переходит с главной страницы трекера на страницу Лонгриды
    Тогда Пользователь убеждается об успешном переходе на страницу Лонгриды
# ТЕСТ работает корректно
  Сценарий: Пользователь переходит с главной страницы Creative Tracker на страницу Платрум
    Когда Пользователь переходит с главной страницы трекера на страницу Платрум
    Тогда Пользователь убеждается об успешном переходе на страницу Платрум
# ТЕСТ работает корректно
  Сценарий: Пользователь переходит с главной страницы Creative Tracker на страницу Гит
    Когда Пользователь переходит с главной страницы трекера на страницу Гит
    Тогда Пользователь убеждается об успешном переходе на страницу Гит
# ТЕСТ работает корректно
  Сценарий: Пользователь переходит с главной страницы Creative Tracker на страницу CRT.TEAM
    Когда Пользователь переходит с главной страницы трекера на страницу CRT.TEAM
    Тогда Пользователь убеждается об успешном переходе на страницу CRT.TEAM
# ТЕСТ работает корректно
  Сценарий: Пользователь переходит с главной страницы Creative Tracker на страницу Сайт
    Когда Пользователь переходит с главной страницы трекера на страницу Сайт
    Тогда Пользователь убеждается об успешном переходе на страницу Сайт
# ТЕСТ работает корректно
  Сценарий: Пользователь переходит с главной страницы Creative Tracker на страницу Резюме специалистов
    Когда Пользователь переходит с главной страницы трекера на страницу Резюме специалистов
    Тогда Пользователь убеждается об успешном переходе на страницу Резюме специалистов
# ТЕСТ работает корректно
  Сценарий: Пользователь удаляет проект из архива
    Когда Пользователь заходит на страницу с проектами и удаляет проект из Архива
    Тогда Пользователь получает уведомление об отсутствии прав на удаление проекта
# ТЕСТ работает корректно(негативный сценарий)
  Сценарий: Пользователь ищет проекты на странице используя невалидные данные
    Когда Пользователь переходит на страницу Проекты и вводит в поиск невалидные данные
    Тогда Пользователь получает уведомление об отсутствии проектов с таким названием
# ТЕСТ работает корректно(негативный сценарий)
  Сценарий: Пользователь создает новый проект без данных
    Когда Пользователь заходит на страницу с проектами и создает проект без данных
    Тогда Пользователь получает уведомление об необходимости заполнения полей
# Тест проходит корректно(негативный сценарий)
  Сценарий: Пользователь заходит на страницу Проекты и создает проект используя только название
    Когда Пользователь переходит на страницу с проектами и вводит только название проекта
    Тогда Пользователь получает уведомление об необходимости заполнения полей
# Тест проходит корректно(негативный сценарий)
  Сценарий: Пользователь заходит на страницу Проекты и создает проект с неполными данными
    Когда Пользователь заходит на страницу с проектами и создает проект без выбора подрядчика
    Тогда Пользователь получает уведомление об необходимости заполнения полей
# Тест проходит корректно(негативный сценарий)
  Сценарий: Пользователь создает задачу с параметрами используя невалидный временной промежуток
    Когда Пользователь создает задачу с параметрами
      | Название         | Написание автотестов на трекер       |
      | Время начала     | 00:00                                |
      | Время конец      | 00:00                                |
      | Проект           | Песок                                |
      | Ссылка на задачу | https://hub.crtweb.ru/tracker        |
      | Описание задачи  | Автотестирование внутреннего трекера |
    Тогда Пользователь получает уведомление о неверно выбранном временном промежутке
# Тест проходит корректно
  Сценарий: Пользователь создает задачу запуская таймер и останавливает ее меньше чем за минуту
    Когда Пользователь заходит на страницу Таймер запускает таймер в текущем времени и останавливает его менее чем за минуту
    Тогда Пользователь получает уведомление о неверно выбранном временном промежутке
# Тест проходит корректно(негативный сценарий)
  Сценарий: Пользователь создает задачу на час вперед от текущего времени
    Когда Пользователь создает задачу с параметрами
      | Название         | Написание автотестов на трекер       |
      | Время начала     | 10:20                                |
      | Время конец      | 11:00                                |
      | Проект           | Песок                                |
      | Ссылка на задачу | https://hub.crtweb.ru/tracker        |
      | Описание задачи  | Автотестирование внутреннего трекера |
    Тогда Пользователь получает уведомление о невалидном временном промежутке
# Тест проходит корректно
  Сценарий: Пользователь создает проект без полных данных
    Когда Пользователь заходит на страницу Проекты и создает проект выбрав только Подрядчика
    Тогда Пользователь получает уведомление об необходимости заполнения полей
# Тест проходит корректно
  Сценарий: Пользователь создает задачу без параметров
    Когда Пользователь переходит на страницу Таймер и создает задачу без параметров
    Тогда Пользователь получает уведомление об необходимости выбрать название для задачи
# Тест проходит корректно(негативный сценарий)
  Сценарий: Пользователь ищет пользователей по невалидным данным
    Когда Пользователь переходит на страницу с Пользователями и ищет сотрудников по невалидным данным
    Тогда Пользовватель видит сообщение об отсутствии таких пользователей
# Тест проходит корректно(Баг)
  Сценарий: Пользователь проверяет работу пагинации на странице
    Когда Пользователь заходит на страницу с проектами и пользуется пагинацией
    Тогда При каждом клике на страницу на которой находится пользователь страницв обновляется
# Тест проходит корректно(негативный сценарий)
  Сценарий: Пользователь просматривает информацию на странице Профиль по проектах за вчерашний день
    Когда Пользователь переходит в календарь и просматривает информацию по проектам за вчерашний день
    Тогда Пользователь убеждается об отсутствии отчета за данный период
# Тест проходит корректно(негативный сценарий)
  Сценарий: Пользователь просматривает информацию на странице Профиль по проектах за текущую неделю
    Когда Пользователь переходит в календарь просматривает информацию по проектам за текущую неделю
    Тогда Пользователь убеждается об отсутствии отчета за данный период
# Тест проходит корректно(негативный сценарий)
  Сценарий: Пользователь просматривает информацию на странице Профиль за прошлую неделю
    Когда Пользователь переходит в календарь и просматривает информацию по проектам за прошлую неделю
    Тогда Пользователь видит информацию по проекту Добавление логирование на проект
# Тест проходит корректно
  Сценарий: Пользователь просматривает информацию на странице Профиль по проектам за текущий месяц
    Когда Пользователь переходит в календарь и просматривает информацию по проектам за текущий месяц
    Тогда Пользователь видит информацию по проектам за текущий месяц
# Тест проходит корректно
  Сценарий: Пользователь просматривает информацию на странице Профиль по проекту за прошлую неделю
    Когда Пользователь заходит в календарь и смотрит информацию по конкретному проекту за прошлую неделю
    Тогда Пользователь видит информацию по проекту за прошлую неделю
# Тест проходит корректно
  Сценарий: Пользователь заходит на страницу Профиль и просматривает информацию по проекту за прошлый месяц
    Когда Пользователь заходит в календарь и смотрит информацию по конкретному проекту за прошлый месяц
    Тогда Пользователь видит информацию по проекту за прошлый месяц
# Тест проходит (Отсутствует отчет за данный период)
  Сценарий: Пользователь заходит на страницу Проекты и просматривает отчет по проекту за сегодня
    Когда Пользователь просматривает отчет по проекту за сегодня
    Тогда Пользователь убеждается об отсутствии отчета за сегодня
# Тест проходит (Отсутствует отчет за данный период)
  Сценарий: Пользователь заходит на страницу Проекты и просматривает отчет по проекту за вчера
    Когда Пользователь просматривает отчет по проекту за вчера
    Тогда Пользователь убеждается об отсутствии отчета за вчера
# Тест проходит (Отсутствует отчет за данный период)
  Сценарий: Пользователь заходит на страницу Проекты и просматривает отчет по проекту за текущую неделю
    Когда Пользователь просматривает отчет по проекту за текущую неделю
    Тогда Пользователь убеждается об отсутствии отчета за текущую неделю
# Тест проходит (Отсутствует отчет за данный период)
  Сценарий: Пользователь заходит на страницу Проекты и просматривает отчет по проекту за прошлую неделю
    Когда Пользователь просматривает отчет по проекту за прошлую неделю
    Тогда Пользователь просматривает отчет за прошлую неделю
# Тест проходит (Присутствует отчет за данный период)
  Сценарий: Пользователь заходит на страницу Проекты и просматривает отчет по проекту за текущий месяц
    Когда Пользователь просматривает отчет по проекту за текущий месяц
    Тогда Пользователь просматривает отчет за текущий месяц
# Тест проходит (Отсутствует отчет за данный период)
  Сценарий: Пользователь заходит на страницу Проекты и просматривает отчет по проекту за прошлый месяц
    Когда Пользователь просматривает отчет по проекту за прошлый месяц
    Тогда Пользователь просматривает отчет за прошлый месяц
# Тест проходит
  Сценарий:Пользователь заходит на страницу Таймер создает задачу и удаляет созданную задачу
    Когда Пользователь создает задачу с параметрами
      | Название         | Написание автотестов на трекер       |
      | Время начала     | 11:00                                |
      | Время конец      | 11:12                                |
      | Проект           | Песок                                |
      | Ссылка на задачу | https://hub.crtweb.ru/tracker        |
      | Описание задачи  | Автотестирование внутреннего трекера |
    Тогда Пользователь убеждается об успешном создании задач
    И Пользователь удаляет созданную задачу
    Тогда Пользователь убеждается в удалении задачи

# Тест проходит
  Сценарий: Пользователь создает задачу без ссылки и описания
    Когда Пользователь создает задачу с параметрами
      | Название     | Написание автотестов на трекер |
      | Время начала | 09:00                          |
      | Время конец  | 09:12                          |
      | Проект       | Песок                          |
    Тогда Пользователь убеждается об успешном создании задач

# Тест проходит
  Сценарий:Пользователь добавляет ссылку и описание в созданную задачу
    Когда Пользователь заходит в созданную задачу и добавляет ссылку и описание
    Тогда Пользователь убеждается в сохранении задачи
# Тест проходит
  Сценарий: Пользователь создает две задачи с одинаковым названием
    Когда Пользователь создает задачу с параметрами
      | Название         | Написание автотестов на трекер       |
      | Время начала     | 09:00                                |
      | Время конец      | 09:12                                |
      | Проект           | Песок                                |
      | Ссылка на задачу | https://hub.crtweb.ru/tracker        |
      | Описание задачи  | Автотестирование внутреннего трекера |
    Тогда Пользователь убеждается об успешном создании задач
    И Пользователь создает задачу с параметрами
      | Название         | Написание автотестов на трекер      |
      | Время начала     | 09:15                               |
      | Время конец      | 09:30                               |
      | Проект           | Песок                               |
      | Ссылка на задачу | https://hub.crtweb.ru/tracker       |
      | Описание задачи  | Добавление Allure репорта к проекту |
    Тогда Пользователь убеждается об успешном создании задач

# Тест проходит(негативный сценарий)
  Сценарий: Пользователь на странице Таймер создает задачу с некорректным временем начала
    Когда Пользователь создает задачу с параметрами
      | Название         | Написание автотестов на трекер       |
      | Время начала     | 00:01                                |
      | Время конец      | 00:01                                |
      | Проект           | Песок                                |
      | Ссылка на задачу | https://hub.crtweb.ru/tracker        |
      | Описание задачи  | Автотестирование внутреннего трекера |
    Тогда Пользователь получает уведомление о некорректном временном промежутке

# Тест проходит(негативный сценарий)
  Сценарий: Пользователь заходит на страницу Таймер и создает задачу названием в (400 символов)
    Когда Пользователь создает задачу с длинным названием
      | Время начала     | 09:01                                |
      | Время конец      | 10:00                                |
      | Проект           | Песок                                |
      | Ссылка на задачу | https://hub.crtweb.ru/tracker        |
      | Описание задачи  | Автотестирование внутреннего трекера |
    Тогда Пользователь убеждается об успешном создании задач

  Сценарий: Пользователь заходит на страницу Пользователи и добавляет роли другим пользователям
    Когда Пользователь добавляет роли другим пользователям и сохраняет результат
    Тогда Пользователь убеждается в добавлении ролей пользователю


