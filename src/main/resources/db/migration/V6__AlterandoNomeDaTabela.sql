ALTER TABLE alternativa
RENAME TO tb_alternativa;

ALTER TABLE tb_alternativa
RENAME COLUMN questao_id TO id_questao;

ALTER TABLE tb_alternativa
RENAME COLUMN letra_referencia TO "letra-referencia";
