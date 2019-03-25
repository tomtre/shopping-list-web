# Shopping List web application
Sample web application built on top of Spring, Spring Security and Hibernate with PostgreSQL written in Java.
The functionality is exposed through WWW and REST services.

It helps the user to plan their shopping by allowing to create a list of products in advance and mark them as bought after the purchase.

### Functionality:
- Create new user
- Login / logout from the application
- Browse a list of products
- Add new product
- View details of the selected product
- Mark / unmark, delete, edit the product

##### Available REST endpoints:
- /api/v1/products - GET, POST, PUT
- /api/v1/products/{productId} - GET, DELETE
- /api/v1/users - POST, PUT
- /api/v1/users/{username} - GET, DELETE

### Technology stack
- Spring - Core, MVC, AOP
- Spring Security
- PostgreSQL database
- Hibernate ORM
- Hibernate Validator
- Thymeleaf

### Running
Application uses PostgreSQL database (or equivalent database with Sequence support)
1. Run scripts from `/sql` directory as postgres user (a) and then sl_user (b, c, d):
```
a) psql -h localhost -d postgres -p 5432 -U postgres -a -f 01_user_database.sql
   (creates user: sl_user , password: sl_user_pass, database: shopping_list)
b) psql -h localhost -d shopping_list -p 5432 -U sl_user -a -f 02_db_schema.sql
c) psql -h localhost -d shopping_list -p 5432 -U sl_user -a -f 03_roles.sql
d) psql -h localhost -d shopping_list -p 5432 -U sl_user -a -f 04_example_users_products.sql
```
2. The application uses **jetty-maven-plugin**. To build and run use maven command: `mvn jetty:run-war`
3. Persistence configuration properties (database, user, password, etc) is placed in */src/main/resources/persistence.properties*
4. Access URLs: 
   - Open http://localhost:8080/shopping-list/ site for web version.
   - REST services are placed under http://localhost:8080/shopping-list/api/v1/**
   - Example user has been added to the database, user: jack , password: computer44 .