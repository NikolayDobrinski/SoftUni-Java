update cars
set `condition` = 'C'
where (mileage >= 800000 or mileage is null) and year <= 2010 and make != 'Mercedes-Benz';