package br.ufg.inf.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="StartMB")
@ViewScoped
public class StartMB {
	
	public void start(){
			FacesContext.getCurrentInstance().addMessage("Sucesso", new FacesMessage("Viu Nao acontece nada"));
	}
	
}
