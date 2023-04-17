--liquibase formatted sql
--changeset janos.hipszki:init-cars-table
CREATE TABLE IF NOT EXISTS cars (
	id serial NOT NULL,
	status boolean NOT NULL DEFAULT true,
	name character varying(64) NOT NULL,
	type character varying(32) NOT NULL,
	description character varying(128),
	plate character varying(32) NOT NULL,
	price integer NOT NULL,
	created_at timestamp(0) without time zone,
	CONSTRAINT cars_pkey PRIMARY KEY (id)
);

CREATE INDEX IF NOT EXISTS cars_status_index ON public.cars(status);
CREATE INDEX IF NOT EXISTS cars_plate_index ON public.cars(plate);
CREATE INDEX IF NOT EXISTS cars_type_index ON public.cars(type);