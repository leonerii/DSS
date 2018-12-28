/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;

import data_access.*;

/**
 *
 * @author leonardo
 */
public class BuildMovil {
	private ClienteDAO clientes;
	private UtilizadorDAO utilizadores;
	private PacoteDAO pacotes;
	private ComponenteDAO componentes;
	private PedidoDAO pedidos;

	public BuildMovil (){
		this.clientes = new ClienteDAO();
		this.utilizadores = new UtilizadorDAO();
		this.pacotes = new PacoteDAO();
		this.componentes = new ComponenteDAO();
		this.pedidos = new PedidoDAO();
	}

	public void addComponente(int id, String nome, float valor, int peso, int[] dep, int[] inc) {
		Componente comp = new Componente();
		comp.setId(id);
		comp.setNome(nome);
		comp.setPeso(peso);
		comp.setValor(valor);

		for(int i : dep)
			comp.addDependente(this.componentes.get_lite(i));

		for(int i : inc)
			comp.addIncompativel(this.componentes.get_lite(i));

		this.componentes.put(id, comp);
	}

	public void addPacote(int id, float valor, String nome, int[] comp) {
		throw new UnsupportedOperationException();
	}

	public void addCliente(String nome, String nif) {
		throw new UnsupportedOperationException();
	}

	public boolean removeCliente(String nif) {
		throw new UnsupportedOperationException();
	}

	public void addUilizador(String nome, String tipo, String user, String pass) {
		throw new UnsupportedOperationException();
	}

	public boolean removeUtilizador(String user) {
		throw new UnsupportedOperationException();
	}

	public Pedido getPedido(int id) {
		throw new UnsupportedOperationException();
	}

	public Pacote getPacote(int id) {
		throw new UnsupportedOperationException();
	}

	public Cliente getCliente(String nif) {
		throw new UnsupportedOperationException();
	}

	public Utilizador getUtilizador(String user) {
		throw new UnsupportedOperationException();
	}

	public Componente getComponente(int id) {
		throw new UnsupportedOperationException();
	}

	public void addComponente(int id, Pedido order) {
		throw new UnsupportedOperationException();
	}

	public void addComponente(int id, Pacote pack) {
		throw new UnsupportedOperationException();
	}

	public boolean login(String user, String pass) {
		throw new UnsupportedOperationException();
	}

	public void addPacote(Pedido order, int pack) {
		throw new UnsupportedOperationException();
	}
}