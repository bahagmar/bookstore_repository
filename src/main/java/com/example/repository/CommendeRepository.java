package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entites.Commande;

public interface CommendeRepository extends  JpaRepository<Commande, Integer>{

}
