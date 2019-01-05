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
		return this.utilizadores.get(user);
	}

	public Componente getComponente(int id) {
		throw new UnsupportedOperationException();
	}

	public void addComponente(int id, Pedido order) {
		Componente c = this.componentes.get(id);
                order.addComponente(c);
	}

	public void addComponente(int id, Pacote pack) {
		throw new UnsupportedOperationException();
	}
        
        public void removeComponente(int id,Pedido pedido){
            Componente c = this.componentes.get(id);
            pedido.removeComponente(c);
        }
        
        public void removeComponentes(ArrayList<Componente> inc,Pedido pedido){
            for(Componente c : inc){
              pedido.removeComponente(c);
            }
        }

	public boolean login(String user, String pass) {
		Utilizador u = this.utilizadores.get(user);
                return (user.equals(u.getUser()) && pass.equals(u.getPass()));
	}

	public void addPacote(Pedido order, int pack) {
		throw new UnsupportedOperationException();
	}

        public int getNum_pedidos() {
            return this.num_pedidos;
        }

        public ArrayList<Componente> calculaIncomp(Pedido pedido,int id){
            Componente c = this.componentes.get(id);
            ArrayList<Componente> ret = new ArrayList();
            for(Componente a : pedido.getComponentes()){
                if(a.getIncompativeis().contains(c))
                    ret.add(a);
            }
            return ret;
        }
        
        public ArrayList<Componente> calculaExtra(Pedido pedido,int id){
            Componente c = this.componentes.get(id);
            return c.getDependencias();
        }
        
        public void addComponentes(Pedido pedido,ArrayList<Componente> extra){
            for(Componente c : extra){
                pedido.addComponente(c);
            }
        }
        
        

        public void setNum_pedidos(int num_pedidos) {
            this.num_pedidos = num_pedidos;
        }

        public int getNum_pacotes() {
            return this.num_pacotes;
        }

        public void setNum_pacotes(int num_pacotes) {
            this.num_pacotes = num_pacotes;
        }

        public int getNum_componentes() {
            return this.num_componentes;
        }

        public ArrayList<Componente> getComponentes() {
            return this.componentes.values();
        }

        public void setNum_componentes(int num_componentes) {
            this.num_componentes = num_componentes;
        }

        public Pedido createPedido(){
                    this.num_pedidos++;
            return new Pedido(this.num_pedidos);
            }

            public Pacote createPacote(){
                    this.num_pacotes++;
                    return new Pacote(this.num_pacotes);
            }

        public static void main(String[] args){
          BuildMovil bm = new BuildMovil();
            
            Pedido p = bm.createPedido();
            
          /*  bm.addComponente(33, p);
            ArrayList<Componente> ret = new ArrayList();
            ret = bm.calculaIncomp(p,34);
            for(Componente c : ret){
                System.out.println(c.getId());
            }*/
    }      
       
}