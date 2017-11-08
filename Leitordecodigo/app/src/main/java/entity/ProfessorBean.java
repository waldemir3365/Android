package entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by WaldemirGomesDeAndra on 23/10/2017.
 */
@DatabaseTable(tableName ="TB_PROFESSOR")
public class ProfessorBean {

    @DatabaseField(columnName = "ID", generatedId = true)
    private int id;
    @DatabaseField(columnName = "NOME_PROF")
    private String nome;
    @DatabaseField(columnName = "CPF_PROF")
    private String cpf;
    @DatabaseField(columnName = "LOGIN_PROF")
    private String login;
    @DatabaseField(columnName = "SENHA_PROF")
    private String senha;

    public ProfessorBean() {}

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
}
