package com.springboot.test;


    
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

    public class UpServlet  {

        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            request.setCharacterEncoding("UTF-8");
            //申明文件上传的路径
            String path = getServletContext().getRealPath("/up");
            //设置一个名称
            FileRenamePolicy reName =
                    new DefaultFileRenamePolicy();
            //开始上传，MultipartRequest构造方法的参数reName是DefaultFileRenamePolicy()的对象，这个必须有才能实现重命名。UTF-8没有就会出现乱码
            MultipartRequest req = new MultipartRequest(request, path, 1024 * 1024 * 10, "UTF-8", reName);
            System.out.println("上传成功");

            //显示信息
            response.setContentType("text/html;charset=UTF-8");

            String oldName = req.getOriginalFileName("imgs");
            String newName = req.getFilesystemName("imgs");
            long size = req.getFile("imgs").length();
            String contentType = req.getContentType("imgs");

            PrintWriter out = response.getWriter();

            out.println("本地文件名称：" + oldName + "<br/>" + "文件上传后重命名为：" + newName + "<br/>" + "文件大小为：" + size + "<br/>" + "文件类型：" + contentType + "<br/>");
            out.println("上传成功");
        }

    }
}
