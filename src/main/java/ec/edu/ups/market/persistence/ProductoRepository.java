package ec.edu.ups.market.persistence;

import ec.edu.ups.market.persistence.crud.ProductoCrudRepository;
import ec.edu.ups.market.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria) {
        return productoCrudRepository.findByIdCategoria( idCategoria );
    }
}