package Entidades.EntidadesPessoas;

public abstract class Pessoa {

    private String nome;
    private String cpf;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Nome do cliente: " + nome +
                "\nCPF: " + cpf +
                '\n';
    }
}


