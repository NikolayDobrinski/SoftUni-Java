DELIMITER //
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(IN salary_level DECIMAL(19, 4))
BEGIN
	SELECT ah.first_name, ah.last_name FROM account_holders AS ah
    JOIN accounts AS a
    ON a.account_holder_id = ah.id
    GROUP BY a.account_holder_id
    HAVING SUM(a.balance) > salary_level
    ORDER BY ah.id;
END//
DELIMITER ;

CALL usp_get_holders_with_balance_higher_than(7000);