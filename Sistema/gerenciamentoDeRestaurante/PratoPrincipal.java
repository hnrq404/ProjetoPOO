public class PratoPrincipal extends Menu {
    private String acompanhamentos;

    public PratoPrincipal(String nome, double preco, String acompanhamentos) {
        super(nome, preco);
        this.acompanhamentos = acompanhamentos;
    }

    public String getAcompanhamentos() {
        return acompanhamentos;
    }

    // Sobrecarga adicional: Personalização de acompanhamentos
    public void adicionarAcompanhamento(String acompanhamento) {
        System.out.println("Acompanhamento '" + acompanhamento + "' adicionado ao prato '" + getNome() + "'.");
    }

    public void adicionarAcompanhamento(String acompanhamento, boolean semCusto) {
        System.out.println("Acompanhamento '" + acompanhamento + "' adicionado ao prato '" + getNome() + "' | Sem custo: " + (semCusto ? "Sim" : "Não"));
    }

    @Override
    public void exibirDetalhes() {
        System.out.println(toString() + " | Acompanhamentos: " + acompanhamentos);
    }
}
