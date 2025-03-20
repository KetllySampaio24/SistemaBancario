import java.util.Calendar;

public class ContaCorrente extends ContaBancaria {


    public ContaCorrente(String titular, double saldo, int senha) {
        super(titular, saldo, senha);
    }


    @Override
    public void emitirRelatorio() {
        super.emitirRelatorio();
        System.out.println("Tipo de Conta: Conta Corrente");
    }
}
