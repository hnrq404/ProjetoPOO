public class Sistema3 {
    public static void main(String[] args) {
        Mesa mesa1 = new Mesa(1);
        mesa1.ocuparMesa();
 
        ItemDoPedido item1 = new ItemDoPedido("Pizza", 25.00, 1);
        ItemDoPedido item2 = new ItemDoPedido("Refrigerante", 5.00, 1);
 
        mesa1.adicionarItemPedido(item1);
        mesa1.adicionarItemPedido(item2);
 
        double total = mesa1.fecharConta();
        int numero = mesa1.getNumero();
        
        System.out.println("Total a pagar da mesa "+ numero +" : R$ " + total);
    }
}
