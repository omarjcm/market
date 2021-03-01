package ec.edu.ups.market.persistence;

import ec.edu.ups.market.domain.Product;
import ec.edu.ups.market.domain.repository.ProductRepository;
import ec.edu.ups.market.persistence.crud.ProductoCrudRepository;
import ec.edu.ups.market.persistence.entity.Producto;
import ec.edu.ups.market.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    private ProductoCrudRepository productoCrudRepository;
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategoryId(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOOrderByNombreAsc(categoryId);
        return Optional.of( mapper.toProducts(productos) );
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto( product );
        return mapper.toProduct(productoCrudRepository.save( producto ));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById( productId );
    }
}