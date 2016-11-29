package br.ufg.inf.sempreufg.modelo;

import java.util.List;

import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import br.ufg.inf.sempreufg.enums.MedidasTempo;
import br.ufg.inf.sempreufg.servico.BackupBancoService;


public class JobsDoBanco implements Job{

	public static void main(String[] args) {
		new JobsDoBanco().inicializarServicoDeBackup();
	}

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		BackupBancoService bkp = new BackupBancoService(ControleTipoBanco.obterTipoBancoLogado());
		bkp.realizarBackup();
	}

	public void inicializarServicoDeBackup(){
		BackupBancoService bkp = new BackupBancoService(ControleTipoBanco.obterTipoBancoLogado());
		List<ParametrosBackupBanco> parametros = bkp.consultarParametrosBackupBanco();
		if (parametros.isEmpty()) {
			System.out.println("Nao foi possivel inicializar o serviço de backup pois os parametros não estão configurados.");
			System.out.println("Será preciso inicializar o serviço de forma manual apos realizar o cadastro dos parametros");
		}else{
			int tempo = parametros.get(0).getTempo();
			MedidasTempo unidade = parametros.get(0).getUnidade();
			String cronSchedule = "";

			switch (unidade) {
			case DIAS:
				cronSchedule = "0 0/* * "+tempo+" * * ?";
				break;
			case HORAS:
				cronSchedule = "0 0/* "+tempo+" * * * ?";
				break;
			case MINUTOS:
				cronSchedule = "0 0/"+tempo+" * * * ?";;
				break;
			default:
				break;
			}
			init(cronSchedule);
		}
	}

	public void init(String cronExpression){
		SchedulerFactory shedFact = new StdSchedulerFactory();
		try {
			Scheduler scheduler = shedFact.getScheduler();
			scheduler.start();
			JobDetail job = JobBuilder.newJob(JobsDoBanco.class)
					.withIdentity("validadorJOB", "grupo01")
					.build();
			Trigger trigger = TriggerBuilder.newTrigger()
					.withIdentity("validadorTRIGGER","grupo01")
					.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
					.build();
			scheduler.scheduleJob(job, trigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}
