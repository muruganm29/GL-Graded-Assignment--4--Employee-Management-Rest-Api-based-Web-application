# G2B1_BED_GradedProject4
Employee Management Rest Api based Web Application

****************************************************************************************
Tasks:

1. CRUD functionality for Employee Management

2. Search and Sorting Employee Records

3. Securing the REST API with Spring-Security (User Authentication, Role Authorization)

****************************************************************************************

Requirements:

1. JDK 1.8 or higher
2. Eclipse/ IntelliJ IDE or any other ...
3. MySQL Workbench or any other database ...
4. Postman (For Testing APIs)

****************************************************************************************

Running the Application:

1. Run EmployeeRestApiApplication.java, as Java Application
    path to the above file: /EmployeeRestApi/src/main/java/com/g2b1/emsrestapi/EmployeeRestApiApplication.java

**Important:** 

**From the Backend**
Comment out **".and().httpBasic()"** in configure(HttpSecurity http) method to disable Authentication in the Beginning Phase of the Project as there will be no roles and users in the MySQL database initially.

file path: /EmployeeRestApi/src/main/java/com/g2b1/emsrestapi/security/WebSecurityConfig.java

**OR**

**From Postman**
Select **No-Auth** in Postman and start adding roles and users and once done, now can switch to **Basic-Authorization** in Postman to further test the APIs 

2. i. Add Roles into the database.
        url: http://localhost/registration/addrole - POST Request
        
        Sample JSON input:
        {
            "name":"USER"
        }
    
    ii. Add Users into the Database.
        url: http://localhost/registration/adduser - POST Request

        Sample JSON input:
        {
            "username":"temp",
            "password":"12345",
            "roles":[{
                "id":2,
                "name":"USER",
            }]
        }

**Important:** Enable Authentication(Basic Authorization), undo commenting **".and().httpBasic()"** in configure(HttpSecurity http) method 
file path: /EmployeeRestApi/src/main/java/com/g2b1/emsrestapi/security/WebSecurityConfig.java

3. Saving Employee Record
    
    url: http://localhost:8080/api/employees/save - POST Request

    Sample JSON input:
    {
       "firstName":"gl",
       "lastName":"postman",
       "email":"postman@gmail.com"
    }

4. Display Employee Records
   
   url: http://localhost:8080/api/employees - Get Request

5. Display An Employee's Record By ID

    url: http://localhost:8080/api/employees/1 - Get Request

6. Update the Details of A Specific Employee
   
    url: http://localhost:8080/api/employees/update - Put Request

    Object to be updated(raw->Json)- 
    {
       "id":1,
       "firstName":"postman",
       "lastName":"postman",
       "email":"postman@gamil.com"
    }

    Response Body after updation-
    {
       "id": 1,
       "firstName": "postman",
       "lastName": "postman",
       "email": "postman@gamil.com"
    }

7. Delete An Employee Record By ID

    url: http://localhost:8080/api/employees/1 - Delete Request

8. Search(Display) List of All Employees By their FirstName

    url: http://localhost:8080/api/employees/search/postman - Get Request

9. Sort Employees Records By their FirstName
    
   url: http://localhost:8080/api/employees/sort?order=desc - Get Request 
