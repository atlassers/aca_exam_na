package it.euris.academy.finalCinema.controller;

import io.swagger.annotations.Api;
import it.euris.academy.finalCinema.data.dto.CinemaDto;
import it.euris.academy.finalCinema.service.CinemaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "CinemaController")
@RestController
@RequestMapping("/cinema")
public class CinemaController {

  @Autowired
  private CinemaService cinemaService;

  @GetMapping("/v1")
  public List<CinemaDto> getAll() {
    return cinemaService.getAll();
  }

  @GetMapping("/v1/{id}")
  public CinemaDto get(@PathVariable("id") Long id) {
    return cinemaService.get(id);
  }

  @PostMapping("/v1")
  public CinemaDto add(@RequestBody CinemaDto cinemaDto) {
    return cinemaService.add(cinemaDto);
  }

  @PutMapping("/v1")
  public CinemaDto update(@RequestBody CinemaDto cinemaDto) {
    return cinemaService.update(cinemaDto);
  }

  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return cinemaService.delete(id);
  }

}
