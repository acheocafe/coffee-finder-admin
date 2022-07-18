package br.com.coffeefinder.controller;

import br.com.coffeefinder.domain.dto.RoasterDto;
import br.com.coffeefinder.service.RoasterServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** RoasterController * */
@RestController
@RequestMapping(value = {"/api/v1/roasters"})
public class RoasterController {

  private final RoasterServiceImpl roasterService;

  public RoasterController(RoasterServiceImpl roasterService) {
    this.roasterService = roasterService;
  }

  @GetMapping
  public ResponseEntity<Page<RoasterDto>> findPageable(Pageable pageable) {
    return new ResponseEntity<>(roasterService.findPageable(pageable), HttpStatus.OK);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<RoasterDto> findById(@PathVariable String id) {
    return new ResponseEntity<>(roasterService.findById(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<RoasterDto> saveRoaster(@RequestBody final RoasterDto roasterModel) {

    return new ResponseEntity<>(roasterService.save(roasterModel), HttpStatus.OK);
  }

  @PutMapping
  public RoasterDto updateRoaster(
      @RequestBody final RoasterDto roasterModel) {
    return roasterService.updateRoaster(roasterModel);
  }
}
