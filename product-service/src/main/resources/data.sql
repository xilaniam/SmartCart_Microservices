-- Ensure the 'product' table exists
CREATE TABLE IF NOT EXISTS product
(
    id              UUID PRIMARY KEY,
    name            VARCHAR(255) NOT NULL,
    description     TEXT,
    price           VARCHAR(50) NOT NULL,
    inventory_count VARCHAR(50) NOT NULL,
    created_at      DATE NOT NULL,
    updated_at      DATE NOT NULL
);

-- Insert predefined products (updated_at = created_at)
INSERT INTO product (id, name, description, price, inventory_count, created_at, updated_at)
SELECT '211e4567-e89b-12d3-a456-426614174000',
       'Laptop Pro 14',
       'High performance laptop with 16GB RAM',
       '1499.99',
       '50',
       '2025-10-01',
       '2025-10-01'
WHERE NOT EXISTS (SELECT 1 FROM product WHERE id = '211e4567-e89b-12d3-a456-426614174000');

INSERT INTO product (id, name, description, price, inventory_count, created_at, updated_at)
SELECT '211e4567-e89b-12d3-a456-426614174001',
       'Wireless Mouse',
       'Ergonomic wireless mouse with adjustable DPI',
       '39.99',
       '200',
       '2025-10-01',
       '2025-10-01'
WHERE NOT EXISTS (SELECT 1 FROM product WHERE id = '211e4567-e89b-12d3-a456-426614174001');

INSERT INTO product (id, name, description, price, inventory_count, created_at, updated_at)
SELECT '211e4567-e89b-12d3-a456-426614174002',
       'Mechanical Keyboard',
       'RGB mechanical keyboard with blue switches',
       '89.99',
       '120',
       '2025-10-02',
       '2025-10-02'
WHERE NOT EXISTS (SELECT 1 FROM product WHERE id = '211e4567-e89b-12d3-a456-426614174002');

INSERT INTO product (id, name, description, price, inventory_count, created_at, updated_at)
SELECT '211e4567-e89b-12d3-a456-426614174003',
       '27" 4K Monitor',
       'Ultra HD monitor with HDR10 support',
       '399.99',
       '75',
       '2025-10-02',
       '2025-10-02'
WHERE NOT EXISTS (SELECT 1 FROM product WHERE id = '211e4567-e89b-12d3-a456-426614174003');

INSERT INTO product (id, name, description, price, inventory_count, created_at, updated_at)
SELECT '211e4567-e89b-12d3-a456-426614174004',
       'Gaming Chair',
       'Ergonomic chair with lumbar support and adjustable height',
       '199.99',
       '60',
       '2025-10-03',
       '2025-10-03'
WHERE NOT EXISTS (SELECT 1 FROM product WHERE id = '211e4567-e89b-12d3-a456-426614174004');

INSERT INTO product (id, name, description, price, inventory_count, created_at, updated_at)
SELECT '211e4567-e89b-12d3-a456-426614174005',
       'External SSD 1TB',
       'Portable SSD with USB-C connectivity',
       '129.99',
       '150',
       '2025-10-03',
       '2025-10-03'
WHERE NOT EXISTS (SELECT 1 FROM product WHERE id = '211e4567-e89b-12d3-a456-426614174005');

INSERT INTO product (id, name, description, price, inventory_count, created_at, updated_at)
SELECT '211e4567-e89b-12d3-a456-426614174006',
       'Smartphone X',
       'Latest generation smartphone with OLED display',
       '999.99',
       '80',
       '2025-10-04',
       '2025-10-04'
WHERE NOT EXISTS (SELECT 1 FROM product WHERE id = '211e4567-e89b-12d3-a456-426614174006');

INSERT INTO product (id, name, description, price, inventory_count, created_at, updated_at)
SELECT '211e4567-e89b-12d3-a456-426614174007',
       'Wireless Earbuds',
       'Noise-cancelling earbuds with 24h battery life',
       '149.99',
       '300',
       '2025-10-04',
       '2025-10-04'
WHERE NOT EXISTS (SELECT 1 FROM product WHERE id = '211e4567-e89b-12d3-a456-426614174007');

INSERT INTO product (id, name, description, price, inventory_count, created_at, updated_at)
SELECT '211e4567-e89b-12d3-a456-426614174008',
       'Smartwatch Z',
       'Fitness smartwatch with heart rate and sleep tracking',
       '249.99',
       '90',
       '2025-10-05',
       '2025-10-05'
WHERE NOT EXISTS (SELECT 1 FROM product WHERE id = '211e4567-e89b-12d3-a456-426614174008');

INSERT INTO product (id, name, description, price, inventory_count, created_at, updated_at)
SELECT '211e4567-e89b-12d3-a456-426614174009',
       'Bluetooth Speaker',
       'Portable waterproof Bluetooth speaker',
       '79.99',
       '200',
       '2025-10-05',
       '2025-10-05'
WHERE NOT EXISTS (SELECT 1 FROM product WHERE id = '211e4567-e89b-12d3-a456-426614174009');

INSERT INTO product (id, name, description, price, inventory_count, created_at, updated_at)
SELECT '211e4567-e89b-12d3-a456-426614174010',
       'Drone Pro',
       '4K camera drone with GPS and obstacle avoidance',
       '599.99',
       '40',
       '2025-10-06',
       '2025-10-06'
WHERE NOT EXISTS (SELECT 1 FROM product WHERE id = '211e4567-e89b-12d3-a456-426614174010');

INSERT INTO product (id, name, description, price, inventory_count, created_at, updated_at)
SELECT '211e4567-e89b-12d3-a456-426614174011',
       'Action Camera',
       'Waterproof action camera with 4K recording',
       '199.99',
       '70',
       '2025-10-06',
       '2025-10-06'
WHERE NOT EXISTS (SELECT 1 FROM product WHERE id = '211e4567-e89b-12d3-a456-426614174011');

INSERT INTO product (id, name, description, price, inventory_count, created_at, updated_at)
SELECT '211e4567-e89b-12d3-a456-426614174012',
       'Router AX3000',
       'Dual-band WiFi 6 router with high-speed coverage',
       '129.99',
       '110',
       '2025-10-07',
       '2025-10-07'
WHERE NOT EXISTS (SELECT 1 FROM product WHERE id = '211e4567-e89b-12d3-a456-426614174012');

INSERT INTO product (id, name, description, price, inventory_count, created_at, updated_at)
SELECT '211e4567-e89b-12d3-a456-426614174013',
       'Smart Home Hub',
       'Central hub for smart home devices',
       '149.99',
       '85',
       '2025-10-07',
       '2025-10-07'
WHERE NOT EXISTS (SELECT 1 FROM product WHERE id = '211e4567-e89b-12d3-a456-426614174013');

INSERT INTO product (id, name, description, price, inventory_count, created_at, updated_at)
SELECT '211e4567-e89b-12d3-a456-426614174014',
       'Electric Scooter',
       'Foldable electric scooter with 20km range',
       '499.99',
       '30',
       '2025-10-08',
       '2025-10-08'
WHERE NOT EXISTS (SELECT 1 FROM product WHERE id = '211e4567-e89b-12d3-a456-426614174014');
