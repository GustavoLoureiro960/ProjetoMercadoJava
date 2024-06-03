package view;

import java.util.ArrayList;
import java.util.Scanner;

import view.Produto;
import view.Estoque;
import view.Comprar;

public class Mercado {

    public static void Menu() {
        Scanner input = new Scanner(System.in);
        int opcoes = 0;

        ArrayList<Produto> estoque = Comprar.estoque;
        ArrayList<Produto> carrinho = Comprar.carrinho;


        do {
            System.out.println("Sejam bem-vindos ao mercado digital.");
            System.out.println("Por favor selecione qual opção você deseja?");
            System.out.println("1 - Cadastrar produtos");
            System.out.println("2 - Lista de produtos");
            System.out.println("3 - Comprar produto");
            System.out.println("4 - Visualizar carrinho");
            System.out.println("5 - Finalizar a compra");
            System.out.println("6 - Sair do Sistema");

            opcoes = input.nextInt();
            input.nextLine();

            switch (opcoes) {
                case 1:
                    System.out.println("Você Escolheu o cadastro de produtos");
                    Estoque.novoProduto(estoque);
                    break;
                case 2:
                    System.out.println("Você escolheu ver todos os produtos em Estoque");
                    Estoque.ListeEstoque(estoque);
                    break;
                case 3:
                    boolean continuarComprando = true;

                    do{
                        System.out.println("Você escolheu comprar produtos. " +
                                "\nPor favor diga o nome do produto que você deseja comprar");

                        Comprar.AdicionarAoCarrinho(String.valueOf(input.nextLine()));
                        System.out.println("O que você deseja fazer em seguida?");
                        System.out.println("1 - Continuar comprando");
                        System.out.println("2 - Finalizar compra e sair do sistema");
                        System.out.println("3 - Trocar de Serviço");

                        Scanner scanner = new Scanner(System.in);
                        int opcao = scanner.nextInt();
                        switch (opcao){
                            case(1):
                                continuarComprando = true;
                                break;
                            case (2):
                                Comprar.ListarCarrinho(carrinho);
                                continuarComprando = false;
                                opcoes = 6;
                                break;
                            case(3):
                                continuarComprando = false;
                                break;
                            default:
                                continuarComprando = true;
                                System.out.println("Opção invalida, por favor selecione uma opção valida");
                                System.out.println("1 - Continuar comprando");
                                System.out.println("2 - Finalizar compra e sair do sistema");
                                System.out.println();
                                break;
                        }
                    }while (continuarComprando);
                    break;
                case 4:
                    System.out.println("Você escolheu ver o seu carrinho");
                    Comprar.ListarCarrinho(carrinho);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Você escolheu finalizar sua(s) compra(s)");
                    System.out.println();

                    if(carrinho.isEmpty()){
                        System.out.println("O carrinho está vazio");
                        System.out.println("Deseja ver meus produtos? (s/n)");
                        System.out.println();
                        String continuar = input.next();
                        if (continuar.equalsIgnoreCase("s")) {
                            opcoes = 2;
                        }else {
                            System.out.println("Obrigado por visitar minha loja volte sempre");
                            System.out.println();
                            opcoes = 6;
                        }

                    }else{
                        Comprar.ListarCarrinho(carrinho);
                        opcoes = 6;
                    }
                    break;
                case 6:
                    System.out.println("Obrigado por escolher minha loja fazer suas compras, até a próxima");
                    System.out.println();
                default:
                    System.out.println("Opção inválida");
                    System.out.println();
                    break;
            }
        } while (opcoes != 6);
        System.exit(0);
    }
}

