package view;

import java.util.ArrayList;
import java.util.Scanner;

public class Comprar {

    public static ArrayList<Produto> carrinho = new ArrayList<>();
    public static ArrayList<Produto> estoque = Estoque.produtos();

    public static void AdicionarAoCarrinho(String nome){
        Produto produto = null;
        for (Produto p: estoque){
            if (p.getNome().equals(nome)){
                produto = p;
                break;
            }
        }

        //Verifica se o produto foi encontrado no estoque
        if (produto != null) {
            // Verifica se a quantidade solicitada está disponível no estoque
            if (produto.getQuantidade() >= 1) {

                // Adiciona o produto ao carrinho
                //Verefica se o produto já está no carrinho
                boolean produtoEncontrado = false;
                for (Produto p: carrinho) {
                    if (p.getNome().equals(nome)) {
                        p.setQuantidade(p.getQuantidade());
                        produtoEncontrado = true;
                        break;
                    }
                }
                //Se o produto não estiver no carrinho, adiciona um novo produto
                if (!produtoEncontrado){
                    Produto produtoCarrinho = new Produto(produto.getNome(), produto.getMarca(),
                            produto.getPreco(), 1);
                    carrinho.add(produtoCarrinho);
                    System.out.println("Produto adicionado ao carrinho com sucesso!");
                    System.out.println();
                }else{
                    System.out.println("Produto já se encontra no carrinho");
                    System.out.println();
                }
                // Diminui a quantidade do produto no estoque
                produto.setQuantidade(produto.getQuantidade() - 1);

                // Verifica se a quantidade do produto no estoque se tornou 0 e remove-o se necessário
                if (produto.getQuantidade() == 0) {
                    estoque.remove(produto);
                }
            } else {
                System.out.println("Quantidade solicitada não disponível no estoque.");
                System.out.println();
            }
        } else if (produto == null){
            System.out.println("Produto não encontrado no estoque." +
                    "\nPor favor verifique a lista de produtos para mais informações");
            System.out.println();

        }
    }

    public static void ListarCarrinho(ArrayList<Produto> carrinho) {
        double total = 0;
        for (int i = 0; i < carrinho.size(); i++) {
            total += carrinho.get(i).getPreco();
            System.out.println(carrinho.get(i).toString());
            System.out.println();
        }
        System.out.println("O total da compra é de  R$: " + total);
        System.out.println();
    }

}

