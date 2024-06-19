package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTemporadas(@JsonAlias("Title") String titulo,
                              @JsonAlias("Season") Integer numeroTemporada,
                              @JsonAlias("Episodes") List<DadosEpisodios> episodios) {
}
