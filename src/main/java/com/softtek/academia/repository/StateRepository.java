package com.softtek.academia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.softtek.academia.entity.State;
import com.softtek.academia.entity.User;

@Repository
public interface StateRepository extends CrudRepository<State, Long>{

}
