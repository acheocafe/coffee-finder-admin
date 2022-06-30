package br.com.coffeefinder.controller;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.coffeefinder.model.Roaster;
import br.com.coffeefinder.service.RoasterService;

/**
 * RoasterController
 */
@RestController
@RequestMapping(value={"/v1/api/roasters"})
public class RoasterController {

  private final RoasterService roasterService;

  public RoasterController(RoasterService roasterService) {
    this.roasterService= roasterService;
  }

  @GetMapping
  public ResponseEntity<List<Roaster>> findAll() {
    return new ResponseEntity<>(roasterService.findAll(), HttpStatus.OK);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Roaster> findById(@PathVariable Long id) {
    return new ResponseEntity<>(roasterService.findById(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Roaster> saveRoaster(@RequestBody final Roaster roasterModel) {
    return new ResponseEntity<>(roasterService.save(roasterModel), HttpStatus.OK);
  }

  @PutMapping
  public Roaster updateRoaster(@PathVariable final String id, @RequestBody final Roaster roasterModel)
      throws NotFoundException {
    return roasterService.updateRoaster(roasterModel, id);

  }

}
