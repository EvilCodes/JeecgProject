package com.yangjiang.entity.t_zg_package_detail;

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
 * @Description: 打包子表
 * @author zhangdaihao
 * @date 2016-12-20 14:12:41
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_zg_package_detail", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class T_zg_package_detailEntity implements java.io.Serializable {
	/**编码*/
	private java.lang.String id;
	/**包号*/
	private java.lang.String packid;
	/**批号全称*/
	private java.lang.String batchfull;
	/**规格*/
	private java.lang.String dn;
	/**产品代码*/
	private java.lang.String itemcode;
	/**产品名称*/
	private java.lang.String itemcname;
	/**生产计划号*/
	private java.lang.String productplanno;
	/**管号*/
	private java.lang.String pipecode;
	/**批支数*/
	private java.lang.Integer pipenum;
	/**特殊合同描述*/
	private java.lang.String special;
	/**管序号*/
	private java.lang.String pipeserial;
	/**备注*/
	private java.lang.String remark;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编码
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,precision=50,length=50)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="remark",nullable=true,precision=50,length=50)
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
	 *@return: java.lang.String  包号
	 */
	@Column(name ="PACKID",nullable=true,precision=50,length=50)
	public java.lang.String getPackid(){
		return this.packid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  包号
	 */
	public void setPackid(java.lang.String packid){
		this.packid = packid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  批号全称
	 */
	@Column(name ="BATCHFULL",nullable=true,precision=32,length=32)
	public java.lang.String getBatchfull(){
		return this.batchfull;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  批号全称
	 */
	public void setBatchfull(java.lang.String batchfull){
		this.batchfull = batchfull;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  规格
	 */
	@Column(name ="DN",nullable=true,precision=32,length=32)
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
	 *@return: java.lang.String  产品代码
	 */
	@Column(name ="ITEMCODE",nullable=true,precision=50,length=50)
	public java.lang.String getItemcode(){
		return this.itemcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品代码
	 */
	public void setItemcode(java.lang.String itemcode){
		this.itemcode = itemcode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品名称
	 */
	@Column(name ="ITEMCNAME",nullable=true,precision=50,length=50)
	public java.lang.String getItemcname(){
		return this.itemcname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品名称
	 */
	public void setItemcname(java.lang.String itemcname){
		this.itemcname = itemcname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  生产计划号
	 */
	@Column(name ="PRODUCTPLANNO",nullable=true,precision=50,length=50)
	public java.lang.String getProductplanno(){
		return this.productplanno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  生产计划号
	 */
	public void setProductplanno(java.lang.String productplanno){
		this.productplanno = productplanno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  管号
	 */
	@Column(name ="PIPECODE",nullable=true,precision=50,length=50)
	public java.lang.String getPipecode(){
		return this.pipecode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  管号
	 */
	public void setPipecode(java.lang.String pipecode){
		this.pipecode = pipecode;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  批支数
	 */
	@Column(name ="PIPENUM",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getPipenum(){
		return this.pipenum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  批支数
	 */
	public void setPipenum(java.lang.Integer pipenum){
		this.pipenum = pipenum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  特殊合同描述
	 */
	@Column(name ="SPECIAL",nullable=true,precision=80,length=80)
	public java.lang.String getSpecial(){
		return this.special;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  特殊合同描述
	 */
	public void setSpecial(java.lang.String special){
		this.special = special;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  管序号
	 */
	@Column(name ="PIPESERIAL",nullable=true,precision=16,length=16)
	public java.lang.String getPipeserial(){
		return this.pipeserial;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  管序号
	 */
	public void setPipeserial(java.lang.String pipeserial){
		this.pipeserial = pipeserial;
	}
}
