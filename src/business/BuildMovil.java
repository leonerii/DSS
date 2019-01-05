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
		Componente comp = this.componentes.get(id);
		order.addComponente(comp);
		this.componentes.put(id, comp);
	}

	public void addComponente(int id, Pacote pack) {
		Componente comp = this.componentes.get(id);
		pack.addComponente(comp);
	}

	public void addPacote(Pedido order, int pack) {
		Pacote p = this.pacotes.get(pack);
		order.addPacote(p);
	}

	public boolean addCliente(String nome, String nif, String morada) {
		Cliente user = new Cliente();
		user.setMorada(morada);
		user.setNif(nif);
		user.setNome(nome);
		
		if(this.clientes.containsKey(nif))
			return false;
		
		this.clientes.put(nif, user);
		return true;
	}

	public boolean addUilizador(String nome, String tipo, String user, String pass) {
		Utilizador u = new Utilizador(nome, tipo, user, pass);

		if(this.utilizadores.containsKey(user))
			return false;

		this.utilizadores.put(user, u);
		return true;
	}

	public void removeCliente(String nif) {
		this.clientes.remove(nif);
	}

	public void removeUtilizador(String user) {
		this.utilizadores.remove(user);
	}

	public void removePedido(int id) {
		this.pedidos.remove(id);
	}

	public void removePacote(int id) {
		this.pacotes.remove(id);
	}

	public Pedido getPedido(int id) {
		return this.pedidos.get(id);
	}

	public Pacote getPacote(int id) {
		return this.pacotes.get(id);
	}

	public Cliente getCliente(String nif) {
		return this.clientes.get(nif);
	}

	public Utilizador getUtilizador(String user) {
		return this.utilizadores.get(user);
	}

	public Componente getComponente(int id) {
		return this.componentes.get(id);
	}

	public boolean login(String user, String pass) {
		Utilizador u = this.utilizadores.get(user);

		if(u != null)
			return u.getPass().equals(pass);
		
		return false;
	}

	public Pacote createPacote() {
		return new Pacote(++this.num_pacotes);
	}

	public Componente createComponente() {
		return new Componente(++this.num_componentes);
	}

	public Pedido createPedido() {
		return new Pedido(++this.num_pedidos);
	}

	public void savePacote(Pacote p){
		this.pacotes.put(p.getId(), p);
	}

	public void savePedido(Pedido p){
		this.pedidos.put(p.getId(), p);
	}

	public void saveComponente(Componente c){
		this.componentes.put(c.getId(), c);
	}

	public void saveCliente(Cliente c){
		this.clientes.put(c.getNif(), c);
	}
	
	public ArrayList<Componente> getComponentes(){
		return this.componentes.values();
	}
}