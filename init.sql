--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2 (Ubuntu 15.2-1.pgdg22.10+1)
-- Dumped by pg_dump version 15.2 (Ubuntu 15.2-1.pgdg22.10+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: eco1; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.eco1 (
    id integer NOT NULL,
    region text NOT NULL,
    check_text boolean DEFAULT true
);


ALTER TABLE public.eco1 OWNER TO postgres;

--
-- Name: eco1_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.eco1_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.eco1_id_seq OWNER TO postgres;

--
-- Name: eco1_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.eco1_id_seq OWNED BY public.eco1.id;


--
-- Name: eco1_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.eco1_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.eco1_seq OWNER TO postgres;

--
-- Name: eco2; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.eco2 (
    id integer NOT NULL,
    level text NOT NULL,
    check_text boolean DEFAULT true
);


ALTER TABLE public.eco2 OWNER TO postgres;

--
-- Name: eco2_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.eco2_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.eco2_id_seq OWNER TO postgres;

--
-- Name: eco2_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.eco2_id_seq OWNED BY public.eco2.id;


--
-- Name: eco2_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.eco2_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.eco2_seq OWNER TO postgres;

--
-- Name: people; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.people (
    id integer NOT NULL,
    email text NOT NULL,
    pass text NOT NULL,
    rule text NOT NULL
);


ALTER TABLE public.people OWNER TO postgres;

--
-- Name: people_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.people_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.people_id_seq OWNER TO postgres;

--
-- Name: people_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.people_id_seq OWNED BY public.people.id;


--
-- Name: people_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.people_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.people_seq OWNER TO postgres;

--
-- Name: eco1 id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.eco1 ALTER COLUMN id SET DEFAULT nextval('public.eco1_id_seq'::regclass);


--
-- Name: eco2 id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.eco2 ALTER COLUMN id SET DEFAULT nextval('public.eco2_id_seq'::regclass);


--
-- Name: people id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.people ALTER COLUMN id SET DEFAULT nextval('public.people_id_seq'::regclass);


--
-- Data for Name: eco1; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.eco1 (id, region, check_text) FROM stdin;
1	Europe	t
2	Asia	t
3	North America	f
\.


--
-- Data for Name: eco2; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.eco2 (id, level, check_text) FROM stdin;
0	144	f
3	77	f
13	711	f
25	0	f
26	101	f
27	854	t
28	10	t
24	11111112	f
23	123455678	f
29	0	f
30	1	t
4	79	f
14	7555	f
21	567	f
22	345678	f
2	477	f
\.


--
-- Data for Name: people; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.people (id, email, pass, rule) FROM stdin;
1	admin@admin	admin	admin
2	users@users	users	users
3	user@user	user	user
4	ko@ko	ko	user
5	ko@ko	ko	user
6	111@1	1	user
7	of@of	of	user
\.


--
-- Name: eco1_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.eco1_id_seq', 1, false);


--
-- Name: eco1_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.eco1_seq', 1, false);


--
-- Name: eco2_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.eco2_id_seq', 30, true);


--
-- Name: eco2_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.eco2_seq', 251, true);


--
-- Name: people_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.people_id_seq', 7, true);


--
-- Name: people_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.people_seq', 51, true);


--
-- Name: eco1 eco1_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.eco1
    ADD CONSTRAINT eco1_pkey PRIMARY KEY (id);


--
-- Name: eco2 eco2_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.eco2
    ADD CONSTRAINT eco2_pkey PRIMARY KEY (id);


--
-- Name: people people_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.people
    ADD CONSTRAINT people_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

