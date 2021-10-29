package it.euris.academy.finalCinema.controller;

import io.swagger.annotations.Api;
import it.euris.academy.finalCinema.data.dto.SalaCinematograficaDto;
import it.euris.academy.finalCinema.service.SalaCinematograficaService;
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

@Api(value = "SalaCinematograficaController")
@RestController
@RequestMapping("/salacinematografica")
public class SalaCinematograficaController {

  @Autowired
  SalaCinematograficaService salaCinematograficaService;
  @GetMapping("/v1")
  public List<SalaCinematograficaDto> getAll() {
    return salaCinematograficaService.getAll();
  }

  @GetMapping("/v1/{id}")
  public SalaCinematograficaDto get(@PathVariable("id") Long id) {
    return salaCinematograficaService.get(id);
  }

  @PostMapping("/v1")
  public SalaCinematograficaDto add(@RequestBody SalaCinematograficaDto salaCinematograficaDto) {
    return salaCinematograficaService.add(salaCinematograficaDto);
  }

  @PutMapping("/v1")
  public SalaCinematograficaDto update(@RequestBody SalaCinematograficaDto salaCinematograficaDto) {
    return salaCinematograficaService.update(salaCinematograficaDto);
  }

  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return salaCinematograficaService.delete(id);
  }
}
