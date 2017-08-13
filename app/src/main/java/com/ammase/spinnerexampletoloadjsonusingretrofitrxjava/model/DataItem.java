package com.ammase.spinnerexampletoloadjsonusingretrofitrxjava.model;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class DataItem{

	@SerializedName("nama")
	private String nama;

	@SerializedName("id_prov")
	private int idProv;

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setIdProv(int idProv){
		this.idProv = idProv;
	}

	public int getIdProv(){
		return idProv;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"nama = '" + nama + '\'' + 
			",id_prov = '" + idProv + '\'' + 
			"}";
		}
}