package uyw.dto;

import java.util.Random;

import lombok.Getter;
import lombok.Setter;
import uyw.model.EMedia;

@Getter @Setter
public class MediaDto {
  private EMedia media;
  private String url;

  public static MediaDto getNewMedia() {
		MediaDto mediaDto = new MediaDto();
		mediaDto.setMedia(Media.values()[new Random().nextInt(Media.values().length)]);


		switch (mediaDto.getMedia()) {
			case IMAGE:
				mediaDto.setUrl("https://unsplash.it/600");
				break;
			case VIDEO:
				mediaDto.setUrl("https://www.youtube.com/embed/xvFZjo5PgG0");
				break;
			case TEXTE:
				mediaDto.setUrl("https://www.lipsum.com/");
				break;
			default:
				break;
		}

		return mediaDto;
	}
}
