package Entidades;

import Entidades.EntidadesPessoas.Cliente;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Banco {

    public static final String NOME_BANCO = "Banco DIO";

    public Banco() {}

    public static List<Cliente> clientes = new ArrayList<>();
    public static List<ContaCorrente> contaCorrentes = new ArrayList<>();
    public static List<ContaPoupanca> contaPoupancas = new ArrayList<>();

    public static ContaCorrente getContaPorNumeroCC(String numConta){
        for(ContaCorrente conta: contaCorrentes){
            if(String.valueOf(conta.getNumeroConta()).equals( numConta))
                return conta;
        }
        return null;
    }

    public static ContaPoupanca getContaPorNumeroCP(String numConta){
        for(ContaPoupanca conta: contaPoupancas){
            if(String.valueOf(conta.getNumeroConta()).equals( numConta))
                return conta;
        }
        return null;
    }


    public static String[][] extratoContas() {

        String[][] dadosExtratos = new String[contaCorrentes.size() + contaPoupancas.size()][5];
        int c;

        for(c = 0; c < contaCorrentes.size(); c++) {
            dadosExtratos[c][0] = String.valueOf(contaCorrentes.get(c).numeroConta);
            dadosExtratos[c][1] = String.valueOf(contaCorrentes.get(c).agencia);
            dadosExtratos[c][2] = String.valueOf(contaCorrentes.get(c).saldo);
            dadosExtratos[c][3] = contaCorrentes.get(c).getCliente().getCpf();
            dadosExtratos[c][4] = "CC";
        }
        for (int i=0;i< contaPoupancas.size();i++){
            dadosExtratos[c][0] = String.valueOf(contaPoupancas.get(i).numeroConta);
            dadosExtratos[c][1] = String.valueOf(contaPoupancas.get(i).agencia);
            dadosExtratos[c][2] = String.valueOf(contaPoupancas.get(i).saldo);
            dadosExtratos[c][3] = contaPoupancas.get(i).getCliente().getCpf();
            dadosExtratos[c][4] = "CP";
            c++;
        }
        return dadosExtratos;
    }
}
