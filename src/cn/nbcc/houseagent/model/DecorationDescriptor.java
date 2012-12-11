package cn.nbcc.houseagent.model;

/***********************************************************************
 * Module:  DecorationDescriptor.java
 * Author:  zheng zhe
 * Purpose: Defines the Class DecorationDescriptor
 ***********************************************************************/

import java.text.DecimalFormat;
import java.util.*;
import static cn.nbcc.houseagent.utils.RentConstants.EumDecStyle;

/** 装修描述
 * 
 * @pdOid e57f8d83-a704-43c4-8cae-2557b206bf52 */
public class DecorationDescriptor extends ModelObject {
   /** 装修描述
    * 
    * @pdOid c92c0648-189c-4506-b92a-9ff75bcb4beb */
   private java.lang.String desc;
   /** 装修费用
    * 
    * @pdOid b031f468-d89c-492a-8cc8-54798862d210 */
   private double decFee;
   /** 装修风格
    * 
    * @pdOid 64778b89-d7d3-4481-931d-ea2ab0208dcd */
   private EumDecStyle decStyle;
   
   
   private int year;
   
   
   public String getYear() {
	   DecimalFormat fourDecimalFormat = new DecimalFormat("0000");
	   return fourDecimalFormat.format(year);
}

public void setYear(int year) {
	this.year = year;
}

/** @pdOid 457f9444-39bf-408d-a79a-554c1bb65ce6 */
   public java.lang.String getDesc() {
      return desc;
   }
   
   /** @param newDesc
    * @pdOid 21f49ecc-769a-469b-a56f-0246088049ef */
   public void setDesc(java.lang.String newDesc) {
      firePropertyChange("desc", desc, desc = newDesc);
   }
   
   /** @pdOid c3764f74-fe5e-4967-8aa7-0093824d5360 */
   public EumDecStyle  getDecStyle() {
      return decStyle;
   }
   
   /** @param newDecStyle
    * @pdOid d0a549cc-fafe-406a-90f3-b0668e4ef7c0 */
   public void setDecStyle( EumDecStyle newDecStyle) {
     firePropertyChange("decStyle", decStyle,  decStyle = newDecStyle);
   }
   
   /** @pdOid 1e3c1b0a-3c81-4667-b4fb-810677836c5e */
   public double getDecFee() {
      return decFee;
   }
   
   /** @param newDecFee
    * @pdOid ba47ff04-f308-483f-a3f6-1f113214923b */
   public void setDecFee(double newDecFee) {
     firePropertyChange("decFee", decFee, decFee = newDecFee);
   }

}