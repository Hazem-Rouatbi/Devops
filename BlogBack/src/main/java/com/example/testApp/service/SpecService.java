package com.example.testApp.service;

import java.util.List;

import com.example.testApp.models.Specilization;


public interface SpecService {
    public Specilization getSpec(Long idSpec);
    public Specilization createSpec(Specilization spec); //this is not needed
    public Specilization updateSpec(Specilization spec);
    public List<Specilization> getAllSpec();
    public void deleteSpec(Long idSpec);

}
