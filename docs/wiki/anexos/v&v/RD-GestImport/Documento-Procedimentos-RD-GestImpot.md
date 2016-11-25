# Documento de Procedimentos - (RD-GestImport)

## 1. Descrição do Artefato
Definir e descrever qual sera o artefato a ser testado com os procedimentos neste documento adotados, e apos a coleta dos restulados, quais interessados expor as medidas necessárias para o sucesso na entrega do artefato.

|Artefato Avaliado| Descrição do Artefato | Nome do Responsavel do Artefato|
|-----------------|-----------------------|---------------------|
|Codigo de Testes RD-GestImport|Implementação dos testes unitários referente ao RD-GestImport.|Higor André|

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

### 3.2 Casos de Testes
|Caso de Teste|Descrição|Entrada|Saida Esperada|
|-------------|---------|-------|--------------|
|CT1.1|Timestamp da execução da importação deve ser unico|Data já existente|Erro de unicidade com data ja existente|
|CT1.2|Timestamp da execução da importação deve ser no formato de data|Data em formato de String|Erro de semantica com data no formato diferente de Date|
|CT1.3|Timestamp da execução da importação deve ser inacessivel sua alteração|Modifica data já existente|Erro de integridade com data já existente|
|CT2.1|Deve conter no minino um e no maximo um usuario para cada importação de dados de egressos que é realizado.
|CT2.2|Usuario que realizou a importação de dados deve ser unico para um Timestamp|Usuario já existente|Erro de unicidade com usuario já existente|
