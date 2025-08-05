package com.yourproject.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate createdDate;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Security> securities;

    public Portfolio() {}

    public Portfolio(LocalDate createdDate, Client client, List<Security> securities) {
        this.createdDate = createdDate;
        this.client = client;
        this.securities = securities;
    }

    public Long getId() { return id; }
    public LocalDate getCreatedDate() { return createdDate; }
    public Client getClient() { return client; }
    public List<Security> getSecurities() { return securities; }

    public void setCreatedDate(LocalDate createdDate) { this.createdDate = createdDate; }
    public void setClient(Client client) { this.client = client; }
    public void setSecurities(List<Security> securities) { this.securities = securities; }
}
