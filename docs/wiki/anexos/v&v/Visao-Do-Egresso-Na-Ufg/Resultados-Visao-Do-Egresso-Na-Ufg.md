# Relatório de Resultados - (Visao-Do-Egresso-Na-Ufg)
 
## 1. Conjunto dos Testes Executados
 
CT-1 e CT-2.
 
## 2. Conjunto de Testes Falhos
**CT-1 . Conjunto de testes para verificar se as tabelas estão criadas no Banco de dados**
 
|Caso de Teste|Saída da Execução|Comentário|
|-------------|-----------------|----------|
|CT-1.1||O campo ID não está representado no diagrama do documento de requisitos.|
|CT-1.1||Definir um nome mais sucinto, objetivo e que não permita várias interpretações. Ex: NOME_OFICIAL.|
|CT-1.1||Definir um nome mais sucinto, objetivo e que não permita várias interpretações. Ex: NOME_DA_MAE.|
|CT-1.1||Definir um nome mais sucinto, objetivo e que não permita várias interpretações. Ex: DATA_DE_NASCIMENTO.|
|CT-1.1||Definir um nome mais sucinto, objetivo e que não permita várias interpretações. Ex: NOME_DA_MAE.|
|CT-1.1||O tamanho dos campos NOME E NOME_DA_MAE estão com tamanho 300, por ser nome sugiro que altere para 100.|
|CT-1.2||Definir um nome mais sucinto, objetivo e que não permita várias interpretações. Ex: NOME_DA_CIDADE.|
|CT-1.4||Definir um nome mais sucinto, objetivo e que não permita várias interpretações. Ex: NOME_DA_AREA.|
|CT-1.8||O campo HISTORICO não existe no diagrama do documento de requisitos.|
|CT-1.8||O campo HISTORICO está sendo associado ao campo NUMERO_MATRICULA_CURSO. Essa definição não ficou clara.|
|CT-1.9||O campo HISTORICO não existe no diagrama do documento de requisitos.|
 
**CT-2. Conjunto de testes para verificar se as tabelas estão aceitando os dados válidos corretamente, e com entradas com todos os campos obrigatorios e opcionais**
 
|Caso de Teste|Saída da Execução|Comentário|
|-------------|-----------------|----------|
|CT-2.||Definir tipo mais genericos aos campos da tabela. Ex: 'text' ao inves de 'char'. Até porque não foi definido tamanho nos requisitos.|
|CT-2.1||Foi definido um identificador ID do tipo inteiro, sendo que nos requisitos não existe essa definição.|
|CT-2.1||O limite de apenas 5 fotos não está sendo definido no vetor de fotos adicionais.|
|CT-2.1||Campo CPF sem definição de tamanho, sendo que deveria ser de tamanho 11.|
|CT-2.3||Foi definido um identificador ID do tipo inteiro, sendo que nos requisitos não existe essa definição.|
|CT-2.4||Campo CODIGO está definido no documento de requisitos com tamanho 10, porém isso não está no arquivo de visão.|
|CT-2.4||O campo SUPER_AREA não está definido no documento de requisitos.|
|CT-2.4|| Falta de padrão de definição de nomeclatura de campos. Escreva os campos em maiúsculo ou minúsculo.|
|CT-2.8||Campo DATA_AVALIACAO está como está definido como identificador no documento de requisitos, porém não está implementado na DDL.|
|CT-2.8||Foi definido um identificador HISTORICO do tipo inteiro, sendo que nos requisitos não existe essa definição.|
|CT-2.9||Foi definido um identificador HISTORICO do tipo inteiro, sendo que nos requisitos não existe essa definição.|