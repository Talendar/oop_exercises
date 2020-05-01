import java.util.ArrayList;
import produtos.*;

/**
 * Define a estrutura geral e as operações de uma loja.
 */
public class Loja
{
    private ArrayList<Produto> produtos = new ArrayList<>();

    /**
     * Adiciona um produto a loja.
     * @param p novo produto a ser adicionado (o produto já deve vir com o estoque especificado).
     */
    public void addProduto(Produto p) {
        this.produtos.add(p);
    }

    /**
     * Busca por um produto no inventário da loja a partir de seu código de barras.
     * @param codigoBarras código de barras do produto.
     * @return o produto.
     * @throws ProdutoNaoEncontradoException caso o produto não seja encontrado.
     */
    public Produto buscarProduto(long codigoBarras) throws ProdutoNaoEncontradoException{
        for(Produto p: this.produtos) {
            if(p.getCodigoBarras() == codigoBarras)
                return p;
        }
        throw new ProdutoNaoEncontradoException();
    }

    /**
     * Busca por um produto no inventário da loja a partir de seu nome.
     * @param nome nome do produto.
     * @return o produto.
     * @throws ProdutoNaoEncontradoException caso o produto não seja encontrado.
     */
    public Produto buscarProduto(String nome) throws ProdutoNaoEncontradoException{
        for(Produto p: this.produtos) {
            if(p.getNome().equals(nome))
                return p;
        }
        throw new ProdutoNaoEncontradoException();
    }

    /**
     * Realiza a operação de venda de um produto a partir de seu código de barras.
     * @param codigoBarras código de barras do produto.
     * @param quantidade quantidade de itens a serem vendidos.
     * @param valorPago valor pago pelo cliente.
     * @return troco do cliente.
     * @throws ProdutoForaDeEstoqueException caso não haja quantidade suficiente do produto em estoque.
     * @throws ProdutoNaoEncontradoException caso o produto não tenha sido encontrado.
     * @throws ValorInsuficienteException caso o valor pago pelo cliente seja insuficiente para completar a operação.
     */
    public double venderProduto(long codigoBarras, int quantidade, double valorPago)
            throws ProdutoForaDeEstoqueException, ProdutoNaoEncontradoException, ValorInsuficienteException {
        Produto p = this.buscarProduto(codigoBarras);
        if(p.getEstoque() < quantidade)
            throw new ProdutoForaDeEstoqueException();
        if(p.getPreco() * quantidade > valorPago)
            throw new ValorInsuficienteException();

        p.setEstoque(p.getEstoque() - quantidade);
        return valorPago - (p.getPreco() * quantidade);
    }

    /**
     * Função auxiliar para adicionar as strings dos produtos de uma dada categoria em um StringBuilder.
     * @param titulo
     * @param lista
     * @param str
     */
    private static void toStringCategoria(String titulo, ArrayList<? extends Produto> lista, StringBuilder str) {
        str.append(titulo);
        for(Produto p: lista)
            str.append(String.format("<>  %s  <>\n", p));
    }

    /**
     * Sobrecarga para facilitar a impressão do estoque da loja.
     * @return uma string contendo informações relativas ao estoque da loja.
     */
    @Override
    public String toString() {
        ArrayList<DispositivoDeArmazenamento> dars = new ArrayList<>();
        ArrayList<Livro> livros = new ArrayList<>();
        ArrayList<Produto> outros = new ArrayList<>();

        for(Produto p: this.produtos) {
            if(p instanceof DispositivoDeArmazenamento)
                dars.add((DispositivoDeArmazenamento) p);
            else if(p instanceof Livro)
                livros.add((Livro) p);
            else
                outros.add(p);
        }

        StringBuilder str = new StringBuilder();
        toStringCategoria("\n-> LIVROS:\n", livros, str);
        toStringCategoria("\n-> DISPOSITIVOS DE ARMAZENAMENTO:\n", dars, str);
        toStringCategoria("\n-> OUTROS\n", outros, str);

        return str.toString();
    }
}
