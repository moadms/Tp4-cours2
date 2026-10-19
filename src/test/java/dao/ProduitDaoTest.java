package dao;

import entities.Produit;
import org.junit.jupiter.api.*;
import util.HibernateUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProduitDaoTest {

    private static IProduitDao produitDao;

    @BeforeAll
    static void setUp() {
        produitDao = new ProduitDaoImpl();
    }

    @AfterAll
    static void tearDown() {
        HibernateUtil.shutdown();
    }

    @Test
    @Order(1)
    void testSaveProduit() {
        Produit p = new Produit("Clavier Mécanique", 1200.0, 15);
        Produit saved = produitDao.save(p);
        assertNotNull(saved.getId(), "L'identifiant généré ne doit pas être null");
        assertEquals("Clavier Mécanique", saved.getDesignation());
    }

    @Test
    @Order(2)
    void testFindById() {
        Produit p = new Produit("Casque Sony WH-1000XM5", 3800.0, 5);
        produitDao.save(p);
        Produit found = produitDao.findById(p.getId());
        assertNotNull(found);
        assertEquals(3800.0, found.getPrix());
    }

    @Test
    @Order(3)
    void testFindAll() {
        List<Produit> list = produitDao.findAll();
        assertNotNull(list);
        assertTrue(list.size() >= 2);
    }

    @Test
    @Order(4)
    void testDelete() {
        Produit p = new Produit("Webcam 1080p", 450.0, 20);
        produitDao.save(p);
        Long id = p.getId();
        assertNotNull(produitDao.findById(id));

        produitDao.delete(id);
        assertNull(produitDao.findById(id));
    }
}
