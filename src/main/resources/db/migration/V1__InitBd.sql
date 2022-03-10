CREATE TABLE vacancy
(
    id          SERIAL,
    title       varchar(250),
    company     varchar(250),
    salary_from numeric,
    salary_to   numeric,
    currency    varchar(250),
    gross       boolean,
    create_date timestamp,
    CONSTRAINT pk_vacancy PRIMARY KEY (id)
);

CREATE TABLE skill
(
    id   SERIAL,
    name varchar(250) UNIQUE ,
    CONSTRAINT pk_skill PRIMARY KEY (id)
);

CREATE TABLE vacancy_skill
(
    vacancy_id integer,
    skill_id   integer,
    CONSTRAINT FK_vacancy
        FOREIGN KEY (vacancy_id) REFERENCES vacancy (id),
    CONSTRAINT FK_skill
        FOREIGN KEY (skill_id) REFERENCES skill (id)
);








