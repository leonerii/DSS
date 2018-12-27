/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Objects;

/**
 *
 * @author leonardo
 */
public class Utilizador {
	private String nome;
	private String tipo;
	private String user;
	private String pass;


	public Utilizador() {
	}

	public Utilizador(String nome, String tipo, String user, String pass) {
		this.nome = nome;
		this.tipo = tipo;
		this.user = user;
		this.pass = pass;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Utilizador nome(String nome) {
		this.nome = nome;
		return this;
	}

	public Utilizador tipo(String tipo) {
		this.tipo = tipo;
		return this;
	}

	public Utilizador user(String user) {
		this.user = user;
		return this;
	}

	public Utilizador pass(String pass) {
		this.pass = pass;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Utilizador)) {
			return false;
		}
		Utilizador utilizador = (Utilizador) o;
		return Objects.equals(nome, utilizador.nome) && Objects.equals(tipo, utilizador.tipo) && Objects.equals(user, utilizador.user) && Objects.equals(pass, utilizador.pass);
	}

	@Override
	public String toString() {
		return "{" +
			" nome='" + getNome() + "'" +
			", tipo='" + getTipo() + "'" +
			", user='" + getUser() + "'" +
			", pass='" + getPass() + "'" +
			"}";
	}
}