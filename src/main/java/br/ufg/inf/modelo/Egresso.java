package br.ufg.inf.modelo;

import br.ufg.inf.enums.Sexo;
import br.ufg.inf.enums.VisibilidadeDados;

import java.util.BitSet;
import java.util.Date;
import java.util.List;

/**
 * Created by user1 on 09/10/2016.
 */
public class Egresso extends Usuario {
    private String nome;
    private String nome_mae;
    private Date data_nascimento;
    private Sexo sexo;
    private String email_alternativo;
    private BitSet foto_principal;
    private BitSet fotos_adicionais;
    private VisibilidadeDados visibilidade;
    private List<HistoricoUFG> lista_historicosUFG;
    private LocalizacaoGeografica naturalidade;

    public Egresso() {
    }
    
    public Egresso(String nome, String nome_mae, Date data_nascimento, Sexo sexo, String email_alternativo, BitSet foto_principal, BitSet fotos_adicionais, VisibilidadeDados visibilidade, List<HistoricoUFG> lista_historicosUFG) {
        this.nome = nome;
        this.nome_mae = nome_mae;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
        this.email_alternativo = email_alternativo;
        this.foto_principal = foto_principal;
        this.fotos_adicionais = fotos_adicionais;
        this.visibilidade = visibilidade;
        this.lista_historicosUFG = lista_historicosUFG;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome_mae() {
        return nome_mae;
    }

    public void setNome_mae(String nome_mae) {
        this.nome_mae = nome_mae;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getEmail_alternativo() {
        return email_alternativo;
    }

    public void setEmail_alternativo(String email_alternativo) {
        this.email_alternativo = email_alternativo;
    }

    public BitSet getFoto_principal() {
        return foto_principal;
    }

    public void setFoto_principal(BitSet foto_principal) {
        this.foto_principal = foto_principal;
    }

    public BitSet getFotos_adicionais() {
        return fotos_adicionais;
    }

    public void setFotos_adicionais(BitSet fotos_adicionais) {
        this.fotos_adicionais = fotos_adicionais;
    }

    public VisibilidadeDados getVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade(VisibilidadeDados visibilidade) {
        this.visibilidade = visibilidade;
    }

    public List<HistoricoUFG> getLista_historicosUFG() {
        return lista_historicosUFG;
    }

    public void setLista_historicosUFG(List<HistoricoUFG> lista_historicosUFG) {
        this.lista_historicosUFG = lista_historicosUFG;
    }

    public LocalizacaoGeografica getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(LocalizacaoGeografica naturalidade) {
        this.naturalidade = naturalidade;
    }
    
}
