package Entidades;

import Entidades.EntidadesPessoas.Cliente;

import javax.swing.*;


import static Entidades.Banco.NOME_BANCO;
import static Utils.Util.verificarValor;

public class ContaPoupanca extends Conta {

    private int numeroDeSaques = 0;

    public ContaPoupanca(Cliente cliente, Double saldo) {
        super(cliente);
        this.saldo = saldo;
    }

    @Override
    public void depositar(Double valor) {
        if (verificarValor(valor)) saldo += valor;
    }

    @Override
    public void sacar(Double valor) {
        if (numeroDeSaques > 2) {
            saldo -= (valor + 15);
            JOptionPane.showMessageDialog(null, "Devido ao número de saques este mês, foi " +
                    "cobrado uma taxa de R$ 15,00");

        } else if (verificarValor(valor) && this.saldo >= valor) {
            saldo -= valor;
            numeroDeSaques++;
        } else {
            JOptionPane.showMessageDialog(null, "Valor inválido!", NOME_BANCO, JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void transferir(Conta contaDestino, Double valor) {
        sacar(valor);
        contaDestino.depositar(valor);
    }

    public int getNumeroDeSaques() {
        return numeroDeSaques;
    }

    @Override
    public String toString() {
        return "Conta Poupanca \n" +
                "\nAgencia: " + agencia +
                "\nNumero Conta: " + numeroConta +
                "\nSaldo: " + saldo +
                "\n"+ cliente;
    }
}
