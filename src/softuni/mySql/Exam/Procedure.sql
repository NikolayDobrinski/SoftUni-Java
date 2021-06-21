CREATE PROCEDURE udp_courses_by_address(address_name VARCHAR(100))
BEGIN
	SELECT a.`name`,
			cl.full_name AS full_names,
			(CASE
				WHEN cor.bill <= 20 THEN 'Low'
				WHEN cor.bill <= 30 THEN 'Medium'
				WHEN cor.bill > 30 THEN 'High'
			END) AS level_of_bill,
			c.`make`,
			c.`condition`,
			cat.`name` AS cat_name
	FROM addresses AS a
	LEFT JOIN courses AS cor
	ON cor.from_address_id = a.id
	LEFT JOIN clients AS cl
	ON cor.client_id = cl.id
	LEFT JOIN cars AS c
	ON cor.car_id = c.id
	LEFT JOIN categories AS cat
	ON c.category_id = cat.id
	WHERE a.name = address_name
	ORDER BY c.`make`, cl.full_name;
END //