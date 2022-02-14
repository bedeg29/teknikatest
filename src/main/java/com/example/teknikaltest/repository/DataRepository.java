package com.example.teknikaltest.repository;

import com.example.teknikaltest.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DataRepository extends JpaRepository<Data,Long> {

@Query (
        value = "SELECT * FROM DATA WHERE handphone %2=0",
        nativeQuery = true
)
    List<Data>getDataByHandphone();
@Query(
        value = "SELECT * FROM DATA WHERE handphone %2<>0",
        nativeQuery = true
)
    List<Data>getDataByHandphoneGanjil();
}
