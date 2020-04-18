package br.com.cedran.domain.employees;

import br.com.cedran.domain.common.IEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "employees")
public class Employee implements IEntity<UUID> {

    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column
    private String name;

    private Employee() {

    }

    public Employee(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee(String name) {
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
