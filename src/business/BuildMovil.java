/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

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

	public void addComponente(int id) {
		throw new UnsupportedOperationException();
	}

	public void addPacote(int id) {
		throw new UnsupportedOperationException();
	}

	public Pedido makePedido() {
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

	public Pacote makePacote() {
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