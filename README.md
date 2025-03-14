# Sistema Bancário

## Descrição

Este é um sistema bancário simples, desenvolvido em Java, que permite criar contas bancárias de diferentes tipos (Corrente e Poupança), realizar depósitos, transferências, ver o saldo e emitir relatórios detalhados. O sistema também aplica juros mensais para contas poupança e cobra uma taxa de manutenção para contas correntes.

---

## Funcionalidades

- **Conta Corrente**: 
  - Possui uma taxa de manutenção mensal que é descontada automaticamente após cada depósito realizado.
  
- **Conta Poupança**: 
  - Aplica juros ao saldo de acordo com a taxa de juros mensal definida.

- **Operações disponíveis**:
  - **Depósito**: Realiza depósitos nas contas.
  - **Transferência**: Realiza transferências entre contas.
  - **Ver saldo**: Exibe o saldo atual da conta.
  - **Emitir Relatório**: Gera um relatório completo da conta.

---

## Tecnologias Usadas

- **Java 8+**
- **IDE recomendada**: IntelliJ IDEA, Eclipse ou qualquer IDE que suporte Java.
- **Sistema Operacional**: O projeto pode ser executado em sistemas operacionais que suportam o JDK (Windows, Linux, macOS).

---

## Estrutura do Projeto

A estrutura básica do projeto é composta pelas seguintes classes:

- **`ContaBancaria`**: Classe base que contém as propriedades e métodos comuns a todas as contas bancárias.
- **`ContaCorrente`**: Herda de `ContaBancaria` e implementa funcionalidades específicas para contas correntes, como a cobrança da taxa de manutenção.
- **`ContaPoupanca`**: Herda de `ContaBancaria` e implementa a funcionalidade de aplicação de juros mensais sobre o saldo.
- **`Main`**: Classe principal que interage com o usuário e gerencia as operações do sistema bancário.

---

## Exemplo de Interação


![image](https://github.com/user-attachments/assets/2d616053-c7b5-4dbe-88c5-2db31f19c2fa)


