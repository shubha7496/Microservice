package com.history.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.history.entity.History;
import com.history.repository.HistoryRepository;
import com.history.service.HistoryService;


@Service
public class HistoryServiceImpl implements HistoryService {
	
	@Autowired
	private HistoryRepository  historyRepository;
	
	    @Override
	    public History saveHistory(History History) {
	        return historyRepository.save(History);
	    }

	    @Override
	    public History getHistoryById(Long patientId) {
	        return historyRepository.findById(patientId).get();
	    }

	    @Override
	    public List<History> getAll() {
	        return historyRepository.findAll();
	    }


}
