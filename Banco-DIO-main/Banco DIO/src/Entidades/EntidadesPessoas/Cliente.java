package Entidades.EntidadesPessoas;


import static Utils.Util.formatarCPF;
import static Utils.Util.formatarTelefone;

public class Cliente extends Pessoa {


    private String telefone;

    public Cliente(String nome, String cpf,String telefone) {
        super(nome, formatarCPF(cpf));
        this.telefone = formatarTelefone(telefone);
    }


    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Telefone: " + telefone;
    }



}
