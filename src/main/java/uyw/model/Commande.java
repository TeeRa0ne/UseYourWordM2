package uyw.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "commande")
@Getter @Setter
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cmd_id")
	private int id;
	
	@Column(name = "cmd_date", nullable = false)
	private LocalDateTime date;
	
	@ManyToOne
	@JoinColumn(name = "cmd_client_id", nullable = false)
	private Client client;
	
	@OneToMany(mappedBy = "commande")
	private List<CommandeDetail> details;
}
