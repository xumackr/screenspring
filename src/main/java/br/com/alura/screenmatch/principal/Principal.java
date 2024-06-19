package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.Services.ConsumoApi;

import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);

    private final String ENDERECO = "https://www.omdbapi.com/?t=";

    private final String API_KEY = "&apikey=edd6c8b0";

    private ConsumoApi consumo = new ConsumoApi();


    public void exibeMenu () {
        System.out.println("Digite o nome da serie que gostaria de pesquisar");
        String nomeSerie = leitura.nextLine();
        String json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);


    }

}
