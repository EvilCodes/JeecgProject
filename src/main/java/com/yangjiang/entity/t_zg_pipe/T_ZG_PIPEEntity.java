package com.yangjiang.entity.t_zg_pipe;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 铸管部入库详单
 * @author zhangdaihao
 * @date 2016-10-14 09:23:44
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_zg_pipe", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class T_ZG_PIPEEntity implements java.io.Serializable {
	/**管号*/
	private java.lang.String pipeCode;
	/**规格*/
	private java.lang.String dn;
	/**年份*/
	private java.lang.String pYear;
	/**批号*/
	private java.lang.String batch;
	/**批号全文*/
	private java.lang.String batchFull;
	/**管序号*/
	private java.lang.String pipeSerial;
	/**生成计划号*/
	private java.lang.String productPlanNo;
	/**产品编码*/
	private java.lang.String itemCode;
	/**产品中文名称*/
	private java.lang.String itemCname;
	/**标志*/
	private java.lang.String expFlag;
	/**特殊合同描述*/
	private java.lang.String specialDesc;
	/**包号*/
	private java.lang.String packageid;
	/**数量*/
	private java.lang.String pipenum;
	/**入库单编号*/
	private java.lang.String mainId;
	/**二维码*/
	private java.lang.String qrcode;
	/**效验码*/
	private java.lang.String rccode;
	/**标志*/
	private java.lang.String flag;
	/**生产线*/
	private java.lang.String productLine;
	/**编辑人*/
	private java.lang.String edituser;
	/**编辑IP地址*/
	private java.lang.String editip;
	/**编辑时间*/
	private java.util.Date edittime;
	/**编号*/
	private java.lang.String id;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  管号
	 */
	@Column(name ="pipe_code",nullable=false,precision=50,length=50)
	public java.lang.String getPipeCode(){
		return this.pipeCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  管号
	 */
	public void setPipeCode(java.lang.String pipeCode){
		this.pipeCode = pipeCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  规格
	 */
	@Column(name ="dn",nullable=true,precision=10,length=10)
	public java.lang.String getDn(){
		return this.dn;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  规格
	 */
	public void setDn(java.lang.String dn){
		this.dn = dn;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  年份
	 */
	@Column(name ="p_year",nullable=true,precision=3,scale=0,length=1)
	public java.lang.String getPYear(){
		return this.pYear;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  年份
	 */
	public void setPYear(java.lang.String pYear){
		this.pYear = pYear;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  批号
	 */
	@Column(name ="batch",nullable=true,precision=5,scale=0,length=2)
	public java.lang.String getBatch(){
		return this.batch;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  批号
	 */
	public void setBatch(java.lang.String batch){
		this.batch = batch;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  批号全文
	 */
	@Column(name ="batch_full",nullable=true,precision=10,length=10)
	public java.lang.String getBatchFull(){
		return this.batchFull;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  批号全文
	 */
	public void setBatchFull(java.lang.String batchFull){
		this.batchFull = batchFull;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  管序号
	 */
	@Column(name ="pipe_serial",nullable=true,precision=5,scale=0,length=2)
	public java.lang.String getPipeSerial(){
		return this.pipeSerial;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  管序号
	 */
	public void setPipeSerial(java.lang.String pipeSerial){
		this.pipeSerial = pipeSerial;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  生成计划号
	 */
	@Column(name ="product_plan_no",nullable=true,precision=20,length=20)
	public java.lang.String getProductPlanNo(){
		return this.productPlanNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  生成计划号
	 */
	public void setProductPlanNo(java.lang.String productPlanNo){
		this.productPlanNo = productPlanNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品编码
	 */
	@Column(name ="item_code",nullable=true,precision=20,length=20)
	public java.lang.String getItemCode(){
		return this.itemCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品编码
	 */
	public void setItemCode(java.lang.String itemCode){
		this.itemCode = itemCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品中文名称
	 */
	@Column(name ="item_cname",nullable=true,precision=20,length=20)
	public java.lang.String getItemCname(){
		return this.itemCname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品中文名称
	 */
	public void setItemCname(java.lang.String itemCname){
		this.itemCname = itemCname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  标志
	 */
	@Column(name ="exp_flag",nullable=true,precision=2,length=2)
	public java.lang.String getExpFlag(){
		return this.expFlag;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  标志
	 */
	public void setExpFlag(java.lang.String expFlag){
		this.expFlag = expFlag;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  特殊合同描述
	 */
	@Column(name ="special_desc",nullable=true,precision=200,length=200)
	public java.lang.String getSpecialDesc(){
		return this.specialDesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  特殊合同描述
	 */
	public void setSpecialDesc(java.lang.String specialDesc){
		this.specialDesc = specialDesc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  包号
	 */
	@Column(name ="packageid",nullable=true,precision=20,length=20)
	public java.lang.String getPackageid(){
		return this.packageid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  包号
	 */
	public void setPackageid(java.lang.String packageid){
		this.packageid = packageid;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  数量
	 */
	@Column(name ="pipenum",nullable=true,precision=3,scale=0,length=1)
	public java.lang.String getPipenum(){
		return this.pipenum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  数量
	 */
	public void setPipenum(java.lang.String pipenum){
		this.pipenum = pipenum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入库单编号
	 */
	@Column(name ="main_ID",nullable=true,precision=36,length=36)
	public java.lang.String getMainId(){
		return this.mainId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入库单编号
	 */
	public void setMainId(java.lang.String mainId){
		this.mainId = mainId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  二维码
	 */
	@Column(name ="qrcode",nullable=true,precision=14,length=14)
	public java.lang.String getQrcode(){
		return this.qrcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  二维码
	 */
	public void setQrcode(java.lang.String qrcode){
		this.qrcode = qrcode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  效验码
	 */
	@Column(name ="rccode",nullable=true,precision=4,length=4)
	public java.lang.String getRccode(){
		return this.rccode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  效验码
	 */
	public void setRccode(java.lang.String rccode){
		this.rccode = rccode;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  标志
	 */
	@Column(name ="flag",nullable=true,precision=5,scale=0,length=2)
	public java.lang.String getFlag(){
		return this.flag;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  标志
	 */
	public void setFlag(java.lang.String flag){
		this.flag = flag;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  生产线
	 */
	@Column(name ="product_line",nullable=true,precision=20,length=20)
	public java.lang.String getProductLine(){
		return this.productLine;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  生产线
	 */
	public void setProductLine(java.lang.String productLine){
		this.productLine = productLine;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编辑人
	 */
	@Column(name ="edituser",nullable=true,precision=10,length=10)
	public java.lang.String getEdituser(){
		return this.edituser;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  编辑人
	 */
	public void setEdituser(java.lang.String edituser){
		this.edituser = edituser;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编辑IP地址
	 */
	@Column(name ="editip",nullable=true,precision=15,length=15)
	public java.lang.String getEditip(){
		return this.editip;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  编辑IP地址
	 */
	public void setEditip(java.lang.String editip){
		this.editip = editip;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  编辑时间
	 */
	@Column(name ="edittime",nullable=false,precision=23,scale=3,length=8)
	public java.util.Date getEdittime(){
		return this.edittime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  编辑时间
	 */
	public void setEdittime(java.util.Date edittime){
		this.edittime = edittime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编号
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="id",nullable=false,precision=36,length=72)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  编号
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
}
