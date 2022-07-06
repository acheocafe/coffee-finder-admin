package br.com.coffeefinder.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import br.com.coffeefinder.exception.RoasterNotFoundException;
import br.com.coffeefinder.repository.RoasterRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/** TestRoasterService */
@ExtendWith(MockitoExtension.class)
class TestRoasterService {

  @InjectMocks RoasterServiceImpl roasterService;

  @Mock RoasterRepository roasterRepository;

  @Test
  void test_nonexistent_roaster_id_should_throw_exception() {

    when(roasterRepository.findById(3L)).thenReturn(Optional.empty());

    RoasterNotFoundException expectedException =
        assertThrows(RoasterNotFoundException.class, () -> roasterService.findById("3"));
    assertEquals("Could not find Roaster: 3", expectedException.getMessage());
  }
}
