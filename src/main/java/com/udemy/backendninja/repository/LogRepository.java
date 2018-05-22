package com.udemy.backendninja.repository;

import com.udemy.backendninja.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
// segundo paso
@Repository("logRepository")
public interface LogRepository extends JpaRepository<Log, Serializable> {

}
