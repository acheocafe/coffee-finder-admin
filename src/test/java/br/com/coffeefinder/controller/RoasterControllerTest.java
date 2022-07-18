package br.com.coffeefinder.controller;

import static br.com.coffeefinder.controller.helper.RoasterControllerHelper.asJsonString;
import static br.com.coffeefinder.controller.helper.RoasterControllerHelper.mockExpectedRoaster;
import static br.com.coffeefinder.controller.helper.RoasterControllerHelper.mockInputRoaster;
import static br.com.coffeefinder.controller.helper.RoasterControllerHelper.mockPageRoaster;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.coffeefinder.domain.dto.RoasterDto;
import br.com.coffeefinder.exception.RoasterNotFoundException;
import br.com.coffeefinder.service.RoasterServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/** RoasterControllerTest */
@WebMvcTest(controllers = RoasterController.class)
class RoasterControllerTest {

  @Autowired MockMvc mockMvc;

  @MockBean RoasterServiceImpl roasterServiceImpl;

  @Test
  void get_all_records_success() throws Exception {
    Page<RoasterDto> expected = mockPageRoaster();
    when(roasterServiceImpl.findPageable(ArgumentMatchers.isA(Pageable.class)))
        .thenReturn(expected);
    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/api/v1/roasters?page=1&size=20")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.content", hasSize(2)))
        .andExpect(jsonPath("$.content[1].name").value("Roaster2"));
  }

  @Test
  void get_all_records_should_be_not_found() throws Exception {
    when(roasterServiceImpl.findPageable(ArgumentMatchers.isA(Pageable.class))).thenThrow(new RoasterNotFoundException());
    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/api/v1/roasters?page=1&size=40").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }

  @Test
  void find_by_id_success() throws Exception {
    when(roasterServiceImpl.findById("2")).thenReturn(mockExpectedRoaster());

    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/api/v1/roasters/2")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").exists());
  }

  @Test
  void find_by_id_should_be_not_found() throws Exception {

    when(roasterServiceImpl.findById("2")).thenThrow(new RoasterNotFoundException());
    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/api/v1/roasters/2")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }

  @Test
  void save_roaster_successs() throws Exception {

    var mockExpectedRoaster = mockExpectedRoaster();
    var mockInputRoaster = mockInputRoaster();
    when(roasterServiceImpl.save(mockInputRoaster)).thenReturn(mockExpectedRoaster);
    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/api/v1/roasters/")
                .content(asJsonString(mockInputRoaster))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void update_roaster_success() throws Exception {

    var mockExpectedRoaster = mockExpectedRoaster();
    var mockInputRoaster = mockInputRoaster();

    when(roasterServiceImpl.updateRoaster(mockInputRoaster)).thenReturn(mockExpectedRoaster);
    mockMvc
        .perform(
            MockMvcRequestBuilders.put("/api/v1/roasters/")
                .content(asJsonString(mockInputRoaster))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(mockExpectedRoaster.getId()));
  }
}
