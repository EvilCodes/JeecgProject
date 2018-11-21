package com.yangjiang.entity.t_zgk_pipe_rkm;

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
 * @Description: 管材入库主表信息
 * @author zhangdaihao
 * @date 2016-10-27 14:46:10
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_zgk_pipe_rkm", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class T_ZGK_PIPE_RKMEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**入库单编号*/
	private java.lang.String rukudanid;
	/**日期*/
	private java.util.Date riqi;
	/**管库名称*/
	private java.lang.String storeName;
	/**保管员*/
	private java.lang.String baoguanyuan;
	
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
	 *@return: java.lang.String  入库单编号
	 */
	@Column(name ="RUKUDANID",nullable=false,precision=20,length=20)
	public java.lang.String getRukudanid(){
		return this.rukudanid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入库单编号
	 */
	public void setRukudanid(java.lang.String rukudanid){
		this.rukudanid = rukudanid;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  日期
	 */
	@Column(name ="RIQI",nullable=true,precision=23,scale=3,length=8)
	public java.util.Date getRiqi(){
		return this.riqi;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  日期
	 */
	public void setRiqi(java.util.Date riqi){
		this.riqi = riqi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  管库名称
	 */
	@Column(name ="STORE_NAME",nullable=true,precision=10,length=10)
	public java.lang.String getStoreName(){
		return this.storeName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  管库名称
	 */
	public void setStoreName(java.lang.String storeName){
		this.storeName = storeName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  保管员
	 */
	@Column(name ="BAOGUANYUAN",nullable=true,precision=10,length=10)
	public java.lang.String getBaoguanyuan(){
		return this.baoguanyuan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  保管员
	 */
	public void setBaoguanyuan(java.lang.String baoguanyuan){
		this.baoguanyuan = baoguanyuan;
	}
}
