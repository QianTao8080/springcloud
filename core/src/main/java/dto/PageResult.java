package dto;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {

    private int pageNo;
    private int pageSize;
    private int pageNum;
    private int total;
    private PageParam param;
    private List<T> result;
}
