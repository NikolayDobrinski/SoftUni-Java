delete from clients AS c
where c.id not in (select co.client_id from courses AS co) and length(c.full_name) > 3;