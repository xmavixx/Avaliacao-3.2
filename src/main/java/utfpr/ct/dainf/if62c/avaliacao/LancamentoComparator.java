package utfpr.ct.dainf.if62c.avaliacao;

import java.util.Comparator;

/**
 * IF62C Fundamentos de Programação 2 Avaliação parcial.
 *
 * @author
 */
public class LancamentoComparator<T extends Lancamento> implements Comparator {

    LancamentoComparator() {
    }

    public int compare(T data1, T data2) {
        if (data1.getConta() < data2.getConta()) {
            return -1;
        } else if (data1.getConta() > data2.getConta()) {
            return 1;
        } else if (data1.getData().before(data2.getData())) {
            return -1;
        } else if (data1.getData().after(data2.getData())) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int compare(Object data1, Object data2) {
        return 0;
    }
}
