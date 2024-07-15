package br.com.whitearctic.screenmusicchallenge.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "singer")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Singer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private SingerType singerType;

    @OneToMany(mappedBy = "singer", fetch = FetchType.EAGER)
    private List<Music> musics;

    public Singer(String name, String type) {
        this.name = name;
        this.singerType = SingerType.valueOf(type);
    }
}
