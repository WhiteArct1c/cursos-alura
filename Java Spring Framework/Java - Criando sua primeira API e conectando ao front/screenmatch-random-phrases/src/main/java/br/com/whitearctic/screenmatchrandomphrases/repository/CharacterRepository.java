package br.com.whitearctic.screenmatchrandomphrases.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.whitearctic.screenmatchrandomphrases.model.Character;
import br.com.whitearctic.screenmatchrandomphrases.model.Serie;

public interface CharacterRepository extends JpaRepository<Character, Long>{

    List<Character> findAllBySerie(Serie serie);

}
