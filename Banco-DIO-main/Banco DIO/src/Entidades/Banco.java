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

    public static void extratoCC() {
        for(ContaCorrente cc : contaCorrentes) {
            JOptionPane.showMessageDialog(null, cc.toString(),NOME_BANCO, JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static void extratoCP() {
        for(ContaPoupanca cp : contaPoupancas) {
            JOptionPane.showMessageDialog(null, cp.toString(),NOME_BANCO, JOptionPane.PLAIN_MESSAGE);
        }
    }

}
