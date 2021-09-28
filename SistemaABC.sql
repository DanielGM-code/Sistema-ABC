--
-- PostgreSQL database dump
--

-- Dumped from database version 12.8 (Ubuntu 12.8-0ubuntu0.20.04.1)
-- Dumped by pg_dump version 13.4

-- Started on 2021-09-28 16:04:26

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
-- TOC entry 203 (class 1259 OID 16421)
-- Name: estudiante; Type: TABLE; Schema: public; Owner: guest
--

CREATE TABLE public.estudiante (
    id integer NOT NULL,
    primer_ape text NOT NULL,
    segundo_ape text NOT NULL,
    primer_nom text NOT NULL,
    segundo_nom text,
    activo boolean
);


ALTER TABLE public.estudiante OWNER TO guest;

--
-- TOC entry 202 (class 1259 OID 16419)
-- Name: estudiante_id_seq; Type: SEQUENCE; Schema: public; Owner: guest
--

CREATE SEQUENCE public.estudiante_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.estudiante_id_seq OWNER TO guest;

--
-- TOC entry 2933 (class 0 OID 0)
-- Dependencies: 202
-- Name: estudiante_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: guest
--

ALTER SEQUENCE public.estudiante_id_seq OWNED BY public.estudiante.id;


--
-- TOC entry 2797 (class 2604 OID 16424)
-- Name: estudiante id; Type: DEFAULT; Schema: public; Owner: guest
--

ALTER TABLE ONLY public.estudiante ALTER COLUMN id SET DEFAULT nextval('public.estudiante_id_seq'::regclass);


--
-- TOC entry 2927 (class 0 OID 16421)
-- Dependencies: 203
-- Data for Name: estudiante; Type: TABLE DATA; Schema: public; Owner: guest
--

COPY public.estudiante (id, primer_ape, segundo_ape, primer_nom, segundo_nom, activo) FROM stdin;
1	Yggo	Gorey	Malynda	Raquel	f
2	Bustin	Medlen	Theresita	Maurie	t
3	Whellams	McConway	Sonnie	Konstantin	t
4	Gipps	Hudghton	Alaster	Monah	f
5	Eskrick	Dommett	Samara	Bradan	f
6	Coupe	Verling	Dara	Jonathon	t
7	Edgett	Mullins	Torrie	Arleta	f
8	O'Shevlan	Azam	Tammara	Gibby	t
9	Boyan	Shipway	Artie	Reinwald	t
10	Waldie	Bristowe	Saundra	Braden	t
11	Burnhill	Waylen	Clo	Raimundo	f
12	Passmore	Bullas	Zabrina	Cori	f
13	Chisolm	Lanfranchi	Charity	Dillon	f
14	Belfitt	Skitch	Grannie	Avram	t
15	Ajam	Barkly	Claudelle	Hendrik	f
16	Rathe	Lilywhite	Ethelda	Latisha	t
17	Chesser	Horney	Kendre	Dame	f
18	Studders	Kitney	Agatha	Marylee	f
19	Huxley	Spragge	Laurena	\N	f
20	Adenet	Mansion	Matthew	Carmen	f
21	Grestie	Compton	Esma	Cad	t
22	Lambdin	Sall	Eddy	Meade	t
23	Koppe	Pike	Ariel	Laura	t
24	Balding	Ridd	Jackelyn	Humfrid	f
25	Padly	Ikringill	Miguela	Charlotte	f
26	Gleed	Dumpleton	Lenore	\N	f
27	Banville	Shakshaft	Garner	Brooke	t
29	Files	Bothe	Bent	Farrel	f
30	Greatbanks	Esh	Erie	Kora	f
31	Abarough	Deddum	Babita	Mellisa	f
32	Sutherby	Ortmann	Noel	Etti	t
33	Jenicke	Polk	Conant	Wallas	f
34	Penhalurick	Mills	Florentia	Ladonna	f
35	Lacelett	Room	Freida	Dionne	f
36	Heathorn	Leipelt	Olwen	Early	t
37	Gaskell	Marzelo	Isabelita	Montgomery	t
38	Tinman	Massow	Meggy	Valene	t
39	Howsin	Toppin	Dario	Arvin	t
40	Langman	Witcomb	Devin	Vanessa	t
41	Khadir	Paragreen	Layne	\N	f
42	Batchelder	Ingerith	Ofelia	\N	t
43	Lankester	McCaffrey	Sammy	\N	f
44	Norcutt	Cochrane	Towney	Vikki	t
45	Bergeon	Benz	Phineas	Emery	f
46	Will	Curnucke	Lynelle	Ira	f
47	Kausche	Bilson	Norma	Redd	t
48	Spensley	O' Donohue	Normie	Berthe	f
49	Cleaton	Wheelhouse	Rodolph	Filmore	t
50	Jakubowsky	Rowan	Enid	Ellene	t
52	Morales	Sanchez	Adrian	Noel	t
51	Diaz	Morales	Juan	Angel	f
53	Sanchez 	Garcia	Seth	Damián 	f
54	Mendoza	De jesus	Daniel	Pepe	f
28	Fellnee	Durrett	Deina	Gae	f
55	Garcia	Morales	Daniel	Daniel	t
\.


--
-- TOC entry 2934 (class 0 OID 0)
-- Dependencies: 202
-- Name: estudiante_id_seq; Type: SEQUENCE SET; Schema: public; Owner: guest
--

SELECT pg_catalog.setval('public.estudiante_id_seq', 55, true);


--
-- TOC entry 2799 (class 2606 OID 16429)
-- Name: estudiante estudiante_pkey; Type: CONSTRAINT; Schema: public; Owner: guest
--

ALTER TABLE ONLY public.estudiante
    ADD CONSTRAINT estudiante_pkey PRIMARY KEY (id);


-- Completed on 2021-09-28 16:04:30

--
-- PostgreSQL database dump complete
--

