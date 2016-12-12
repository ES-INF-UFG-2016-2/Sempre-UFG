# Relatório de Resultados - (RD-GestImport)

## 1. Conjunto dos Testes Executados

Todos.

## 2. Conjunto de Testes Falhos
**CT-1 . Conjunto de testes para verificar se as tabelas estão criadas no Banco de dados**

|Caso de Teste|Saída da Execução|Comentário|
|-------------|-----------------|----------|
|CT-1.1||Definir um nome mais sucinto, objetivo e que não permita várias interpretações. Ex: IMPORTACAO_EGRESSO.|
|CT-1.4||Definir um nome mais sucinto, objetivo e que não permita várias interpretações. Ex: PAPEL_USUARIO.|
|CT-1.5||Definir um nome mais sucinto, objetivo e que não permita várias interpretações. Ex: RECURSO_SISTEMA.|
|CT-1.6||Definir um nome mais sucinto, objetivo e que não permita várias interpretações. Ex: BACKUP_SISTEMA.|
|CT-1.7||Definir um nome mais sucinto, objetivo e que não permita várias interpretações. Ex: RESTAURA_SISTEMA.|
|CT-1.9||Definir um nome mais sucinto, objetivo e que não permita várias interpretações. Ex: PARAMETRO_CONFIGURA_SISTEMA.|
|CT-1.10||Definir um nome mais sucinto, objetivo e que não permita várias interpretações. Ex: IMPORTACAO_RESTRITA_EGRESSO
CT-1.11||Definir um nome mais sucinto, objetivo e que não permita várias interpretações. Ex: IMPORTACAO_RESTRITA_INSTANCIA.|

**CT-2. Conjunto de testes para verificar se as tabelas estão aceitando os dados validos corretamente, e com entradas com todos os campos obrigatorios e opcionais**

|Caso de Teste|Saída da Execução|Comentário|
|-------------|-----------------|----------|
|CT-2.||Definir tipo mais genericos aos campos da tabela. Ex: 'text' ao inves de 'char'. Até porque não foi definido tamanho nos requisitos.|
|CT-2.1||Foi definido um identificador do tipo inteiro, sendo que nos requisitos define que os identificadores do usario são o email princial e ou CPF.|
|CT-2.1|| Falta de padrão de definição de nomeclatura de campos. Escreva os campos em maiúsculo ou minúsculo.|
|CT-2.1||Campo CPF sem definição de tamanho, sendo que deveria ser de tamanho 11.|
|CT-2.2||Foi definido um identificador do tipo inteiro, sendo que nos requisitos define que o identificador da importação de dados de egresso é o timestamp de execução da importação.|
|CT-2.2||Não existe campo quantidade de egressos recebidos.|
|CT-2.2||Nome dos campos muito extensos, procure não usar mais que 30(trinta) caracteres. Para diminuir procurar abreviar nomes conhecidos. Ex: 'quantidade_importados_sucesso' para 'qtde_importados_sucesso'.|
|CT-2.2||O identificador do usuario na tabela é invalido. Pois referencia um inteiro, no qual de acordo com os requisitos não existe. O id referente ao usuario é o email principal do mesmo.|
|CT-2.3||Foi definido um identificador do tipo inteiro, sendo que nos requisitos define que o identificador da instancia administrativa da UFG, é a sigla da instancia no formato de texto.|
|CT-2.4||Nome da tabela não condiz com o eperado, pois cita USUARIO_PROCESSO_IMPORTACAO ao inves de EGRESSO.
|CT-2.4||Definir um nome mais sucinto, objetivo e que não permita várias interpretações. Ex: IMPORTACAO_RESTRITA_EGRESSO.|
|CT-2.4||Foi definido identificador do tipo inteiro, sendo que nos requisitos define que o identificador da importacao de dados de egressos é o timestamp de execucao do tipo date.|
|CT-2.5||Foi definido identificadores do tipo inteiro, sendo que nos requisitos define que o identificador de uma instancia é a sua sigla do tipo texto, e o identificador de uma importação de dados de egressos é o timestamp de execução do tipo date.|
|CT-2.5||Nome da tabela muito extensa, procure não usar mais que 30(trinta) caracteres, para diminuir procurar abreviar. Ex: IMPORTACAO_RESTRITA_INSTANCIA.|
|CT-2.6||Definir um nome mais sucinto, objetivo e que não permita várias interpretações. Ex: BACKUP_SISTEMA.|
|CT-2.6||Foi definido um identificador do tipo serial, sendo que nos requisitos define que o identificador de um backup do sistema é do tipo texto.|
|CT-2.6||O identificador do usuario na tabela é invalido. Pois referencia um inteiro, no qual de acordo com os requisitos não existe. O id referente ao usuario é o email principal do mesmo.|
|CT-2.6||Uso de preposicao indevido. Evite usar 'de' e outras preposicoes em nomeclatura de campos. Uma forma correta seria local_armazenamento;|
|CT-2.7||Definir um nome mais sucinto, objetivo e que não permita várias interpretações. Ex: RESTAURACAO_SISTEMA.|
|CT-2.7||O identificador do usuario na tabela é invalido. Pois referencia um inteiro, no qual de acordo com os requisitos não existe. O id referente ao usuario é o email principal do mesmo.|
|CT-2.7||O identificador do backup na tabela é invalido. Pois referencia um serial, no qual de acordo com os requisitos não existe. O id referente ao backup é do tipo texto.|
|CT-2.8||Definir um nome mais sucinto, objetivo e que não permita várias interpretações. Ex: PAPEL_USUARIO.|
|CT-2.8||Foi definido identificador do tipo inteiro, sendo que nos requisitos define que o identificador de um papel é a sua sigla do tipo texto.|
|CT-2.8||Foi definido um tamanho para o nome do papel invalido, no qual o esperado era de tamanho = 200, e no ddl foi definido um tamanho = 20 para este campo.|
|CT-2.9||Definir um nome mais sucinto, objetivo e que não permita várias interpretações. Ex: RECURSO_SISTEMA.|
|CT-2.9||Foi definido identificador do tipo inteiro, sendo que nos requisitos define que o identificador de um recurso é a sua sigla do tipo texto.|
|CT-2.10||Definir um nome mais sucinto, objetivo e que não permita várias interpretações. Ex: USUARIO_EXERCE_PAPEL.|
|CT-2.10||Foi definido identificadores do tipo inteiro, sendo que nos requisitos define que o identificador do papel é sua sigla do tipo texto, e o identificador do usuario é seu email principal do tipo texto.|
|CT-2.10||Falta de padrão de definição de nomeclatura de campos. Escreva os campos em maiúsculo ou minúsculo.|
|CT-2.11||Definir um nome mais sucinto, objetivo e que não permita várias interpretações. Ex: PAPEL_ACESSA_RECURSO.|
|CT-2.11||Foi definido identificadores do tipo inteiro, sendo que nos requisitos define que o identificador do papel e do recurso são suas siglas do tipo texto.|
|CT-2.11||Falta de padrão de definição de nomeclatura de campos. Escreva os campos em maiúsculo ou minúsculo.|
|CT-2.12||Foi definido identificador do tipo inteiro, sendo que nos requisitos define que o identificador do sistema SempreUFG é seu nome do tipo texto.|
|CT-2.12||O identificador do usuario na tabela é invalido. Pois referencia um inteiro, no qual de acordo com os requisitos não existe. O id referente ao usuario é o email principal do mesmo.|
|CT-2.12||Definir um nome mais sucinto, objetivo e que não permita várias interpretações. Ex: timestamp_instalacao.|
|CT-2.13||Foi definido identificador do tipo inteiro, sendo que nos requisitos define que o identificador do parametro é sua sigla tipo texto.|
|CT-2.13||O identificador do sistema SempreUFG na tabela é invalido. Pois referencia um bigint, no qual de acordo com os requisitos não existe. O id referente ao sistema é seu nome do tipo texto.|
|CT-2.13||Não existe o campo 'nome_sistema' na tabela parametro.|
