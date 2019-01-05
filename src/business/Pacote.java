/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author leonardo
 */
public class Pacote {
	private int id;
	private float valor;
	private String nome;
	private ArrayList<Componente> componentes;


	public Pacote(int id) {
		this.id = id;
		this.componentes = new ArrayList<>();
	}

	public Pacote() {
		this.componentes = new ArrayList<>();
	}

	public Pacote(int id, float valor, String nome, ArrayList<Componente> componentes) {
		this.id = id;
		this.valor = valor;
		this.nome = nome;
		this.componentes = componentes;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getValor() {
		return this.valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Componente> getComponentes() {
		return this.componentes;
	}

	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Pacote)) {
			return false;
		}
		Pacote pacote = (Pacote) o;
		return id == pacote.id && valor == pacote.valor && Objects.equals(nome, pacote.nome) && Objects.equals(componentes, pacote.componentes);
	}

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", valor='" + getValor() + "'" +
			", nome='" + getNome() + "'" +
			", componentes='" + getComponentes() + "'" +
			"}";
	}

	public void addComponente(Componente comp){
		for(Componente c : this.componentes)
			if(comp.getIncompativeis().contains(c))
				return;

		this.componentes.add(comp);
	}

	public void removeComponente(Componente comp){
		this.componentes.remove(comp);
	}
}