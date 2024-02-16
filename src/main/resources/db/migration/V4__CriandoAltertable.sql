
ALTER TABLE tb_sessao_questao
ADD COLUMN pontuação int8;

ALTER TABLE alternativa
ADD COLUMN letra_referencia VARCHAR(255);