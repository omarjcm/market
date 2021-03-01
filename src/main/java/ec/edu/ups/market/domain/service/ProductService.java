package ec.edu.ups.market.domain.service;

import ec.edu.ups.market.domain.Product;
import ec.edu.ups.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategoryId(int categoryId) {
        return productRepository.getByCategoryId(categoryId);
    }

    public Optional<List<Product>> getScarseProducts(int quantity) {
        return productRepository.getScarseProducts(quantity);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public boolean delete(int productId) {
        // Primera forma
        return getProduct( productId ).map( product -> {
            productRepository.delete( productId );
            return true;
        } ).orElse( false );
        // Segunda forma
//        if (getProduct(productId).isPresent()) {
//            productRepository.delete(productId);
//            return true;
//        } else {
//            return false;
//        }
    }
}
