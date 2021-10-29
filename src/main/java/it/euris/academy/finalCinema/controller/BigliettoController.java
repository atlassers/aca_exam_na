package it.euris.academy.finalCinema.controller;

import io.swagger.annotations.Api;
import it.euris.academy.finalCinema.data.dto.BigliettoDto;
import it.euris.academy.finalCinema.service.BigliettoService;
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

@Api(value = "BigliettoController")
@RestController
@RequestMapping("/biglietto")
public class BigliettoController {

  @Autowired
  BigliettoService bigliettoService;

  @GetMapping("/v1")
  public List<BigliettoDto> getAll() {
    return bigliettoService.getAll();
  }

  @GetMapping("/v1/{id}")
  public BigliettoDto get(@PathVariable("id") Long id) {
    return bigliettoService.get(id);
  }

  @PostMapping("/v1")
  public BigliettoDto add(@RequestBody BigliettoDto bigliettoDto) {
    return bigliettoService.add(bigliettoDto);
  }

  @PutMapping("/v1")
  public BigliettoDto update(@RequestBody BigliettoDto bigliettoDto) {
    return bigliettoService.update(bigliettoDto);
  }

  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return bigliettoService.delete(id);
  }

}
