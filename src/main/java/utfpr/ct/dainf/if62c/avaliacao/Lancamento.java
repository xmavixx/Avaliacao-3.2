package utfpr.ct.dainf.if62c.avaliacao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author 
 */
public class Lancamento {
    private Integer calculo;
    private Date data;
    private String desc;
    private Double valor;
    
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dia: (dd)/mes: (MM)/ano: (yyyy)");

    public Lancamento(Integer calculo, Date data, String desc, Double valor) {
        this.calculo = calculo;
        this.data = data;
        this.desc = desc;
        this.valor = valor;
    }

    public Integer getConta() {
        return calculo;
    }

    public void setConta(Integer conta) {
        this.calculo = conta;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return desc;
    }

    public void setDescricao(String descricao) {
        this.desc = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("%06d %s %-60s %20f", calculo, dateFormat.format(data),
                desc, valor);
    }    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.calculo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass()
                && this.calculo.equals(((Lancamento)obj).calculo);
    }

}
