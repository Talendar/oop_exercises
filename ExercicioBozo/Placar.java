import java.util.Arrays;

/**
 * Esta classe representa o placar de um jogo de Bozó. Permite que combinações de dados sejam alocadas às posições e mantém o escore de um jogador.
 * @author Gabriel de Oliveira Guedes Nogueira (10295496)
 */
public class Placar
{
    private int[] score;

    /**
     * Construtor padrão.
     */
    public Placar() {
        this.score =  new int[10];
        Arrays.fill(this.score, -1); //-1 indica que a posição ainda não foi marcada
    }

    /**
     * Conta quantas vezes um determinado lado aparece em uma sequência de dados.
     * @param lado
     * @param dados
     * @return a contagem.
     */
    private static int contaLados(int lado, int[] dados) {
        int count = 0;
        for(int d: dados) {
            if(d == lado)
                count += 1;
        }
        return count;
    }

    /**
     * Conta quantas vezes cada um dos lados aparece nos dados.
     * @param dados
     * @return array de int com 6 elementos, cada qual representando um dos seis lados do dado, com a contagem de sua frequencia.
     */
    private static int[] contaLados(int[] dados) {
        int[] count = new int[6];
        for(int i = 0; i <  5; i++)
            count[dados[i] - 1] += 1;

        return count;
    }

    /**
     * Adiciona uma sequencia de dados em uma determinada posição do placar. Após a chamada, aquela posição torna-se ocupada e não pode ser usada uma segunda vez.
     * @param posicao posição a ser preenchida. As posições 1 a 6 correspondem às quantidas de uns até seis, ou seja, as laterais do placar. As outas posições são: 7 - full hand; 8 - sequencia; 9 - quadra; e 10 - quina
     * @param dados um array de inteiros, de tamanho 5. Cada posição corresponde a um valor de um dado. Supões-se que cada dado pode ter valor entre 1 e 6.
     * @throws java.lang.IllegalArgumentException se a posição estiver ocupada ou se for passado um valor de posição inválido, essa exceção é lançada. Não é feita nenhuma verificação quanto ao tamanho do array nem quanto ao seu conteúdo.
     */
    public void add(int posicao, int[] dados) throws IllegalArgumentException
    {
        if(posicao < 1 || posicao > 10 || this.score[posicao - 1] != -1)
            throw new IllegalArgumentException();

        //posicoes externas
        if(posicao <= 6)
            this.score[posicao - 1] = posicao * contaLados(posicao, dados);
        //full hand
        else if(posicao == 7) {
            int[] count = contaLados(dados);
            boolean seq2 = false, seq3 = false;

            for(int i = 0; i < 6; i++) {
                if(count[i] >= 3)
                    seq3 = true;
                else if(count[i] == 2)
                    seq2 = true;
            }

            this.score[posicao - 1] = (seq2 && seq3) ? 15 : 0;
        }
        //sequencia
        else if(posicao == 8) {
            int[] count = contaLados(dados);
            boolean scored = true;

            if(count[0] > 1 && count[5] > 1)
                scored = false;
            else {
                for (int i = 0; i < 6; i++) {
                    if (count[i] >= 2) {
                        scored = false;
                        break;
                    }
                }
            }

            this.score[posicao - 1] = scored ? 20 : 0;
        }
        //quadra
        else if(posicao == 9){
            int[] count = contaLados(dados);
            boolean scored = false;

            for(int i = 0; i < 6; i++) {
                if(count[i] >= 4) {
                    scored = true;  break;
                }
            }

            this.score[posicao - 1] = scored ? 30 : 0;
        }
        //quina
        else {
            int[] count = contaLados(dados);
            boolean scored = false;

            for(int i = 0; i < 6; i++) {
                if(count[i] == 5) {
                    scored = true;  break;
                }
            }

            this.score[posicao - 1] = scored ? 40 : 0;
        }
    }

    /**
     * Computa a soma dos valores obtidos, considerando apenas as posições que já estão ocupadas.
     * @return o valor da soma.
     */
    public int getScore() {
        int count = 0;
        for(int v: this.score) {
            if(v != -1)
                count += v;
        }

        return count;
    }

    /**
     * Cria uma string para representar a pontuação de uma dada posição.
     * @param pos
     * @return a string criada.
     */
    private String score2str(int pos) {
        return (this.score[pos - 1] == -1) ? String.format("(%d)", pos) :
                    String.format((this.score[pos - 1] < 10) ? " %d " : " %d", this.score[pos - 1]);
    }

    /**
     * A representação na forma de string, mostra o placar completo, indicando quais são as posições livres (com seus respectivos números) e o valor obtido nas posições já ocupadas. Por exemplo:
     *  (1)    |   (7)    |   (4)
     *  --------------------------
     *  (2)    |   20     |   (5)
     *  --------------------------
     *  (3)    |   30     |   (6)
     * --------------------------
     *         |   (10)   |
     *         +----------+
     *
     * mostra as posições 8 (sequencia) e 9 (quadra) ocupadas.
     */
    @Override
    public String toString() {
        return String.format(
                " %s    |   %s    |   %s \n" +
                " --------------------------\n" +
                " %s    |   %s    |   %s \n" +
                " --------------------------\n" +
                " %s    |   %s    |   %s \n" +
                "--------------------------\n" +
                "        |   %s   |\n" +
                "        +----------+",
                this.score2str(1), this.score2str(7), this.score2str(4),
                this.score2str(2), this.score2str(8), this.score2str(5),
                this.score2str(3), this.score2str(9), this.score2str(6),
                                        this.score2str(10));
    }
}
