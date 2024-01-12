package dm.bl.catalogservice;

import java.util.List;

public record PageResponse<T>(
        List<T> element,
        long found,
        int pageNumber,
        int totalPages
) {
}
