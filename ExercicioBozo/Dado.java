/**
 * Simula um dado de número de lados variados. Ao criar o objeto é possível estabelecer o número de lados. A rolagem do dado é feita por meio de um gerador de números aleatórios (Random).
 * @author Gabriel de Oliveira Guedes Nogueira (10295496)
 */
public class Dado
{
    private int num_lados, ultimo_lado;
    private Random rand;

    /**
     * Cria objeto com um número n qualquer de lados.
     */
    public Dado(int n) {
        this.num_lados = n;
        this.rand = new Random();
    }

    /**
     * Cria um dado com 6 lados (um cubo).
     */
    public Dado() {
        this(6);
    }

    /**
     * Recupera o último número selecionado.
     * @return o número do último lado selecionado.
     */
    public int getLado() {
       return this.ultimo_lado;
    }

    /**
     * Simula a rolagem do dado por meio de um gerador aleatório. O número selecionado pode posteriormente ser recuperado com a chamada a getLado().
     * @return o número que foi sorteado.
     */
    public int rolar() {
        return (this.ultimo_lado = rand.getIntRand(this.num_lados) + 1);
    }

    /**
     * Transforma representação do dado em String. É mostrada uma representação do dado que está para cima. Note que só funciona corretamente para dados de 6 lados.
     */
    @Override
    public String toString() {
        switch(this.ultimo_lado) {
            case 1:
                return  "+-----+    \n" +
                        "|     |    \n" +
                        "|  *  |    \n" +
                        "|     |    \n" +
                        "+-----+    \n";
            case 2:
                return  "+-----+    \n" +
                        "|*    |    \n" +
                        "|     |    \n" +
                        "|    *|    \n" +
                        "+-----+    \n";
            case 3:
                return  "+-----+    \n" +
                        "|*    |    \n" +
                        "|  *  |    \n" +
                        "|    *|    \n" +
                        "+-----+    \n";
            case 4:
                return  "+-----+    \n" +
                        "|*   *|    \n" +
                        "|     |    \n" +
                        "|*   *|    \n" +
                        "+-----+    \n";
            case 5:
                return  "+-----+    \n" +
                        "|*   *|    \n" +
                        "|  *  |    \n" +
                        "|*   *|    \n" +
                        "+-----+    \n";
            case 6:
                return  "+-----+    \n" +
                        "|* * *|    \n" +
                        "|     |    \n" +
                        "|* * *|    \n" +
                        "+-----+    \n";
            default:
                return "Erro: nao eh possivel representar um dado com mais de 6 lados!";
        }
    }
}
