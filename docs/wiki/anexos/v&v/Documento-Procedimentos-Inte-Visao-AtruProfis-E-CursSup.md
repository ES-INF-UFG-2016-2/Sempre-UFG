# Documento de Procedimentos - Integração Visão da Atuação Proficional do Egresso e Visão da Definição de Cursos Superiores
 
## 1. Descrição do Artefato
 
|Artefato Avaliado|Descrição do Artefato|
|-----------------|---------------------|
|ExecConsTest.java|Implementação dos testes unitários referente ao RD-CursoSup na UFG|
|AtuProfsEgresTest.java|Implementação dos testes referentes ao RD-AtuProfisEgres|
 
 
## 2. Critérios de Coberturas dos Testes
 - Todos os testes implementados devem ser verificados.
 - Os testes devem passar independentemente do banco de dados configurado.
 - O artefato testado deverá conter todos os dados necessários para a execução dos testes, bem como corresponder a especificação de requisitos.
 
 ## 3. Especificação dos Testes
 ### 3.1 Procedimentos
 - O diagrama de entidade e relacionamento definido no documento de Requisitos do Software SempreUFG e as classes que implementam os teste referente ao RD-CursoSup e RD-AtuProfisEgres são as bases para criar os casos de testes.
 - O casos de testes foram aplicados nas classes referentes à implementação das tabelas pertencentes aos RD's, disponibilizadas no respositório do projeto, realizando a execução dos testes implementados, coletando seus resultados, e analizando o código de teste.
 - Os resultados coletados e analisados foram descritos no Relatório de Testes.
 - Os testes foram executados manualmente.
 
 ### 3.2 Recursos de Testes
 Não se aplica.
 
 ### 3.3 Casos de Testes
 #### 3.3.1 Entradas Válidas
 OBS: Entradas válidas temos duas situações a serem testadas:
 - rejeitar uma entrada válida.
 - aceitar causando um resultado incorreto.
 
 |Caso de Teste|Descrição|Entrada|Saida Esperada|
 |-------------|---------|-------|--------------|
 |CTV-1|Realiza inserção de localização geográfica com campos opcionais|<div>id_localizacao = 1</div><div>cidade = "Catalão"</div><div>unidade_federativa = "GO"</div><div>pais = "Brasil"</div><div>sigla = "GO"</div><div>latitude = 321343004</div><div>longitude = 03520220043</div>|true|
 |CTV-2|Realiza inserção de localização geográfica sem campos opcionais|<div>id_localizacao = 2</div><div>cidade = "Jataí"</div><div>unidade_federativa = "GO"</div><div>pais = "Brasil"</div><div>sigla = "GO"</div>|true|
 |CTV-3|Realiza inserção de regional UFG|<div>id = 1</div><div>nome_regional = "Campus Samambaia"</div><div>id_localizacao = 1</div>|true|
 |CTV-4|Realiza inserção de unidade acadêmica UFG|<div>id_unidade = 1</div><div>nome_unidade = "INF"</div><div>id_localizacao = 1</div><div>id_regional = 1</div>|true|
 |CTV-5|Realiza inserção de área de conhecimento|<div>nome_area = "Ciências Exatas e da Terra"</div><div>codigo_area = 100003</div>|true|
 |CTV-6|Realiza inserção de sub-área de conhecimento|<div>nome_area = "Matemática"</div><div>codigo_area = 100008</div><div>fk_nome_area = "Ciências Exatas e da Terra"</div><div>fk_codigo_area = 10000003</div>|true|
 |CTV-7|Realiza inserção de curso da UFG|<div>nivel = "Bacharelado"</div><div>tipo_resolucao = "CONSUNI"</div><div>num_resolucao = 32</div><div>ePresencial = true</div><div>turno = "Integral"</div><div>id_unidade_academica = 1</div><div>id_nome_area = "Ciências Exatas e da Terra"</div><div>id_codigo_area = 10000003</div>|true|
 |CTV-8|Realiza inserção de curso de outra instituição de ensino com campos opcionais|<div>id_curso_ies = 2</div><div>nome_curso = "Biologia"</div><div>nivel = "Bacharelado"</div><div>nome_unidade_academica = "Falculdade Ciencias Biologicas"</div><div>ies_curso = "Uni-Anhaguera"</div><div>tipo_instituicao = "Particular"</div><div>url = "www.unianhanguera.edu.br"</div><div>id_nome_area = "Ciências Exatas e da Terra"</div><div>id_codigo_area = 100000003</div>|true|
 |CTV-9|Realiza inserção de curso de outra instituição de ensino com campos opcionais, porém sem área de conhecimento|<div>id_curso_ies = 2</div><div>nome_curso = "Biologia"</div><div>nivel = "Bacharelado"</div><div>nome_unidade_academica = "Falculdade Ciencias Biologicas"</div><div>ies_curso = "Uni-Anhaguera"</div><div>tipo_instituicao = "Particular"</div><div>url = "www.unianhanguera.edu.br"</div>|true|
 |CTV-10|Realiza inserção de curso de outra instituição de ensino sem campos opcionais e sem área de conhecimento|<div>id_curso_ies = 3</div><div>nome_curso = "Matemática"</div><div>nivel = "Bacharelado"</div><div>ies_curso = "Universidade Estadual de Goiás"</div><div>tipo_instituicao = "Pública"</div>|true|
 |CTV-11|Realiza verificação se já existe tabela para Cursos da UFG no banco de dados|Não se aplica.|true|
 |CTV-12|Realiza verificação se já existe tabela para Cursos de outra instituição de ensino superior no banco de dados|Não se aplica.|true|
 |CTV-13|Realiza verificação se já existe tabela para área de conhecimentos no banco de dados|Não se aplica.|true|
 |CTV-14|Realiza verificação se já existe tabela para unidade acadêmica no banco de dados|Não se aplica.|true|
 |CTV-15|Realiza verificação se já existe tabela para regionais da UFG no banco de dados|Não se aplica.|true|
 |CTV-16|Realiza verificação se já existe tabela para localizações geográficas no banco de dados|Não se aplica.|true|
 |CTV-17|Realiza incerção de data de início|<div>data = 20122012</div>|true|
 |CTV-18|Realiza incerção da data fim|<div>data = 20122012</div>|true|
 |CTV-19|Realiza incerção da forma ingresso|<div>forma = "Concurso"</div>|true|
 |CTV-20|Realiza incerção da renda mensal média|<div>renda = 880.90</div>|true|
 |CTV-21|Realiza incerção de satisfação com renda mensal|<div>satisfacao = 5</div>|true|
 |CTV-22|Realiza incersão de perspectiva futuro|<div>perspectiva = 5</div>|true|
 |CTV-23|Realiza incerção de comentário|<div>comentario = "Muito bom"</div>|true|
 
 #### 3.3.2 Entradas Inválidas
 |Caso de Teste|Descrição|Entrada|Saida Esperada|
 |-------------|---------|-------|--------------|
 |CTI-1|Realiza inserção de localização geográfica com identificador duplicado|<div><div>{id_localizacao = 1</div><div>cidade = "Catalão"</div><div>unidade_federativa = "GO"</div><div>pais = "Brasil"</div><div>sigla = "GO"</div><div>latitude = 321343004</div><div>longitude = 03520220043</div>}</div><div>{id_localizacao = 1</div><div>cidade = "Jataí"</div><div>unidade_federativa = "GO"</div><div>pais = "Brasil"</div><div>sigla = "GO"</div><div>latitude = 321343004</div><div>longitude = 03520220043</div>}</div>|false|
 |CTI-2|Realiza inserção de regional UFC com identificador inexistente|<div>id = 1</div><div>nome_regional = "Campus Samambaia"</div><div>id_localizacao = -2</div>|false|
 |CTI-3|Realiza inserção de regional UFC com identificador regional duplicado|<div>{<div>id = 1</div><div>nome_regional = "Campus Samambaia"</div><div>id_localizacao = 1</div>}</div><div>{<div>id = 1</div><div>nome_regional = "Campus I"</div><div>id_localizacao = 1</div>}</div>|false|
 |CTI-4|Realiza inserção de unidade acadêmica UFG com identificador de localização inexistente|<div>id_unidade = 1</div><div>nome_unidade = "INF"</div><div>id_localizacao = -2</div><div>id_regional = 1</div>|false|
 |CTI-5|Realiza inserção de unidade acadêmica UFG com identificador de regional inexistente|<div>id_unidade = 1</div><div>nome_unidade = "INF"</div><div>id_localizacao = 1</div><div>id_regional = -2</div>|false|
 |CTI-6|Realiza inserção de unidade acadêmica UFG com identificador de unidade duplicado|<div>{<div>id_unidade = 1</div><div>nome_unidade = "INF"</div><div>id_localizacao = 1</div><div>id_regional = 1</div>}</div><div>{<div>id_unidade = 1</div><div>nome_unidade = "IME"</div><div>id_localizacao = 1</div><div>id_regional = 1</div>}</div>|false|
 |CTI-7|Realiza inserção de área de conhecimento da UFG com identificador de nome de área duplicado|<div>{<div>nome_area = "Ciências Exatas e da Terra"</div><div>id_localizacao = 1011003</div>{<div>nome_area = "Ciências Exatas e da Terra"</div><div>id_localizacao = 1000003</div>}</div>|false|
 |CTI-8|Realiza inserção de área de conhecimento da UFG com identificador de código de área duplicado|<div>{<div>nome_area = "Ciências Exatas e da Terra"</div><div>id_localizacao = 1011003</div>{<div>nome_area = "Ciências Biológicas"</div><div>id_localizacao = 1011003</div>}</div>|false|
 |CTI-9|Realiza inserção de sub-área de conhecimento com identificador de área duplicado|<div>{<div>nome_area = "Matemática"</div><div>codigo_area = 100008</div><div>fk_nome_area = "Ciências Exatas e da Terra"</div><div>fk_codigo_area = 10000003</div>}</div><div>{<div>nome_area = "Matemática"</div><div>codigo_area = 100238</div><div>fk_nome_area = "Ciências Exatas e da Terra"</div><div>fk_codigo_area = 10000003</div>}</div>|false|
 |CTI-10|Realiza inserção de sub-área de conhecimento com identificador de código duplicado|<div>{<div>nome_area = "Matemática"</div><div>codigo_area = 100008</div><div>fk_nome_area = "Ciências Exatas e da Terra"</div><div>fk_codigo_area = 10000003</div>}</div><div>{<div>nome_area = "Engenharia de Software"</div><div>codigo_area = 100008</div><div>fk_nome_area = "Ciências Exatas e da Terra"</div><div>fk_codigo_area = 10000003</div>}</div>|false|
 |CTI-11|Realiza inserção de sub-área de conhecimento com identificador de nome de área inexistente|<div>nome_area = "XXSADASDA"</div><div>codigo_area = 100008</div><div>fk_nome_area = "Ciências Exatas e da Terra"</div><div>fk_codigo_area = 10000003</div>|false|
 |CTI-12|Realiza inserção de sub-área de conhecimento com identificador de código de área inexistente|<div>nome_area = "Matemática"</div><div>codigo_area = -12315</div><div>fk_nome_area = "Ciências Exatas e da Terra"</div><div>fk_codigo_area = 10000003</div>|false|
 |CTI-13|Realiza inserção de sub-área de conhecimento com identificador de código de área inexistente|<div>nome_area = "Matemática"</div><div>codigo_area = -12315</div><div>fk_nome_area = "Ciências Exatas e da Terra"</div><div>fk_codigo_area = 10000003</div>|false|
 |CTI-14|Realiza inserção de sub-área de conhecimento sem área principal|<div>nome_area = "Matemática"</div><div>codigo_area = -12315</div><div>fk_nome_area = null</div><div>fk_codigo_area = 0</div>|false|
 |CTI-15|Realiza inserção de curso da UFG com identificador de unidade acadêmica inexistente|<div>nivel = "Bacharelado"</div><div>tipo_resolucao = "CONSUNI"</div><div>num_resolucao = 32</div><div>ePresencial = true</div><div>turno = "Integral"</div><div>id_unidade_academica = -10</div><div>id_nome_area = "Ciências Exatas e da Terra"</div><div>id_codigo_area = 10000003</div>|true|
 |CTI-16|Realiza inserção de curso da UFG com identificador de área de conhecimento inexistente|<div>nivel = "Bacharelado"</div><div>tipo_resolucao = "CONSUNI"</div><div>num_resolucao = 32</div><div>ePresencial = true</div><div>turno = "Integral"</div><div>id_unidade_academica = -10</div><div>id_nome_area = "Ciências Exatas e da Terra"</div><div>id_codigo_area = -102312</div>|true|
 |CTI-17|Realiza inserção de curso da UFG com identificador de nome de área de conhecimento inexistente|<div>nivel = "Bacharelado"</div><div>tipo_resolucao = "CONSUNI"</div><div>num_resolucao = 32</div><div>ePresencial = true</div><div>turno = "Integral"</div><div>id_unidade_academica = -10</div><div>id_nome_area = "HSA12312"</div><div>id_codigo_area = 1000003</div>|true|
 |CTI-18|Realiza inserção de curso de outra instituição de ensino (IES) com campos opcionais, com área de conhecimento e com identificador de IES duplicado|<div>{<div>id_curso_ies = 2</div><div>nome_curso = "Letras"</div><div>nivel = "Bacharelado"</div><div>nome_unidade_academica = "Falcudade de Letras"</div><div>ies_curso = "UNIP"</div><div>tipo_instituicao = "Particular"</div><div>url = "www.unip.edu.br"</div>}</div><div>{<div>id_curso_ies = 2</div><div>nome_curso = "Enfermagem"</div><div>nivel = "Bacharelado"</div><div>nome_unidade_academica = "Falcudade de Ciências Biológicas"</div><div>ies_curso = "UNIP"</div><div>tipo_instituicao = "Particular"</div><div>url = "www.unip.edu.br"</div>}</div>|true|
 |CTI-19|Realiza inserção de curso de outra instituição de ensino (IES) com campos opcionais, com área de conhecimento e com identificador do nome do curso inexistente|<div>id_curso_ies = 2</div><div>nome_curso = "HSU1231A"</div><div>nivel = "Bacharelado"</div><div>nome_unidade_academica = "Falcudade de Letras"</div><div>ies_curso = "UNIP"</div><div>tipo_instituicao = "Particular"</div><div>url = "www.unip.edu.br"</div>|true|
 |CTI-20|Realiza inserção de curso de outra instituição de ensino (IES) com campos opcionais, com área de conhecimento e com identificador do código do curso inexistente|<div>id_curso_ies = -10</div><div>nome_curso = "Português"</div><div>nivel = "Bacharelado"</div><div>nome_unidade_academica = "Falcudade de Letras"</div><div>ies_curso = "UNIP"</div><div>tipo_instituicao = "Particular"</div><div>url = "www.unip.edu.br"</div>|true|
 |CTV-21|Realiza incerção de data de início inválida|<div>data = -40</div>|false|
 |CTV-22|Realiza incerção de data de início inválida|<div>data = 0</div>|false|
 |CTV-23|Realiza incerção da data fim inválida|<div>data = -32</div>|false|
 |CTV-24|Realiza incerção da forma ingresso inválida|<div>forma = ""</div>|false|
 |CTV-25|Realiza incerção da renda mensal média inválida|<div>renda = -3</div>|false|
 |CTV-26|Realiza incerção de satisfação com renda mensal inválida|<div>satisfacao = -2</div>|false|
 |CTV-27|Realiza incersão de perspectiva futuro inválida|<div>perspectiva = 12</div>|false|
 |CTV-28|Realiza incerção de comentário inválido|<div>comentario = ""</div>|false|
