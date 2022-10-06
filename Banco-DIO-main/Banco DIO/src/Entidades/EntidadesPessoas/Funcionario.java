package Entidades.EntidadesPessoas;

import Entidades.Banco;
import Entidades.Conta;
import Entidades.ContaCorrente;
import Entidades.ContaPoupanca;

import javax.swing.*;

import static Entidades.Banco.*;
import static Utils.Util.*;

public class Funcionario extends Pessoa {

    public Funcionario() {

    }

    public Funcionario(String nome, String cpf) {
        super(nome, formatarCPF(cpf));
    }

    public void cadastrarCliente() {
        JTextField nome = new JTextField();
        JTextField cpf = new JTextField();
        JTextField telefone = new JTextField();

        //cria campos para as informações serem preechidas
        Object[] campos = {
                "Insira o nome do cliente:", nome,
                "Insira o cpf do cliente", cpf,
                "Insira telefone do cliente", telefone
        };
        JOptionPane.showMessageDialog(null, campos, NOME_BANCO, JOptionPane.PLAIN_MESSAGE);

        //cria um objeto que recebe todas as informações passadas acima
        Cliente c = new Cliente(nome.getText(),cpf.getText(),telefone.getText());
        //o objeto é passado para a lista de clientes, onde é armazenado
        clientes.add(c);

    }

    public void criarContaCorrente() {
        JTextField nome = new JTextField();
        JTextField cpf = new JTextField();

        Object[] campos = {
                "Insira o nome do titular:", nome,
                "Insira o cpf do titular:", cpf
        };
        JOptionPane.showMessageDialog(null, campos, NOME_BANCO, JOptionPane.PLAIN_MESSAGE);

        if (existeCPF(cpf.getText())) {
            ContaCorrente cc = new ContaCorrente(getCliente(cpf.getText()));
            contaCorrentes.add(cc);
        } else {
            JOptionPane.showMessageDialog(null, "Primeiro cadastre o cliente",
                    NOME_BANCO, JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void criarContaPoupanca() {
        JTextField nome = new JTextField();
        JTextField cpf = new JTextField();
        JTextField saldoInicial = new JTextField();

        Object[] campos = {
                "Insira o nome do titular:", nome,
                "Insira o  cpf do titular:", cpf,
                "Insira o valor inicial a ser depositado na conta:", saldoInicial
        };
        JOptionPane.showMessageDialog(null, campos, NOME_BANCO, JOptionPane.PLAIN_MESSAGE);

        if (existeCPF(cpf.getText())) {
            ContaCorrente cc = new ContaCorrente(getCliente(cpf.getText()));
            contaCorrentes.add(cc);
        } else {
            JOptionPane.showMessageDialog(null, "Primeiro cadastre o cliente",
                    NOME_BANCO, JOptionPane.PLAIN_MESSAGE);
        }

    }

}
