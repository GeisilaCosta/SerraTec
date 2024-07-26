package banco;

import java.util.List;

public class OperacoesBancarias {

    public static void realizarSaque(Conta conta, double valor) {
        if (conta instanceof ContaCorrente) {
            ContaCorrente contaCorrente = (ContaCorrente) conta;
            if (contaCorrente.getSaldo() >= valor) {
                contaCorrente.setSaldo(contaCorrente.getSaldo() - valor);
                contaCorrente.incrementarNumSaques();
                System.out.println("Saque de R$" + valor + " realizado com sucesso!");
            } else {
                System.out.println("Saldo insuficiente para realizar o saque!");
            }
        } else if (conta instanceof ContaPoupanca) {
            ContaPoupanca contaPoupanca = (ContaPoupanca) conta;
            if (contaPoupanca.getSaldo() >= valor) {
                contaPoupanca.setSaldo(contaPoupanca.getSaldo() - valor);
                contaPoupanca.incrementarNumSaques();
                System.out.println("Saque de R$" + valor + " realizado com sucesso!");
            } else {
                System.out.println("Saldo insuficiente para realizar o saque!");
            }
        }
    }

    public static void realizarDeposito(Conta conta, double valor) {
        if (conta instanceof ContaCorrente) {
            ContaCorrente contaCorrente = (ContaCorrente) conta;
            contaCorrente.setSaldo(contaCorrente.getSaldo() + valor);
            contaCorrente.incrementarNumDepositos();
            System.out.println("Depósito de R$" + valor + " realizado com sucesso!");
        } else if (conta instanceof ContaPoupanca) {
            ContaPoupanca contaPoupanca = (ContaPoupanca) conta;
            contaPoupanca.setSaldo(contaPoupanca.getSaldo() + valor);
            contaPoupanca.incrementarNumDepositos();
            System.out.println("Depósito de R$" + valor + " realizado com sucesso!");
        }
    }

    public static void realizarTransferencia(Conta origem, Conta destino, double valor) {
        if (origem instanceof ContaCorrente && destino instanceof ContaCorrente) {
            ContaCorrente origemCorrente = (ContaCorrente) origem;
            ContaCorrente destinoCorrente = (ContaCorrente) destino;
            if (origemCorrente.getSaldo() >= valor) {
                origemCorrente.setSaldo(origemCorrente.getSaldo() - valor);
                destinoCorrente.setSaldo(destinoCorrente.getSaldo() + valor);
                origemCorrente.incrementarNumTransferencias();
                System.out.println("Transferência de R$" + valor + " realizada com sucesso!");
            } else {
                System.out.println("Saldo insuficiente para realizar a transferência!");
            }
        } else if (origem instanceof ContaPoupanca && destino instanceof ContaPoupanca) {
            ContaPoupanca origemPoupanca = (ContaPoupanca) origem;
            ContaPoupanca destinoPoupanca = (ContaPoupanca) destino;
            if (origemPoupanca.getSaldo() >= valor) {
                origemPoupanca.setSaldo(origemPoupanca.getSaldo() - valor);
                destinoPoupanca.setSaldo(destinoPoupanca.getSaldo() + valor);
                origemPoupanca.incrementarNumTransferencias();
                System.out.println("Transferência de R$" + valor + " realizada com sucesso!");
            } else {
                System.out.println("Saldo insuficiente para realizar a transferência!");
            }
        }
    }

}
