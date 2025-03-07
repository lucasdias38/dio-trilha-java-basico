import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        System.out.println(cadastrar());
    }

    private static String cadastrar() {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Por favor, digite o número da conta !");
        int  numero = scanner.nextInt();

        System.out.println("Por favor, digite a Agência !");
        String agencia = scanner.next();

        scanner.nextLine();
        System.out.println("Por favor, digite o seu nome completo !");
        String nomeCliente	= scanner.nextLine();

        System.out.println("É necessário realizar um primeiro depósito, digite o valor !");
        double saldo = scanner.nextDouble();

        return retornarMensagem(numero, agencia, nomeCliente, saldo);
    }

    private static String retornarMensagem(int numero, String agencia, String nomeCliente, double saldo) {
        String retorno = "Olá ";
        retorno = retorno.concat(nomeCliente).concat(" obrigado por criar uma conta em nosso banco");
        retorno = retorno.concat(", sua agência é ").concat(agencia);
        retorno = retorno.concat(", conta ").concat(""+numero+"");
        retorno = retorno.concat(" e seu saldo ").concat(doubleToBRL(saldo)).concat(" já está disponível para saque.");
        return retorno;
    }

    private static String doubleToBRL(double value) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
    
        DecimalFormat format = new DecimalFormat("###,###,##0.00", symbols);
        return "R$ " + format.format(value);
    }

}
