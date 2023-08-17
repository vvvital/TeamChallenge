ALTER SEQUENCE global_seq RESTART WITH 1000;

insert into users ( email, name, surName, phone, password)
values ('email1@mail.ua','name1','surname1','phoneNumber1','123456'),
       ('email2@mail.ua','name2','surname2','phoneNumber2','234567'),
       ('email3@mail.ua','name3','surname3','phoneNumber3','345678'),
       ('email4@mail.ua','name4','surname4','phoneNumber4','456789'),
       ('email5@mail.ua','name5','surname5','phoneNumber5','567890');