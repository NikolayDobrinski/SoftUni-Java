create function udf_courses_by_client (phone_num varchar(20))
returns integer
begin

return (
select count(*)  AS `count`
from clients AS c
join courses AS co
on c.id = co.client_id
where c.phone_number = phone_num
);

end;

SELECT udf_courses_by_client ('(831) 1391236') as `count`;