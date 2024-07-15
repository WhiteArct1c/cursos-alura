package br.com.whitearctic.screenmusicchallenge.service;

import br.com.whitearctic.screenmusicchallenge.model.Singer;
import br.com.whitearctic.screenmusicchallenge.repository.SingerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingerService {

    private final SingerRepository singerRepository;

    public SingerService(SingerRepository singerRepository) {
        this.singerRepository = singerRepository;
    }

    public void registerSinger(String name, String type) {
        try{
            String singerType = type.toUpperCase().trim();
            Singer singer = new Singer(name, singerType);
            singerRepository.save(singer);
        } catch (Exception e) {
            System.out.println(STR."Error registering singer: \{e.getMessage()}");
        }
    }

    public List<Singer> findSingerByLikeName(String singerName) {
        try{
            return singerRepository.findByNameContaining(singerName);
        } catch (Exception e) {
            System.out.println(STR."Error finding singer: \{e.getMessage()}");
            return null;
        }
    }

    public Singer findSingerByName(String singerName) {
        try{
            return singerRepository.findByName(singerName);
        } catch (Exception e) {
            System.out.println(STR."Error finding singer: \{e.getMessage()}");
            return null;
        }
    }

    public List<Singer> listSingers() {
        try{
            return singerRepository.findAll();
        } catch (Exception e) {
            System.out.println(STR."Error listing singers: \{e.getMessage()}");
            return null;
        }
    }
}
