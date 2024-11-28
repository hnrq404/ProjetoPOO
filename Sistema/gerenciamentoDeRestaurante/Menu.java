

public abstract class Menu implements Personalizavel {
    private String nome;
    private double preco;

    public Menu(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    // Implementação dos métodos da interface Personalizável
    @Override
    public void adicionarIngrediente(String ingrediente) {
        System.out.println("Ingrediente '" + ingrediente + "' adicionado ao item: " + nome);
    }

    @Override
    public void removerIngrediente(String ingrediente) {
        System.out.println("Ingrediente '" + ingrediente + "' removido do item: " + nome);
    }

    @Override
    public void alterarQuantidade(String ingrediente, int quantidade) {
        System.out.println("Quantidade de '" + ingrediente + "' ajustada para " + quantidade + " no item: " + nome);
    }

     // Sobrecarga de métodos: Detalhes personalizados
     public void exibirDetalhes(String comentario) {
        System.out.println(toString() + " | Comentário: " + comentario);
    }

    public void exibirDetalhes(String comentario, boolean destaque) {
        System.out.println(toString() + " | Comentário: " + comentario + " | Destaque: " + (destaque ? "Sim" : "Não"));
    }

    public abstract void exibirDetalhes(); // Método abstrato para polimorfismo

    @Override
    public String toString() {
        return "Item: " + nome + " | Preço: R$ " + String.format("%.2f", preco);
    }
}
