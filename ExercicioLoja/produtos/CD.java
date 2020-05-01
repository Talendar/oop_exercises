package produtos;

/**
 * Define a estrutura geral de um CD.
 */
public class CD extends DispositivoDeArmazenamento
{
    /**
     * Construtor padrão para um CD.
     * @param nome
     * @param codigoBarras
     * @param preco
     * @param estoque
     * @param capacidade em MBs.
     */
    public CD(String nome, long codigoBarras, double preco, int estoque, long capacidade) {
        super(nome, codigoBarras, preco, estoque, capacidade);
    }
}
