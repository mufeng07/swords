package com.mufeng.blog.util;

import java.io.Serializable;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/29 18:17
 */
public class ReqPage implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 页数
     */
    private int page=1;
    /**
     * 每页显示条数
     */
    private int pageSize=10;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
