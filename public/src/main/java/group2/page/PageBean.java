package group2.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author: KongKongBaby
 * @create: 2020-06-10 14:21
 * @description: 分页
 **/

@ToString
@Getter
@Setter
public class PageBean<T> implements Serializable {
    private Integer currentPage; // 当前页（从1开始）
    private Integer pageSize; // 每页多少个
    private Integer totalPages; // 总页数
    private List<T> data;


    public PageBean(Integer startPage, Integer pageSize, Integer totalPages, T data) {
        this.currentPage = startPage;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.data = (List<T>) data;
    }
}