package eventos;

public class Conferencia extends Evento {

    private String palestrantePrincipal;

    public Conferencia(String nome,String descricao,Local local, String palestrantePrincipal) {
        super(nome, descricao, local);
        this.palestrantePrincipal = palestrantePrincipal;
    }

    public String getPalestrantePrincipal() {
        return palestrantePrincipal;
    }

    // Sobrecarga adicional: Patrocínios
    public void adicionarPatrocinio(String empresa) {
        System.out.println("Patrocínio da empresa '" + empresa + "' adicionado à Conferência '" + getNome() + "'.");
    }

    public void adicionarPatrocinio(String empresa, double valor) {
        System.out.println("Patrocínio da empresa '" + empresa + "' no valor de R$ " + String.format("%.2f", valor) + " adicionado à Conferência '" + getNome() + "'.");
    }

    @Override
    public void organizarEvento() {
        System.out.println("Organizando a Conferência '" + getNome() + "' com o palestrante principal " + palestrantePrincipal + ".");
    }
}