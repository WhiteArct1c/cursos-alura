package br.com.alura.cursospring;

import br.com.alura.cursospring.service.DataConverter;
import br.com.alura.cursospring.service.SerieService;
import br.com.alura.cursospring.view.PrincipalMenu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CursoAluraScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CursoAluraScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) {
        PrincipalMenu principalMenu = new PrincipalMenu(new SerieService(new DataConverter()));

        principalMenu.showMenu();
	}
}
