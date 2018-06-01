package _repositories;

import _entities.item.Item;

import java.util.Collection;
import java.util.List;

/**
 * Repositório de itens. Extende o repositório genérico
 * oferecendo assim um CRUD básico.
 * 
 * @author Emanuel Joivo
 *
 */
public interface ItemRepository extends Repository<Item> {

    List<Item> getItens();
}
	
