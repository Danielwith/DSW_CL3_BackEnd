package com.cibertec.cl3.service;

import com.cibertec.cl3.entity.Ubigeo;
import com.cibertec.cl3.repository.UbigeoRepository;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.hibernate.sql.ast.tree.expression.Distinct;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UbigeoService {
    @Autowired
    private UbigeoRepository ubigeoRepository;
    public List<Ubigeo> listarUbigeo(){
        return ubigeoRepository.findAll();
    }
}
