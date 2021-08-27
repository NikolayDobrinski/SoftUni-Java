SELECT
    REVERSE(s.name) AS reverse_name,
    CONCAT(UPPER(t.name), '-', a.name) AS full_address,
    COUNT(e.id) AS employees_count
FROM
    stores AS s
        LEFT JOIN
    addresses AS a
    ON s.address_id = a.id
        LEFT JOIN
    towns AS t
    ON a.town_id = t.id
        LEFT JOIN
    employees AS e
    ON s.id = e.store_id
GROUP BY s.id
HAVING employees_count >= 1
ORDER BY full_address;

-- -------------------------------------------------------------

SELECT
    REVERSE(s.name) AS reverse_name,
    CONCAT(UPPER(t.name), '-', a.name) AS full_address,
    (SELECT COUNT(e.id) FROM employees AS e
     WHERE e.store_id = s.id) AS employees_count
FROM
    stores AS s
        JOIN
    addresses AS a
    ON s.address_id = a.id
WHERE
        (SELECT COUNT(e.id) FROM employees AS e
         WHERE e.store_id = s.id) >= 1
ORDER BY full_address;