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
