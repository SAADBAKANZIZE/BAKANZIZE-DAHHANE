package com.example.backend.controller;

import com.example.backend.beans.Pharmacie;
import com.example.backend.beans.PharmacieGarde;
import com.example.backend.repository.PharmacieGardeRepository;
import com.example.backend.repository.PharmacieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/pharmacieGarde")
public class PharmacieGardeController {
    @Autowired
    PharmacieGardeRepository pharmacieGardeRepository;

    @PostMapping("/addPharmacieGarde")
    public String add(@RequestBody PharmacieGarde pharmacieGarde){
        pharmacieGardeRepository.save(pharmacieGarde);
        return "New pharmacie en garde";
    }

    @RequestMapping(value = "/{ph_id}/{garde_id}/{date}", method=RequestMethod.POST)
    public void addPharmacie(@PathVariable(required = true) String ph_id, @PathVariable(required = true) String garde_id, @PathVariable(required = true) String date) throws ParseException {
        pharmacieGardeRepository.inserPharmacieGarde(Integer.parseInt(ph_id), Integer.parseInt(garde_id), date);

    }
}
