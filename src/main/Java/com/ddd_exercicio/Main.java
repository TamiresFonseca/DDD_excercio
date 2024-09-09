package com.ddd_exercicio;

import com.ddd_exercicio.application.DDDApplication;
import com.ddd_exercicio.entitites.DDDEstados;
import com.ddd_exercicio.repositories.DDDRepository;
import com.ddd_exercicio.services.DDDService;
import java.util.Scanner;

public class Main {

    private static DDDApplication dddApplication;
    private static Scanner scanner;

    public static void main(String[] args) {
        DDDRepository repository = new DDDRepository();
        DDDService service = new DDDService();
        dddApplication = new DDDApplication(repository, service);
        scanner = new Scanner(System.in);

        exibirMenu();
    }

    public static void exibirMenu() {
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\n1 - Novo estado");
            System.out.println("2 - Atualizar estado");
            System.out.println("3 - Listar estados");
            System.out.println("4 - Buscar estado pelo DDD");
            System.out.println("5 - Remover estado");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Limpa o buffer do Scanner

            switch (opcao) {
                case 1:
                    criarEstado();
                    break;
                case 2:
                    atualizarEstado();
                    break;
                case 3:
                    listarEstados();
                    break;
                case 4:
                    buscarEstadoPorDDD();
                    break;
                case 5:
                    removerEstado();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void criarEstado() {
        System.out.print("Digite o DDD: ");
        int ddd = scanner.nextInt();
        scanner.nextLine();  // Limpa o buffer do Scanner
        System.out.print("Digite o nome do estado: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o caminho da imagem: ");
        String imagem = scanner.nextLine();

        dddApplication.criarEstado(ddd, nome, imagem);
        System.out.println("Estado criado com sucesso!");
    }

    private static void atualizarEstado() {
        System.out.print("Digite o DDD do estado a ser atualizado: ");
        int ddd = scanner.nextInt();
        scanner.nextLine();  // Limpa o buffer do Scanner
        System.out.print("Digite o novo nome do estado: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o novo caminho da imagem: ");
        String imagem = scanner.nextLine();

        dddApplication.atualizarEstado(ddd, nome, imagem);
        System.out.println("Estado atualizado com sucesso!");
    }

    private static void listarEstados() {
        for (DDDEstados estado : dddApplication.listarEstados()) {
            System.out.println("DDD: " + estado.getDdd() + ", Nome: " + estado.getNome() + ", Imagem: " + estado.getCaminhoImagem());
        }
    }

    private static void buscarEstadoPorDDD() {
        System.out.print("Digite o DDD: ");
        int ddd = scanner.nextInt();

        DDDEstados estado = dddApplication.buscarPorDDD(ddd);
        if (estado != null) {
            System.out.println("DDD: " + estado.getDdd() + ", Nome: " + estado.getNome() + ", Imagem: " + estado.getCaminhoImagem());
        } else {
            System.out.println("Estado não encontrado!");
        }
    }

    private static void removerEstado() {
        System.out.print("Digite o DDD do estado a ser removido: ");
        int ddd = scanner.nextInt();

        dddApplication.removerEstado(ddd);
        System.out.println("Estado removido com sucesso!");
    }
}
