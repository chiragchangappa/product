package com.abc.testapp.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.abc.testapp.entity.Product;
public interface ProductRepository
extends JpaRepository<Product, Long> {

}
