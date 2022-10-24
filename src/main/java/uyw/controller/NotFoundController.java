package uyw.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
@RequestMapping("/error")
public class NotFoundController {

  @GetMapping
  @RequestMapping("/404")
  public String NotFound() {
    return "404";
  }
  
}
