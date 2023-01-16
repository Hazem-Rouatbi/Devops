package com.example.testApp.models;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAddress;
    private String text;
    @OneToOne
    private User user;

    public Long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Long idAdress) {
        this.idAddress = idAdress;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address() {
    }

    public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Address(Long idAddress, String text, User user) {
        this.idAddress = idAddress;
        this.text = text;
        this.user = user;
    }
}
