package eventos;

public class Workshop extends Evento {

    private String instrutor;

    public Workshop(String nome,String descricao,Local local, String instrutor) {
        super(nome, descricao, local);
        this.instrutor = instrutor;
    }

    public String getInstrutor() {
        return instrutor;
    }

    // Sobrecarga adicional: Materiais
    public void adicionarMaterial(String material) {
        System.out.println("Material '" + material + "' adicionado ao Workshop '" + getNome() + "'.");
    }

    public void adicionarMaterial(String material, String descricao) {
        System.out.println("Material '" + material + "' adicionado ao Workshop '" + getNome() + "' com descrição: " + descricao + ".");
    }

    @Override
    public void organizarEvento() {
        System.out.println("Organizando o Workshop '" + getNome() + "' com o instrutor " + instrutor + ".");
    }
}
