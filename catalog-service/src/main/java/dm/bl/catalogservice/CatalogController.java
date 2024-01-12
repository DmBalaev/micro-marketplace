package dm.bl.catalogservice;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/catalog")
@AllArgsConstructor
public class CatalogController {
    private final ProductService service;

    @GetMapping
    public PageResponse<Product> findAllByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int sizePerPage,
            @RequestParam(defaultValue = "ID") SortField sortField,
            @RequestParam(defaultValue = "DESC") Sort.Direction sortDirection

            ){
        Pageable pageable = PageRequest.of(page,sizePerPage, sortDirection, sortField.getDatabaseFieldName());
        return service.findAll(pageable);
    }


    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@RequestBody CreateProductResponse createProductResponse){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createProduct(createProductResponse));
    }
}
