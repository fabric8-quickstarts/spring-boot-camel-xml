-- Table: public.person

-- DROP TABLE public.person;

CREATE TABLE public.person
(
    person_id serial NOT NULL,
    first_name text COLLATE pg_catalog."default",
    last_name text COLLATE pg_catalog."default",
    contact_no text COLLATE pg_catalog."default",
    image bytea,
    email text COLLATE pg_catalog."default",
    CONSTRAINT person_pkey PRIMARY KEY (person_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.person
    OWNER to postgres;