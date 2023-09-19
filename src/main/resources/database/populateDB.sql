

insert into users ( email, name, surName, phone, password)
values ('email1@mail.ua','name1','surname1','phoneNumber1','123456'),
       ('email2@mail.ua','name2','surname2','phoneNumber2','234567'),
       ('email3@mail.ua','name3','surname3','phoneNumber3','345678'),
       ('email4@mail.ua','name4','surname4','phoneNumber4','456789'),
       ('email5@mail.ua','name5','surname5','phoneNumber5','567890');

insert into psychologist(name, surname, email, password, phone, price, location, online, offline, experience, rating, description, photolink)
values ('Сергій','Павленко','sergiy@gmail.com','password','0505555555','100','KYIV',true,true,'5','1','Опис психолога','https://drive.google.com/uc?export=view&id=1dQB6rvCpTjJJ8cSg6b6eZjuvB8mPkOz6'),
       ('Валерій','Осипов','osipov@gmail.com','password','0601234567','50','LVIV',false,true,'2','2','Опис психолога','https://drive.google.com/uc?export=view&id=1dQB6rvCpTjJJ8cSg6b6eZjuvB8mPkOz6'),
       ('Марьяна','Іванова','ivanova@gmail.com','password','0504442233','80','KYIV',true,false,'4','3','Опис психолога','https://drive.google.com/uc?export=view&id=1dQB6rvCpTjJJ8cSg6b6eZjuvB8mPkOz6'),
       ('Петро','Петров','petrov@gmail.com','password','0445556644','100','ODESSA',true,true,'6','4','Опис психолога','https://drive.google.com/uc?export=view&id=1dQB6rvCpTjJJ8cSg6b6eZjuvB8mPkOz6'),
       ('Оксана','Прокопенко','oksana@gmail.com','password','0565551122','80','DNIPRO',true,true,'1','5','Опис психолога','https://drive.google.com/uc?export=view&id=1dQB6rvCpTjJJ8cSg6b6eZjuvB8mPkOz6'),
       ('Марія','Примаченко','maria@gmail.com','password','0442223344','80','LVIV',true,false,'6','5','Опис психолога','https://drive.google.com/uc?export=view&id=1dQB6rvCpTjJJ8cSg6b6eZjuvB8mPkOz6');

insert into psychologist_categories(psychologist_id, categories) values
            (1,'PSYCHOTHERAPIST'),
            (3,'PSYCHOTHERAPIST'),
            (2,'ORGANIZATIONAL_PSYCHOLOGIST'),
            (4,'ORGANIZATIONAL_PSYCHOLOGIST'),
            (5,'CHILD_PSYCHOLOGIST'),
            (6,'CHILD_PSYCHOLOGIST')
--        (1,'Клінічний психолог'),
--        (1,'Дитячий психолог'),
--        (1,'Сімейний психолог'),
--        (2,'Організаційний психолог'),
--        (2,'Психотерапевт'),
--        (2,'Психолог з проблем залежностей'),
--        (3,'Шкільний психолог'),
--        (4,'Психолог для підлітків'),
--        (4,'Психолог для старшої вікової категорії'),
--        (4,'Спортивний психолог'),
--        (5,'Психолог-сексолог'),
--        (5,'Групова терапія'),
--        (5,'Онлайн консультації'),
--        (6,'Рекомендовані психологи'),
--        (6,'Мають статті'),
--        (6,'Онлайн консультації');

