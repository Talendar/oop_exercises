package produtos;

/**
 * Define a estrutura para livros produtos da loja.
 */
public class Livro extends Produto
{
    private int numPaginas;
    private int edicao;
    final private String AUTOR;

    /**
     * Construtor padrão para um produto do tipo livro.
     * @param titulo
     * @param codigoBarras
     * @param preco
     * @param estoque
     * @param numPaginas
     * @param edicao
     * @param autor
     */
    public Livro(String titulo, long codigoBarras, double preco, int estoque, int numPaginas, int edicao, String autor) {
        super(titulo, codigoBarras, preco, estoque);
        this.numPaginas = numPaginas;
        this.edicao = edicao;
        this.AUTOR = autor;
    }

    /**
     * Getter para o campo número de páginas.
     * @return o número de páginas do livro.
     */
    public int getNumPaginas() {
        return this.numPaginas;
    }

    /**
     * Getter para o campo edição.
     * @return a edição do livro.
     */
    public int getEdicao() {
        return this.edicao;
    }

    /**
     * Getter para o campo autor;.
     * @return o autor do livro.
     */
    public String getAutor() {
        return this.AUTOR;
    }

    /**
     * Setter para o campo número de páginas.
     * @param numPaginas o novo número de páginas do livro.
     */
    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    /**
     * Setter para o campo edição.
     * @param edicao a nova edicao do livro.
     */
    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    /**
     * Sobrecarga para facilitar impressões.
     * @return uma string com informações relativas ao produto.
     */
    @Override
    public String toString() {
        return super.toString() + String.format("  |  Autor: %s  |  Ed.: %d  |  Pags.: %d", this.AUTOR, this.edicao, this.numPaginas);
    }
}
