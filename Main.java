import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ContaBancaria contaCorrente = new ContaCorrente("José Maria Teste", 0.0, 1234);
        ContaBancaria contaPoupanca = new ContaPoupanca("Tesouro Teste", 100.0, 4321, 10);


        System.out.println("\n ********** Sistema de Conta Bancária **********");

        ContaBancaria contaEscolhida = null;

        while (contaEscolhida == null) {
            System.out.println("Escolha o tipo de conta \n1 - Conta Corrente \n2 - Conta Poupança");
            int opcao = scan.nextInt();

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
                System.out.println("Saldo: R$ " + contaEscolhida.getSaldo());
                if(contaEscolhida == contaPoupanca){
                    ((ContaPoupanca) contaPoupanca).aplicarJuros();
                }


                do {
                    System.out.println("\nEscolha uma opção:");
                    System.out.println("\033[1;32m1 - Depositar\033[0m");   // Cor verde
                    System.out.println("\033[1;34m2 - Transferir\033[0m");  // Cor azul
                    System.out.println("\033[1;33m3 - Ver Saldo\033[0m");   // Cor amarela
                    System.out.println("\033[1;31m4 - Emitir Relatório\033[0m"); // Cor vermelha
                    System.out.println("\033[1;35m5 - Trocar tipo de conta\033[0m");  // Cor roxa
                    System.out.println("\033[1;36m6 - Sair\033[0m");

                    opcao = scan.nextInt();


                    switch (opcao) {
                        case 1:
                            System.out.println("Digite o valor que deseja depositar: ");
                            double deposito = scan.nextDouble();
                            if (deposito > 0) {
                                contaEscolhida.depositar(deposito);
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
                            boolean contaAutenticada = false;
                            ContaBancaria contaEscolhidaAnterior = contaEscolhida;


                            while (!contaAutenticada) {
                                System.out.println("Escolha o tipo de conta");
                                System.out.println("1 - Conta Corrente");
                                System.out.println("2 - Conta Poupança");

                                int trocaDeConta = scan.nextInt();
                                if (trocaDeConta == 1) {
                                    contaEscolhida = contaCorrente;
                                } else if (trocaDeConta == 2) {
                                    contaEscolhida = contaPoupanca;
                                } else {
                                    System.out.println("Opção inválida.");
                                    continue;
                                }

                                System.out.println("Digite sua senha da conta: ");
                                int senhaTrocaDeConta = scan.nextInt();

                                if (contaEscolhida.autenticar(senhaTrocaDeConta)) {
                                    System.out.println("Senha Correta\nBem-vindo(a) Novamente!! " + contaEscolhida.getTitular());
                                    System.out.println("------------------------------------");
                                    System.out.println("Saldo: R$ " + contaEscolhida.getSaldo());
                                    contaAutenticada = true;
                                } else {
                                    System.out.println("Senha incorreta! Acesso negado.");
                                    contaEscolhida = contaEscolhidaAnterior;
                                }
                            }
                            break;

                        case 6:
                            System.out.println("Saindo do Sistema de Conta Bancária\n");
                            break;

                        default:
                            System.out.println("Opção inválida! Tente novamente.\n");
                    }
                } while (opcao != 6);

            } else {
                System.out.println("Senha incorreta! Acesso negado.");
            }
        }
            scan.close();

    }
}
