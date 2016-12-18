# Documento de Procedimentos - (Visão do Egresso na UFG)
 
 ## 1. Descrição do Artefato
 |Artefato Avaliado| Descrição do Artefato |
 |-----------------|-----------------------|
 |DDl Visao do Egresso na UFG|Implementação da DDL que integra os RD's: PessoaEgres e CursUfgEgres, que formam a visão de Egresso na UFG|
 
 ## 2. Critérios de Coberturas dos Testes
 - Os testes implementados devem garantir que a DDL que implementa o requisito de dados está correta.
 - Todas as implementações devem ser testadas.
 - Os testes devem ser aprovados independentemente do banco de dados utilziado (MariaDb e Postgres).
 - O artefato testado deve conter todos os dados necessários para a execução dos testes, bem como corresponder a especificação de requisitos.
 
 ## 3. Especificação dos Testes
 Nesta parte do documento devem ser descritos os procedimentos e os casos de teste a serem aplicados. Dar um identificador para o conjunto de testes
 
 ### 3.1 Recursos
 |Codigo|Descrição|Localização|Aplicabilidade|
 |------|---------|-----------|--------------|
 |RC1|Kleudson|Time de desenvolvimento|Responsável por executar os testes.|
 |RC2|Script DML com todos os comandos utilizados nos testes para testar a DDL que integra a visão do egresso no sistema SempreUFG.|.\Sempre-UFG\db\|Testes manuais de banco de dados.|
 
 ### 3.2 Procedimentos
 - O diagrama de entidade e relacionamento definido no documento de Requisitos do Software SempreUFG é a base de criação dos casos de testes.
 - O casos de testes foram aplicados na DDL que integra a visão do egresso na ufg disponibilizada no respositório do projeto, realizando a execução dos testes e coletando seus resultados.
 - Os resultados coletados e analisados foram descritos no relatorio que descreve os resultados dos procedimentos.
 - Os testes foram executados manualmente.
 
 ### 3.3 Casos de Testes
 #### 3.3.1 CheckList de Qualidade
 Padrões simples que vão deixar a base de dados organizada e de fácil entendimento. Focando em melhorar a qualidade das estruturas de dados de uma maneira simples e eficiente.
 - Não usar espaço em branco;
 - Não usar hífen, acentos e caracteres especiais;
 - Não usar palavras reservadas como: INSERT, DELETE, SELECT e etc.;
 - Não usar mais que 30(trinta) caracteres;
 - Não usar verbos;
 - Escrever em maiúsculo ou minúsculo;
 - Não utilizar palavras no plural;
 - Não usar preposições;
 - Não usar números;
 - Não usar nomes próprios;
 - Separe os nomes com underline;
 - Crie nomes sucintos e objetivos;
 - O nome não pode ter várias interpretações;
 
 #### 3.3.2 Entradas Válidas
 **CT-1 . Conjunto de testes para verificar se as tabelas estão criadas no Banco de dados**
 
 |Caso de Teste|Pré-condições|Descrição|Entrada|Resultado Esperado|
 |-------------|-------------|------------|-------|---------|
 |CT-1.1|Banco de dados funcionando corretamente.|Verifica se a tabela referente aos dados do egresso de PessoaEgres.|SELECT * FROM EGRESSO| true|
 |CT-1.2| * | Verifica se a tabela referente A PessoaEgres existe.|SELECT * FROM RESIDENCIA| true|
 |CT-1.3| * | Verifica se a tabela referente a localização geográfica existe.|SELECT * FROM LOCALIZACAO_GEOGRAFICA | true|
 |CT-1.4|* |Verifica se a tabela referente a área de conhecimento existe.|SELECT * FROM AREA_DE_CONHECIMENTO| true|
 |CT-1.5| * | Verifica se a tabela referente a unidade acadêmica existe.|SELECT * FROM UNIDADE_ACADEMICA| true|
 |CT-1.6| * | Verifica se a tabela referente ao curso da ufg existe.| SELECT * FROM CURSO_DA_UFG|true|
 |CT-1.7| * | Verifica se a tabela referente histórico na ufg existe.|SELECT * FROM HISTORICO_NA_UFG| true|
 |CT-1.8| *| Verifica se a tabela referente a a avaliação do cursos por parte do egresso existe.|SELECT * FROM AVALIACAO_DO_CURSO_PELO_EGRESSO|true|
 |CT-1.9|*|Verifica se a tabela referente a realização de programas acadêmicos existe.|SELECT * FROM REALIZACAO_DE_PROGRAMA_ACADEMICO|true|
 
 **CT-2. Conjunto de testes para verificar se as tabelas estão aceitando os dados validos corretamente, e com entradas com todos os campos obrigatorios e opcionais**
 
 |Caso de Teste|Pré-condições|Descrição|Entrada|Resultado Esperado|
 |-------------|-------------|------------|-------|---------|
 |CT-2.1|Tabela EGRESSO existente.|Realiza a inserção de dados de egresso com todos os dados validos e campos obrigatorios.| INSERT INTO EGRESSO (ID, NOME, NOME_MAE, DATA_NASCIMENTO, FOTO_PRINCIPAL, FOTO_ADICIONAIS, VISIBILIDADE, SEXO) VALUES (2, 'Kleudson Rodrigues de Souza', 'Aparecida Pereira de Souza', '24-01-2010', E'\\xDEADCEEF', null, 'publico', 'masculino')|true|
|CT-2.2|Tabela RESIDENCIA existente.|Realiza inserção de dados de uma residencia com todos os dados validos, campos obrigatorios e campos opcionais|INSERT INTO RESIDENCIA (DATA_INICIO, DATA_FIM, ENDERECO) VALUES ('14-12-2016', '15-12-2016', 'Av. Floresta, Qd. 15 Lt. 16')|true|
 |CT-2.3|Tabela LOCALIZACAO_GEOGRAFICA existente.|Realiza inserção de dados em na tabela localizacao_geografica com todos os dados validos, campos obrigatorios e campos opcionais.|INSERT INTO LOCALIZACAO_GEOGRAFICA (ID, NOME_CIDADE, NOME_UNIDADE_FEDERATIVA, NOME_PAIS, SIGLA, LATITUDE, LONGITUDE) VALUES ('1', 'Goiânia', 'Goiás', 'Brasil', 'BR', '-16.603402', '-49.266637')|true|
 |CT-2.4|Tabela AREA_DE_CONHECIMENTO existente.|Realiza a inserção de dados na ta tabela area_de_conhecimento com todos os dados validos, campos obrigatorios e campos opcionais.|INSERT INTO AREA_DE_CONHECIMENTO (NOME, CODIGO, SUPER_AREA) VALUES ('Informática', 1, 1)|true|
 |CT-2.5|Tabela UNIDADE_ACADEMICA existente.|Realiza a inserção de dados com todos os dados validos, campos obrigatorios e campos opcionais.|INSERT INTO UNIDADE_ACADEMICA (ID) VALUES (1)|true|
 |CT-2.6|Tabela CURSO_DA_UFG existente.|Realiza a inserção de dados dos cursos da ufg, com todos os dados validos, campos obrigatorios e campos opcionais.|INSERT INTO CURSO_DA_UFG (NIVEL, TIPO_DE_RESOLUCAO, NUMERO_DA_RESOLUCAO, E_PRESENCIAL, TURNO, UNIDADE_ACADEMICA, AREA_DE_CONHECIMENTO) VALUES ('Bacharelado', 'CONSUNI', 1, TRUE, 'Matutino', 1, 1)|true|
 |CT-2.7|Tabela HISTORICO_NA_UFG existente.|Realiza a inserção de dados na tabela histórico na ufg, campos obrigatorios e campos opcionais.|INSERT INTO HISTORICO_NA_UFG (NUMERO_MATRICULA_CURSO, MES_DE_INICIO, ANO_DE_INICIO, MES_DE_FIM, ANO_DE_FIM, TITULO_DO_TRABALHO_FINAL, CURSO, ID_EGRESSO) VALUES (201392248, 01, 2011, 12, 2016, 'A Engenharia de Software no Dia-a-Dia', 1, 1)|true|
 |CT-2.8|Tabela AVALIACAO_DO_CURSO_PELO_EGRESSO existente.|Realiza inserção de dados da avaliação do curso pelo egresso de todos os dados validos, campos obrigatorios e campos opcionais.|INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO (HISTORICO, DATA_AVALIACAO, MOTIVACAO_ESCOLHA, SATISFACAO_CURSO, CONCEITO_GLOBAL_CURSO, PREPARACAO_PARA_MERCADO, MELHORIA_CAPACIDADE_COMUNICACAO, CAPACIDADE_ETICA_RESPONSABILIADE, CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO, COMENTARIO) VALUES (201392248, '01-12-2016', 'Qualidade/Reputacao do Curso', 10, 10, 10, 10, 10, 10, 'Comentário sobre o curso de Engenharia de Software')|true|
 |CT-2.9|Tabela REALIZACAO_DE_PROGRAMA_ACADEMICO existente.|Realiza inserção de dados da realização do programa acadêmico com todos os dados validos, campos obrigatorios e campos opcionais.|INSERT INTO REALIZACAO_DE_PROGRAMA_ACADEMICO (HISTORICO, TIPO, DATA_INICIO, DATA_FIM, DESCRICAO) VALUES (201392248, 'Iniciacao_Cientifica', '02-12-2016', '02-01-2017', 'Descrição do Programa Acadêmico')|true|

#### 3.3.3 Entradas Inválidas
 
 **CT-3. Conjunto de testes para verificar se as tabelas estão sendo tratadas para não receber dados faltantes.**
 
 |Caso de Teste|Pré-condições|Descrição|Entrada|Resultado Esperado|
 |-------------|-------------|------------|-------|---------|
 |CT-3.1|Tabela EGRESSO existente.|Realiza a inserção de dados de um EGRESSO com id faltando.| INSERT INTO EGRESSO (NOME, NOME_MAE, DATA_NASCIMENTO, FOTO_PRINCIPAL, FOTO_ADICIONAIS, VISIBILIDADE, SEXO) VALUES ('Kleudson Rodrigues de Souza', 'Aparecida Pereira de Souza', '24-01-2010', E'\\xDEADCEEF', null, 'publico', 'masculino')|true|
 |CT-3.2|Tabela EGRESSO existente.|Realiza a inserção de dados de um usuário com nome faltando.| INSERT INTO EGRESSO (ID, NOME_MAE, DATA_NASCIMENTO, FOTO_PRINCIPAL, FOTO_ADICIONAIS, VISIBILIDADE, SEXO) VALUES (10, 'Aparecida Pereira de Souza', '24-01-2010', E'\\xDEADCEEF', null, 'publico', 'masculino')|true|
 |CT-3.3|Tabela EGRESSO existente.|Realiza a inserção de dados de um usuário com nome da mãe faltando.| INSERT INTO EGRESSO (ID, NOME, DATA_NASCIMENTO, FOTO_PRINCIPAL, FOTO_ADICIONAIS, VISIBILIDADE, SEXO) VALUES (2, 'Kleudson Rodrigues de Souza', '24-01-2010', E'\\xDEADCEEF', null, 'publico', 'masculino')|true|
 |CT-3.4|Tabela EGRESSO existente.|Realiza a inserção de dados de um usuário com data de nascimento faltando..|INSERT INTO EGRESSO (ID, NOME, NOME_MAE, FOTO_PRINCIPAL, FOTO_ADICIONAIS, VISIBILIDADE, SEXO) VALUES (2, 'Kleudson Rodrigues de Souza', 'Aparecida Pereira de Souza', E'\\xDEADCEEF', null, 'publico', 'masculino')|true|
 |CT-3.5|Tabela RESIDENCIA existente.|Realiza inserção de dados de residência com data de início faltando.|INSERT INTO RESIDENCIA (DATA_FIM, ENDERECO) VALUES ('15-12-2016', 'Av. Floresta, Qd. 15 Lt. 16')|true|
 |CT-3.6|Tabela RESIDENCIA existente.|Realiza inserção de dados de residência com endereço faltando.|INSERT INTO RESIDENCIA (DATA_INICIO, DATA_FIM) VALUES ('14-12-2016', '15-12-2016')|true|
 |CT-3.7|Tabela LOCALIZACAO_GEOGRAFICA existente.|Realiza a inserção de dados de localização geográfica com id faltando.|INSERT INTO LOCALIZACAO_GEOGRAFICA (NOME_CIDADE, NOME_UNIDADE_FEDERATIVA, NOME_PAIS, SIGLA, LATITUDE, LONGITUDE) VALUES ('Goiânia', 'Goiás', 'Brasil', 'BR', '-16.603402', '-49.266637')|true|
 |CT-3.8|Tabela LOCALIZACAO_GEOGRAFICA existente.|Realiza a inserção de dados de localização geográfica com nome da cidade faltando.|INSERT INTO LOCALIZACAO_GEOGRAFICA (ID, NOME_UNIDADE_FEDERATIVA, NOME_PAIS, SIGLA, LATITUDE, LONGITUDE) VALUES (1, 'Goiás', 'Brasil', 'BR', '-16.603402', '-49.266637')|true|
 |CT-3.9|Tabela LOCALIZACAO_GEOGRAFICA existente.|Realiza a inserção de dados de localização geográfica com nome da unidade federativa faltando.|INSERT INTO LOCALIZACAO_GEOGRAFICA (ID, NOME_CIDADE, NOME_PAIS, SIGLA, LATITUDE, LONGITUDE) VALUES (1, 'Goiânia', 'Brasil', 'BR', '-16.603402', '-49.266637')|true|
 |CT-3.10|Tabela LOCALIZACAO_GEOGRAFICA existente.|Realiza a inserção de dados de localização geográfica com nome do país faltando.|INSERT INTO LOCALIZACAO_GEOGRAFICA (ID, NOME_CIDADE, NOME_UNIDADE_FEDERATIVA, SIGLA, LATITUDE, LONGITUDE) VALUES (1, 'Goiânia', 'Goiás', 'BR', '-16.603402', '-49.266637')|true|
 |CT-3.11|Tabela LOCALIZACAO_GEOGRAFICA existente.|Realiza a inserção de dados de localização geográfica com sigla faltando.|INSERT INTO LOCALIZACAO_GEOGRAFICA (ID, NOME_CIDADE, NOME_UNIDADE_FEDERATIVA, NOME_PAIS, LATITUDE, LONGITUDE) VALUES (1, 'Goiânia', 'Goiás', 'Brasil', '-16.603402', '-49.266637')|true|
 |CT-3.12|Tabela AREA_DE_CONHECIMENTO existente.|Realiza a inserção de dados de uma área de conhecimento com nome faltando.|INSERT INTO AREA_DE_CONHECIMENTO (CODIGO, SUPER_AREA) VALUES (1, 1)|true|
 |CT-3.13|Tabela AREA_DE_CONHECIMENTO existente.|Realiza a inserção de dados de uma área de conhecimento com código faltando.|INSERT INTO AREA_DE_CONHECIMENTO (NOME, SUPER_AREA) VALUES ('Informática', 1)|true|
 |CT-3.14|Tabela CURSO_DA_UFG existente.|Realiza inserção de curso da ufg com nivel faltando.|INSERT INTO CURSO_DA_UFG (TIPO_DE_RESOLUCAO, NUMERO_DA_RESOLUCAO, E_PRESENCIAL, TURNO, UNIDADE_ACADEMICA, AREA_DE_CONHECIMENTO) VALUES ('CONSUNI', 1, TRUE, 'Matutino', 1, 1)|true|
 |CT-3.15|Tabela CURSO_DA_UFG existente.|Realiza inserção de curso da ufg com tipo de resolução faltando.|INSERT INTO CURSO_DA_UFG (NIVEL,  NUMERO_DA_RESOLUCAO, E_PRESENCIAL, TURNO, UNIDADE_ACADEMICA, AREA_DE_CONHECIMENTO) VALUES ('Bacharelado', 1, TRUE, 'Matutino', 1, 1)|true|
 |CT-3.16|Tabela CURSO_DA_UFG existente.|Realiza inserção de curso da ufg com numero da resolução faltando.|INSERT INTO CURSO_DA_UFG (NIVEL, TIPO_DE_RESOLUCAO, E_PRESENCIAL, TURNO, UNIDADE_ACADEMICA, AREA_DE_CONHECIMENTO) VALUES ('Bacharelado', 'CONSUNI', TRUE, 'Matutino', 1, 1)|true|
 |CT-3.17|Tabela CURSO_DA_UFG existente.|Realiza inserção de curso da ufg com a verificação se é presencial faltando.|INSERT INTO CURSO_DA_UFG (NIVEL, TIPO_DE_RESOLUCAO, NUMERO_DA_RESOLUCAO, TURNO, UNIDADE_ACADEMICA, AREA_DE_CONHECIMENTO) VALUES ('Bacharelado', 'CONSUNI', 1, 'Matutino', 1, 1)|true|
 |CT-3.18|Tabela CURSO_DA_UFG existente.|Realiza inserção de curso da ufg com turno faltando.|INSERT INTO CURSO_DA_UFG (NIVEL, TIPO_DE_RESOLUCAO, NUMERO_DA_RESOLUCAO, E_PRESENCIAL, UNIDADE_ACADEMICA, AREA_DE_CONHECIMENTO) VALUES ('Bacharelado', 'CONSUNI', 1, TRUE, 1, 1)|true|
 |CT-3.19|Tabela CURSO_DA_UFG existente.|Realiza inserção de curso da ufg com unidade acadêmica faltando.|INSERT INTO CURSO_DA_UFG (NIVEL, TIPO_DE_RESOLUCAO, NUMERO_DA_RESOLUCAO, E_PRESENCIAL, TURNO, AREA_DE_CONHECIMENTO) VALUES ('Bacharelado', 'CONSUNI', 1, TRUE, 'Matutino', 1)|true|
 |CT-3.20|Tabela CURSO_DA_UFG existente.|Realiza inserção de curso da ufg com área de conhecimento faltando.|INSERT INTO CURSO_DA_UFG (NIVEL, TIPO_DE_RESOLUCAO, NUMERO_DA_RESOLUCAO, E_PRESENCIAL, TURNO, UNIDADE_ACADEMICA) VALUES ('Bacharelado', 'CONSUNI', 1, TRUE, 'Matutino', 1)|true|
 |CT-3.21|Tabela HISTORICO_NA_UFG existente.|Realiza inserção de dados de histórico com número da matrícula do curso faltando.|INSERT INTO HISTORICO_NA_UFG (MES_DE_INICIO, ANO_DE_INICIO, MES_DE_FIM, ANO_DE_FIM, TITULO_DO_TRABALHO_FINAL, CURSO, ID_EGRESSO) VALUES (01, 2011, 12, 2016, 'A Engenharia de Software no Dia-a-Dia', 1, 1)|true|
 |CT-3.22|Tabela HISTORICO_NA_UFG existente.|Realiza inserção de dados de histórico com mês de início faltando.|INSERT INTO HISTORICO_NA_UFG (NUMERO_MATRICULA_CURSO, ANO_DE_INICIO, MES_DE_FIM, ANO_DE_FIM, TITULO_DO_TRABALHO_FINAL, CURSO, ID_EGRESSO) VALUES (201392248, 2011, 12, 2016, 'A Engenharia de Software no Dia-a-Dia', 1, 1)|true|
 |CT-3.23|Tabela HISTORICO_NA_UFG existente.|Realiza inserção de dados de histórico com ano de início faltando.|INSERT INTO HISTORICO_NA_UFG (NUMERO_MATRICULA_CURSO, MES_DE_INICIO, MES_DE_FIM, ANO_DE_FIM, TITULO_DO_TRABALHO_FINAL, CURSO, ID_EGRESSO) VALUES (201392248, 01, 12, 2016, 'A Engenharia de Software no Dia-a-Dia', 1, 1)|true|
 |CT-3.24|Tabela HISTORICO_NA_UFG existente.|Realiza inserção de dados de histórico com mês de fim faltando.|INSERT INTO HISTORICO_NA_UFG (NUMERO_MATRICULA_CURSO, MES_DE_INICIO, ANO_DE_INICIO, ANO_DE_FIM, TITULO_DO_TRABALHO_FINAL, CURSO, ID_EGRESSO) VALUES (201392248, 01, 2011, 2016, 'A Engenharia de Software no Dia-a-Dia', 1, 1)|true|
 |CT-3.25|Tabela HISTORICO_NA_UFG existente.|Realiza inserção de dados de histórico com ano de fim faltando.|INSERT INTO HISTORICO_NA_UFG (NUMERO_MATRICULA_CURSO, MES_DE_INICIO, ANO_DE_INICIO, MES_DE_FIM, TITULO_DO_TRABALHO_FINAL, CURSO, ID_EGRESSO) VALUES (201392248, 01, 2011, 12, 'A Engenharia de Software no Dia-a-Dia', 1, 1)|true|
 |CT-3.26|Tabela HISTORICO_NA_UFG existente.|Realiza inserção de dados de histórico com título do trabalho final faltando.|INSERT INTO HISTORICO_NA_UFG (NUMERO_MATRICULA_CURSO, MES_DE_INICIO, ANO_DE_INICIO, MES_DE_FIM, ANO_DE_FIM, CURSO, ID_EGRESSO) VALUES (201392248, 01, 2011, 12, 2016, 1, 1)|true|
 |CT-3.27|Tabela HISTORICO_NA_UFG existente.|Realiza inserção de dados de histórico com curso faltando.|INSERT INTO HISTORICO_NA_UFG (NUMERO_MATRICULA_CURSO, MES_DE_INICIO, ANO_DE_INICIO, MES_DE_FIM, ANO_DE_FIM, TITULO_DO_TRABALHO_FINAL, ID_EGRESSO) VALUES (201392248, 01, 2011, 12, 2016, 'A Engenharia de Software no Dia-a-Dia', 1)|true|
 |CT-3.28|Tabela HISTORICO_NA_UFG existente.|Realiza inserção de dados de histórico com id do egresso faltando.|INSERT INTO HISTORICO_NA_UFG (NUMERO_MATRICULA_CURSO, MES_DE_INICIO, ANO_DE_INICIO, MES_DE_FIM, ANO_DE_FIM, TITULO_DO_TRABALHO_FINAL, CURSO) VALUES (201392248, 01, 2011, 12, 2016, 'A Engenharia de Software no Dia-a-Dia', 1)|true|