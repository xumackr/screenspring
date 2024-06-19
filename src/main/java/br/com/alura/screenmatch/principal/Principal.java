package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.Services.ConsumoApi;
import br.com.alura.screenmatch.Services.ConverteApi;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporadas;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);

    private final String ENDERECO = "https://www.omdbapi.com/?t=";

    private final String API_KEY = "&apikey=edd6c8b0";

    private ConsumoApi consumo = new ConsumoApi();

    private ConverteApi converte = new ConverteApi();


    public void exibeMenu () throws JsonProcessingException {
        System.out.println("Digite o nome da serie que gostaria de pesquisar");
        String nomeSerie = leitura.nextLine();
        String json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dados = converte.converterApi(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporadas> temporadas = new ArrayList<>();

        for (int i = 1; i <= dados.totalTemporadas(); i++ ){
            json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+")+"&season="+i+API_KEY);
            DadosTemporadas dadosTemporadas = converte.converterApi(json, DadosTemporadas.class);
            temporadas.add(dadosTemporadas);
        }
        temporadas.forEach(System.out::println);

    }

}
