# TP 4 : Hibernate et Persistance des Données

Ce projet implémente le mapping objet-relationnel (ORM) avec **Hibernate 6** et **JPA 3**, en conformité avec le cours d'Architecture Logicielle et Microservices.

## 🎯 Objectifs
- Configurer un environnement Hibernate via `hibernate.cfg.xml`.
- Utiliser les annotations JPA standards (`@Entity`, `@Table`, `@Id`, `@GeneratedValue`, `@Column`).
- Mettre en œuvre le pattern DAO avec Hibernate `SessionFactory`, `Session`, `Transaction`, `persist()`, `createQuery()`, `remove()`.
- Gérer le cycle de vie des entités (Transient, Persistent, Detached, Removed).
- Assurer les tests unitaires avec JUnit 5 et une base H2 en mémoire.

## 📁 Structure du Projet
```
Tp4-cours2/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── entities/
│   │   │   │   └── Produit.java
│   │   │   ├── dao/
│   │   │   │   ├── IProduitDao.java
│   │   │   │   └── ProduitDaoImpl.java
│   │   │   ├── util/
│   │   │   │   └── HibernateUtil.java
│   │   │   └── presentation/
│   │   │       └── PresentationHibernate.java
│   │   └── resources/
│   │       └── hibernate.cfg.xml
│   └── test/
│       └── java/
│           └── dao/
│               └── ProduitDaoTest.java
```

## 🚀 Exécution

### Exécuter les tests unitaires
```bash
mvn clean test
```

### Exécuter l'application
```bash
mvn compile exec:java -Dexec.mainClass="presentation.PresentationHibernate"
```
