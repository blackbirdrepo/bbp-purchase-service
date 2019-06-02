package com.bbp.purchaseservice.domain;

import com.bbp.purchaseservice.domain.enums.CityEnum;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(of = {"name"}, callSuper = true)
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Accessors(chain = true)
@Entity
@Table(name = "\"address\"")
public class Address extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_address")
    @SequenceGenerator(allocationSize = 1, sequenceName = "seq_address", name = "seq_address")
    private Long id;

    private CityEnum city;

    private String street;

    private String streetNumber;

    private String apartment;

    public static Address create(CityEnum city, String street, String streetNumber, String apartment) {
        return new Address()
                .setCity(city)
                .setStreet(street)
                .setStreetNumber(streetNumber)
                .setApartment(apartment);
    }
}