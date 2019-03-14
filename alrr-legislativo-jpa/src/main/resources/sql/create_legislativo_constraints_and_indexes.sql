
/**
 * Criar as chaves estrangeiras e cascade delete
 */
/**ALTER TABLE seguranca_schema.perfil
    ADD CONSTRAINT dsas FOREIGN KEY (grupo_perfil_id)
    REFERENCES seguranca_schema.grupo_perfil (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE CASCADE;
CREATE INDEX fki_dsas
    ON seguranca_schema.perfil(grupo_perfil_id);
    **/

CREATE UNIQUE INDEX legislatura_uq_idx1 ON legislativo_schema.legislatura (LOWER(legislatura.nome));

/*
 * CREATE UNIQUE INDEX perfil_uq_idx1 ON seguranca_schema.perfil (grupo_perfil_id, LOWER(perfil.nome)) WHERE grupo_perfil_id IS NOT NULL;
 * CREATE UNIQUE INDEX perfil_uq_idx2 ON seguranca_schema.perfil (LOWER(perfil.nome)) WHERE grupo_perfil_id IS NULL;
 * ALTER TABLE seguranca_schema.permissao ADD CONSTRAINT permissao_uq1 UNIQUE (objeto_id, operacao_id);
 */






