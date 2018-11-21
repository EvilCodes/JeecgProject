package com.yangjiang.entity.t_zgk_pipe_ck_hcz;

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
 * @Description: 火车装车
 * @author zhangdaihao
 * @date 2017-02-24 14:58:59
 * @version V1.0   
 *
 */
@Entity
@Table(name = "T_ZGK_PIPE_CK_HCZ", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class T_ZGK_PIPE_CK_HCZEntity implements java.io.Serializable {
	/**发货通知单号*/
	private java.lang.String billNoticeNo;
	/**发货通知单明细*/
	private java.lang.String billLadingNoItem;
	/**单号*/
	private java.lang.String sendNo;
	/**仓库名称*/
	private java.lang.String outWhouseName;
	/**备注*/
	private java.lang.String remark;
	/**产品编码*/
	private java.lang.String itemCode;
	/**产品名称*/
	private java.lang.String itemCname;
	/**车皮型号代码*/
	private java.lang.String blockSize;
	/**车皮型号*/
	private java.lang.String blockSizeName;
	/**车号*/
	private java.lang.String blockNo;
	/**保管员*/
	private java.lang.String stockPerson;
	/**发货支数*/
	private java.lang.Integer planNum;
	/**发货重量*/
	private java.lang.Double planWt;
	/**发货时间*/
	private java.util.Date sendTime;
	/**短尺标志*/
	private java.lang.String noSameMark;
	/**样品管标志*/
	private java.lang.String sample;
	/**箱号*/
	private java.lang.String boxNo;
	/**审核标志*/
	private java.lang.String shbz;
	/**审核人*/
	private java.lang.String shr;
	/**审核时间*/
	private java.util.Date shsj;
	/**提交时间*/
	private java.util.Date riqi;
	

	/**读取标志*/
	private java.lang.String readFlag;
	/**到站*/
	private java.lang.String delivyPlaceName;
	/**专线名称*/
	private java.lang.String privateRouteName;
	/**销售公司*/
	private java.lang.String orgName;
	/**收货单位*/
	private java.lang.String consignCname;
	/**保管员*/
	private java.lang.String baoguanyuan;
	/**编号*/
	private java.lang.String id;
	@Column(name ="baoguanyuan",nullable=true,precision=20,length=20)
	public java.lang.String getBaoguanyuan() {
		return baoguanyuan;
	}

	public void setBaoguanyuan(java.lang.String baoguanyuan) {
		this.baoguanyuan = baoguanyuan;
	}

	@Column(name ="riqi",nullable=true,precision=20,length=20)
	public java.util.Date getRiqi() {
		return riqi;
	}

	public void setRiqi(java.util.Date riqi) {
		this.riqi = riqi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发货通知单号
	 */
	@Column(name ="BILL_NOTICE_NO",nullable=true,precision=20,length=20)
	public java.lang.String getBillNoticeNo(){
		return this.billNoticeNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发货通知单号
	 */
	public void setBillNoticeNo(java.lang.String billNoticeNo){
		this.billNoticeNo = billNoticeNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发货通知单明细
	 */
	@Column(name ="BILL_LADING_NO_ITEM",nullable=true,precision=30,length=30)
	public java.lang.String getBillLadingNoItem(){
		return this.billLadingNoItem;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发货通知单明细
	 */
	public void setBillLadingNoItem(java.lang.String billLadingNoItem){
		this.billLadingNoItem = billLadingNoItem;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单号
	 */
	@Column(name ="SEND_NO",nullable=false,precision=20,length=20)
	public java.lang.String getSendNo(){
		return this.sendNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单号
	 */
	public void setSendNo(java.lang.String sendNo){
		this.sendNo = sendNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仓库名称
	 */
	@Column(name ="OUT_WHOUSE_NAME",nullable=true,precision=20,length=20)
	public java.lang.String getOutWhouseName(){
		return this.outWhouseName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仓库名称
	 */
	public void setOutWhouseName(java.lang.String outWhouseName){
		this.outWhouseName = outWhouseName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARK",nullable=true,precision=300,length=300)
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
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
	 *@return: java.lang.String  车皮型号代码
	 */
	@Column(name ="BLOCK_SIZE",nullable=true,precision=3,length=3)
	public java.lang.String getBlockSize(){
		return this.blockSize;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车皮型号代码
	 */
	public void setBlockSize(java.lang.String blockSize){
		this.blockSize = blockSize;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车皮型号
	 */
	@Column(name ="BLOCK_SIZE_NAME",nullable=true,precision=50,length=50)
	public java.lang.String getBlockSizeName(){
		return this.blockSizeName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车皮型号
	 */
	public void setBlockSizeName(java.lang.String blockSizeName){
		this.blockSizeName = blockSizeName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车号
	 */
	@Column(name ="BLOCK_NO",nullable=true,precision=20,length=20)
	public java.lang.String getBlockNo(){
		return this.blockNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车号
	 */
	public void setBlockNo(java.lang.String blockNo){
		this.blockNo = blockNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  保管员
	 */
	@Column(name ="STOCK_PERSON",nullable=true,precision=20,length=20)
	public java.lang.String getStockPerson(){
		return this.stockPerson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  保管员
	 */
	public void setStockPerson(java.lang.String stockPerson){
		this.stockPerson = stockPerson;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  发货支数
	 */
	@Column(name ="PLAN_NUM",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getPlanNum(){
		return this.planNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  发货支数
	 */
	public void setPlanNum(java.lang.Integer planNum){
		this.planNum = planNum;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  发货重量
	 */
	@Column(name ="PLAN_WT",nullable=true,precision=13,scale=6,length=9)
	public java.lang.Double getPlanWt(){
		return this.planWt;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  发货重量
	 */
	public void setPlanWt(java.lang.Double d){
		this.planWt = d;
		
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  发货时间
	 */
	@Column(name ="SEND_TIME",nullable=true,precision=23,scale=3,length=8)
	public java.util.Date getSendTime(){
		return this.sendTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  发货时间
	 */
	public void setSendTime(java.util.Date sendTime){
		this.sendTime = sendTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  短尺标志
	 */
	@Column(name ="NO_SAME_MARK",nullable=true,precision=1,length=1)
	public java.lang.String getNoSameMark(){
		return this.noSameMark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  短尺标志
	 */
	public void setNoSameMark(java.lang.String noSameMark){
		this.noSameMark = noSameMark;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  样品管标志
	 */
	@Column(name ="SAMPLE",nullable=true,precision=1,length=1)
	public java.lang.String getSample(){
		return this.sample;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  样品管标志
	 */
	public void setSample(java.lang.String sample){
		this.sample = sample;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  箱号
	 */
	@Column(name ="BOX_NO",nullable=true,precision=20,length=20)
	public java.lang.String getBoxNo(){
		return this.boxNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  箱号
	 */
	public void setBoxNo(java.lang.String boxNo){
		this.boxNo = boxNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核标志
	 */
	@Column(name ="SHBZ",nullable=true,precision=1,length=1)
	public java.lang.String getShbz(){
		return this.shbz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核标志
	 */
	public void setShbz(java.lang.String shbz){
		this.shbz = shbz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核人
	 */
	@Column(name ="SHR",nullable=true,precision=20,length=20)
	public java.lang.String getShr(){
		return this.shr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核人
	 */
	public void setShr(java.lang.String shr){
		this.shr = shr;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  审核时间
	 */
	@Column(name ="SHSJ",nullable=true,precision=23,scale=3,length=8)
	public java.util.Date getShsj(){
		return this.shsj;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  审核时间
	 */
	public void setShsj(java.util.Date shsj){
		this.shsj = shsj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  读取标志
	 */
	@Column(name ="READ_FLAG",nullable=true,precision=1,length=1)
	public java.lang.String getReadFlag(){
		return this.readFlag;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  读取标志
	 */
	public void setReadFlag(java.lang.String readFlag){
		this.readFlag = readFlag;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  到站
	 */
	@Column(name ="DELIVY_PLACE_NAME",nullable=true,precision=200,length=200)
	public java.lang.String getDelivyPlaceName(){
		return this.delivyPlaceName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  到站
	 */
	public void setDelivyPlaceName(java.lang.String delivyPlaceName){
		this.delivyPlaceName = delivyPlaceName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  专线名称
	 */
	@Column(name ="PRIVATE_ROUTE_NAME",nullable=true,precision=200,length=200)
	public java.lang.String getPrivateRouteName(){
		return this.privateRouteName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专线名称
	 */
	public void setPrivateRouteName(java.lang.String privateRouteName){
		this.privateRouteName = privateRouteName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  销售公司
	 */
	@Column(name ="ORG_NAME",nullable=true,precision=100,length=100)
	public java.lang.String getOrgName(){
		return this.orgName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  销售公司
	 */
	public void setOrgName(java.lang.String orgName){
		this.orgName = orgName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收货单位
	 */
	@Column(name ="CONSIGN_CNAME",nullable=true,precision=200,length=200)
	public java.lang.String getConsignCname(){
		return this.consignCname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收货单位
	 */
	public void setConsignCname(java.lang.String consignCname){
		this.consignCname = consignCname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编号
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
	 *@param: java.lang.String  编号
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
}
