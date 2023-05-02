CREATE TABLE book_category_main (
                                    id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                    name VARCHAR(255) NOT NULL,
                                    class_number VARCHAR(20) NOT NULL
);

CREATE TABLE book_category_sub (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    class_number VARCHAR(20) NOT NULL,
    main_category_id BIGINT NOT NULL,
    FOREIGN KEY (main_category_id) REFERENCES book_category_main(id) ON DELETE CASCADE
);
