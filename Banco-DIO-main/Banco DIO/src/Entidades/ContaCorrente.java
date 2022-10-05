package Entidades;

import Entidades.EntidadesPessoas.Cliente;
import Entidades.EntidadesPessoas.Pessoa;

import static Utils.Util.verificarValor;

public class ContaCorrente extends Conta {


    public ContaCorrente( Cliente cliente) {
        super(cliente);
        this.saldo = 0.0;
    }

    @Override
    public void depositar(Double valor) {
        if (verificarValor(valor)) saldo += valor;
    }

    @Override
    public void sacar(Double valor) {
        if (verificarValor(valor) && this.saldo >= valor) saldo -= valor;
    }

    @Override
    public void transferir(Conta contaDestino, Double valor) {
        sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public String toString() {
        return "Conta Corrente\n" +
                "\nAgencia: " + agencia +
                "\nNúmeroConta: " + numeroConta +
                "\nSaldo: " + saldo +
                "\n" + cliente;

    }
}
