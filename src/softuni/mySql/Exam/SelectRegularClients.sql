SELECT
    cl.full_name,
    COUNT(cor.car_id) AS count_of_cars,
    SUM(cor.bill) AS total_sum
FROM
    clients AS cl
        LEFT JOIN
    courses AS cor ON cl.id = cor.client_id
WHERE
    cl.full_name LIKE '_a%'
GROUP BY cl.id
HAVING count_of_cars > 1
ORDER BY cl.full_name;