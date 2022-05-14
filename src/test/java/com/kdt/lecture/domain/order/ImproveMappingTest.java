package com.kdt.lecture.domain.order;

import com.kdt.lecture.domain.parent.Parent;
import com.kdt.lecture.domain.parent.ParentId;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.time.LocalDateTime;

@SpringBootTest
@Slf4j
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

    @Test
    void mapped_super_class_test() {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        Order order = new Order();
        order.setOrderStatus(OrderStatus.OPENED);
        order.setMemo("---");
        order.setOrderDateTime(LocalDateTime.now());

        //
        order.setCreatedBy("yongcheol");
        order.setCreatedAt(LocalDateTime.now());
        entityManager.persist(order);
        transaction.commit();
    }

    @Test
    void id_test() {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        Parent parent = new Parent();
        parent.setId1("id1");
        parent.setId2("id2");

        entityManager.persist(parent);

        transaction.commit();
        entityManager.clear();
        Parent parent1 = entityManager.find(Parent.class, new ParentId("id2", "id1"));
        log.info("{} {}", parent1.getId1(), parent1.getId2());
    }
}
