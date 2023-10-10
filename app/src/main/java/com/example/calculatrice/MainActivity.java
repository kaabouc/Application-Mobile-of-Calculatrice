package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
//Button btn0,btn1 , btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
        Button add,supp,mul,equal,div ;
private EditText edit ;
   private  int val1=0;
   private  int val2=2;
   private String operation="";
   private boolean isOp1=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = findViewById(R.id.resultat);



    }

//    public   void   relieid(){
//        btn0 = findViewById(R.id.num0);
//        btn1=findViewById(R.id.num1);
//        btn2 = findViewById(R.id.num2);
//        btn3 = findViewById(R.id.num3);
//        btn4 = findViewById(R.id.num4);
//        btn5= findViewById(R.id.num5);
//        btn6 =findViewById(R.id.num6);
//        btn7=findViewById(R.id.num7);
//        btn8=findViewById(R.id.num8);
//        btn9=findViewById(R.id.num9);
//        add=findViewById(R.id.add);
//        supp=findViewById(R.id.suprime);
//        mul=findViewById(R.id.multiple);
//         div = findViewById(R.id.divise);
//         edit = findViewById(R.id.resultat);
//        equal=findViewById(R.id.equal);
//
//    }

    private   void afficher(){
        if (!isOp1){
            edit.setText(String.valueOf(val1)+" "+operation+" "+String.valueOf(val2));
        }else{
            edit.setText(String.valueOf(val1));
        }
    }
    public void setOperation(View v){

         add=findViewById(R.id.add);
         if (R.id.add==v.getId()){
            operation = "+";
        }
        else if (R.id.suprime==v.getId()){
            operation = "-";
        }

        else if (R.id.multiple==v.getId()){
            operation = "*";
        }
        else  if (R.id.divise==v.getId()){
            operation = "/";
        }else {
            return;
         }


        isOp1=false;
        afficher();
    }
    public void ajouterChiffre(View v){
        int val = Integer.parseInt(((Button)v).getText().toString());
        if (isOp1){
            val1=val1*10+val;
            afficher();
        }else {
            val2=val2*10+val;
            afficher();
        }
    }
    public void   calculer(View v){
     if (!isOp1){
         switch (operation){
             case "+" : val1= val1+val2; break;
             case "-" : val1 = val1-val2 ; break;
             case "/" :
                 if (val2==0){
                     val1=0;
                 }else {
                     val1= val1/val2;

                 }   ; break;
             case "*" : val1 = val1*val2; break;
             default :
                    return;
         }

         val2 = 0 ;
         isOp1=true;
         afficher();
     }

    }
    public void reset(View v){
        val1=0; val2=0 ; isOp1=true;
        operation="";
        afficher();
    }

}