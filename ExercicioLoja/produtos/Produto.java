package produtos;

/**
 * Define a estrutura geral de um produto da loja. A classe não é declarada abstrata para que produtos sem categoria possam ser criados a partir dela.
 */
public class Produto
{
    protected String nome;
    protected final long CODIGO;
    protected double preco;
    protected int estoque;

    /**
     * Construtor padrão para um produto da loja.
     * @param nome
     * @param codigoBarras
     * @param preco
     * @param estoque
     */
    public Produto(String nome, long codigoBarras, double preco, int estoque) {
        this.nome = nome;
        this.CODIGO = codigoBarras;
        this.preco = preco;
        this.estoque = estoque;
    }

    /**
     * Getter para o campo nome.
     * @return o nome do produto.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Setter para o campo nome.
     * @param nome o novo nome do produto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Getter para o campo código de barras.
     * @return o código de barras do produto.
     */
    public long getCodigoBarras() {
        return this.CODIGO;
    }

    /**
     * Getter para o campo preço.
     * @return o preço do produto.
     */
    public double getPreco() {
        return this.preco;
    }

    /**
     * Setter para o campo preço.
     * @param preco o novo preço do produto.
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Getter para o campo estoque.
     * @return a quantidade do produto em estoque.
     */
    public int getEstoque() {
        return this.estoque;
    }

    /**
     * Setter para o campo estoque.
     * @param estoque novo estoque do produto.
     */
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    /**
     * Sobrecarga para facilitar impressões.
     * @return uma string com informações relativas ao produto.
     */
    @Override
    public String toString() {
        return String.format("Nome: %s  |  Valor: %.2f  |  Estoque: %d  |  Codigo: %d", this.nome, this.preco, this.estoque, this.CODIGO);
    }
}
