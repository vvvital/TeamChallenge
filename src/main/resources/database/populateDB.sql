ALTER SEQUENCE global_seq RESTART WITH 1000;

insert into users ( email, name, surName, phone, password)
values ('email1@mail.ua','name1','surname1','phoneNumber1','123456'),
       ('email2@mail.ua','name2','surname2','phoneNumber2','234567'),
       ('email3@mail.ua','name3','surname3','phoneNumber3','345678'),
       ('email4@mail.ua','name4','surname4','phoneNumber4','456789'),
       ('email5@mail.ua','name5','surname5','phoneNumber5','567890');

insert into psychologist(name, surname, email, password, phone, price, location, online, offline, experience, rating, description, photolink)
values ('Сергій','Павленко','sergiy@gmail.com','password','0505555555','100','KYIV',true,true,'5','5','Опис психолога','https://drive.google.com/file/d/1dQB6rvCpTjJJ8cSg6b6eZjuvB8mPkOz6/view?usp=sharing'),
       ('Валерій','Осипов','osipov@gmail.com','password','0601234567','50','LVIV',false,true,'2','4','Опис психолога','https://drive.google.com/file/d/1dQB6rvCpTjJJ8cSg6b6eZjuvB8mPkOz6/view?usp=sharing'),
       ('Марьяна','Іванова','ivanova@gmail.com','password','0504442233','80','',true,false,'4','5','Опис психолога','https://drive.google.com/file/d/1dQB6rvCpTjJJ8cSg6b6eZjuvB8mPkOz6/view?usp=sharing'),
       ('Петро','Петров','petrov@gmail.com','password','0445556644','100','ODESSA',true,true,'6','5','Опис психолога','https://drive.google.com/file/d/1dQB6rvCpTjJJ8cSg6b6eZjuvB8mPkOz6/view?usp=sharing'),
       ('Оксана','Прокопенко','oksana@gmail.com','password','0565551122','80','DNIPRO',true,true,'1','5','Опис психолога','https://drive.google.com/file/d/1dQB6rvCpTjJJ8cSg6b6eZjuvB8mPkOz6/view?usp=sharing'),
       ('Марія','Примаченко','maria@gmail.com','password','0442223344','80','',true,false,'6','5','Опис психолога','https://drive.google.com/file/d/1dQB6rvCpTjJJ8cSg6b6eZjuvB8mPkOz6/view?usp=sharing');
