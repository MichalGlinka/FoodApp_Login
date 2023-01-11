CREATE TABLE customer(
    id INT AUTO_INCREMENT,
    username VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    authcode VARCHAR(255),
    PRIMARY KEY (id)
);