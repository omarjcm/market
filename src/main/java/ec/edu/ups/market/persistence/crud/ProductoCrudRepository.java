package ec.edu.ups.market.persistence.crud;

import ec.edu.ups.market.persistence.entity.Producto;

import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

}
