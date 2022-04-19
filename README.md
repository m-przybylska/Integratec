# Table of contents
* [About the Integratec](#about-the-integratec)
* [Technologies](#technologies)
* [How to run frontend](#how-to-run-frontend)
* [How to run backend](#how-to-run-backend)


# About the Integratec

Project implemented as part of the academic subject - Team Project. An application supporting communication between employees and the HR department through the possibility of managing requests and tasks. It allows the HR department to better plan its work and set priorities. Implemented in the form of a ticket system. 

# Technologies

<ul>  
<li> Backend: Maven project in Java, Spring Boot 2.6.6, Hibernate 5.6.5 </li>
<li> Frontend: React, sass, axios, react-router-dom, Node.js</li>
<li> Data Base: MySQL Database </li>
</ul>

 
# How to run frontend

In src/frontend/frontend directory run:

$ npm install\
$ npm start

# How to run backend

Create database connection named *integratec*

In Intellij:  
Change in *resources/application.properties* file *spring.datasource.password="your databse password"* to your own database password
In backend/demo right click on the *pom.xml* file, next click on *Build Module 'demo'*, next click on *Maven > Reload project*  
Run scr/main/java/com.integratec/Main

# For us

https://docs.google.com/document/d/1GdKW1UmhlmO0-_V3cbJVHxq56NKQSRcqmIjDuBGonCs/edit?usp=sharing

