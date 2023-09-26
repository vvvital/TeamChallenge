

insert into users ( email, name, surName, phone, password)
values ('iryna@mail.ua','Ірина','Шаповал','0503322444','123456'),
       ('valera@mail.ua','Валерій','Курага','0664567885','123456'),
       ('semen@mail.ua','Семен','Ващенко','0674658595','123456'),
       ('nastia@mail.ua','Настя','Семенченко','0442233554','123456'),
       ('natasha@mail.ua','Наталья','Яриш','0994215689','123456');

insert into psychologist(name, surname, email, password, phone, price, location, online, offline, experience, rating, description, photolink)
values ('Сергій','Павленко','sergiy@gmail.com','password','0505555555','100','KYIV',true,true,'5','1','Опис психолога','https://drive.google.com/uc?export=view&id=1dQB6rvCpTjJJ8cSg6b6eZjuvB8mPkOz6'),
       ('Валерій','Осипов','osipov@gmail.com','password','0601234567','50','LVIV',false,true,'2','2','Опис психолога','https://drive.google.com/uc?export=view&id=1dQB6rvCpTjJJ8cSg6b6eZjuvB8mPkOz6'),
       ('Марьяна','Іванова','ivanova@gmail.com','password','0504442233','80','KYIV',true,false,'4','3','Опис психолога','https://drive.google.com/uc?export=view&id=1dQB6rvCpTjJJ8cSg6b6eZjuvB8mPkOz6'),
       ('Петро','Петров','petrov@gmail.com','password','0445556644','100','ODESSA',true,true,'6','4','Опис психолога','https://drive.google.com/uc?export=view&id=1dQB6rvCpTjJJ8cSg6b6eZjuvB8mPkOz6'),
       ('Оксана','Прокопенко','oksana@gmail.com','password','0565551122','80','DNIPRO',true,true,'1','5','Опис психолога','https://drive.google.com/uc?export=view&id=1dQB6rvCpTjJJ8cSg6b6eZjuvB8mPkOz6'),
       ('Марія','Примаченко','maria@gmail.com','password','0442223344','80','LVIV',true,false,'6','5','Опис психолога','https://drive.google.com/uc?export=view&id=1dQB6rvCpTjJJ8cSg6b6eZjuvB8mPkOz6');

insert into psychologist_categories(psychologist_id, categories) values
            (1,'PSYCHOTHERAPIST'),
            (1,'CHILD_PSYCHOLOGIST'),
            (1,'FAMILY_PSYCHOLOGIST'),
            (2,'ORGANIZATIONAL_PSYCHOLOGIST'),
            (2,'PSYCHOTHERAPIST'),
            (2,'PSYCHOLOGIST_ON_ADDICTION_PROBLEMS'),
            (3,'SCHOOL_PSYCHOLOGIST'),
            (3,'PSYCHOLOGIST_FOR_TEENAGERS'),
            (4,'PSYCHOLOGIST_FOR_AGER'),
            (4,'SPORTS_PSYCHOLOGIST'),
            (5,'PSYCHOLOGIST_SEXOLOGIST'),
            (6,'GROUP_THERAPY'),
            (6,'ONLINE_CONSULTATION');

