package br.ufg.inf.sempreufg.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.BitSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import br.ufg.inf.sempreufg.enums.Sexo;
import br.ufg.inf.sempreufg.enums.VisibilidadeDados;

@Entity(name = "egresso")
public class Egresso implements Serializable{
	
	private static final long serialVersionUID = 3370581220250685348L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String numeroMatricula;
	private String nome;
	private String nomeMae;
	private LocalDate dataNascimento;
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	private String email;
	private String emailAlternativo;
	
	private BitSet fotoPrincipal;
    private BitSet fotosAdicionais;
	
	@Enumerated(EnumType.STRING)
	private VisibilidadeDados visibilidadeDeDados;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "residencia")
	private Residencia residencia;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instituicaoEnsino")
	private InstituicaoEnsino instituicaoEnsino;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "historicoEnsinoMedio")	
	private HistoricoOutrasIES historicoOutrasIES;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="egresso_curso_outra_instituicao_ensino", joinColumns={@JoinColumn(name="egresso")}, inverseJoinColumns={@JoinColumn(name="cursos_outra_instituicao_ensino")})
	private List<CursoOutrasIES> cursosOutrasIES;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="egresso_historico_ufg", joinColumns={@JoinColumn(name="egresso")}, inverseJoinColumns={@JoinColumn(name="historico_ufg")})
	private List<HistoricoUFG> historicoUfg;
	
	public Egresso(String numeroMatricula, String nome, String nomeMae, LocalDate dataNascimento, Sexo sexo,
			String email, String emailAlternativo, BitSet fotoPrincipal, BitSet fotosAdicionais,
			VisibilidadeDados visibilidadeDeDados, Residencia residencia,
			InstituicaoEnsino instituicaoEnsino, HistoricoOutrasIES historicoOutrasIES,
			List<CursoOutrasIES> cursosOutrasIES, List<CursoUFG> cursosUfg, List<HistoricoUFG> historicoUfg) {
		super();
		this.numeroMatricula = numeroMatricula;
		this.nome = nome;
		this.nomeMae = nomeMae;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.email = email;
		this.emailAlternativo = emailAlternativo;
		this.fotoPrincipal = fotoPrincipal;
		this.fotosAdicionais = fotosAdicionais;
		this.visibilidadeDeDados = visibilidadeDeDados;
		this.residencia = residencia;
		this.instituicaoEnsino = instituicaoEnsino;
		this.historicoOutrasIES = historicoOutrasIES;
		this.cursosOutrasIES = cursosOutrasIES;
		this.historicoUfg = historicoUfg;
	}
	
	public Egresso(){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailAlternativo() {
		return emailAlternativo;
	}

	public void setEmailAlternativo(String emailAlternativo) {
		this.emailAlternativo = emailAlternativo;
	}

	public BitSet getFotoPrincipal() {
		return fotoPrincipal;
	}

	public void setFotoPrincipal(BitSet fotoPrincipal) {
		this.fotoPrincipal = fotoPrincipal;
	}

	public BitSet getFotosAdicionais() {
		return fotosAdicionais;
	}

	public void setFotosAdicionais(BitSet fotosAdicionais) {
		this.fotosAdicionais = fotosAdicionais;
	}

	public VisibilidadeDados getVisibilidadeDeDados() {
		return visibilidadeDeDados;
	}

	public void setVisibilidadeDeDados(VisibilidadeDados visibilidadeDeDados) {
		this.visibilidadeDeDados = visibilidadeDeDados;
	}

	public Residencia getResidencia() {
		return residencia;
	}

	public void setResidencia(Residencia residencia) {
		this.residencia = residencia;
	}

	public InstituicaoEnsino getInstituicaoEnsino() {
		return instituicaoEnsino;
	}

	public void setInstituicaoEnsino(InstituicaoEnsino instituicaoEnsino) {
		this.instituicaoEnsino = instituicaoEnsino;
	}

	public HistoricoOutrasIES getHistoricoOutrasIES() {
		return historicoOutrasIES;
	}

	public void setHistoricoOutrasIES(HistoricoOutrasIES historicoOutrasIES) {
		this.historicoOutrasIES = historicoOutrasIES;
	}

	public List<CursoOutrasIES> getCursosOutrasIES() {
		return cursosOutrasIES;
	}

	public void setCursosOutrasIES(List<CursoOutrasIES> cursosOutrasIES) {
		this.cursosOutrasIES = cursosOutrasIES;
	}

	public List<HistoricoUFG> getHistoricoUfg() {
		return historicoUfg;
	}

	public void setHistoricoUfg(List<HistoricoUFG> historicoUfg) {
		this.historicoUfg = historicoUfg;
	}
}
