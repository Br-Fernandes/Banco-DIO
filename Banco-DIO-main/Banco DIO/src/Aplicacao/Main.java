package Aplicacao;

import Entidades.Banco;
import Entidades.Conta;
import Entidades.ContaCorrente;
import Entidades.ContaPoupanca;
import Entidades.EntidadesPessoas.Cliente;
import Entidades.EntidadesPessoas.Funcionario;
import visualizacao.GUI;

import javax.swing.*;


public class Main {

    public static void main(String[] args) {
        Banco.addAccounts();
        GUI.aplicacao();
    }
}
