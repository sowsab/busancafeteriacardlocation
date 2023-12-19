INSERT INTO `user` (`idx`, `email`, `id`, `pw`)
VALUES (1, 'admin@test.com', 'admin', '1234'),
       (2, 'test@test.com', 'test', '1234');

INSERT INTO `user_role` (`idx`, `user_idx`, `role`)
VALUES (1, 1, 'ADMIN'),
       (2, 1, 'USER'),
       (3, 2, 'USER');