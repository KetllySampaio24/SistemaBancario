public class ContaPoupanca extends ContaBancaria {

    public double taxaDeJuros; // mensal

    // Parâmetros
    public ContaPoupanca(String titular, double saldo, int senha, double taxaDeJuros) {
        super(titular, saldo, senha);
        this.taxaDeJuros = taxaDeJuros;
    }

// Aplicar juros ao saldo
    public void aplicarJuros() {
        if (taxaDeJuros > 0) {
            // Calcula os juros baseados no saldo
            double juros = getSaldo() * (taxaDeJuros / 100);
            depositar(juros); // Adiciona os juros ao saldo
            System.out.println("Juros aplicados: R$ " + juros);
        } else {
            System.out.println("Taxa de juros inválida.");
        }
    }

    // Emitir relatório com dados da conta
    @Override
    public void emitirRelatorio() {
        super.emitirRelatorio(); // Chama o metodo mãe
        System.out.println("Tipo de Conta: Conta Poupança");
        System.out.println("Taxa de Juros: " + taxaDeJuros + "%");
    }
}
