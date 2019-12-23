package com.softtek.academia.service;

import java.util.List;

import com.softtek.academia.entity.State;

public interface StateService {
	public List<State> getAllStates();
	public State getStatesById(Long id);
	public boolean saveSatet(State state);
	public boolean deleteStateById(Long id);
}
