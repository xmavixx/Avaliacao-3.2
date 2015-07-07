
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
        Scanner entrada = new Scanner(System.in);

        String path, conta;
        System.out.println("Digite o caminho do arquivo:");
        path = entrada.next();
        ProcessaLancamentos processa = new ProcessaLancamentos(path);
        List<Lancamento> lista = processa.getLancamentos();

        boolean diferente = false;

        while (!diferente) {

            System.out.println("Digite o numero da conta:");
            if (entrada.hasNextInt()) {
                int i = entrada.nextInt();
                exibeLancamentosConta(lista, i);
            } else {
                System.out.println("Por favor, informe um valor numérico");
            }
        }
    }

    public static void exibeLancamentosConta(List<Lancamento> lancamentos, Integer conta) {

        int i = lancamentos.indexOf(new Lancamento(conta, null, null, Double.NaN));
        if (i == -1) {
            System.out.println("Conta inexistente.");
        } else {

            int j = lancamentos.lastIndexOf(new Lancamento(conta, null, null, Double.NaN));
            while (i <= j) {
                System.out.println(lancamentos.get(i));
                i++;
            }
        }
    }
}
