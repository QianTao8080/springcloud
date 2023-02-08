package dto;

import lombok.Data;

@Data
public class PageParam {

    private int pageNo;
    private int pageSize;
    private String name;
}
