package it.euris.academy.finalCinema.service.impl;

import it.euris.academy.finalCinema.data.dto.BigliettoDto;
import it.euris.academy.finalCinema.repository.BigliettoRepository;
import it.euris.academy.finalCinema.service.BigliettoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigliettoServiceImpl implements BigliettoService {

  @Autowired
  BigliettoRepository bigliettoRepository;

  @Override
  public List<BigliettoDto> getAll() {
    return null;
  }

  @Override
  public BigliettoDto get(Long id) {
    return null;
  }

  @Override
  public BigliettoDto add(BigliettoDto bigliettoDto) {
    return null;
  }

  @Override
  public BigliettoDto update(BigliettoDto bigliettoDto) {
    return null;
  }

  @Override
  public Boolean delete(Long id) {
    return null;
  }
}
