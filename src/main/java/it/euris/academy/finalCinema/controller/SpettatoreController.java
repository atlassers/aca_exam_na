package it.euris.academy.finalCinema.controller;

import io.swagger.annotations.Api;
import it.euris.academy.finalCinema.data.dto.SpettatoreDto;
import it.euris.academy.finalCinema.service.SpettatoreService;
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

@Api(value = "SpettatoreController")
@RestController
@RequestMapping("/spettatore")
public class SpettatoreController
{
  @Autowired
  SpettatoreService spettatoreService;

  @GetMapping("/v1")
  public List<SpettatoreDto> getAll() {
    return spettatoreService.getAll();
  }

  @GetMapping("/v1/{id}")
  public SpettatoreDto get(@PathVariable("id") Long id) {
    return spettatoreService.get(id);
  }

  @PostMapping("/v1")
  public SpettatoreDto add(@RequestBody SpettatoreDto spettatoreDto) {
    return spettatoreService.add(spettatoreDto);
  }

  @PutMapping("/v1")
  public SpettatoreDto update(@RequestBody SpettatoreDto spettatoreDto) {
    return spettatoreService.update(spettatoreDto);
  }

  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return spettatoreService.delete(id);
  }
}
