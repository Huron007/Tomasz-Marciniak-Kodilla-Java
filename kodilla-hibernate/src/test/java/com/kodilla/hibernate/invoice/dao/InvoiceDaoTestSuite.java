package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave(){
        //Given
        Product water = new Product("Water");
        Product tomatoes = new Product("Tomatoes");
        Product meat = new Product("Meat");

        Item item1 = new Item(water, new BigDecimal(1), 100, new BigDecimal(100));
        Item item2 = new Item(tomatoes, new BigDecimal(3), 50, new BigDecimal(150));
        Item item3 = new Item(meat, new BigDecimal(20), 10, new BigDecimal(200));

        Invoice invoice = new Invoice("Invoice 1");
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);

        //When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        //Then
        Assertions.assertNotEquals(0, invoiceId);

        //Cleanup
        try {
            invoiceDao.deleteById(invoiceId);
        } catch (Exception e){

        }

    }
}
