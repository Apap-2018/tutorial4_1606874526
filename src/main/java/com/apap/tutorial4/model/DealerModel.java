package com.apap.tutorial4.model;

import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * DealerModel
 */

@Entity
@Table(name = "dealer")
public class DealerModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "alamat", nullable = false)
	public String alamat;
	
	@NotNull
	@Size(max = 13)
	@Column(name = "no_telp", nullable = false)
	public String noTelp;
	
	@OneToMany(mappedBy = "dealer", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<CarModel> listCar;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getNoTelp() {
		return noTelp;
	}

	public void setNoTelp(String noTelp) {
		this.noTelp = noTelp;
	}

	public List<CarModel> getListCar() {
		for (int i = 1; i < listCar.size(); i++) { 
            int j = i - 1;
            while (j >= 0 && listCar.get(j).getPrice() < listCar.get(i).getPrice()) { 	
            	listCar.set(j+1, listCar.get(j));
                j--; 
            } 
            listCar.set(j+1, listCar.get(i)); 
        }
		return listCar;
	}

	public void setListCar(List<CarModel> listCar) {
		this.listCar = listCar;
	}
	
	
}
