package com.example.testApp.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.testApp.models.Address;
import com.example.testApp.repository.AddressRepo;
import com.example.testApp.service.AddressService;
@Service
public class AddrServiceImpl implements AddressService{
	AddressRepo addrRepo;
	
	public AddrServiceImpl(AddressRepo addrRepo) {
		super();
		this.addrRepo = addrRepo;
	}

	@Override
	public Address getAddr(Long idAdd) {return addrRepo.findById(idAdd).get();}

	@Override
	public Address createAddr(Address addr) {return addrRepo.save(addr);}

	@Override
	public Address updateAddr(Address addr) {return addrRepo.save(addr);}

	@Override
	public List<Address> getAllAddr() {return addrRepo.findAll();}

	@Override
	public void deleteSpec(Long idAddr) {addrRepo.deleteById(idAddr);}

}
