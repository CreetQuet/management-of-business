package Controller;

import View.MainScreen;

public class TableSalesController {

	private SaleSearchController viewSearch;
	private MainScreen view;
	private String fromDate, toDate;
	private int folio;

	public TableSalesController(MainScreen v, SaleSearchController sc) {
		view = v;
		viewSearch = sc;
	}
	

}
