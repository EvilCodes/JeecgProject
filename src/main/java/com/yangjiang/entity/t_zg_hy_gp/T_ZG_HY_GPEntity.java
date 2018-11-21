package com.yangjiang.entity.t_zg_hy_gp;

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
 * @Description: 光谱数据
 * @author zhangdaihao
 * @date 2017-03-23 18:01:56
 * @version V1.0   
 *
 */
@Entity
@Table(name = "T_ZG_HY_GP", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class T_ZG_HY_GPEntity implements java.io.Serializable {
	/**分析时间*/
	private java.util.Date analyDate;
	/**试样名称*/
	private java.lang.String sampleName;
	/**试样编号*/
	private java.lang.String sampleNo;
	/**判定*/
	private java.lang.String result;
	/**c*/
	private BigDecimal c;
	/**si*/
	private BigDecimal si;
	/**mn*/
	private BigDecimal mn;
	/**s*/
	private BigDecimal s;
	/**p*/
	private BigDecimal p;
	/**mg*/
	private BigDecimal mg;
	/**ni*/
	private BigDecimal ni;
	/**cr*/
	private BigDecimal cr;
	/**mo*/
	private BigDecimal mo;
	/**v*/
	private BigDecimal v;
	/**ti*/
	private BigDecimal ti;
	/**al*/
	private BigDecimal al;
	/**pb*/
	private BigDecimal pb;
	/**ce*/
	private BigDecimal ce;
	/**cu*/
	private BigDecimal cu;
	/**ceq*/
	private BigDecimal ceq;
	/**lrsj*/
	private java.util.Date lrsj;
	/**b*/
	private BigDecimal b;
	/**sb*/
	private BigDecimal sb;
	/**as1*/
	private BigDecimal as1;
	/**sn*/
	private BigDecimal sn;
	/**lrr*/
	private java.lang.String lrr;
	/**lrbm*/
	private java.lang.String lrbm;
	/**编号*/
	private java.lang.String id;
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="id",nullable=false,precision=50,length=50)
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  分析时间
	 */
	@Column(name ="analyDate",nullable=false,precision=23,scale=3,length=8)
	public java.util.Date getAnalyDate(){
		return this.analyDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  分析时间
	 */
	public void setAnalyDate(java.util.Date analyDate){
		this.analyDate = analyDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  试样名称
	 */
	@Column(name ="sampleName",nullable=true,precision=12,length=12)
	public java.lang.String getSampleName(){
		return this.sampleName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  试样名称
	 */
	public void setSampleName(java.lang.String sampleName){
		this.sampleName = sampleName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  试样编号
	 */
	@Column(name ="sampleNo",nullable=false,precision=20,length=20)
	public java.lang.String getSampleNo(){
		return this.sampleNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  试样编号
	 */
	public void setSampleNo(java.lang.String sampleNo){
		this.sampleNo = sampleNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  判定
	 */
	@Column(name ="result",nullable=true,precision=20,length=20)
	public java.lang.String getResult(){
		return this.result;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  判定
	 */
	public void setResult(java.lang.String result){
		this.result = result;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  c
	 */
	@Column(name ="C",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getC(){
		return this.c;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  c
	 */
	public void setC(BigDecimal c){
		this.c = c;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  si
	 */
	@Column(name ="SI",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getSi(){
		return this.si;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  si
	 */
	public void setSi(BigDecimal si){
		this.si = si;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  mn
	 */
	@Column(name ="MN",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getMn(){
		return this.mn;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  mn
	 */
	public void setMn(BigDecimal mn){
		this.mn = mn;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  s
	 */
	@Column(name ="S",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getS(){
		return this.s;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  s
	 */
	public void setS(BigDecimal s){
		this.s = s;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  p
	 */
	@Column(name ="P",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getP(){
		return this.p;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  p
	 */
	public void setP(BigDecimal p){
		this.p = p;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  mg
	 */
	@Column(name ="MG",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getMg(){
		return this.mg;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  mg
	 */
	public void setMg(BigDecimal mg){
		this.mg = mg;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  ni
	 */
	@Column(name ="NI",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getNi(){
		return this.ni;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  ni
	 */
	public void setNi(BigDecimal ni){
		this.ni = ni;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  cr
	 */
	@Column(name ="CR",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getCr(){
		return this.cr;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  cr
	 */
	public void setCr(BigDecimal cr){
		this.cr = cr;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  mo
	 */
	@Column(name ="MO",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getMo(){
		return this.mo;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  mo
	 */
	public void setMo(BigDecimal mo){
		this.mo = mo;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  v
	 */
	@Column(name ="V",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getV(){
		return this.v;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  v
	 */
	public void setV(BigDecimal v){
		this.v = v;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  ti
	 */
	@Column(name ="TI",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getTi(){
		return this.ti;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  ti
	 */
	public void setTi(BigDecimal ti){
		this.ti = ti;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  al
	 */
	@Column(name ="AL",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getAl(){
		return this.al;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  al
	 */
	public void setAl(BigDecimal al){
		this.al = al;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  pb
	 */
	@Column(name ="PB",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getPb(){
		return this.pb;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  pb
	 */
	public void setPb(BigDecimal pb){
		this.pb = pb;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  ce
	 */
	@Column(name ="CE",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getCe(){
		return this.ce;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  ce
	 */
	public void setCe(BigDecimal ce){
		this.ce = ce;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  cu
	 */
	@Column(name ="CU",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getCu(){
		return this.cu;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  cu
	 */
	public void setCu(BigDecimal cu){
		this.cu = cu;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  ceq
	 */
	@Column(name ="CEQ",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getCeq(){
		return this.ceq;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  ceq
	 */
	public void setCeq(BigDecimal ceq){
		this.ceq = ceq;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  lrsj
	 */
	@Column(name ="LRSJ",nullable=true,precision=23,scale=3,length=8)
	public java.util.Date getLrsj(){
		return this.lrsj;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  lrsj
	 */
	public void setLrsj(java.util.Date lrsj){
		this.lrsj = lrsj;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  b
	 */
	@Column(name ="B",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getB(){
		return this.b;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  b
	 */
	public void setB(BigDecimal b){
		this.b = b;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  sb
	 */
	@Column(name ="SB",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getSb(){
		return this.sb;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  sb
	 */
	public void setSb(BigDecimal sb){
		this.sb = sb;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  as1
	 */
	@Column(name ="AS1",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getAs1(){
		return this.as1;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  as1
	 */
	public void setAs1(BigDecimal as1){
		this.as1 = as1;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  sn
	 */
	@Column(name ="SN",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getSn(){
		return this.sn;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  sn
	 */
	public void setSn(BigDecimal sn){
		this.sn = sn;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  lrr
	 */
	@Column(name ="LRR",nullable=true,precision=16,length=16)
	public java.lang.String getLrr(){
		return this.lrr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  lrr
	 */
	public void setLrr(java.lang.String lrr){
		this.lrr = lrr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  lrbm
	 */
	@Column(name ="LRBM",nullable=true,precision=30,length=30)
	public java.lang.String getLrbm(){
		return this.lrbm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  lrbm
	 */
	public void setLrbm(java.lang.String lrbm){
		this.lrbm = lrbm;
	}
}
