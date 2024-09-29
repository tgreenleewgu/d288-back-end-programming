package com.d288.bookings;

import com.d288.bookings.dao.*;
import com.d288.bookings.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BootStrapData implements CommandLineRunner {

    @Autowired
    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }




    @Override
    public void run(String... args) throws Exception {
        if (customerRepository.count() == 1) {

            Customer customer2 = new Customer();
            customer2.setAddress("101 Apple Tree Avenue");
            customer2.setFirstName("Lily");
            customer2.setLastName("Roberts");
            customer2.setPhone("987-654-3210");
            customer2.setPostal_code("98765");
            customer2.setDivision(divisionRepository.getReferenceById(2L));
            customerRepository.save(customer2);

            Customer customer3 = new Customer();
            customer3.setAddress("404 Blueberry Street");
            customer3.setFirstName("James");
            customer3.setLastName("Smith");
            customer3.setPhone("321-654-9870");
            customer3.setPostal_code("65432");
            customer3.setDivision(divisionRepository.getReferenceById(10L));
            customerRepository.save(customer3);

            Customer customer4 = new Customer();
            customer4.setAddress("909 Sunset Boulevard");
            customer4.setFirstName("Emily");
            customer4.setLastName("Johnson");
            customer4.setPhone("123-789-4560");
            customer4.setPostal_code("12378");
            customer4.setDivision(divisionRepository.getReferenceById(18L));
            customerRepository.save(customer4);

            Customer customer5 = new Customer();
            customer5.setAddress("57 Hilltop Drive");
            customer5.setFirstName("Michael");
            customer5.setLastName("Clark");
            customer5.setPhone("456-789-1230");
            customer5.setPostal_code("45612");
            customer5.setDivision(divisionRepository.getReferenceById(2L));
            customerRepository.save(customer5);

            Customer customer6 = new Customer();
            customer6.setAddress("302 Ocean Breeze Lane");
            customer6.setFirstName("Patrick");
            customer6.setLastName("Star");
            customer6.setPhone("789-123-4567");
            customer6.setPostal_code("78945");
            customer6.setDivision(divisionRepository.getReferenceById(2L));
            customerRepository.save(customer6);

        }
    }
}