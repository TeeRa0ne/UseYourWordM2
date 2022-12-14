package uyw.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "[reponse]")
@Getter @Setter
@NoArgsConstructor
public class Reponse {

	public Reponse(String answer) {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rep_id")
	private int id;

	@Column(name = "rep_value", nullable = false)
	private String reponse;

	@Column(name = "rep_tour", nullable = false)
	private int tour;

	@Column(name = "rep_vote", nullable = false)
	private int vote;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "rep_player", nullable = false)
	private Player player;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "rep_media", nullable = false)
	private Media media;

    @OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "rep_game", nullable = false)
	private Game game;
}