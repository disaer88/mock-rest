# Getting Started  

**Getting Started**

1. Скачать последнюю версию приложения:
[https://github.com/cancelpwnz/mock-rest/releases/latest](https://github.com/cancelpwnz/mock-rest/releases/latest)

2. Запустить приложение
Команда запуска приложения: **java -jar _path_to_jar_**
Пример: **java -jar** ‪**c:\my_jar.jar**

По умолчанию приложения работает на порте 8080. При необходимости порт можно изменить при запуске приложения используя параметр «_server__.__port_».
Пример: **java -jar** ‪**c:\my_jar.jar --server.port=8083**

3. REST  API  приложения
Документация доступна после запуска приложения  по пути:
_«swagger-ui/index.html?url=/v3/api-docs»_
Пример: [http://localhost:8080/swagger-ui/index.html?url=/v3/api-docs](http://localhost:8080/swagger-ui/index.html?url=/v3/api-docs)

||============================================================||
   ************* Задание  ¯\_(ツ)_/¯ ************************ 
 =============================================================

**Базовый уровень**

Создать рабочий web  UI  поддерживающий CRUD операции микросервиса «Сотрудники» используя предоставленный REST  API. 
При реализации задачи использовать только: HTML, CSS, **JavaScript (ECMAScript 6+)**.

Пользовательский интерфейс должен содержать:
1. _Вид_ (таблицу) с сотрудниками. Необходимый функционал:
 1.1 сортировка колонок (по доступным параметрам из документации к API);
 1.2 поиск по имени;
 1.3 возможность постраничного отображения данных с возможностью выбора кол-ва элементов на странице.
3. Форма для просмотра, редактирования данных о сотруднике или для добавления нового сотрудника.
4. Кнопки или иные необходимые элементы управления данными

**Продвинутый уровень**
1) Реализовать все пункты из базового задания на React
 
