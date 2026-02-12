Spring MVC + Hibernate CRUD Application
A full-stack Java web application demonstrating CRUD operations. This project integrates the Spring Framework (MVC) for request handling and Hibernate ORM for database persistence, following a clean DAO (Data Access Object) design pattern.
🌟 Key Features
•	Web Interface: Interactive JSP pages for adding, viewing, updating, and deleting employees.
•	Spring MVC Integration: Utilizes DispatcherServlet, InternalResourceViewResolver, and @Controller for seamless request mapping.
•	Dependency Injection: Uses Spring's @Autowired and @Component annotations for loose coupling.
•	Layered Architecture: Clear separation between the Entity, Data Access Object (DAO), and Controller layers.
•	Dynamic Data Rendering: Uses JSTL/Scriplets to display real-time database content on the frontend.
🏗️ Project Architecture
The application follows the standard Spring Web MVC flow:
1.	Browser sends a request (e.g., /saveEmployee).
2.	DispatcherServlet intercepts the request and routes it to the HomeController.
3.	Controller processes data and interacts with the EmployeeDAO.
4.	EmployeeDAOImpl uses Hibernate SessionFactory to perform DB operations.
5.	Controller returns a logical view name, and the InternalResourceViewResolver renders the JSP.
________________________________________
🛠️ Tech Stack
•	Backend: Spring MVC 5.x, Hibernate 5.x/6.x
•	Frontend: JSP, CSS, HTML
•	Database: MySQL
•	Server: Apache Tomcat (or any Servlet Container)
•	Build Tool: Maven
________________________________________
📂 Folder Structure
Plaintext
src/main/java
 ├── com.tap.controller    # Handles web requests and navigation
 ├── com.tap.dao           # Data Access Object interfaces
 ├── com.tap.daoimpl       # Hibernate implementation of DAO
 └── com.tap.Entity        # Database mapped POJOs
src/main/webapp
 ├── WEB-INF
 │    ├── views            # JSP files (index, success, update)
 │    ├── web.xml          # Servlet configuration
 │    └── dispatcher-servlet.xml # Spring Bean & View configurations
 └── resources             # Static assets (if any)
________________________________________
🚀 Setup & Installation
1.	Clone the Repo:
Bash
git clone https://github.com/your-username/Spring_CURD.git
2.	Database Setup: Create a MySQL database named employee and update hibernate.cfg.xml with your root password.
3.	Deployment:
o	Right-click on the project in your IDE.
o	Select Run On Server (choose Apache Tomcat).
o	Access the app at http://localhost:8080/Spring_CURD/

