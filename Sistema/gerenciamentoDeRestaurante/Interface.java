import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class Interface {
    private JFrame frame;
    private JTextArea outputArea;
    private List<Mesa> mesas;
    private int numMesas;
    private int numClientes;
    private Map<Integer, ItemDoPedido> cardapio;
    private Map<String, Integer> contadorPedidos;

    public Interface(int numMesas) {
        this.numMesas = numMesas;
        mesas = new ArrayList<>();
        for (int i = 1; i <= numMesas; i++) {
            mesas.add(new Mesa(i));
        }
        initializeCardapio();
        contadorPedidos = new HashMap<>(); // Contador de pedidos por nome de item
        initialize();
    }

    private void initializeCardapio() {
        cardapio = new HashMap<>();
        cardapio.put(1, new ItemDoPedido("Pizza", 25.00, 1));
        cardapio.put(2, new ItemDoPedido("Hamburguer", 20.00, 1));
        cardapio.put(3, new ItemDoPedido("Refrigerante", 5.00, 1));
        cardapio.put(4, new ItemDoPedido("Suco", 7.00, 1));
        cardapio.put(5, new ItemDoPedido("Batata Frita", 10.00, 1));
    }

    private void initialize() {
        frame = new JFrame("Sistema de Restaurante");
        frame.setBounds(500, 100, 600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.NORTH);

        JButton ocuparMesaBtn = new JButton("Ocupar Mesa");
        ocuparMesaBtn.addActionListener(e -> ocuparMesa());
        panel.add(ocuparMesaBtn);

        JButton fazerPedidoBtn = new JButton("Fazer Pedido");
        fazerPedidoBtn.addActionListener(e -> fazerPedido());
        panel.add(fazerPedidoBtn);

        JButton fecharContaBtn = new JButton("Fechar Conta");
        fecharContaBtn.addActionListener(e -> fecharConta());
        panel.add(fecharContaBtn);

        JButton finalizarDiaBtn = new JButton("Finalizar Dia");
        finalizarDiaBtn.addActionListener(e -> finalizarDia());
        panel.add(finalizarDiaBtn);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void ocuparMesa() {
        numClientes++;
        boolean mesaOcupada = false;
        for (Mesa mesa : mesas) {
            if (!mesa.isOcupada()) {
                mesa.ocuparMesa();
                outputArea.append("Mesa " + mesa.getNumero() + " agora está ocupada.\n");
                mesaOcupada = true;
                break;
            }
        }
        if (!mesaOcupada) {
            outputArea.append("Todas as mesas estão ocupadas.\n");
        }
    }

    private void fazerPedido() {
        String mesaStr = JOptionPane.showInputDialog("Para qual mesa deseja fazer o pedido?");
        int mesaNumero = Integer.parseInt(mesaStr);

        if (mesaNumero <= numMesas && mesas.get(mesaNumero - 1).isOcupada()) {
            StringBuilder menu = new StringBuilder("Cardápio:\n");
            for (Map.Entry<Integer, ItemDoPedido> entry : cardapio.entrySet()) {
                menu.append(entry.getKey()).append(" - ").append(entry.getValue().getItem())
                    .append(" (R$ ").append(entry.getValue().getPreco()).append(")\n");
            }
            menu.append("Escolha o número do item:");
            String itemStr = JOptionPane.showInputDialog(menu.toString());
            int itemNumero = Integer.parseInt(itemStr);

            if (cardapio.containsKey(itemNumero)) {
                ItemDoPedido itemSelecionado = cardapio.get(itemNumero);
                String quantidadeStr = JOptionPane.showInputDialog("Informe a quantidade:");
                int quantidade = Integer.parseInt(quantidadeStr);

                ItemDoPedido item = new ItemDoPedido(itemSelecionado.getItem(), itemSelecionado.getPreco(), quantidade);
                mesas.get(mesaNumero - 1).adicionarItemPedido(item);

                contadorPedidos.put(item.getItem(), contadorPedidos.getOrDefault(item.getItem(), 0) + quantidade);

                outputArea.append("Item " + itemSelecionado.getItem() + " adicionado ao pedido da mesa " + mesaNumero + ".\n");
            } else {
                outputArea.append("Item inválido.\n");
            }
        } else {
            outputArea.append("Mesa inválida ou não ocupada.\n");
        }
    }

    private void fecharConta() {
        String mesaStr = JOptionPane.showInputDialog("Qual mesa deseja fechar a conta?");
        int mesaNumero = Integer.parseInt(mesaStr);

        if (mesaNumero <= numMesas && mesas.get(mesaNumero - 1).isOcupada()) {
            Mesa mesa = mesas.get(mesaNumero - 1);
            outputArea.append("Itens pedidos pela mesa " + mesa.getNumero() + ":\n");
            Pedido pedido = mesa.getPedido();
            List<ItemDoPedido> itens = pedido.getItens();
            for (ItemDoPedido itemPedido : itens) {
                outputArea.append(itemPedido.getQuantidade() + "x " + itemPedido.getItem() + " - R$ " + itemPedido.getPreco() + " cada\n");
            }

            double total = mesa.fecharConta();
            outputArea.append("Total a pagar da mesa " + mesa.getNumero() + " : R$ " + total + "\n");
            outputArea.append("Mesa " + mesa.getNumero() + " desocupada.\n");
        } else {
            outputArea.append("Mesa inválida ou não ocupada.\n");
        }
    }

    private void finalizarDia() {
        outputArea.append("\nFinalização do dia:\n");
        outputArea.append(numClientes + " Mesas foram ocupadas hoje, ");
        if (numClientes < numMesas){
            outputArea.append("foi um dia pouco movimentado, talvez deveríamos diminuir os preços.\n");
        }else if(numClientes >= numMesas){
            if (numClientes >= (numMesas*2)) {
                outputArea.append("ótimo para o restaurante! Podemos aumentar os preços e lucrar mais.\n");
            }else{
                outputArea.append("foi razoável... Poderíamos pensar em fazer uma promoção.\n");
            }
        }
        numClientes = 0;

        if (contadorPedidos.isEmpty()) {
            outputArea.append("Nenhum pedido foi registrado hoje.\n");
            return;
        }

        List<Map.Entry<String, Integer>> listaPedidos = new ArrayList<>(contadorPedidos.entrySet());
        listaPedidos.sort((a, b) -> b.getValue().compareTo(a.getValue()));


        outputArea.append("Itens mais pedidos:\n");
        for (int i = 0; i < Math.min(3, listaPedidos.size()); i++) {
            Map.Entry<String, Integer> entry = listaPedidos.get(i);
            outputArea.append((i + 1) + ". " + entry.getKey() + " - " + entry.getValue() + "x\n");
        }
        contadorPedidos.clear();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Interface(5));
    }
}
