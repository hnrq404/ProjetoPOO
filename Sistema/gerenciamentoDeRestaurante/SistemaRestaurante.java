import java.util.*;

public class Sistema {
    private static List<Mesa> mesas;
    private static Map<Integer, ItemDoPedido> cardapio;
    private static Map<String, Integer> contadorPedidos;
    private static int numClientes;
    private static int numMesas;

    public static void main(String[] args) {
        mesas = new ArrayList<>();
        contadorPedidos = new HashMap<>();
        initializeCardapio();
        numClientes = 0;

        numMesas = 5;
        for (int i = 1; i <= numMesas; i++) {
            mesas.add(new Mesa(i));
        }

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Ocupar uma mesa");
            System.out.println("2. Fazer um pedido");
            System.out.println("3. Fechar a conta");
            System.out.println("4. Finalizar o dia");
            System.out.println("5. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    ocuparMesa();
                    break;
                case 2:
                    fazerPedido(scanner);
                    break;
                case 3:
                    fecharConta(scanner);
                    break;
                case 4:
                    finalizarDia();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }

    private static void initializeCardapio() {
        cardapio = new HashMap<>();
        cardapio.put(1, new ItemDoPedido("Pizza", 25.00, 1));
        cardapio.put(2, new ItemDoPedido("Hamburguer", 20.00, 1));
        cardapio.put(3, new ItemDoPedido("Refrigerante", 5.00, 1));
        cardapio.put(4, new ItemDoPedido("Suco", 7.00, 1));
        cardapio.put(5, new ItemDoPedido("Batata Frita", 10.00, 1));
    }

    private static void ocuparMesa() {
        numClientes++;
        for (Mesa mesa : mesas) {
            if (!mesa.isOcupada()) {
                mesa.ocuparMesa();
                System.out.println("Mesa " + mesa.getNumero() + " agora está ocupada.");
                return;
            }
        }
        System.out.println("Todas as mesas estão ocupadas.");
    }

    private static void fazerPedido(Scanner scanner) {
        System.out.print("Para qual mesa deseja fazer o pedido? ");
        int mesaNumero = scanner.nextInt();
        scanner.nextLine();

        if (mesaNumero > 0 && mesaNumero <= mesas.size() && mesas.get(mesaNumero - 1).isOcupada()) {
            System.out.println("\nCardápio:");
            for (Map.Entry<Integer, ItemDoPedido> entry : cardapio.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue().getItem() + " (R$ " + entry.getValue().getPreco() + ")");
            }
            System.out.print("Escolha o número do item: ");
            int itemNumero = scanner.nextInt();
            scanner.nextLine();

            if (cardapio.containsKey(itemNumero)) {
                ItemDoPedido itemSelecionado = cardapio.get(itemNumero);
                System.out.print("Informe a quantidade: ");
                int quantidade = scanner.nextInt();
                scanner.nextLine();

                ItemDoPedido item = new ItemDoPedido(itemSelecionado.getItem(), itemSelecionado.getPreco(), quantidade);
                mesas.get(mesaNumero - 1).adicionarItemPedido(item);
                contadorPedidos.put(item.getItem(), contadorPedidos.getOrDefault(item.getItem(), 0) + quantidade);
                System.out.println("Item " + item.getItem() + " adicionado ao pedido da mesa " + mesaNumero + ".");
            } else {
                System.out.println("Item inválido.");
            }
        } else {
            System.out.println("Mesa inválida ou não ocupada.");
        }
    }

    private static void fecharConta(Scanner scanner) {
        System.out.print("Qual mesa deseja fechar a conta? ");
        int mesaNumero = scanner.nextInt();
        scanner.nextLine();

        if (mesaNumero > 0 && mesaNumero <= mesas.size() && mesas.get(mesaNumero - 1).isOcupada()) {
            Mesa mesa = mesas.get(mesaNumero - 1);
            System.out.println("Itens pedidos pela mesa " + mesa.getNumero() + ":");

            Pedido pedido = mesa.getPedido();
            List<ItemDoPedido> itens = pedido.getItens();
            for (ItemDoPedido itemPedido : itens) {
                System.out.println(itemPedido.getQuantidade() + "x " + itemPedido.getItem() + " - R$ " + itemPedido.getPreco() + " cada");
            }

            double total = mesa.fecharConta();
            System.out.println("Total a pagar da mesa " + mesa.getNumero() + " : R$ " + total);
        } else {
            System.out.println("Mesa inválida ou não ocupada.");
        }
    }

    private static void finalizarDia() {
        System.out.println("\nFinalização do dia:");
        System.out.println(numClientes + " Mesas foram ocupadas hoje.");
        if (numClientes < numMesas) {
            System.out.println("Foi um dia pouco movimentado, talvez deveríamos diminuir os preços.");
        }
        else if (numClientes >= numMesas){
            if (numClientes >= (numMesas*2)) {
                System.out.println("Dia ótimo para o restaurante! Podemos pensar em aumentar os preços e lucrar mais.");
            }else{
                System.out.println("Foi razoável... Poderíamos pensar em fazer uma promoção.");
            }
        }
        numClientes = 0;
        if (contadorPedidos.isEmpty()) {
            System.out.println("Nenhum pedido foi registrado hoje.");
            return;
        }

        List<Map.Entry<String, Integer>> listaPedidos = new ArrayList<>(contadorPedidos.entrySet());
        listaPedidos.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("Itens mais pedidos:");
        for (int i = 0; i < Math.min(3, listaPedidos.size()); i++) {
            Map.Entry<String, Integer> entry = listaPedidos.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + " - " + entry.getValue() + "x");
        }


        contadorPedidos.clear();
    }
}
