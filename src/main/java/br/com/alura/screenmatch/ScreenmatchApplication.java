package br.com.alura.screenmatch;

import br.com.alura.screenmatch.Services.ConsumoApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Primeiro projeto spring sem web");

		var consumoApi = new ConsumoApi();
		var dados = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&Season=1&apikey=edd6c8b0");

		System.out.println(dados);
	}
}
