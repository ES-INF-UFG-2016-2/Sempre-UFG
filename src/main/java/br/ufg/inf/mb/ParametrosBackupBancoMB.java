package br.ufg.inf.mb;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.ufg.inf.enums.MedidasTempo;
import br.ufg.inf.enums.TipoBanco;
import br.ufg.inf.factory.FabricaBackup;
import br.ufg.inf.interfaces.BackupBancoInterface;
import br.ufg.inf.modelo.ControleTipoBanco;
import br.ufg.inf.modelo.JobsDoBanco;
import br.ufg.inf.modelo.ParametrosBackupBanco;
import br.ufg.inf.servico.BackupBancoService;


@ManagedBean(name="ParametrosBackupBancoMB")
@ViewScoped
public class ParametrosBackupBancoMB {
	
	private List<ParametrosBackupBanco> parametrosBackupBanco;
	private ParametrosBackupBanco parametroBackupBanco;
	private TipoBanco tipoBanco;
	private BackupBancoInterface backupBanco;
	private BackupBancoService backupBancoService;
	
	private String tempoBackup;
	
	public ParametrosBackupBancoMB() {
		super();
	}
	
	@PostConstruct
	public void init(){
		try {
			setTipoBanco(ControleTipoBanco.obterTipoBancoLogado());
			consultarParametrosBackup();
			setBackupBanco(FabricaBackup.criarBackup(getTipoBanco()));
			setBackupBancoService(new BackupBancoService(getTipoBanco()));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void salvarParametrosBanco(){
		if (validarEntradaDados()) {
			getParametroBackupBanco().setUnidade(MedidasTempo.valueOf(tempoBackup));
			getBackupBancoService().salvarParametrosBackup(getParametroBackupBanco());
			FacesContext.getCurrentInstance().addMessage("Sucesso", new FacesMessage("Parametros salvos com sucesso"));
			limparCamposCadastro();
		}
	}
	
	
	public void excluirParametros(){
		getBackupBancoService().removerParametros();
		consultarParametrosBackup();
		FacesContext.getCurrentInstance().addMessage("Sucesso", new FacesMessage("Parametros excluidos com sucesso"));
	}
	
	private void limparCamposCadastro() {
		setParametroBackupBanco(new ParametrosBackupBanco());
	}
	
	public void consultarParametrosBackup(){
		BackupBancoService backupBancoService = new BackupBancoService(getTipoBanco());
		List<ParametrosBackupBanco> parametrosBackupBanco = backupBancoService.consultarParametrosBackupBanco();
		setParametrosBackupBanco(parametrosBackupBanco);
	}
	
	public void inicializarServicoManualBackup(){
		new JobsDoBanco().inicializarServicoDeBackup();
		FacesContext.getCurrentInstance().addMessage("Sucesso", new FacesMessage("Serviço de backup inicializado. Será executado conforme parametrização"));
	}
	
	public boolean existemParametrosBancoCadastrados(){
		return new BackupBancoService(getTipoBanco()).existeParametrosBancoCadastrados();
	}
	
	public boolean validarEntradaDados(){
		if (existemParametrosBancoCadastrados()) {
			String msg = "Já existe parametros cadastrados para o backup do banco."+
						 "Delete-os para inserir novos, ou edite os existentes";
					
			FacesContext.getCurrentInstance().addMessage("Falha", new FacesMessage(msg));
			return false;
		}
		
		return true;
	}
	
	public String redirect(String link){
		return link+"?faces-redirect=true";
	}

	public TipoBanco getTipoBanco() {
		return tipoBanco;
	}

	public void setTipoBanco(TipoBanco tipoBanco) {
		this.tipoBanco = tipoBanco;
	}

	public List<ParametrosBackupBanco> getParametrosBackupBanco() {
		return parametrosBackupBanco;
	}

	public void setParametrosBackupBanco(List<ParametrosBackupBanco> parametrosBackupBanco) {
		this.parametrosBackupBanco = parametrosBackupBanco;
	}

	public ParametrosBackupBanco getParametroBackupBanco() {
		if (parametroBackupBanco == null) {
			setParametroBackupBanco(new ParametrosBackupBanco());
		}
		return parametroBackupBanco;
	}

	public void setParametroBackupBanco(ParametrosBackupBanco parametroBackupBanco) {
		this.parametroBackupBanco = parametroBackupBanco;
	}

	public BackupBancoService getBackupBancoService() {
		return backupBancoService;
	}

	public void setBackupBancoService(BackupBancoService backupBancoService) {
		this.backupBancoService = backupBancoService;
	}

	public BackupBancoInterface getBackupBanco() {
		return backupBanco;
	}

	public void setBackupBanco(BackupBancoInterface backupBanco) {
		this.backupBanco = backupBanco;
	}

	public String getTempoBackup() {
		return tempoBackup;
	}

	public void setTempoBackup(String tempoBackup) {
		this.tempoBackup = tempoBackup;
	}
	
	public MedidasTempo[] getUnidadeTempoExecucaoBackup(){
		return MedidasTempo.values();
	}
}
