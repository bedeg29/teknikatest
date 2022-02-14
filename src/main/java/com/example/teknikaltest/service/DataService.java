package com.example.teknikaltest.service;

import com.example.teknikaltest.model.Data;
import com.example.teknikaltest.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DataService  {

    @Autowired
    private DataRepository repo;

    public List<Data>getDataByPrice(){
        return repo.getDataByHandphone();
    }

    public List<Data>getDataByPriceGanjil(){
        return  repo.getDataByHandphoneGanjil();
    }

    public List<Data> listAll() {

        return repo.findAll();
    }

    public void save(Data data) {
        repo.save(data);
    }

    public Data get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }



}
