insert into vacancy (title, company, salary_from, salary_to, currency, gross, create_date)
values ('Java developer', 'Google', 3500, 5000, 'USD', false, CURRENT_TIMESTAMP);
insert into vacancy (title, company, salary_from, salary_to, currency, gross, create_date)
values ('Python developer', 'Yandex', 75000, 140000, 'RUB', true, CURRENT_TIMESTAMP);
insert into vacancy (title, company, salary_from, salary_to, currency, gross, create_date)
values ('Javascript developer', 'Facebook', 3000, 5000, 'USD', false, CURRENT_TIMESTAMP);

insert into skill(name)
values ('java');
insert into skill(name)
values ('python');
insert into skill(name)
values ('javascript');
insert into skill(name)
values ('hibernate');
insert into skill(name)
values ('sql');
insert into skill(name)
values ('maven');
insert into skill(name)
values ('spring');
insert into skill(name)
values ('git');

insert into vacancy_skill(vacancy_id, skill_id)
values (1, 1),
       (1, 4),
       (1, 5),
       (1, 8),
       (2, 2),
       (2, 4),
       (2, 8),
       (3, 3),
       (3, 4),
       (3, 8);
