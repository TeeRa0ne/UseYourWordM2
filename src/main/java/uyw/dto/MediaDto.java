package uyw.dto;

import lombok.Getter;
import lombok.Setter;
import uyw.model.EMedia;

@Getter @Setter
public class MediaDto {
  private EMedia media;
  private String url;
}
