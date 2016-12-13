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
 |CT-1.5| * | Verifica se a tabela referente a unidade acadêmica existe.|SELEC * FROM UNIDADE_ACADEMICA| true|
 |CT-1.6| * | Verifica se a tabela referente ao curso da ufg existe.| SELECT * FROM CURSO_DA_UFG|true|
 |CT-1.7| * | Verifica se a tabela referente histórico na ufg existe.|SELECT * FROM HISTORICO_NA_UFG| true|
 |CT-1.8| *| Verifica se a tabela referente a a avaliação do cursos por parte do egresso existe.|SELECT * FROM AVALIACAO_DO_CURSO_PELO_EGRESSO|true|
 |CT-1.9|*|Verifica se a tabela referente a realização de programas acadêmicos existe.|SELECT * FROM REALIZACAO_DE_PROGRAMA_ACADEMICO|true|
 
 **CT-2. Conjunto de testes para verificar se as tabelas estão aceitando os dados validos corretamente, e com entradas com todos os campos obrigatorios e opcionais**
 
 |Caso de Teste|Pré-condições|Descrição|Entrada|Resultado Esperado|
 |-------------|-------------|------------|-------|---------|
 |CT-2.1|Tabela area_de_conhecimento existente.|Realiza a inserção de dados de area_de_conhecimento com todos os dados validos, campos obrigatorios e campos opcionais.| INSERT INTO area_de_conhecimento VALUES nome = ‘Kleudson’, codigo = ‘100’, super_area = ‘200'|true|

 **Casos de teste para Importação de Dados de Egressos**
 
 #### 3.3.3 Entradas Inválidas
 
  CT1.1 - nome do caso de teste
  Descrição: definicao do caso de teste
  Entrada: valor que sera dado como entrada para se ter a saida esperada.
  Saida Esperada: valor desejavel para a saida do artefato testado.
  Recurso: REC1