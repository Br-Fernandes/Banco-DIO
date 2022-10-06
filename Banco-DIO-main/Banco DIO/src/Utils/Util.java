package Utils;

import Entidades.Conta;
import Entidades.EntidadesPessoas.Cliente;

import javax.swing.*;

import static Entidades.Banco.NOME_BANCO;
import static Entidades.Banco.clientes;

public class Util {

    //  verifica se o cpf contém 11 elementos e
    //  se são somente números
    public static boolean verificarCPF(String cpf) {
        boolean ehNumerico = cpf.matches("[+-]?\\d*(\\.\\d+)?");
        if (cpf.length() == 11)
            return ehNumerico;
        else
            return false;

    }

    // formata o cpf para o formato
    // 999.999.999-99
    public static String formatarCPF(String cpf) {
        if (verificarCPF(cpf)) {
            return  cpf.substring(0,3) +"."+
                    cpf.substring(3,6) +"."+
                    cpf.substring(6,9) +"-"+
                    cpf.substring(9,11);
        } else {
            JOptionPane.showMessageDialog(null, "CPF inválido");
        }
        return "";
    }

    // verifica se o telefone contém 9 elementos
    // e se são somente números
    public static boolean verificarTelefone(String telefone) {
        boolean ehNumerico = telefone.matches("[+-]?\\d*(\\.\\d+)?");
        if (telefone.length() == 9)
            return ehNumerico;
        else
            return false;
    }

    //formata o telefone para o formato
    // 9 9999 9999
    public static String formatarTelefone(String telefone) {
        if (verificarTelefone(telefone)) {
            return telefone.substring(0,1) +" "+
                    telefone.substring(1,5) +" "+
                    telefone.substring(5,9);
        } else {
            JOptionPane.showMessageDialog(null, "Telefone Inválido", NOME_BANCO, JOptionPane.ERROR_MESSAGE);
        }
        return "";
    }

    // verifica se um determinado cpf está vinculado
    // com algum cliente
    public static boolean existeCPF(String cpf){
        boolean e = false;

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(formatarCPF(cpf))){
                e = true;
            }
        }
        return e;
    }

    // verifica se um valor é maior que zero
    public static boolean verificarValor(Double valor) {
        if (valor > 0)
            return true;
        else
            return false;

    }

    // dado um determinado num. de cpf, é retornado
    // o cliente com cpf de mesmo valor
    public static Cliente getCliente(String cpf) {
        Cliente c = null;

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)){
                c = cliente;
            }
        }
        return c;
    }
}
