package br.com.coffeefinder.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.coffeefinder.mockhelpers.RoasterControllerHelper;
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
  void getAllRecords_success() throws Exception {
    final var expected = RoasterControllerHelper.mockRoastersListExpected();
    when(roasterServiceImpl.findAll()).thenReturn(expected);
    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/v1/api/roasters").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)))
        .andExpect(jsonPath("$[1].name").value("Roaster2"));
  }
}
