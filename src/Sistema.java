public class Sistema{
    public static void main(String[] args){
        Medico Kristyson = new Medico("Kristyson", 21, "70556565312",  "Kris@gmai.com", "4002", "Otorrino");
        Participante Leandro = new Participante(Kristyson);
        System.out.println(Leandro.getIdade());
        Participante participante = new Participante("Henrique", 15, "1234123", "daniel@hotmai.com", "espectador");
        System.out.println(participante.getTipo());
    }
}