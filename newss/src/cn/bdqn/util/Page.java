package cn.bdqn.util;

public class Page {
	private Integer totalCount;//�ܼ�¼��
	private Integer pageSize=1;//ҳ��С
	private Integer pageCount;//��ҳ��
	private Integer pageIndex;//��ǰҳ��
	public Page(Integer totalCount, Integer pageSize, Integer pageCount,
			Integer pageIndex) {
		super();
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.pageIndex = pageIndex;
	}
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Page [totalCount=" + totalCount + ", pageSize=" + pageSize
				+ ", pageCount=" + pageCount + ", pageIndex=" + pageIndex + "]";
	}
	public Integer getTotalCount() {
		
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		if (totalCount>0) {
			this.totalCount = totalCount;
			pageCount=(totalCount%pageSize==0)?totalCount/pageSize:totalCount/pageSize+1;
		}
		
		
		this.totalCount = totalCount;
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
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	
}
