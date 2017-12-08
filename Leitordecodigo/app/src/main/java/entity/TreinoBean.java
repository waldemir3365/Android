package entity;

/**
 * Created by WaldemirGomesDeAndra on 24/11/2017.
 */

public class TreinoBean {


    private int id;
    private String tipo;
    private String qtdseries;
    private String qtdrepeticoes;
    private String intervalo;
    private String observacoes;
    private String nome;

    public TreinoBean(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getQtdseries() {
        return qtdseries;
    }

    public void setQtdseries(String qtdseries) {
        this.qtdseries = qtdseries;
    }

    public String getQtdrepeticoes() {
        return qtdrepeticoes;
    }

    public void setQtdrepeticoes(String qtdrepeticoes) {
        this.qtdrepeticoes = qtdrepeticoes;
    }

    public String getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(String intervalo) {
        this.intervalo = intervalo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
