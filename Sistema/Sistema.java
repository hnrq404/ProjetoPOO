import clinica.*;
import eventos.Participante;

public class Sistema {
    public static void main(String[] args) {
        // Criação do objeto Medico
        Medico kristyson = new Pediatra("Kristyson", 21, "705.565.653-12", "Kris@gmai.com", "4002");

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
