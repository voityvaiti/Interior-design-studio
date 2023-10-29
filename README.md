# Interior Design Studio 
Web App, realising functions of business card site.

## Installation instructions:

1. Clone project to your local computer.
2. Download Apache Tomcat v9 and SQL server.
3. Create database. Create tables ```customers```, ```subscriptions``` and ```call_orders```. Every table must have column ```id``` with auto incrementation.
    1. customers:
       1. first_name VARCHAR(40)
       2. last_name VARCHAR(40)
       3. tel_number VARCHAR(16)
       4. email VARCHAR (255)
    2. subscriptions:
       1. customer_id INT
       2. type VARCHAR(20)
       3. start_date DATE
       4. end_date DATE
    3. call_orders:
       1. customer_id INT
4. Set driver for your SQL server in DatabaseConnector class (default - MySQL driver).
5. In ```src/main/resources``` folder create db.properties file and set ```URL```, ```USERNAME``` and ```PASSWORD``` properties for your SQL server.
6. Open ```tomcat_users.xml``` file, (default path: ```$CATALINA_HOME\conf\tomcat-users```) and add there at least one user with role ```admin```.
7. Start project in Tomcat Server.
8. To access the admin panel open ```/admin``` URL. To verify as admin, use credentials of user, created in ```tomcat_users.xml```.

## Features:

### Backend 
- Admin panel with form-based authentication
- Ability to order call
- Customer accounting 
- Subscription to services for a selected period and conditions
- Displaying and editing information about customers in admin panel
- Validation of input fields with errors displaying

###### Technology stack:
- Java EE
- JDBC
- MySQL
- Apache Tomcat
- Hibernate Validator

### Frontend(by [DmitriyTruten](https://github.com/DmitriyTruten)):
- Adaptive/Semantic layout
- Animations

###### Technology stack:
- HTML
- CSS/SCSS
- JavaScript
- Bootstrap
- JQuery
