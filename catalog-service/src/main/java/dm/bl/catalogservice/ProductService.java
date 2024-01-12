package dm.bl.catalogservice;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Transactional(readOnly = true)
    public PageResponse<Product> findAll(Pageable pageable){
        Page<Product> page = productRepository.findAll(pageable);
        return new PageResponse<>(
                page.getContent(),
                page.getTotalElements(),
                pageable.getPageNumber(),
                page.getTotalPages()
        );
    }

    public ProductDto createProduct(CreateProductResponse response){
        Product newProduct = Product.builder()
                .name(response.name())
                .description(response.description())
                .price(response.price())
                .build();

        return productMapper.apply(productRepository.save(newProduct));
    }
}