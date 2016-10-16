-- teste para verificar a inserção em condições ideais

delimiter //

create procedure Inserir_modoIdeal(
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

  declare exit handler for

  insert into egresso (nome, nome_mae, data_nascimento, foto_principal, foto_adicionais, visibilidade, sexo, id_localizacao)
    values (nome, nome_mae, data_nascimento, null, null, visibilidade, sexo, id_localizacao);

end
//
