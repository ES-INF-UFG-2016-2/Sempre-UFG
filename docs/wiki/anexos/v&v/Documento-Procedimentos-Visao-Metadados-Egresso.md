# Documento de Procedimentos - (Visao de Metadados do Egresso)

## 1. Descrição do Artefato
|Artefato Avaliado| Descrição do Artefato |
|-----------------|-----------------------|
|DDL MetaEgres|Implementação da DDL que integra as visões: egresso na UFG, egresso em outras instituições de ensino e atuação profissional do egresso|

## 2. Critérios de Coberturas dos Testes
- Os testes devem ser aprovados independentemente do banco de dados utilziado (MariaDb e Postgres).
- Os testes implementados devem garantir que a DDL que implementa o requisito de dados está correta.
- Todas as implementações devem ser testadas.
- O artefato testado deve conter todos os dados necessários para a execução dos testes, bem como corresponder a especificação de requisitos.

## 3. Especificações dos testes
Esta seção abrange como os testes serão realizados, o que será testado e qual metodologia foi selecionada pra realizar os testes.

### 3.1 Metodologia de testes
Os testes serão realizados primeiramente atravéz de uma ferramenta online validadora de scripts DDL, de forma a verificar possíveis atravéz da ferramenta [SQL Fiddle](http://sqlfiddle.com/).

### 3.2 Procedimentos
- O diagrama de entidade e relacionamento definido no documento de Requisitos do Software SempreUFG é a base de criação dos casos de testes.
- O casos de testes foram aplicados na DDL que integra a visão de Metadados do Egresso disponibilizada no respositório do projeto, realizando a execução dos testes e coletando seus resultados.
- Os resultados coletados e analisados foram descritos no relatorio que descreve os resultados dos procedimentos.
- Os testes foram executados ambos manualmente e através da ferramenta SQL Fiddle.

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
|CT-1.1|Banco de dados funcionando corretamente.|Verifica se a tabela referente a importação de dados de egressos existe.|SELECT * FROM IMPORTACAO_EGRESSO| true|



