package guangpu;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;

public class UploadDownloadUtil {
	public void smbGet(String remoteUrl,String localDir) {   
	     InputStream in = null;   
	     OutputStream out = null;   
	     try {   
	         SmbFile remoteFile = new SmbFile(remoteUrl);   
	         if(remoteFile==null){   
	            System.out.println("共享文件不存在");   
	            return;   
	         }   
	         String fileName = remoteFile.getName();   
	         File localFile = new File(localDir+File.separator+fileName);   
	         in = new BufferedInputStream(new SmbFileInputStream(remoteFile));   
	         out = new BufferedOutputStream(new FileOutputStream(localFile));      
	         byte[] buffer = new byte[1024];   
	         while(in.read(buffer)!=-1){   
	            out.write(buffer);   
	            buffer = new byte[1024];   
	         }   
	     } catch (Exception e) {   
	         e.printStackTrace();   
	     } finally {   
	         try {   
	            out.close();   
	            in.close();   
	         } catch (IOException e) {   
	            e.printStackTrace();   
	         }   
	     }   
	}}
