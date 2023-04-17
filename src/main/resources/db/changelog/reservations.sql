--liquibase formatted sql
--changeset janos.hipszki:init-reservations-table
CREATE TABLE reservations (
	id serial NOT NULL,
	car_id integer NOT NULL,
	user_name character varying(64) NOT NULL,
	user_email character varying(32) NOT NULL,
	user_mobile character varying(16) NOT NULL,
	user_address character varying(64) NOT NULL,
	start_date date NOT NULL,
	end_date date NOT NULL,
	description character varying(128),
	created_at timestamp(0) without time zone,
	CONSTRAINT reservations_pkey PRIMARY KEY (id)
);

CREATE INDEX IF NOT EXISTS reservations_car_id_index ON public.reservations(car_id);
CREATE INDEX IF NOT EXISTS reservations_user_name_index ON public.reservations(user_name);
CREATE INDEX IF NOT EXISTS reservations_user_email_index ON public.reservations(user_email);
CREATE INDEX IF NOT EXISTS reservations_start_date_index ON public.reservations(start_date);
CREATE INDEX IF NOT EXISTS reservations_end_date_index ON public.reservations(end_date);