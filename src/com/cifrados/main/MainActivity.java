package com.cifrados.main;

import com.cifrados.metodos.Descifrar;
import com.cifrados.metodos.DeterminanteMatriz;
import com.cifrados.metodos.CodigoCesar;
import com.cifrados.metodos.CodigoPlayFair;
import com.cifrados.metodos.CodigoVernam;
import com.cifrados.metodos.CodigoVigenere;
import com.example.nuevo.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;


public class MainActivity extends Activity{
	
	CodigoCesar cesar = new CodigoCesar();
    CodigoPlayFair playfair = new CodigoPlayFair();
    CodigoVigenere lotes = new CodigoVigenere();
    CodigoVernam vernam = new CodigoVernam();
    Descifrar descifrar = new Descifrar();
    DeterminanteMatriz determinanteM = new DeterminanteMatriz();
    
    int item;
    int tamMatriz=0, determ=0, inversaDeterm=0;
    int [][]matrizA = new int [25][25];
    
    EditText edtxTexto, edtxClave, edtxResultado;
    Button btnCifrartxt, btnDescifrartxt;
    
    RadioButton rdbCesar, rdbPlayfair, rdbVigenere, rdbVernam;
    RadioGroup rdgeneral;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		edtxTexto = (EditText)findViewById(R.id.txtTexto);
		edtxClave = (EditText)findViewById(R.id.txtClave);
		edtxResultado = (EditText)findViewById(R.id.txtResultado);
		btnCifrartxt = (Button)findViewById(R.id.btnCifrar);
		btnDescifrartxt = (Button)findViewById(R.id.btnDescifrar);
		rdbCesar = (RadioButton)findViewById(R.id.rbCesar);
		rdbPlayfair = (RadioButton)findViewById(R.id.rbplayfair);
		rdbVernam = (RadioButton)findViewById(R.id.rbVernam);
		rdbVigenere = (RadioButton)findViewById(R.id.rbVigenere);
		rdgeneral = (RadioGroup)findViewById(R.id.rdgGrupo);
		
		edtxResultado.setEnabled(false);
		edtxClave.setEnabled(false);
		
		rdgeneral.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				item = rdgeneral.getCheckedRadioButtonId();
				switch (item) {
				case R.id.rbCesar:
					if(rdbCesar.isChecked()){
						edtxClave.setEnabled(false);
					}
					break;
				case R.id.rbplayfair:
					if(rdbPlayfair.isChecked()){
						edtxClave.setEnabled(true);
					}
					break;
				case R.id.rbVernam:
					if(rdbVernam.isChecked()){
						edtxClave.setEnabled(true);
					}
					break;
				case R.id.rbVigenere:
					if(rdbVigenere.isChecked()){
						edtxClave.setEnabled(true);
					}
					break;
				default:
					break;
				}
			}
		});
		
		btnCifrartxt.setOnClickListener(new OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				item = rdgeneral.getCheckedRadioButtonId();
				String txt_a_cifrar = edtxTexto.getText().toString();
		        String txt_clave= edtxClave.getText().toString();
		        char[] array_texto=txt_a_cifrar.toCharArray();
		        char [] array_clave=txt_clave.toCharArray();
		        int ocurre = 0;
		        switch (item) {
		        
				case R.id.rbCesar:
					if("".equals(edtxTexto.getText().toString())){
						edtxTexto.setError("Escribe el texto");
						Toast.makeText(getApplicationContext(), "¡Ingresa el texto a cifrar!", Toast.LENGTH_LONG).show();
					}
				    char[] resulcesar=cesar.Cifrado(array_texto); 
		            edtxResultado.setText(String.valueOf(resulcesar));
					break;
				case R.id.rbplayfair:
					if("".equals(edtxTexto.getText().toString())){
						edtxTexto.setError("Escribe el texto");
						Toast.makeText(getApplicationContext(), "¡Ingresa el texto a cifrar!", Toast.LENGTH_LONG).show();
					}else if("".equals(edtxClave.getText().toString())){
						edtxClave.setError("Escribe la clave");
						Toast.makeText(getApplicationContext(), "'Ingresa la clave!", Toast.LENGTH_LONG);
					}
					try {
						char[] resulplayfair=playfair.Cifrado(array_texto,array_clave);
		                edtxResultado.setText(String.valueOf(resulplayfair));	
					} catch (Exception e) {
						// TODO: handle exception
						Toast.makeText(getApplicationContext(), "¡Ingresa el texto a cifrar!", Toast.LENGTH_LONG).show();
					}
					
	                break;
				case R.id.rbVernam:
					if("".equals(edtxTexto.getText())){
						Toast.makeText(getApplicationContext(), "¡Ingresa el texto a cifrar!", Toast.LENGTH_LONG).show();
		            }else if("".equals(edtxTexto.getText())){
		            	Toast.makeText(getApplicationContext(), "¡Ingresa la clave", Toast.LENGTH_LONG).show();
		            }else if(txt_a_cifrar.length()>10){
		            	Toast.makeText(getApplicationContext(), "La longitud no puede ser mayor a 10", Toast.LENGTH_LONG).show();
		            }else if ("".equals(edtxTexto.getText())) {
		            	Toast.makeText(getApplicationContext(), "¡Ingresa el texto a cifrar!", Toast.LENGTH_LONG).show();
		            }else if(txt_clave.length()>10){
		            	Toast.makeText(getApplicationContext(), "La longitud no puede ser mayor a 10", Toast.LENGTH_LONG).show();
		            }else if(txt_clave.length() != txt_a_cifrar.length()){
		            	Toast.makeText(getApplicationContext(), "El texto y la clave deben tener la misma longitud", Toast.LENGTH_LONG).show();
		            }else{
		                String[] resul=vernam.Cifrado(array_texto,array_clave);
		                char[] resul2 = new char[(resul.length*9)];
		                int sum=0;
		                System.out.println("");
		                for (int i = 0; i < resul.length; i++) {
		                    for (int j = 0; j < 9; j++) {
		                        resul2[sum]=resul[i].charAt(j);
		                        System.out.println(""+resul2[sum]);
		                        sum++;
		                    }
		                }
		                edtxResultado.setText(String.valueOf(resul2));
		            }
		                break;
				case R.id.rbVigenere:
					if("".equals(edtxTexto.getText().toString())){
						Toast.makeText(getApplicationContext(), "¡Ingresa el texto a cifrar!", Toast.LENGTH_LONG).show();
					}
					if("".equals(edtxClave.getText().toString())){
						Toast.makeText(getApplicationContext(), "¡Ingresa la clave", Toast.LENGTH_LONG).show();
					}
					char[] resulvigenere=lotes.Cifrado(array_texto,array_clave);
	                edtxResultado.setText(String.valueOf(resulvigenere));
	                break;
				default:
						Toast.makeText(getApplicationContext(), "No has seleccionado ningún método", Toast.LENGTH_LONG).show();
					break;
				}

			}	
		});
	}

		        
}
