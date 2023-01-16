package com.example.testApp.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.testApp.models.Specilization;
import com.example.testApp.repository.SpecRepo;
import com.example.testApp.service.SpecService;
@Service
public class SpecServiceImpl implements SpecService {

	SpecRepo specRepo;
	
	public SpecServiceImpl(SpecRepo specRepo) {
		super();
		this.specRepo = specRepo;
	}

	@Override
	public Specilization getSpec(Long idSpec) {return specRepo.findById(idSpec).get();}

	@Override
	public Specilization createSpec(Specilization spec) {return specRepo.save(spec);}

	@Override
	public Specilization updateSpec(Specilization spec) {return specRepo.save(spec);}
	@Override
	public void deleteSpec(Long idSpec) {specRepo.deleteById(idSpec);}
	@Override
	public List<Specilization> getAllSpec() {return specRepo.findAll();}

}
