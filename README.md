# 🐾 API Automation Project — Swagger Petstore

Автоматизированные тесты для публичного API **Swagger Petstore**, написанные на **Java** с использованием **REST Assured** и **TestNG**.

Проект покрывает три основных модуля API: `Pet`, `Store` и `User`, реализуя основные CRUD-операции и проверку ответов сервера.
 
---

## 🚀 Стек технологий

| Технология | Назначение |
|---|---|
| **Java** | Язык разработки |
| **REST Assured** | Отправка HTTP-запросов и валидация ответов |
| **TestNG** | Запуск и организация тестов |
| **Jackson (jackson-databind)** | Сериализация/десериализация JSON ↔ Java-объекты |
| **Maven** | Управление зависимостями и сборка проекта |
| **SLF4J** | Логирование |
 
---

## 📂 Структура проекта

```
API_Automation_Project_01
├── src/test/java
│   ├── base
│   │   └── BaseTest.java
│   ├── model
│   │   ├── Category.java
│   │   ├── Order.java
│   │   ├── Pet.java
│   │   ├── Tag.java
│   │   └── User.java
│   ├── tests
│   │   ├── pet
│   │   │   ├── CreatePetTest.java
│   │   │   ├── DeletePetTest.java
│   │   │   ├── GetPetTest.java
│   │   │   └── UpdatePetTest.java
│   │   ├── store
│   │   │   ├── CreateOrderTest.java
│   │   │   ├── DeleteOrderTest.java
│   │   │   └── GetOrderTest.java
│   │   └── user
│   │       ├── CreateUserTest.java
│   │       ├── DeleteUserTest.java
│   │       ├── GetUserTest.java
│   │       ├── LoginTest.java
│   │       ├── LogoutTest.java
│   │       └── UpdateUserTest.java
│   └── utils
│       ├── ApiConstants.java
│       └── Endpoints.java
├── testng.xml
└── pom.xml
```
 
---

## 🔗 Тестируемый API

**Base URL:**
```
https://virtserver.swaggerhub.com/sds-c05/Test_GCERT/1.0.0
```

Используется мок-сервер SwaggerHub, эмулирующий стандартный Swagger Petstore API.
 
---

## ✅ Покрытие тестами

### 🐶 Pet
| Метод | Endpoint | Тест |
|---|---|---|
| POST | `/pet` | `postPet` — создание питомца |
| POST | `/pet/{petId}` | `postPetId` — обновление данных питомца через form-data |
| POST | `/pet/{petId}/uploadImage` | `postPetIdUploadImage` — загрузка изображения |
| PUT | `/pet` | `putPet` — обновление питомца |
| GET | `/pet/findByStatus` | `getFindByStatus` — поиск по статусу |
| GET | `/pet/findByTags` | `getFindByTags` — поиск по тегам |
| GET | `/pet/{petId}` | `getPetById` — получение питомца по ID |
| DELETE | `/pet/{petId}` | `deletePetId` — удаление питомца |

### 🏬 Store
| Метод | Endpoint | Тест |
|---|---|---|
| POST | `/store/order` | `postStoreOrder` — создание заказа |
| GET | `/store/order/{orderId}` | `getStoreOrderId` — получение заказа |
| GET | `/store/inventory` | `getStoreInventory` — состояние инвентаря |
| DELETE | `/store/order/{orderId}` | `deleteStoreOrderId` — удаление заказа |

### 👤 User
| Метод | Endpoint | Тест |
|---|---|---|
| POST | `/user` | `postUser` — создание пользователя |
| GET | `/user/{username}` | `getUserName` — получение пользователя |
| PUT | `/user/{username}` | `putUserName` — обновление пользователя |
| DELETE | `/user/{username}` | `deleteUserName` — удаление пользователя |
| GET | `/user/login` | `getUserLogin` — авторизация |
| GET | `/user/logout` | `getUserLogout` — выход из системы |
 
---

## ⚙️ Установка и запуск

### 1. Клонировать репозиторий
```bash
git clone <URL_репозитория>
cd API_Automation_Project_01
```

### 2. Собрать проект
```bash
mvn clean install
```

### 3. Запустить тесты через `testng.xml`
```bash
mvn test -DsuiteXmlFile=testng.xml
```

### 4. Требования
- **JDK 11+**
- **Maven 3.8+**
- Доступ в интернет (используется удалённый мок-сервер SwaggerHub)
---

## 🧩 Архитектура тестов

- **model** — POJO-классы (`Pet`, `Order`, `User`, `Category`, `Tag`) для маппинга JSON-ответов и тела запросов.
- **utils** — константы (`ApiConstants`) и endpoint-пути (`Endpoints`), исключающие дублирование строк в тестах.
- **base** — базовый класс `BaseTest`, точка расширения для общей настройки тестов (hooks, конфигурация RestAssured).
- **tests** — тестовые классы, сгруппированные по доменам (`pet`, `store`, `user`), каждый метод проверяет отдельный сценарий работы с API.
---

## 📌 Возможные улучшения

- [ ] Вынести общую настройку `RestAssured.baseURI` и `contentType` в `BaseTest` (через `@BeforeClass`/`@BeforeSuite`)
- [ ] Добавить логирование запросов/ответов через `RequestLoggingFilter` / `ResponseLoggingFilter`
- [ ] Параметризировать тестовые данные (DataProvider вместо хардкода)
- [ ] Добавить негативные тест-кейсы (400/404/422)
- [ ] Подключить Allure для отчётности
- [ ] Убрать абсолютные пути (например, путь к изображению в `postPetIdUploadImage`) — сделать относительными/ресурсными
---

## 👤 Автор

Учебный/пет-проект по автоматизации API-тестирования на Java (REST Assured + TestNG).