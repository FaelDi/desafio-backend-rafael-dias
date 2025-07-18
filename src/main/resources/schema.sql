CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    account_balance DECIMAL(19,2) NOT NULL,
    type VARCHAR(20) NOT NULL
);

CREATE TABLE transactions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    "value" DECIMAL(19, 2) NOT NULL,
    authorized BOOLEAN NOT NULL,
    notified BOOLEAN NOT NULL,
    created_at TIMESTAMP NOT NULL,
    processed_at TIMESTAMP NOT NULL,

    payer BIGINT NOT NULL,
    payee BIGINT NOT NULL,

    CONSTRAINT fk_transaction_payer FOREIGN KEY (payer) REFERENCES users(id),
    CONSTRAINT fk_transaction_payee FOREIGN KEY (payee) REFERENCES users(id)
);
