package uyw.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class NotFoundController {

  public String NotFound() {
    return "404";
  }
  
}
