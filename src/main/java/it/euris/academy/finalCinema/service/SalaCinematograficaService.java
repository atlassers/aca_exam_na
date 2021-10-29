package it.euris.academy.finalCinema.service;

import it.euris.academy.finalCinema.data.dto.SalaCinematograficaDto;
import java.util.List;

public interface SalaCinematograficaService {

  List<SalaCinematograficaDto> getAll();
  SalaCinematograficaDto get(Long id);
  SalaCinematograficaDto add(SalaCinematograficaDto salaCinematograficaDto);
  SalaCinematograficaDto update(SalaCinematograficaDto movieDto);
  Boolean delete(Long id);
  Boolean svuotaSala(Long id);
}
