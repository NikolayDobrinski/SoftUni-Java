SELECT
    a.name,
    (CASE
        WHEN HOUR(cor.start) BETWEEN 6 AND 20 THEN 'Day'
        WHEN HOUR(cor.start) BETWEEN 0 AND 5 THEN 'Night'
        WHEN HOUR(cor.start) BETWEEN 21 AND 23 THEN 'Night'
    END) AS day_time,
    cor.bill,
    cl.full_name,
    c.make,
    c.model,
    cat.`name` AS category_name
FROM
    courses AS cor
        LEFT JOIN
    addresses AS a ON cor.from_address_id = a.id
        LEFT JOIN
    clients AS cl ON cor.client_id = cl.id
        LEFT JOIN
    cars AS c ON cor.car_id = c.id
        LEFT JOIN
    categories AS cat ON c.category_id = cat.id
ORDER BY cor.id;