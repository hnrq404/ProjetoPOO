import clinica.*;

public class Sistema{
    public static void main(String[] args){
        Medico Kristyson = new Medico("Kristyson", 21, "705.565.653-12",  "Kris@gmai.com", "4002", "Otorrino");
        Participante Leandro = new Participante(Kristyson);
        System.out.println(Leandro.getCPF());
        Participante participante = new Participante("Henrique", 15, "1234123", "daniel@hotmai.com", "espectador");
        System.out.println(participante.getTipo());
    }
}