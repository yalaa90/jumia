package org.jumia.exercise.dto;

/**
 * Request Parameters Class
 */
public class FilterParametersDTO {
    private final String code;
    private final String state;
    private final int pageNum;
    private final int pageSize;

    public FilterParametersDTO(String code, String state, int pageNum, int pageSize) {
        this.code = code;
        this.state = state;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public String getCode() {
        return code;
    }

    public String getState() {
        return state;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }
}
