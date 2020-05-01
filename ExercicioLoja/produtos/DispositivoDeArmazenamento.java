package produtos;

/**
 * Define a estrutura geral de um dispositivo de armazenamento genérico.
 */
public abstract class DispositivoDeArmazenamento extends Produto
{
    private long capacidade; //unidade: MBs

    /**
     * Construtor padrão para um dispositivo de armazenamento.
     * @param nome
     * @param codigoBarras
     * @param preco
     * @param estoque
     * @param capacidade em MBs
     */
    public DispositivoDeArmazenamento(String nome, long codigoBarras, double preco, int estoque, long capacidade) {
        super(nome, codigoBarras, preco, estoque);
        this.capacidade = capacidade;
    }

    /**
     * Getter para o campo capacidade.
     * @return a capacidade do dispositivo em MBs.
     */
    public long getCapacidade() {
        return capacidade;
    }

    /**
     * Setter para o campo capacidade.
     * @param capacidade a nova capacidade do dispositivo, em MBs.
     */
    public void setCapacidade(long capacidade) {
        this.capacidade = capacidade;
    }

    /**
     * Sobrecarga para facilitar impressões.
     * @return uma string com informações relativas ao produto.
     */
    @Override
    public String toString() {
        return super.toString() + String.format("  |  Capacidade: %d MBs", this.capacidade);
    }
}
