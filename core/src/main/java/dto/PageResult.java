package dto;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {

    private PageParam param;
    private long pageNum;
    private long total;
    private List<T> result;
}
