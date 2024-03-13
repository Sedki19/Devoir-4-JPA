package com.sedki.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Pc implements Serializable {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id_pc;
	
	private String nom_pc;
	private float prixpc;
	private String specs;
	
	
	public int getId_pc() {
		return id_pc;
	}
	public void setId_pc(int id_pc) {
		this.id_pc = id_pc;
	}
	public String getNom_pc() {
		return nom_pc;
	}
	public void setNom_pc(String nom_pc) {
		this.nom_pc = nom_pc;
	}
	public float getPrixpc() {
		return prixpc;
	}
	public void setPrixpc(float prixpc) {
		this.prixpc = prixpc;
	}
	public String getSpecs() {
		return specs;
	}
	public void setSpecs(String specs) {
		this.specs = specs;
	}
	
	
}
