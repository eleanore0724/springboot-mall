package com.AAA.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.AAA.constant.ProductCategory;
import com.AAA.model.Product;

public class ProductRowMapper implements RowMapper<Product>{
	//泛型要轉換成 Product 這個 Java class
	
	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		//可以從這個 resultSet 的參數裡面，去取得資料庫查詢出來的數據，然後將他去儲存在 product 這個變數裡面
		Product product=new Product();
		product.setProductId(rs.getInt("product_id"));
		product.setProductName(rs.getString("product_name"));
		
		String categoryStr=rs.getString("category");
		ProductCategory category=ProductCategory.valueOf(categoryStr);
		product.setCategory(category);
		
		//改寫一行 product.setCategory(ProductCategory.valueOf(rs.getString("category")));
		//product.setCategory(rs.getString("category"));
		
		product.setImageUrl(rs.getString("image_url"));
		product.setPrice(rs.getInt("price"));
		product.setStock(rs.getInt("stock"));
		product.setDescription(rs.getString("description"));
		product.setCreatedDate(rs.getTimestamp("created_date"));
		product.setLastModifiedDate(rs.getTimestamp("last_modified_date"));
		return product;
	}
	
}
