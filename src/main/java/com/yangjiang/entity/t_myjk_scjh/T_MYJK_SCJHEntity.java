package com.yangjiang.entity.t_myjk_scjh;

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
 * @Description: 生产计划
 * @author zhangdaihao
 * @date 2017-01-16 17:03:54
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_myjk_scjh", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class T_MYJK_SCJHEntity implements java.io.Serializable {
	/**生产计划号*/
	private java.lang.String productPlanNo;
	/**合约号*/
	private java.lang.String contractNo;
	/**合同号*/
	private java.lang.String orderNo;
	/**合约简称*/
	private java.lang.String contractDesc;
	/**内外销标识*/
	private java.lang.String expFlag;
	/**年份*/
	private java.lang.String year;
	/**月份*/
	private java.lang.String month;
	/**产品代码*/
	private java.lang.String itemCode;
	/**产品中文名称*/
	private java.lang.String itemCname;
	/**产品英文名称*/
	private java.lang.String itemEname;
	/**工业区代码*/
	private java.lang.String factoryCode;
	/**工业区名称*/
	private java.lang.String factoryName;
	/**批复生产数量*/
	private java.lang.Integer launchCount;
	/**批复生产重量*/
	private BigDecimal launchWeight;
	/**套装方式*/
	private java.lang.String suitMode;
	/**套装数量*/
	private java.lang.Integer suitCount;
	/**生产计划编制人*/
	private java.lang.String planPerson;
	/**生产计划编制日期*/
	private java.lang.String planCerateDate;
	/**计划下达日期*/
	private java.lang.String planLaunchDate;
	/**交付截止日期*/
	private java.lang.String planDeliveryDate;
	/**销售机构代码*/
	private java.lang.String saleDept;
	/**销售机构名称*/
	private java.lang.String saleDeptName;
	/**订货用户代码*/
	private java.lang.String orderUserNum;
	/**订货用户中文名称*/
	private java.lang.String orderUserCname;
	/**订货用户英文名称*/
	private java.lang.String orderUserEname;
	/**内防腐执行标准序码*/
	private java.lang.String liningStdSeq;
	/**内防腐执行标准描述*/
	private java.lang.String liningStdDesc;
	/**内防腐终饰层厚度序码*/
	private java.lang.String liningTkSeq;
	/**内防腐终饰层厚度描述*/
	private java.lang.String liningTkDesc;
	/**喷锌标准序码*/
	private java.lang.String zincStdSeq;
	/**喷锌标准描述*/
	private java.lang.String zincStdDesc;
	/**外防腐终饰层厚度序码*/
	private java.lang.String coatTkSeq;
	/**外防腐终饰层厚度描述*/
	private java.lang.String coatTkDesc;
	/**外防腐执行标准序码*/
	private java.lang.String coatStdSeq;
	/**外防腐执行标准描述*/
	private java.lang.String coatStdDesc;
	/**承口内部终饰层材料序码*/
	private java.lang.String bellMaterialSeq;
	/**承口内部终饰层材料描述*/
	private java.lang.String bellMaterialDesc;
	/**承口内部终饰层厚度序码*/
	private java.lang.String bellTkSeq;
	/**承口内部终饰层厚度描述*/
	private java.lang.String bellTkDesc;
	/**插口端终饰层材料序码*/
	private java.lang.String jackMaterialSeq;
	/**插口端终饰层材料描述*/
	private java.lang.String jackMaterialDesc;
	/**插口端终饰层厚度序码*/
	private java.lang.String jackTkSeq;
	/**插口端终饰层厚度描述*/
	private java.lang.String jackTkDesc;
	/**排产单号(外销排产)*/
	private java.lang.String schedulingNo;
	/**申报单位代码(外销排产)*/
	private java.lang.String reportUserNum;
	/**申报单位中文名(外销排产)*/
	private java.lang.String reportUserCname;
	/**结算单位代码(外销排产)*/
	private java.lang.String settleUserNum;
	/**结算单位中文名(外销排产)*/
	private java.lang.String settleUserCname;
	/**申报时间(外销排产)*/
	private java.lang.String reportTime;
	/**最终销售地(外销排产)*/
	private java.lang.String saleGround;
	/**采购商(外销排产)*/
	private java.lang.String buyers;
	/**交货日期(外销排产)*/
	private java.lang.String deliveryDate;
	/**交货地点(外销排产)*/
	private java.lang.String deliveryPlace;
	/**运输方式代码(外销排产)*/
	private java.lang.String trnpModeCode;
	/**运输方式描述(外销排产)*/
	private java.lang.String trnpModeName;
	/**需求程度(外销排产)*/
	private java.lang.String requireLevel;
	/**技术要求(外销排产)*/
	private java.lang.String technicalDemand;
	/**包装要求(外销排产)*/
	private java.lang.String packingDemand;
	/**包装唛头(外销排产)*/
	private java.lang.String shippingMark;
	/**运输唛头(外销排产)*/
	private java.lang.String trnpModeMark;
	/**质保书(外销排产)*/
	private java.lang.String millCertificate;
	/**商检(外销排产)*/
	private java.lang.String inspection;
	/**排产单总金额(外销排产)*/
	private BigDecimal schedulingAmt;
	/**特殊合同描述*/
	private java.lang.String specialDesc;
	/**备注*/
	private java.lang.String remark;
	/**附件路径*/
	private java.lang.String annexPath;
	/**插入时间*/
	private java.util.Date insertDate;
	/**生产单位*/
	private java.lang.String scdw;
	/**审核人*/
	private java.lang.String shr;
	/**审核部门*/
	private java.lang.String shbm;
	/**审核时间*/
	private java.util.Date shsj;
	/**计划类型*/
	private java.lang.String planType;
	/**编号*/
	private java.lang.String id;
	/**审核结果*/
	private java.lang.String auditresult;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  生产计划号
	 */
	@Column(name ="PRODUCT_PLAN_NO",nullable=false,precision=20,length=20)
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
	 *@return: java.lang.String  合约号
	 */
	@Column(name ="CONTRACT_NO",nullable=true,precision=20,length=20)
	public java.lang.String getContractNo(){
		return this.contractNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合约号
	 */
	public void setContractNo(java.lang.String contractNo){
		this.contractNo = contractNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同号
	 */
	@Column(name ="ORDER_NO",nullable=true,precision=25,length=25)
	public java.lang.String getOrderNo(){
		return this.orderNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同号
	 */
	public void setOrderNo(java.lang.String orderNo){
		this.orderNo = orderNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合约简称
	 */
	@Column(name ="CONTRACT_DESC",nullable=true,precision=200,length=200)
	public java.lang.String getContractDesc(){
		return this.contractDesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合约简称
	 */
	public void setContractDesc(java.lang.String contractDesc){
		this.contractDesc = contractDesc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  内外销标识
	 */
	@Column(name ="EXP_FLAG",nullable=true,precision=2,length=2)
	public java.lang.String getExpFlag(){
		return this.expFlag;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内外销标识
	 */
	public void setExpFlag(java.lang.String expFlag){
		this.expFlag = expFlag;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  年份
	 */
	@Column(name ="YEAR",nullable=true,precision=4,length=4)
	public java.lang.String getYear(){
		return this.year;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  年份
	 */
	public void setYear(java.lang.String year){
		this.year = year;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  月份
	 */
	@Column(name ="MONTH",nullable=true,precision=2,length=2)
	public java.lang.String getMonth(){
		return this.month;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  月份
	 */
	public void setMonth(java.lang.String month){
		this.month = month;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品代码
	 */
	@Column(name ="ITEM_CODE",nullable=true,precision=20,length=20)
	public java.lang.String getItemCode(){
		return this.itemCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品代码
	 */
	public void setItemCode(java.lang.String itemCode){
		this.itemCode = itemCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品中文名称
	 */
	@Column(name ="ITEM_CNAME",nullable=true,precision=200,length=200)
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
	 *@return: java.lang.String  产品英文名称
	 */
	@Column(name ="ITEM_ENAME",nullable=true,precision=200,length=200)
	public java.lang.String getItemEname(){
		return this.itemEname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品英文名称
	 */
	public void setItemEname(java.lang.String itemEname){
		this.itemEname = itemEname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工业区代码
	 */
	@Column(name ="FACTORY_CODE",nullable=true,precision=10,length=10)
	public java.lang.String getFactoryCode(){
		return this.factoryCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工业区代码
	 */
	public void setFactoryCode(java.lang.String factoryCode){
		this.factoryCode = factoryCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工业区名称
	 */
	@Column(name ="FACTORY_NAME",nullable=true,precision=20,length=20)
	public java.lang.String getFactoryName(){
		return this.factoryName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工业区名称
	 */
	public void setFactoryName(java.lang.String factoryName){
		this.factoryName = factoryName;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  批复生产数量
	 */
	@Column(name ="LAUNCH_COUNT",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getLaunchCount(){
		return this.launchCount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  批复生产数量
	 */
	public void setLaunchCount(java.lang.Integer launchCount){
		this.launchCount = launchCount;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  批复生产重量
	 */
	@Column(name ="LAUNCH_WEIGHT",nullable=true,precision=16,scale=4,length=9)
	public BigDecimal getLaunchWeight(){
		return this.launchWeight;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  批复生产重量
	 */
	public void setLaunchWeight(BigDecimal launchWeight){
		this.launchWeight = launchWeight;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  套装方式
	 */
	@Column(name ="SUIT_MODE",nullable=true,precision=64,length=64)
	public java.lang.String getSuitMode(){
		return this.suitMode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  套装方式
	 */
	public void setSuitMode(java.lang.String suitMode){
		this.suitMode = suitMode;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  套装数量
	 */
	@Column(name ="SUIT_COUNT",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getSuitCount(){
		return this.suitCount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  套装数量
	 */
	public void setSuitCount(java.lang.Integer suitCount){
		this.suitCount = suitCount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  生产计划编制人
	 */
	@Column(name ="PLAN_PERSON",nullable=true,precision=16,length=16)
	public java.lang.String getPlanPerson(){
		return this.planPerson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  生产计划编制人
	 */
	public void setPlanPerson(java.lang.String planPerson){
		this.planPerson = planPerson;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  生产计划编制日期
	 */
	@Column(name ="PLAN_CERATE_DATE",nullable=true,precision=14,length=14)
	public java.lang.String getPlanCerateDate(){
		return this.planCerateDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  生产计划编制日期
	 */
	public void setPlanCerateDate(java.lang.String planCerateDate){
		this.planCerateDate = planCerateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计划下达日期
	 */
	@Column(name ="PLAN_LAUNCH_DATE",nullable=true,precision=14,length=14)
	public java.lang.String getPlanLaunchDate(){
		return this.planLaunchDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计划下达日期
	 */
	public void setPlanLaunchDate(java.lang.String planLaunchDate){
		this.planLaunchDate = planLaunchDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  交付截止日期
	 */
	@Column(name ="PLAN_DELIVERY_DATE",nullable=true,precision=14,length=14)
	public java.lang.String getPlanDeliveryDate(){
		return this.planDeliveryDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交付截止日期
	 */
	public void setPlanDeliveryDate(java.lang.String planDeliveryDate){
		this.planDeliveryDate = planDeliveryDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  销售机构代码
	 */
	@Column(name ="SALE_DEPT",nullable=true,precision=16,length=16)
	public java.lang.String getSaleDept(){
		return this.saleDept;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  销售机构代码
	 */
	public void setSaleDept(java.lang.String saleDept){
		this.saleDept = saleDept;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  销售机构名称
	 */
	@Column(name ="SALE_DEPT_NAME",nullable=true,precision=64,length=64)
	public java.lang.String getSaleDeptName(){
		return this.saleDeptName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  销售机构名称
	 */
	public void setSaleDeptName(java.lang.String saleDeptName){
		this.saleDeptName = saleDeptName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  订货用户代码
	 */
	@Column(name ="ORDER_USER_NUM",nullable=true,precision=10,length=10)
	public java.lang.String getOrderUserNum(){
		return this.orderUserNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订货用户代码
	 */
	public void setOrderUserNum(java.lang.String orderUserNum){
		this.orderUserNum = orderUserNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  订货用户中文名称
	 */
	@Column(name ="ORDER_USER_CNAME",nullable=true,precision=200,length=200)
	public java.lang.String getOrderUserCname(){
		return this.orderUserCname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订货用户中文名称
	 */
	public void setOrderUserCname(java.lang.String orderUserCname){
		this.orderUserCname = orderUserCname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  订货用户英文名称
	 */
	@Column(name ="ORDER_USER_ENAME",nullable=true,precision=200,length=200)
	public java.lang.String getOrderUserEname(){
		return this.orderUserEname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订货用户英文名称
	 */
	public void setOrderUserEname(java.lang.String orderUserEname){
		this.orderUserEname = orderUserEname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  内防腐执行标准序码
	 */
	@Column(name ="LINING_STD_SEQ",nullable=true,precision=2,length=2)
	public java.lang.String getLiningStdSeq(){
		return this.liningStdSeq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内防腐执行标准序码
	 */
	public void setLiningStdSeq(java.lang.String liningStdSeq){
		this.liningStdSeq = liningStdSeq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  内防腐执行标准描述
	 */
	@Column(name ="LINING_STD_DESC",nullable=true,precision=60,length=60)
	public java.lang.String getLiningStdDesc(){
		return this.liningStdDesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内防腐执行标准描述
	 */
	public void setLiningStdDesc(java.lang.String liningStdDesc){
		this.liningStdDesc = liningStdDesc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  内防腐终饰层厚度序码
	 */
	@Column(name ="LINING_TK_SEQ",nullable=true,precision=2,length=2)
	public java.lang.String getLiningTkSeq(){
		return this.liningTkSeq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内防腐终饰层厚度序码
	 */
	public void setLiningTkSeq(java.lang.String liningTkSeq){
		this.liningTkSeq = liningTkSeq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  内防腐终饰层厚度描述
	 */
	@Column(name ="LINING_TK_DESC",nullable=true,precision=60,length=60)
	public java.lang.String getLiningTkDesc(){
		return this.liningTkDesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内防腐终饰层厚度描述
	 */
	public void setLiningTkDesc(java.lang.String liningTkDesc){
		this.liningTkDesc = liningTkDesc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  喷锌标准序码
	 */
	@Column(name ="ZINC_STD_SEQ",nullable=true,precision=2,length=2)
	public java.lang.String getZincStdSeq(){
		return this.zincStdSeq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  喷锌标准序码
	 */
	public void setZincStdSeq(java.lang.String zincStdSeq){
		this.zincStdSeq = zincStdSeq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  喷锌标准描述
	 */
	@Column(name ="ZINC_STD_DESC",nullable=true,precision=60,length=60)
	public java.lang.String getZincStdDesc(){
		return this.zincStdDesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  喷锌标准描述
	 */
	public void setZincStdDesc(java.lang.String zincStdDesc){
		this.zincStdDesc = zincStdDesc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  外防腐终饰层厚度序码
	 */
	@Column(name ="COAT_TK_SEQ",nullable=true,precision=2,length=2)
	public java.lang.String getCoatTkSeq(){
		return this.coatTkSeq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  外防腐终饰层厚度序码
	 */
	public void setCoatTkSeq(java.lang.String coatTkSeq){
		this.coatTkSeq = coatTkSeq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  外防腐终饰层厚度描述
	 */
	@Column(name ="COAT_TK_DESC",nullable=true,precision=60,length=60)
	public java.lang.String getCoatTkDesc(){
		return this.coatTkDesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  外防腐终饰层厚度描述
	 */
	public void setCoatTkDesc(java.lang.String coatTkDesc){
		this.coatTkDesc = coatTkDesc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  外防腐执行标准序码
	 */
	@Column(name ="COAT_STD_SEQ",nullable=true,precision=2,length=2)
	public java.lang.String getCoatStdSeq(){
		return this.coatStdSeq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  外防腐执行标准序码
	 */
	public void setCoatStdSeq(java.lang.String coatStdSeq){
		this.coatStdSeq = coatStdSeq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  外防腐执行标准描述
	 */
	@Column(name ="COAT_STD_DESC",nullable=true,precision=60,length=60)
	public java.lang.String getCoatStdDesc(){
		return this.coatStdDesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  外防腐执行标准描述
	 */
	public void setCoatStdDesc(java.lang.String coatStdDesc){
		this.coatStdDesc = coatStdDesc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  承口内部终饰层材料序码
	 */
	@Column(name ="BELL_MATERIAL_SEQ",nullable=true,precision=2,length=2)
	public java.lang.String getBellMaterialSeq(){
		return this.bellMaterialSeq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  承口内部终饰层材料序码
	 */
	public void setBellMaterialSeq(java.lang.String bellMaterialSeq){
		this.bellMaterialSeq = bellMaterialSeq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  承口内部终饰层材料描述
	 */
	@Column(name ="BELL_MATERIAL_DESC",nullable=true,precision=60,length=60)
	public java.lang.String getBellMaterialDesc(){
		return this.bellMaterialDesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  承口内部终饰层材料描述
	 */
	public void setBellMaterialDesc(java.lang.String bellMaterialDesc){
		this.bellMaterialDesc = bellMaterialDesc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  承口内部终饰层厚度序码
	 */
	@Column(name ="BELL_TK_SEQ",nullable=true,precision=2,length=2)
	public java.lang.String getBellTkSeq(){
		return this.bellTkSeq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  承口内部终饰层厚度序码
	 */
	public void setBellTkSeq(java.lang.String bellTkSeq){
		this.bellTkSeq = bellTkSeq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  承口内部终饰层厚度描述
	 */
	@Column(name ="BELL_TK_DESC",nullable=true,precision=60,length=60)
	public java.lang.String getBellTkDesc(){
		return this.bellTkDesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  承口内部终饰层厚度描述
	 */
	public void setBellTkDesc(java.lang.String bellTkDesc){
		this.bellTkDesc = bellTkDesc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  插口端终饰层材料序码
	 */
	@Column(name ="JACK_MATERIAL_SEQ",nullable=true,precision=2,length=2)
	public java.lang.String getJackMaterialSeq(){
		return this.jackMaterialSeq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  插口端终饰层材料序码
	 */
	public void setJackMaterialSeq(java.lang.String jackMaterialSeq){
		this.jackMaterialSeq = jackMaterialSeq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  插口端终饰层材料描述
	 */
	@Column(name ="JACK_MATERIAL_DESC",nullable=true,precision=60,length=60)
	public java.lang.String getJackMaterialDesc(){
		return this.jackMaterialDesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  插口端终饰层材料描述
	 */
	public void setJackMaterialDesc(java.lang.String jackMaterialDesc){
		this.jackMaterialDesc = jackMaterialDesc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  插口端终饰层厚度序码
	 */
	@Column(name ="JACK_TK_SEQ",nullable=true,precision=2,length=2)
	public java.lang.String getJackTkSeq(){
		return this.jackTkSeq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  插口端终饰层厚度序码
	 */
	public void setJackTkSeq(java.lang.String jackTkSeq){
		this.jackTkSeq = jackTkSeq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  插口端终饰层厚度描述
	 */
	@Column(name ="JACK_TK_DESC",nullable=true,precision=60,length=60)
	public java.lang.String getJackTkDesc(){
		return this.jackTkDesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  插口端终饰层厚度描述
	 */
	public void setJackTkDesc(java.lang.String jackTkDesc){
		this.jackTkDesc = jackTkDesc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  排产单号(外销排产)
	 */
	@Column(name ="SCHEDULING_NO",nullable=true,precision=20,length=20)
	public java.lang.String getSchedulingNo(){
		return this.schedulingNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  排产单号(外销排产)
	 */
	public void setSchedulingNo(java.lang.String schedulingNo){
		this.schedulingNo = schedulingNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申报单位代码(外销排产)
	 */
	@Column(name ="REPORT_USER_NUM",nullable=true,precision=10,length=10)
	public java.lang.String getReportUserNum(){
		return this.reportUserNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申报单位代码(外销排产)
	 */
	public void setReportUserNum(java.lang.String reportUserNum){
		this.reportUserNum = reportUserNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申报单位中文名(外销排产)
	 */
	@Column(name ="REPORT_USER_CNAME",nullable=true,precision=200,length=200)
	public java.lang.String getReportUserCname(){
		return this.reportUserCname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申报单位中文名(外销排产)
	 */
	public void setReportUserCname(java.lang.String reportUserCname){
		this.reportUserCname = reportUserCname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结算单位代码(外销排产)
	 */
	@Column(name ="SETTLE_USER_NUM",nullable=true,precision=10,length=10)
	public java.lang.String getSettleUserNum(){
		return this.settleUserNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结算单位代码(外销排产)
	 */
	public void setSettleUserNum(java.lang.String settleUserNum){
		this.settleUserNum = settleUserNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结算单位中文名(外销排产)
	 */
	@Column(name ="SETTLE_USER_CNAME",nullable=true,precision=200,length=200)
	public java.lang.String getSettleUserCname(){
		return this.settleUserCname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结算单位中文名(外销排产)
	 */
	public void setSettleUserCname(java.lang.String settleUserCname){
		this.settleUserCname = settleUserCname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申报时间(外销排产)
	 */
	@Column(name ="REPORT_TIME",nullable=true,precision=14,length=14)
	public java.lang.String getReportTime(){
		return this.reportTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申报时间(外销排产)
	 */
	public void setReportTime(java.lang.String reportTime){
		this.reportTime = reportTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  最终销售地(外销排产)
	 */
	@Column(name ="SALE_GROUND",nullable=true,precision=200,length=200)
	public java.lang.String getSaleGround(){
		return this.saleGround;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  最终销售地(外销排产)
	 */
	public void setSaleGround(java.lang.String saleGround){
		this.saleGround = saleGround;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  采购商(外销排产)
	 */
	@Column(name ="BUYERS",nullable=true,precision=200,length=200)
	public java.lang.String getBuyers(){
		return this.buyers;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购商(外销排产)
	 */
	public void setBuyers(java.lang.String buyers){
		this.buyers = buyers;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  交货日期(外销排产)
	 */
	@Column(name ="DELIVERY_DATE",nullable=true,precision=14,length=14)
	public java.lang.String getDeliveryDate(){
		return this.deliveryDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交货日期(外销排产)
	 */
	public void setDeliveryDate(java.lang.String deliveryDate){
		this.deliveryDate = deliveryDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  交货地点(外销排产)
	 */
	@Column(name ="DELIVERY_PLACE",nullable=true,precision=200,length=200)
	public java.lang.String getDeliveryPlace(){
		return this.deliveryPlace;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交货地点(外销排产)
	 */
	public void setDeliveryPlace(java.lang.String deliveryPlace){
		this.deliveryPlace = deliveryPlace;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  运输方式代码(外销排产)
	 */
	@Column(name ="TRNP_MODE_CODE",nullable=true,precision=2,length=2)
	public java.lang.String getTrnpModeCode(){
		return this.trnpModeCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  运输方式代码(外销排产)
	 */
	public void setTrnpModeCode(java.lang.String trnpModeCode){
		this.trnpModeCode = trnpModeCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  运输方式描述(外销排产)
	 */
	@Column(name ="TRNP_MODE_NAME",nullable=true,precision=14,length=14)
	public java.lang.String getTrnpModeName(){
		return this.trnpModeName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  运输方式描述(外销排产)
	 */
	public void setTrnpModeName(java.lang.String trnpModeName){
		this.trnpModeName = trnpModeName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  需求程度(外销排产)
	 */
	@Column(name ="REQUIRE_LEVEL",nullable=true,precision=10,length=10)
	public java.lang.String getRequireLevel(){
		return this.requireLevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  需求程度(外销排产)
	 */
	public void setRequireLevel(java.lang.String requireLevel){
		this.requireLevel = requireLevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  技术要求(外销排产)
	 */
	@Column(name ="TECHNICAL_DEMAND",nullable=true,precision=1000,length=1000)
	public java.lang.String getTechnicalDemand(){
		return this.technicalDemand;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  技术要求(外销排产)
	 */
	public void setTechnicalDemand(java.lang.String technicalDemand){
		this.technicalDemand = technicalDemand;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  包装要求(外销排产)
	 */
	@Column(name ="PACKING_DEMAND",nullable=true,precision=1000,length=1000)
	public java.lang.String getPackingDemand(){
		return this.packingDemand;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  包装要求(外销排产)
	 */
	public void setPackingDemand(java.lang.String packingDemand){
		this.packingDemand = packingDemand;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  包装唛头(外销排产)
	 */
	@Column(name ="SHIPPING_MARK",nullable=true,precision=2000,length=2000)
	public java.lang.String getShippingMark(){
		return this.shippingMark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  包装唛头(外销排产)
	 */
	public void setShippingMark(java.lang.String shippingMark){
		this.shippingMark = shippingMark;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  运输唛头(外销排产)
	 */
	@Column(name ="TRNP_MODE_MARK",nullable=true,precision=2000,length=2000)
	public java.lang.String getTrnpModeMark(){
		return this.trnpModeMark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  运输唛头(外销排产)
	 */
	public void setTrnpModeMark(java.lang.String trnpModeMark){
		this.trnpModeMark = trnpModeMark;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  质保书(外销排产)
	 */
	@Column(name ="MILL_CERTIFICATE",nullable=true,precision=200,length=200)
	public java.lang.String getMillCertificate(){
		return this.millCertificate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  质保书(外销排产)
	 */
	public void setMillCertificate(java.lang.String millCertificate){
		this.millCertificate = millCertificate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商检(外销排产)
	 */
	@Column(name ="INSPECTION",nullable=true,precision=200,length=200)
	public java.lang.String getInspection(){
		return this.inspection;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商检(外销排产)
	 */
	public void setInspection(java.lang.String inspection){
		this.inspection = inspection;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  排产单总金额(外销排产)
	 */
	@Column(name ="SCHEDULING_AMT",nullable=true,precision=20,scale=2,length=13)
	public BigDecimal getSchedulingAmt(){
		return this.schedulingAmt;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  排产单总金额(外销排产)
	 */
	public void setSchedulingAmt(BigDecimal schedulingAmt){
		this.schedulingAmt = schedulingAmt;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  特殊合同描述
	 */
	@Column(name ="SPECIAL_DESC",nullable=true,precision=600,length=600)
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
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARK",nullable=true,precision=600,length=600)
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
	 *@return: java.lang.String  附件路径
	 */
	@Column(name ="ANNEX_PATH",nullable=true,precision=2000,length=2000)
	public java.lang.String getAnnexPath(){
		return this.annexPath;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附件路径
	 */
	public void setAnnexPath(java.lang.String annexPath){
		this.annexPath = annexPath;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  插入时间
	 */
	@Column(name ="INSERT_DATE",nullable=true,precision=23,scale=3,length=8)
	public java.util.Date getInsertDate(){
		return this.insertDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  插入时间
	 */
	public void setInsertDate(java.util.Date insertDate){
		this.insertDate = insertDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  生产单位
	 */
	@Column(name ="SCDW",nullable=true,precision=20,length=20)
	public java.lang.String getScdw(){
		return this.scdw;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  生产单位
	 */
	public void setScdw(java.lang.String scdw){
		this.scdw = scdw;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核部门
	 */
	@Column(name ="SHBM",nullable=true,precision=32,length=32)
	public java.lang.String getShbm(){
		return this.shbm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核部门
	 */
	public void setShbm(java.lang.String shbm){
		this.shbm = shbm;
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
	 *@return: java.lang.String  计划类型
	 */
	@Column(name ="PLAN_TYPE",nullable=true,precision=2,length=2)
	public java.lang.String getPlanType(){
		return this.planType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计划类型
	 */
	public void setPlanType(java.lang.String planType){
		this.planType = planType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编号
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,precision=36,length=36)
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
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核结果
	 */
	@Column(name ="AUDITRESULT",nullable=true,precision=16,length=16)
	public java.lang.String getAuditresult(){
		return this.auditresult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核结果
	 */
	public void setAuditresult(java.lang.String auditresult){
		this.auditresult = auditresult;
	}
}
