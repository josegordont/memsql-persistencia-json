package ec.aval.ejemplopersistencia.models.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="assets")
public class Assets implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tag_id")
	private BigInteger tagId;
	
	private String name;
	
	private String description;

	@Convert(converter = HashMapConverter.class)
    private Map<String, Object> properties;

	public BigInteger getTagId() {
		return tagId;
	}

	public void setTagId(BigInteger tagId) {
		this.tagId = tagId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

}
