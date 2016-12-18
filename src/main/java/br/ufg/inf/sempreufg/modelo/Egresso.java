package br.ufg.inf.sempreufg.modelo;

import br.ufg.inf.sempreufg.enums.Sexo;
import br.ufg.inf.sempreufg.enums.VisibilidadeDados;
import org.json.JSONObject;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Egresso")
public class Egresso extends Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="idEgresso")
    @SequenceGenerator(name="idEgresso", initialValue=01, sequenceName="EGRESSO_ID_SEQUENCE", allocationSize=1)
    private int id;
    private String nome;
    private String nome_mae;
    private Date data_nascimento;
    private Sexo sexo;
    @Transient
    private String email_alternativo;
    private VisibilidadeDados visibilidade;
    @Transient
    private BitSet foto_principal;
    @Transient
    private BitSet fotos_adicionais;

    private List<HistoricoUFG> lista_historicosUFG;
    private LocalizacaoGeografica naturalidade;

    private static final long serialVersionUID = 3370581220250685348L;

    public Egresso(String nome, String nome_mae, Date data_nascimento, Sexo sexo, String email_alternativo, BitSet foto_principal, BitSet fotos_adicionais, VisibilidadeDados visibilidade, List<HistoricoUFG> lista_historicosUFG, LocalizacaoGeografica naturalidade) {
        this.nome = nome;
        this.nome_mae = nome_mae;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
        this.email_alternativo = email_alternativo;
        this.foto_principal = foto_principal;
        this.fotos_adicionais = fotos_adicionais;
        this.visibilidade = visibilidade;
        this.lista_historicosUFG = lista_historicosUFG;
        this.naturalidade = naturalidade;
    }

    public Egresso(String nome, String nome_mae, Date data_nascimento, Sexo sexo, VisibilidadeDados visibilidade, List<HistoricoUFG> lista_historicosUFG, LocalizacaoGeografica naturalidade) {
        this.nome = nome;
        this.nome_mae = nome_mae;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
        this.visibilidade = visibilidade;
        this.lista_historicosUFG = lista_historicosUFG;
        this.naturalidade = naturalidade;
    }

    public Egresso() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    private JSONObject getLista_historicosUFGAsJson(){
        JSONObject listaHistoricosUFGAsJsonObject = new JSONObject();
        this.lista_historicosUFG.forEach(historicoUFG -> listaHistoricosUFGAsJsonObject.put( String.valueOf(historicoUFG.getId()), historicoUFG.toJson()));
        return listaHistoricosUFGAsJsonObject;
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

    public JSONObject getNaturalidadeAsJson() {
        return naturalidade.toJson();
    }

    public JSONObject toJson(){

        JSONObject egressoAsJsonObject = new JSONObject();
        JSONObject innerJson = new JSONObject();

        innerJson.put("nome", getNome());
        innerJson.put("nome_mae", getNome_mae());
        innerJson.put("data_nascimento", getData_nascimento().toString());
        innerJson.put("sexo", getSexo().toString());
        innerJson.put("visibilidade", getVisibilidade().toString());
        innerJson.put("lista_historicosUFG", getLista_historicosUFGAsJson());
        innerJson.put("naturalidade", getNaturalidadeAsJson());

        egressoAsJsonObject.put( Integer.toString(getId()) , innerJson);
        return egressoAsJsonObject;
    }

    public static Egresso fromJson(JSONObject egressoAsJson) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("mm/dd/yy");
        LocalizacaoGeografica naturalidade = LocalizacaoGeografica.fromJson(egressoAsJson.getJSONObject("naturalidade"));

        List<HistoricoUFG> listaHistoricosUFG = new ArrayList<>();
        egressoAsJson.getJSONObject("lista_historicosUFG").names().forEach( historicoUFGAsJsonObject -> {
            listaHistoricosUFG.add(HistoricoUFG.fromJson((JSONObject) historicoUFGAsJsonObject));
        });

        return new Egresso(
            egressoAsJson.getString("nome"),
            egressoAsJson.getString("nome_mae"),
            formatter.parse(egressoAsJson.getString("data_nascimento")),
            Sexo.valueOf(egressoAsJson.getString("sexo")),
            VisibilidadeDados.valueOf(egressoAsJson.getString("visibilidade")),
            listaHistoricosUFG,
            naturalidade
        );
    }


}
