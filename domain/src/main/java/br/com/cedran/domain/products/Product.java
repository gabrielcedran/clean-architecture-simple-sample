package br.com.cedran.domain.products;

import br.com.cedran.domain.common.IEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product implements IEntity<UUID> {

    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column
    private String name;

    @Column(precision=10, scale=2)
    private Double price;

    private Product() {

    }

    public Product(UUID id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
