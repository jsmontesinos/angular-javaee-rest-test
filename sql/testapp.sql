--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.11
-- Dumped by pg_dump version 9.3.11
-- Started on 2016-03-06 21:06:34 CET

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 9 (class 2615 OID 19657)
-- Name: testapp; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA testapp;


ALTER SCHEMA testapp OWNER TO postgres;

SET search_path = testapp, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 237 (class 1259 OID 19658)
-- Name: contacts; Type: TABLE; Schema: testapp; Owner: postgres; Tablespace: 
--

CREATE TABLE contacts (
    id integer NOT NULL,
    name character varying,
    lastname character varying,
    email character varying,
    address character varying,
    birthdate date
);


ALTER TABLE testapp.contacts OWNER TO postgres;

--
-- TOC entry 238 (class 1259 OID 19668)
-- Name: contacts_seq; Type: SEQUENCE; Schema: testapp; Owner: postgres
--

CREATE SEQUENCE contacts_seq
    START WITH 100
    INCREMENT BY 100
    MINVALUE 100
    NO MAXVALUE
    CACHE 1;


ALTER TABLE testapp.contacts_seq OWNER TO postgres;

--
-- TOC entry 2301 (class 0 OID 19658)
-- Dependencies: 237
-- Data for Name: contacts; Type: TABLE DATA; Schema: testapp; Owner: postgres
--

COPY contacts (id, name, lastname, email, address, birthdate) FROM stdin;
101	Pepe2	adsfsad	dd@dd.com	asfdasdf	2016-03-08
4	Pablomm22	Serrano Toledo	ps@ps.com	2222222	2016-03-09
103	asdfasdf	dasfasdf	\N	\N	\N
100	Pepedddd	akdsjfalk	jsmontesinos@gmail.com	C/ Perez galdós 18	2016-03-16
6	Pepe	kasdjfkl	sdk@dkjas.com	askdjfdaslkfdjas	2007-05-15
200	New contact	kasdjfl	ks@dkdk.com	asdfasdf	2016-03-15
102	sda2	sad	dd@dd.com	dd	\N
\.


--
-- TOC entry 2309 (class 0 OID 0)
-- Dependencies: 238
-- Name: contacts_seq; Type: SEQUENCE SET; Schema: testapp; Owner: postgres
--

SELECT pg_catalog.setval('contacts_seq', 200, true);


--
-- TOC entry 2191 (class 2606 OID 19665)
-- Name: contacts_pk; Type: CONSTRAINT; Schema: testapp; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY contacts
    ADD CONSTRAINT contacts_pk PRIMARY KEY (id);


--
-- TOC entry 2307 (class 0 OID 0)
-- Dependencies: 237
-- Name: contacts; Type: ACL; Schema: testapp; Owner: postgres
--

REVOKE ALL ON TABLE contacts FROM PUBLIC;
REVOKE ALL ON TABLE contacts FROM postgres;
GRANT ALL ON TABLE contacts TO postgres;
GRANT ALL ON TABLE contacts TO testapp;


--
-- TOC entry 2308 (class 0 OID 0)
-- Dependencies: 238
-- Name: contacts_seq; Type: ACL; Schema: testapp; Owner: postgres
--

REVOKE ALL ON SEQUENCE contacts_seq FROM PUBLIC;
REVOKE ALL ON SEQUENCE contacts_seq FROM postgres;
GRANT ALL ON SEQUENCE contacts_seq TO postgres;
GRANT ALL ON SEQUENCE contacts_seq TO testapp;


-- Completed on 2016-03-06 21:06:34 CET

--
-- PostgreSQL database dump complete
--

