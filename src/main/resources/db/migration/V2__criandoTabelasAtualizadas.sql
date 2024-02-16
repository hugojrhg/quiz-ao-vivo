CREATE TABLE public.tb_configuracao_jogo (
	id int8 NOT NULL,
	moeda_inicial int8 NULL,
	pontuacao_por_acerto int8 NULL,
	"level" varchar(255) NULL,
	CONSTRAINT tb_configuracao_jogo_pkey PRIMARY KEY (id)
);

CREATE TABLE public.usuario (
	age int4 NULL,
	id int8 NOT NULL,
	full_name varchar(255) NULL,
	"name" varchar(255) NULL,
	CONSTRAINT usuario_pkey PRIMARY KEY (id)
);

CREATE TABLE public.questao (
	id int8 NOT NULL,
	id_tema int8 NULL,
	pergunta varchar(255) NULL,
	resposta varchar(255) NULL,
	CONSTRAINT questao_pkey PRIMARY KEY (id)
);

CREATE TABLE public.tb_tema (
	id int8 NOT NULL,
	tema varchar(255) NULL,
	CONSTRAINT tb_tema_pkey PRIMARY KEY (id)
);

CREATE TABLE public.alternativa (
	eh_correta bool NOT NULL,
	id int8 NOT NULL,
	questao_id int8 NULL,
	alternativa varchar(255) NULL,
	CONSTRAINT alternativa_pkey PRIMARY KEY (id)
);

ALTER TABLE public.questao ADD CONSTRAINT fknn9exirc9fv3qynai30tfha9l FOREIGN KEY (id_tema) REFERENCES public.tb_tema(id);

ALTER TABLE public.alternativa ADD CONSTRAINT fk1r2gwu4bd0jnmah9m5401qex5 FOREIGN KEY (questao_id) REFERENCES public.questao(id);