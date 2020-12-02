package studio.baivo.testenv_sakila.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SALES_BY_STORE database table.
 * 
 */
@Entity
@Table(name="SALES_BY_STORE")
@NamedQuery(name="SalesByStore.findAll", query="SELECT s FROM SalesByStore s")
public class SalesByStore implements Serializable {
	private static final long serialVersionUID = 1L;

	private String manager;

	private String store;

	@Column(name="STORE_ID")
	private BigDecimal storeId;

	@Column(name="TOTAL_SALES")
	private BigDecimal totalSales;

	public SalesByStore() {
	}

	public String getManager() {
		return this.manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getStore() {
		return this.store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public BigDecimal getStoreId() {
		return this.storeId;
	}

	public void setStoreId(BigDecimal storeId) {
		this.storeId = storeId;
	}

	public BigDecimal getTotalSales() {
		return this.totalSales;
	}

	public void setTotalSales(BigDecimal totalSales) {
		this.totalSales = totalSales;
	}

}