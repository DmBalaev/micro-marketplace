package dm.bl.catalogservice;

public record ProductDto(
        String id,
        String name,
        String description,
        double price
) {
}
