package br.com.alura.cursospring.service;

import br.com.alura.cursospring.dto.EpisodeDTO;
import br.com.alura.cursospring.dto.SeasonDTO;
import br.com.alura.cursospring.dto.SerieDTO;
import br.com.alura.cursospring.model.Episode;
import br.com.alura.cursospring.utils.APIData;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SerieService {

    private final IDataConverter dataConverter;

    private final ConsumoAPI api = new ConsumoAPI();

    public SerieService(IDataConverter dataConverter) {
        this.dataConverter = dataConverter;
    }

    public SerieDTO getSerieDataByName(String serieName) throws JsonProcessingException {
        String name = serieName.replace(" ", "+").toLowerCase().trim();
        var dados = api.obterDados(STR."\{APIData.API_URI.getValue()}t=\{name}&apikey=\{APIData.API_KEY.getValue()}");
        SerieDTO serieDTO =  dataConverter.getData(dados, SerieDTO.class);
        if(serieDTO.title() == null){
            throw new IllegalArgumentException("Série não encontrada");
        }
        return serieDTO;
    }

    public Episode getEpisodeDataByName(String serieName, int seasonNumber, int episodeNumber) throws JsonProcessingException {
        String name = serieName.replace(" ", "+").toLowerCase().trim();
        var dados = api.obterDados(STR."\{APIData.API_URI.getValue()}t=\{name}&Season=\{seasonNumber}&episode=\{episodeNumber}&apikey=\{APIData.API_KEY.getValue()}");
        EpisodeDTO episodeDTO = dataConverter.getData(dados, EpisodeDTO.class);
        if(episodeDTO.title() == null){
            throw new IllegalArgumentException("Episódio não encontrado");
        }
        return new Episode(seasonNumber, episodeDTO);
    }

    public List<SeasonDTO> getAllSeasonsDataByName(String serieName) throws JsonProcessingException {
        String name = serieName.replace(" ", "+").toLowerCase().trim();
        List<SeasonDTO> seasons = new ArrayList<>();
        for(int i = 1; i <= getSerieDataByName(serieName).totalSeasons(); i++){
            try{
                var dados = api.obterDados(STR."\{APIData.API_URI.getValue()}t=\{name}&Season=\{i}&apikey=\{APIData.API_KEY.getValue()}");
                seasons.add(dataConverter.getData(dados, SeasonDTO.class));
            }catch (Exception e){
                System.out.println(STR."Erro ao buscar temporada: \{e.getMessage()}");
            }
        }
        return seasons;
    }

    public String getTop5EpisodesDataByName(String serieName) throws JsonProcessingException {
        StringBuilder topEpisodesString = new StringBuilder();
        List<SeasonDTO> seasonData = getAllSeasonsDataByName(serieName);
        List<EpisodeDTO> top5Episodes = seasonData.stream()
                .flatMap(season -> season.episodes().stream())
                .filter(episode -> !episode.imdbRating().equalsIgnoreCase("N/A"))
                .sorted((e1, e2) -> e2.imdbRating().compareTo(e1.imdbRating()))
                .limit(5)
                .toList();
        if(top5Episodes.isEmpty()){
            throw new IllegalArgumentException("Episódios não encontrados");
        }
        top5Episodes.forEach(episode -> topEpisodesString.append(STR."Episódio: \{episode.title()} - Nota: \{episode.imdbRating()}\n"));
        return topEpisodesString.toString();
    }
}
