package Entidades;

import Entidades.EntidadesPessoas.Cliente;
import static Utils.Util.verificarValor;

public class ContaPoupanca extends Conta {


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
        if (verificarValor(valor)) saldo -= valor;
    }

    @Override
    public void transferir(Conta contaDestino, Double valor) {
        sacar(valor);
        contaDestino.depositar(valor);
    }


}
