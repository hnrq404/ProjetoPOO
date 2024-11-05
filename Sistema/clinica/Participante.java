package clinica;

public class Participante {
    private Medico medico;
    private String nome;
    private int idade;
    private String cpf;
    private String email;
    private String tipo;

    public Participante(String nome, int idade, String cpf, String email, String tipo){
        this.idade = idade;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.tipo = tipo;
        if (!this.tipo.equals("espectador") && !this.tipo.equals("palestrante")) {
            throw new IllegalArgumentException("O tipo deve ser 'espectador' ou 'palestrante'.");
        }
    }

    public Participante (Medico medico){
        this.nome = medico.getNome();
        this.idade = medico.getIdade();
        this.cpf = medico.getCPF();
        this.email = medico.getEmail();
        this.medico = medico;
        this.tipo = "palestrante";
    }

    public String getEspecialidade() {
        if (medico != null) {
            return medico.getEspecialidade();
        } else {
            return "Não aplicável";
        }
    }
    
    public String getNome(){return this.nome;}

    public void setNome(String var){this.nome = var;}

    public int getIdade(){return this.idade;}

    public void setIdade(int var){this.idade = var;}

    public String getCPF(){return this.cpf;}
    
    public void setCPF(String var){this.cpf = var;}

    public String getEmail(){return this.email;}

    public void setEmail(String var){this.email = var;}

    public String getTipo(){return this.tipo;}

    public void setTipo(String var){
        this.tipo = var;
        if (!this.tipo.equals("participante") && !this.tipo.equals("palestrante")) {
            throw new IllegalArgumentException("O tipo deve ser 'participante' ou 'palestrante'.");
        }
    }

}
