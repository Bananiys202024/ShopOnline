
insert into USERS (USERNAME, PASSWORD, ENABLED, PHONE, EMAIL) values ('dbuser1', '12345', 1, '+380972793658','Beveloper24@gmail.com');
 
insert into USERS (USERNAME, PASSWORD, ENABLED, EMAIL,PHONE) values ('dbadmin1', '12345', 1,'MayJavaDeveler24@gmail.com', '0977393661');  

insert into USERS (USERNAME, PASSWORD, ENABLED, EMAIL,PHONE) values ('Admin', '12345', 1,'Admin', '0975793661');  
 
insert into USER_ROLES(USERNAME, USER_ROLE,EMAIL) values ('dbuser1', 'USER','BestJavaDeer24@gmail.com');
 
insert into USER_ROLES (USERNAME, USER_ROLE, EMAIL) values ('Admin', 'ADMIN', 'Admin');
 
insert into USER_ROLES (USERNAME, USER_ROLE,EMAIL) values ('dbadmin1', 'USER','NotBeswper24@gmail.com');

INSERT INTO comments(commentText, dateTime,  modifiedDateTime,product_id, title,nameOfUser, WouldRecommendThisToAFriend,rating,ThatWasModified) VALUES('I hope watch this comment','2019-03-18 13:50:31','2019-03-18 15:50:50','2409','ThatTitle','ThatNameOfUser',false,4.1,true);
INSERT INTO comments(commentText, dateTime,  modifiedDateTime,product_id, title,nameOfUser, WouldRecommendThisToAFriend,rating,ThatWasModified) VALUES('I hope watch this comment','2019-03-18 13:50:31','2019-03-18 15:50:50','2410','ThatTitle','ThatNameOfUser',false,4.1,true);
INSERT INTO comments(commentText, dateTime,  modifiedDateTime,product_id, title,nameOfUser, WouldRecommendThisToAFriend,rating,ThatWasModified) VALUES('I hope watch this comment','2019-03-18 13:50:31','2019-03-18 15:50:50','2411','ThatTitle','ThatNameOfUser',false,4.1,true);
INSERT INTO comments(commentText, dateTime,  modifiedDateTime,product_id, title,nameOfUser, WouldRecommendThisToAFriend,rating,ThatWasModified) VALUES('I hope watch this comment','2019-03-18 13:50:31','2019-03-18 15:50:50','2412','ThatTitle','ThatNameOfUser',false,4.1,true);
INSERT INTO comments(commentText, dateTime,  modifiedDateTime,product_id, title,nameOfUser, WouldRecommendThisToAFriend,rating,ThatWasModified) VALUES('I hope watch this comment','2019-03-18 13:50:31','2019-03-18 15:50:50','2413','ThatTitle','ThatNameOfUser',false,4.1,true);


insert into Products (CODE, NAME, PRICE, createDate,Quantity,description, rating, Brand, Section, Category) values ('2409', 'Core Java', 100, current_timestamp(), "1", "descriptionFirst",  4.1, "Husquarna Viking","Наборы инструментов Пневматичный инструмент", "Лобзики Дрели с ударом");
 
insert into Products (CODE, NAME, PRICE, createDate,Quantity,description, rating, brand, Category) values ('2410', 'Spring for Beginners', 50, current_timestamp(), "0","descriptionSecond", 1,"#Husquarna","Лобзики Дрели с ударом");
 
insert into Products (CODE, NAME, PRICE, createDate,Quantity,description, rating, brand, Category) values ('2411', 'Swift for Beginners', 120, current_timestamp(), "123","descriptionThird",  2, "#Husquarna","Лобзики Дрели с ударом");
 
insert into Products (CODE, NAME, PRICE, createDate,Quantity,description, rating, brand,Category) values ('2412', 'Oracle XML Parser', 120, current_timestamp(), "1000000","descriptionFourth", 2.5, "#Husquarna","Лобзики Дрели с ударом");
 
insert into Products (CODE, NAME, PRICE, createDate,Quantity,description, rating, brand, Category) values ('2413', 'CSharp Tutorial for Beginers', 110, current_timestamp(), "55", "descriptionFith", 2.9, "#Husquarna","Лобзики Дрели с ударом");

INSERT INTO Admin(email,phone) VALUES("EmailCreated","phoneCREATED");
