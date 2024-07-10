package br.com.whitearctic.screenmatchrandomphrases.repository;

import br.com.whitearctic.screenmatchrandomphrases.model.Phrase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhraseRepository extends JpaRepository<Phrase, Long> {
    List<Phrase> findAllByCharacterId(Long id);
}
