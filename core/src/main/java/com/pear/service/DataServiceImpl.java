package com.pear.service;

import com.pear.model.ListSample;
import com.pear.repository.DataRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import java.util.List;

@Service
public class DataServiceImpl implements DataService {

	private static final AntPathMatcher MATHER = new AntPathMatcher();
	private DataRespository dataRespository;

	@Autowired
	public DataServiceImpl(DataRespository dataRespository) {
		this.dataRespository = dataRespository;
	}

	@Override
	public List<ListSample> getListSample() {
		return dataRespository.getSampleList();
	}


}
