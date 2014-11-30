package com.cifrados.metodos;

public class ValidarClave {
	
	 public char[] validarClave(char []clave1){
	        String datos = "abcdefghiklmnopqrstuvwxyz";
	        int tamK=clave1.length, contAlf=0, tamAlf=25;
	        char[] clave2= new char[tamK];
	        
	        System.out.print("\nModificando: ");
	        int encontrado=0, no=0, contC1=0, tamC2=0;
	        int tamC1 = tamK;
	        for (int i = 0; i < tamC1; i++) {
	                encontrado=0;
	                int j=0;
	                while(j < tamAlf) {
	                    if(contC1==tamC1){
	                        j=tamAlf;
	                    }else if (clave1[i]==datos.charAt(j)){
	                        clave2[tamC2]=clave1[i];
	                        tamC2++;
	                        encontrado=1;
	                        j=tamAlf;
	                    }else{
	                        j++;
	                    } 
	                }
	                if (encontrado==0) {
	                    no++;
	                }
	        }
	        for (int i = 0; i < tamC2; i++) {
	            System.out.print(""+clave2[i]); 
	        }
	        
	        return clave2;
	    }
	    
	    public int error(char []clave1){
	        String datos = "abcdefghiklmnopqrstuvwxyz";
	        int tamK=clave1.length, contAlf=0, tamAlf=25;
	        char[] clave2= new char[tamK];
	        
	        int encontrado=0, no=0, contC1=0, tamC2=0;
	        int tamC1 = tamK;
	        for (int i = 0; i < tamC1; i++) {
	                encontrado=0;
	                int j=0;
	                while(j < tamAlf) {
	                    if(contC1==tamC1){
	                        j=tamAlf;
	                    }else if (clave1[i]==datos.charAt(j)){
	                        clave2[tamC2]=clave1[i];
	                        tamC2++;
	                        encontrado=1;
	                        j=tamAlf;
	                    }else{
	                        j++;
	                    } 
	                }
	                if (encontrado==0) {
	                    no++;
	                }
	        }
	        System.out.print("\nCorrecciones en Clave= "+no);
	        
	        return no;
	    }

}
