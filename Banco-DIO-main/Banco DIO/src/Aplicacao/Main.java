package Aplicacao;

import Entidades.Banco;
import Entidades.Conta;
import Entidades.ContaCorrente;
import Entidades.ContaPoupanca;
import Entidades.EntidadesPessoas.Cliente;
import Entidades.EntidadesPessoas.Funcionario;

import javax.swing.*;

import static Aplicacao.Vizualizacao.aplicacao;

public class Main {

    public static void main(String[] args) {
        //aplicacao();

        Funcionario func = new Funcionario();
        func.criarContaPoupanca();
        func.criarContaPoupanca();

        Banco.extratoCC();
        Banco.extratoCP();


    }
}
