package br.com.alura.cursospring.view;

import br.com.alura.cursospring.service.SerieService;

import java.util.Scanner;

public class PrincipalMenu {
    private final Scanner scanner = new Scanner(System.in);

    private final SerieService serieService;

    public PrincipalMenu(SerieService serieService) {
        this.serieService = serieService;
    }

    public void showMenu() {
        System.out.println("Bem-vindo ao sistema de séries!");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Buscar série por nome");
        System.out.println("2 - Buscar episódio por nome da série e temporada");
        System.out.println("3 - Buscar todas as temporada por nome da série");
        System.out.println("4 - Buscar melhores episódios por nome da série");
        System.out.println("0 - Sair");

        int option = Integer.parseInt(scanner.nextLine());

        getOption(option);
    }

    public void getOption(int option) {
        switch(option){
            case 1:
                getSerieByNameOption();
                break;
            case 2:
                getEpisodeByNameOption();
                break;
            case 3:
                getAllSeasonsByNameOption();
                break;
            case 4:
                getTopEpisodesByNameOption();
                break;
            case 0:
                exitOption();
                break;
            default:
                System.out.println("Opção inválida!");
                showMenu();
                break;
        }
        scanner.close();
    }

    private void getTopEpisodesByNameOption() {
        System.out.println("Digite o nome da série:");
        String serieName = scanner.nextLine();
        try {
            System.out.println(serieService.getTop5EpisodesDataByName(serieName));
        } catch (Exception e) {
            System.out.println(STR."Erro ao buscar melhores episódios: \{e.getMessage()}");
        }
    }

    public void getSerieByNameOption() {
        System.out.println("Digite o nome da série:");
        String serieName = scanner.nextLine();
        try {
            System.out.println(serieService.getSerieDataByName(serieName));
        } catch (Exception e) {
            System.out.println(STR."Erro ao buscar série: \{e.getMessage()}");
        }
    }

    public void getEpisodeByNameOption() {
        System.out.println("Digite o nome da série:");
        String serieName = scanner.nextLine();

        System.out.println("Digite o número da temporada:");
        int seasonNumber = Integer.parseInt(scanner.nextLine());

        System.out.println("Digite o número do episódio:");
        int episodeNumber = Integer.parseInt(scanner.nextLine());

        try {
            System.out.println(serieService.getEpisodeDataByName(serieName, seasonNumber, episodeNumber));
        } catch (Exception e) {
            System.out.println(STR."Erro ao buscar episódio: \{e.getMessage()}");
        }
    }

    public void getAllSeasonsByNameOption() {
        System.out.println("Digite o nome da série:");
        String serieName = scanner.nextLine();
        try {
            serieService.getAllSeasonsDataByName(serieName).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(STR."Erro ao buscar temporadas: \{e.getMessage()}");
        }
    }

    public void exitOption() {
        System.exit(0);
    }
}
