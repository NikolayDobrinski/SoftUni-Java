SELECT
    p.id,
    CONCAT_WS(' ', p.first_name, p.last_name) AS full_name,
    p.age,
    p.position,
    p.hire_date
FROM
    players AS p
        JOIN
    skills_data AS sd ON p.skills_data_id = sd.id
WHERE
    age < 23
		AND position = 'A'
        AND hire_date IS NULL
        AND sd.strength > 50
ORDER BY salary , age;