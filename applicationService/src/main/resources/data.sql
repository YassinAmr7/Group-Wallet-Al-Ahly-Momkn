-- INSERT IGNORE INTO users (id, email, name) VALUES (1, 'khaled@alahly.com', 'Khaled');
-- INSERT IGNORE INTO users (id, email, name) VALUES (2, 'intern@alahly.com', 'Junior Intern');
-- INSERT IGNORE INTO users (id, email, name) VALUES (3, 'lead@alahly.com', 'Team Lead');
--
--
-- INSERT INTO wallets (balance, type, user_id, group_id, version)
-- SELECT 5000.00, 'PERSONAL', 1, NULL, 0 FROM DUAL
-- WHERE NOT EXISTS (SELECT 1 FROM wallets WHERE user_id = 1 AND type = 'PERSONAL');
--
-- INSERT INTO wallets (balance, type, user_id, group_id, version)
-- SELECT 5000.00, 'PERSONAL', 2, NULL, 0 FROM DUAL
-- WHERE NOT EXISTS (SELECT 1 FROM wallets WHERE user_id = 2 AND type = 'PERSONAL');





-- 1. إدخال المستخدمين
IF NOT EXISTS (SELECT 1 FROM users WHERE id = 1)
    INSERT INTO users (id, email, name) VALUES (1, 'khaled@alahly.com', 'Khaled');

IF NOT EXISTS (SELECT 1 FROM users WHERE id = 2)
    INSERT INTO users (id, email, name) VALUES (2, 'intern@alahly.com', 'Junior Intern');

IF NOT EXISTS (SELECT 1 FROM users WHERE id = 3)
    INSERT INTO users (id, email, name) VALUES (3, 'lead@alahly.com', 'Team Lead');

IF NOT EXISTS (SELECT 1 FROM wallets WHERE user_id = 1 AND type = 'PERSONAL')
    INSERT INTO wallets (balance, type, user_id, group_id, version)
    VALUES (5000.00, 'PERSONAL', 1, NULL, 0);

IF NOT EXISTS (SELECT 1 FROM wallets WHERE user_id = 2 AND type = 'PERSONAL')
    INSERT INTO wallets (balance, type, user_id, group_id, version)
    VALUES (5000.00, 'PERSONAL', 2, NULL, 0);