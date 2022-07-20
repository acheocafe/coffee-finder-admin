package br.com.coffeefinder.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.coffeefinder.domain.entity.VendorEntity;
import br.com.coffeefinder.domain.mapper.VendorMapper;
import br.com.coffeefinder.exception.VendorNotFoundException;
import br.com.coffeefinder.repository.VendorRepository;
import br.com.coffeefinder.service.helper.VendorServiceHelper;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

/** TestVendorService */
@ExtendWith(MockitoExtension.class)
class VendorServiceTest {

  @InjectMocks VendorServiceImpl vendorService;

  @Mock VendorRepository vendorRepository;

  @Spy
  VendorMapper vendorMapper = Mappers.getMapper(VendorMapper.class);

  @Test
  void test_find_by_id_success() {
    var expected = VendorServiceHelper.mockExpectedVendor();
    when(vendorRepository.findById(2L))
        .thenReturn(VendorServiceHelper.mockVendorRepositoryReturn());
    var actual = vendorService.findById("2");
    assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
  }

  @Test
  void test_find_all_success() {

    var expected = VendorServiceHelper.mockExpectedFindAll();

    when(vendorRepository.findAll()).thenReturn(VendorServiceHelper.mockFindAllRespository());
    var actual = vendorService.findAll();
    assertThat(actual).usingRecursiveFieldByFieldElementComparator().isEqualTo(expected);
  }

  @Test
  void test_save_vendor_success() {
    when(vendorRepository.save(any(VendorEntity.class)))
        .thenReturn(VendorServiceHelper.mockSaveVendorRepository());
    vendorService.save(VendorServiceHelper.mockExpectedSaveVendor());
    verify(vendorRepository, times(1)).save(any());
  }

  @Test
  void test_update_vendor_success() {

    ArgumentCaptor<VendorEntity> vendorArgumentCaptor =
        ArgumentCaptor.forClass(VendorEntity.class);
    var inputVendorDto = VendorServiceHelper.mockInputVendorDto();
    var actual = vendorService.updateVendor(inputVendorDto);

    verify(vendorRepository, times(1)).save(vendorArgumentCaptor.capture());

    var updatedVendor = vendorArgumentCaptor.getValue();
    var expectedVendor = VendorServiceHelper.mockExpectedVendor();

    assertEquals(expectedVendor.idToLong(), updatedVendor.getId());
  }

  @Test
  // TODO: implement
  void test_delete_vendor_success() {
    String vendorTobeDelete = "2";
    vendorService.deleteVendorById(vendorTobeDelete);
    verify(vendorRepository, times(1)).deleteById(Long.valueOf(vendorTobeDelete));
  }

  @Test
  void test_nonexistent_vendor_id_should_throw_exception() {

    when(vendorRepository.findById(3L)).thenReturn(Optional.empty());

    VendorNotFoundException expectedException =
        assertThrows(VendorNotFoundException.class, () -> vendorService.findById("3"));
    assertEquals("Could not find Vendor: 3", expectedException.getMessage());
  }
}
