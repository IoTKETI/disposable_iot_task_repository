--
-- PostgreSQL database dump
--

-- Dumped from database version 11.5
-- Dumped by pg_dump version 11.3

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

--
-- Name: disposable; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA disposable;


ALTER SCHEMA disposable OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: category; Type: TABLE; Schema: disposable; Owner: postgres
--

CREATE TABLE disposable.category (
    category_id character varying(3) NOT NULL,
    name character varying(30),
    use_yes_or_no character varying(1),
    "order" integer,
    description character varying(500),
    creator_id character varying(30),
    modifier_id character varying(30),
    parent_id character varying(30),
    created_time timestamp with time zone,
    modified_time timestamp with time zone,
    type character varying(20)
);


ALTER TABLE disposable.category OWNER TO postgres;

--
-- Name: device_task_data_id_seq; Type: SEQUENCE; Schema: disposable; Owner: postgres
--

CREATE SEQUENCE disposable.device_task_data_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE disposable.device_task_data_id_seq OWNER TO postgres;

--
-- Name: flexible_parameter; Type: TABLE; Schema: disposable; Owner: postgres
--

CREATE TABLE disposable.flexible_parameter (
    task_id integer NOT NULL,
    flexible_parameter_id integer NOT NULL,
    data_type character varying(20),
    full_name character varying(30),
    short_name character varying(30),
    value double precision
);


ALTER TABLE disposable.flexible_parameter OWNER TO postgres;

--
-- Name: microservice; Type: TABLE; Schema: disposable; Owner: postgres
--

CREATE TABLE disposable.microservice (
    microservice_id integer NOT NULL,
    category_id character varying(3) NOT NULL,
    name character varying(30),
    description character varying(500),
    use_yes_or_no character varying(1),
    creator_id character varying(30),
    modifier_id character varying(30),
    created_time timestamp(6) without time zone,
    modified_time timestamp(6) without time zone,
    type character varying(30)
);


ALTER TABLE disposable.microservice OWNER TO postgres;

--
-- Name: output_parameter; Type: TABLE; Schema: disposable; Owner: postgres
--

CREATE TABLE disposable.output_parameter (
    task_id integer NOT NULL,
    output_parameter_id integer NOT NULL,
    data_type character varying(20) NOT NULL,
    unit_category character varying(20) NOT NULL,
    unit character varying(20),
    min_value double precision,
    max_value double precision
);


ALTER TABLE disposable.output_parameter OWNER TO postgres;

--
-- Name: service; Type: TABLE; Schema: disposable; Owner: postgres
--

CREATE TABLE disposable.service (
    service_id integer NOT NULL,
    category_id character varying(3) NOT NULL,
    name character varying(30),
    description character varying(500),
    use_yes_or_no character varying(1) NOT NULL,
    creator_id character varying(30),
    modifier_id character varying(30),
    created_time timestamp(6) without time zone NOT NULL,
    modified_time timestamp(6) without time zone,
    type character varying(30)
);


ALTER TABLE disposable.service OWNER TO postgres;

--
-- Name: static_parameter; Type: TABLE; Schema: disposable; Owner: postgres
--

CREATE TABLE disposable.static_parameter (
    task_id integer NOT NULL,
    static_parameter_id integer NOT NULL,
    data_type character varying(20),
    full_name character varying(30),
    short_name character varying(30),
    value double precision
);


ALTER TABLE disposable.static_parameter OWNER TO postgres;

--
-- Name: task; Type: TABLE; Schema: disposable; Owner: postgres
--

CREATE TABLE disposable.task (
    task_id integer NOT NULL,
    category_id character varying(3) NOT NULL,
    name character varying(30),
    description character varying(500),
    use_yes_or_no character varying(1) NOT NULL,
    creator_id character varying(30) NOT NULL,
    modifier_id character varying(30),
    created_time timestamp(6) without time zone NOT NULL,
    modified_time timestamp(6) without time zone,
    type character varying(30)
);


ALTER TABLE disposable.task OWNER TO postgres;

--
-- Data for Name: category; Type: TABLE DATA; Schema: disposable; Owner: postgres
--

COPY disposable.category (category_id, name, use_yes_or_no, "order", description, creator_id, modifier_id, parent_id, created_time, modified_time, type) FROM stdin;
002	Device	Y	3	태스크	KETI		001	2019-12-09 09:17:59.25626+00	2019-12-09 09:17:59.25626+00	Task
001	Edge	Y	2	마이크로서비스	KETI		000	2019-12-09 09:17:59.25626+00	2019-12-09 09:17:59.25626+00	MicroService
000	Cloud	Y	1	서비스	KETI		NULL	2019-12-09 09:17:59.25626+00	2019-12-09 09:17:59.25626+00	Service
\.


--
-- Data for Name: flexible_parameter; Type: TABLE DATA; Schema: disposable; Owner: postgres
--

COPY disposable.flexible_parameter (task_id, flexible_parameter_id, data_type, full_name, short_name, value) FROM stdin;
101	1	INT32	ObservingPeriod	osbp	600
101	2	INT32	SensingPeriod	senp	10
101	3	INT32	SensingDuration	send	1000
101	4	INT32	AveragingNumber	avgn	10
101	5	INT32	AveragingTime	avgt	600
102	1	INT32	SensingPeriod	senp	10
102	2	INT32	SensingDuration	send	1000
102	3	INT32	AveragingNumber	avgn	10
102	4	INT32	AveragingTime	avgt	600
103	1	INT32	ObservingPeriod	osbp	600
103	3	INT32	SensingDuration	send	1000
103	4	INT32	AveragingNumber	avgn	10
104	1	INT32	SensingDuration	send	1000
104	2	INT32	AveragingNumber	avgn	10
\.


--
-- Data for Name: microservice; Type: TABLE DATA; Schema: disposable; Owner: postgres
--

COPY disposable.microservice (microservice_id, category_id, name, description, use_yes_or_no, creator_id, modifier_id, created_time, modified_time, type) FROM stdin;
101	001	모너터링 마이크로서비스	모너터링 마이크로서비스	Y	KETI		2019-12-09 18:19:44.933351	2019-12-09 18:19:44.933351	MicroService
102	001	데이터업로드 마이크로서비스	데이터업로드 마이크로서비스	Y	KETI		2019-12-09 18:19:44.933351	2019-12-09 18:19:44.933351	MicroService
201	001	마이크로서비스3	마이크로서비스3	Y	KETI		2019-12-09 18:19:44.933351	2019-12-09 18:19:44.933351	MicroService
202	001	마이크로서비스4	마이크로서비스4	Y	KETI		2019-12-09 18:19:44.933351	2019-12-09 18:19:44.933351	MicroService
101	001	모너터링 마이크로서비스	모너터링 마이크로서비스	Y	KETI		2019-12-09 18:19:44.933351	2019-12-09 18:19:44.933351	MicroService
102	001	데이터업로드 마이크로서비스	데이터업로드 마이크로서비스	Y	KETI		2019-12-09 18:19:44.933351	2019-12-09 18:19:44.933351	MicroService
201	001	마이크로서비스3	마이크로서비스3	Y	KETI		2019-12-09 18:19:44.933351	2019-12-09 18:19:44.933351	MicroService
202	001	마이크로서비스4	마이크로서비스4	Y	KETI		2019-12-09 18:19:44.933351	2019-12-09 18:19:44.933351	MicroService
\.


--
-- Data for Name: output_parameter; Type: TABLE DATA; Schema: disposable; Owner: postgres
--

COPY disposable.output_parameter (task_id, output_parameter_id, data_type, unit_category, unit, min_value, max_value) FROM stdin;
101	1	FLOAT	atemp	℃	-40	120
102	1	FLOAT	atemp	℃	-40	120
103	1	FLOAT	atemp	℃	-40	120
104	1	FLOAT	atemp	℃	-40	120
\.


--
-- Data for Name: service; Type: TABLE DATA; Schema: disposable; Owner: postgres
--

COPY disposable.service (service_id, category_id, name, description, use_yes_or_no, creator_id, modifier_id, created_time, modified_time, type) FROM stdin;
101	000	산불감시 서비스	산불감시 서비스	Y	KETI		2019-12-09 18:19:44.933351	2019-12-09 18:19:44.933351	Service
102	000	서비스2	서비스2	Y	KETI		2019-12-09 18:19:44.933351	2019-12-09 18:19:44.933351	Service
103	000	서비스3	서비스3	Y	KETI		2019-12-09 18:19:44.933351	2019-12-09 18:19:44.933351	Service
104	000	서비스4	서비스4	Y	KETI		2019-12-09 18:19:44.933351	2019-12-09 18:19:44.933351	Service
\.


--
-- Data for Name: static_parameter; Type: TABLE DATA; Schema: disposable; Owner: postgres
--

COPY disposable.static_parameter (task_id, static_parameter_id, data_type, full_name, short_name, value) FROM stdin;
101	1	INT32	MinObservePeriod	miop	0
101	2	INT32	MaxObservePeriod	maop	3600
101	3	FLOAT	MinSensingThreshold	mist	0
101	4	FLOAT	MaxSensingThreshold	mast	100
101	5	INT32	MinSensingPeriod	misp	10
101	6	INT32	MaxSensingPeriod	masp	600
101	7	INT32	MinSensingDuration	misd	1000
101	8	INT32	MaxSensingDuration	masd	3600
101	9	INT32	MinAveragingNumber	mian	0
101	10	INT32	MaxAveragingNumber	maan	600
101	11	INT32	MinAveragingTime	miat	0
101	12	INT32	MaxAveragingTime	maat	600
102	1	FLOAT	MinSensingThreshold	mist	0
102	2	FLOAT	MaxSensingThreshold	mast	100
102	3	INT32	MinSensingPeriod	misp	10
102	4	INT32	MaxSensingPeriod	masp	600
102	5	INT32	MinSensingDuration	misd	1000
102	6	INT32	MaxSensingDuration	masd	3600
102	7	INT32	MinAveragingNumber	mian	0
102	8	INT32	MaxAveragingNumber	maan	600
102	9	INT32	MinAveragingTime	miat	0
102	10	INT32	MaxAveragingTime	maat	600
103	1	INT32	MinObservePeriod	miop	0
103	2	INT32	MaxObservePeriod	maop	3600
103	3	FLOAT	MinSensingThreshold	mist	0
103	4	FLOAT	MaxSensingThreshold	mast	100
103	5	INT32	MinSensingDuration	misd	1000
103	6	INT32	MaxSensingDuration	masd	3600
103	7	INT32	MinAveragingNumber	mian	0
103	8	INT32	MaxAveragingNumber	maan	600
104	1	FLOAT	MinSensingThreshold	mist	0
104	2	FLOAT	MaxSensingThreshold	mast	100
104	3	INT32	MinSensingDuration	misd	1000
104	4	INT32	MaxSensingDuration	masd	3600
104	5	INT32	MinAveragingNumber	mian	0
104	6	INT32	MaxAveragingNumber	maan	600
\.


--
-- Data for Name: task; Type: TABLE DATA; Schema: disposable; Owner: postgres
--

COPY disposable.task (task_id, category_id, name, description, use_yes_or_no, creator_id, modifier_id, created_time, modified_time, type) FROM stdin;
101	002	온도 센싱 태스크	osbp > avgt 인 경우에만 정상적인 동작	Y	KETI		2019-12-09 18:19:44.933351	2019-12-09 18:19:44.933351	Device
102	002	온도 센싱 태스크	If=7 요청이 오면, 10초(senp) 간격으로 센싱한 데이터를 600초(avgt)동안 모아 평균(atemp) 응답	Y	KETI		2019-12-09 18:19:44.933351	2019-12-09 18:19:44.933351	Device
103	002	온도 센싱 태스크	If=7 요청이 오면, 600초(osbp)마다 센싱한 데이터(temp)를 주기적으로 응답	Y	KETI		2019-12-09 18:19:44.933351	2019-12-09 18:19:44.933351	Device
104	002	온도 센싱 테스크	If=7 요청이 오면, 센싱한 데이터(temp)를 주기적으로 응답	Y	KETI		2019-12-09 18:19:44.933351	2019-12-09 18:19:44.933351	Device
\.


--
-- Name: device_task_data_id_seq; Type: SEQUENCE SET; Schema: disposable; Owner: postgres
--

SELECT pg_catalog.setval('disposable.device_task_data_id_seq', 100001, true);


--
-- Name: flexible_parameter flexible_parameter_pkey; Type: CONSTRAINT; Schema: disposable; Owner: postgres
--

ALTER TABLE ONLY disposable.flexible_parameter
    ADD CONSTRAINT flexible_parameter_pkey PRIMARY KEY (task_id, flexible_parameter_id);


--
-- Name: output_parameter output_parameter_pkey; Type: CONSTRAINT; Schema: disposable; Owner: postgres
--

ALTER TABLE ONLY disposable.output_parameter
    ADD CONSTRAINT output_parameter_pkey PRIMARY KEY (task_id, output_parameter_id);


--
-- Name: service service_pkey; Type: CONSTRAINT; Schema: disposable; Owner: postgres
--

ALTER TABLE ONLY disposable.service
    ADD CONSTRAINT service_pkey PRIMARY KEY (service_id);


--
-- Name: static_parameter static_parameter_pkey; Type: CONSTRAINT; Schema: disposable; Owner: postgres
--

ALTER TABLE ONLY disposable.static_parameter
    ADD CONSTRAINT static_parameter_pkey PRIMARY KEY (task_id, static_parameter_id);


--
-- Name: task task_pkey; Type: CONSTRAINT; Schema: disposable; Owner: postgres
--

ALTER TABLE ONLY disposable.task
    ADD CONSTRAINT task_pkey PRIMARY KEY (task_id);


--
-- Name: category top_category_pkey; Type: CONSTRAINT; Schema: disposable; Owner: postgres
--

ALTER TABLE ONLY disposable.category
    ADD CONSTRAINT top_category_pkey PRIMARY KEY (category_id);


--
-- Name: output_parameter fk_task_id; Type: FK CONSTRAINT; Schema: disposable; Owner: postgres
--

ALTER TABLE ONLY disposable.output_parameter
    ADD CONSTRAINT fk_task_id FOREIGN KEY (task_id) REFERENCES disposable.task(task_id);


--
-- Name: flexible_parameter fk_task_id; Type: FK CONSTRAINT; Schema: disposable; Owner: postgres
--

ALTER TABLE ONLY disposable.flexible_parameter
    ADD CONSTRAINT fk_task_id FOREIGN KEY (task_id) REFERENCES disposable.task(task_id);


--
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: cloudsqlsuperuser
--

REVOKE ALL ON SCHEMA public FROM cloudsqladmin;
REVOKE ALL ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO cloudsqlsuperuser;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

