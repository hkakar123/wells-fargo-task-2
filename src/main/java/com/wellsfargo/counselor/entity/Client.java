package com.yourproject.entities;

import javax.persistence.*;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "advisor_id")
    private Advisor advisor;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private Portfolio portfolio;

    public Client() {}

    public Client(String name, String email, String phoneNumber, Advisor advisor, Portfolio portfolio) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.advisor = advisor;
        this.portfolio = portfolio;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public Advisor getAdvisor() { return advisor; }
    public Portfolio getPortfolio() { return portfolio; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setAdvisor(Advisor advisor) { this.advisor = advisor; }
    public void setPortfolio(Portfolio portfolio) { this.portfolio = portfolio; }
}
