/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import business.Componente;
import business.Pacote;
import dbconnect.DBConnection;

/**
 *
 * @author leonardo
 */
public class PacoteDAO implements Map<Integer, Pacote> {

    @Override
    public int size() {
        String query = "select count(*) from Pacote";
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
        Pacote p1 = (Pacote) value;
        Pacote p2 = this.get(p1.getId());

        return(p1 == p2);
    }

    @Override
    public Pacote get(Object key) {
        String query = "Select * from Pacote where id = ?";
        String query2 = "Select fk_Componente_id from Pacote_Componente where fk_Pacote_id = ?;";
        Pacote p = null;

        try {
            Connection con = DBConnection.connect();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, (int) key);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                p = new Pacote();
                p.setNome(rs.getString("nome"));               
                p.setValor(rs.getFloat("valor"));
                p.setId(rs.getInt("id"));

                stmt = con.prepareStatement(query2);
                stmt.setInt(1, (int) key);
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
    public Pacote put(Integer key, Pacote value) {
        String query = "INSERT INTO Pacote (nome,id,valor) values(?,?,?);";
        String query2 = "Insert into Pacote_Componente (fk_Componente_id, fk_Pacote_id) values (?,?);";
        Pacote cp = this.remove(key);

        try{
            Connection con = DBConnection.connect();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1,value.getNome());
            stmt.setInt(2,value.getId());
            stmt.setFloat(3,value.getValor());
            stmt.executeQuery();

            for(Componente comp : value.getComponentes()){
                stmt = con.prepareStatement(query2);
                stmt.setInt(1, comp.getId());
                stmt.setInt(2, value.getId());
                stmt.executeQuery();
            }

            stmt.close();
            con.close();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            return cp;
        }
    }

    @Override
    public Pacote remove(Object key) {
        String query = "DELETE FROM Pacote WHERE id = ?";
        Pacote cp = null;

        try {
            cp = this.get(key);

            Connection con = DBConnection.connect();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, (int) key);
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
    public ArrayList<Pacote> values() {
        ArrayList<Pacote> res = new ArrayList<>();
        String query = "SELECT id FROM Pacote";

        try{ 
            Connection con = DBConnection.connect();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);              
            
            while(rs.next()) {
                Pacote p = this.get(rs.getInt("id"));
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
    public void putAll(Map<? extends Integer, ? extends Pacote> m) {
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

    @Override
    public Set<Entry<Integer, Pacote>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
