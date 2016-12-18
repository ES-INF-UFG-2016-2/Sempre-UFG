# Documento de Procedimentos - (Visao de Gestão do Sistema)

## 1. Descrição do Artefato
|Artefato Avaliado| Descrição do Artefato |
|-----------------|-----------------------|
|DDl Gestao do Sistema|Implementação da DDL que integra os RD's: GestImport, GestUsu e GestSis, que formam a visão de gestão do sistema|

## 2. Critérios de Coberturas dos Testes
- Os testes implementados devem garantir que a DDL que implementa o requisito de dados está correta.
- Todas as implementações devem ser testadas.
- Os testes devem ser aprovados independentemente do banco de dados utilziado (MariaDb e Postgres).
- O artefato testado deve conter todos os dados necessários para a execução dos testes, bem como corresponder a especificação de requisitos.

## 3. Especificação dos Testes
Nesta parte do documento devem ser descritos os procedimentos e os casos de teste a serem aplicados. Dar um identificador para o conjunto de testes

### 3.1 Recursos
|Codigo|Descrição|Localização|Aplicabilidade|
|------|---------|-----------|--------------|
|RC1|Testador|Time de desenvolvimento|Responsável por executar os testes.|
|RC2|Script DML com todos os comandos utilizados nos testes para testar a DDL que integra a gestão do sistema SempreUFG.|.\Sempre-UFG\db\|Testes manuais de banco de dados.|
|RC3|Script DDL que contem a integração da visão de gestão do sistema SempreUFG.|.\Sempre-UFG\db\|Estudo de caso para os casos de teste.|

### 3.2 Procedimentos
- O diagrama de entidade e relacionamento definido no documento de Requisitos do Software SempreUFG é a base de criação dos casos de testes.
- O casos de testes foram aplicados na DDL que integra a visão de Gestão do Sistema disponibilizada no respositório do projeto, realizando a execução dos testes e coletando seus resultados.
- Os resultados coletados e analisados foram descritos no relatorio que descreve os resultados dos procedimentos.
- Os testes foram executados manualmente.

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
|CT-1.2| * | Verifica se a tabela referente a instancia administrativa da UFG existe.|SELECT * FROM INSTANCIA_ADMINISTRATIVA_UFG | true|
|CT-1.3| * | Verifica se a tabela referente ao Usuário do sistema existe.|SELECT * FROM USUARIO | true|
|CT-1.4|* |Verifica se a tabela referente ao Papel do usuario no sistema existe.|SELECT * FROM PAPEL_USUARIO| true|
|CT-1.5| * | Verifica se a tabela referente ao Recurso existe.|SELEC * FROM RECURSO_SISTEMA| true|
|CT-1.6| * | Verifica se a tabela referente ao Backup do Sistema existe.| SELECT * FROM BACKUP_SISTEMA|true|
|CT-1.7| * | Verifica se a tabela referente a Restauração do Sistema existe.|SELECT * FROM RESTAURACAO_SISTEMA| true|
|CT-1.8| *| Verifica se a tabela referente ao Sistema Sempre-UFG existe.|SELECT * FROM SEMPREUFG|true|
|CT-1.9|*|Verifica se a tabela referente ao Paramentro de configuração do sistema existe.|SELECT * FROM PARAMETRO_CONFIGURA_SISTEMA|true|
|CT-1.10| *|Verifica se a tabela referente a relação importação  de dados de egressos e egresso existe.|SELECT * FROM IMPORTACAO_RESTRITA_EGRESSO| true|
|CT-1.11|*|Verifica se a tabela referente a relação importação de dados de egressos e instancia administrativa existe.|SELECT * FROM IMPORTACAO_RESTRITA_INSTANCIA| true|
|CT-1.12|*|Verifica se a tabela referente a relação usuario e seu papel existe.|SELECT * FROM USUARIO_EXERCE_PAPEL| true|
|CT-1.13|*|Verifica se a tabela referente a relação papel e recurso existe.|SELECT * FROM PAPEL_ACESSA_RECURSO|true|

**CT-2. Conjunto de testes para verificar se as tabelas estão aceitando os dados validos corretamente, e com entradas com todos os campos obrigatorios e opcionais**

|Caso de Teste|Pré-condições|Descrição|Entrada|Resultado Esperado|
|-------------|-------------|------------|-------|---------|
|CT-2.1|Tabela USUARIO existente.|Realiza a inserção de dados de um usuário com todos os dados validos, campos obrigatorios e campos opcionais.| INSERT INTO USUARIO VALUES email_principal = 'julianny@inf.ufg.br', senha = '3A56S3DA4S5AF6A5S5D4', nome_social = 'Julianny Alves', cpf = 1234567890, foto_pessoal = E'\\xDEADBEEF, recebe_divulgacao = 'semanal', timestamp_cadastro = 2013-03-04 14:03:11, timestamp_ultima_atualizacao = 2016-07-12 10:39:23, timestamp_exclusao_logica = 2016-12-23|true|
|CT-2.2|Tabela IMPORTACAO_EGRESSO existente.|Realiza inserção de dados de uma importação de egressos com todos os dados válidos, campos obrigatorios e campos opcionais.|INSERT INTO IMPORTACAO_EGRESSO VALUES timestamp_execucao = 2016-12-06 09:45:01, inicio_periodo = 2016-12-06 09:57:03, fim_periodo = 2016-12-06 10:05:43, qtde_egresso_recebido = 45, qtde_importado_sucesso = 45, qtde_egresso_incorreto = 45, qtde_egresso_replicado = 45, id_usuario_autorizador = 'julianny@inf.ufg.br'|true|
|CT-2.3|Tabela INSTANCIA_ADMINISTRATIVA_UFG existente.|Realiza inserção de dados de uma instancia administrativa da UFG com todos os dados validos, campos obrigatorios e campos opcionais.|INSERT INTO INSTANCIA_ADMINISTRATIVA_UFG VALUES sigla_instancia = 'INF', nome_instancia = 'Instituto de Informatica', tipo_instancia = 'Unidade', data_criacao = 2015-12-07, data_encerramento = 2016-12-07, email_institucional = 'inf@inf.ufg,br', url_institucional = 'http://wwww.inf.ufg.br', id_usuario_responsavel = 'julianny@inf.ufg.br'|true|
|CT-2.4|Tabela IMPORTACAO_RESTRITA_EGRESSO existente.|Realiza a inserção de dados de uma importados de dados de egressos restrito a um egresso com todos os dados validos, campos obrigatorios e campos opcionais.|INSERT INTO IMPORTACAO_RESTRITA_EGRESSO VALUES id_egresso = 1, id_IMPORTACAO_EGRESSO = 2016-12-06 09:45:01|true|
|CT-2.5|Tabela IMPORTACAO_RESTRITA_INSTANCIA existente.|Realiza a inserção de dados de uma importados de dados de egressos restrito a uma instancia administrativa com todos os dados validos, campos obrigatorios e campos opcionais.|INSERT INTO IMPORTACAO_RESTRITA_INSTANCIA VALUES id_instancia = 'INF', id_IMPORTACAO_EGRESSO = 2016-12-06 09:45:01|true|
|CT-2.6|Tabela BACKUP_SISTEMA existente.|Realiza a inserção de dados de um backup do sistema com todos os dados validos, campos obrigatorios e campos opcionais.|INSERT INTO BACKUP_SISTEMA VALUES id_backup_sistema = 'backup do sistema 001', timestamp_inicio_backup = 2016-12-07 15:00:00, timestamp_fim_backup = 2016-12-07 16:00:00, local_armazenamento = 'c:/Backup/SempreUFG/', timestamp_RESTAURACAOcao_sistema = 2016-04-23, id_usuario_copia = 'julianny@inf.ufg.br'|true|
|CT-2.7|Tabela RESTAURACAO_SISTEMA existente.|Realiza a inserção de dados de uma restauração do sistema com todos os dados validos, campos obrigatorios e campos opcionais.|INSERT INTO RESTAURACAO_SISTEMA VALUES timestamp_restauracao = 2016-12-15 13:43:11, motivo_restauracao = 'instalado software infectuoso.', id_backup_sistema = 'backup do sistema 001', id_usuario_restaura = 'julianny@inf.ufg.br'|true|
|CT-2.8|Tabela PAPEL_USUARIO existente.|Realiza inserção de dados de um papel que o usuario exerce no sistema com todos os dados validos, campos obrigatorios e campos opcionais.|INSERT INTO PAPEL_USUARIO VALUES sigla_papel = 'ADM', nome_papel = 'Administrador'|true|
|CT-2.9|Tabela RECURSO_SISTEMA existente.|Realiza inserção de dados de um recurso do sistema com todos os dados validos, campos obrigatorios e campos opcionais.|INSERT INTO RECURSO_SISTEMA VALUES sigla_recurso = 'LOGIN', descricao_recurso = 'Usuario realiza o acesso ao sistema.'|true|
|CT-2.10|Tabela USUARIO_EXERCE_PAPEL existente.|Realiza inserção de dados de usuario que exerce algum papel dentro do sistema com todos os dados validos, campos obrigatorios e campos opcionais.|INSERT INTO USUARIO_EXERCE_PAPEL VALUES id_usuario = 'julianny@inf.ufg.br', id_papel_sistema = 'ADM'|true|
|CT-2.11|Tabela PAPEL_ACESSA_RECURSO existente.|Realiza inserção de dados de um papel de usario que acessa uma funcionalidade do sistema com todos os dados validos, campos obrigatorios e campos opcionais.|INSERT INTO PAPEL_ACESSA_RECURSO VALUES id_papel_sistema = 'ADM', id_recurso_sistema = 'LOGIN'|true|
|CT-2.12|Tabela SEMPREUFG existente.|Realiza inserção de dados de um sistema com todos os dados validos, campos obrigatorios e campos opcionais.|INSERT INTO SEMPREUFG VALUES nome_sistema = 'SempreUFG', timestamp_instalacao = 2016-01-01 12:43:11, id_usuario_gestor = 'julianny@inf.ufg.br'|true|
|CT-2.13|Tabela PARAMETRO existente.|Realiza inserção de dados dos paramentros de sistema com todos os dados validos, campos obrigatorios e campos opcionais.|INSERT INTO PARAMETRO VALUES sigla_parametro = 'BACKUP_SEMANAL', tipo = 'Backup', descricao_parametro = 'Fazer backup do sistema por prevenção.', valor_parametro = 'backup123', id_sistema = 'SempreUFG'|true|

#### 3.3.3 Entradas Inválidas

**CT-3. Conjunto de testes para verificar se as tabelas estão sendo tratadas para não receber dados faltantes.**

|Caso de Teste|Pré-condições|Descrição|Entrada|Resultado Esperado|
|-------------|-------------|------------|-------|---------|
|CT-3.1|Tabela USUARIO existente.|Realiza a inserção de dados de um usuário com email princial faltando.| INSERT INTO USUARIO VALUES senha = '3A56S3DA4S5AF6A5S5D4', nome_social = 'Julianny Alves', cpf = 1234567890, foto_pessoal = E'\\xDEADBEEF, recebe_divulgacao = 'semanal', timestamp_cadastro = 2013-03-04 14:03:11, timestamp_ultima_atualizacao = 2016-07-12 10:39:23, timestamp_exclusao_logica = 2016-12-23|true|
|CT-3.2|Tabela USUARIO existente.|Realiza a inserção de dados de um usuário com cpf faltando.| INSERT INTO USUARIO VALUES email_principal = 'julianny@inf.ufg.br', senha = '3A56S3DA4S5AF6A5S5D4', nome_social = 'Julianny Alves', foto_pessoal = E'\\xDEADBEEF, recebe_divulgacao = 'semanal', timestamp_cadastro = 2013-03-04 14:03:11, timestamp_ultima_atualizacao = 2016-07-12 10:39:23, timestamp_exclusao_logica = 2016-12-23|true|
|CT-3.3|Tabela USUARIO existente.|Realiza a inserção de dados de um usuário com data de cadastro faltando.| INSERT INTO USUARIO VALUES email_principal = 'julianny@inf.ufg.br', senha = '3A56S3DA4S5AF6A5S5D4', nome_social = 'Julianny Alves', cpf = 1234567890, foto_pessoal = E'\\xDEADBEEF, recebe_divulgacao = 'semanal', timestamp_ultima_atualizacao = 2016-07-12 10:39:23, timestamp_exclusao_logica = 2016-12-23|true|
|CT-3.4|Tabela IMPORTACAO_EGRESSO existente.|Realiza inserção de dados de uma importação de egressos com data de importação faltando.|INSERT INTO IMPORTACAO_EGRESSO VALUES inicio_periodo = 2016-12-06 09:57:03, fim_periodo = 2016-12-06 10:05:43, qtde_egresso_recebido = 45, qtde_importado_sucesso = 45, qtde_egresso_incorreto = 45, qtde_egresso_replicado = 45, id_usuario_autorizador = 'julianny@inf.ufg.br'|true|
|CT-3.5|Tabela IMPORTACAO_EGRESSO existente.|Realiza inserção de dados de uma importação de egressos com fim do periodo de importação faltando.|INSERT INTO IMPORTACAO_EGRESSO VALUES timestamp_execucao = 2016-12-06 09:45:01, inicio_periodo = 2016-12-06 09:57:03, qtde_egresso_recebido = 45, qtde_importado_sucesso = 45, qtde_egresso_incorreto = 45, qtde_egresso_replicado = 45, id_usuario_autorizador = 'julianny@inf.ufg.br'|true|
|CT-3.6|Tabela INSTANCIA_ADMINISTRATIVA_UFG existente.|Realiza inserção de dados de uma instancia administrativa da UFG com sigla da intancia faltando.|INSERT INTO INSTANCIA_ADMINISTRATIVA_UFG VALUES nome_instancia = 'Instituto de Informatica', tipo_instancia = 'Unidade', data_criacao = 2015-12-07, data_encerramento = 2016-12-07, email_institucional = 'inf@inf.ufg,br', url_institucional = 'http://wwww.inf.ufg.br', id_usuario_responsavel = 'julianny@inf.ufg.br'|true|
|CT-3.7|Tabela IMPORTACAO_RESTRITA_EGRESSO existente.|Realiza a inserção de dados de uma importados de dados de egressos restrito a um egresso com id do egresso faltando.|INSERT INTO IMPORTACAO_RESTRITA_EGRESSO VALUES id_IMPORTACAO_EGRESSO = 2016-12-06 09:45:01|true|
|CT-3.8|Tabela IMPORTACAO_RESTRITA_INSTANCIA existente.|Realiza a inserção de dados de uma importados de dados de egressos restrito a uma instancia administrativa com id da importancao faltando.|INSERT INTO IMPORTACAO_RESTRITA_INSTANCIA VALUES id_instancia = 'INF'|true|
|CT-3.9|Tabela BACKUP_SISTEMA existente.|Realiza a inserção de dados de um backup do sistema com id do backup faltando.|INSERT INTO BACKUP_SISTEMA VALUES timestamp_inicio_backup = 2016-12-07 15:00:00, timestamp_fim_backup = 2016-12-07 16:00:00, local_armazenamento = 'c:/Backup/SempreUFG/', timestamp_RESTAURACAOcao_sistema = 2016-04-23, id_usuario_copia = 'julianny@inf.ufg.br'|true|
|CT-3.10|Tabela BACKUP_SISTEMA existente.|Realiza a inserção de dados de um backup do sistema com local de armazenamento faltando.|INSERT INTO BACKUP_SISTEMA VALUES id_backup_sistema = 'backup do sistema 001', timestamp_inicio_backup = 2016-12-07 15:00:00, timestamp_fim_backup = 2016-12-07 16:00:00, timestamp_RESTAURACAOcao_sistema = 2016-04-23, id_usuario_copia = 'julianny@inf.ufg.br'|true|
|CT-3.11|Tabela RESTAURACAO_SISTEMA existente.|Realiza a inserção de dados de uma restauração do sistema com motivo faltando.|INSERT INTO RESTAURACAO_SISTEMA VALUES timestamp_restauracao = 2016-12-15 13:43:11, id_backup_sistema = 'backup do sistema 001', id_usuario_restaura = 'julianny@inf.ufg.br'|true|
|CT-3.12|Tabela RESTAURACAO_SISTEMA existente.|Realiza a inserção de dados de uma restauração do sistema com id do backup faltando.|INSERT INTO RESTAURACAO_SISTEMA VALUES timestamp_restauracao = 2016-12-15 13:43:11, motivo_restauracao = 'instalado software infectuoso.', id_usuario_restaura = 'julianny@inf.ufg.br'|true|
|CT-3.13|Tabela PAPEL_USUARIO existente.|Realiza inserção de dados de um papel que o usuario exerce no sistema com sigla do papel faltando.|INSERT INTO PAPEL_USUARIO VALUES nome_papel = 'Administrador'|true|
|CT-3.14|Tabela PAPEL_USUARIO existente.|Realiza inserção de dados de um papel que o usuario exerce no sistema com nome do papel faltando.|INSERT INTO PAPEL_USUARIO VALUES sigla_papel = 'ADM'|true|
|CT-3.15|Tabela RECURSO_SISTEMA existente.|Realiza inserção de dados de um recurso do sistema com sigla do recurso faltando.|INSERT INTO RECURSO_SISTEMA VALUES descricao_recurso = 'Usuario realiza o acesso ao sistema.'|true|
|CT-3.16|Tabela RECURSO_SISTEMA existente.|Realiza inserção de dados de um recurso do sistema com descricao do recurso faltando.|INSERT INTO RECURSO_SISTEMA VALUES sigla_recurso = 'LOGIN'|true|
|CT-3.17|Tabela USUARIO_EXERCE_PAPEL existente.|Realiza inserção de dados de usuario que exerce algum papel dentro do sistema com id do usuario faltando.|INSERT INTO USUARIO_EXERCE_PAPEL VALUES id_papel_sistema = 'ADM'|true|
|CT-3.18|Tabela USUARIO_EXERCE_PAPEL existente.|Realiza inserção de dados de usuario que exerce algum papel dentro do sistema com id do papel faltando.|INSERT INTO USUARIO_EXERCE_PAPEL VALUES id_usuario = 'julianny@inf.ufg.br'|true|
|CT-3.19|Tabela PAPEL_ACESSA_RECURSO existente.|Realiza inserção de dados de um papel de usario que acessa uma funcionalidade do sistema com id do papel faltando.|INSERT INTO PAPEL_ACESSA_RECURSO VALUES id_recurso_sistema = 'LOGIN'|true|
|CT-3.20|Tabela PAPEL_ACESSA_RECURSO existente.|Realiza inserção de dados de um papel de usario que acessa uma funcionalidade do sistema com id do recurso faltando.|INSERT INTO PAPEL_ACESSA_RECURSO VALUES id_papel_sistema = 'ADM'|true|
|CT-3.21|Tabela SEMPREUFG existente.|Realiza inserção de dados de um sistema com nome do sistema faltando.|INSERT INTO SEMPREUFG VALUES timestamp_instalacao = 2016-01-01 12:43:11, id_usuario_gestor = 'julianny@inf.ufg.br'|true|
|CT-3.22|Tabela SEMPREUFG existente.|Realiza inserção de dados de um sistema com data de instalação faltando.|INSERT INTO SEMPREUFG VALUES nome_sistema = 'SempreUFG', id_usuario_gestor = 'julianny@inf.ufg.br'|true|
|CT-3.23|Tabela SEMPREUFG existente.|Realiza inserção de dados de um sistema com id do gestor do sistema faltando.|INSERT INTO SEMPREUFG VALUES nome_sistema = 'SempreUFG', timestamp_instalacao = 2016-01-01 12:43:11|true|
|CT-3.24|Tabela PARAMETRO existente.|Realiza inserção de dados dos paramentros de sistema com a sigla do paramentro faltando.|INSERT INTO PARAMETRO VALUES tipo = 'Backup', descricao_parametro = 'Fazer backup do sistema por prevenção.', valor_parametro = 'backup123', id_sistema = 'SempreUFG'|true|
|CT-3.25|Tabela PARAMETRO existente.|Realiza inserção de dados dos paramentros de sistema com id do sistema faltando.|INSERT INTO PARAMETRO VALUES sigla_parametro = 'BACKUP_SEMANAL', tipo = 'Backup', descricao_parametro = 'Fazer backup do sistema por prevenção.', valor_parametro = 'backup123'|true|

**CT-4. Conjunto de testes para verificar se as tabelas estão sendo tratadas para não receber dados incorretos.**

|Caso de Teste|Pré-condições|Descrição|Entrada|Resultado Esperado|
|-------------|-------------|------------|-------|---------|
|CT-4.1|Tabela USUARIO existente.|Realiza a inserção de dados de um usuário com campos incorretos.| INSERT INTO USUARIO VALUES email_principal = 'julianny@inf.ufg.br', senha = 3A56S3DA4S5AF6A5S5D4, nome_social = 'Julianny Alves', cpf = '1234567890', foto_pessoal = E'\\xDEADBEEF, recebe_divulgacao = 'semanal', timestamp_cadastro = '2013-03-04 14:03:11', timestamp_ultima_atualizacao = 2016-07-12 10:39:23, timestamp_exclusao_logica = 2016-12-23|true|
|CT-4.2|Tabela IMPORTACAO_EGRESSO existente.|Realiza inserção de dados de uma importação de egressos com campos incorretos.|INSERT INTO IMPORTACAO_EGRESSO VALUES timestamp_execucao = '2016-12-06 09:45:01', inicio_periodo = 2016-12-06 09:57:03, fim_periodo = 2016-12-06 10:05:43, qtde_egresso_recebido = 45, qtde_importado_sucesso = 45, qtde_egresso_incorreto = 45, qtde_egresso_replicado = '45', id_usuario_autorizador = 'julianny@inf.ufg.br'|true|
|CT-4.3|Tabela INSTANCIA_ADMINISTRATIVA_UFG existente.|Realiza inserção de dados de uma instancia administrativa da UFG com campos incorretos.|INSERT INTO INSTANCIA_ADMINISTRATIVA_UFG VALUES sigla_instancia = INF, nome_instancia = 'Instituto de Informatica', tipo_instancia = Unidade, data_criacao = 2015-12-07, data_encerramento = 2016-12-07, email_institucional = 'inf@inf.ufg,br', url_institucional = 'http://wwww.inf.ufg.br', id_usuario_responsavel = 'julianny@inf.ufg.br'|true|
|CT-4.4|Tabela IMPORTACAO_RESTRITA_EGRESSO existente.|Realiza a inserção de dados de uma importados de dados de egressos restrito a um egresso com dados incorretos.|INSERT INTO IMPORTACAO_RESTRITA_EGRESSO VALUES id_egresso = '1', id_IMPORTACAO_EGRESSO = '2016-12-06 09:45:01'|true|
|CT-4.5|Tabela IMPORTACAO_RESTRITA_INSTANCIA existente.|Realiza a inserção de dados de uma importados de dados de egressos restrito a uma instancia administrativa com dados incorretos.|INSERT INTO IMPORTACAO_RESTRITA_INSTANCIA VALUES id_instancia = INF, id_IMPORTACAO_EGRESSO = 2016-12-06 09:45:01|true|
|CT-4.6|Tabela BACKUP_SISTEMA existente.|Realiza a inserção de dados de um backup do sistema com dados incorretos.|INSERT INTO BACKUP_SISTEMA VALUES id_backup_sistema = 'backup do sistema 001', timestamp_inicio_backup = '2016-12-07 15:00:00', timestamp_fim_backup = 2016-12-07 16:00:00, local_armazenamento = 'c:/Backup/SempreUFG/', timestamp_RESTAURACAOcao_sistema = 20160423, id_usuario_copia = 'julianny@inf.ufg.br'|true|
|CT-4.7|Tabela RESTAURACAO_SISTEMA existente.|Realiza a inserção de dados de uma restauração do sistema com dados incorretos.|INSERT INTO RESTAURACAO_SISTEMA VALUES timestamp_restauracao = '2016-12-15 13:43:11', motivo_restauracao = 'instalado software infectuoso.', id_backup_sistema = 'backup do sistema 001', id_usuario_restaura = 'julianny@inf.ufg.br'|true|
|CT-4.8|Tabela PAPEL_USUARIO existente.|Realiza inserção de dados de um papel que o usuario exerce no sistema com dados incorretos.|INSERT INTO PAPEL_USUARIO VALUES sigla_papel = ADM, nome_papel = 'Administrador'|true|
|CT-4.9|Tabela RECURSO_SISTEMA existente.|Realiza inserção de dados de um recurso do sistema com dados incorretos.|INSERT INTO RECURSO_SISTEMA VALUES sigla_recurso = LOGIN, descricao_recurso = 'Usuario realiza o acesso ao sistema.'|true|
|CT-4.10|Tabela USUARIO_EXERCE_PAPEL existente.|Realiza inserção de dados de usuario que exerce algum papel dentro do sistema com dados incorretos.|INSERT INTO USUARIO_EXERCE_PAPEL VALUES id_usuario = 'julianny@inf.ufg.br', id_papel_sistema = ADM|true|
|CT-4.11|Tabela PAPEL_ACESSA_RECURSO existente.|Realiza inserção de dados de um papel de usario que acessa uma funcionalidade do sistema com dados incorretos..|INSERT INTO PAPEL_ACESSA_RECURSO VALUES id_papel_sistema = 'ADM', id_recurso_sistema = LOGIN|true|
|CT-4.12|Tabela SEMPREUFG existente.|Realiza inserção de dados de um sistema com dados incorretos.|INSERT INTO SEMPREUFG VALUES nome_sistema = 'SempreUFG', timestamp_instalacao = '2016-01-01 12:43:11', id_usuario_gestor = 'julianny@inf.ufg.br|true|
|CT-4.13|Tabela PARAMETRO existente.|Realiza inserção de dados dos paramentros de sistema com dados incorretos.|INSERT INTO PARAMETRO VALUES sigla_parametro = 'BACKUP_SEMANAL', tipo = 'Backup', descricao_parametro = 'Fazer backup do sistema por prevenção.', valor_parametro = backup123, id_sistema = SempreUFG|true|
