package clinica;

public class Cardiologista extends Medico {

    public Cardiologista(String nome, int idade, String cpf, String email, String crm) {
        super(nome, idade, cpf, email, crm, "Cardiologista");
    }

    // Sobrecarga adicional específica
    public void realizarExame(String tipoExame) {
        System.out.println("Exame cardiológico realizado: " + tipoExame);
    }

    public void realizarExame(String tipoExame, String paciente) {
        System.out.println("Exame cardiológico '" + tipoExame + "' realizado para o paciente: " + paciente);
    }

    @Override
    public void realizarConsulta() {
        System.out.println("Realizando consulta cardiológica. Verificando pressão arterial e eletrocardiograma.");
    }

    //utilizando interface

    @Override
    public void agendarConsulta(String paciente, String data, String hora) {
        System.out.println("Consulta cardiológica agendada para " + paciente + " no dia " + data + " às " + hora + ".");
    }

    @Override
    public boolean cancelarConsulta(String paciente, String data) {
        System.out.println("Consulta cardiológica de " + paciente + " no dia " + data + " foi cancelada.");
        return true; // Simulação de sucesso no cancelamento
    }
}
