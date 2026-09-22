# Spring Boot & Kotlin Demo

![Licence](https://img.shields.io/github/license/housaynraffea/spring-boot-kotlin-demo)

This repository demonstrates (some of) Spring Boot & Kotlin's impressive features.

Right now, this demo has the following:

- 5 thymeleaf-pages
- A POST-form accessible through the 'Contact'-page
- Navbar- and footer fragments used throughout the entire website
- Custom CSS-styling
- Two APIs (/api/tasks & /api/student-attendance)
- thymeleaf loops and statements (th:each & th:if)

## Tasks API

|Method|End point|Description|
|------|---------|----------|
|GET|/api/tasks|Get all tasks|
|GET|/api/tasks/{id}|Get one task|
|POST|/api/tasks|Create a new task|
|DELETE|/api/tasks/{id}|Delete a task|

An example command you can do to test the API out:

```sh
curl -X POST http://localhost:8080/api/tasks \
-H "Content-Type: application/json" \
-d '{"text": "Test the API with curl"}'
```

## Student Attendance API

|Method|End point|Description|
|------|---------|----------|
|GET|/api/student-attendance|Get all students|
|GET|/api/student-attendance/{studentId}|Get one student|
|POST|/api/student-attendance|Register a new student|
|DELETE|/api/student-attendance/{studentId}|Remove a student|

An example command you can do to test the API out:

```sh
curl -X POST http://localhost:8080/api/student-attendance \
-H "Content-Type: application/json" \
-d '{"studentId": 296792, "firstname": "Gabriel", "lastname": "Garfield", "email":"gabrielgarfield@gmail.com"}'
```
