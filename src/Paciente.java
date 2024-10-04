public class Paciente {
	private String nome;
	private int idade;
	private String cpf;
	private String telefone;
	//a doença do paciente.
	//uma lista de consultas que o paciente está marcado.
	
	
	public Paciente(String nome, int idade, String cpf, String telefone) {
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.telefone = telefone;
	}
	
	public String getNome(){return nome;}
	public void setNome(String var) {this.nome = var;}
	
	public int getIdade(){return idade;}
	public void setIdade(int var) {this.idade = var;}
	
	public String getCpf(){return cpf;}
	public void setCpf(String var) {this.cpf = var;}
	
	
	public String getTelefone(){return telefone;}
	public void setTelefone(String var) {this.telefone = var;}

	public void exibirDados() {
		System.out.println("Dados do paciente: ");
		System.out.println("Nome: "+ nome +",\nIdade: "+ idade + ",\ncpf: "+ cpf +",\ntelefone: "+ telefone + "\n");
	}
}
