import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class para representar um contato de agenda de uma pessoa física. Subclasse da classe Contato.
 */
public class PessoaFisica extends Contato
{
    final private long CPF; //o cpf do contato é imutável
    final private Date NASCIMENTO; //a data de nascimento do contato é imutável
    private String estadoCivil;

    /**
     * Construtor padrão para um contato de pessoa física.
     * @param nome
     * @param endereco
     * @param email
     * @param telefone
     * @param cpf
     * @param nascimento
     * @param estadoCivil
     */
    public PessoaFisica(String nome, String endereco, String email, long telefone, long cpf, Date nascimento, String estadoCivil) {
        super(nome, endereco, email, telefone);
        this.CPF = cpf;
        this.NASCIMENTO = nascimento;
        this.estadoCivil = estadoCivil;
    }

    /**
     * Getter para o CPF do contato.
     * @return o CPF do contato.
     */
    public long getCpf() {
        return this.CPF;
    }

    /**
     * Getter para a data de nascimento do contato.
     * @return a data de nascimento do contato em um objeto do tipo Date.
     */
    public Date getNascimento() {
        return this.NASCIMENTO;
    }

    /**
     * Getter para o estado civil do contato.
     * @return o estado civil do contato.
     */
    public String getEstadoCivil() {
        return this.estadoCivil;
    }

    /**
     * Setter para o estado civil do contato.
     * @param novoEstadoCivil o novo estado civil do contato.
     */
    public void setEstadoCivil(String novoEstadoCivil) {
        this.estadoCivil = novoEstadoCivil;
    }

    /**
     * Sobrecarga do método para possibilitar a impressão do contato.
     * @return uma string contendo as informações do contato.
     */
    @Override
    public String toString() {
        return super.toString() + String.format(
                "CPF: %d\n" +
                "Data de nascimento: %s\n" +
                "Estado civil: %s\n",
                this.CPF, new SimpleDateFormat("dd/MM/YYYY").format(this.NASCIMENTO), this.estadoCivil
        );
    }
}
