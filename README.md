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
| **SLF4J (slf4j-simple)** | Логирование в консоль |

---

## 📂 Структура проекта

```
API_Automation_Project_01
├── src/test/java
│   ├── base
│   │   └── BaseTest.java          # общая настройка RestAssured (baseUri, contentType, логирование)
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
│   ├── resources
│   │   └── pet-image.png          # тестовое изображение для uploadImage
│   └── utils
│       ├── ApiConstants.java
│       └── Endpoints.java
├── testng.xml
├── pom.xml
└── README.md
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

### 3. Запустить тесты
`testng.xml` подключён в `maven-surefire-plugin`, поэтому достаточно:
```bash
mvn test
```
Либо явно указать suite-файл:
```bash
mvn test -DsuiteXmlFile=testng.xml
```

### 4. Требования
- **JDK 11+**
- **Maven 3.8+**
- Доступ в интернет (используется удалённый мок-сервер SwaggerHub)

---

## 🧩 Архитектура тестов

- **base.BaseTest** — базовый класс, из которого наследуются все тестовые классы. В `@BeforeClass` строит единый `RequestSpecification` (base URI, content-type, логирование запроса/ответа), чтобы не дублировать эти настройки в каждом тесте.
- **model** — POJO-классы (`Pet`, `Order`, `User`, `Category`, `Tag`) для маппинга JSON-ответов и тела запросов.
- **utils** — константы (`ApiConstants`) и endpoint-пути (`Endpoints`), исключающие дублирование строк в тестах.
- **resources/pet-image.png** — тестовое изображение для `postPetIdUploadImage`, лежит внутри проекта, а не по абсолютному локальному пути.
- **tests** — тестовые классы, сгруппированные по доменам (`pet`, `store`, `user`), каждый метод проверяет отдельный сценарий работы с API и содержит осмысленные ассерты (а не только проверку статус-кода).

---

## 🛠️ История исправлений

- **Bugfix:** `UpdatePetTest.putPet()` вызывал `.post()` вместо `.put()` — метод не тестировал то, что заявлено в названии. Исправлено.
- **Bugfix:** `postPetIdUploadImage` использовал абсолютный путь к файлу на локальной машине (`C:\Users\...`) — заменено на файл из `src/test/resources`.
- **Refactor:** настройка `baseUri`/`contentType` вынесена из каждого теста в `BaseTest`.
- **Refactor:** удалён закомментированный "мёртвый" код.
- **Improvement:** добавлены проверки содержимого ответа (не только статус-код) в тестах `Pet`, `Store`, `User`.
- **Improvement:** добавлена реализация SLF4J (`slf4j-simple`) — раньше логи никуда не писались, был только `slf4j-api`.
- **Improvement:** `testng.xml` подключён напрямую в `maven-surefire-plugin`, убран абсолютный локальный путь из атрибута `name`.

---

## 📌 Возможные улучшения

- [ ] Добавить негативные тест-кейсы (400/404/422)
- [ ] Параметризировать тестовые данные (DataProvider вместо хардкода)
- [ ] Подключить Allure для отчётности
- [ ] Добавить CI (GitHub Actions) для автозапуска тестов на каждый push
- [ ] Вынести тестовые данные в отдельные builder/factory классы

---

## 👤 Автор

Учебный/пет-проект по автоматизации API-тестирования на Java (REST Assured + TestNG).