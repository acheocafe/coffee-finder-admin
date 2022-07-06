package br.com.coffeefinder.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import br.com.coffeefinder.domain.mapper.RoasterMapper;
import br.com.coffeefinder.exception.RoasterNotFoundException;
import br.com.coffeefinder.mockhelpers.service.RoasterServiceHelper;
import br.com.coffeefinder.repository.RoasterRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

/** TestRoasterService */
@ExtendWith(MockitoExtension.class)
class RoasterServiceTest {

  @InjectMocks RoasterServiceImpl roasterService;

  @Mock RoasterRepository roasterRepository;

  @Spy RoasterMapper roasterMapper = Mappers.getMapper(RoasterMapper.class);

  @Test
  void test_find_by_id_success() {
    var expected = RoasterServiceHelper.mockExpectedRoaster();
    when(roasterRepository.findById(2L))
        .thenReturn(RoasterServiceHelper.mockRoasterRepositoryReturn());
    var actual = roasterService.findById("2");
    assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
  }

  @Test
  void test_nonexistent_roaster_id_should_throw_exception() {

    when(roasterRepository.findById(3L)).thenReturn(Optional.empty());

    RoasterNotFoundException expectedException =
        assertThrows(RoasterNotFoundException.class, () -> roasterService.findById("3"));
    assertEquals("Could not find Roaster: 3", expectedException.getMessage());
  }
}
