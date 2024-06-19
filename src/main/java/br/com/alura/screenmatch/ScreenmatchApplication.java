package br.com.alura.screenmatch;

import br.com.alura.screenmatch.Services.ConsumoApi;
import br.com.alura.screenmatch.Services.ConverteApi;
import br.com.alura.screenmatch.Services.IConverteApi;
import br.com.alura.screenmatch.model.DadosEpisodios;
import br.com.alura.screenmatch.model.DadosSerie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.alura.screenmatch.model.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ConsumoApi consumoApi = new ConsumoApi();
		String dados = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=edd6c8b0");
		System.out.println(dados);

		ConverteApi converte = new ConverteApi();
		DadosSerie dados1 = converte.converterApi(dados, DadosSerie.class);

		System.out.println(dados1);

		dados = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=edd6c8b0");

		DadosEpisodios dadosEpisodios = converte.converterApi(dados, DadosEpisodios.class);

		System.out.println(dadosEpisodios);

		List<DadosTemporadas> temporadas = new ArrayList<>();

		for (int i = 1; i <= dados1.totalTemporadas(); i++ ){
			dados = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season="+i+"&apikey=edd6c8b0");
			DadosTemporadas dadosTemporadas = converte.converterApi(dados, DadosTemporadas.class);
			temporadas.add(dadosTemporadas);
		}
		temporadas.forEach(System.out::println);
	}
}
