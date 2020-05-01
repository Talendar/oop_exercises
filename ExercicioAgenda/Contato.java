/**
 * Class abstrata que representa a estrutura geral de um contato de agenda.
 */
public abstract class Contato
{
    private String nome, endereco, email;
    private long telefone;

    /**
     * Construtor padrão para um contato.
     * @param nome
     * @param endereco
     * @param email
     * @param telefone
     */
    public Contato(String nome, String endereco, String email, long telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }

    /**
     * Getter para o nome do contato.
     * @return o nome do contato.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Setter para o nome do contato.
     * @param novoNome novo nome do contato.
     */
    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    /**
     * Getter para o enedereço do contato.
     * @return endereço do contato.
     */
    public String getEndereco() {
        return this.endereco;
    }

    /**
     * Setter para o endereço do contato.
     * @param novoEndereco novo endereço do contato.
     */
    public void setEndereco(String novoEndereco) {
        this.endereco = novoEndereco;
    }

    /**
     * Getter para o email do contato.
     * @return o email do contato.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Setter para o email do contato.
     * @param novoEmail novo email do contato.
     */
    public void setEmail(String novoEmail) {

    }

    /**
     * Getter para o telefone do contato.
     * @return o telefone do contato.
     */
    public long getTelefone() {
        return this.telefone;
    }

    /**
     * Setter para o telefone do contato.
     * @param novoTelefone novo telefone do contato.
     */
    public void setTelefone(long novoTelefone) {
        this.telefone = novoTelefone;
    }

    /**
     * Sobrecarga do método para possibilitar a impressão do contato.
     * @return uma string contendo as informações do contato.
     */
    @Override
    public String toString() {
        return String.format(
                "Nome: %s\n" +
                "Email: %s\n" +
                "Endereco: %s\n" +
                "Telefone: %d\n", this.nome, this.email, this.endereco, this.telefone
        );
    }
}
