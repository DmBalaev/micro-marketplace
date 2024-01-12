package dm.bl.catalogservice;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProductMapper implements Function<Product, ProductDto > {
    @Override
    public ProductDto apply(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }
}
