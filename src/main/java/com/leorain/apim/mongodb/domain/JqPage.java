package com.leorain.apim.mongodb.domain;

import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/1/3 0003.
 */
public class JqPage<T> implements Serializable, Iterable<T>{

    private Integer page = 1;//当前页
    private Integer total = 1;//总页数
    private Integer pageSize = 20;//每页显示多少
    private Integer records;//总记录数
    private List<T> rows;//记录

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal() {
        total = getRecords()%getPageSize()==0? getRecords()/getPageSize() : getRecords()/getPageSize() + 1;
        if (total == 0) {
            total = 1;
        }

        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getRecords() {
        return records;
    }

    public void setRecords(Integer records) {
        this.records = records;
        setTotal(getTotal());
    }

    public List<T> getRows() {
        return rows;
    }

    public Integer getFromIndex() {
        if (getPage() == null) {
            setPage(1);
        }

        return (getPage()-1) * getPageSize();
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>) (rows == null ? Collections.emptyList()
                .iterator() : rows.iterator());
    }

}
