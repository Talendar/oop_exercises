package produtos;

/**
 * Define a estrutura geral de um DVD.
 */
public class DVD extends DispositivoDeArmazenamento
{
    /**
     * Construtor padrão para um CD.
     * @param nome
     * @param codigoBarras
     * @param preco
     * @param estoque
     * @param capacidade em MBs.
     */
    public DVD(String nome, long codigoBarras, double preco, int estoque, long capacidade) {
        super(nome, codigoBarras, preco, estoque, capacidade);
    }
}
