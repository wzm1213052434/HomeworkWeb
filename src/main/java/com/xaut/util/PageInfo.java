package com.xaut.util;

import java.util.List;

/**
 * 分页信息
 * @param <T>
 */
public class PageInfo<T> {
    private List<T> list; //你页面需要展示的集合
    private Integer totalNum; //显示的总记录数
    private Integer totalPage; //总页数
    private Integer currentPage; //当前页
    private Integer pageSize; //每页显示的数目
    //显示的页码 ：[start,start+pageNo-1]
    private Integer start; //下标页码开始处
    private Integer pageNo; //下标页码的大小
    
    /**
     * 分页信息构造函数
     */
    public PageInfo(Integer totalNum, Integer currentPage, Integer pageSize, Integer pageNo) {
        this.totalNum = totalNum;
        this.currentPage = currentPage;
        this.pageSize = pageSize;

        //计算总页数
        if (totalNum % this.pageSize == 0) {
            this.totalPage = totalNum / this.pageSize;
        }
        else {
            this.totalPage = (totalNum / this.pageSize) + 1;
        }

        //计算页码
        if (this.totalPage <= pageNo) { //总页数 <= 页码位数5,总页数全显示:[1,...,totalPage]
            this.pageNo = this.totalPage;
            this.start = 1;
        }
        else { //总页数6 > 页码位数5,总页数分开显示
        	this.start = ((this.currentPage - 1)/pageNo)*5 + 1;
        	
        	if(this.totalPage%pageNo !=0 && this.currentPage>this.totalPage-this.totalPage%pageNo) { //最后一页,且页码未满：[11,12,13],[11,12,13,14]
        		this.pageNo = this.totalPage % pageNo;
        	}
        	else { //每次展示5页:[1,2,3,4,5] [6,7,8,9,10]
        		this.pageNo = pageNo;
        	}
        }
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
}