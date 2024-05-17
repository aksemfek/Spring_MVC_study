package kr.bit.beans;

public class Page {

	private int min;
	private int max;
	private int prePage;
	private int nextPage;
	private int pageCnt;
	private int currentPage;

	public Page(int contentCnt, int currentPage, int contentPageCnt, int pa) {

		this.currentPage = currentPage;
		pageCnt = contentCnt / contentPageCnt;
		// 533/10=53 
		if (contentCnt % contentPageCnt > 0) {
			pageCnt++;
		}
		min = ((currentPage - 1) / contentPageCnt) * contentPageCnt + 1;
		max = min + pa - 1;

		if (max > pageCnt) {
			max = pageCnt;
		}

		prePage = min - 1;
		nextPage = max + 1;

		if (nextPage > pageCnt) {
			nextPage = pageCnt;
		}
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getPageCnt() {
		return pageCnt;
	}

	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

}
