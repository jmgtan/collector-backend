package org.humanitarian.collector.auth.models;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_ANALYST = "ANALYST";
    public static final String ROLE_COLLECTOR = "COLLECTOR";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
