/**
 * Classe para representar um contato de agenda de uma pessoa juridica. Subclasse da classe Contato.
 */
public class PessoaJuridica extends Contato
{
    final private long CNPJ, INSCRICAO_ESTADUAL; //campos imutáveis
    private String razaoSocial;

    /**
     * Construtor padrão para um contato de pessoa jurídica.
     * @param nome
     * @param endereco
     * @param email
     * @param telefone
     * @param cnpj
     * @param inscricaoEstadual
     * @param razaoSocial
     */
    public PessoaJuridica(String nome, String endereco, String email, long telefone, long cnpj, long inscricaoEstadual, String razaoSocial) {
        super(nome, endereco, email, telefone);
        this.CNPJ = cnpj;
        this.INSCRICAO_ESTADUAL = inscricaoEstadual;
        this.razaoSocial = razaoSocial;
    }

    /**
     * Getter para o CNPJ do contato.
     * @return o CNPJ do contato.
     */
    public long getCnpj() {
        return this.CNPJ;
    }

    /**
     * Getter para a inscrição estadual do contato.
     * @return a inscrição estadual do contato.
     */
    public long getInscricaoEstadual() {
        return this.INSCRICAO_ESTADUAL;
    }

    /**
     * Getter para a razão social do contato.
     * @return a razão social do contato.
     */
    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    /**
     * Setter para a razão social do contato.
     * @param novaRazaoSocial a nova razão social do contato.
     */
    public void setRazaoSocial(String novaRazaoSocial) {
        this.razaoSocial = novaRazaoSocial;
    }

    /**
     * Sobrecarga do método para possibilitar a impressão do contato.
     * @return uma string contendo as informações do contato.
     */
    @Override
    public String toString() {
        return super.toString() + String.format(
                "CNPJ: %d\n" +
                "Razao social: %s\n" +
                "Inscricao estadual: %d\n",
                this.CNPJ, this.razaoSocial, this.INSCRICAO_ESTADUAL
        );
    }
}
