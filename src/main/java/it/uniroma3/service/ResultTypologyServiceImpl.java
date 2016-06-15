package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.dao.ResultTypologyDao;
import it.uniroma3.model.ResultTypology;

@Service
public class ResultTypologyServiceImpl implements ResultTypologyService {

	@Autowired
	private ResultTypologyDao resultTypologyDao;
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.ResultTypologyService#getResultTypology(java.lang.Long)
	 */
	@Override
	public ResultTypology getResultTypology(Long id) {
		return this.resultTypologyDao.getResultTypology(id);
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.ResultTypologyService#listResultTypology()
	 */
	@Override
	public List<ResultTypology> listResultTypology() {
		return this.resultTypologyDao.getAllResultTypologies();
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.ResultTypologyService#insertResultTypology(it.uniroma3.model.ResultTypology)
	 */
	@Override
	@Transactional
	public void insertResultTypology(ResultTypology resultTypology) {
		this.resultTypologyDao.insertResultTypology(resultTypology);
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.ResultTypologyService#deleteResultTypology(java.lang.Long)
	 */
	@Override
	@Transactional
	public void deleteResultTypology(Long id) {
		this.resultTypologyDao.deleteResultTypology(id);
	}
}
