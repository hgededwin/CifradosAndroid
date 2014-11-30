package com.cifrados.metodos;

public class CodigoVernam {
	
	 ValidarPatron validPat = new ValidarPatron();
	    
	    public String[] Cifrado(char []a, char []k){
	        
	        ///////////////// OBTENER PATRON MODIFICADO /////////
	        System.out.print("\nEl Patron es: ");
	        for (int i = 0; i < a.length; i++) {
	            System.out.print(""+a[i]);
	        }
	        int errorPI = validPat.error(a);
	        char[] patronInicial = new char[a.length];
	        patronInicial = validPat.validarPatron2(a);
	        int tamPV = patronInicial.length-errorPI;
	        char[] patron = new char[tamPV];
	        for (int i = 0; i < tamPV; i++) {
	            patron[i]=patronInicial[i];
	        }
	        ///////////////// OBTENER CLAVE MODIFICADO /////////
	        System.out.print("\nLa clave es: ");
	        for (int i = 0; i < k.length; i++) {
	            System.out.print(""+k[i]);
	        }
	        int errorKI = validPat.error(k);
	        char[] claveInicial = new char[k.length];
	        claveInicial = validPat.validarPatron2(k);
	        int tamKV = claveInicial.length-errorKI;
	        char[] clave = new char[tamKV];
	        for (int i = 0; i < tamKV; i++) {
	            clave[i]=claveInicial[i];
	        }
	        
	        /////////////// REALIZAMOS LA OPERACION XOR ////////////////
	        String cero = "0";
	        String[] resul2 = new String[tamPV];
	        System.out.println("");
	        for (int i = 0; i < tamPV; i++) {
	            int ascii = (int)patron[i] ^ (int)clave[i];
	            if (Integer.toBinaryString(ascii).length()<8) {
	                int ceros = 8 - Integer.toBinaryString(ascii).length();
	                char[] zeros = new char[ceros];
	                for (int j = 0; j < ceros; j++) {
	                    zeros[j]=cero.charAt(0);
	                }
	                resul2[i]=(""+String.valueOf(zeros)+Integer.toBinaryString(ascii)+" ");
	            }
	            System.out.print(""+resul2[i]);
	        }
	        
	        return resul2;
	    }
	    

}
