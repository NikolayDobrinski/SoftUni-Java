DELIMITER //
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL(19,4))
BEGIN
	START TRANSACTION;
    IF(money_amount <= 0)
		THEN ROLLBACK;
    ELSE
		UPDATE accounts
        SET balance = balance + money_amount
        WHERE id = account_id;
        END IF;
        COMMIT;
END //
DELIMITER ;

CALL usp_deposit_money(1, 100);