package eventos;

import java.util.ArrayList;
import java.util.List;

public abstract class Evento implements Reservavel {
    private String nome;
    private String descricao;
    private Local local;
    private List <Participante> participantes = new ArrayList<>();
    public Evento(String nome,String descricao,Local local){
        this.nome = nome;
        this.descricao = descricao;
        this.local = local;
    }
    public void cadastrarParticipante(Participante participante){
        if (local.getQuantidade() == local.getCapacidade()){
            System.out.println("O evento já atingiu a capacidade máxima");
            return;
        }
        participantes.add(participante);
        local.addQuantidade();
    }

    // Implementação da interface Organizável
    @Override
    public void definirCronograma(String horario, String atividade) {
        System.out.println("Atividade '" + atividade + "' definida para o horário: " + horario + " no evento '" + this.nome + "'.");
    }

    @Override
    public void adicionarPalestrante(String nome) {
        System.out.println("Palestrante '" + nome + "' adicionado ao evento '" + this.nome + "'.");
    }

    @Override
    public void adicionarPalestrante(String nome, String areaDeEspecialidade) {
        System.out.println("Palestrante '" + nome + "' (Especialidade: " + areaDeEspecialidade + ") adicionado ao evento '" + this.nome + "'.");
    }

    // Sobrecarga de métodos: Registro de participantes
    public void registrarParticipante(String nome) {
        System.out.println("Registrando o participante: " + nome + " no evento '" + this.nome + "'.");
    }

    public void registrarParticipante(String nome, String email) {
        System.out.println("Registrando o participante: " + nome + " (Email: " + email + ") no evento '" + this.nome + "'.");
    }

    public void registrarParticipante(String nome, String email, String telefone) {
        System.out.println("Registrando o participante: " + nome + " (Email: " + email + ", Telefone: " + telefone + ") no evento '" + this.nome + "'.");
    }

    public void setNome(String var){
        this.nome = var;
    }
    public String getNome(){
        return this.nome;
    }
    public void setDescricao(String var){
        this.descricao = var;
    }
    public String getDescricao() {
        return this.descricao;
    }
    public void setLocal(Local var){
        this.local = var;
    }
    public Local getLocal(){
        return this.local;
    }

    public abstract void organizarEvento(); // Método abstrato para polimorfismo

    public void exibirDados(){
        System.out.println("Nome do evento: " + this.nome);
        System.out.println("Descrição do evento: " + this.descricao);
        local.exibirDados();
        System.out.println("Palestrantes: ");
        for (Participante pessoa : participantes) {
            if (pessoa.getTipo() == "palestrante"){
                System.out.println(pessoa.getNome());
            }
        }
    }
    public List <Participante> getParticipantes(){
        return participantes;
    }

    public boolean verificarLotacao() {
        return participantes.size() >= local.getCapacidade();
    }
}
