# language: ru
@Negative


Функционал: Авторизация с некорректными данными

  @Negative
  Сценарий: Пользователь вводит некорректный email при авторизации
    Когда Пользователь авторизуется в трекере используя некорректный email '1221212121'
    Тогда Пользователь убеждается об введении некорректного email

  @Negative
  Сценарий: Пользователь авторизуется в трекере используя некорректный пароль
    Когда Пользователь аторизуется в трекере используя некорректный пароль
      | Корректный имейл    | nip@crtweb.ru |
      | Некорректный пароль | фывфывфывфыв  |
    Тогда Пользователь убеждается об введении некорректного пароля

