select d.first_name, d.last_name, c.make, c.model, c.mileage
from drivers AS d
join cars_drivers AS cd
on d.id = cd.driver_id
join cars AS c
on c.id = cd.car_id
where c.mileage is not null
order by c.mileage desc, d.first_name;