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

-- Criação de teste para verificar os relacionamentos

delimiter //

create function verificaQuantidade(i int)
  returns text

  begin
    declare s text;

    if i > 1 then s = 'erro relacionamento um para muitos';
    else s = 'relacionamento correto';
    end if

    return s;
  end //

delimiter ;

delimiter //

create procedure buscaRows(out x int)
  begin
    select count(*) into x from EnsMedioEgres
    inner join LocalizGeograf on EnsMedioEgres.id_localizacao = LocalizGeograf.id_localizacao;
    order by EnsMedioEgres.nome_iem asc;

  end //

delimiter ;
