package ec.edu.ups.market.persistence.crud;

import ec.edu.ups.market.persistence.entity.Producto;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    @Query(value="SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true )
    List<Producto> findCategoria(int idCategoria);

    // Query Methods
    List<Producto> findByIdCategoria(int idCategoria);
    List<Producto> findByIdCategoriaOOrderByNombreAsc(int idCategoria);
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
