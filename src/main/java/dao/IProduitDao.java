package dao;

import entities.Produit;
import java.util.List;

public interface IProduitDao {
    Produit save(Produit p);
    Produit findById(Long id);
    List<Produit> findAll();
    void delete(Long id);
}
