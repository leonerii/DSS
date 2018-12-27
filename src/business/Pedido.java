/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author leonardo
 */
public class Pedido {
	private String estado;
	private float valor;
	private int id;
	private LocalDateTime datai;
	private LocalDateTime dataf;
	private Cliente cliente;
	private Pacote pacote;
	private ArrayList<Componente> componentes;


	public Pedido() {
	}

	public Pedido(String estado, float valor, int id, LocalDateTime datai, LocalDateTime dataf, Cliente cliente, Pacote pacote, ArrayList<Componente> componentes) {
		this.estado = estado;
		this.valor = valor;
		this.id = id;
		this.datai = datai;
		this.dataf = dataf;
		this.cliente = cliente;
		this.pacote = pacote;
		this.componentes = componentes;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public float getValor() {
		return this.valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDatai() {
		return this.datai;
	}

	public void setDatai(LocalDateTime datai) {
		this.datai = datai;
	}

	public LocalDateTime getDataf() {
		return this.dataf;
	}

	public void setDataf(LocalDateTime dataf) {
		this.dataf = dataf;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pacote getPacote() {
		return this.pacote;
	}

	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}

	public ArrayList<Componente> getComponentes() {
		return this.componentes;
	}

	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
	}

	public Pedido estado(String estado) {
		this.estado = estado;
		return this;
	}

	public Pedido valor(float valor) {
		this.valor = valor;
		return this;
	}

	public Pedido id(int id) {
		this.id = id;
		return this;
	}

	public Pedido datai(LocalDateTime datai) {
		this.datai = datai;
		return this;
	}

	public Pedido dataf(LocalDateTime dataf) {
		this.dataf = dataf;
		return this;
	}

	public Pedido cliente(Cliente cliente) {
		this.cliente = cliente;
		return this;
	}

	public Pedido pacote(Pacote pacote) {
		this.pacote = pacote;
		return this;
	}

	public Pedido componentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Pedido)) {
			return false;
		}
		Pedido pedido = (Pedido) o;
		return Objects.equals(estado, pedido.estado) && valor == pedido.valor && id == pedido.id && Objects.equals(datai, pedido.datai) && Objects.equals(dataf, pedido.dataf) && Objects.equals(cliente, pedido.cliente) && Objects.equals(pacote, pedido.pacote) && Objects.equals(componentes, pedido.componentes);
	}

	@Override
	public String toString() {
		return "{" +
			" estado='" + getEstado() + "'" +
			", valor='" + getValor() + "'" +
			", id='" + getId() + "'" +
			", datai='" + getDatai() + "'" +
			", dataf='" + getDataf() + "'" +
			", cliente='" + getCliente() + "'" +
			", pacote='" + getPacote() + "'" +
			", componentes='" + getComponentes() + "'" +
			"}";
	}

	public void addPacote(Pacote p) {
		for(Componente comp : p.getComponentes()){
			if(!this.check_componentes(comp))
				return;
		}
		this.pacote = p;
	}

	public void removePacote() {
		this.pacote = null;
	}

	public void addComponente(Componente c) {
		if(this.check_componentes(c))
			this.componentes.add(c);
	}

	public void removeComponente(Componente c) {
		this.componentes.remove(c);
	}

	private boolean check_componentes(Componente comp) {
		boolean valid = true;

		for(Componente c : this.componentes){
			if(c.getIncompativeis().contains(c))
				valid = false;
				break;
		}
		return valid;
	}
}