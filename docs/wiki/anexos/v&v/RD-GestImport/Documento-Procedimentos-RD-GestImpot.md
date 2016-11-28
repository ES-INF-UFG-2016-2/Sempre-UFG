# Documento de Procedimentos - (RD-GestImport)

## 1. Descrição do Artefato
Definir e descrever qual sera o artefato a ser testado com os procedimentos neste documento adotados.

|Artefato Avaliado| Descrição do Artefato |
|-----------------|-----------------------|
|Codigo de Testes RD-GestImport|Implementação dos testes unitários referente ao RD-GestImport.|

## 2. Critérios de Coberturas dos Testes
Definir aqui as condições que devem ser satisfeitas para que o conjunto de testes seja considerado bem sucedido.

|Numero de Ordem do Item|Critério|
|-----------------------|--------|
|01 | Os testes implementados devem garantir que a DDL que implementa o requisito de dados GestImport esta correta. |
|02 | Todas as instruções devem ser testadas. |
|03 | Os testes devem ser aprovados independentemente do banco de dados utilziado.|
|04 | O artefato testado devera conter todos os dados necessários para a execução dos testes, bem como corresponder a especificação de requisitos.|

## 3. Especificação dos Testes
Nesta parte do documento devem ser descritos os procedimentos e os casos de teste a serem aplicados. Dar um identificador para o conjunto de testes.

### 3.1 Procedimentos
- Os testes foram realizados de forma orientado a especificação do requisito e seu diagrama de entidade e relacionamento definido no documento de Requisitos do Software SempreUFG.
- O casos de testes foram aplicados nas classes geradas na implementação dos testes do RD-GestImport, disponibilziadas no respositório do projeto.
- Os resultados coletados e analisados foram descritos no Relatório-Resultados-Procedimentos-RD-GestImport.
- Quaisquer problemas ocorridos na execução deverá ser informado no cartão da tarefa no Trello. Marcando o gerente do projeto bem como o responsável pela implementação dos teste do requisito.

### 3.2 Recursos dos Testes
REC1 - <Nome do Recurso>
Descrição: definição do recuso em si e como foi definido.
Aplicabilidade: em qual contexto sera usado este recurso, e quais situações (Casos de testes) se aplica seus dados.
Localidade: commit refente a base de dados com as entradas utilizadas nos testes..Ex: ddl

REC2 - <Nome do Recurso>
Descrição: definição do recuso em si e como foi definido.
Aplicabilidade: em qual contexto sera usado este recurso, e quais situações (Casos de testes) se aplica seus dados.
Localidade: commit refente a base de dados com as entradas utilizadas nos testes..Ex: ddl

### 3.3 Casos de Testes

#### 3.3.1 Entradas Válidas

 CT1.1 - Timestamp da execução da importação de dados
 Descrição: definicao do caso de teste
 Entrada: valor que sera dado como entrada para se ter a saida esperada.
 Saida Esperada: valor desejavel para a saida do artefato testado.
 Recurso: REC1

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
