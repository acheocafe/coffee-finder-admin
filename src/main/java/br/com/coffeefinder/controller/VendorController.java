package br.com.coffeefinder.controller;

import br.com.coffeefinder.domain.dto.VendorDto;
import br.com.coffeefinder.service.VendorServiceImpl;
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

/** VendorController * */
@RestController
@RequestMapping(value = {"/api/v1/vendors"})
public class VendorController {

  private final VendorServiceImpl vendorService;

  public VendorController(VendorServiceImpl vendorService) {
    this.vendorService = vendorService;
  }

  @GetMapping
  public ResponseEntity<Page<VendorDto>> findPageable(Pageable pageable) {
    return new ResponseEntity<>(vendorService.findPageable(pageable), HttpStatus.OK);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<VendorDto> findById(@PathVariable String id) {
    return new ResponseEntity<>(vendorService.findById(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<VendorDto> saveVendor(@RequestBody final VendorDto vendorModel) {

    return new ResponseEntity<>(vendorService.save(vendorModel), HttpStatus.OK);
  }

  @PutMapping
  public VendorDto updateVendor(
      @RequestBody final VendorDto vendorModel) {
    return vendorService.updateVendor(vendorModel);
  }
}
