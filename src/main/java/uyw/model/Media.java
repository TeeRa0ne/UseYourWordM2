package uyw.model;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "[Media]")
public class Media {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "type", nullable = false)
    private EMedia media;

  // generate random media 
  public Media randomMedia() {
    this.media = EMedia.values()[new Random().nextInt(EMedia.values().length)];

    switch (this.media) {
			case IMAGE:
				this.url = "https://unsplash.it/600";
				break;
			case VIDEO:
				this.url = "https://www.youtube.com/embed/xvFZjo5PgG0";
				break;
			case TEXTE:
				this.url = "https://www.lipsum.com/";
				break;
			default:
				break;
		}
    return this;
  }

}
