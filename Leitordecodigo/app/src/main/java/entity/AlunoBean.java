package entity;

/**
 * Created by WaldemirGomesDeAndra on 24/11/2017.
 */

public class AlunoBean {


    private int id;
    private String nome;
    private String login;
    private String senha;
    private String objetivo;
    private String pagamento;


    public AlunoBean(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }



    @Override
    public String toString(){
        return nome.toString() + " " + login.toString() + senha.toString() + objetivo.toString() + pagamento.toString();

    }

}
