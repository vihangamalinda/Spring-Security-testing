package com.example.springsecurity.partner.controller;

import com.example.springsecurity.partner.entity.Partner;
import com.example.springsecurity.partner.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/partner")
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    @GetMapping("/all")
    public List<Partner> getAll(){
        List<Partner> list = partnerService.getAll();
        return list;
    }
}
