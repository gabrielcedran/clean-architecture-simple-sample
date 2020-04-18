package br.com.cedran.domain.customers;

import br.com.cedran.domain.common.IEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "customers")
public class Customer implements IEntity<UUID> {

    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column
    private String name;

    private Customer() {

    }

    public Customer(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
