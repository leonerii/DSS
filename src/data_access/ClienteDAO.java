/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_access;

import java.util.Map;
import java.util.Set;
import business.Cliente;
import business.Pedido;
import dbconnect.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author leonardo
 */
public class ClienteDAO implements Map<String, Cliente> {

    private ArrayList<Pedido> getPedidos(String nif){
        ArrayList<Pedido> res = new ArrayList<>();
        String query = "select * from Pedido where fk_Cliente_nif = ?";

        try{
            Connection con = DBConnection.connect();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, nif);
            ResultSet rs = stmt.executeQuery();

            PedidoDAO pedido_dao = new PedidoDAO();

            while(rs.next()){
                res.add(pedido_dao.get(rs.getInt("id")));
            }

            rs.close();
            stmt.close();
            con.close();
        } catch(SQLException | ClassNotFoundException er){
            er.printStackTrace();
        } finally{
            return res;
        }
    }

        
    @Override
    public ArrayList<Cliente> values() {
        ArrayList<Cliente> res = new ArrayList<>();
        String query = "SELECT * FROM Cliente";

        try{ 
            Connection con = DBConnection.connect();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);              
            
            while(rs.next()) {
                Cliente cp = new Cliente();
                cp.setNome(rs.getString("username"));
                cp.setNif(rs.getString("nif"));
                cp.setMorada(rs.getString("morada"));
                res.add(cp);
            }
            rs.close();
            stmt.close();
            con.close();

        }catch(SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        } finally{
            return res;
        }
    }

    @Override
    public boolean isEmpty() {
        if(this.size() > 0)
            return true;
        
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        if(this.get(key) == null)
            return false;
        
        return true;
    }

    @Override
    public boolean containsValue(Object value) {
        Cliente cp1 = (Cliente) value;
        Cliente cp2 = this.get(cp1.getNif());

        return(cp1 == cp2);
    }

    @Override
    public Cliente get(Object key) {
        String query = "Select * from Cliente where nif = ?";
        Cliente cp = null;

        try {
            Connection con = DBConnection.connect();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, (String) key);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                cp = new Cliente();
                cp.setNome(rs.getString("nome"));                
                cp.setNif(rs.getString("nif"));
                cp.setMorada(rs.getString("morada"));
                cp.setPedidos(this.getPedidos((String) key));
            }

            rs.close();
            stmt.close();
            con.close();

        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            return cp;
        }
    }

    @Override
    public Cliente put(String key, Cliente value) {
        String query = "INSERT INTO `Cliente` (`nome`,`nif`,`morada`) values(?,?,?);";
        Cliente cp = this.remove(key);

        try{
            Connection con = DBConnection.connect();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1,value.getNome());
            stmt.setString(2,value.getNif());
            stmt.setString(3,value.getMorada());
            stmt.executeQuery();

            PedidoDAO pedido_dao = new PedidoDAO();

            for(Pedido order : value.getPedidos())
                pedido_dao.put(order.getId(), order);
          
            stmt.close();
            con.close();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            return cp;
        }
    }

    @Override
    public Cliente remove(Object key) {
        String query = "DELETE FROM Cliente WHERE nif = ?";
        Cliente cp = null;

        try {
            cp = this.get(key);

            Connection con = DBConnection.connect();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, (String) key);
            stmt.executeUpdate();

            stmt.close();
            con.close();
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            return cp;
        }
    }

    @Override
    public int size() {
        String query = "select count(*) from Cliente";
        int size = 0;
        
        try{
            Connection con = DBConnection.connect();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            rs.next();

            size = rs.getInt("count(*)");

            rs.close();
            stmt.close();
            con.close();

        } catch(SQLException sql){
            sql.printStackTrace();
        } catch(ClassNotFoundException cl){
            cl.printStackTrace();
        } finally{
            return size;
        }
    }

    @Override
    public void putAll(Map<? extends String, ? extends Cliente> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<String> keySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<String, Cliente>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
