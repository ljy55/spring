package kr.or.ddit.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

/**
 *   클래스패스 리소스 형태의 템플릿을 읽어들임.
 * @param tmplPath : 클래스패스 경로
 * @return 템플릿 소스
 * @throws IOException
 * 
 */

public class TemplateUtils {
   
   public static StringBuffer readTemplate(String tmplPath) throws IOException{
      URL tmplURL = TemplateUtils.class.getResource(tmplPath);
      if(tmplURL==null) {
         throw new NullPointerException(tmplPath+"에 해당하는 파일이 없음.");
      }
      try {
         Path tmpPath = Paths.get(tmplURL.toURI());
         File tmplFile = tmpPath.toFile();
         StringBuffer template = new StringBuffer();
         try(
            FileInputStream fis = new FileInputStream(tmplFile);
            InputStreamReader in = new InputStreamReader(fis, "UTF-8");
            BufferedReader reader = new BufferedReader(in);
         ){
         String tmp = null;
         while((tmp=reader.readLine())!=null) {
            template.append(tmp+"\n");
            }
         }
         return template;
      }catch (URISyntaxException e) {
         throw new IOException(e);
      }
   }
   
   /**
    *   토큰을 데이터로 치환
    * @param attributeMap : 클래스패스 경로
    * @return 템플릿 소스
     * @throws IOException
    */
   public static String replaceAttributeToData(Map<String, Object> attributeMap, StringBuffer template){
      for(Entry<String, Object> entry : attributeMap.entrySet()) {
         String name = entry.getKey();
         Object value = entry.getValue();
         String token = "@"+name;
         int indexOf = template.indexOf(token);
         template.replace(indexOf, indexOf + token.length(), Objects.toString(value, ""));
         
      }
      return template.toString();      
   }
   
   /**
    * 템플릿을 읽고 데이터를 치환하는 메소드
    * @param tmplPath : 템플릿의 클래스패스 경로
    * @param attributeMap 
     * @throws IOException
    */
   public static String readAndReplace(String tmplPath, Map<String, Object> attributeMap) throws IOException {
      StringBuffer template = readTemplate(tmplPath);
      return replaceAttributeToData(attributeMap, template);
   }
   
}








