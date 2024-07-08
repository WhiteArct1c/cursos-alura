package br.com.whitearctic.screenmusicchallenge.view;

import br.com.whitearctic.screenmusicchallenge.model.Singer;
import br.com.whitearctic.screenmusicchallenge.service.MusicService;
import br.com.whitearctic.screenmusicchallenge.service.SingerService;

import java.util.List;
import java.util.Scanner;

public class PrincipalMenu {

    private final SingerService singerService;

    private final MusicService musicService;

    private final Scanner scanner = new Scanner(System.in);

    public PrincipalMenu(SingerService singerService, MusicService musicService) {
        this.singerService = singerService;
        this.musicService = musicService;
    }

    public void showMenu() {
        while(true) {
            System.out.println("1 - Cadastrar cantor");
            System.out.println("2 - Cadastrar música");
            System.out.println("3 - Listar cantores");
            System.out.println("4 - Listar músicas");
            System.out.println("5 - Buscar musicas por artistas");
            System.out.println("0 - Sair");

            var option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    registerSinger();
                    break;
                case 2:
                    registerMusic();
                    break;
                case 3:
                    listSingers();
                    break;
                case 4:
                    listMusics();
                    break;
                case 5:
                    searchMusicsByArtist();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    private void searchMusicsByArtist() {
        System.out.println("Digite o nome do cantor: ");
        var singerName = scanner.nextLine();
        List<Singer> singers = singerService.findSingerByLikeName(singerName);
        singers.forEach(singer -> {
            System.out.println(STR."Artista: \{singer.getName()} - Tipo: \{singer.getSingerType()}");
            singer.getMusics().forEach(music -> System.out.println(STR."Musica: \{music.getName()} - Gênero: \{music.getGenre()}"));
        });
    }

    private void listMusics() {
        musicService.listMusics().forEach(music -> System.out.println(STR."Nome: \{music.getName()} - Cantor: \{music.getSinger().getName()} - Gênero: \{music.getGenre()}"));
    }

    private void listSingers() {
        singerService.listSingers().forEach(singer -> System.out.println(STR."Nome: \{singer.getName()} - Tipo: \{singer.getSingerType()}"));
    }

    private void registerSinger() {
        System.out.println("Digite o nome do cantor: ");
        var name = scanner.nextLine();
        System.out.println("Digite o tipo do cantor (Solo, Dupla ou Banda): ");
        var type = scanner.nextLine();
        singerService.registerSinger(name, type);
    }

    private void registerMusic() {
        System.out.println("Digite o nome da música: ");
        var name = scanner.nextLine();
        System.out.println("Digite o nome do cantor: ");
        var singerName = scanner.nextLine();
        System.out.println("Digite o genero da música: ");
        var genre = scanner.nextLine();
        musicService.registerMusic(name, singerName, genre);
    }
}
