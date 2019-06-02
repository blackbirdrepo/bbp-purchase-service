package com.bbp.purchaseservice.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;

@EqualsAndHashCode(of = {"email", "firstName", "lastName"}, callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "\"purchase\"")
public class Purchase extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_purchase")
    @SequenceGenerator(allocationSize = 1, sequenceName = "seq_purchase", name = "seq_purchase")
    private Long id;

    private int quantity;

    @Column(name = "inventory_id")
    private long inventory;

    @Column(name = "user_id")
    private long user;

    public static Purchase create(int quantity, long inventory, long user) {
        return new Purchase()
                .setQuantity(quantity)
                .setInventory(inventory)
                .setUser(user);
    }
}
