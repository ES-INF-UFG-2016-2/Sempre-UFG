Projeto de Teste Funcional RF-ImportEgresPeriod
======
#### (Importar dados cadastrais de egressos em um determinado período)
**Prioridade**: Alta.

**Partes Interessadas**: PROGRAD, PRPG.

**Entradas**: data inicial e final do período; opcionalmente podem ser informadas listas com identificadores de: egressos, cursos da UFG, Unidades Acadêmicas da UFG, e/ou Regionais da UFG.

**Resultados**: dados cadastrais de egressos de graduação e pós-graduação que concluíram seus cursos na UFG no período informado são importados dos sistemas do CERCOMP para o software SempreUFG. Se houver listas de entrada, somente os dados de egressos que se enquadram nessas listas são importados. Para cada egresso incluído é criado um usuário correspondente, com um valor default “0” para a senha.

**Estatísticas de importação de dados são registradas sobre**: o total de egressos exportados pelo CERCOMP; o total de egressos importados com sucesso pelo SempreUFG; o total de egressos não importados devido a erros nos dados (indicando, para cada egresso, os erros detectados); e o total de egressos não importados por replicação, ou seja, os dados exportados já constam no SempreUFG (indicando quais são esses dados, para cada egresso).
	Um relatório de importação de dados é gerado para apresentar essas estatísticas.
	A forma de integração com os sistemas do CERCOMP é definida em RNF-IntgrCercom.

Testes Funcionais
------
Com o detalhamento do requisito em perspectiva, o conjunto de casos de teste funcionais - segmentados em módulos - que garante qualidade satisfatória para o mesmo segue:

#### Módulo 1 – Importação Válida

**Premissas**: Dados completamente íntegros e mapeados advindos do (s) SW (s) do CERCOMP.

**Execução**: Realizar a importação via integração com o CERCOMP.

**Sucesso**: Os dados migrados devem constar na base de dados conforme mapeamento dos dados iniciais.

- Caso de Teste 1 (Parâmetros básicos, apenas data início e data fim)
- Caso de Teste 2 (Parâmetros opcionais, lista com identificadores de egressos)
- Caso de Teste 3 (Parâmetros opcionais, lista com identificadores de cursos da UFG)
- Caso de Teste 4 (Parâmetros opcionais, lista com identificadores de Unidades Acadêmicas da UFG)
- Caso de Teste 5 (Parâmetros opcionais, lista com identificadores de Regionais da UFG)

#### Módulo 2 – Importação Inválida

**Premissas**: Dados parcialmente íntegros e mapeados advindos do (s) SW (s) do CERCOMP.

**Execução**: Realizar a importação via integração com o CERCOMP.

**Sucesso**: Os dados migrados consistentes devem constar na base de dados conforme mapeamento dos dados iniciais enquanto os dados inconsistentes não devem ser migrados e devem constar no relatório de forma que as devidas inconsistências conhecidas no momento do mapeamento estejam equivalentes e corretamente indicadas.

- Caso de Teste 1 (Parâmetros básicos, apenas data início e data fim)
- Caso de Teste 2 (Parâmetros opcionais, lista com identificadores de egressos)
- Caso de Teste 3 (Parâmetros opcionais, lista com identificadores de cursos da UFG)
- Caso de Teste 4 (Parâmetros opcionais, lista com identificadores de Unidades Acadêmicas da UFG)
- Caso de Teste 5 (Parâmetros opcionais, lista com identificadores de Regionais da UFG)

#### Módulo 3 – Geração de Relatório

**Premissas**: Ter executado um dos casos de teste dos módulos 1 ou 2.

**Execução**: Observar e aferir a existência e significância das informações contidas no relatório.

**Sucesso**: O caso de teste realizado na premissa deve atender todos os critérios de sucesso e o relatório, além de existir, deve trazer as informações do processamento exatamente como ele ocorreu, sem falsos positivos e/ou erros. Para que isso seja constatado, os atributos do relatório (o total de egressos na entrada do processamento; o total de egressos importados com sucesso; o total de egressos não importados por erros ou por replicação) devem concordar com a realidade medida e observável.

- Cada caso de teste dos módulos 1 e 2 geram um caso de teste deste módulo, portanto são 10 casos de teste, um para cada cenário dos módulos de 1 e 2

