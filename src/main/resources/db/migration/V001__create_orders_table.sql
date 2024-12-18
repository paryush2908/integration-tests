CREATE TABLE IF NOT EXISTS orders (
    id BIGSERIAL PRIMARY KEY,
    order_number VARCHAR(50) NOT NULL,
    tracking_number VARCHAR(50),
    order_date TIMESTAMP NOT NULL,
    status VARCHAR(20) NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL,
    customer_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);