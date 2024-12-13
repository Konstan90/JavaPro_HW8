-- Создание таблицы UserLimit
CREATE TABLE IF NOT EXISTS UserLimit (
    user_id BIGINT PRIMARY KEY,
    limit_amount DECIMAL(15,2) DEFAULT 10000.00,
    spent_amount DECIMAL(15,2) DEFAULT 0.00
    );

-- Вставка тестовых данных
INSERT INTO UserLimit (user_id, limit_amount, spent_amount) VALUES (1, 10000.00, 0.00);
INSERT INTO UserLimit (user_id, limit_amount, spent_amount) VALUES (2, 10000.00, 0.00);
INSERT INTO UserLimit (user_id, limit_amount, spent_amount) VALUES (3, 10000.00, 0.00);
INSERT INTO UserLimit (user_id, limit_amount, spent_amount) VALUES (4, 10000.00, 0.00);
INSERT INTO UserLimit (user_id, limit_amount, spent_amount) VALUES (5, 10000.00, 0.00);
INSERT INTO UserLimit (user_id, limit_amount, spent_amount) VALUES (6, 10000.00, 500.00);
INSERT INTO UserLimit (user_id, limit_amount, spent_amount) VALUES (7, 10000.00, 1234.56);
INSERT INTO UserLimit (user_id, limit_amount, spent_amount) VALUES (8, 10000.00, 9876.54);
INSERT INTO UserLimit (user_id, limit_amount, spent_amount) VALUES (9, 10000.00, 4321.00);
INSERT INTO UserLimit (user_id, limit_amount, spent_amount) VALUES (10, 10000.00, 8765.43);
INSERT INTO UserLimit (user_id, limit_amount, spent_amount) VALUES (11, 10000.00, 999.99);
INSERT INTO UserLimit (user_id, limit_amount, spent_amount) VALUES (12, 10000.00, 450.50);
INSERT INTO UserLimit (user_id, limit_amount, spent_amount) VALUES (13, 10000.00, 2000.00);
INSERT INTO UserLimit (user_id, limit_amount, spent_amount) VALUES (14, 10000.00, 1500.00);
INSERT INTO UserLimit (user_id, limit_amount, spent_amount) VALUES (15, 10000.00, 3000.00);

-- Проверка данных
SELECT * FROM UserLimit;
