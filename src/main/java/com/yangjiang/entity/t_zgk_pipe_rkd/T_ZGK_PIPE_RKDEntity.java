package com.yangjiang.entity.t_zgk_pipe_rkd;

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
 * @Description: 管材入库详细信息
 * @author zhangdaihao
 * @date 2016-10-27 14:46:48
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_zgk_pipe_rkd", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class T_ZGK_PIPE_RKDEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**入库单号*/
	private java.lang.String rukudanid;
	/**规格*/
	private java.lang.String dn;
	/**批号全称*/
	private java.lang.String batchFull;
	/**管序号*/
	private java.lang.String pipeSerial;
	/**包号*/
	private java.lang.String packageid;
	/**生产计划号*/
	private java.lang.String productPlanNo;
	/**产品编码*/
	private java.lang.String itemCode;
	/**产品名称*/
	private java.lang.String itemCname;
	/**出口标识*/
	private java.lang.String expFlag;
	/**特殊合同描述*/
	private java.lang.String specialDesc;
	/**支数*/
	private java.lang.Integer pipenum;
	/**套装方式*/
	private java.lang.String suitWay;
	/**货位*/
	private java.lang.String huowei;
	/**层号*/
	private java.lang.Integer cengci;
	/**层序号*/
	private java.lang.Integer cengneixuhao;
	/**生产线*/
	private java.lang.String productLine;
	/**外键*/
	private java.lang.String mainId;
	/**pipeCode*/
	private java.lang.String pipeCode;
	
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,precision=50,length=100)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入库单号
	 */
	@Column(name ="RUKUDANID",nullable=true,precision=36,length=36)
	public java.lang.String getRukudanid(){
		return this.rukudanid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入库单号
	 */
	public void setRukudanid(java.lang.String rukudanid){
		this.rukudanid = rukudanid;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  规格
	 */
	@Column(name ="DN",nullable=false,precision=10,length=10)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  批号全称
	 */
	@Column(name ="BATCH_FULL",nullable=false,precision=16,length=16)
	public java.lang.String getBatchFull(){
		return this.batchFull;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  批号全称
	 */
	public void setBatchFull(java.lang.String batchFull){
		this.batchFull = batchFull;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  管序号
	 */
	@Column(name ="PIPE_SERIAL",nullable=false,precision=10,length=10)
	public java.lang.String getPipeSerial(){
		return this.pipeSerial;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  管序号
	 */
	public void setPipeSerial(java.lang.String pipeSerial){
		this.pipeSerial = pipeSerial;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  包号
	 */
	@Column(name ="PACKAGEID",nullable=true,precision=20,length=20)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  生产计划号
	 */
	@Column(name ="PRODUCT_PLAN_NO",nullable=true,precision=20,length=20)
	public java.lang.String getProductPlanNo(){
		return this.productPlanNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  生产计划号
	 */
	public void setProductPlanNo(java.lang.String productPlanNo){
		this.productPlanNo = productPlanNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品编码
	 */
	@Column(name ="ITEM_CODE",nullable=true,precision=20,length=20)
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
	 *@return: java.lang.String  产品名称
	 */
	@Column(name ="ITEM_CNAME",nullable=true,precision=200,length=200)
	public java.lang.String getItemCname(){
		return this.itemCname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品名称
	 */
	public void setItemCname(java.lang.String itemCname){
		this.itemCname = itemCname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出口标识
	 */
	@Column(name ="EXP_FLAG",nullable=true,precision=2,length=2)
	public java.lang.String getExpFlag(){
		return this.expFlag;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出口标识
	 */
	public void setExpFlag(java.lang.String expFlag){
		this.expFlag = expFlag;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  特殊合同描述
	 */
	@Column(name ="SPECIAL_DESC",nullable=true,precision=30,length=30)
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  支数
	 */
	@Column(name ="PIPENUM",nullable=true,precision=5,scale=0,length=2)
	public java.lang.Integer getPipenum(){
		return this.pipenum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  支数
	 */
	public void setPipenum(java.lang.Integer pipenum){
		this.pipenum = pipenum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  套装方式
	 */
	@Column(name ="SUIT_WAY",nullable=true,precision=30,length=30)
	public java.lang.String getSuitWay(){
		return this.suitWay;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  套装方式
	 */
	public void setSuitWay(java.lang.String suitWay){
		this.suitWay = suitWay;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  货位
	 */
	@Column(name ="HUOWEI",nullable=true,precision=10,length=10)
	public java.lang.String getHuowei(){
		return this.huowei;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  货位
	 */
	public void setHuowei(java.lang.String huowei){
		this.huowei = huowei;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  层号
	 */
	@Column(name ="CENGCI",nullable=true,precision=3,scale=0,length=1)
	public java.lang.Integer getCengci(){
		return this.cengci;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  层号
	 */
	public void setCengci(java.lang.Integer cengci){
		this.cengci = cengci;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  层序号
	 */
	@Column(name ="CENGNEIXUHAO",nullable=true,precision=3,scale=0,length=1)
	public java.lang.Integer getCengneixuhao(){
		return this.cengneixuhao;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  层序号
	 */
	public void setCengneixuhao(java.lang.Integer cengneixuhao){
		this.cengneixuhao = cengneixuhao;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  生产线
	 */
	@Column(name ="PRODUCT_LINE",nullable=true,precision=20,length=20)
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
	 *@return: java.lang.String  外键
	 */
	@Column(name ="MAIN_ID",nullable=true,precision=36,length=72)
	public java.lang.String getMainId(){
		return this.mainId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  外键
	 */
	public void setMainId(java.lang.String mainId){
		this.mainId = mainId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  pipeCode
	 */
	@Column(name ="PIPE_CODE",nullable=true,precision=50,length=100)
	public java.lang.String getPipeCode(){
		return this.pipeCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  pipeCode
	 */
	public void setPipeCode(java.lang.String pipeCode){
		this.pipeCode = pipeCode;
	}
}
