import java.util.ArrayList;
import java.util.Arrays;

/**
 * Essa é uma classe auxiliar que permite gerencia um conjunto de vários dados simultaneamente. Operações como rolar alguns dos dados ou exibir o resultado de todos eles, são implementadas.
 * @author Gabriel de Oliveira Guedes Nogueira (10295496)
 */
public class RolaDados
{
    private ArrayList<Dado> lista_dados;

    /**
     * Construtor que cria e armazena vários objetos do tipo Dado. Usa para isso o construtor padrão daquela classe, ou seja, um dado de 6 lados e gerando sempre uma semente aleatória para o gerador de números aleatórios. Os dados criados podem ser referenciados por números, entre 1 e n.
     * @param n número de dados a serem criados.
     */
    public RolaDados(int n)
    {
        this.lista_dados = new ArrayList<>();
        for(int i = 0; i < n; i++)
            this.lista_dados.add(new Dado());
    }

    /**
     * Rola alguns dos dados.
     * @param quais é um array de booleanos que indica quais dados devem ser rolados. Cada posição representa um dos dados. Ou seja, a posição 0 do array indica se o dado 1 deve ser rolado ou não, e assim por diante.
     * @return retorna o valor de cada um dos dados, inclusive os que não foram rolados. Nesse caso, o valor retornado é o valor anterior que ele já possuia.
     */
    public int[] rolar(boolean[] quais)
    {
        int[] dados = new int[this.lista_dados.size()];
        for(int i = 0; i < this.lista_dados.size(); i++)
            dados[i] = (quais[i]) ? this.lista_dados.get(i).rolar() : this.lista_dados.get(i).getLado();

        return dados;
    }

    /**
     * Rola todos os dados.
     * @return retorna o valor de cada um dos dados, inclusive os que não foram rolados. Nesse caso, o valor retornado é o valor anterior que ele já possuia.
     */
    public int[] rolar() {
        boolean[] quais = new boolean[this.lista_dados.size()];  Arrays.fill(quais, true);
        return this.rolar(quais);
    }

    /**
     * Rola alguns dos dados.
     * @param s é um String que possui o número dos dados a serem rolados. Por exemplo "1 4 5" indica que os dados 1 4 e cinco devem ser rolados. Os números devem ser separados por espaços. Se o valor passado no string estiver fora do intervalo válido, ele é ignorado simplesmente.
     * @return retorna o valor de cada um dos dados, inclusive os que não foram rolados. Nesse caso, o valor retornado é o valor anterior que ele já possuia.
     */
    public int[] rolar(String s)
    {
        boolean[] quais = new boolean[this.lista_dados.size()];  Arrays.fill(quais, false);
        for(char c: s.toCharArray()) {
            int n = Character.getNumericValue(c) - 1;
            if(n >= 0 && n < quais.length)
                quais[n] = true;
        }

        return this.rolar(quais);
    }

    /**
     * Retorna a enésima linha da string. Caso não haja n linhas, a última linha encontrada é retornada.
     * @param str
     * @return a enésima linha da string.
     */
    private static String getLine(String str, int n) {
        StringBuffer out = new StringBuffer();
        int counter = 0;

        for(char c: str.toCharArray()) {
            if(c == '\n') {
                if (++counter == n)
                    break;
                out.delete(0, out.length());
            }
            else
                out.append(c);
        }

        return out.toString();
    }

    /**
     * Usa a representação em string do dados, para mostrar o valor de todos os dados do conjunto. Exibe os dados horizontalmente, por exemplo:
     *  1          2          3          4          5
     * +-----+    +-----+    +-----+    +-----+    +-----+
     * |*   *|    |     |    |*    |    |*    |    |*   *|
     * |  *  |    |  *  |    |     |    |  *  |    |     |
     * |*   *|    |     |    |    *|    |    *|    |*   *|
     * +-----+    +-----+    +-----+    +-----+    +-----+
     */
    @Override
    public String toString()
    {
        String[] dadosStr = new String[this.lista_dados.size()];
        for(int i = 0; i < this.lista_dados.size(); i++) {
            System.out.printf(" %d         ", i + 1);
            dadosStr[i] = this.lista_dados.get(i).toString();
        }

        StringBuffer r = new StringBuffer();
        for(int line = 1; line <= 5; line++) {
            for(String s: dadosStr)
                r.append(getLine(s, line));
            r.append("\n");
        }

        return r.toString();
    }
}
