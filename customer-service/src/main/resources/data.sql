-- Ensure the 'customer' table exists
CREATE TABLE IF NOT EXISTS customer
(
    id          UUID PRIMARY KEY,
    name        VARCHAR(255)        NOT NULL,
    email       VARCHAR(255) UNIQUE NOT NULL,
    created_at  DATE                NOT NULL
);

-- Insert predefined customers (only if they don't already exist)
INSERT INTO customer (id, name, email, created_at)
SELECT '111e4567-e89b-12d3-a456-426614174000',
       'Alice Johnson',
       'alice.johnson@example.com',
       '2024-05-01'
WHERE NOT EXISTS (SELECT 1 FROM customer WHERE id = '111e4567-e89b-12d3-a456-426614174000');

INSERT INTO customer (id, name, email, created_at)
SELECT '111e4567-e89b-12d3-a456-426614174001',
       'Bob Smith',
       'bob.smith@example.com',
       '2024-05-02'
WHERE NOT EXISTS (SELECT 1 FROM customer WHERE id = '111e4567-e89b-12d3-a456-426614174001');

INSERT INTO customer (id, name, email, created_at)
SELECT '111e4567-e89b-12d3-a456-426614174002',
       'Charlie Brown',
       'charlie.brown@example.com',
       '2024-05-03'
WHERE NOT EXISTS (SELECT 1 FROM customer WHERE id = '111e4567-e89b-12d3-a456-426614174002');

INSERT INTO customer (id, name, email, created_at)
SELECT '111e4567-e89b-12d3-a456-426614174003',
       'Diana Miller',
       'diana.miller@example.com',
       '2024-05-04'
WHERE NOT EXISTS (SELECT 1 FROM customer WHERE id = '111e4567-e89b-12d3-a456-426614174003');

INSERT INTO customer (id, name, email, created_at)
SELECT '111e4567-e89b-12d3-a456-426614174004',
       'Ethan Davis',
       'ethan.davis@example.com',
       '2024-05-05'
WHERE NOT EXISTS (SELECT 1 FROM customer WHERE id = '111e4567-e89b-12d3-a456-426614174004');

INSERT INTO customer (id, name, email, created_at)
SELECT '111e4567-e89b-12d3-a456-426614174005',
       'Fiona Clark',
       'fiona.clark@example.com',
       '2024-05-06'
WHERE NOT EXISTS (SELECT 1 FROM customer WHERE id = '111e4567-e89b-12d3-a456-426614174005');

INSERT INTO customer (id, name, email, created_at)
SELECT '111e4567-e89b-12d3-a456-426614174006',
       'George Wilson',
       'george.wilson@example.com',
       '2024-05-07'
WHERE NOT EXISTS (SELECT 1 FROM customer WHERE id = '111e4567-e89b-12d3-a456-426614174006');

INSERT INTO customer (id, name, email, created_at)
SELECT '111e4567-e89b-12d3-a456-426614174007',
       'Hannah Lewis',
       'hannah.lewis@example.com',
       '2024-05-08'
WHERE NOT EXISTS (SELECT 1 FROM customer WHERE id = '111e4567-e89b-12d3-a456-426614174007');

INSERT INTO customer (id, name, email, created_at)
SELECT '111e4567-e89b-12d3-a456-426614174008',
       'Isaac Hall',
       'isaac.hall@example.com',
       '2024-05-09'
WHERE NOT EXISTS (SELECT 1 FROM customer WHERE id = '111e4567-e89b-12d3-a456-426614174008');

INSERT INTO customer (id, name, email, created_at)
SELECT '111e4567-e89b-12d3-a456-426614174009',
       'Julia Adams',
       'julia.adams@example.com',
       '2024-05-10'
WHERE NOT EXISTS (SELECT 1 FROM customer WHERE id = '111e4567-e89b-12d3-a456-426614174009');

INSERT INTO customer (id, name, email, created_at)
SELECT '111e4567-e89b-12d3-a456-426614174010',
       'Kevin Turner',
       'kevin.turner@example.com',
       '2024-05-11'
WHERE NOT EXISTS (SELECT 1 FROM customer WHERE id = '111e4567-e89b-12d3-a456-426614174010');

INSERT INTO customer (id, name, email, created_at)
SELECT '111e4567-e89b-12d3-a456-426614174011',
       'Laura Scott',
       'laura.scott@example.com',
       '2024-05-12'
WHERE NOT EXISTS (SELECT 1 FROM customer WHERE id = '111e4567-e89b-12d3-a456-426614174011');

INSERT INTO customer (id, name, email, created_at)
SELECT '111e4567-e89b-12d3-a456-426614174012',
       'Michael Evans',
       'michael.evans@example.com',
       '2024-05-13'
WHERE NOT EXISTS (SELECT 1 FROM customer WHERE id = '111e4567-e89b-12d3-a456-426614174012');

INSERT INTO customer (id, name, email, created_at)
SELECT '111e4567-e89b-12d3-a456-426614174013',
       'Nina Carter',
       'nina.carter@example.com',
       '2024-05-14'
WHERE NOT EXISTS (SELECT 1 FROM customer WHERE id = '111e4567-e89b-12d3-a456-426614174013');

INSERT INTO customer (id, name, email, created_at)
SELECT '111e4567-e89b-12d3-a456-426614174014',
       'Oscar Reed',
       'oscar.reed@example.com',
       '2024-05-15'
WHERE NOT EXISTS (SELECT 1 FROM customer WHERE id = '111e4567-e89b-12d3-a456-426614174014');
