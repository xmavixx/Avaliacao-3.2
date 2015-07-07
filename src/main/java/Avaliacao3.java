
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utfpr.ct.dainf.if62c.avaliacao.Lancamento;
import utfpr.ct.dainf.if62c.avaliacao.ProcessaLancamentos;

/**
 * IF62C Fundamentos de Programação 2 Avaliação parcial.
 *
 * @author
 */
public class Avaliacao3 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scan = new Scanner(System.in);
        String pacotes;
        System.out.println("Caminho completo do pacote: ");
        pacotes = scan.next();
        ProcessaLancamentos pl = new ProcessaLancamentos(pacotes);
        ArrayList<Lancamento> lancamentos = (ArrayList<Lancamento>) pl.getLancamentos();
        do {
            String conta = scan.next();
            Integer calculo = Integer.valueOf(conta);
            if (calculo == 0) {
                break;
            }
            if (calculo == null) {
                System.out.println("Por favor, informe um valor numérico");
                continue;
            }
            if (lancamentos.indexOf(calculo) == -1) {
                System.out.println("Conta inexistente");
                continue;
            }
            exibeLancamentosConta(lancamentos, calculo);
        } while (true);
    }

    public static void exibeLancamentosConta(List<Lancamento> lancamentos, Integer conta) {
        Integer i = lancamentos.indexOf(conta);
        if (i == -1) {
            return;
        }
        Lancamento lanca = lancamentos.get(i);
        while (lanca.getConta() == conta) {
            System.out.println(lanca);
            lanca = lancamentos.get(++i);
        }
    }
}
