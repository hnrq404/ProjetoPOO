public class Bebida extends Menu {
    private boolean alcoolica;

    public Bebida(String nome, double preco, boolean alcoolica) {
        super(nome, preco);
        this.alcoolica = alcoolica;
    }

    public boolean isAlcoolica() {
        return alcoolica;
    }

    // Sobrecarga adicional: Personalização de bebidas
    public void adicionarGelo() {
        System.out.println("Gelo adicionado à bebida '" + getNome() + "'.");
    }

    public void adicionarGelo(int quantidade) {
        System.out.println(quantidade + " cubos de gelo adicionados à bebida '" + getNome() + "'.");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println(toString() + " | Alcoólica: " + (alcoolica ? "Sim" : "Não"));
    }
}