package servlet;

import entity.FileP;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.FileService;
import until.TimeHelper;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet(urlPatterns = "/File")
public class FlieServlet extends HttpServlet {

    private static final long serialVersionUID=1L;

    FileService service=new FileService();
    public FlieServlet(){
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        System.out.println("op:" + op + "----------FileServlet-----------");
        if("doUpFile".equals(op)){
            doUpFile(request,response);
        }else if("doShowAll".equals(op)){
            doShowAll(request,response);
        }else if("doDownLoad".equals(op)){
            doDownLoad(request,response);
        }else if("doDelFile".equals(op)){
            doDelFile(request,response);
        }
    }
    protected void doDelFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //删除文件要删除数据库加磁盘的两个地方的文件
        int id=Integer.parseInt(request.getParameter("id"));
        FileP fileP=service.findFileById(id);
        //得到文件在磁盘上的真实路径
        String path="/upLoad/"+fileP.getFile_auto_name();
        String realPath=getServletContext().getRealPath(path);
        File file=new File(realPath);
        boolean bf=file.delete();
        System.out.println("删除成功了吗：----"+bf);
        service.subFileById(id);
    }
    protected void doDownLoad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        FileP fileP=service.findFileById(id);
        //得到文件在磁盘上的真实路径
        String path="/upLoad/"+fileP.getFile_auto_name();
        String realPath=getServletContext().getRealPath(path);
        String file_auto_name=fileP.getFile_auto_name();
        String ext=file_auto_name.substring(file_auto_name.lastIndexOf("."));
        String fileName=fileP.getFile_name()+ext;
        System.out.println("下载后的文件名："+fileName);

        //下载 先把文件读到内存中 清空response
        FileInputStream in=new FileInputStream(realPath);
        response.reset();
        response.setHeader("Content-Disposition","attachment;filename="+fileName);
        //输出流写出
        ServletOutputStream out=response.getOutputStream();
        byte[] buf=new byte[1024];
        int len=0;
        while((len=in.read(buf))>0){
            out.write(buf,0,len);
        }
        in.close();
        out.flush();
        out.close();

    }
    protected void doShowAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String userName=(String)request.getSession().getAttribute("loginName");
          List<FileP> list= service.findFileByUserName(userName);
          request.setAttribute("list",list);
          request.getRequestDispatcher("ShowAllFiles.jsp").forward(request,response);
    }

    protected void doUpFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(factory);
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> list=upload.parseRequest(request);
                String file_name=null;
                String file_desc=null;
                String auto_name=null;
                String user_name=(String)request.getSession().getAttribute("loginName");

                for (FileItem item: list) {
                    if(item.isFormField()){
                     String name =item.getFieldName();

                     String value=item.getString("UTF-8");
                     if("fileName".equals(name)){
                         file_name=value;
                     }else if("fileDesc".equals(name)){
                         file_desc=value;
                     }
                    }else {
                   InputStream input =item.getInputStream();
                   String name=item.getName();
                        System.out.println("上传的文件名："+name);
                    String ext=name.substring(name.lastIndexOf("."));
                        System.out.println(ext+"-----文件的扩展名");
                       auto_name= TimeHelper.getTime2()+ext;
                        //根据虚拟路径得到物理路径
                       String realPath =getServletContext().getRealPath("/upLoad");
                        File file=new File(realPath,auto_name);
                        file.createNewFile();
                        FileOutputStream out=new FileOutputStream(file);
                        byte[] buf=new byte[1024];
                        int len=0;
                        while((len=input.read(buf))>0){
                            out.write(buf,0,len);
                        }
                        input.close();
                        out.close();
                    }
                }
                System.out.println("上传的文件名："+file_name+"    文件说明："+file_desc);
                System.out.println("autoName:"+auto_name);
                System.out.println("userName:"+user_name);

                int i= service.addFile(new FileP(file_name,file_desc,auto_name,user_name));
                PrintWriter out=response.getWriter();
                if(i>0){
                    out.print("<script>alert('恭喜你，文件上传成功');</script>");
                }else{
                    out.print("<script>alert('对不起，上传失败');history.back();</script>");
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
