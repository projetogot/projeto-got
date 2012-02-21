package qrcode.tees.got;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class PrototipoQrCodeActivity extends Activity implements OnClickListener{
    
	private static final int REQUEST_CODE = 0;
	
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button lerQrButton = (Button)findViewById(R.id.ler_QrCode);    
        lerQrButton.setOnClickListener(this);

        
       

    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    	if (requestCode == REQUEST_CODE) {
    		if (resultCode == Activity.RESULT_OK) {
    			String contents = intent.getStringExtra("SCAN_RESULT");
    			String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
    			Toast.makeText(this, contents + " " + format, Toast.LENGTH_LONG);
    		} else if (resultCode == Activity.RESULT_CANCELED) {
    			// Usuário não fez a leitura do código de barras
    		}
    	}
    }
    
     
    public void onClick(View v) {    
    	Intent intent = new Intent("com.google.zxing.client.android.SCAN"); 
    	intent.putExtra("SCAN_MODE", "ALL_CODE_TYPES"); 
    	startActivityForResult(intent, REQUEST_CODE);    
    }    
    

}