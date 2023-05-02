INSERT INTO book_category_main (id, name, class_number) VALUES
                                                       (1, 'Science', '01'),
                                                       (2, 'Mathematics', '02');

INSERT INTO book_category_sub (id, name, class_number, main_category_id) VALUES
                                                                        (1, 'Biology', '01A', 1),
                                                                        (2, 'Chemistry', '01B', 1),
                                                                        (3, 'Calculus', '02A', 2),
                                                                        (4, 'Algebra', '02B', 2);
