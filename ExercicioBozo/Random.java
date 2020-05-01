/**
 * Gerador simples de números aleatórios.
 * @author Gabriel de Oliveira Guedes Nogueira (10295496)
 */
public class Random
{
    private long seed;
    final static private long
            A = 453816693L,
            M =  843314861L,
            P = 2147483648L;

    /**
     * Construtor que permite criar o gerador, especificando o valor inicial da semente.
     * @param seed o valor inicial da semente.
     */
    public Random(long seed) {
        this.seed = seed;
    }

    /**
     * Construtor que usa uma semente aleatória, obtida usando-se o método System.currentTimeMillis().
     */
    public Random() {
        this(System.nanoTime());
    }

    /**
     * Retorna um número aleatório no intervalo (0,1[.
     * @return o número gerado.
     */
    public double getRand() {
        this.seed = (A + M * this.seed) % P;
        return Math.abs(((double) this.seed) / P);
    }

    /**
     * Retorna um valor inteiro no intervalo (0,max[.
     * @param max o valor limite para a geração do número inteiro.
     * @return o número gerado.
     */
    public int getIntRand(int max) {
        return (int) (this.getRand() * max);
    }

    /**
     * Permite alterar a semente de geração de números aleatórios. Supostamente deve ser chamada antes de iniciar a geração, mas se for chamado a qualquer instante, reseta o valor da semante.
     * @param seed o valor da nova semente de geração.
     */
    public void setSeed(long seed) {
        this.seed = seed;
    }
}