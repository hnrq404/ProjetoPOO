import clinica.*;
import eventos.Participante;

<<<<<<< HEAD
public class Sistema {
    public static void main(String[] args) {
        // Criação do objeto Medico
        Medico kristyson = new Medico("Kristyson", 21, "705.565.653-12", "Kris@gmai.com", "4002", "Otorrino");

        // Criação do Participante Leandro com base no objeto Medico
        Participante leandro = new Participante(kristyson);

        // Exibição das informações do participante Leandro
        System.out.println("Informações do Participante :");
        System.out.println("Nome: " + leandro.getNome());
        System.out.println("CPF: " + leandro.getCPF());
        System.out.println("Email: " + leandro.getEmail());
        System.out.println("Especialidade: " + leandro.getEspecialidade());
        System.out.println();  // Linha em branco para separar os participantes

        // Criação de outro Participante, sem especialidade
=======
public class Sistema{
    public static void main(String[] args){
        Medico Kristyson = new Medico("Kristyson", 21, "705.565.653-12",  "Kris@gmai.com", "4002", "Otorrino");
        Participante Leandro = new Participante(Kristyson);
        System.out.println(Leandro.getCPF());

        System.out.println(Leandro.getMedico().getEspecialidade());
>>>>>>> accb009b02be76dc26f88d817b7abc692b0b3882
        Participante participante = new Participante("Henrique", 15, "1234123", "daniel@hotmai.com", "espectador");

        // Exibição das informações do participante Henrique
        System.out.println("Informações do Participante :");
        System.out.println("Nome: " + participante.getNome());
        System.out.println("Idade: " + participante.getIdade());
        System.out.println("CPF: " + participante.getCPF());
        System.out.println("Email: " + participante.getEmail());
        System.out.println("Tipo: " + participante.getTipo());
    }
}
