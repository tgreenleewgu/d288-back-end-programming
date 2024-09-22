package entities;


//import jakarta.validation.constraints.*;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import org.hibernate.annotations.UpdateTimestamp;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;



@Getter
@Setter
@Entity
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    //@NotBlank(message = "First name is mandatory")
    @NonNull
    @Column(name = "customer_first_name")
    private String firstName;

    //@NotBlank(message = "Last name is mandatory")
    @Column(name = "customer_last_name")
    private String lastName;

    //@NotBlank(message = "Address is mandatory")
    @Column(name = "address")
    private String address;

    //@NotBlank(message = "Postal code is mandatory")
    //@Size(min = 5, max = 10, message = "Postal code must be between 5 and 10 characters")
    @Column(name = "postal_code")
    private String postal_code;

    //@NotBlank(message = "Phone number is mandatory")
    @Column(name = "phone")
    private String phone;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "division_id",nullable = false)
    private Division division;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Cart> carts;

    public void add(Cart cart) {
        if (cart != null) {
            if (carts == null) {
                carts = new HashSet<>();
            }
            carts.add(cart);
            cart.setCustomer(this);
        }
    }


    public Customer(String firstName, String lastName, String address, String postal_code, String phone, Long division_id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postal_code = postal_code;
        this.phone = phone;
        this.division = setDivision(division_id);
    }

    public Division setDivision(Long id) {

        Division division = new Division();
        division.setId(id);

        return division;
    }
}

