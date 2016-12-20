# Relatório de Resultados - (Visao do Egresso Em Outras Instituições de Ensino)

## 1. Checklist de Qualidade
|Item|Avaliação|Comentário|
|-------------|-----------------|----------|
|Não usar espaço em branco|APROVADO||
|Não usar hífen, acentos e caracteres especiais|APROVADO||
|Não usar palavras reservadas|APROVADO||
|Não usar verbos|APROVADO||
|Escrever em maiúsculo ou minúsculo|APROVADO||
|Não utilizar palavras no plural|APROVADO||
|Não usar preposições|APROVADO||
|Não usar números|APROVADO||
|Não usar nomes próprios|APROVADO||
|Separe os nomes com underline|APROVADO||
|Crie nomes sucintos e objetivos|APROVADO PARCIALMENTE|Tabela curso_outra_ies possui alguns campos confusos|

## 2. CheckList Conformidade com Documentação e Diagramas

|Item|Avaliação|Comentário|
|-------------|-----------------|----------|
|Todas as tabelas existem|APROVADO||
|Todas as tabelas incluem os mesmos campos existentes na documentação|REPROVADO|Campos "matricula" da tabela egresso; "nome_pt, nome_original, codigo e nome_unidade_academica_original da tabela curso_outra_ies  não existem na documentação|
|Todos os campos possuem dados iguais ou compatíveis com aqueles da documentação|APROVADO||
|Todos os campos indicados como opcionais na documentação são opcionais nas tabelas|REPROVADO|Os campos "latitude" e "longitude" da tabela localizacao_geografica constam como opcionais na documentação, mas foram modelados como obrigatórios|
|Relacionamentos existentes na documentação existem também nas tabelas|APROVADO||

## 2. Casos de teste

|Caso de Teste|Saída da Execução|Resultado|
|-------------|-----------------|----------|
|CT-01|Tabelas criadas|APROVADO|
|CT-02|curso_outra_ies, egresso, historico_ensino_medio, historico_outra_ies, inst_ensino_medio, localizacao_geografica|APROVADO|
|CT-03|Dados inseridos|APROVADO|
|CT-04|Comando Recusado|APROVADO|
|CT-05|Comando Recusado|APROVADO|
|CT-06|Comando Recusado|APROVADO|
|CT-07|Comando Recusado|APROVADO|
CT-08|Apenas dados inseridos são exibidos|APROVADO|
CT-09|Todos os dados são exibidos|APROVADO|
CT-10|Todos os dados são exibidos|APROVADO|
CT-11|Comando Recusado|APROVADO|
CT-12|Comando Recusao|APROVADO|
CT-13|Comando Recusado|APROVADO|
CT-14|Comando Recusado|APROVADO|
CT-15|Comando Recusado|REPROVADO|
CT-16|Todos os dados são exebidos|APROVADO|
CT-17|Comando Recusado|APROVADO|
CT-18|Comando Recusado|APROVADO|
CT-19|Todos os dados são exibidos|APROVADO|
CT-20|Comando Recusado|APROVADO|
CT-21|Comando Recusado|APROVADO|

Tabela "curso_outra_ies" não foi testada porque está fora do padrão da documentação.
Tabela "historico_outra_ies" não foi testada porque dependia da tabela "curso_utra_ies".