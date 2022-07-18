package br.com.coffeefinder.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.coffeefinder.domain.mapper.RoasterMapper;
import br.com.coffeefinder.domain.entity.RoasterEntity;
import br.com.coffeefinder.exception.RoasterNotFoundException;
import br.com.coffeefinder.repository.RoasterRepository;
import java.util.Optional;

import br.com.coffeefinder.service.helper.RoasterServiceHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.ArgumentCaptor;
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
  void test_find_all_success() {

    var expected = RoasterServiceHelper.mockExpectedFindAll();

    when(roasterRepository.findAll()).thenReturn(RoasterServiceHelper.mockFindAllRespository());
    var actual = roasterService.findAll();
    assertThat(actual).usingRecursiveFieldByFieldElementComparator().isEqualTo(expected);
  }

  @Test
  void test_save_roaster_success() {
    when(roasterRepository.save(any(RoasterEntity.class)))
        .thenReturn(RoasterServiceHelper.mockSaveRoasterRepository());
    roasterService.save(RoasterServiceHelper.mockExpectedSaveRoaster());
    verify(roasterRepository, times(1)).save(any());
  }

  @Test
  void test_update_roaster_success() {

    ArgumentCaptor<RoasterEntity> roasterArgumentCaptor =
        ArgumentCaptor.forClass(RoasterEntity.class);
    var inputRoasterDto = RoasterServiceHelper.mockInputRoasterDto();
    var actual = roasterService.updateRoaster(inputRoasterDto);

    verify(roasterRepository, times(1)).save(roasterArgumentCaptor.capture());

    var updatedRoaster = roasterArgumentCaptor.getValue();
    var expectedRoaster = RoasterServiceHelper.mockExpectedRoaster();

    assertEquals(expectedRoaster.idToLong(), updatedRoaster.getId());
  }

  @Test
  // TODO: implement
  void test_delete_roaster_success() {
    String roasterTobeDelete = "2";
    roasterService.deleteRoasterById(roasterTobeDelete);
    verify(roasterRepository, times(1)).deleteById(Long.valueOf(roasterTobeDelete));
  }

  @Test
  void test_nonexistent_roaster_id_should_throw_exception() {

    when(roasterRepository.findById(3L)).thenReturn(Optional.empty());

    RoasterNotFoundException expectedException =
        assertThrows(RoasterNotFoundException.class, () -> roasterService.findById("3"));
    assertEquals("Could not find Roaster: 3", expectedException.getMessage());
  }
}
