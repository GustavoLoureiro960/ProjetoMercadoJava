package view;

import java.util.ArrayList;
import java.util.Scanner;


public class Estoque {
    public static ArrayList<Produto> produtos() {
        ArrayList<Produto> estoque = new ArrayList<>();

        Produto XboxOneX = new Produto("Xbox One X", "Microsoft", 2231.00, 10);
        Produto XboxSeriesS = new Produto("Xbox Series S", "Microsoft", 2398.79, 25);
        Produto XboxSeriesX = new Produto("Xbox Series X", "Microsoft", 3699.00, 15);

        Produto Playsattion4Pro = new Produto("Playstation 4 Pro", "Sonny", 2699.00, 10);
        Produto Playsation5 = new Produto("Playstation 5", "Sonny", 3599.99, 25);
        Produto Playstation5Slim = new Produto("Playstation 5 Slim", "Sonny", 3533.07, 25);

        estoque.add(XboxOneX);
        estoque.add(XboxSeriesS);
        estoque.add(XboxSeriesX);
        estoque.add(Playsattion4Pro);
        estoque.add(Playsation5);
        estoque.add(Playstation5Slim);

        return estoque;
    }

    public static void ListeEstoque(ArrayList<Produto> estoque){
        for (int i = 0; i < estoque.size(); i++) {
            System.out.println(estoque.get(i).toString());
            System.out.println();
        }
    }

    public static void novoProduto(ArrayList<Produto> stoque) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Por favor insira o nome do produto que você deseja adicionar.");
        String name = scan.nextLine();
        if (name.equalsIgnoreCase("quit")) {
        }

        System.out.println("Por favor insira a marca do produto que você deseja adicionar.");
        String marca = scan.next();
        if (marca.equalsIgnoreCase("quit")) {
        }

        System.out.println("Por favor insira o preço do produto que você deseja adicionar.");
        double preco;

        while (true){
            try{
                preco = Double.parseDouble(scan.nextLine());
                if (preco <= 0) {
                    System.out.println("O Preço precisa ser maior do que 0. Por favor insira outro valor superiror.");
                }else {
                    break;
                }
            }catch (NumberFormatException e){
                System.out.println("Por favor insira um valor númerico válido para o preço");
            }
        }


        System.out.println("Por favor insira a quantidade do produto que você deseja adicionar ao estoque.");
        int quantidade;
        while (true){
            try{
                quantidade = Integer.parseInt(scan.nextLine());
                if (quantidade <= 0) {
                    System.out.println("A quantidade de unidades do produto precisa ser maior do que 0.\n" +
                            " Por favor insira outro valor superiror");
                }else {
                    break;
                }
            }catch (NumberFormatException e) {
                System.out.println("por favor insira um valor valido.");
            }
        }



        Produto a = new Produto(name, marca, preco, quantidade);
        stoque.add(a);
    }
}

