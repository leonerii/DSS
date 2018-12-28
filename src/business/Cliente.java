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
public class Cliente {
	private String nome;
	private String nif;
	private String morada;
	private ArrayList<Pedido> pedidos;

	
	public Cliente() {
		this.pedidos = new ArrayList<>();

	}

	public Cliente(String nome, String nif, String morada, ArrayList<Pedido> pedidos) {
		this.nome = nome;
		this.nif = nif;
		this.morada = morada;
		this.pedidos = pedidos;
	}

	public void addPedido(Pedido order){
		this.pedidos.add(order);
	}

	public void removePedido(Pedido order){
		this.pedidos.remove(order);
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNif() {
		return this.nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getMorada() {
		return this.morada;
	}

	public void setMorada(String morada) {
		this.morada = morada;
	}

	public ArrayList<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Cliente)) {
			return false;
		}
		Cliente cliente = (Cliente) o;
		return Objects.equals(nome, cliente.nome) && Objects.equals(nif, cliente.nif) && Objects.equals(morada, cliente.morada) && Objects.equals(pedidos, cliente.pedidos);
	}

	@Override
	public String toString() {
		return "{" +
			" nome='" + getNome() + "'" +
			", nif='" + getNif() + "'" +
			", morada='" + getMorada() + "'" +
			", pedidos='" + getPedidos() + "'" +
			"}";
	}
	
}