create table engine(
id serial primary key,
name varchar(2000)
)
insert into engine(name) values ('1.8 potrol');
insert into engine(name) values ('1.8 diesel');
insert into engine(name) values ('1.6 protol');

create table transmission(
id serial primary key,
name varchar(2000)
)
insert into transmission(name) values ('automatic');
insert into transmission(name) values ('robot');
insert into transmission(name) values ('mehanic');

create table carbody(
id serial primary key,
name varchar(2000)
)
insert into carbody(name) values ('sidan');
insert into carbody(name) values ('hatchback');
insert into carbody(name) values ('universal');

create table car(
id serial primary key,
name varchar(2000),
car_engine int references engine(id),
car_transmission int references transmission(id),
car_carbody int references carbody(id)
)

insert into car(name,car_engine,car_transmission,car_carbody) values ('HENDAY SPLARIS',1,1,1);
insert into car(name,car_engine,car_transmission,car_carbody) values ('OPEL ASTRA',1,1,2);
insert into car(name,car_engine,car_transmission,car_carbody) values ('NISSAN ALMERA',1,1,1);

--Output all cars--
select c.id, c.name, e.name, t.name, ca.name from car as c left outer join engine as e on c.car_engine = e.id
left outer join transmission as t on c.car_transmission = t.id
left outer join carbody as ca on c.car_carbody = ca.id;

--Output unused details:--
--engine--
select e.name from car as c right outer join engine as e on c.car_engine = e.id where c.id is null;
--transmission--
select t.name from car as c right outer join transmission as t on c.car_transmission = t.id where c.id is null;
--car_body--
select ca.name from car as c right outer join carbody as ca on c.car_carbody = ca.id where c.id is null;