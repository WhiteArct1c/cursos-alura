package br.com.whitearctic.screenmusicchallenge.repository;

import br.com.whitearctic.screenmusicchallenge.model.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SingerRepository extends JpaRepository<Singer, Long> {
    Singer findByName(String singerName);

    List<Singer> findByNameContaining(String singerName);
}
