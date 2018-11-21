package com.yangjiang.entity.t_myjk_fyjh;

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
 * @Description: 发运计划审核
 * @author zhangdaihao
 * @date 2016-11-03 16:48:54
 * @version V1.0   
 *
 */
@Entity
@Table(name = "T_MYJK_FYJH", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class T_MYJK_FYJHEntity implements java.io.Serializable {
	/**发货通知单号*/
	private java.lang.String billNoticeNo;
	/**发货通知单明细号*/
	private java.lang.String billLadingNoItem;
	/**发货通知单状态*/
	private java.lang.String planStatus;
	/**内外销标志*/
	private java.lang.String expFlag;
	/**合同号*/
	private java.lang.String contractNo;
	/**合同子项号*/
	private java.lang.String orderNo;
	/**批次号*/
	private java.lang.String schedulingNo;
	/**交货日期*/
	private java.lang.String delivyDate;
	/**交货地点代码*/
	private java.lang.String delivyPlaceCode;
	/**交货地点名称*/
	private java.lang.String delivyPlaceName;
	/**专用线代码*/
	private java.lang.String privateRouteCode;
	/**专用线名称*/
	private java.lang.String privateRouteName;
	/**运输方式代码*/
	private java.lang.String trnpModeCode;
	/**运输方式名称*/
	private java.lang.String trnpMode;
	/**发货组织机构代码*/
	private java.lang.String outOrgCode;
	/**发货组织机构名称*/
	private java.lang.String outOrgName;
	/**发货库房代码*/
	private java.lang.String outStorehouseCode;
	/**发货库房*/
	private java.lang.String outStorehouseName;
	/**入库组织机构代码*/
	private java.lang.String inOrgCode;
	/**入库组织机构名称*/
	private java.lang.String inOrgName;
	/**入库仓库代码*/
	private java.lang.String inWhouseCode;
	/**入库仓库名称*/
	private java.lang.String inWhouseName;
	/**收货地点*/
	private java.lang.String recAdd;
	/**收货联系人*/
	private java.lang.String recPerson;
	/**收货人联系电话*/
	private java.lang.String recTel;
	/**组织机构名称*/
	private java.lang.String orgName;
	/**收货单位名称*/
	private java.lang.String consignCname;
	/**销售人员名称*/
	private java.lang.String salePersonName;
	/**销售人员电话*/
	private java.lang.String mobilePhone;
	/**备注*/
	private java.lang.String remark;
	/**套装要求*/
	private java.lang.String suitFlag;
	/**产品编码*/
	private java.lang.String itemCode;
	/**产品名称*/
	private java.lang.String itemCname;
	/**计划件数*/
	private BigDecimal planNum;
	/**计划重量*/
	private BigDecimal planWt;
	/**包装方式*/
	private java.lang.String packageWay;
	/**特殊产品描述 */
	private java.lang.String specialDesc;
	/**胶圈指定生产厂代码*/
	private java.lang.String itemFactoryCode;
	/**胶圈指定生产厂名称*/
	private java.lang.String itemFactoryName;
	/**读取标识*/
	private java.lang.String readFlag;
	/**插入日期*/
	private java.util.Date insertDate;
	/**更新标识*/
	private java.lang.String updateflag;
	/**主运号*/
	private java.lang.String carryNo;
	/**编码*/
	private java.lang.String id;
	/**总发运数量*/
	private java.lang.Integer totalTransportNum;
	/**总发运重量*/
	private BigDecimal totaltransportwt;
	/**审核标记*/
	private java.lang.String auditflag;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发货通知单号
	 */
	@Column(name ="BILL_NOTICE_NO",nullable=false,precision=20,length=20)
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
	 *@return: java.lang.String  发货通知单明细号
	 */
	@Column(name ="BILL_LADING_NO_ITEM",nullable=false,precision=25,length=25)
	public java.lang.String getBillLadingNoItem(){
		return this.billLadingNoItem;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发货通知单明细号
	 */
	public void setBillLadingNoItem(java.lang.String billLadingNoItem){
		this.billLadingNoItem = billLadingNoItem;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发货通知单状态
	 */
	@Column(name ="PLAN_STATUS",nullable=false,precision=2,length=2)
	public java.lang.String getPlanStatus(){
		return this.planStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发货通知单状态
	 */
	public void setPlanStatus(java.lang.String planStatus){
		this.planStatus = planStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  内外销标志
	 */
	@Column(name ="EXP_FLAG",nullable=true,precision=2,length=2)
	public java.lang.String getExpFlag(){
		return this.expFlag;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内外销标志
	 */
	public void setExpFlag(java.lang.String expFlag){
		this.expFlag = expFlag;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同号
	 */
	@Column(name ="CONTRACT_NO",nullable=true,precision=20,length=20)
	public java.lang.String getContractNo(){
		return this.contractNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同号
	 */
	public void setContractNo(java.lang.String contractNo){
		this.contractNo = contractNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同子项号
	 */
	@Column(name ="ORDER_NO",nullable=true,precision=20,length=20)
	public java.lang.String getOrderNo(){
		return this.orderNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同子项号
	 */
	public void setOrderNo(java.lang.String orderNo){
		this.orderNo = orderNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  批次号
	 */
	@Column(name ="SCHEDULING_NO",nullable=true,precision=20,length=20)
	public java.lang.String getSchedulingNo(){
		return this.schedulingNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  批次号
	 */
	public void setSchedulingNo(java.lang.String schedulingNo){
		this.schedulingNo = schedulingNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  交货日期
	 */
	@Column(name ="DELIVY_DATE",nullable=true,precision=20,length=20)
	public java.lang.String getDelivyDate(){
		return this.delivyDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交货日期
	 */
	public void setDelivyDate(java.lang.String delivyDate){
		this.delivyDate = delivyDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  交货地点代码
	 */
	@Column(name ="DELIVY_PLACE_CODE",nullable=true,precision=20,length=20)
	public java.lang.String getDelivyPlaceCode(){
		return this.delivyPlaceCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交货地点代码
	 */
	public void setDelivyPlaceCode(java.lang.String delivyPlaceCode){
		this.delivyPlaceCode = delivyPlaceCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  交货地点名称
	 */
	@Column(name ="DELIVY_PLACE_NAME",nullable=true,precision=200,length=200)
	public java.lang.String getDelivyPlaceName(){
		return this.delivyPlaceName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交货地点名称
	 */
	public void setDelivyPlaceName(java.lang.String delivyPlaceName){
		this.delivyPlaceName = delivyPlaceName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  专用线代码
	 */
	@Column(name ="PRIVATE_ROUTE_CODE",nullable=true,precision=20,length=20)
	public java.lang.String getPrivateRouteCode(){
		return this.privateRouteCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专用线代码
	 */
	public void setPrivateRouteCode(java.lang.String privateRouteCode){
		this.privateRouteCode = privateRouteCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  专用线名称
	 */
	@Column(name ="PRIVATE_ROUTE_NAME",nullable=true,precision=200,length=200)
	public java.lang.String getPrivateRouteName(){
		return this.privateRouteName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专用线名称
	 */
	public void setPrivateRouteName(java.lang.String privateRouteName){
		this.privateRouteName = privateRouteName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  运输方式代码
	 */
	@Column(name ="TRNP_MODE_CODE",nullable=true,precision=4,length=4)
	public java.lang.String getTrnpModeCode(){
		return this.trnpModeCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  运输方式代码
	 */
	public void setTrnpModeCode(java.lang.String trnpModeCode){
		this.trnpModeCode = trnpModeCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  运输方式名称
	 */
	@Column(name ="TRNP_MODE",nullable=true,precision=20,length=20)
	public java.lang.String getTrnpMode(){
		return this.trnpMode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  运输方式名称
	 */
	public void setTrnpMode(java.lang.String trnpMode){
		this.trnpMode = trnpMode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发货组织机构代码
	 */
	@Column(name ="OUT_ORG_CODE",nullable=true,precision=20,length=20)
	public java.lang.String getOutOrgCode(){
		return this.outOrgCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发货组织机构代码
	 */
	public void setOutOrgCode(java.lang.String outOrgCode){
		this.outOrgCode = outOrgCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发货组织机构名称
	 */
	@Column(name ="OUT_ORG_NAME",nullable=true,precision=200,length=200)
	public java.lang.String getOutOrgName(){
		return this.outOrgName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发货组织机构名称
	 */
	public void setOutOrgName(java.lang.String outOrgName){
		this.outOrgName = outOrgName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发货库房代码
	 */
	@Column(name ="OUT_STOREHOUSE_CODE",nullable=true,precision=20,length=20)
	public java.lang.String getOutStorehouseCode(){
		return this.outStorehouseCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发货库房代码
	 */
	public void setOutStorehouseCode(java.lang.String outStorehouseCode){
		this.outStorehouseCode = outStorehouseCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发货库房
	 */
	@Column(name ="OUT_STOREHOUSE_NAME",nullable=true,precision=200,length=200)
	public java.lang.String getOutStorehouseName(){
		return this.outStorehouseName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发货库房
	 */
	public void setOutStorehouseName(java.lang.String outStorehouseName){
		this.outStorehouseName = outStorehouseName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入库组织机构代码
	 */
	@Column(name ="IN_ORG_CODE",nullable=true,precision=20,length=20)
	public java.lang.String getInOrgCode(){
		return this.inOrgCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入库组织机构代码
	 */
	public void setInOrgCode(java.lang.String inOrgCode){
		this.inOrgCode = inOrgCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入库组织机构名称
	 */
	@Column(name ="IN_ORG_NAME",nullable=true,precision=200,length=200)
	public java.lang.String getInOrgName(){
		return this.inOrgName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入库组织机构名称
	 */
	public void setInOrgName(java.lang.String inOrgName){
		this.inOrgName = inOrgName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入库仓库代码
	 */
	@Column(name ="IN_WHOUSE_CODE",nullable=true,precision=20,length=20)
	public java.lang.String getInWhouseCode(){
		return this.inWhouseCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入库仓库代码
	 */
	public void setInWhouseCode(java.lang.String inWhouseCode){
		this.inWhouseCode = inWhouseCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入库仓库名称
	 */
	@Column(name ="IN_WHOUSE_NAME",nullable=true,precision=200,length=200)
	public java.lang.String getInWhouseName(){
		return this.inWhouseName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入库仓库名称
	 */
	public void setInWhouseName(java.lang.String inWhouseName){
		this.inWhouseName = inWhouseName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收货地点
	 */
	@Column(name ="REC_ADD",nullable=true,precision=200,length=200)
	public java.lang.String getRecAdd(){
		return this.recAdd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收货地点
	 */
	public void setRecAdd(java.lang.String recAdd){
		this.recAdd = recAdd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收货联系人
	 */
	@Column(name ="REC_PERSON",nullable=true,precision=100,length=100)
	public java.lang.String getRecPerson(){
		return this.recPerson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收货联系人
	 */
	public void setRecPerson(java.lang.String recPerson){
		this.recPerson = recPerson;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收货人联系电话
	 */
	@Column(name ="REC_TEL",nullable=true,precision=100,length=100)
	public java.lang.String getRecTel(){
		return this.recTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收货人联系电话
	 */
	public void setRecTel(java.lang.String recTel){
		this.recTel = recTel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  组织机构名称
	 */
	@Column(name ="ORG_NAME",nullable=true,precision=100,length=100)
	public java.lang.String getOrgName(){
		return this.orgName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  组织机构名称
	 */
	public void setOrgName(java.lang.String orgName){
		this.orgName = orgName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收货单位名称
	 */
	@Column(name ="CONSIGN_CNAME",nullable=true,precision=200,length=200)
	public java.lang.String getConsignCname(){
		return this.consignCname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收货单位名称
	 */
	public void setConsignCname(java.lang.String consignCname){
		this.consignCname = consignCname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  销售人员名称
	 */
	@Column(name ="SALE_PERSON_NAME",nullable=true,precision=100,length=100)
	public java.lang.String getSalePersonName(){
		return this.salePersonName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  销售人员名称
	 */
	public void setSalePersonName(java.lang.String salePersonName){
		this.salePersonName = salePersonName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  销售人员电话
	 */
	@Column(name ="MOBILE_PHONE",nullable=true,precision=100,length=100)
	public java.lang.String getMobilePhone(){
		return this.mobilePhone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  销售人员电话
	 */
	public void setMobilePhone(java.lang.String mobilePhone){
		this.mobilePhone = mobilePhone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARK",nullable=true,precision=500,length=500)
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
	 *@return: java.lang.String  套装要求
	 */
	@Column(name ="SUIT_FLAG",nullable=true,precision=200,length=200)
	public java.lang.String getSuitFlag(){
		return this.suitFlag;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  套装要求
	 */
	public void setSuitFlag(java.lang.String suitFlag){
		this.suitFlag = suitFlag;
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
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  计划件数
	 */
	@Column(name ="PLAN_NUM",nullable=true,precision=6,scale=0,length=5)
	public BigDecimal getPlanNum(){
		return this.planNum;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  计划件数
	 */
	public void setPlanNum(BigDecimal planNum){
		this.planNum = planNum;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  计划重量
	 */
	@Column(name ="PLAN_WT",nullable=true,precision=20,scale=6,length=13)
	public BigDecimal getPlanWt(){
		return this.planWt;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  计划重量
	 */
	public void setPlanWt(BigDecimal planWt){
		this.planWt = planWt;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  包装方式
	 */
	@Column(name ="PACKAGE_WAY",nullable=true,precision=50,length=50)
	public java.lang.String getPackageWay(){
		return this.packageWay;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  包装方式
	 */
	public void setPackageWay(java.lang.String packageWay){
		this.packageWay = packageWay;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  特殊产品描述 
	 */
	@Column(name ="SPECIAL_DESC",nullable=true,precision=500,length=500)
	public java.lang.String getSpecialDesc(){
		return this.specialDesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  特殊产品描述 
	 */
	public void setSpecialDesc(java.lang.String specialDesc){
		this.specialDesc = specialDesc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  胶圈指定生产厂代码
	 */
	@Column(name ="ITEM_FACTORY_CODE",nullable=true,precision=20,length=20)
	public java.lang.String getItemFactoryCode(){
		return this.itemFactoryCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  胶圈指定生产厂代码
	 */
	public void setItemFactoryCode(java.lang.String itemFactoryCode){
		this.itemFactoryCode = itemFactoryCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  胶圈指定生产厂名称
	 */
	@Column(name ="ITEM_FACTORY_NAME",nullable=true,precision=50,length=50)
	public java.lang.String getItemFactoryName(){
		return this.itemFactoryName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  胶圈指定生产厂名称
	 */
	public void setItemFactoryName(java.lang.String itemFactoryName){
		this.itemFactoryName = itemFactoryName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  读取标识
	 */
	@Column(name ="READ_FLAG",nullable=true,precision=2,length=2)
	public java.lang.String getReadFlag(){
		return this.readFlag;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  读取标识
	 */
	public void setReadFlag(java.lang.String readFlag){
		this.readFlag = readFlag;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  插入日期
	 */
	@Column(name ="INSERT_DATE",nullable=true,precision=23,scale=3,length=8)
	public java.util.Date getInsertDate(){
		return this.insertDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  插入日期
	 */
	public void setInsertDate(java.util.Date insertDate){
		this.insertDate = insertDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新标识
	 */
	@Column(name ="UPDATEFLAG",nullable=true,precision=1,length=1)
	public java.lang.String getUpdateflag(){
		return this.updateflag;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新标识
	 */
	public void setUpdateflag(java.lang.String updateflag){
		this.updateflag = updateflag;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主运号
	 */
	@Column(name ="CARRY_NO",nullable=true,precision=10,length=10)
	public java.lang.String getCarryNo(){
		return this.carryNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主运号
	 */
	public void setCarryNo(java.lang.String carryNo){
		this.carryNo = carryNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编码
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,precision=36,length=72)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  编码
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  总发运数量
	 */
	@Column(name ="TOTALTRANSPORTNUM",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getTotaltransportnum(){
		return this.totalTransportNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  总发运数量
	 */
	public void setTotaltransportnum(java.lang.Integer totaltransportnum){
		this.totalTransportNum = totaltransportnum;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  总发运重量
	 */
	@Column(name ="TOTALTRANSPORTWT",nullable=true,precision=20,scale=0,length=13)
	public BigDecimal getTotaltransportwt(){
		return this.totaltransportwt;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  总发运重量
	 */
	public void setTotaltransportwt(BigDecimal totaltransportwt){
		this.totaltransportwt = totaltransportwt;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核标记
	 */
	@Column(name ="AUDITFLAG",nullable=true,precision=8,length=8)
	public java.lang.String getAuditflag(){
		return this.auditflag;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核标记
	 */
	public void setAuditflag(java.lang.String auditflag){
		this.auditflag = auditflag;
	}
}
