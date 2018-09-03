package entity;

import java.io.Serializable;
import java.util.List;

public class PageResult implements Serializable {
	
	private long total;
	
	private List row;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List getRow() {
		return row;
	}

	public void setRow(List row) {
		this.row = row;
	}

	public PageResult(long total, List row) {
		super();
		this.total = total;
		this.row = row;
	}
	
	
	
	
 
}
