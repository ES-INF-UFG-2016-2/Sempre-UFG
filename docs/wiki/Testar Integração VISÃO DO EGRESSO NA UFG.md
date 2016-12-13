# Documento de Procedimentos - (Vis�o do Egresso na UFG)
 
 ## 1. Descri��o do Artefato
 |Artefato Avaliado| Descri��o do Artefato |
 |-----------------|-----------------------|
 |DDl Visao do Egresso na UFG|Implementa��o da DDL que integra os RD's: PessoaEgres e CursUfgEgres, que formam a vis�o de Egresso na UFG|
 
 ## 2. Crit�rios de Coberturas dos Testes
 - Os testes implementados devem garantir que a DDL que implementa o requisito de dados est� correta.
 - Todas as implementa��es devem ser testadas.
 - Os testes devem ser aprovados independentemente do banco de dados utilziado (MariaDb e Postgres).
 - O artefato testado deve conter todos os dados necess�rios para a execu��o dos testes, bem como corresponder a especifica��o de requisitos.
 
 ## 3. Especifica��o dos Testes
 Nesta parte do documento devem ser descritos os procedimentos e os casos de teste a serem aplicados. Dar um identificador para o conjunto de testes
 
 ### 3.1 Recursos
 |Codigo|Descri��o|Localiza��o|Aplicabilidade|
 |------|---------|-----------|--------------|
 |RC1|Kleudson|Time de desenvolvimento|Respons�vel por executar os testes.|
 |RC2|Script DML com todos os comandos utilizados nos testes para testar a DDL que integra a vis�o do egresso no sistema SempreUFG.|.\Sempre-UFG\db\|Testes manuais de banco de dados.|
 
 ### 3.2 Procedimentos
 - O diagrama de entidade e relacionamento definido no documento de Requisitos do Software SempreUFG � a base de cria��o dos casos de testes.
 - O casos de testes foram aplicados na DDL que integra a vis�o do egresso na ufg disponibilizada no resposit�rio do projeto, realizando a execu��o dos testes e coletando seus resultados.
 - Os resultados coletados e analisados foram descritos no relatorio que descreve os resultados dos procedimentos.
 - Os testes foram executados manualmente.
 
 ### 3.3 Casos de Testes
 #### 3.3.1 CheckList de Qualidade
 Padr�es simples que v�o deixar a base de dados organizada e de f�cil entendimento. Focando em melhorar a qualidade das estruturas de dados de uma maneira simples e eficiente.
 - N�o usar espa�o em branco;
 - N�o usar h�fen, acentos e caracteres especiais;
 - N�o usar palavras reservadas como: INSERT, DELETE, SELECT e etc.;
 - N�o usar mais que 30(trinta) caracteres;
 - N�o usar verbos;
 - Escrever em mai�sculo ou min�sculo;
 - N�o utilizar palavras no plural;
 - N�o usar preposi��es;
 - N�o usar n�meros;
 - N�o usar nomes pr�prios;
 - Separe os nomes com underline;
 - Crie nomes sucintos e objetivos;
 - O nome n�o pode ter v�rias interpreta��es;
 
 #### 3.3.2 Entradas V�lidas
 **CT-1 . Conjunto de testes para verificar se as tabelas est�o criadas no Banco de dados**
 
 |Caso de Teste|Pr�-condi��es|Descri��o|Entrada|Resultado Esperado|
 |-------------|-------------|------------|-------|---------|
 |CT-1.1|Banco de dados funcionando corretamente.|Verifica se a tabela referente aos dados do egresso de PessoaEgres.|SELECT * FROM EGRESSO| true|
 |CT-1.2| * | Verifica se a tabela referente A PessoaEgres existe.|SELECT * FROM RESIDENCIA| true|
 |CT-1.3| * | Verifica se a tabela referente a localiza��o geogr�fica existe.|SELECT * FROM LOCALIZACAO_GEOGRAFICA | true|
 |CT-1.4|* |Verifica se a tabela referente a �rea de conhecimento existe.|SELECT * FROM AREA_DE_CONHECIMENTO| true|
 |CT-1.5| * | Verifica se a tabela referente a unidade acad�mica existe.|SELEC * FROM UNIDADE_ACADEMICA| true|
 |CT-1.6| * | Verifica se a tabela referente ao curso da ufg existe.| SELECT * FROM CURSO_DA_UFG|true|
 |CT-1.7| * | Verifica se a tabela referente hist�rico na ufg existe.|SELECT * FROM HISTORICO_NA_UFG| true|
 |CT-1.8| *| Verifica se a tabela referente a a avalia��o do cursos por parte do egresso existe.|SELECT * FROM AVALIACAO_DO_CURSO_PELO_EGRESSO|true|
 |CT-1.9|*|Verifica se a tabela referente a realiza��o de programas acad�micos existe.|SELECT * FROM REALIZACAO_DE_PROGRAMA_ACADEMICO|true|
 
 **CT-2. Conjunto de testes para verificar se as tabelas est�o aceitando os dados validos corretamente, e com entradas com todos os campos obrigatorios e opcionais**
 
 |Caso de Teste|Pr�-condi��es|Descri��o|Entrada|Resultado Esperado|
 |-------------|-------------|------------|-------|---------|
 |CT-2.1|Tabela area_de_conhecimento existente.|Realiza a inser��o de dados de area_de_conhecimento com todos os dados validos, campos obrigatorios e campos opcionais.| INSERT INTO area_de_conhecimento VALUES nome = �Kleudson�, codigo = �100�, super_area = �200'|true|

 **Casos de teste para Importa��o de Dados de Egressos**
 
 #### 3.3.3 Entradas Inv�lidas
 
  CT1.1 - nome do caso de teste
  Descri��o: definicao do caso de teste
  Entrada: valor que sera dado como entrada para se ter a saida esperada.
  Saida Esperada: valor desejavel para a saida do artefato testado.
  Recurso: REC1