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
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import business.Componente;
import dbconnect.DBConnection;

/**
 *
 * @author leonardo
 */
public class ComponenteDAO implements Map<Integer, Componente> {

    @Override
    public int size() {
        String query = "select count(*) from Componente";
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
        Componente c1 = (Componente) value;
        Componente c2 = this.get(c1.getId());

        return(c1 == c2);
    }

    @Override
    public Componente get(Object key) {
        String query = "Select * from Componente where id = ?";
        String query1 = "Select fk_Pacote_id"
        String query2 = "Select * from Dependente where fk_Componente_id = ?";
        String query3 = "Select * from Incompativel where fk_Componente_id = ?";
        Componente c = null;

        try {
            Connection con = DBConnection.connect();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, (int) key);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                c = new Componente();
                c.setNome(rs.getString("nome"));               
                c.setValor(rs.getFloat("valor"));
                c.setId(rs.getInt("id"));
                c.setPeso(rs.getInt("peso"));

                stmt = con.prepareStatement(query2);
                stmt.setInt(1, (int) key);
                ResultSet rs2 = stmt.executeQuery();

                while(rs2.next())
                    c.addDependente(this.get(rs2.getInt("fk_Componente_id_")));

                stmt = con.prepareStatement(query3);
                stmt.setInt(1, (int) key);
                ResultSet rs3 = stmt.executeQuery();
    
                while(rs3.next())
                    c.addIncompativel(this.get(rs3.getInt("fk_Componente_id_")));

                rs2.close();
                rs3.close();
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
    public Componente put(Integer key, Componente value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Componente remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Componente> m) {
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
    public Collection<Componente> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<Integer, Componente>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
