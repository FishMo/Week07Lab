/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domainmodel.Note;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 709317
 */
public class NoteDB {
    
    public int insert(Note note) throws NotesDBException{
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection(); 
        
        try {   
            String preparedQuery = "INSERT INTO Note (noteId,dateCreated,contents)"+
                    "VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(preparedQuery);
            ps.setInt(1,note.getNoteId());
            ps.setDate(2, (Date) note.getDateCreated());
            ps.setString(3, note.getContents());
            int rows = ps.executeUpdate();
            return rows;
            
        } catch (SQLException ex) {
            Logger.getLogger(NoteDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            pool.freeConnection(connection);
        }
        return 0;     
    }
    
    public int update(Note note) throws NotesDBException{
      
        
        
        
        return 0;
        
    }
    
    
    
}
