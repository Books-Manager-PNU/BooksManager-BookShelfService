CREATE TABLE IF NOT EXISTS bookshelf (
    id BIGINT NOT NULL PRIMARY KEY,
    name TEXT NOT NULL,
    user_id BIGINT NOT NULL,
    update_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    create_date TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

CREATE TABLE IF NOT EXISTS bookshelf_book (
    id BIGINT NOT NULL PRIMARY KEY,
    bookshelf_id BIGINT NOT NULL,
    book_id BIGINT NOT NULL,
    is_read BOOLEAN NOT NULL,
    update_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    create_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    FOREIGN KEY (bookshelf_id) REFERENCES bookshelf (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS bookshelf_category (
    id BIGINT NOT NULL PRIMARY KEY,
    name TEXT NOT NULL,
    update_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    create_date TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

CREATE TABLE IF NOT EXISTS bookshelf_category_book (
    id BIGINT NOT NULL PRIMARY KEY,
    bookshelf_book_id BIGINT NOT NULL,
    bookshelf_category_id BIGINT NOT NULL,
    update_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    create_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT fk_bookshelf_book FOREIGN KEY (bookshelf_book_id) REFERENCES public.bookshelf_book(id),
    CONSTRAINT fk_bookshelf_category FOREIGN KEY (bookshelf_category_id) REFERENCES public.bookshelf_category(id),
    CONSTRAINT unique_book_category UNIQUE (bookshelf_book_id, bookshelf_category_id)
);

CREATE TABLE IF NOT EXISTS bookshelf_favourite (
    id BIGINT NOT NULL PRIMARY KEY,
    bookshelf_book_id BIGINT NOT NULL,
    update_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    create_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT unique_bookshelf_book_id UNIQUE (bookshelf_book_id),
    CONSTRAINT fk_bookshelf_book_id FOREIGN KEY (bookshelf_book_id) REFERENCES bookshelf_book(id)
);

CREATE TABLE IF NOT EXISTS reading_progress (
    id BIGINT NOT NULL PRIMARY KEY,
    bookshelf_book_id BIGINT NOT NULL,
    pages_read INTEGER NOT NULL,
    update_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    create_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT unique_bookshelf_book_id UNIQUE (bookshelf_book_id),
    CONSTRAINT fk_bookshelf_book_id FOREIGN KEY (bookshelf_book_id) REFERENCES bookshelf_book(id)
);