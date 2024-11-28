package clinica;

public class Pediatra extends Medico {

    public Pediatra(String nome, int idade, String cpf, String email, String crm) {
        super(nome, idade, cpf, email, crm, "Pediatra");
    }

    // Sobrecarga adicional específica
    public void realizarVacina(String vacina) {
        System.out.println("Vacina aplicada: " + vacina);
    }

    public void realizarVacina(String vacina, String paciente) {
        System.out.println("Vacina '" + vacina + "' aplicada para o paciente: " + paciente);
    }

    @Override
    public void realizarConsulta() {
        System.out.println("Realizando consulta pediátrica. Avaliando crescimento e imunizações da criança.");
    }

    //utilizando interface
    @Override
    public void agendarConsulta(String paciente, String data, String hora) {
        System.out.println("Consulta pediátrica agendada para " + paciente + " no dia " + data + " às " + hora + ".");
    }

    @Override
    public boolean cancelarConsulta(String paciente, String data) {
        System.out.println("Consulta pediátrica de " + paciente + " no dia " + data + " foi cancelada.");
        return true; // Simulação de sucesso no cancelamento
    }
}
