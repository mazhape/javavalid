DROP TABLE IF EXISTS contribution;

CREATE TABLE contribution(
    id BIGINT NOT NULL AUTO_INCREMENT UNIQUE PRIMARY KEY,
    hwai_id BIGINT NOT NULL,
    center VARCHAR(80),
    amount FLOAT
)


