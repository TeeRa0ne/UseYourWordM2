package uyw.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "[game]")
@Getter @Setter
@NoArgsConstructor
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "game_id")
	private int id;

    @ManyToMany
	@JoinTable(name = "medias", joinColumns = @JoinColumn(name = "game_id"), inverseJoinColumns = @JoinColumn(name = "media_id"))
	private List<Media> medias;

    @ManyToMany
	@JoinTable(name = "players", joinColumns = @JoinColumn(name = "game_id"), inverseJoinColumns = @JoinColumn(name = "player_id"))
	private List<Player> players;
}