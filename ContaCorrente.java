public class ContaCorrente extends ContaBancaria {

    private double taxaDeManutenção;

    public ContaCorrente(String titular, double saldo, int senha, double taxaDeManutenção) {
        super(titular, saldo, senha); // chamando construtor da classe base (ContaBancaria)
        this.taxaDeManutenção = taxaDeManutenção;
    }

    // Cobrar a taxa de manutenção
    public void cobrarTaxa() {
        if (getSaldo() >= taxaDeManutenção) {
            // Deduz a taxa de manutenção diretamente do saldo
            double novoSaldo = getSaldo() - taxaDeManutenção;
            setSaldo(novoSaldo); // Atualiza o saldo após deduzir a taxa
            System.out.println("Taxa de manutenção cobrada: R$ " + String.format("%.2f", taxaDeManutenção));
        } else {
            System.out.println("Saldo insuficiente para cobrar a taxa de manutenção.");
        }
    }

    // Cobrança da taxa após o depósito
    @Override
    public void depositar(double valor) {
        double novoSaldo = getSaldo() + valor;
        setSaldo(novoSaldo); 
        System.out.println("Depósito realizado com sucesso! Saldo após depósito: R$ " + String.format("%.2f", getSaldo()));
    }

    @Override
    public void emitirRelatorio() {
        super.emitirRelatorio();
        System.out.println("Tipo de Conta: Conta Corrente");
        System.out.println("Taxa de Manutenção: R$ " + String.format("%.2f", taxaDeManutenção));
    }


}
