Restful CRUD API using Kotlin, Spring Boot, Mysql, JPA and Hibernate.

## Requirements

1. Java - 1.8.x

2. Gradle - 4.x

3. Mysql - 5.x.x

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/CesareIurlaro/Kotlin-Spring-RESTful-Project.git
```

**2. Create Mysql database**
```bash
create database kotlin_demo_app
```

**3. Change mysql username and password as per your installation or create a priviledged new user**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

OR

+ run the following query in your MySQL Shell , it will create a new priviledged user whos password is 'welcome'

`CREATE USER 'user'@'localhost' IDENTIFIED WITH mysql_native_password BY 'welcome';` <br/>
`GRANT ALL PRIVILEGES ON * . * TO 'user'@'localhost';`

**4. Running the App**

Type the following command in your terminal to run the app -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.
