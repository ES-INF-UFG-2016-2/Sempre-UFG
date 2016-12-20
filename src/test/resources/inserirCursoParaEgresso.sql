INSERT INTO egresso (nome, nome_mae, data_nascimento, visibilidade, sexo) VALUES
  ('Marcos Pereira', 'Nadir de Paulo', NOW() :: DATE, 'Privado', 'feminino');

INSERT INTO localizacao_geografica (nome_cidade, nome_unidade_federativa, nome_pais, sigla)
VALUES ('Goiânia', 'Goiás', 'Brasil', 'GO');

INSERT INTO regional_ufg (nome, id_localizacao_geografica) VALUES (
  'Goiânia', (SELECT id
              FROM localizacao_geografica
              LIMIT 1)
);


INSERT INTO unidade_academica_ufg (nome, id_localizacao_geografica, regional_ufg_id) VALUES (
  'Área acadêmica', (SELECT id
                     FROM localizacao_geografica
                     LIMIT 1), (SELECT id
                                FROM regional_ufg
                                LIMIT 1)
);

INSERT INTO area_conhecimento (nome_area, codigo_area) VALUES
  ('nome da area', 1234);

insert into instancia_administrativa_ufg (
  sigla_instancia, nome, tipo, data_criacao, data_encerra, email_institucional, url_institucional) VALUES (
    'ES', 'Engenharia de Software', 'CURSO', now()::DATE, now()::DATE, 'email', 'url');

INSERT INTO curso_da_ufg (
  nivel, tipo_de_resolucao, numero_da_resolucao, e_presencial, turno, unidade_academica, area_conhecimento_nome, area_conhecimento_codigo, instancia_administrativa) VALUES (
  'BACHARELADO', 'CEPEC', 1234, TRUE, 'MATUTINO', (SELECT id
                                                   FROM unidade_academica_ufg
                                                   LIMIT 1), (select nome_area from area_conhecimento),
  (select codigo_area from area_conhecimento), (SELECT sigla_instancia from instancia_administrativa_ufg LIMIT 1));



INSERT INTO historico_na_ufg (
  numero_matricula_curso, mes_de_inicio, ano_de_inicio, mes_de_fim, ano_de_fim, titulo_do_trabalho_final, curso, id_egresso)
VALUES (118218, 10, 1998, 12, 2016, 'Não tem TCC', (select numero_da_resolucao FROM curso_da_ufg LIMIT 1), (select id from egresso));
