DELIMITER //
CREATE FUNCTION ufn_get_salary_level(salary_emp DECIMAL(19,4))
RETURNS VARCHAR(10) DETERMINISTIC
BEGIN
	DECLARE result VARCHAR(10);
    SET result :=
		(CASE
			WHEN salary_emp < 30000 THEN 'Low'
			WHEN salary_emp BETWEEN 3000 AND 50000 THEN 'Average'
			ELSE 'High'
		END);
	RETURN result;
END//
DELIMITER ;

SELECT ufn_get_salary_level(13500.00);