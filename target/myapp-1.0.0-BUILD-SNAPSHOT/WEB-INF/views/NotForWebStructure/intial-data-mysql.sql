We need add trim() to category sections, brand;



insert into USERS (USERNAME, PASSWORD, ENABLED, PHONE, EMAIL)
values ('dbuser1', '12345', 1, '+380977793668','BestJavaDeveloper24@gmail.com');
 
insert into USERS (USERNAME, PASSWORD, ENABLED, EMAIL,PHONE)
values ('dbadmin1', '12345', 1,'MayBeBestJavaDeveloper24@gmail.com', '0977793661');  

insert into USERS (USERNAME, PASSWORD, ENABLED, EMAIL,PHONE)
values ('Admin', '12345', 1,'Admin', '0977793661');  
 
 
insert into USER_ROLES(USERNAME, USER_ROLE,EMAIL)
values ('dbuser1', 'USER','BestJavaDeveloper24@gmail.com');
 
insert into USER_ROLES (USERNAME, USER_ROLE, EMAIL)
values ('Admin', 'ADMIN', 'Admin');
 
insert into USER_ROLES (USERNAME, USER_ROLE,EMAIL)
values ('dbadmin1', 'USER','NotBestJavaDeveloper24@gmail.com');

INSERT INTO comments(commentText, dateTime,  modifiedDateTime,product_id, title,nameOfUser, WouldRecommendThisToAFriend,rating,ThatWasModified) VALUES('I hope watch this comment','2019-03-18 13:50:31','2019-03-18 15:50:50''empty','2409','ThatTitle','ThatNameOfUser',false,4.1,true);
INSERT INTO comments(deleted,commentText, dateTime,  modifiedDateTime,product_id,title,nameOfUser, WouldRecommendThisToAFriend,rating,ThatWasModified) VALUES(true,'I hope watch this comment','2019-03-18 13:50:31','2019-03-18 15:50:50''empty','2410','ThatTitle','ThatNameOfUser',true,3.2,false);
	

insert into Products (CODE, NAME, PRICE, createDate,Quantity,description, rating, Brand, Section, Category)
values ('2409', 'Core Java', 100, current_timestamp(), "1", "descriptionFirst",  4.1, "Husquarna Viking","Наборы инструментов Пневматичный инструмент", "Лобзики Дрели с ударом");
 
insert into Products (CODE, NAME, PRICE, createDate,Quantity,description, rating, brand)
values ('2410', 'Spring for Beginners', 50, current_timestamp(), "0","descriptionSecond", 1,"#Husquarna");
 
insert into Products (CODE, NAME, PRICE, createDate,Quantity,description, rating, brand)
values ('2411', 'Swift for Beginners', 120, current_timestamp(), "123","descriptionThird",  2, "#Husquarna");
 
insert into Products (CODE, NAME, PRICE, createDate,Quantity,description, rating, brand)
values ('2412', 'Oracle XML Parser', 120, current_timestamp(), "1000000","descriptionFourth", 2.5, "#Husquarna");
 
insert into Products (CODE, NAME, PRICE, createDate,Quantity,description, rating, brand)
values ('2413', 'CSharp Tutorial for Beginers', 110, current_timestamp(), "55", "descriptionFith", 2.9, "#Husquarna");
