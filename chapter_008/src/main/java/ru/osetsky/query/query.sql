--1--
select p.id, p.name, p.type_id, p.expired_date, p.price from product as p,type as t where t.name = 'СЫР';
--2--
select * from product as p where p.name like '%мороженное%';
--3--
select * from product as p where p.expired_date between '2017-12-10' and '2018-01-10';
--4--
select max(p.price) from product as p;
--5--
select count(id) from product where product.type_id=1;
--6--
select p.id, p.name, p.type_id, p.expired_date, p.price from product as p, type as t where t.name = 'СЫР' or t.name = 'МОЛОКО';
--7--
select t.name from product as p, type as t group by t.id having count(p.type_id) < 10 ;
--8--
select p.id,p.name,t.name,p.expired_date,p.price from product as p INNER JOIN type as t on p.type_id = t.id;