package ec.aval.ejemplopersistencia.models.dao;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import ec.aval.ejemplopersistencia.models.entity.Assets;

public interface IAssetsDao extends CrudRepository<Assets, BigInteger> {

}
