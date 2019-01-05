/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_access;

import java.util.Map;
import business.Componente;
import business.Pedido;
import dbconnect.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author leonardo
 */
public class PedidoDAO implements Map<Integer,Pedido>{

    @Override
    public int size() {
        int size = 0;
        String query = "select count(*) from Pedido";

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
        Pedido p1 = (Pedido) value;
        Pedido p2 = this.get(p1.getId());

        return(p1 == p2);
    }

    @Override
    public Pedido get(Object key) {
        String query = "Select * from Pedido where id = ?";
        String query2 = "Select fk_Componente_id from Pedido_Componente where fk_Pedido_id = ?";
        Pedido p = null;

        try {
            Connection con = DBConnection.connect();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, (int) key);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                p = new Pedido();
                p.setId(rs.getInt("id"));
                p.setEstado(rs.getString("estado"));
                p.setValor(rs.getFloat("valor"));
                p.setDatai(LocalDateTime.ofInstant(rs.getDate("data_inicial").toInstant(), ZoneId.systemDefault()));
                p.setDataf(LocalDateTime.ofInstant(rs.getDate("data_final").toInstant(), ZoneId.systemDefault()));
                
                ClienteDAO cliente_dao = new ClienteDAO();
                p.setCliente(cliente_dao.get(rs.getString("fk_Cliente_nif")));

                PacoteDAO pacote_dao = new PacoteDAO();
                p.setPacote(pacote_dao.get(rs.getInt("fk_Pacote_id")));

                stmt = con.prepareStatement(query2);
                ResultSet rs2 = stmt.executeQuery();
                ComponenteDAO componente_dao = new ComponenteDAO();

                while(rs2.next())
                    p.addComponente(componente_dao.get(rs2.getInt("fk_Componente_id")));

                rs2.close();
            }

            rs.close();
            stmt.close();
            con.close();

        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            return p;
        }
    }

    @Override
    public Pedido put(Integer key, Pedido value) {
        String query = "INSERT INTO Pedido (estado,id,valor,datai,dataf,fk_Cliente_nif,fk_Pacote_id) values(?,?,?,?,?,?,?);";
        String query2 = "Insert into Pedido_Componente (fk_Componente_id,fk_Pedido_id) values(?,?);";
        Pedido p = this.remove(key);

        try{
            Connection con = DBConnection.connect();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1,value.getEstado());
            stmt.setInt(2,value.getId());
            stmt.setFloat(3,value.getValor());
            stmt.setDate(4,java.sql.Date.valueOf(value.getDatai().toLocalDate()));
            stmt.setDate(5,java.sql.Date.valueOf(value.getDataf().toLocalDate()));
            stmt.setString(6, value.getCliente().getNif());
            
            if(value.getPacote() != null)
                stmt.setInt(7, value.getPacote().getId());
            else
                stmt.setNull(7, Types.INTEGER);

            stmt.executeUpdate();

            for(Componente comp : value.getComponentes()){
                stmt = con.prepareStatement(query2);
                stmt.setInt(1, comp.getId());
                stmt.setInt(2, value.getId());
                stmt.executeUpdate();
            }

            stmt.close();
            con.close();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            return p;
        }
    }

    @Override
    public Pedido remove(Object key) {
        String query = "DELETE FROM Pedido WHERE id = ?";
        Pedido p = null;

        try {
            p = this.get(key);

            Connection con = DBConnection.connect();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, (int) key);
            stmt.executeUpdate();

            stmt.close();
            con.close();
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            return p;
        }
    }

    @Override
    public ArrayList<Pedido> values() {
        ArrayList<Pedido> res = new ArrayList<>();
        String query = "SELECT id FROM Pedido";

        try{ 
            Connection con = DBConnection.connect();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);              
            
            while(rs.next()) {
                Pedido p = this.get(rs.getInt("id"));
                res.add(p);
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
    public Set<Entry<Integer, Pedido>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Pedido> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Integer> keySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
