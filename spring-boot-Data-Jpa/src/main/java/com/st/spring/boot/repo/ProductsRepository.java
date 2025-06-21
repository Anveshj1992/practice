package com.st.spring.boot.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.st.spring.boot.entity.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products,Integer>{
	
	//public Products getProductByProductId(Integer productId);
	//public Products readProductByProductId(Integer productId);
	//public Products findProductByProductId(Integer productId);
	
	//public Products queryProductByProductCode(String productCode);
	//public Products streamProductByProductCode(String productCode);
	public Products searchProductByProductCode(String productCode);
	
	public boolean existsProductByProductName(String productName);
	
	public Integer countProductByProductName(String productName);
	
	//@Query("Select p from Products p where p.quantity= :qcount")
	//public Products readProductByQuantityCount(@Param("qcount") Integer count);
	
	//@Query("Select p from Products p where p.quantity= :count")
	//public Products readProductByQuantityCount(Integer count);
	
	//@Query("Select p from Products p where p.quantity= ?1")
	//public Products readProductByQuantityCount(Integer count);
	
	@Query(value="select * from products p where p.quantity=?", nativeQuery=true)
	public Products readProductByQuantityCount(Integer count);
	
    @Modifying
    @Transactional
    @Query("UPDATE Products p SET p.productCode= :productCode WHERE p.productId= :productId")
	public void updateProductCodeById(@Param("productCode") String productCode,
			@Param("productId") Integer productId);
	
	

}
