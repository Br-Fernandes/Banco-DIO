package Entidades;

import Entidades.EntidadesPessoas.Cliente;

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
        if (verificarValor(valor)) saldo -= valor;
    }

    @Override
    public void transferir(Conta contaDestino, Double valor) {
        sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public String toString() {
        return "ContaCorrente\n" +
                "Agencia: " + agencia +
                "NúmeroConta: " + numeroConta +
                "Saldo: " + saldo +
                "\n" + cliente;
    }
}
