import java.time.LocalDateTime;

public class Consulta {
	private Paciente paciente;
	private Medico medico;
	private LocalDateTime data;
	//status da consulta: agendado ou concluido.
	
	public Consulta(Paciente paciente, Medico medico, LocalDateTime data) {
		this.paciente = paciente;
		this.medico = medico;
		this.data = data;
	}
	
	public Paciente getPaciente() {return paciente;}
	public void setPaciente(Paciente var) {this.paciente = var;}
	
	public Medico getMedico() {return medico;}
	public void setMedico(Medico var) {this.medico = var;}
	
	public LocalDateTime getData() {return data;}
	public void setData(LocalDateTime var) {this.data = var;}
	
	public boolean agendarConsulta() {
		if (medico.verificarDisponibilidade()) {			
			System.out.println("Consulta marcada com sucesso, data da consulta: "+ data);
			return true;
		}else {
			System.out.println("Consulta indisponível!");
			return false;
		}
	}
	
	public void exibirDetalhes() {
		System.out.println("Detalhes da consulta: ");
		System.out.println("Nome do paciente: "+ paciente.getNome() + "\nNome do medico: " + medico.getNome() + "\nData da consulta: " + getData());
	}
}
