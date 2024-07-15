package br.com.whitearctic.screenmusicchallenge.service;

import br.com.whitearctic.screenmusicchallenge.model.Music;
import br.com.whitearctic.screenmusicchallenge.model.Singer;
import br.com.whitearctic.screenmusicchallenge.repository.MusicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    private final MusicRepository musicRepository;

    private final SingerService singerService;

    public MusicService(MusicRepository musicRepository, SingerService singerService) {
        this.musicRepository = musicRepository;
        this.singerService = singerService;
    }

    public void registerMusic(String name, String singerName, String genre) {
        try {
            Singer singer = singerService.findSingerByName(singerName);
            String genreType = genre.toUpperCase().trim();
            Music music = new Music(name, singer, genreType);
            musicRepository.save(music);
        } catch (Exception e) {
            System.out.println(STR."Error registering music: \{e.getMessage()}");
        }
    }

    public List<Music> listMusics() {
        try {
            return musicRepository.findAll();
        } catch (Exception e) {
            System.out.println(STR."Error listing musics: \{e.getMessage()}");
            return null;
        }
    }
}
