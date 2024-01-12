package dm.bl.catalogservice;

public record CreateProductResponse(
        String name,
        String description,
        double price
) {
}
