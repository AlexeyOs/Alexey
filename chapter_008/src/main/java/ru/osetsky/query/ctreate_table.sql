create table category_request (
	id_category_request serial primary key,
	degree_of_importance character varying (2000)
);

create table role (
	id serial primary key,
	namerole character varying (2000),
	rightrole character varying (2000)
);

create table users (
	id serial primary key,
	login character varying (2000),
	password character varying (2000),
	create_date timestamp,
	role_id int,
	FOREIGN KEY (role_id) REFERENCES role(id)
);

create table request (
	number_request serial primary key,
	current_status character varying (2000),
	comment_request character varying (2000),
	applied_file character varying (2000),
	category_reuest character varying (2000),
	id_user int,
	FOREIGN KEY (id_user) REFERENCES users(id),
	role_id int,
	FOREIGN KEY (role_id) REFERENCES role(id)
);

INSERT INTO category_request (degree_of_importance) VALUES ('FIRST_DEGREE');


INSERT INTO request (current_status) VALUES ('send');
INSERT INTO request (comment_request) VALUES ('for teacher');
INSERT INTO request (applied_file) VALUES ('MyWordFile');
INSERT INTO request (category_reuest) VALUES ('FISRST');

INSERT INTO role (namerole) VALUES ('User');
INSERT INTO role (rightrole) VALUES ('READ');


INSERT INTO users (login) VALUES ('Alex');
INSERT INTO users (password) VALUES ('1234');
INSERT INTO users (create_date) VALUES (current_timestamp);