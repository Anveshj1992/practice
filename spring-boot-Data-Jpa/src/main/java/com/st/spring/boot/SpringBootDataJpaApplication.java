package com.st.spring.boot;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.st.spring.boot.entity.Products;
import com.st.spring.boot.repo.ProductsRepository;

@SpringBootApplication
public class SpringBootDataJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootDataJpaApplication.class, args);
		ProductsRepository repo = context.getBean(ProductsRepository.class);
		List<Products> listofProducts = repo.findAll();
		//System.out.println("List of Orders:" +listofProducts);
		System.out.println("Product By code: "+repo.searchProductByProductCode("ELTNCS"));
		System.out.println("check stock existence of product By name: "+repo.existsProductByProductName("IPHONE_13"));
		System.out.println("count stock of products By name: "+repo.countProductByProductName("US_POLO"));
		System.out.println("product By count ordered: "+repo.readProductByQuantityCount(1));
		repo.updateProductCodeById("GARMENTS",1);
		System.out.println("Updated Successfully");
	}

}
