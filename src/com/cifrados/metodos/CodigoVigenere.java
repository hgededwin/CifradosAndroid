package com.cifrados.metodos;

public class CodigoVigenere {
	
	 Alfabeto alfabeto = new Alfabeto();
	    
	    public char[] Cifrado(char []a, char []k){
	        int[] C= new int[a.length];
	        int[] K= new int[a.length];
	        int tamK = k.length, cont=0;
	        char[] resulvigenere=a;
	        char[] clave=k;
	        String r;
	        int c=-666; 
	        for (int i = 0; i < resulvigenere.length; i++) {
	            C[i]=alfabeto.numero(String.valueOf(resulvigenere[i]));
	            if(cont==tamK) {
	                cont=0;
	            }
	            K[i]=alfabeto.numero(String.valueOf(clave[cont]));
	            if(C[i]==-666 || K[i]==-666){
	            	resulvigenere[i]=resulvigenere[i];
	                cont--;
	            }else{
	                if (C[i]==-555) {
	                    c=-555;
	                    cont--;
	                }else{
	                    c=(C[i]+K[i])%26;
	                }
	                r=alfabeto.letra(c);
	                resulvigenere[i]=r.charAt(0); 
	            }
	            cont++;
	        }
	 
	        return resulvigenere;
	    }
	    
	    public char[] Descifrado(char []a, char []k){
	        int[] C= new int[a.length];
	        int[] K= new int[a.length];
	        int tamK = k.length, cont=0;
	        char[] resul=a;
	        char[] clave=k;
	        String r;
	        int c=-666; 
	        for (int i = 0; i < resul.length; i++) {
	            C[i]=alfabeto.numero(String.valueOf(resul[i]));
	            if(cont==tamK) {
	                cont=0;
	            }
	            K[i]=alfabeto.numero(String.valueOf(clave[cont]));
	            if(C[i]==-666 || K[i]==-666){
	                resul[i]=resul[i];
	                cont--;
	            }else{
	                if (C[i]==-555) {
	                    c=-555;
	                    cont--;
	                }else{
	                    c=(C[i]-K[i])%26;
	                    if(c<0){
	                        c=c+26;
	                    }
	                }
	                r=alfabeto.letra(c);
	                resul[i]=r.charAt(0); 
	            }
	            cont++;
	        }
	 
	        return resul;
	    }

}
