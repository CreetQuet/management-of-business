package Model.Report;

public class ReportModel {

	private String categoryName;
	private float saleTotal;
	
	public ReportModel(String cN, float sT) {
		categoryName = cN;
		saleTotal = sT;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public float getSaleTotal() {
		return saleTotal;
	}

	public void setSaleTotal(float saleTotal) {
		this.saleTotal = saleTotal;
	}
}
