package com.example.testApp.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "specilization")
public class Specilization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSpec;
    private String spec;
   @ManyToMany(mappedBy = "spec",cascade = CascadeType.ALL)
    private List<User> user;

    public Long getIdSpec() {
        return idSpec;
    }

    public Specilization(Long idSpec, String spec, List<User> user) {
		super();
		this.idSpec = idSpec;
		this.spec = spec;
		this.user = user;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public void setIdSpec(Long idSpec) {
        this.idSpec = idSpec;
    }


    public Specilization() {
    }


	public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
