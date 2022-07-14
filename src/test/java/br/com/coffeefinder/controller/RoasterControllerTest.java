package br.com.coffeefinder.controller;

import static br.com.coffeefinder.controller.helper.RoasterControllerHelper.*;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.coffeefinder.exception.RoasterNotFoundException;
import br.com.coffeefinder.service.RoasterServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
    final var expected = mockRoastersListExpected();
    when(roasterServiceImpl.findAll()).thenReturn(expected);
    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/v1/api/roasters").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)))
        .andExpect(jsonPath("$[1].name").value("Roaster2"));
  }

  @Test
  void get_all_records_should_be_not_found() throws Exception {
    when(roasterServiceImpl.findAll()).thenThrow(new RoasterNotFoundException());
    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/v1/api/roasters").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }

  @Test
  void find_by_id_success() throws Exception {
    when(roasterServiceImpl.findById("2")).thenReturn(mockExpectedRoaster());

    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/v1/api/roasters/2")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").exists());
  }

  @Test
  void find_by_id_should_be_not_found() throws Exception {

    when(roasterServiceImpl.findById("2")).thenThrow(new RoasterNotFoundException());
    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/v1/api/roasters/2")
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
            MockMvcRequestBuilders.post("/v1/api/roasters/")
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
            MockMvcRequestBuilders.put("/v1/api/roasters/")
                .content(asJsonString(mockInputRoaster))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(mockExpectedRoaster.getId()));
  }
}
