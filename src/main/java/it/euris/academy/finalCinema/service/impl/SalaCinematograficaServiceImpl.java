package it.euris.academy.finalCinema.service.impl;

import it.euris.academy.finalCinema.data.dto.SalaCinematograficaDto;
import it.euris.academy.finalCinema.repository.SalaCinematograficaRepository;
import it.euris.academy.finalCinema.service.SalaCinematograficaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaCinematograficaServiceImpl implements SalaCinematograficaService {

  @Autowired
  SalaCinematograficaRepository salaCinematograficaRepository;

  @Override
  public List<SalaCinematograficaDto> getAll() {
    return null;
  }

  @Override
  public SalaCinematograficaDto get(Long id) {
    return null;
  }

  @Override
  public SalaCinematograficaDto add(SalaCinematograficaDto salaCinematograficaDto) {
    return null;
  }

  @Override
  public SalaCinematograficaDto update(SalaCinematograficaDto movieDto) {
    return null;
  }

  @Override
  public Boolean delete(Long id) {
    return null;
  }
}
