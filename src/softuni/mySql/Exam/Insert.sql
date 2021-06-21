insert into clients (full_name, phone_number)
select concat(d.first_name, " ", d.last_name),
 concat('(088) 9999', "",  d.id * 2) from drivers AS d where d.id >= 10 and d.id <=20;