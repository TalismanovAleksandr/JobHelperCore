CREATE TABLE course_source
(
    id    int auto_increment,
    title varchar(255),
    CONSTRAINT pk_course_source PRIMARY KEY (id)
);

CREATE TABLE skill
(
    id    bigint auto_increment,
    title varchar(255) NOT NULL,
    CONSTRAINT pk_skill PRIMARY KEY (id),
    CONSTRAINT unique_skill_title UNIQUE (title)
);

CREATE TABLE course
(
    id               bigint auto_increment,
    title            varchar(255)  NOT NULL,
    course_source_id integer       NOT NULL,
    link             varchar(2048) NOT NULL,
    description      varchar(2048) NOT NULL,
    free             boolean       NOT NULL DEFAULT true,
    CONSTRAINT pk_course PRIMARY KEY (id),
    CONSTRAINT fk_course_on_course_source FOREIGN KEY (course_source_id) REFERENCES course_source (id)
);

// Вспомогательная таблица для связи курс-скилл
CREATE TABLE course_skill
(
    id        bigint auto_increment,
    course_id bigint NOT NULL,
    skill_id  bigint NOT NULL,
    CONSTRAINT pk_course_skill PRIMARY KEY (id),
    CONSTRAINT fk_course_skill_on_course FOREIGN KEY (course_id) REFERENCES course (id),
    CONSTRAINT fk_course_skill_on_skill FOREIGN KEY (skill_id) REFERENCES skill (id)
);

insert into course_source (title)
values ('EPAM');
insert into course_source (title)
values ('Codecademy');

insert into skill (title)
values ('jvm');
insert into skill (title)
values ('collections');
insert into skill (title)
values ('stream');
insert into skill (title)
values ('concurrency');
insert into skill (title)
values ('субд');
insert into skill (title)
values ('postgres');
insert into skill (title)
values ('mysql');
insert into skill (title)
values ('js');

insert into course (title, course_source_id, link, description, free)
values ('Learn JavaScript', 2, 'https://www.codecademy.com/learn/introduction-to-javascript',
        'You will learn programming fundamentals and basic object-oriented concepts using the latest JavaScript syntax.',
        true);
insert into course (title, course_source_id, link, description, free)
values ('Learn Spring', 2, 'https://www.codecademy.com/learn/learn-spring',
        'In this course, you will learn how to build RESTful APIs with the annotations-based approach to Spring and Spring Boot.',
        false);
insert into course (title, course_source_id, link, description, free)
values ('Learn Python 3', 2, 'https://www.codecademy.com/learn/learn-python-3',
        'This course is a great introduction to both fundamental programming concepts and the Python programming language.',
        false);
insert into course (title, course_source_id, link, description, free)
values ('SQL by Examples (ENG)', 1, 'https://learn.epam.com/detailsPage?id=e4488893-0eb4-4b6c-954c-07e2ad102b29',
        'This training is for beginners in SQL (i.e. it is NOT for experienced professionals, sorry :) ).', false);
insert into course (title, course_source_id, link, description, free)
values ('Angular Mentoring Program', 1, 'https://learn.epam.com/detailsPage?id=56c95eac-49c4-409e-bcb9-e8e2c91baa3a',
        'The program is aimed to help everyone willing to master Angular.', false);

// 'Learn JavaScript' have no requirements
// 'Learn Spring' requires collections, stream, concurrency
insert into course_skill (course_id, skill_id)
values (2, 2);
insert into course_skill (course_id, skill_id)
values (2, 3);
insert into course_skill (course_id, skill_id)
values (2, 4);

// 'Learn Python 3' requires субд, mysql
insert into course_skill (course_id, skill_id)
values (3, 5);
insert into course_skill (course_id, skill_id)
values (3, 7);

// 'SQL by Examples (ENG)' requires субд
insert into course_skill (course_id, skill_id)
values (4, 5);

// 'Angular Mentoring Program' requires js
insert into course_skill (course_id, skill_id)
values (5, 8);

