package dm.bl.catalogservice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SortField {
    ID("id"),
    NAME("name");

    private final String databaseFieldName;
}
