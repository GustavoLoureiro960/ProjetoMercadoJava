package view;

public class Produto {
    private String nome;
    private String marca;
    private double preco;
    private int quantidade;

    Produto(String nome, String marca, double preco, int quantidade) {
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getMarca(){
        return  marca;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public double getPreco(){
        return preco;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public int getQuantidade(){
        return quantidade;
    }
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    @Override
    public String toString(){
        return "Nome: " + nome + "\n Marca: " + marca + "\n Preço: R$ " + preco + "\n Quantidade: " + quantidade;
    }
}

