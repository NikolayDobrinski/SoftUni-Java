SELECT
    c.country_name, r.river_name
FROM
    countries AS c
        LEFT JOIN
    countries_rivers AS cr ON c.country_code = cr.country_code
        LEFT JOIN
    rivers AS r ON cr.river_id = r.id
        JOIN
    continents ON c.continent_code = continents.continent_code
WHERE
    continent_name = 'Africa'
ORDER BY c.country_name
LIMIT 5;