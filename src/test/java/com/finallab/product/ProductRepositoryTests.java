//package com.finallab.account.AccountUnitTests;
//
//
//import com.finallab.product.repository.ProductRepository;
//import org.apache.commons.math.stat.descriptive.summary.Product;
//import org.hamcrest.Matchers;
//import static org.junit.Assert.assertThat;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Optional;
//
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class ProductRepositoryTests {
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Test
//    public void testFindById(){
//        Product testProduct = new Product();
//        entityManager.persistAndFlush(testProduct);
//
//        Product foundProduct = productRepository.findProductById(1L);
//
//        assertThat(foundProduct.getId(), Matchers.is(Matchers.equalTo(Long.valueOf(1))));
//    }
//
//}
