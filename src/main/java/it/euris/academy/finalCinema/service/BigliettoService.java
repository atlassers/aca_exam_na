package it.euris.academy.finalCinema.service;

import it.euris.academy.finalCinema.data.dto.BigliettoDto;
import java.util.List;

public interface BigliettoService {

  List<BigliettoDto> getAll();
  BigliettoDto get(Long id);
  BigliettoDto add(BigliettoDto bigliettoDto);
  BigliettoDto update(BigliettoDto bigliettoDto);
  Boolean delete(Long id);
}
