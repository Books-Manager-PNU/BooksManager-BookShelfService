CREATE TABLE IF NOT EXISTS publisher (
    id BIGINT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    website VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS author (
    id BIGINT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS book(
    id BIGINT NOT NULL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    author_id BIGINT NOT NULL,
    publisher_id BIGINT NOT NULL,
    publication_date TIMESTAMP NOT NULL,
    genre VARCHAR(255) NOT NULL,
    update_date TIMESTAMP NOT NULL,
    create_date TIMESTAMP NOT NULL,
    CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES author(id),
    CONSTRAINT fk_publisher FOREIGN KEY (publisher_id) REFERENCES publisher(id)
);