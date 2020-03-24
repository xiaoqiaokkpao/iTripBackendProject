package cn.ekgc.itrip.pojo.entity;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer curPage;        // 当前页码
	private Integer total;          // 总记录数
	private Integer pageSize;       // 每页行数
	private Integer pageCount;      // 页面总数
	private Integer beginPos;       // 结果集中数据的起始位置
	private List<T> rows;           // List集合

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getTotal() {
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

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getBeginPos() {
		return beginPos;
	}

	public void setBeginPos(Integer beginPos) {
		this.beginPos = beginPos;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
