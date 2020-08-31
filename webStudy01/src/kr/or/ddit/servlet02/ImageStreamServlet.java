package kr.or.ddit.servlet02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost/webStudy01/image/image.do
@WebServlet(urlPatterns = "/image/image.do", 
			initParams = { @WebInitParam(name = "contentsPath", value = "e:/contents") })
public class ImageStreamServlet extends HttpServlet{
   private File folder;
   
   @Override
   public void init(ServletConfig config) throws ServletException {
      super.init(config);
      String contentsPath = config.getInitParameter("contentsPath");
      folder = new File(contentsPath);
   }
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.setCharacterEncoding("UTF-8");
      String imageName = req.getParameter("image");
      if(imageName == null || imageName.trim().length()==0) {
         resp.sendError(400);
         return;
      }
      
      File imageFile = new File(folder, imageName);
      if(!imageFile.exists()) {
         resp.sendError(404);
         return;
      }
      
      String mime = getServletContext().getMimeType(imageName);
      if(mime == null) {
         mime = "application/octet-stream";
      }
      
      resp.setContentType(mime);
      
//      try with resource 구문, 1.7부터 사용.
      try(
            // Closable 기능 객체의 생성 및 할당 코드
            FileInputStream fis = new FileInputStream(imageFile);
            OutputStream os = resp.getOutputStream();
      ){
            // 예외 발생 가능 코드
            byte[] buffer = new byte[1024];
            int pointer = -1;
            while((pointer = fis.read(buffer))!=-1) {
               os.write(buffer, 0, pointer);
            }
            os.flush();
      }
   }
}
      
   /*   FileInputStream fis = null;
      OutputStream os = null;
      try {
         fis = new FileInputStream(imageFile);
         os = resp.getOutputStream();
         
         byte[] buffer = new byte[1024];
         int pointer = -1;
         while((pointer = fis.read(buffer))!=-1) {
            os.write(buffer, 0, pointer);
         }
         os.flush();
      }finally {
         if(fis!=null) fis.close();
         if(os!=null)  os.close();
         }
      }
   }
*/