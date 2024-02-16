CREATE TABLE public.tb_sessao_jogador (
    sessao_ativada bool NULL,
    id int8 NOT NULL,
    pontuacao int8 NULL,
    usuario_id int8 NULL,
    "level" varchar(255) NULL,
    CONSTRAINT tb_sessao_jogador_pkey PRIMARY KEY (id)
);

CREATE TABLE public.tb_sessao_questao (
    foi_jogado bool NULL,
    jogador_venceu bool NULL,
    questao_ativa bool NULL,
    id int8 NOT NULL,
    questao_id int8 NULL,
    sessao_jogador_id int8 NULL,
    CONSTRAINT tb_sessao_questao_pkey PRIMARY KEY (id)
);
ALTER TABLE questao RENAME TO tb_questao;
ALTER TABLE public.tb_sessao_questao ADD CONSTRAINT fkf5wpmx1ui8oscs2k3wyidjtgi FOREIGN KEY (sessao_jogador_id) REFERENCES public.tb_sessao_jogador(id);

ALTER TABLE public.tb_sessao_questao ADD CONSTRAINT fkfey7x3t2cjrt3hwx49bs78p4m FOREIGN KEY (questao_id) REFERENCES public.tb_questao(id);