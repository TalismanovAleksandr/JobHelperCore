CREATE TABLE vacancy
(
    id       SERIAL,
    title    varchar(250),
    company  varchar(250),
    skills   varchar(250),
    bottom   numeric,
    top      numeric,
    currency varchar(250),
    gross    boolean,
    CONSTRAINT pk_vacancy PRIMARY KEY (id)
);
insert into vacancy (title, company, skills, bottom, top, currency, gross)
values ('Associate Professor', 'Eire', 'Caracal', 28223, 234113, 'Yuan Renminbi', true);
insert into vacancy (title, company, skills, bottom, top, currency, gross)
values ('Editor', 'Photospace', 'Common seal', 67700, 235426, 'Dollar', true);
insert into vacancy (title, company, skills, bottom, top, currency, gross)
values ('Marketing Manager', 'Mynte', 'Rat, white-faced tree', 21716, 381956, 'Rupiah', true);
insert into vacancy (title, company, skills, bottom, top, currency, gross)
values ('Physical Therapy Assistant', 'Jaxnation', 'Dolphin, common', 41547, 87669, 'Yuan Renminbi', false);
insert into vacancy (title, company, skills, bottom, top, currency, gross)
values ('Senior Developer', 'BlogXS', 'Polecat, african', 20588, 477213, 'Zloty', true);
insert into vacancy (title, company, skills, bottom, top, currency, gross)
values ('Occupational Therapist', 'Eire', 'Squirrel, arctic ground', 39884, 382339, 'Hryvnia', false);
insert into vacancy (title, company, skills, bottom, top, currency, gross)
values ('Internal Auditor', 'Mynte', 'Peacock, blue', 39927, 149946, 'Yuan Renminbi', true);
insert into vacancy (title, company, skills, bottom, top, currency, gross)
values ('Graphic Designer', 'Tanoodle', 'Iguana, common green', 47586, 452760, 'Dollar', false);
insert into vacancy (title, company, skills, bottom, top, currency, gross)
values ('Speech Pathologist', 'Innojam', 'Yellow-necked spurfowl', 51481, 121951, 'Euro', true);
insert into vacancy (title, company, skills, bottom, top, currency, gross)
values ('Research Associate', 'Mynte', 'Cat, cape wild', 37767, 189459, 'Euro', true);






