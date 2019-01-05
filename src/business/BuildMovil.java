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
    private int num_pedidos;
    private int num_pacotes;
    private int num_componentes;

	public BuildMovil (){
            this.clientes = new ClienteDAO();
		this.utilizadores = new UtilizadorDAO();
		this.pacotes = new PacoteDAO();
		this.componentes = new ComponenteDAO();
		this.pedidos = new PedidoDAO();
                this.num_pedidos = 0;
                this.num_componentes = 0;
            this.num_pacotes = 0;
	}

	public void addComponente(int id, Pedido order) {
		throw new UnsupportedOperationException();
	}

	public void addComponente(int id, Pacote pack) {
		throw new UnsupportedOperationException();
	}

	public void addPacote(Pedido order, int pack) {
		throw new UnsupportedOperationException();
	}

	public void addCliente(String nome, String nif, String morada) {
		throw new UnsupportedOperationException();
	}

	public void addUilizador(String nome, String tipo, String user, String pass) {
		throw new UnsupportedOperationException();
	}

	public void removeCliente(String nif) {
		throw new UnsupportedOperationException();
	}

	public void removeUtilizador(String user) {
		throw new UnsupportedOperationException();
	}

	public void removePedido(int id) {
		throw new UnsupportedOperationException();
	}

	public void removePacote(int id) {
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

	public boolean login(String user, String pass) {
		throw new UnsupportedOperationException();
	}

	public Pacote createPacote() {
		throw new UnsupportedOperationException();
	}

	public Componente createComponente() {
		throw new UnsupportedOperationException();
	}

	public Pedido createPedido() {
		throw new UnsupportedOperationException();
	}
}