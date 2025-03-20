import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContaBancaria {


//    Dados da conta

    private String titular;
    private double saldo;
    private int senha;
    private List<String> transacoes;

    //    Construtor para inicializar a conta bancária
    public ContaBancaria(String titular, double saldo, int senha) {
        this.titular = titular;
        this.saldo = saldo;
        this.senha = senha;
        this.transacoes = new ArrayList<>();
    }


    //   Autenticação de senha
    public boolean autenticar(int senhaDigitada) {
        return this.senha == senhaDigitada;
    }

    //  Deposito
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
        transacoes.add("Deposito: R$" + valor + "| Data:" + new Date());
    }

    //  Transferencia
    public boolean transferir(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor; //deduz o valor de saldo da conta
            transacoes.add("Transferência: R$" + valor + "| Data:" + new Date());
            return true;
        } else {
            System.out.println("Transferência falhou. Verifique o valor ou o saldo.");
            return false;
        }
    }

    //  Relatório
    public void emitirRelatorio() {
        System.out.println("\n********** Relatório de Transações **********");
        System.out.println("Titular: " + titular);
        System.out.println("Saldo Final: R$ " + saldo);
        System.out.println("\nHistórico de Transações:");

        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transação realizada.");
        } else {
            for (String transacao : transacoes) {
                System.out.println(transacao);
            }
        }

        System.out.println("\n********************************************\n");
    }


    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<String> getTransacoes() {
        return transacoes;
    }
}
