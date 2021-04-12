create table "user"(
	id serial NOT NULL,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	CONSTRAINT user_pkey PRIMARY KEY (id)
);
