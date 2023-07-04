package AgenciaBancaria.Programa;

import java.util.ArrayList;
import java.util.Scanner;

import AgenciaBancaria.Conta;

public class PrincipalAgenciaBancaria {

    static Scanner teclado = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {

        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    /**
     * 
     */
    public static void operacoes() {

        System.out.println("--------------------------------------------------------");
        System.out.println("-------------Bem vindo a Nossa Agência------------------");
        System.out.println("--------------------------------------------------------");
        System.out.println("****** Selecione uma Operação que deseja realizar ******");
        System.out.println("--------------------------------------------------------");
        System.out.println("[   Opção 1 - Criar Conta]  ");
        System.out.println("[   Opção 2 - Depositar  ]  ");
        System.out.println("[   Opção 3 - Sacar      ]  ");
        System.out.println("[   Opção 4 - Transferir ]  ");
        System.out.println("[   Opção 5 - Listar     ]  ");
        System.out.println("[   Opção 6 - Sair       ]  ");

        int operacao = teclado.nextInt();
        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listarContas();
                break;
            case 6:
                System.out.println("Obrigado por usar nossa agência");
                System.exit(0);

            default:
                System.out.println("Opção invalida");
                operacoes();
                break;

        }

    }

    public static void criarConta() {

        System.out.println("\nNome: ");
        String nome = teclado.next();
        System.out.println("\nCPF: ");
        String CPF = teclado.next();
        System.out.println("\nEmail: ");
        String email = teclado.next();

        Pessoa pessoa = new Pessoa(nome, CPF, email); // instanciando
        Conta conta = new Conta(pessoa);
        contasBancarias.add(conta);

        System.out.println("Sua conta foi criada com sucesso!");

        operacoes();

    }

    public static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if (contasBancarias.size() > 0){ // Conferir contas na lista de contas
            for (Conta c : contasBancarias) {
                if (c.getNumeroConta() == numeroConta){
                    ;
                conta = c;
            }
        }
    }
        return conta;
    }

    public static void depositar() {
        System.out.println("Numero da Conta ");
        int numeroConta = teclado.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual o valor deseja depositar ");
            Double valorDeposito = teclado.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println("Valor depositado com sucesso");
        } else {
            System.out.println("Conta não encontrada");
        }
        operacoes();
    }

    public static void sacar() {
        System.out.println("Numero da Conta");
        int numeroConta = teclado.nextInt();

        Conta conta = encontrarConta(numeroConta);
        if (conta != null) {
            System.out.println("Qual o valor deseja sacar");
            Double valorSaque = teclado.nextDouble();
            conta.sacar(valorSaque);
           
        } else {
            System.out.println("Conta não encontrada");
        }
        operacoes();
    }

    public static void transferir() {
        System.out.println("Numero da conta do Remetente: ");
        int nContaRemetente = teclado.nextInt();

        Conta contaRemetente = encontrarConta(nContaRemetente);
        if (contaRemetente != null) {
            System.out.println("O numero da conta do destinatário: ");
            int nContaDestinatario = teclado.nextInt();

            Conta contaDestinatario = encontrarConta(nContaDestinatario);

            if (contaDestinatario != null) {
                System.out.println("Valor da transferência: ");
                Double valor = teclado.nextDouble();
                contaRemetente.transferir(contaDestinatario, valor);
            } else {
                System.out.println("A conta para deposito não encontrada ");
            } 
        } else {
            System.out.println("Conta para transferência não encontrada");
        }
        operacoes();
    }

    public static void listarContas() {
        if (contasBancarias.size() > 0) {
            for (Conta conta : contasBancarias) {
                System.out.println(conta);
            }
        } else {
            System.out.println("Não há contas cadastradas! ");
        }
        operacoes();
    }
}
