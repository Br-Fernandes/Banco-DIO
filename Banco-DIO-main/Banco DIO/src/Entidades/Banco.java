package Entidades;

import Entidades.EntidadesPessoas.Cliente;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Banco {

    public static final String NOME_BANCO = "Banco DIO";

    public Banco() {
    }

    public static List<Cliente> clientes = new ArrayList<>();
    public static List<ContaCorrente> contaCorrentes = new ArrayList<>();
    public static List<ContaPoupanca> contaPoupancas = new ArrayList<>();

    public static void addAccounts() {
        for (int c = 0; c < 10; c++) {
            clientes.add(new Cliente("test", "12345678912", "996532145"));
            contaCorrentes.add(new ContaCorrente(new Cliente("test_CC", "12345678912", "996532145")));
            contaPoupancas.add(new ContaPoupanca(new Cliente("test_CP", "12345678912", "996532145"), 1500.0));
        }
    }

    public static ContaCorrente getContaPorNumeroCC(String numConta) {
        for (ContaCorrente conta : contaCorrentes) {
            if (String.valueOf(conta.getNumeroConta()).equals(numConta))
                return conta;
        }
        return null;
    }

    public static ContaPoupanca getContaPorNumeroCP(String numConta) {
        for (ContaPoupanca conta : contaPoupancas) {
            if (String.valueOf(conta.getNumeroConta()).equals(numConta))
                return conta;
        }
        return null;
    }


    public static String[][] extratoContas() {

        String[][] dadosExtratos = new String[contaCorrentes.size() + contaPoupancas.size()][5];
        int c;

        for (c = 0; c < contaCorrentes.size(); c++) {
            dadosExtratos[c][0] = String.valueOf(contaCorrentes.get(c).numeroConta);
            dadosExtratos[c][1] = String.valueOf(contaCorrentes.get(c).agencia);
            dadosExtratos[c][2] = String.valueOf(contaCorrentes.get(c).saldo);
            dadosExtratos[c][3] = contaCorrentes.get(c).cliente.getCpf();
            dadosExtratos[c][4] = "CC";
        }
        for (ContaPoupanca contaPoupanca : contaPoupancas) {
            dadosExtratos[c][0] = String.valueOf(contaPoupanca.numeroConta);
            dadosExtratos[c][1] = String.valueOf(contaPoupanca.agencia);
            dadosExtratos[c][2] = String.valueOf(contaPoupanca.saldo);
            dadosExtratos[c][3] = contaPoupanca.cliente.getCpf();
            dadosExtratos[c][4] = "CP";
            c++;
        }
        return dadosExtratos;
    }

}
