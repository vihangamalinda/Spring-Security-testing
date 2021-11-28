package com.example.springsecurity.partner.service;

import com.example.springsecurity.partner.entity.Partner;
import com.example.springsecurity.partner.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerServiceImpl  implements PartnerService{
    @Autowired
    private PartnerRepository partnerRepository;

    @Override
    public List<Partner> getAll() {
        List<Partner> list = partnerRepository.findAll();
        return list;
    }
}
