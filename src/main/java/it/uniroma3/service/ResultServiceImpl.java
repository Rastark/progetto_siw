package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.dao.ResultDao;
import it.uniroma3.model.Result;

@Service
public class ResultServiceImpl implements ResultService {

	@Autowired
	private ResultDao resultDao;
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.ResultService#getResult(java.lang.Long)
	 */
	@Override
	public Result getResult(Long id) {
		return this.resultDao.getResult(id);
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.ResultService#listResult()
	 */
	@Override
	public List<Result> listResult() {
		return this.resultDao.getAllResults();
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.ResultService#insertResult(it.uniroma3.model.Result)
	 */
	@Override
	@Transactional
	public void insertResult(Result result) {
		this.resultDao.insertResult(result);
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.ResultService#deleteResult(java.lang.Long)
	 */
	@Override
	@Transactional
	public void deleteResult(Long id) {
		this.resultDao.deleteResult(id);
	}
}
