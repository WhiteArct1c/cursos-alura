package br.com.whitearctic.screenmusicchallenge.repository;

import br.com.whitearctic.screenmusicchallenge.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Long> {
}
