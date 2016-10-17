/*
 * Não foram realizadas verificações nos relacionamentos exceto o relacionamento
 * da tabela EnsMedioEgres com a tabela LocalizGeograf por haver a restrição de
 * que apenas um elemento da tabela EnsMedioEgres relaciona somente com uma ou nenhuma
 * tabela de LocalizGeograf.
 */

-- Criação de teste para verificar a inserção dos dados somente na tabela Egresso

delimiter //

create procedure inserir_somenteEgresso(
  in nome varchar(50),
  in nome_mae varchar(50),
  in data_nascimento date,
  in foto_principal longblob,
  in foto_adicionais longblob,
  in visibilidade enum('privado', 'publico', 'so egresso'),
  in sexo enum('masculino', 'feminino'),
  in id_localizacao integer
)
begin

  declare exit handler for 1265
  select 'Tipo do dado nao permitido';

  declare exit handler for 1318
  select 'chamada necessita parametros';

  insert into egresso (nome, nome_mae, data_nascimento, foto_principal, foto_adicionais, visibilidade, sexo, id_localizacao)
    values (nome, nome_mae, data_nascimento, null, null, visibilidade, sexo, id_localizacao);

end
//

delimiter ;

-- Criação de teste para verificar a inserção dos dados somente na tabela Instituição de Ensino Medio

delimiter //

create procedure inserir_ensinoMedio(
  in id_egresso bigint,
  in id_localizacao bigint,
  in nome_instituicao text,
  in tipo_instituicao enum('Federal','Estadual','Municipal','Particular')
)
begin

  declare exit handler for 1265
  select 'Tipo de dado nao permitido';

  declare exit handler for 1318
  select 'chamada necessita parametros';

  insert into EnsMedioEgres (id_egresso, id_localizacao, nome_iem, tipo_iem) values (id_egresso, id_localizacao, nome_instituicao, tipo_instituicao);

end
//

delimiter ;
-- Criação de teste para verificar a inserção dos dados somente na tabela de Localização geográfica

delimiter //

create procedure inserir_localizacaoGeografica(
  in cidade text,
  in UF text,
  in pais text,
  in siglaUF text,
  in latitude float,
  in longitude float,
  in id_localizacao bigint
)
begin

  declare exit handler for 1265
  select 'Tipo de dado nao permitido';

  declare exit handler for 1318
  select 'chamada necessita parametros';

  insert into LocalizGeograf (cidade, unid_federativa, pais, sigla_unid_federativa, latitude, longitude, id_localizacao)
    values (cidade, UF, pais, siglaUF, latitude, longitude, id_localizacao);

end
//

delimiter ;

-- Criação de teste para verificar a consistencia dos dados na tabela HistEnsMedio

delimiter //

create procedure inserir_historicoEnsinoMedio(
  in id_egresso bigint,
  in id_EnsMedio text,
  in mes_inicio integer,
  in ano_inicio integer,
  in mes_fim integer,
  in ano_fim integer
)
begin

  declare exit handler for 1265
  select 'Tipo do dado nao permitido';

  declare exit handler for 1318
  select 'chamada necessita parametros';

  insert into HistEnsMedio (id_egresso, id_EnsMedio, mes_inicio, ano_inicio, mes_fim, ano_fim)
    values (id_egresso, id_EnsMedio, mes_inicio, ano_inicio, mes_fim, ano_fim);

end
//

delimiter ;

-- Criação de teste para verificar os relacionamentos

delimiter //

create function verificaQuantidade(i int)
  returns text

  begin
    declare s text;

    if i > 1 then s = 'erro de relacionamento: Possivel quebra N:1';
    else s = 'relacionamento correto';
    end if

    return s;
  end //

delimiter ;

delimiter //

create procedure buscaRows(out quantidade int)
  begin

  select id_localizacao, count(*) into quantidade from EnsMedioEgres group by id_localizacao;

  end //

delimiter ;

-- Execução dos testes de stored procedures para Egresso.

call inserir_somenteEgresso('Joao Aluísio', 'Marilia Pereira de Sousa', '20/03/1995', NULL, NULL, 2, 1, 1);

call inserir_somenteEgresso('Diego Pereira da Silva', 'Tania Maria ALlves', '12/12/1995', NULL, NUll, 70, 1, 1);

call inserir_somenteEgresso('Diego Pereira da Silva', 3.7, '12/12/1995', NULL, NUll, 2, 1, 1);

call inserir_somenteEgresso('Joao Aluísio', 'Marilia Pereira de Sousa', 20/03/1995, NULL, NULL, 2, 1, 1);

call inserir_somenteEgresso('Joao Aluísio', 'Marilia Pereira de Sousa', '20/03/1995', 'teste com string', NULL, 2, 1, 1);

call inserir_somenteEgresso('Joao Aluísio', 'Marilia Pereira de Sousa', '20/03/1995', NULL, 2, 2, 1, 1);

-- Execução dos testes de stored procedures para LocalizGeograf

call inserir_localizacaoGeografica('Goiania', 'Goias', 'Brasil', 'GO', -16.6868910, -49.2647940, 1);

call inserir_localizacaoGeografica('Goiania', 'Goias', 'Brasil', 'GO', NULL, NULL, 70);

call inserir_localizacaoGeografica('Goiania', 'Goias', 'Brasil', 'GO', -16.6868910, -49.2647940, 'teste');

call inserir_localizacaoGeografica('Goiania', 'Goias', 'Brasil', 2, -16.6868910, -49.2647940, 1);

call inserir_localizacaoGeografica('Goiania', 'Goias', 2, 'GO', -16.6868910, -49.2647940, 1);

call inserir_localizacaoGeografica(2, 'Goias', 'Brasil', 'GO', -16.6868910, -49.2647940, 1);

call inserir_localizacaoGeografica('Goiania', 2, 'Brasil', 'GO', -16.6868910, -49.2647940, 1);

call inserir_localizacaoGeografica('Goiania', 'Goias', 'Brasil', 'GO', -16.6868910, 'teste para verificação', 1);

call inserir_localizacaoGeografica('Goiania', 'Goias', 'Brasil', 'GO', 'teste para verificação', -49.2647940, 1);

-- Execução de testes de stored procedure para EnsMedioEgres

call inserir_ensinoMedio(1, 2, 'Colegio Estadual Fulano de tal', 2);

call inserir_ensinoMedio(1, 2, 2, 2);

call inserir_ensinoMedio(11, 2300, 'Colegio Estadual Fulano de tal', 5);

call inserir_ensinoMedio('teste de inserção invalida', 2, 'Colegio Estadual Fulano de tal', 2);

call inserir_ensinoMedio(1, 'teste de inserção invalida', 'Colegio Avila', 4);

call inserir_historicoEnsinoMedio(1, 'Colegio Vera Cruz II', 03, 10, 04, 13);

call inserir_historicoEnsinoMedio('teste de inserção invalida', 'Colegio Vera Cruz II', 03, 10, 04, 13);

call inserir_historicoEnsinoMedio(1, 3, 03, 10, 04, 13);

call inserir_historicoEnsinoMedio(1, 'Colegio Vera Cruz II', 8288, 99999, 99999, 8873);

call inserir_historicoEnsinoMedio(1, 'Colegio Vera Cruz II', 'teste de inserção invalida', 10, 04, 13);

-- Execução do teste de relacionamento

call buscaRows(@quantidadeRows);
select verificaQuantidade(select @quantidadeRows);
