package com.naveen.splitthebillapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Bill extends AppCompatActivity {
    private  Double totalBillAmount;
    private  Integer totalnumberOfPeople;
    private  Double outputAmount;
    private String groupChoice;
    private Double tipPrice;
    private Double totalAmount;

    private final String excellent = "Excellent";
    private final String average = "Average";
    private final String poor = "poor";
    private String comment;

    private final double excellentTip = 0.20;
    private final double averageTip = 0.15;
    private final double poorTip = 0.05;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        //creating the button variable
        Button splitHelpButton2=(Button) findViewById(R.id.button2);
        //validate the splitHelpButton2 reference
        assert  splitHelpButton2!=null;

        //adding the eventhandler for the button
        View.OnClickListener splitHelpButtonListner2=new View.OnClickListener() {
            //creating the variables for the spinner,textView
            final EditText totalBill=(EditText) findViewById(R.id.totalAmount);
            final  EditText numberOfPeople=(EditText) findViewById(R.id.numberOfPeople);
            final Spinner QualityOfService=(Spinner) findViewById(R.id.txtGroup);
            final TextView finalOutput=(TextView)findViewById(R.id.finalOutput);
            final TextView review=(TextView) findViewById(R.id.comment);
            @Override
            public void onClick(View v) {
                //getting the input(totalBill) from user
                Editable Input=totalBill.getText();
                String InputString=Input.toString();
                //getting the input(number of people) from user
                Editable Input2=numberOfPeople.getText();
                String InputString2=Input2.toString();
                try {
                    totalBillAmount =Double.parseDouble(InputString);
                    totalnumberOfPeople=Integer.parseInt(InputString2);


                    groupChoice=QualityOfService.getSelectedItem().toString();

                    DecimalFormat currency=new DecimalFormat("$###,###.##");

                    //tip calculation based on QualityOfService
                    if(groupChoice.equals(excellent)){

                        tipPrice = totalBillAmount * excellentTip;
                        totalAmount = totalBillAmount + tipPrice;
                        outputAmount = totalAmount/totalnumberOfPeople;
                        comment="Review : One of the best meals ever!  I will recommend this place to everyone I know!";

                    }
                    else if (groupChoice.equals(average)){
                        tipPrice = totalBillAmount * averageTip;
                        totalAmount = totalBillAmount + tipPrice;
                        outputAmount = totalAmount/totalnumberOfPeople;
                        comment="Review : Everything was OK.";

                    }
                    else {
                        tipPrice = totalBillAmount * poorTip;
                        totalAmount = totalBillAmount + tipPrice;
                        outputAmount = totalAmount/totalnumberOfPeople;
                        comment="Review : Awful!  The worst!  I can't wait to give negative reviews on Yelp!";
                    }

                    String outputString="The total tip amount is "+ currency.format(tipPrice)+" and the individual share of the bill including the tip is " + currency.format(outputAmount);
                    finalOutput.setText(outputString);
                    review.setText(comment);



                }
                catch (Exception e){
                    Log.e(e.getMessage(),e.toString());
                }

            }
        };

        splitHelpButton2.setOnClickListener(splitHelpButtonListner2 );
    }
}
