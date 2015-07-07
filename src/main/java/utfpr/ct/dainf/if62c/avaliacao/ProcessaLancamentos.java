package utfpr.ct.dainf.if62c.avaliacao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * IF62C Fundamentos de Programação 2 Avaliação parcial.
 *
 * @author
 */
public class ProcessaLancamentos {

    private BufferedReader reader;

    public ProcessaLancamentos(File arquivo) throws FileNotFoundException {
        
        reader = new BufferedReader(new FileReader(arquivo));
        
    }

    public ProcessaLancamentos(String path) throws FileNotFoundException {
        
        reader = new BufferedReader(new FileReader(path));
        
    }

    private String getNextLine() throws IOException {
        
        return reader.readLine();
        
    }

    private Lancamento processaLinha(String linha) {
        
        int dia, mes, ano;
        int conta;
        double valor;
        String descricao;

        
        conta = Integer.parseInt(linha.substring(0, 6));

        
        ano = Integer.parseInt(linha.substring(6, 10));
        mes = Integer.parseInt(linha.substring(10, 12));
        dia = Integer.parseInt(linha.substring(12, 14));

        
        descricao = linha.substring(14, 74);

        
        valor = Double.parseDouble(linha.substring(74, 86));

        
        valor = valor / 100;

        
        GregorianCalendar data = new GregorianCalendar(ano, mes - 1, dia);
        return new Lancamento(conta, data.getTime(), descricao, valor);
    }

    private Lancamento getNextLancamento() throws IOException {
        String linha = getNextLine();
        
        
        if (linha != null) {

            
            return processaLinha(linha);
        } else {
            
            return null;
            
        }
    }

    public List<Lancamento> getLancamentos() throws IOException {
        ArrayList<Lancamento> lista = new ArrayList<>();

        
        Lancamento atual = getNextLancamento();
        while (atual != null) {
            lista.add(atual);
            atual = getNextLancamento();
        }

        
        Collections.sort(lista, new LancamentoComparator());
        return lista;
    }
}
