package presentation;

import dao.IProduitDao;
import dao.ProduitDaoImpl;
import entities.Produit;
import util.HibernateUtil;

import java.util.List;

public class PresentationHibernate {
    public static void main(String[] args) {
        System.out.println("=== TP 4 : Hibernate et Persistance des Données ===");
        IProduitDao produitDao = new ProduitDaoImpl();

        // 1. Ajouter des produits
        Produit p1 = new Produit("Ordinateur Dell XPS 15", 14500.0, 10);
        Produit p2 = new Produit("Souris Logitech MX Master 3", 850.0, 35);
        Produit p3 = new Produit("Écran 4K Dell UltraSharp", 5200.0, 8);

        System.out.println("\n--- Sauvegarde des produits ---");
        produitDao.save(p1);
        produitDao.save(p2);
        produitDao.save(p3);
        System.out.println("Produits sauvegardés avec succès ! IDs : " + p1.getId() + ", " + p2.getId() + ", " + p3.getId());

        // 2. Consulter tous les produits
        System.out.println("\n--- Liste de tous les produits ---");
        List<Produit> produits = produitDao.findAll();
        produits.forEach(p -> System.out.println("-> " + p));

        // 3. Recherche par ID
        System.out.println("\n--- Recherche du produit ID " + p1.getId() + " ---");
        Produit found = produitDao.findById(p1.getId());
        System.out.println("Trouvé : " + found);

        // 4. Suppression
        System.out.println("\n--- Suppression du produit ID " + p2.getId() + " ---");
        produitDao.delete(p2.getId());
        System.out.println("Produits restants : " + produitDao.findAll().size());

        HibernateUtil.shutdown();
        System.out.println("\n=== Fin de l'exécution avec succès ===");
    }
}
