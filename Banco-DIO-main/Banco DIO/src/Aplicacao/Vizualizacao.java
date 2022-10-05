package Aplicacao;

import Entidades.Banco;
import Entidades.EntidadesPessoas.Funcionario;

import javax.swing.*;
import static Entidades.Banco.NOME_BANCO;

public class Vizualizacao {

    public static void aplicacao() {

        int menu = -1;
        Object[] menu2 = {"Funcionário", "Cliente", "Sair"};

        do {
        try {
            menu = JOptionPane.showOptionDialog(null, "Escolha o tipo de usuário em que deseja logar",
                    NOME_BANCO,JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, menu2, menu2[0]);

            if (menu == 0) {
                int menuFunc = -1;
                Object[] menuFunc2 = {"Cadastrar Cliente", "Criar Conta Corrente", "Criar Conta Poupança",
                        "Extrato Contas Correntes", "Extratos Contas Poupanças","Voltar"};

                menuFunc = JOptionPane.showOptionDialog(null, "",
                        NOME_BANCO,JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, menuFunc2, menuFunc2[0]);

                Funcionario func = new Funcionario();
                Banco banco = new Banco();
                switch (menuFunc){
                    case 0:
                        func.cadastrarCliente();

                    case 1:
                        func.criarContaCorrente();

                    case 2:
                        func.criarContaPoupanca();

                    case 3:
                        banco.extratoCC();

                    case 4:
                        banco.extratoCP();

                    case 5:
                        break;
                }

            } else {
                int menuCLi = -1;
                Object[] menuCLi2 = {"Realizar Saque", "Depositar", "Realizar Transferência"};

                JOptionPane.showOptionDialog(null,"", NOME_BANCO, JOptionPane.DEFAULT_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null, menuCLi2, menuCLi2[0]);

                //switch (menuCLi

            }

        } catch (Exception e){

        }
        } while (menu != 2);

    }

}
