CREATE TABLE `notification_emails`(
	`id` INT(11) UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `recipient` INT(11) NOT NULL,
    `subject` VARCHAR(50) NOT NULL,
    `body` VARCHAR(255) NOT NULL
);

DROP TRIGGER IF EXISTS tr_notification_emails;

DELIMITER //
CREATE TRIGGER tr_notification_emails
AFTER INSERT
ON `logs`
FOR EACH ROW
BEGIN
	INSERT INTO `notification_emails`(`recipient`, `subject`, `body`)
	VALUES (NEW.account_id,
			CONCAT('Balance change for account: ', NEW.account_id),
			CONCAT('On ', DATE_FORMAT(NOW(), '%b %d %Y at %r'), ' your balance was changed from ',
				ROUND(NEW.old_sum, 2), ' to ', ROUND(NEW.new_sum, 2), '.'));
END//
DELIMITER ;

SELECT * FROM `notification_emails`;