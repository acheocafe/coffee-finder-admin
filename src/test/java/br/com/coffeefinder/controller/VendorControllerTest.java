package br.com.coffeefinder.controller;

import static br.com.coffeefinder.controller.helper.VendorControllerHelper.asJsonString;
import static br.com.coffeefinder.controller.helper.VendorControllerHelper.mockExpectedVendor;
import static br.com.coffeefinder.controller.helper.VendorControllerHelper.mockInputVendor;
import static br.com.coffeefinder.controller.helper.VendorControllerHelper.mockPageVendor;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.coffeefinder.domain.dto.VendorDto;
import br.com.coffeefinder.exception.VendorNotFoundException;
import br.com.coffeefinder.service.VendorServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/** VendorControllerTest */
@WebMvcTest(controllers = VendorController.class,excludeAutoConfiguration = {
    SecurityAutoConfiguration.class})
class VendorControllerTest {

  @Autowired MockMvc mockMvc;

  @MockBean VendorServiceImpl vendorServiceImpl;

  @Test
  void get_all_records_success() throws Exception {
    Page<VendorDto> expected = mockPageVendor();
    when(vendorServiceImpl.findPageable(ArgumentMatchers.isA(Pageable.class)))
        .thenReturn(expected);
    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/api/v1/vendors?page=1&size=20")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.content", hasSize(2)))
        .andExpect(jsonPath("$.content[1].name").value("Vendor2"))
        .andExpect(jsonPath("$.content[1].address[0].addressName").value("rua teste,8"));

  }

  @Test
  void get_all_records_should_be_not_found() throws Exception {
    when(vendorServiceImpl.findPageable(ArgumentMatchers.isA(Pageable.class))).thenThrow(new VendorNotFoundException());
    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/api/v1/vendors?page=1&size=40").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }

  @Test
  void find_by_id_success() throws Exception {
    when(vendorServiceImpl.findById("2")).thenReturn(mockExpectedVendor());

    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/api/v1/vendors/2")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").exists());
  }

  @Test
  void find_by_id_should_be_not_found() throws Exception {

    when(vendorServiceImpl.findById("2")).thenThrow(new VendorNotFoundException());
    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/api/v1/vendors/2")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }

  @Test
  void save_vendor_successs() throws Exception {

    var mockExpectedVendor = mockExpectedVendor();
    var mockInputVendor = mockInputVendor();
    when(vendorServiceImpl.save(mockInputVendor)).thenReturn(mockExpectedVendor);
    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/api/v1/vendors/")
                .content(asJsonString(mockInputVendor))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void update_vendor_success() throws Exception {

    var mockExpectedVendor = mockExpectedVendor();
    var mockInputVendor = mockInputVendor();

    when(vendorServiceImpl.updateVendor(mockInputVendor)).thenReturn(mockExpectedVendor);
    mockMvc
        .perform(
            MockMvcRequestBuilders.put("/api/v1/vendors/")
                .content(asJsonString(mockInputVendor))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(mockExpectedVendor.getId()));
  }
}
