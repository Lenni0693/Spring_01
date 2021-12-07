
INSERT INTO `users` (`id`, `username`, `first_name`, `last_name`, `email`, `password`, `age`)
VALUES
(1,'admin','admin','admin','admin','admin', 33),
(2,'user','user','user','user','123', 33);

INSERT INTO `roles` (`id`, `role`)
VALUES
(1,'ROLE_ADMIN'),
(2,'ROLE_USER');

insert into users_roles
values
(1, 1),
(1, 2),
(2, 2);