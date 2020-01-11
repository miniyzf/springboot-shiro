package com.yzf.example.entity;

/**
 * Page
 *
 * @author Administrator
 * @since 2020-01-06 17:02:00
 */
public class Page {
    private Integer page;
    private Integer offset;
    private Integer limit;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = limit * (page - 1);
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}