import entity.Product;
import entity.Sale;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        EntityManager entityManager = Persistence.createEntityManagerFactory("test")
                .createEntityManager();

        entityManager.getTransaction().begin();

        // - CascadeType.PERSIST - example

//        Sale sale = new Sale();
//        sale.setDateTime(LocalDateTime.now());
//
//        Product product = new Product();
//        product.setName("testProduct");
//        product.setPrice(BigDecimal.TEN);
//        product.setQuantity(5);
//
//        product.getSales().add(sale);
//        sale.setProduct(product);
//
//        entityManager.persist(product);

// - CascadeType.DELETE - example

//        Product found = entityManager.find(Product.class, 1L);
//        entityManager.remove(found);

        entityManager.getTransaction().commit();

    }
}
