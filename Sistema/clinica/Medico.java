package clinica;

import java.util.ArrayList;
import java.util.List;

public abstract class Medico implements Agendavel {
	private String nome;
	private int idade;
	private String cpf;
	private String email;
	private String crm;
	private String especialidade;
	private boolean disponivel = true;

	// Lista estática para armazenar médicos
	private static List<Medico> medicos = new ArrayList<>();

	public abstract void realizarConsulta(); // Método abstrato para polimorfismo

	 // Sobrecarga de métodos: Relatórios de médicos
	 public void gerarRelatorio() {
        System.out.println("Relatório do médico: " + nome + ", Especialidade: " + especialidade);
    }

    public void gerarRelatorio(String paciente) {
        System.out.println("Relatório do médico: " + nome + ", Paciente atendido: " + paciente);
    }

    public void gerarRelatorio(String paciente, String data) {
        System.out.println("Relatório do médico: " + nome + ", Paciente atendido: " + paciente + ", Data: " + data);
    }

	public Medico(String nome, int idade, String cpf, String email, String crm, String especialidade) {
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.email = email;
		this.crm = crm;
		this.especialidade = especialidade;
	}

	// Métodos existentes...
	public String getNome() {
		return nome;
	}

	public void setNome(String var) {
		this.nome = var;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int var) {
		this.idade = var;
	}

	public String getCPF() {
		return cpf;
	}

	public void setCPF(String var) {
		this.cpf = var;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String var) {
		this.email = var;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String var) {
		this.crm = var;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String var) {
		this.especialidade = var;
	}

	public boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean var) {
		this.disponivel = var;
	}

	public boolean verificarDisponibilidade() {
		return disponivel;
	}

	public void exibirDados() {
		System.out.println("Dados do medico: ");
		System.out.println("Nome: " + nome + ",\nIdade: " + idade + ",\ncrm: " + crm + ",\nEspecialidade: " + especialidade + "\n");
	}

	// Métodos para gerenciar a lista de médicos
	public static void adicionarMedico(Medico medico) {
		medicos.add(medico);
	}

	public static List<Medico> obterMedicos() {
		return medicos;
	}
}
