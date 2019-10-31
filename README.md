# ShopOnline

<h2>Overwiew</h2>
<h6>This is my first web stie. He is completed. He works, but...code is terrible, but I am too lazy for fixing and refactoring this code because project is very big, code in CONTROLLER expecially terrible, please don't see on it, but there are many different things which cost to notice. <h6>

<h2>Frameworks and tools</h2>

<h6>
    Java&IDE: JDK7 MyEclipse2018<br>
    Backend: SpringMVC, Spring, Hibernate, jdbc, Spring Security<br>
    Frontend: JQuery, Ajax <br>
    Database: mysql7<br>
    Web Server: Tomcat 7<br>
    Build Tool: Maven<br>
    Linux： Arch Linux<br>
    Other: Log4j, Twilio <br>
</h6>

<h2>System Features</h2>

<h6>
    <ul>
        <li>Ability add item to cart</li>
        <li>Ability send message at the phone: "We sended your order."</li>
        <li>Ability to restore password by gmail</li>
        <li>Ability to LogIn and SignUp by Spring Security</li>
        <li>Ability restore password</li>
        <li>Ability review of ordered items</li>
        <li>6 different types of sorting items</li>
        <li>Ability create own product for Admin</li>
        <li>Ability edit own product for Admin</li>
        <li>Ability add comment</li>
        <li>Ability to edit comment</li>
        <li>Ability count sold amount of items for Admin</li>
        <li>Ability to revise lately viewed items</li>
        <li>Ability add rating</li>
        
    
   </ul>

</h6>

<h2>Tuning project...</h2>

<h6>
    <ol>
     <li>For sending message:<br>
        You should get trial account of twilio and then to tuning class "SendSms" in package              "CloudCommunicationPlatform" in match with your trial account </li>      
     <li>for connecting Registration and RestorePassword:<br>
        a)Set email company and password company in class "SendEmail" on lines:18,19
        <br>b)Set email on line 25 in file "servlet-context.xml"
        <br>c)Set email on line 112 in controller to your email
        <br>d)Only gmail;
     </li>  
     <li>For work of sorting:<br>        You should add to your tomcat to file "server.xml" next line:
        
        
            <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="UTF-8">
    
        
        
   </li> 
   </ol>
   
   

   
</h6>

   <h6>How use Mysql</h6>

   I'm using for start <br>
   
        mysql -p -u root
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
