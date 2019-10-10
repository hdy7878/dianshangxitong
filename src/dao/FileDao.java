package dao;

import entity.FileP;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FileDao extends BaseDao {
    public int insertFile(Connection conn, FileP f)throws SQLException{
        String sql="insert into files(file_name,file_desc,file_auto_name,user_name) values (?,?,?,?)";
        Object[] objs={f.getFile_name(),f.getFile_desc(),f.getFile_auto_name(),f.getUser_name()};
        return super.updateDate(conn,sql,objs);
    }

    public ResultSet selectFilesByUserName(Connection conn,String userName)throws SQLException{
        String sql="select * from files where user_name = ?";
        Object[] objs={userName};
        return super.selectDate(conn,sql,objs);
    }

    public ResultSet selectFilesById(Connection conn,int id) throws SQLException{
        String sql="select * from files where id = ?";
        Object[] objs={id};
        return super.selectDate(conn,sql,objs);
    }
    public int deleteFileById(Connection conn, int id) throws SQLException {
        String sql="delete from files where id=?";
        return super.updateDate(conn, sql, id);
    }
}
