import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ContaBancaria contaCorrente = new ContaCorrente("José Maria Teste", 0.0, 1234, 21.99);
        ContaBancaria contaPoupanca = new ContaPoupanca("Tesouro Teste", 100.0, 4321, 0.5);

        System.out.println("\n ********** Sistema de Conta Bancária **********");


        System.out.println("Escolha o tipo de conta \n1 - Conta Corrente \n2 - Conta Poupança:");
        int opcao = scan.nextInt();
        ContaBancaria contaEscolhida = null;

        if (opcao == 1) {
            contaEscolhida = contaCorrente;
        } else if (opcao == 2) {
            contaEscolhida = contaPoupanca;
        } else {
            System.out.println("Opção inválida.");
            return;
        }


        System.out.println("Digite sua senha da conta: ");
        int senhaDigitada = scan.nextInt();

        if (contaEscolhida.autenticar(senhaDigitada)) {
            System.out.println("Senha Correta\nBem-vindo(a) " + contaEscolhida.getTitular());
            System.out.println("------------------------------------");
            System.out.println("Saldo inicial: R$ " + contaEscolhida.getSaldo());


            do {
                System.out.println("\nEscolha uma opção:");
                System.out.println("\033[1;32m1 - Depositar\033[0m");   // Cor verde
                System.out.println("\033[1;34m2 - Transferir\033[0m");  // Cor azul
                System.out.println("\033[1;33m3 - Ver Saldo\033[0m");   // Cor amarela
                System.out.println("\033[1;31m4 - Emitir Relatório\033[0m"); // Cor vermelha
                System.out.println("\033[1;35m5 - Sair\033[0m");  // Cor roxa

                opcao = scan.nextInt();

                // Tratar opção desejada
                switch (opcao) {
                    case 1:
                        System.out.println("Digite o valor que deseja depositar: ");
                        double deposito = scan.nextDouble();
                        if (deposito > 0) {
                            contaEscolhida.depositar(deposito);     // Realiza o depósito
                        } else {
                            System.out.println("Valor de depósito inválido! Tente novamente.\n");
                        }
                        break;

                    case 2:
                        System.out.println("Digite o valor que deseja transferir: ");
                        double transferencia = scan.nextDouble();
                        if (contaEscolhida.transferir(transferencia)) {
                            System.out.println("Transferência realizada com sucesso!");
                        } else {
                            System.out.println("Saldo insuficiente ou valor inválido. Transferência não realizada.\n");
                        }
                        break;

                    case 3:
                        System.out.println("\nSaldo atual: R$ " + String.format("%.2f", contaEscolhida.getSaldo()) + "\n");
                        break;

                    case 4:
                        contaEscolhida.emitirRelatorio();
                        break;

                    case 5:
                        System.out.println("Saindo do Sistema de Conta Bancária\n");
                        break;

                    default:
                        System.out.println("Opção inválida! Tente novamente.\n");
                }
            } while (opcao != 5);

        } else {
            System.out.println("Senha incorreta! Acesso negado.");
        }

        scan.close();
    }
}
