package guangpu;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import net.sf.json.JSONObject;

import org.jeecgframework.core.util.JSONHelper;
import org.jeecgframework.web.system.service.SystemService;

import antlr.collections.List;

import com.google.common.collect.Maps;
import com.yangjiang.entity.t_zg_analy_gp.T_zg_analy_GPEntity;
import com.yangjiang.service.t_zg_analy_gp.T_zg_analy_GPServiceI;

import jcifs.Config;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
public class ConnectGPPC {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	private static T_zg_analy_GPServiceI t_zg_analy_GPService;
	private SystemService systemService;
	private static Map oderData = new HashMap();
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public static void main(String[] args) throws Exception {
	        //smb://xxx:xxx@192.168.2.188/testIndex/  
	        //xxx:xxx是共享机器的用户名密码
			final NtlmPasswordAuthentication AUTH = new NtlmPasswordAuthentication("WORKGROUP", "jsjs", "8299");

			Config.setProperty("jcifs.netbios.wins", "172.16.22.200");
			
			//Properties props = new Properties();
			SmbFile file = new SmbFile("smb://172.16.22.200/Temp/IN_FILE.TMP", AUTH);
			//byte b[]=new byte[(int)file.];
			int fileLength=file.getContentLength();
			byte buffer[] = new byte[fileLength]; 
			SmbFileInputStream in = new SmbFileInputStream(file);
			ArrayList<ElementValue> ls=new ArrayList<ElementValue>();
			//BufferedReader bre = new BufferedReader(new FileReader(in));
			 while ((in.read(buffer)) != -1) {  
				  	
		            //System.out.write(buffer); 
				 	T_zg_analy_GPEntity tgp=new T_zg_analy_GPEntity();
		            String s = new String(buffer, "GB2312");
		            String [] ss=s.split("\n");
		            //第一行数据，获取年份日期时间，样子编号
		            
		            String firstLine=ss[0].trim();
		            System.out.println("第一行数据------------------");
		            String mYear=firstLine.substring(0, 10);
		            String mmyear=mYear.substring(6, 10);
		            String mmmonth=mYear.substring(3, 5);
		            String mmday=mYear.substring(0, 2);
		            
		            System.out.println("日期："+mYear);
		            String mTime=firstLine.substring(11, 19);
		            String mmhour=mTime.substring(0, 2);
		            String mmm=mTime.substring(3, 5);
		            String mms=mTime.substring(6, 8);
		            System.out.println("时间："+mTime);
		            SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		            ////String test="12.02.2017;16.45.55;P;FE ;Used Type Standardisation Sample: k046c;FE2            ;Cast Iron, low alloyed        ;2;002;Quality-Control          ;Sample No.;";
		            ///System.out.println("length："+test.length());
		            String sampleNum=firstLine.substring(156, 168);
		            System.out.println("sampleNum："+sampleNum);
		            //tgp.setSampleno(sampleNum);
		            System.out.println(mmyear+"-"+mmmonth+"-"+mmday+" "+mmhour+":"+mmm+":"+mms);
		            Date date = sdf.parse( mmyear+"-"+mmmonth+"-"+mmday+" "+mmhour+":"+mmm+":"+mms);
		            //tgp.setAnalydate(date);
		            
		            //取到第二行数据，数据均值
		            String sss=ss[1].trim();
		            System.out.println("第二行数据------------------");
		            //System.out.println(ss[1].trim());
		            //对第二行数据进行区分；
		            String []ssss= sss.split(";; ;          ;          ;Y;Y;");		           
		            for(int i=1;i<21;i++){		            			            			            				            			        		            	
		            	System.out.println("第'"+i+"'个元素名称");
		            	System.out.println(ssss[i].substring(0, 3));
		            	String elementName=ssss[i].substring(0, 2);
		            	System.out.println(ssss[i].substring(18, 24));
		            	String elementValue=ssss[i].substring(18, 26);
		            	
		            	ElementValue e=new ElementValue();
		            	e.setSeq(i);
		            	e.setName(elementName);
		            	e.setValue(elementValue);
		            	ls.add(e);
		            	//System.out.println(myMap.get(4.556));		            			            			            			            
		            	//System.out.print("mdate:"+mYear+","+"mTime:"+mTime+","+"sampleNum:"+sampleNum+","+elementName+":"+elementValue);
		            	System.out.println("第'"+i+"'个元素名");
		            	System.out.println(ls.size());
		            	
		            	
		            }
		            for(int j=0;j<ls.size();j++){
		            	System.out.println("22222222222222222222222222222222222222222222222222");
		            	
		            	oderData.put("'"+ls.get(j).getName()+"'", ls.get(j).getValue());
		            	System.out.println(ls.get(j).getName()+":"+ls.get(j).getValue());
		            }
		            oderData.put("analyDate", date);
		            oderData.put("sampleNo", sampleNum);
		            
		            String myJson=JSONHelper.map2json(oderData);
		            tgp=(T_zg_analy_GPEntity) JSONHelper.json2Object(myJson, T_zg_analy_GPEntity.class);
		            t_zg_analy_GPService.save(tgp);
		     }  
			 	
		    in.close();  
		   //smbFile.delete();  
			//System.out.println(buffer);
		    //return ls;
			
	    }

}
