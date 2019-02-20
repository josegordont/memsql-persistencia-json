package ec.aval.ejemplopersistencia.models.services;

import java.math.BigInteger;
import java.util.List;

import ec.aval.ejemplopersistencia.models.entity.Assets;

public interface IAssetsService {
	
	public List<Assets> findAll();
	
	public void save(Assets assets);
	
	public Assets findById(BigInteger tagId);
	
	public void delete(Assets assets);

}
