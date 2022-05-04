/******************************************************
Автор Анатолий Головнёв. 2022.05.04.
Для работы требуется Number.java
******************************************************/

import java.util.Scanner;
import java.io.*;

class Conditions{//Классы Conditions и Opers оставил в этом файле, поскольку они короткие и простые и логически привязаны к классу Program.
	public static final String exit = new String("exit");
	public static final String badInput = new String("badInput");
		}

enum Opers{plus("+","\\+"),minus("-","-"),mult("*","\\*"),devis("/","/");
	private String sign, sign1;
	Opers(String sign, String sign1){this.sign=sign;this.sign1=sign1;}
	public String getSign(){return sign;}
	public String getSign1(){return sign1;}	
		}

public class Program{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in); //считываем уравнение и сохраняем в sInput.
		System.out.println("Введите выражение:");
		String sInput = sc.nextLine();
		
		while(true){
							
	String[] strInput = new String[]{Conditions.badInput,Conditions.badInput};//далее разбиваем введённое уравнение на слогаемые.
	for(Opers o : Opers.values()) if(sInput.indexOf(o.getSign())!=-1){strInput = sInput.split(o.getSign1(),2);break;}
		
		//проверка, что слогаемых ровно два и операция ровно одна.
		if(strInput[1].equals(Conditions.badInput))//проверка, что введена хотя бы одна операция.
		try{throw new IOException();}catch(IOException e)
			{System.out.println("Строка не является математической операцией.");System.exit(0);}	
			
			int ind = 0;//проверка, что введено не более одной операции.
			for(int i=0;i<2;i++){ 
				for(Opers o : Opers.values())	if(strInput[i].indexOf(o.getSign())!=-1) ind++;
			}//for i
					if(ind!=0)try{throw new IOException();}catch(IOException e)
				{System.out.println("Введено более одной математической операции.");System.exit(0);}	

		
		
		//теперь можно посчитать
				Number n1 = new Number(strInput[0]);	
				Number n2 = new Number(strInput[1]);
				n1.and(n2,sInput.charAt(strInput[0].length())).print();
			
			//расчет завершен. Предлагаем вернуться в начало цикла while или завершить программу.
			System.out.println("Введите \"exit\" чтобы выйти или введите новое выражение:");
			sInput = sc.nextLine();
			if(sInput.equals(Conditions.exit)) break;
			
		}//while

	
	}//main	
}//class Program 