package br.com.coffeefinder.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.coffeefinder.exception.RoasterNotFoundException;
import br.com.coffeefinder.repository.RoasterRepository;

/**
 * TestRoasterService
 */
@ExtendWith(MockitoExtension.class)
class TestRoasterService {

  @InjectMocks
  RoasterService roasterService;

  @Mock
  RoasterRepository roasterRepository;

  @Test
  public void test_nonexistent_roaster_id_should_throw_exception() {
    when(roasterRepository.findById(3L)).thenReturn(Optional.empty());

    RoasterNotFoundException expectedException = assertThrows(RoasterNotFoundException.class,
        () -> roasterService.findById(3L));
    assertEquals(expectedException.getMessage(), "Could not find Roaster: 3");
  }

}
