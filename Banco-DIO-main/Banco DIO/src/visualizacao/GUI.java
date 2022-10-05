package visualizacao;

import Entidades.Banco;
import Entidades.EntidadesPessoas.Funcionario;

import javax.swing.*;

import static Entidades.Banco.NOME_BANCO;
import static Entidades.Banco.getContaPorNumeroCC;

public class GUI {


    public static void aplicacao() {

        int menu = -1;
        Object[] menu2 = {"Funcionário", "Cliente", "Sair"};

        do {
            try {
                menu = JOptionPane.showOptionDialog(null, "Escolha o tipo de usuário em que deseja logar",
                        NOME_BANCO, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, menu2, menu2[0]);

                if (menu == 0) {
                    int menuFunc;
                    do {
                        Object[] menuFunc2 = {"Cadastrar Cliente", "Criar Conta Corrente", "Criar Conta Poupança",
                                "Extrato Contas", "Voltar"};

                        menuFunc = JOptionPane.showOptionDialog(null, "",
                                NOME_BANCO, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, menuFunc2, menuFunc2[0]);

                        Funcionario func = new Funcionario();

                        switch (menuFunc) {
                            case 0:
                                func.cadastrarCliente();
                                break;
                            case 1:
                                func.criarContaCorrente();
                                break;
                            case 2:
                                func.criarContaPoupanca();
                                break;
                            case 3:
                                gerarTabelaExtratos(Banco.extratoContas());

                                break;

                        }
                    } while (menuFunc != 4 && menuFunc != -1);

                } else if (menu == 1) {
                    int menuCLi;
                    Object[] menuCLi2 = {"Realizar Saque", "Depositar", "Realizar Transferência"};

                    menuCLi = JOptionPane.showOptionDialog(null, "", NOME_BANCO, JOptionPane.DEFAULT_OPTION,
                            JOptionPane.PLAIN_MESSAGE, null, menuCLi2, menuCLi2[0]);
                    try {
                        switch (menuCLi) {
                            case 0:
                                saque();
                                break;

                            case 1:
                                deposito();
                                break;

                            case 2:
                                transferencia();

                        }
                    } catch (NullPointerException e) {
                        JOptionPane.showMessageDialog(null, "Conta inválida!", NOME_BANCO, JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (Exception ex) {

            }
        } while (menu != 2);

    }

    public static void saque() throws NullPointerException {
        JTextField conta = new JTextField();
        JTextField valor = new JTextField();
        String[] items = {"CC", "CP"};
        JComboBox<String> comboBox = new JComboBox<>(items);
        Object[] fields = {
                "Nº da Conta:", conta,
                "Valor do saque:", valor,
                "Tipo:", comboBox
        };

        JOptionPane.showConfirmDialog(null, fields, NOME_BANCO, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (comboBox.getSelectedIndex() == 0)
            Banco.getContaPorNumeroCC(conta.getText()).sacar(Double.parseDouble(valor.getText()));
        else
            Banco.getContaPorNumeroCP(conta.getText()).sacar(Double.parseDouble(valor.getText()));
    }

    public static void deposito() throws NullPointerException {
        JTextField conta = new JTextField();
        JTextField valor = new JTextField();
        String[] items = {"CC", "CP"};
        JComboBox<String> comboBox = new JComboBox<>(items);
        Object[] fields = {
                "Nº da Conta:", conta,
                "Valor do deposito:", valor,
                "Tipo:", comboBox
        };

        JOptionPane.showConfirmDialog(null, fields, NOME_BANCO, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (comboBox.getSelectedIndex() == 0)
            Banco.getContaPorNumeroCC(conta.getText()).depositar(Double.parseDouble(valor.getText()));
        else
            Banco.getContaPorNumeroCP(conta.getText()).depositar(Double.parseDouble(valor.getText()));
    }

    public static void transferencia() throws NullPointerException {
        JTextField atual = new JTextField();
        JTextField destino = new JTextField();
        JTextField valor = new JTextField();
        Object[] fields = {
                "Nº da Conta:", atual,
                "Nº do Destino:", destino,
                "Valor da transferência:", valor
        };

        JOptionPane.showConfirmDialog(null, fields, NOME_BANCO, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);

        Banco.getContaPorNumeroCC(atual.getText()).transferir(getContaPorNumeroCC(destino.getText()), Double.parseDouble(valor.getText()));

    }

    public static void gerarTabelaExtratos(String[][] extratos) {
        String[] colunas = {"Nº Conta", "Agência", "Saldo", "CPF Titular", "Tipo Conta"};
        JTable table = new JTable(extratos, colunas);
        JScrollPane scrollPane = new JScrollPane(table);

        JOptionPane.showConfirmDialog(null, scrollPane, NOME_BANCO, JOptionPane.DEFAULT_OPTION);
    }

}