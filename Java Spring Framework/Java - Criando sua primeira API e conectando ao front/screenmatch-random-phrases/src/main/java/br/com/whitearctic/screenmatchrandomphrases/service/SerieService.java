package br.com.whitearctic.screenmatchrandomphrases.service;

import br.com.whitearctic.screenmatchrandomphrases.dto.response.SeriePhraseResponseDTO;
import br.com.whitearctic.screenmatchrandomphrases.model.Character;
import br.com.whitearctic.screenmatchrandomphrases.model.Phrase;
import br.com.whitearctic.screenmatchrandomphrases.model.Serie;
import br.com.whitearctic.screenmatchrandomphrases.repository.CharacterRepository;
import br.com.whitearctic.screenmatchrandomphrases.repository.PhraseRepository;
import br.com.whitearctic.screenmatchrandomphrases.repository.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {

    private final PhraseRepository phraseRepository;

    private final SerieRepository serieRepository;

    private final CharacterRepository characterRepository;

    public SerieService(PhraseRepository phraseRepository, SerieRepository serieRepository, CharacterRepository characterRepository) {
        this.phraseRepository = phraseRepository;
        this.serieRepository = serieRepository;
        this.characterRepository = characterRepository;
    }

    public SeriePhraseResponseDTO getRandomPhraseByCharacter() {
        Serie serie = getRandomSerie();
        Character character = getRandomCharacterBySerie(serie);
        List<Phrase> characterPhrases = phraseRepository.findAllByCharacterId(character.getId());
        if(!characterPhrases.isEmpty()){
            Phrase phrase = characterPhrases.get((int) (Math.random() * characterPhrases.size()));
            return new SeriePhraseResponseDTO(serie.getTitle(), phrase.getText(), character.getName(), serie.getPoster());
        } else {
            throw new RuntimeException(STR."No phrases found for character with id \{character.getId()}");
        }
    }

    public Serie getRandomSerie() {
        List<Serie> series = serieRepository.findAll();
        if(!series.isEmpty()){
            return series.get((int) (Math.random() * series.size()));
        } else {
            throw new RuntimeException("No series found");
        }
    }

    public Character getRandomCharacterBySerie(Serie serie) {
        List<Character> characters = characterRepository.findAllBySerie(serie);
        if(!characters.isEmpty()){
            return characters.get((int) (Math.random() * characters.size()));
        } else {
            throw new RuntimeException(STR."No characters found for serie with id \{serie.getId()}");
        }
    }
}
