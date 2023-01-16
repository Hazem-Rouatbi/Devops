package com.example.testApp.service;

import java.util.List;

import com.example.testApp.models.Address;

public interface AddressService {
	public Address getAddr(Long idAdd);
    public Address createAddr(Address addr); //this is not needed
    public Address updateAddr(Address addr);
    public List<Address> getAllAddr();
    public void deleteSpec(Long idAddr);

}
