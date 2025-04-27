-- V2__Create_User_Table.sql
CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    roles VARCHAR(255) NOT NULL,
    ativo BOOLEAN DEFAULT TRUE
);

-- Adicionando a chave estrangeira novamente, caso necessário
ALTER TABLE loans
ADD CONSTRAINT FK_users
FOREIGN KEY (user_id) REFERENCES users(id);