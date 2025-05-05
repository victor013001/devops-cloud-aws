ALTER TABLE user DROP INDEX name;

-- REVERT
-- ALTER TABLE user ADD UNIQUE (name);
-- DELETE FROM flyway_schema_history WHERE version = '1.1';