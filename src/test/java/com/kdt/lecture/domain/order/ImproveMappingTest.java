package com.kdt.lecture.domain.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@SpringBootTest
class ImproveMappingTest {

    @Autowired
    private EntityManagerFactory emf;

    @Test
    void inheritance_test() {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        Food food = new Food();
        food.setPrice(1000);
        food.setStockQuantity(100);
        food.setChef("백종원");
        entityManager.persist(food);

        transaction.commit();
    }
}
