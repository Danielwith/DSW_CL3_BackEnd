package com.cibertec.cl3.repository;

import com.cibertec.cl3.entity.Ubigeo;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;
public interface UbigeoRepository extends MongoRepository<Ubigeo, String>{

}
