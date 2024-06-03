package priv.backend.entity;

import lombok.Data;

@Data
public class PageBean {
    private int pageNum ;
    private int pageSize ;
    private Boolean isItPaginated ;

    // 默认分页参数
    public PageBean() {
        this.pageNum = 1;
        this.pageSize = 10;
        // 默认分页
        this.isItPaginated = true;
    }

    // 自定义分页参数
    public PageBean(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        // 默认分页
        this.isItPaginated = true;
    }

    // 分页抉择
    public PageBean(Boolean isItPaginated) {
        this.pageNum = 1;
        this.pageSize = 10;
        this.isItPaginated = isItPaginated != null ? isItPaginated : true;
    }

    // 自定义分页参数
    public PageBean(int pageNum, int pageSize, Boolean isItPaginated) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.isItPaginated = isItPaginated != null ? isItPaginated : true;

    }
}
