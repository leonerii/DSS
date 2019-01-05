/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_access;

import java.util.Map;
import business.Utilizador;
import dbconnect.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author leonardo
 */
public class UtilizadorDAO implements Map<String,Utilizador>{

     @Override
    public ArrayList<Utilizador> values() {
        ArrayList<Utilizador> res = new ArrayList<>();
        String query = "SELECT * FROM Utilizador";

        try{ 
            Connection con = DBConnection.connect();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);              
            
            while(rs.next()) {
                Utilizador cp = new Utilizador();
                cp.setUser(rs.getString("user"));
                cp.setPass(rs.getString("pass"));
                cp.setNome(rs.getString("nome"));
                cp.setTipo(rs.getString("tipo"));
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
    public Utilizador get(Object key) {
        String query = "Select * from Utilizador where user = ?";
        Utilizador cp = null;

        try {
            Connection con = DBConnection.connect();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, (String) key);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                cp = new Utilizador();
                cp.setUser(rs.getString("user"));
                cp.setPass(rs.getString("pass"));
                cp.setNome(rs.getString("nome"));
                cp.setTipo(rs.getString("tipo"));
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
    public Utilizador put(String key, Utilizador value) {
        String query = "INSERT INTO `Utilizador` (`user`,`pass`,`nome`,`tipo`) values(?,?,?,?);";
        Utilizador c = this.remove(key);

        try{
            Connection con = DBConnection.connect();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1,value.getUser());
            stmt.setString(2,value.getPass());
            stmt.setString(3,value.getNome());
            stmt.setString(4,value.getTipo());
            stmt.executeUpdate();

            stmt.close();
            con.close();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            return c;
        }
    }
    
    @Override
    public int size() {
        String query = "select count(*) from Utilizador";
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
        Utilizador cp1 = (Utilizador) value;
        Utilizador cp2 = this.get(cp1.getUser());

        return(cp1 == cp2);
    }

    @Override
    public Utilizador remove(Object key) {
        String query = "DELETE FROM Utilizador WHERE user = ?";
        Utilizador cp = null;

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
    public void putAll(Map<? extends String, ? extends Utilizador> m) {
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
    public Set<Entry<String, Utilizador>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
