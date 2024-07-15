package br.com.whitearctic.screenmusicchallenge;

import br.com.whitearctic.screenmusicchallenge.service.MusicService;
import br.com.whitearctic.screenmusicchallenge.service.SingerService;
import br.com.whitearctic.screenmusicchallenge.view.PrincipalMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenMusicChallengeApplication implements CommandLineRunner {

    @Autowired
    private SingerService singerService;
    @Autowired
    private MusicService musicService;

    public static void main(String[] args) {
        SpringApplication.run(ScreenMusicChallengeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        PrincipalMenu menu = new PrincipalMenu(singerService, musicService);
        menu.showMenu();
    }
}
