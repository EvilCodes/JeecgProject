package com.yangjiang.entity.t_zgk_pipe_ls_flag;

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
 * @Description: 结转标志
 * @author zhangdaihao
 * @date 2016-12-05 17:34:25
 * @version V1.0   
 *
 */
@Entity
@Table(name = "T_ZGK_PIPE_KC_LS_FLAG", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class T_ZGK_PIPE_KC_LS_FLAGEntity implements java.io.Serializable {
	/**结算日前*/
	private java.util.Date riqi;
	/**仓库名称*/
	private java.lang.String storeName;
	/**结算标志*/
	private java.lang.String flag;
	/**结算人*/
	private java.lang.String jiesuanRen;
	/**结算IP地址*/
	private java.lang.String jiesuanIp;
	/**编号*/
	private java.lang.String id;
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  结算日前
	 */
	@Column(name ="RIQI",nullable=false,precision=23,scale=3,length=8)
	public java.util.Date getRiqi(){
		return this.riqi;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  结算日前
	 */
	public void setRiqi(java.util.Date riqi){
		this.riqi = riqi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仓库名称
	 */
	@Column(name ="STORE_NAME",nullable=false,precision=10,length=10)
	public java.lang.String getStoreName(){
		return this.storeName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仓库名称
	 */
	public void setStoreName(java.lang.String storeName){
		this.storeName = storeName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结算标志
	 */
	@Column(name ="FLAG",nullable=true,precision=2,length=2)
	public java.lang.String getFlag(){
		return this.flag;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结算标志
	 */
	public void setFlag(java.lang.String flag){
		this.flag = flag;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结算人
	 */
	@Column(name ="JIESUAN_REN",nullable=true,precision=20,length=20)
	public java.lang.String getJiesuanRen(){
		return this.jiesuanRen;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结算人
	 */
	public void setJiesuanRen(java.lang.String jiesuanRen){
		this.jiesuanRen = jiesuanRen;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结算IP地址
	 */
	@Column(name ="JIESUAN_IP",nullable=true,precision=40,length=40)
	public java.lang.String getJiesuanIp(){
		return this.jiesuanIp;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结算IP地址
	 */
	public void setJiesuanIp(java.lang.String jiesuanIp){
		this.jiesuanIp = jiesuanIp;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编号
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=true,precision=50,length=100)
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
