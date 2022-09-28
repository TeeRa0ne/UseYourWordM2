package uyw.dto;

import lombok.Getter;
import lombok.Setter;
import uyw.model.Media;

@Getter @Setter
public class MediaDto {
  private Media media;
  private String url;
}
