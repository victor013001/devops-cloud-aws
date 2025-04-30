CREATE TABLE user (
    id   BIGINT(20) NOT NULL AUTO_INCREMENT,
    uuid CHAR(36) NOT NULL UNIQUE,
    name VARCHAR(256) NOT NULL UNIQUE,
    document_id VARCHAR(32) NOT NULL UNIQUE,
    email VARCHAR(256) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

INSERT INTO user(uuid, name, document_id, email) VALUES ('745e1209-6aa6-44e6-8e30-720713bdca2f', 'Joe', '123456789', 'joe@example.com');

-- REVERT
-- DROP TABLE IF EXISTS user;
-- DELETE FROM user WHERE uuid = '745e1209-6aa6-44e6-8e30-720713bdca2f';
-- DELETE FROM flyway_schema_history WHERE version = '1.0';