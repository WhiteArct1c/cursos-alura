package br.com.whitearctic.screenmatchrandomphrases.controller;

import br.com.whitearctic.screenmatchrandomphrases.dto.response.SeriePhraseResponseDTO;
import br.com.whitearctic.screenmatchrandomphrases.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieService serieService;

    @GetMapping("/frases")
    public SeriePhraseResponseDTO getRandomPhrase() {
        return serieService.getRandomPhraseByCharacter();
   }
}
