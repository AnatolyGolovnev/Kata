/******************************************************************
Автор Анатолий Головнёв. 2022.05.04.
Работает вместе с Program.java

Объект класса Number содержит численное значание (int value) и индикатор системы счисления (String syst).
Функции класса: add() и print().
******************************************************************/
import java.io.*;


enum Roman{one("I",1),two("II",2),three("III",3),four("IV",4),five("V",5),six("VI",6),seven("VII",7),eight("VIII",8),nine("IX",9),ten("X",10);
	private String rValue;  private int aValue;
	Roman(String rValue, int aValue){this.aValue=aValue;this.rValue=rValue;}
	String getrValue(){return rValue;}
	int getaValue(){return aValue;}
};

enum RomanNumbers{C(100), XC(90), L(50), XL(40), X(10), IX(9), V(5), IV(4), I(1);
	private int value;
	RomanNumbers(int value){this.value=value;}
	int getValue(){return value;}
}

public class Number{
	private int value; private String syst;
	int getValue(){return value;}
	String getSyst(){return syst;}
	
Number(int value, String syst){this.value=value;this.syst=syst;}

Number(String sInput){
		
		switch (sInput){//посколько принимаются только числа от 0 до 10, наиболее простое и надёжное решение это их перечислить.
			case "0":case "1":case "2":case "3":case "4":case "5":case "6":case "7":case "8": case"9":case "10":
			this.value = Integer.parseInt(sInput); this.syst="arabic";return;
		}//switch
			
			for(Roman ss : Roman.values())if(ss.getrValue().equals(sInput.toUpperCase())){this.value = ss.getaValue(); this.syst="roman";return;}
			
			if(sInput.equals("wrong"))System.exit(0);
			
			try{throw new IOException();} catch(IOException e){System.out.println("Введено не разрещенное число.");}
			System.exit(0);
		
	}//Number constructor


Number and(Number nn, char oper){
	if(!this.getSyst().equals(nn.getSyst())){
		try{throw new IOException();}catch(IOException e){System.out.println("Разные системы счисления.");}
			return new Number("wrong");}	
	
	int value=0;
	switch(oper){
	case '+'	:	value=this.getValue()+nn.getValue();break;
	case '-'	:	value=this.getValue()-nn.getValue();break;
	case '*'	:	value=this.getValue()*nn.getValue();break;
	case '/'	:	if(nn.getValue()==0){System.out.println("на 0 делить нельзя");return new Number("wrong");}value=this.getValue()/nn.getValue();
	}//switch
	
	if(this.getSyst().equals("roman")){
			if(value<1){
				try{throw new IOException();} catch(IOException e){System.out.println("Римское число получилось не положительным.");}
					return new Number("wrong");}
			else return new Number(value,"roman");
		}//if
	return new Number(value,"arabic");
	
}//and


void print(){
	if(this.getSyst().equals("arabic")){System.out.println(this.getValue());return;}
	
	int outcome = this.getValue(); StringBuilder out = new StringBuilder();
	for(RomanNumbers o : RomanNumbers.values()){
		while(o.getValue()<=outcome && outcome>0) {out.append(o.toString());outcome-=o.getValue();}
	}//for
	
	System.out.println(out);
		
}//print


}//class Number
