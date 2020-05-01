package produtos;

/**
 * Define a estrutura geral de um pen drive.
 */
public class PenDrive extends DispositivoDeArmazenamento
{
    /**
     * Construtor padrão para um CD.
     * @param nome
     * @param codigoBarras
     * @param preco
     * @param estoque
     * @param capacidade em MBs.
     */
    public PenDrive(String nome, long codigoBarras, double preco, int estoque, long capacidade) {
        super(nome, codigoBarras, preco, estoque, capacidade);
    }
}
