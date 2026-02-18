package com.videostore.videostore.domain.common;

import java.util.List;

public class PagedResult<T> {

    private final List<T> content;
    private final int page;
    private final int size;
    private final long totalElements;

    public PagedResult(List<T> content, int page, int size, long totalElements) {
        this.content = content;
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
    }

    public List<T> getContent() {
        return content;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public int getTotalPages() {
        return (int) Math.ceil((double) totalElements / size);
    }

    public boolean hasNext() {
        return page < getTotalPages() - 1;
    }

    public boolean hasPrevious() {
        return page > 0;
    }
}