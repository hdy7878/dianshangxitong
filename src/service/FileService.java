package service;

import dao.FileDao;
import entity.FileP;
import until.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private FileDao md;

    public FileService(){
        md=new FileDao();
    }

    public int addFile(FileP f){
        Connection conn=null;
        try {

            conn= DBHelper.getConnection();
            conn.setAutoCommit(false);
            int i=md.insertFile(conn,f);
            conn.commit();
            conn.setAutoCommit(true);
            return i;
        } catch (SQLException e) {
            try{
                conn.rollback();
                conn.setAutoCommit(true);
            }catch(SQLException e1){
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            md.close();
        }
     return 0;
    }

    public List<FileP> findFileByUserName(String userName){
        Connection conn=null;
        ArrayList<FileP> list=new ArrayList<FileP>();
        try {
            conn=DBHelper.getConnection();
            ResultSet set=md.selectFilesByUserName(conn,userName);
            while (set.next()){
                int id=set.getInt("id");
                String file_name=set.getString("file_name");
                String file_desc=set.getString("file_desc");
                String auto_name=set.getString("file_auto_name");
                String user_name=set.getString("user_name");
                list.add(new FileP(id,file_name,file_desc,auto_name,user_name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            md.close();
        }
        return  list;
    }

    public FileP findFileById(int id2){
        Connection conn=null;
        try {
            conn=DBHelper.getConnection();
            ResultSet set=md.selectFilesById(conn,id2);
            if (set.next()){
                int id=set.getInt("id");
                String file_name=set.getString("file_name");
                String file_desc=set.getString("file_desc");
                String auto_name=set.getString("file_auto_name");
                String user_name=set.getString("user_name");
                return new FileP(id,file_name,file_desc,auto_name,user_name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            md.close();
        }
        return  null;
    }

    public void subFileById(int id){
        Connection conn = null;
        try {
            conn = DBHelper.getConnection();
            int f=md.deleteFileById(conn,id);
            if (f == 1) {
                System.out.println("删除文件成功");
            } else {
                System.out.println("删除文件失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            md.close();
        }

    }
}
