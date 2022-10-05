package Entidades;

import Entidades.EntidadesPessoas.Cliente;

public abstract class Conta {

    private static final int AGENCIA_PADRAO = 14;
    private static int SEQUENCIAL = 0;

    protected int agencia;
    protected int numeroConta;
    protected Double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numeroConta = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public abstract void depositar(Double valor);

    public abstract void sacar(Double valor);

    public abstract void transferir(Conta contaDestino, Double valor);

    public int getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
