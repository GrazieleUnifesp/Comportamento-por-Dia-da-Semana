import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SeletorEstrategia seletor = new SeletorEstrategia();

        System.out.print("Nome: ");
        String usuario = scanner.nextLine();

        System.out.print("Tarefa ou meta: ");
        String informacao = scanner.nextLine();

        System.out.println("\n1 - Usar o dia atual (" + seletor.diaHoje() + ")");
        System.out.println("2 - Informar um dia manualmente");
        System.out.print("Opção: ");
        String opcao = scanner.nextLine();
        
        String dia;
        if (opcao.equals("1")) {
            dia = seletor.diaHoje();
        } else {
            System.out.print("Dia da semana: ");
            dia = scanner.nextLine();
        }

        EstrategiaDia estrategia = seletor.obter(dia);
        
        System.out.println("\n--- Resultado ---");
        System.out.println("Usuário: "        + usuario);
        System.out.println("Dia consultado: " + dia);
        System.out.println("Prioridade: "     + estrategia.getPrioridade());
        System.out.println("Mensagem: "       + estrategia.executar(usuario, informacao));
        
        scanner.close();
    }
}