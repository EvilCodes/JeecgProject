<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker,lodop"></t:base>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>index.html</title>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <script language="javascript" src="plug-in/lodop/LodopFuncs.js"></script>  
        <object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0>  
            <embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0 pluginspage="plug-in/Lodop/install_lodop32.exe"></embed>  
        </object>  
 <script type="text/javascript">
 $(function(){
		//alert(111);
	});
 var LODOP,P_ID="",TaskID1,TaskID2,t,waiting=false,c=0,loop=0; //声明为全局变量 
	function getStatusValue(ValueType,ValueIndex,oResultOB){
		LODOP=getLodop(); 
		if (LODOP.CVERSION) LODOP.On_Return=function(TaskID,Value){oResultOB.value=Value;};
		var strResult=LODOP.GET_VALUE(ValueType,ValueIndex);
		if (!LODOP.CVERSION) return strResult; else return "";
	};
	function MyPrint(){
		
		
		LODOP.SET_PRINT_MODE("CATCH_PRINT_STATUS",true);
		if (LODOP.CVERSION) {
			LODOP.On_Return=function(TaskID,Value)
			{document.getElementById('T1').value=Value;};
			LODOP.PRINTA();
			return;
		} else document.getElementById('T1').value=LODOP.PRINTA();
			console.log("cccccccccc,"+document.getElementById('T1').value);
		var TTT;
		TTT.value=getStatusValue('PRINT_STATUS_OK',document.getElementById('T1').value,TTT);
		console.log("TTTTTTTTTTTTTTT:"+TTT.value);
	};	
	function view1() {  
	
     init();  
   LODOP.PRINT();
     // MyPrint();
   
 }  
 function view() {  
     init();  
     LODOP.SET_SHOW_MODE("BKIMG_IN_PREVIEW",1);  
     
      LODOP.PREVIEW(); 
 }  
    function design() {
    	//alert(111);
        init();  
        document.getElementById('templateCode').value=LODOP.PRINT_DESIGN();  
    }  
   
    function init(){  
    var row_top=0;
    var row_left=20;
    var row_top1=10;
    var row_left1=38;
    	LODOP.PRINT_INITA(80,-53,1240,1754,"跟踪卡");
    
    	//LODOP.ADD_PRINT_TEXT(291+row_top,405+row_left,250,20,"${printData[0].DELIVY_PLACE_NAME }");
    	LODOP.ADD_PRINT_TEXT(198+row_top,406+row_left,74,20,"${printData[0].SALE_PERSON_NAME }");
    	LODOP.ADD_PRINT_TEXT(112+row_top-row_top1,73+row_left,145,20,"${t_zg_pipe_ckm.chukudanid}");
    	LODOP.ADD_PRINT_TEXT(200+row_top,76+row_left,100,19,"529600");
    	LODOP.ADD_PRINT_TEXT(112+row_top-row_top1,457+row_left,135,20,"${printData[0].mday}");
    	LODOP.ADD_PRINT_TEXT(140+row_top,410+row_left,100,20,"${printData[0].org_name }");
    	LODOP.ADD_PRINT_TEXT(170+row_top,409+row_left,153,20,"${printData[0].bill_notice_no }");
    //*****************************************
    	LODOP.ADD_PRINT_TEXT(242+row_top+row_top1,96+row_left,158,20,"输水用球墨铸铁管");
    	LODOP.ADD_PRINT_TEXT(269+row_top+row_top1,98+row_left,157,20,"广东新兴铸管一库");
    	LODOP.ADD_PRINT_TEXT(294+row_top+row_top1,96+row_left,162,20,"${printData[0].carry_company_name }");
    	LODOP.ADD_PRINT_TEXT(323+row_top+row_top1,95+row_left,100,20,"${printData[0].car_no }");
    	LODOP.ADD_PRINT_TEXT(350+row_top+row_top1,95+row_left,100,20,"${printData[0].driver_tel }");
    	
    	LODOP.ADD_PRINT_TEXT(242+row_top+row_top1,405+row_left,173,20,"${printData[0].consign_cname }");
    	LODOP.ADD_PRINT_TEXT(269+row_top+row_top1,405+row_left,100,20,"${printData[0].mtime }");
    	LODOP.ADD_PRINT_TEXT(294+row_top+row_top1,405+row_left,250,20,"${printData[0].REC_ADD }");
    	LODOP.ADD_PRINT_TEXT(323+row_top+row_top1,392+row_left,100,20,"${printData[0].REC_PERSON }");
    	LODOP.ADD_PRINT_TEXT(350+row_top+row_top1,404+row_left,100,20,"${printData[0].REC_TEL }");
    	//console.log("1111111111111111111111111111");
    	//console.log("${printData[0].EXP_FLAG}".replace(/(^\s*)|(\s*$)/g, "")!="0");
    	//console.log("${printData[0].ddh}");
    	if("${printData[0].EXP_FLAG}".replace(/(^\s*)|(\s*$)/g, "")!="0"){
    	LODOP.ADD_PRINT_TEXT(417+row_top+2.3*row_top1,73+row_left-row_left1,64,20,"${printData[0].ddh}");
    	}
    	//console.log("1111111111111111111111111112");
    	LODOP.ADD_PRINT_TEXT(417+row_top+2.3*row_top1,132+row_left-row_left1,64,20,"${printPipeData[0].dn }");
    	LODOP.ADD_PRINT_TEXT(417+row_top+2.3*row_top1,219+row_left,44,20,"${printPipeData[0].LENGTH_DESC }");
    	LODOP.ADD_PRINT_TEXT(417+row_top+2.3*row_top1,296+row_left,45,20,"${printPipeData[0].numpipe }");
    	LODOP.ADD_PRINT_TEXT(553+row_top+10+3.8*1.3*row_top1,563+row_left,100,20,"${printPipeData[0].baoguanyuan }");
    	LODOP.ADD_PRINT_TEXT(553+row_top+10+3.8*1.3*row_top1,134+row_left,100,20,"${printPipeData[0].numpipe }");
    	//增加胶圈  
    	<c:forEach  items="${jqprintData}" var="li" varStatus="status">
        LODOP.ADD_PRINT_TEXT(570+row_top+3.8*1.3*row_top1+"${status.index + 1}"*20,194+row_left,80,25,"${li.name }");
    	LODOP.ADD_PRINT_TEXT(570+row_top+3.8*1.3*row_top1+"${status.index + 1}"*20,294+row_left,80,25,"${li.SPEC_DESC }");
    	LODOP.ADD_PRINT_TEXT(570+row_top+3.8*1.3*row_top1+"${status.index + 1}"*20,394+row_left,80,25,"${li.sendNum }");		
       </c:forEach>
    
    
    
    	LODOP.ADD_PRINT_TEXT(703+row_top+3.8*1.3*row_top1,194+row_left,191,25,"装车质量良好车内无杂物");
    	LODOP.ADD_PRINT_TEXT(553+row_top+3.8*1.3*row_top1+10,167+row_left,100,20,"支");
    	LODOP.ADD_PRINT_TEXT(145+row_top,95+row_left,214,20,"阳春市春城街道南新大道113号");
    	LODOP.ADD_PRINT_TEXT(194+row_top,548+row_left,100,20,"${printData[0].MOBILE_PHONE }");

 
    }  
    
</script>  
</head>
<body>    
        <button type="button" onclick="view()">  
           	 打印预览  
        </button> 
       <textarea id="templateCode" cols="100" rows="30" style="background-color: #fff;"></textarea>       
      <input type="hidden" name="T1" id="T1" size="48">  
 </body> 
 
</html>