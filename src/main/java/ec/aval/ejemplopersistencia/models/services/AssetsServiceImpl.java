package ec.aval.ejemplopersistencia.models.services;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.aval.ejemplopersistencia.models.dao.IAssetsDao;
import ec.aval.ejemplopersistencia.models.entity.Assets;

@Service
public class AssetsServiceImpl implements IAssetsService {

	@Autowired
	private IAssetsDao assetsDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Assets> findAll() {
		return (List<Assets>) assetsDao.findAll();
	}

	@Override
	@Transactional
	public void save(Assets assets) {
		assetsDao.save(assets);
	}

	@Override
	@Transactional(readOnly = true)
	public Assets findById(BigInteger tagId) {
		return assetsDao.findById(tagId).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Assets assets) {
		assetsDao.delete(assets);
		
	}
}
