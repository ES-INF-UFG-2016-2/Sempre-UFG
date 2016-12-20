# Documento de Procedimentos - (Visao do Egresso Em Outras Instituições de Ensino)
 
## 1. Descrição do Artefato
|Artefato Avaliado| Descrição do Artefato |
|-----------------|-----------------------|
|DDL VisaoEgressoOutrasInstEnsino.sql|Implementação de linguagem de definição de dados (DDL) que integra as visões: EnsMedioEgres e CursOutrasIesEgres|
 
## 2. Critérios de Coberturas dos Testes
- Os testes devem ser aprovados independentemente do banco de dados utilziado (MariaDb e Postgres).
- Os testes implementados devem garantir que a DDL que implementa o requisito de dados está correta.
- Todas as implementações devem ser testadas.
- O artefato testado deve conter todos os dados necessários para a execução dos testes, bem como corresponder a especificação de requisitos.

## 3. Especificações dos testes
Esta seção abrange como os testes serão realizados, o que será testado e qual metodologia foi selecionada pra realizar os testes.
 
  ### 3.1 Metodologia de testes
 |Codigo|Descrição|Localização|Aplicabilidade|
 |------|---------|-----------|--------------|
 |RC1|Testador|Time de desenvolvimento|Responsável por executar os testes.|
 |RC2|Script DDL que contem a integração da visão do egresso em outras instituições.|.\Sempre-UFG\ db/ddl/VisaoEgressoOutrasInstEnsino.sql.|
 
 
 ### 3.2 Metodologia de testes
 Os testes serão realizados primeiramente atravéz de uma ferramenta online validadora de scripts DDL, de forma a verificar possíveis atravéz da ferramenta [SQL Fiddle](http://sqlfiddle.com/).
 
### 3.3 Procedimentos
- O diagrama de entidade e relacionamento definido no documento de Requisitos do Software SempreUFG é a base de criação dos casos de testes.
- O casos de testes foram aplicados na DDL que integra a visão do egresso em outras instituições disponibilizada no respositório do projeto, realizando a execução dos testes e coletando seus resultados.
- Os resultados coletados e analisados foram descritos no relatorio que descreve os resultados dos procedimentos.
- Os testes foram executados ambos manualmente e através da ferramenta SQL Fiddle.

### 3.4 Casos de Testes
#### 3.4.1 CheckList de Qualidade
Padrões simples que vão deixar a base de dados organizada e de fácil entendimento. Focando em melhorar a qualidade das estruturas de dados de uma maneira simples e eficiente.
- Não usar espaço em branco;
- Não usar hífen, acentos e caracteres especiais;
- Não usar palavras reservadas como: INSERT, DELETE, SELECT e etc.;
- Não usar verbos;
- Escrever em maiúsculo ou minúsculo;
- Não utilizar palavras no plural;
- Não usar preposições;
- Não usar números;
- Não usar nomes próprios;
- Separe os nomes com underline;
- Crie nomes sucintos e objetivos;

#### 3.4.2 CheckList Conformidade com Documentação e Diagramas
Verificação de alto nível da conformidade entres os artefatos que foram produzidos e o que era esperado segundo a documentação existente.

- Todas as tabelas existem;
- Todas as tabelas incluem os mesmos campos existentes na documentação;
- Todos os campos possuem dados iguais ou compatíveis com aqueles da documentação;
- Nenhuma tabela inclui campos não existentes na documentação e desnecessários;
- Todos os campos indicados como opcionais na documentação são opcionais nas tabelas;
- Relacionamentos existentes na documentação existem também nas tabelas;

#### 3.4.3 Entradas Válidas
**CT-1 . Conjunto de testes para verificar se as tabelas estão criadas no Banco de dados**

|Caso de Teste|Descrição|Entrada|Saida Esperada|
|-------------|---------|-------|--------------|
|CT-01|Arquivo DDL resulta na criação do conjunto de tabelas esperados|Arquivo DDl VisaoEgressoOutrasInstEnsino.sql|Tabelas criadas
|CT-02|Verificação da existência das tabelas egresso, Instituição de Ensino Médio, Curso de Outra IES, Localização Geografica, Historico em IEM e Histórico em Outra IES|show tables|curso_outra_ies, egresso, historico_ensino_medio, historico_outra_ies, inst_ensino_medio, localizacao_geografica|
|CT-03|Inserção de valores válidos para a tabela egresso |INSERT INTO EGRESSO VALUES (matricula = 122256, nome_oficial = 'Erivan Barbosa do Nascimento', nome_mae = 'Deusina Francisco do Nascimento', data_nascimento - 12/12/1990, sexo = 'masculino', email_alternativo = 'erivan.nas@email.com', foto_principal = E’\xDEADBEEF, fotos_adicionais = E’\xDEADBEEF, visibilidade_dados = 'Privado');.  SELECT * FROM EGRESSO WHERE MATRICULA = 122256) |Dados iguais aos inseridos|
|CT-04|Inserção de valores tabela egresso com ausencia de numero de matricula |INSERT INTO EGRESSO VALUES (nome_oficial = 'Erivan Barbosa do Nascimento', nome_mae = 'Deusina Francisco do Nascimento', data_nascimento - 12/12/1990, sexo = 'masculino', email_alternativo = 'erivan.nas@email.com', foto_principal = E’\xDEADBEEF, fotos_adicionais = E’\xDEADBEEF, visibilidade_dados = 'Privado');.  SELECT * FROM EGRESSO WHERE MATRICULA = 122256) |Comando Recusado|
|CT-05|Inserção de valores tabela egresso com ausencia de nome oficial|INSERT INTO EGRESSO VALUES (matricula = 122256, nome_mae = 'Deusina Francisco do Nascimento', data_nascimento - 12/12/1990, sexo = 'masculino', email_alternativo = 'erivan.nas@email.com', foto_principal = E’\xDEADBEEF, fotos_adicionais = E’\xDEADBEEF, visibilidade_dados = 'Privado');.  SELECT * FROM EGRESSO WHERE MATRICULA = 122256) |Comando Recusado|
|CT-06|Inserção de para a tabela egresso sem o nome da mãe |INSERT INTO EGRESSO VALUES (matricula = 122256, nome_oficial = 'Erivan Barbosa do Nascimento',data_nascimento - 12/12/1990, sexo = 'masculino', email_alternativo = 'erivan.nas@email.com', foto_principal = E’\xDEADBEEF, fotos_adicionais = E’\xDEADBEEF, visibilidade_dados = 'Privado');.|Comando Recusado|
|CT-07|Inserção de para a tabela egresso sem a da ta de nascimento |INSERT INTO EGRESSO VALUES (matricula = 122256, nome_oficial = 'Erivan Barbosa do Nascimento', nome_mae = 'Deusina Francisco do Nascimento', sexo = 'masculino', email_alternativo = 'erivan.nas@email.com', foto_principal = E’\xDEADBEEF, fotos_adicionais = E’\xDEADBEEF, visibilidade_dados = 'Privado');.|Comando Recusado|
|CT-08|Inserção de para a tabela egresso sem os campos não obrigatorios |INSERT INTO EGRESSO VALUES (matricula = 122256, nome_oficial = 'Erivan Barbosa do Nascimento', nome_mae = 'Deusina Francisco do Nascimento', data_nascimento = 12/12/1990); SELECT * FROM EGRESSO WHERE MATRICULA = 122256.|Dados preenchidos são exibidos, demais dados são exibidos em branco|
|CT-09|Inserção de dados validos para a tabela localizacao_geografica|INSERT INTO EGRESSO VALUES (cidade = 'goiania', unidade_federativa = 'Goiás', pais = 'Brasil', sigla_unidade_federativa = 'Go', latitute = 25, longitude = 25); SELECT * FROM locaizacao_geografica WHERE cidade = 'goiania' |Todos os dados são exibidos|
|CT-10|Inserção de dados validos para a tabela localizacao_geografica|INSERT INTO EGRESSO VALUES (cidade = 'goiania', unidade_federativa = 'Goiás', pais = 'Brasil', sigla_unidade_federativa = 'Go', latitute = 25, longitude = 25); SELECT * FROM locaizacao_geografica WHERE cidade = 'goiania' |Todos os dados são exibidos|
|CT-11|Inserção de dados invalidos para a tabela localizacao_geografica: ausencia de cidade|INSERT INTO EGRESSO VALUES (unidade_federativa = 'Goiás', pais = 'Brasil', sigla_unidade_federativa = 'Go', latitute = 25, longitude = 25); SELECT * FROM locaizacao_geografica WHERE cidade = 'goiania' |Comando Recusado|
|CT-12|Inserção de dados invalidos para a tabela localizacao_geografica: unidade federativa ausente|INSERT INTO EGRESSO VALUES (cidade = 'goiania', pais = 'Brasil', sigla_unidade_federativa = 'Go', latitute = 25, longitude = 25); SELECT * FROM locaizacao_geografica WHERE cidade = 'goiania' |Comando Recusado|
|CT-13|Inserção de dados invvalidos para a tabela localizacao_geografica: ausencia de pais|INSERT INTO EGRESSO VALUES (cidade = 'goiania', unidade_federativa = 'Goiás', sigla_unidade_federativa = 'Go', latitute = 25, longitude = 25); SELECT * FROM locaizacao_geografica WHERE cidade = 'goiania' |Comando Recusado|
|CT-14|Inserção de dados invvalidos para a tabela localizacao_geografica: ausencia de sigla da unidade federativa|INSERT INTO EGRESSO VALUES (cidade = 'goiania', unidade_federativa = 'Goiás', pais = 'Brasil', latitute = 25, longitude = 25); SELECT * FROM locaizacao_geografica WHERE cidade = 'goiania' |Comando Recusado|
|CT-15|Inserção de dados validos para a tabela localizacao_geografica: ausencia de latitude e longitude|INSERT INTO EGRESSO VALUES (cidade = 'goiania', unidade_federativa = 'Goiás', pais = 'Brasil', sigla_unidade_federativa = 'Go', latitute = 25, longitude = 25); SELECT * FROM locaizacao_geografica WHERE cidade = 'goiania' |Todos os dados são exibidos, com exceção de latitude e longitude|
|CT-16|Inserção de dados validos para a tabela inst_ensino_medio|INSERT INTO INST_ENSINO_MEDIO VALUES (id_localizacao = 1, nome_inst_ensino_medio = 'Colegio Estadual Robinho de Souza', tipo_inst_ensino_medio = 'Estadual'); SELECT * FROM ID INST_ENSINO_MEDIO WHERE nome_inst_ensino_medio = 'Colegio Estadual Robinho de Souza'  |Todos os dados são exibidos|
|CT-17|Inserção de dados invalidos para a tabela inst_ensino_medio: localizacao inexistente (violação de chave estrangeira)|INSERT INTO INST_ENSINO_MEDIO VALUES (id_localizacao = 67, nome_inst_ensino_medio = 'Colegio Estadual Robinho de Souza', tipo_inst_ensino_medio = 'Estadual'); |Comando Recusado|
|CT-18|Inserção de dados invalidos para a tabela inst_ensino_medio: ausencia de nome|INSERT INTO INST_ENSINO_MEDIO VALUES (id_localizacao = 1, tipo_inst_ensino_medio = 'Estadual');|Comando Recusado|
|CT-19|Inserção de dados validos para a tabela historico_ensino_medio|INSERT INTO historico_ensino_medio VALUES (id_egresso = 1, id_inst_ensino_medio = 1, mes_inicio = 1, anos_inicio: 1990, mes_fim = 12, ano_fim = 2000 ); SELECT * FROM HISTORICO_ENSINO_MEDIO WHERE id_egresso = 1|Todos os dados são exibidos|
|CT-20|Inserção de dados invalidos para a tabela historico_ensino_medio: id egresso e id instituição de ensino médio ausentes (violação de campos não nulos e de chave estrangeira)|INSERT INTO historico_ensino_medio VALUES (mes_inicio = 1, anos_inicio: 1990, mes_fim = 12, ano_fim = 2000 );|Comando Recusado|
|CT-21|Inserção de dados invalidos para a tabela historico_ensino_medio: Meses e anos de inicio e fim ausentes (violação de campos não nulos)|INSERT INTO historico_ensino_medio VALUES (id_egresso = 1, id_inst_ensino_medio = 1);|Comando Recusado|

Tabela "curso_outra_ies" não teve casos de teste criados porque estava fora do padrão da documentação.
Tabela "historico_outra_ies" não teve casos de teste criados porque dependia da tabela "curso_utra_ies".
