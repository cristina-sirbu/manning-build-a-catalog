CREATE TABLE catalog (
    sku VARCHAR(255) PRIMARY KEY,  -- Assuming SKU is a string and acts as the primary key
    title VARCHAR(255) NOT NULL,   -- @NotBlank ensures it cannot be empty
    price DECIMAL(10,2) NOT NULL   -- @NotNull ensures it cannot be NULL
);