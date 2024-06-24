package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.OptionalDouble;

public class Serie {

    String titulo;

    Integer totalTemporadas;

    Double avaliacao;

    Categoria genero;

    String atores;

    String poster;
    
    String sinopseEpisodio;

    public Serie (DadosSerie dadosSerie) {
        this.titulo = dadosSerie.titulo();
        this.totalTemporadas = dadosSerie.totalTemporadas();
        this.avaliacao = OptionalDouble.of(Double.valueOf(dadosSerie.avaliacao())).orElse(0);
        this.genero = Categoria.fromString(dadosSerie.genero().split(",")[0].trim());


    }


}
