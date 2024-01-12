package dm.bl.catalogservice;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("product")
public class Product{
        @Id
        String id;
        String name;
        String description;
        double price;

}
