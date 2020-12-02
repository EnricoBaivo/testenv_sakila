package studio.baivo.testenv_sakila.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SALES_BY_FILM_CATEGORY database table.
 * 
 */
@Entity
@Table(name="SALES_BY_FILM_CATEGORY")
@NamedQuery(name="SalesByFilmCategory.findAll", query="SELECT s FROM SalesByFilmCategory s")
public class SalesByFilmCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	private String category;

	@Column(name="TOTAL_SALES")
	private BigDecimal totalSales;

	public SalesByFilmCategory() {
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigDecimal getTotalSales() {
		return this.totalSales;
	}

	public void setTotalSales(BigDecimal totalSales) {
		this.totalSales = totalSales;
	}

}