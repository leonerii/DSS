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
public class Componente {
	private String nome;
	private float valor;
	private int peso;
	private int id;
        private int quantidade;
	private ArrayList<Componente> dependencias;
	private ArrayList<Componente> incompativeis;


	public Componente() {
		this.dependencias = new ArrayList<>();
		this.incompativeis = new ArrayList<>();
	}

	public Componente(String nome, float valor, int peso, int id, ArrayList<Componente> dependencias, ArrayList<Componente> incompativeis) {
		this.nome = nome;
		this.valor = valor;
		this.peso = peso;
		this.id = id;
		this.dependencias = dependencias;
		this.incompativeis = incompativeis;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

        public int getQuantidade() {
            return this.quantidade;
        }

        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }

	public float getValor() {
		return this.valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getPeso() {
		return this.peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Componente> getDependencias() {
		return this.dependencias;
	}

	public void setDependencias(ArrayList<Componente> dependencias) {
		this.dependencias = dependencias;
	}

	public ArrayList<Componente> getIncompativeis() {
		return this.incompativeis;
	}

	public void setIncompativeis(ArrayList<Componente> incompativeis) {
		this.incompativeis = incompativeis;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Componente)) {
			return false;
		}
		Componente componente = (Componente) o;
		return Objects.equals(nome, componente.nome) && valor == componente.valor && peso == componente.peso && id == componente.id && Objects.equals(dependencias, componente.dependencias) && Objects.equals(incompativeis, componente.incompativeis);
	}

	@Override
	public String toString() {
		return "{" +
			" nome='" + getNome() + "'" +
			", valor='" + getValor() + "'" +
			", peso='" + getPeso() + "'" +
			", id='" + getId() + "'" +
			", dependencias='" + getDependencias() + "'" +
			", incompativeis='" + getIncompativeis() + "'" +
			"}";
	}

	public void addDependente(Componente comp) {
		this.dependencias.add(comp);
	}

	public void addIncompativel(Componente comp) {
		this.incompativeis.add(comp);
	}

	public void removeDependente(Componente comp){
		this.dependencias.remove(comp);
	}

	public void removeIncompativel(Componente comp){
		this.incompativeis.remove(comp);
	}
}
