# Documento de Procedimentos - (RD-GestImport)

## 1. Descrição do Artefato

|Artefato Avaliado| Descrição do Artefato |
|-----------------|-----------------------|
|Codigo de Testes RD-GestImport|Implementação dos testes unitários referente ao RD-GestImport.|

## 2. Critérios de Coberturas dos Testes

- Os testes implementados devem garantir que a DDL que implementa o requisito de dados GestImport esta correto.
- Todos os testes implementados devem ser verificados.
- Os testes devem passar independentemente do banco de dados configurado.
- O artefato testado deverá conter todos os dados necessários para a execução dos testes, bem como corresponder a especificação de requisitos.

## 3. Especificação dos Testes
### 3.1 Procedimentos
- O diagrama de entidade e relacionamento definido no documento de Requisitos do Software SempreUFG e as classes que implementam os teste referente ao rd-gestImport são as bases para realizar os testes.
- O casos de testes foram aplicados nas classes geradas na implementação dos testes do RD-GestImport, disponibilziadas no respositório do projeto, realizando a execução dos testes implementados e colhendo seus resultados, e analizando o codigo de teste.
- Os resultados coletados e analisados foram descritos no Relatório dos testes.
- Quaisquer problemas ocorridos na execução dos sera informado no cartão da tarefa no Trello. Marcando o gerente do projeto bem como o responsável pela implementação dos teste do requisito.

### 3.3 Casos de Testes
#### 3.3.1 Entradas Válidas
|Caso de Teste|Descrição|Entrada|Saida Esperada|
|-------------|---------|-------|--------------|
|CT1.1|Timestamp da execução da importação de dados|a|a|

 OBS: Entradas válidas temos duas situações a serem testadas:
 - rejeitar uma entrada válida.
 - aceitar causando um resultado incorreto.

  da geração de resultado incorreto.

#### 3.3.2 Entradas Inválidas
CT1.1 - Timestamp da execução da importação de dados
Descrição:
Entrada:
Saida Esperada:
Recurso:
