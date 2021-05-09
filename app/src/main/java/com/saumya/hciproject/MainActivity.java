package com.saumya.hciproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    RelativeLayout rl;
    ImageView imageview;
    EditText et;
    EditText textdisplay;
    TextView titletext;
    TextView titleType;
    Button btnradius;
    Button btnnext;
    String label= "Ctrl";

    String Handside="";
    String seqoption="";

    boolean Modeleft = false;
    boolean Moderight = false;
    boolean btnSetRadius = false;
    boolean btnGetRadius = false;

    float floatRadius=0;
    float  LeftfloatRadius =0;
    boolean getRad = false;
    int intTotalButtonOnFirstRow =10;
    int intTotalButtonSecondRow =9;
    int intTotalButtonThirdRow=7;
    int intTotalButtonFourRow =7;
    int intWidthofButton =0;
    int intTotalButtonOnFirstRowLeft =10;
    int intTotalButtonSecondRowLeft =9;
    int intTotalButtonThirdRowLeft=7;
    int intTotalButtonFourRowLeft =7;
    int intWidthofButtonLeft =0;
    String inputString="";
    String Cursor ="|";

    int intHeight=0;
    int intWidth=0;

    int intTrial = 10;
    int counter =0;
    long Stop;

    //=======================================
    // The data for storage :
    String sentence;
    String HandSide;
    String KeyboardTpe;
    long startTime;
    long endTime;
    int ErrorCount=0;
    String keystroke;

    String insertData;
    String insertkeyData;
    String insertData1;
    String insertkeyData1;
    String insertData2;
    String insertkeyData2;

    String insertDataLinear="";
    String insertkeyDataLinear="";
    String insertDataCustom="";
    String insertkeyDataCustom="";
    String insertDataExpandable="";
    String insertkeyDataExpandable="";

    String filename ="";
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss");
    String filename1 = "";

    long startKeyTimes;
    long StopKeyTime;

    int intTotalCount =0;
    //======================================
    float StartX=0, StartY=0, EndX =0, EndY =0;
    float cornerX=1175;
    float CornerY=1620;
    float LeftcornerX=0;
    float LeftCornerY=1620;
    int intButtonDistance=0;

    int intButtonDistanceLeft=0;
    String text="";
    private boolean displayCursor=true;
    private boolean cursorOn =false;
    String pointer ="_";
    int i =-1;
    int intsentence =0;
    Spinner myspinner;
    Spinner keySpinner;
//==============================================================================================
    ArrayList<String> childlistFirstRow = new ArrayList<String>();
    ArrayList<String> childlistNumber = new ArrayList<String>();
    ArrayList<String> childlistSecondRow = new ArrayList<String>();
    ArrayList<String> childlistThirdRow = new ArrayList<String>();
    ArrayList<String> childlistFourdRow = new ArrayList<String>();
    ArrayList<String> childlistSymbol = new ArrayList<String>();
    ArrayList<String> childlistSymbolSecond = new ArrayList<String>();
//========================================================================================
    ArrayList<String> expandKey = new ArrayList<String>();
    ArrayList<String> ListofSentence = new ArrayList<String>();
    ArrayList<String> LeftchildlistFirstRow = new ArrayList<String>();
    ArrayList<String> LeftchildlistSecondRow = new ArrayList<String>();
    ArrayList<String> LeftchildlistThirdRow = new ArrayList<String>();
    ArrayList<String> LeftchildlistFourRow = new ArrayList<String>();
    ArrayList<String> LeftchildlistSymbol = new ArrayList<String>();
    ArrayList<String> LeftchildlistSymbolSecond = new ArrayList<String>();
    ArrayList<String> LeftchildlistNumber = new ArrayList<String>();
    List<String> categories = new ArrayList<String>();
    List<String> keyboardType = new ArrayList<String>();
    List<String> sequence = new ArrayList<String>();

    String red = "|";
    SpannableString redSpannable;

//====================================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.rl);
        imageview = findViewById(R.id.img);

        btnradius=findViewById(R.id.btnradius);

        btnnext =findViewById(R.id.btnext);
        myspinner=findViewById(R.id.Handside);
        keySpinner=findViewById(R.id.keyboard);
        et = findViewById(R.id.textid);
        et.requestFocus();
        //et.setTextColor(Color.BLACK);
        et.setShowSoftInputOnFocus(false);
        if(et!=null) et.requestFocus();
        textdisplay=findViewById(R.id.textdisplay);
       // titletext=findViewById(R.id.titledisplay);
       // titleType=findViewById(R.id.titletextid);
        //blk=findViewById(R.id.blinkid);

        String nowDate = formatter.format(Calendar.getInstance().getTime());
        redSpannable = new SpannableString(red);
        redSpannable.setSpan(new ForegroundColorSpan(Color.RED), 0, red.length(), 0);

        //Create the filename
        childlistFirstRow.add("Q");
        childlistFirstRow.add("W");
        childlistFirstRow.add("E");
        childlistFirstRow.add("R");
        childlistFirstRow.add("T");
        childlistFirstRow.add("Y");
        childlistFirstRow.add("U");
        childlistFirstRow.add("I");
        childlistFirstRow.add("O");
        childlistFirstRow.add("P");

        childlistSecondRow.add("A");
        childlistSecondRow.add("S");
        childlistSecondRow.add("D");
        childlistSecondRow.add("F");
        childlistSecondRow.add("G");
        childlistSecondRow.add("H");
        childlistSecondRow.add("J");
        childlistSecondRow.add("K");
        childlistSecondRow.add("L");

        childlistThirdRow.add("Z");
        childlistThirdRow.add("X");
        childlistThirdRow.add("C");
        childlistThirdRow.add("V");
        childlistThirdRow.add("B");
        childlistThirdRow.add("N");
        childlistThirdRow.add("M");

        childlistFourdRow.add("CAP");
        childlistFourdRow.add("#?2");
        childlistFourdRow.add(",");
        childlistFourdRow.add(".");
        childlistFourdRow.add("Spc");
        childlistFourdRow.add("\u232b");
        childlistFourdRow.add("Ent");

        LeftchildlistFirstRow.add("P");
        LeftchildlistFirstRow.add("O");
        LeftchildlistFirstRow.add("I");
        LeftchildlistFirstRow.add("U");
        LeftchildlistFirstRow.add("Y");
        LeftchildlistFirstRow.add("T");
        LeftchildlistFirstRow.add("R");
        LeftchildlistFirstRow.add("E");
        LeftchildlistFirstRow.add("W");
        LeftchildlistFirstRow.add("Q");

        LeftchildlistSecondRow.add("L");
        LeftchildlistSecondRow.add("K");
        LeftchildlistSecondRow.add("J");
        LeftchildlistSecondRow.add("H");
        LeftchildlistSecondRow.add("G");
        LeftchildlistSecondRow.add("F");
        LeftchildlistSecondRow.add("D");
        LeftchildlistSecondRow.add("S");
        LeftchildlistSecondRow.add("A");

        LeftchildlistThirdRow.add("M");
        LeftchildlistThirdRow.add("N");
        LeftchildlistThirdRow.add("B");
        LeftchildlistThirdRow.add("V");
        LeftchildlistThirdRow.add("C");
        LeftchildlistThirdRow.add("X");
        LeftchildlistThirdRow.add("Z");

        LeftchildlistFourRow.add("Ent");
        LeftchildlistFourRow.add("\u232b");
        LeftchildlistFourRow.add("Spc");
        LeftchildlistFourRow.add(".");
        LeftchildlistFourRow.add(",");
        LeftchildlistFourRow.add("#?2");
        LeftchildlistFourRow.add("CAP");

        childlistNumber.add("1");
        childlistNumber.add("2");
        childlistNumber.add("3");
        childlistNumber.add("4");
        childlistNumber.add("5");
        childlistNumber.add("6");
        childlistNumber.add("7");
        childlistNumber.add("8");
        childlistNumber.add("9");
        childlistNumber.add("0");

        LeftchildlistNumber.add("0");
        LeftchildlistNumber.add("9");
        LeftchildlistNumber.add("8");
        LeftchildlistNumber.add("7");
        LeftchildlistNumber.add("6");
        LeftchildlistNumber.add("5");
        LeftchildlistNumber.add("4");
        LeftchildlistNumber.add("3");
        LeftchildlistNumber.add("2");
        LeftchildlistNumber.add("1");

        childlistSymbol.add("!");
        childlistSymbol.add("@");
        childlistSymbol.add("#");
        childlistSymbol.add("$");
        childlistSymbol.add("^");
        childlistSymbol.add("%");
        childlistSymbol.add("&");
        childlistSymbol.add("*");
        childlistSymbol.add("-");

        childlistSymbolSecond.add("{");
        childlistSymbolSecond.add("}");
        childlistSymbolSecond.add(":");
        childlistSymbolSecond.add(";");
        childlistSymbolSecond.add("?");
        childlistSymbolSecond.add("\u0027");
        childlistSymbolSecond.add("\"");

        LeftchildlistSymbol.add("-");
        LeftchildlistSymbol.add("*");
        LeftchildlistSymbol.add("&");
        LeftchildlistSymbol.add("^");
        LeftchildlistSymbol.add("%");
        LeftchildlistSymbol.add("$");
        LeftchildlistSymbol.add("#");
        LeftchildlistSymbol.add("@");
        LeftchildlistSymbol.add("!");

        LeftchildlistSymbolSecond.add("\"");
        LeftchildlistSymbolSecond.add("\u0027");
        LeftchildlistSymbolSecond.add("?");
        LeftchildlistSymbolSecond.add(";");
        LeftchildlistSymbolSecond.add(":");
        LeftchildlistSymbolSecond.add("}");
        LeftchildlistSymbolSecond.add("{");

        expandKey.add("Q-P");
        expandKey.add("A-L");
        expandKey.add("Z-M");
        expandKey.add("Ctrl");

        ListofSentence.add("hi welcome all");
       ListofSentence.add("take a tea break");
        /* ListofSentence.add("have a nice day");
        ListofSentence.add("hope is the way");
        ListofSentence.add("user friendly interface");
        ListofSentence.add("Mary had a lamb");
        ListofSentence.add("Everybody loves laughing");
        ListofSentence.add("are you talking to me");
        ListofSentence.add("starlight and dewdrop");
        ListofSentence.add("thank you for your help"); */
        //ListofSentence.add("University of Manitoba");*/
//============================================================================================

        intHeight=1520;
        intWidth=1175;

        Button btn = new Button(getApplicationContext());
        RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(30, 30);

        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(50); //You can manage the blinking time with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);

        myspinner.setOnItemSelectedListener(this);
        categories.add("Set_Handedness");
        categories.add("Right");
        categories.add("Left");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(dataAdapter);

        keySpinner.setOnItemSelectedListener(this);
        keyboardType.add("Set_keyboard");
        keyboardType.add("Linear Keyboard");
        keyboardType.add("Custom KeyBoard");
        keyboardType.add("Expandable");

        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, keyboardType);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        keySpinner.setAdapter(dataAdapter1);

        insertData = "Handside,Keyboard_Type,Sentence,Trial_No,startTime,stopTime,Error,Counter\n";
        insertkeyData = "Handside,Keyboard_Type,Sentence,Trial_No,keystroke,startTime,StopTime,Error,Counter\n";
        insertData1 = "Handside,Keyboard_Type,Sentence,Trial_No,startTime,stopTime,Error,Counter\n";
        insertkeyData1 = "Handside,Keyboard_Type,Sentence,Trial_No,keystroke,startTime,StopTime,Error,Counter\n";
        insertData2 = "Handside,Keyboard_Type,Sentence,Trial_No,startTime,stopTime,Error,Counter\n";
        insertkeyData2 = "Handside,Keyboard_Type,Sentence,Trial_No,keystroke,startTime,StopTime,Error,Counter\n";

        btnradius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnradius.getText().equals("Get Radius"))
                {
                    btnradius.setText("OK");
                    getRad=false;
                    if(!btnSetRadius)
                    {
                        alertDialog("Hold the device in one hand.\n Draw Radius using Thumb on the canvas \n To set the Radius Click OK.","Instruction");
                        btnSetRadius=true;
                    }

                }
                else
                {
                    btnradius.setText("Get Radius");
                    if(!btnGetRadius)
                    {
                        alertDialog("The Radius is set.\n\n Select the keyboard type to access different keyboard\n\n Note : If need to change, click on \"GET RADIUS\" \n\n ","Instruction");
                        btnGetRadius=true;
                    }

                    keySpinner.setEnabled(true);
                    btnnext.setEnabled(true);
                    getRad=true;
                    for(int i=0;i<50;i++)
                    {
                        ClearRadius();

                    }

                }

            }
        });

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(btnnext.getText().toString().equals("Start"))
                {
                    btnradius.setEnabled(false);
                    myspinner.setEnabled(false);
                    if(keySpinner.getSelectedItem().toString().equals("Set_keyboard"))
                    {
                        alertDialog(" Please set the keyboard","Instruction");
                       //keySpinner.setEnabled(false);
                    }
                    else
                    {
                        keySpinner.setEnabled(false);
                        btnnext.setEnabled(false);
                        btnnext.setText("Next");
                        String sent = ListofSentence.get(intsentence);
                        alertDialog(" Timer will start only when user start typing. \n\n Note: The timer will stop provided the text entered is identical to the displayed text.\n\n Please hold the device in one hand only.\n\n Start typing when you are ready :)","Instruction");
                        intsentence++;
                        textdisplay.setText(sent);
                        sentence =sent;
                        et.setText(redSpannable);
                    }

                }
                else if(btnnext.getText().toString().equals("Next"))
                {
                    if(intsentence<ListofSentence.size())
                    {
                        btnradius.setEnabled(false);
                        myspinner.setEnabled(false);
                        btnnext.setEnabled(false);
                        inputString="";

                        ErrorCount =0;
                        String sent = ListofSentence.get(intsentence);
                        intsentence++;
                        sentence=sent;
                        textdisplay.setText(sent);
                        et.setText(redSpannable);
                    }
                    else
                    {
                        btnnext.setText("Stop");
                        btnnext.setEnabled(true);
                        alertDialog(" Level Complete. \n\n Click STOP to continue.","Instruction");
                        intTotalCount++;
                    }

                }
                else if(btnnext.getText().toString().equals("Stop"))
                 {
                     if(intTotalCount <3)
                     {
                         btnradius.setEnabled(false);
                         myspinner.setEnabled(false);
                         keySpinner.setEnabled(true);
                         keySpinner.setSelection(0);
                         btnnext.setText("Start");
                         alertDialog(" Thank you. \n Repeat the same experiment using another Keyboard type \n click START when ready","Instruction");
                         intsentence=0;
                         inputString="";
                         et.setText(redSpannable);
                         textdisplay.setText("");

                         if(insertDataLinear.length()>1)
                         {
                             filename = "LinearKeyBoard"+nowDate+".csv";
                             filename1 = "LinearKeyStroke"+nowDate+".csv";
                             insertData=insertData+insertDataLinear;
                             insertkeyData=insertkeyData+insertkeyDataLinear;
                             WriteFile(insertData,MainActivity.this);
                             WriteFile1(insertkeyDataLinear,MainActivity.this);
                             insertDataLinear="";
                             insertData="";
                             insertkeyData="";
                             insertkeyDataLinear="";
                         }

                         if(insertDataCustom.length()>1)
                         {
                             filename = "CustomKeyboard"+nowDate+".csv";
                             filename1 = "CustomKeyStroke"+nowDate+".csv";
                             insertData1=insertData1+insertDataCustom;
                             insertkeyData1=insertData1+insertkeyDataCustom;
                             WriteFile(insertData1,MainActivity.this);
                             WriteFile1(insertkeyData1,MainActivity.this);
                             insertData1="";
                             insertkeyData1="";
                             insertDataCustom="";
                             insertkeyDataCustom="";
                         }

                         if(insertDataExpandable.length()>1)
                         {
                             filename = "ExpandableKeyboard"+nowDate+".csv";
                             filename1 = "ExpandableKeyStroke"+nowDate+".csv";

                             insertData2=insertData2+insertDataExpandable;
                             insertkeyData2=insertkeyData2+insertkeyDataExpandable;
                             WriteFile(insertData2,MainActivity.this);
                             WriteFile1(insertkeyData2,MainActivity.this);
                             insertDataExpandable="";
                             insertkeyDataExpandable="";
                             insertData2="";
                             insertkeyData2="";

                         }
                     }
                     else
                     {
                         btnnext.setText("Exit");
                         btnnext.setEnabled(true);
                         System.out.println("Thank You");
                         alertDialog(" Thank You.\n .csv file is created in the Internal Storage. \n \n Click OK to exit.","Information");

                         if(insertDataLinear.length()>1)
                         {
                             filename = "LinearKeyBoard"+nowDate+".csv";
                             filename1 = "LinearKeyStroke"+nowDate+".csv";
                             insertData=insertData+insertDataLinear;
                             insertkeyData=insertkeyData+insertkeyDataLinear;
                             WriteFile(insertData,MainActivity.this);
                             WriteFile1(insertkeyDataLinear,MainActivity.this);
                             insertDataLinear="";
                             insertData="";
                             insertkeyData="";
                             insertkeyDataLinear="";
                         }

                         if(insertDataCustom.length()>1)
                         {
                             filename = "CustomKeyboard"+nowDate+".csv";
                             filename1 = "CustomKeyStroke"+nowDate+".csv";
                             insertData1=insertData1+insertDataCustom;
                             insertkeyData1=insertData1+insertkeyDataCustom;
                             WriteFile(insertData1,MainActivity.this);
                             WriteFile1(insertkeyData1,MainActivity.this);
                             insertData1="";
                             insertkeyData1="";
                             insertDataCustom="";
                             insertkeyDataCustom="";
                         }

                         if(insertDataExpandable.length()>1)
                         {
                             filename = "ExpandableKeyboard"+nowDate+".csv";
                             filename1 = "ExpandableKeyStroke"+nowDate+".csv";

                             insertData2=insertData2+insertDataExpandable;
                             insertkeyData2=insertkeyData2+insertkeyDataExpandable;
                             WriteFile(insertData2,MainActivity.this);
                             WriteFile1(insertkeyData2,MainActivity.this);
                             insertDataExpandable="";
                             insertkeyDataExpandable="";
                             insertData2="";
                             insertkeyData2="";

                         }
                     }
                 }
                else if(btnnext.getText().toString().equals("Exit"))
                {
                    System.exit(0);
                }
                else
                {
                    btnradius.setEnabled(false);
                    myspinner.setEnabled(false);
                    btnnext.setText("Start");
                    alertDialog(" Select the Keyboard and click START when ready","Instruction");
                    inputString="";
                    et.setText(redSpannable);
                    keySpinner.setAdapter(dataAdapter1);
                }
            }
        });
        System.out.println("X: " + btn.getX() + " Y: " + btn.getY());
        //rl.addView(btn);
        rl.setOnTouchListener(View::onTouchEvent);
    }
//========================================================================================
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int[] point =new int[2];
        imageview.getLocationOnScreen(point);

        float x = event.getRawX();
        float y = event.getRawY();

        if(getRad)
        {
            return false;
        }
        else
        {
            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(30, 30);
            bp.leftMargin =(int) x-point[0];
            bp.topMargin = (int) y-point[1];
            btn.setLayoutParams(bp);
            // System.out.println("X: " + btn.getX()+" Y: "+btn.getY());
            rl.addView(btn);
            switch(event.getAction())
            {
                case MotionEvent.ACTION_DOWN:
                    StartX =  x-point[0];
                    StartY= y-point[1];
                   // System.out.println("StartX :"+StartX+"StartY :"+StartY);

                    break;
                case MotionEvent.ACTION_UP:
                    EndX =  x-point[0];
                    EndY=y-point[1];
                  //  System.out.println("EndX: "+EndX+"EndY:"+EndY);
                    if(Modeleft)
                    {
                        leftdis();
                    }
                    if(Moderight)
                    {
                        rightdis();
                    }
                    break;
            }
            return true;
        }
    }
//========================================================================================
    private void rightdis()
    {
        float distance = (float) Math.sqrt(((cornerX-StartX)*(cornerX-StartX))+((CornerY-StartY)*(CornerY-StartY)));
        float distance1 = (float) Math.sqrt(((cornerX-EndX)*(cornerX-EndX))+((CornerY-EndY)*(CornerY-EndY)));
        float radius = ((distance+distance1)/2);
        if(radius<700)
        {
            floatRadius =700;
            intButtonDistance =1100;
        }
        else
        {
            floatRadius =radius;
           // intButtonDistance = (int) Math.sqrt(((EndX-StartX)*(EndX-StartX))+((EndY-StartY)*(EndY-StartY)));
            intButtonDistance=(int)((Math.PI*floatRadius)/2);
        }
        // et.setText("Start:"+String.valueOf(distance));
        //et.setText("End:"+String.valueOf(distance));
        // et.setText("Start:"+ StartX+" , "+StartY+" , "+String.valueOf(distance)+"\nEnd:"+EndX+" , "+EndY+" , "+String.valueOf(distance1)+"\nRadius: "+String.valueOf(radius)+" Distance :"+intButtonDistance);
    }
//===============================================================================================================
    private void leftdis()
    {
        float distance = (float) Math.sqrt(((0-StartX)*(0-StartX))+((1620-StartY)*(1620-StartY)));
        float distance1 = (float) Math.sqrt(((0-EndX)*(0-EndX))+((1620-EndY)*(1620-EndY)));
        float radius = ((distance+distance1)/2);
        if(radius<700){
            LeftfloatRadius =700;
            intButtonDistanceLeft =1100;
        }
        else
        {
            LeftfloatRadius =radius;
            //intButtonDistanceLeft = (int) Math.sqrt(((EndX-StartX)*(EndX-StartX))+((EndY-StartY)*(EndY-StartY)));
            intButtonDistanceLeft=(int)((Math.PI*LeftfloatRadius)/2);
        }
        // et.setText("Start:"+String.valueOf(distance));
        //et.setText("End:"+String.valueOf(distance));
       et.setText("Start:"+ StartX+" , "+StartY+" , "+String.valueOf(distance)+"\nEnd:"+EndX+" , "+EndY+" , "+String.valueOf(distance1)+"\nRadius: "+String.valueOf(radius)+" Distance :"+intButtonDistanceLeft);
    }
//======================================================================================
    private void ClearRadius()
    {
        int intChildCount = rl.getChildCount();
        //System.out.println("ChildCount"+intChildCount);
        for(int i=4; i<intChildCount; i++) {
            View child = rl.getChildAt(i);
            rl.removeView(child);
            //System.out.println("i : "+i);
        }
    }
//===========================================================================================
    private void alertDialog(String msg, String Title) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage(msg);
        dialog.setTitle(Title);
        dialog.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                    }
                });

        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
        dialog.setCancelable(false);
        alertDialog.setCanceledOnTouchOutside(false);
    }
//====================================================================================================
    private void DrawKeyboard()
    {
        int intSecondRadius = (int) floatRadius-105;
        int intThirdRadius = (int) floatRadius-210;
        int intFourRadius = (int) floatRadius-315;
        int intSecondButtonWidth = ((intButtonDistance-100)/intTotalButtonSecondRow);
        int intThirdButtonWidth = ((intButtonDistance-200)/intTotalButtonThirdRow);
        int intFourthButtonWidth = ((intButtonDistance-300)/intTotalButtonFourRow);
        double dblArcAngle = (90/intTotalButtonOnFirstRow);
        double dblArcAngleSecond = (90/intTotalButtonSecondRow);
        double dblArcAngleThird=(90/intTotalButtonThirdRow);
        double dblArcAngleFour=(90/intTotalButtonFourRow);

        for(int i=0;i<intTotalButtonOnFirstRow;i++)
        {
            double dblButtonAngle = dblArcAngle * i;
            int w = (int)Math.sqrt((2*floatRadius*floatRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));
            int intButtonX = (int) (intWidth - floatRadius+x);
            int intButtonY = intHeight - y;

            //create and place button at X and Y
            int intButtonWidth = intButtonDistance/intTotalButtonOnFirstRow;
            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intButtonWidth, 100);
            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(dblButtonAngle-90));
            text = childlistFirstRow.get(i);
            btn.setTextSize(20);
            btn.setText(text.toLowerCase());
            btn.setAllCaps(false);

            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                       // System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataCustom = insertkeyDataCustom+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                   // WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataCustom = insertDataCustom + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                       // WriteFile(insertData,MainActivity.this);
                    }

                }
            });

        }
        for(int i=0;i<intTotalButtonSecondRow;i++)
        {
            double dblButtonAngle = dblArcAngleSecond * i;
            int w = (int)Math.sqrt((2*intSecondRadius*intSecondRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));
            //get button position X and Y
            int intButtonX = (int) (intWidth - intSecondRadius+x);
            int intButtonY = intHeight - y;

            //create and place button at X and Y
            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intSecondButtonWidth, 100);
            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(dblButtonAngle-90));
            text = childlistSecondRow.get(i);
            btn.setTextSize(20);
            btn.setText(text.toLowerCase());
            btn.setAllCaps(false);
            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataCustom = insertkeyDataCustom+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                   // WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataCustom = insertDataCustom + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                      //  WriteFile(insertData,MainActivity.this);
                    }

                }
            });

        }
        for(int i=0;i<intTotalButtonThirdRow;i++)
        {
            double dblButtonAngle = dblArcAngleThird * i;
            int w = (int)Math.sqrt((2*intThirdRadius*intThirdRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));
            //get button position X and Y
            int intButtonX = (int) (intWidth - intThirdRadius+x);
            int intButtonY = intHeight - y;

            //create and place button at X and Y
            Button btn = new Button(getApplicationContext());
            text = childlistThirdRow.get(i);

            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intThirdButtonWidth, 100);

            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(dblButtonAngle-90));
            btn.setTextSize(20);
            btn.setText(text.toLowerCase());
            btn.setAllCaps(false);
            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataCustom = insertkeyDataCustom+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                    //WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataCustom = insertDataCustom + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                       // WriteFile(insertData,MainActivity.this);
                    }

                }
            });

        }
        for(int i=0;i<intTotalButtonFourRow;i++)
        {
            double dblButtonAngle;
            text = childlistFourdRow.get(i);
            dblButtonAngle = dblArcAngleFour * i;

            int w = (int)Math.sqrt((2*intFourRadius*intFourRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));
            //get button position X and Y
            int intButtonX = (int) (intWidth - intFourRadius+x);
            int intButtonY = intHeight - y;

            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intFourthButtonWidth, 100);
            text = childlistFourdRow.get(i);
            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(dblButtonAngle-90));
            btn.setTextSize(15);
            btn.setText(text);

            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(btn.getText().equals("CAP"))
                    {
                            CapKeyboard();
                    }
                    if(btn.getText().equals("#?2") || btn.getText().equals("abc"))
                    {
                        if(btn.getText().equals("abc"))
                        {
                            DrawKeyboard();
                            btn.setText("#?2");
                        }
                        else
                        {
                            btn.setText("abc");
                            btn.setAllCaps(false);
                            NumKey();
                        }

                    }
                    if(btn.getText().equals("."))
                    {

                        if(et.getText().toString().equals("|"))
                        {
                            startTime=Calendar.getInstance().getTimeInMillis();
                            //System.out.println(startTime);
                            startKeyTimes = Calendar.getInstance().getTimeInMillis();
                        }

                        inputString= inputString+btn.getText().toString();
                        if(inputString.isEmpty())
                        {
                            et.setText(redSpannable);
                        }
                        else
                        et.setText(inputString);
                        et.append(redSpannable);
                        keystroke =btn.getText().toString();
                        StopKeyTime=Calendar.getInstance().getTimeInMillis();
                        insertkeyDataCustom = insertkeyDataCustom+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                        //System.out.println(insertkeyData);
                       // WriteFile1(insertkeyData,MainActivity.this);
                        if(textdisplay.getText().toString().equals(inputString))
                        {
                            btnnext.setEnabled(true);
                            alertDialog(" Click NEXT for the next sentence. ","Instruction");
                            endTime=Calendar.getInstance().getTimeInMillis();
                            insertDataCustom = insertDataCustom + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                           // System.out.println(insertData);
                           // WriteFile(insertData,MainActivity.this);
                        }

                        //et.append(btn.getText());
                    }
                    if(btn.getText().equals(","))
                    {
                        if(et.getText().toString().equals("|"))
                        {
                            startTime=Calendar.getInstance().getTimeInMillis();
                            //System.out.println(startTime);
                            startKeyTimes = Calendar.getInstance().getTimeInMillis();
                        }

                        inputString= inputString+btn.getText().toString();
                        if(inputString.isEmpty())
                        {
                            et.setText(redSpannable);
                        }
                        else
                        et.setText(inputString);
                        et.append(redSpannable);
                        keystroke =btn.getText().toString();
                        StopKeyTime=Calendar.getInstance().getTimeInMillis();
                        insertkeyDataCustom = insertkeyDataCustom+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                        //System.out.println(insertkeyData);
                       // WriteFile1(insertkeyData,MainActivity.this);
                        if(textdisplay.getText().toString().equals(inputString))
                        {
                            btnnext.setEnabled(true);
                            alertDialog(" Click NEXT for the next sentence. ","Instruction");
                            endTime=Calendar.getInstance().getTimeInMillis();
                            insertDataCustom = insertDataCustom + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                            //System.out.println(insertData);
                            //WriteFile(insertData,MainActivity.this);
                        }

                    }
                    if(btn.getText().equals("Spc"))
                    {
                        inputString= inputString+" ";
                        if(inputString.isEmpty())
                        {
                            et.setText(redSpannable);
                        }
                        else
                        et.setText(inputString);
                        et.append(redSpannable);
                        keystroke ="Spc";
                        StopKeyTime=Calendar.getInstance().getTimeInMillis();
                        insertkeyDataCustom = insertkeyDataCustom+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                        //System.out.println(insertkeyData);
                       // WriteFile1(insertkeyData,MainActivity.this);
                        if(textdisplay.getText().toString().equals(inputString))
                        {
                            btnnext.setEnabled(true);
                            alertDialog(" Click NEXT for the next sentence. ","Instruction");
                            endTime=Calendar.getInstance().getTimeInMillis();
                            insertDataCustom = insertDataCustom + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                            //System.out.println(insertData);
                           // WriteFile(insertData,MainActivity.this);
                        }
                    }
                    else if(btn.getText().equals("\u232b"))
                    {   String str;
                        if(et.getText().equals(""))
                        {
                            str=redSpannable.toString();
                        }
                        else
                        str = et.getText().toString();
                        System.out.println("String for backspace:"+str);
                        text = backspace(str);
                        inputString=text;
                        if(inputString.isEmpty())
                        {
                            et.setText("");
                        }
                        else
                        et.setText(inputString);
                        et.append(redSpannable);
                        keystroke ="Bsp";
                        StopKeyTime=Calendar.getInstance().getTimeInMillis();
                        insertkeyDataCustom = insertkeyDataCustom+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                        //System.out.println(insertkeyData);
                        //WriteFile1(insertkeyData,MainActivity.this);
                        if(textdisplay.getText().toString().equals(inputString))
                        {
                            btnnext.setEnabled(true);
                            alertDialog(" Click NEXT for the next sentence. ","Instruction");
                            endTime=Calendar.getInstance().getTimeInMillis();
                            insertDataCustom = insertDataCustom + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                            //System.out.println(insertData);
                            //WriteFile(insertData,MainActivity.this);
                        }
                    }
                    else if(btn.getText().equals("Ent"))
                    {
                        inputString= inputString+"\n";
                        if(inputString.isEmpty())
                        {
                            et.setText(redSpannable);
                        }
                        else
                        et.setText(inputString);
                        et.append(redSpannable);
                        keystroke ="Ent";
                        StopKeyTime=Calendar.getInstance().getTimeInMillis();
                        insertkeyDataCustom = insertkeyDataCustom+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                        //System.out.println(insertkeyData);
                        //WriteFile1(insertkeyData,MainActivity.this);
                        if(textdisplay.getText().toString().equals(inputString))
                        {
                            btnnext.setEnabled(true);
                            alertDialog(" Click NEXT for the next sentence. ","Instruction");
                            endTime=Calendar.getInstance().getTimeInMillis();
                            insertDataCustom = insertDataCustom + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                            //System.out.println(insertData);
                            //WriteFile(insertData,MainActivity.this);
                        }
                    }
                    else
                       System.out.println("The text :"+et.getText().length());
                }
            });
        }
     }
//================================================================================================================
    private double getThetaInRadian(double  x)
    {
        x = Math.toRadians(x);
        double theta = Math.cos((x));
        return theta;
    }
//==============================================================================================================
    private String backspace(String str)
    {
        if(str.length()<2)
        {
            return "";
        }
        ErrorCount++;
        str = str.substring(0, str.length() - 2);
        return str;
    }
//================================================================================================================
    private void firstRow() {

        double dblArcAngle = (90 / intTotalButtonOnFirstRow);

        for (int i = 0; i < intTotalButtonOnFirstRow; i++) {
            double dblButtonAngle = dblArcAngle * i;
            int w = (int) Math.sqrt((2 * floatRadius * floatRadius) * (1 - getThetaInRadian(dblButtonAngle)));
            double t1 = 90 - (dblButtonAngle / 2);
            int x = (int) (w * getThetaInRadian(t1));
            int y = (int) Math.sqrt((w * w) - (x * x));

            //get button position X and Y
            int intButtonX = (int) (intWidth - floatRadius + x);
            int intButtonY = intHeight - y;

            //create and place button at X and Y
            int intButtonWidth = intButtonDistance / intTotalButtonOnFirstRow;
            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intButtonWidth, 100);
            bp.leftMargin = (int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float) (dblButtonAngle - 90));
            text = childlistFirstRow.get(i);
            btn.setText(text.toLowerCase());
            btn.setTextSize(20);
            btn.setAllCaps(false);
            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataExpandable = insertkeyDataExpandable+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                    //WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataExpandable = insertDataExpandable + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                      //  WriteFile(insertData,MainActivity.this);
                    }
                }
            });

        }
    }
    private void secondRow() {

        int intSecondRadius = (int) floatRadius;
        int intSecondButtonWidth = ((intButtonDistance) / intTotalButtonSecondRow);
        double dblArcAngleSecond = (90 / intTotalButtonSecondRow);

        for(int i=0;i<intTotalButtonSecondRow;i++)
        {
            double dblButtonAngle = dblArcAngleSecond * i;
            int w = (int)Math.sqrt((2*intSecondRadius*intSecondRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));

            //get button position X and Y
            int intButtonX = (int) (intWidth - intSecondRadius+x);
            int intButtonY = intHeight - y;

            //create and place button at X and Y

            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intSecondButtonWidth, 100);
            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(dblButtonAngle-90));
            text = childlistSecondRow.get(i);
            btn.setText(text.toLowerCase());
            btn.setTextSize(20);
            btn.setAllCaps(false);
            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataExpandable = insertkeyDataExpandable+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                   // WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataExpandable = insertDataExpandable + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                       // System.out.println(insertData);
                     //   WriteFile(insertData,MainActivity.this);
                    }
                }
            });

        }
    }
    private void thirdRow() {
        int intThirdRadius = (int) floatRadius;
        int intThirdButtonWidth = ((intButtonDistance) / intTotalButtonThirdRow);
        double dblArcAngleThird = (90 / intTotalButtonThirdRow);


        for(int i=0;i<intTotalButtonThirdRow;i++)
        {
            double dblButtonAngle = dblArcAngleThird * i;
            int w = (int)Math.sqrt((2*intThirdRadius*intThirdRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));
            //get button position X and Y
            int intButtonX = (int) (intWidth - intThirdRadius+x);
            int intButtonY = intHeight - y;

            //create and place button at X and Y

            Button btn = new Button(getApplicationContext());
            text = childlistThirdRow.get(i);

            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intThirdButtonWidth, 100);

            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(dblButtonAngle-90));
            btn.setTextSize(20);
            btn.setText(text.toLowerCase());
            btn.setAllCaps(false);

            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataExpandable = insertkeyDataExpandable+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                   // WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataExpandable = insertDataExpandable + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                     //   WriteFile(insertData,MainActivity.this);
                    }
                }
            });

        }
    }
    private String fourthRow()
    {
        int intFourRadius = (int) floatRadius;
        int intFourthButtonWidth = ((intButtonDistance)/intTotalButtonFourRow);

        double dblArcAngleFour=(90/intTotalButtonFourRow);

        for(int i=0;i<intTotalButtonFourRow;i++)
        {

            double dblButtonAngle = dblArcAngleFour * i;
            int w = (int)Math.sqrt((2*intFourRadius*intFourRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));
            //System.out.println("w: "+w+" t1: "+t1);
            //System.out.println("x: "+x+" y: "+y);
            //get button position X and Y
            int intButtonX = (int) (intWidth - intFourRadius+x);
            int intButtonY = intHeight - y;

            //create and place button at X and Y
            // int intButtonWidth = intButtonDistance/inTotalButtonOnRow;
            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intFourthButtonWidth, 100);
            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(dblButtonAngle-90));
            text = childlistFourdRow.get(i);
            btn.setTextSize(20);
            btn.setText(text);
            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   label = btn.getText().toString();
                   if(label.equals("CAP"))
                   {
                       repeatKey();
                       CapExpandableKeyboard();

                   }
                    if(label.equals("#?2"))
                    {
                        repeatKey();
                        btn.setText("abc");
                        SymBolExpandableKeyboard();

                    }
                    if(label.equals("."))
                    {
                        if(et.getText().toString().equals("|"))
                        {
                            startTime=Calendar.getInstance().getTimeInMillis();
                            //System.out.println(startTime);
                            startKeyTimes = Calendar.getInstance().getTimeInMillis();
                        }

                        inputString= inputString+btn.getText().toString();
                        if(inputString.isEmpty())
                        {
                            et.setText(redSpannable);
                        }
                        else
                        et.setText(inputString);
                        et.append(redSpannable);
                        keystroke =btn.getText().toString();
                        StopKeyTime=Calendar.getInstance().getTimeInMillis();
                        insertkeyDataExpandable = insertkeyDataExpandable+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                        //System.out.println(insertkeyData);
                       // WriteFile1(insertkeyData,MainActivity.this);
                        if(textdisplay.getText().toString().equals(inputString))
                        {
                            btnnext.setEnabled(true);
                            alertDialog(" Click NEXT for the next sentence. ","Instruction");
                            endTime=Calendar.getInstance().getTimeInMillis();
                            insertDataExpandable = insertDataExpandable + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                            //System.out.println(insertData);
                         //   WriteFile(insertData,MainActivity.this);

                        }
                    }
                    if(label.equals(","))
                    {
                        if(et.getText().toString().equals("|"))
                        {
                            startTime=Calendar.getInstance().getTimeInMillis();
                            //System.out.println(startTime);
                            startKeyTimes = Calendar.getInstance().getTimeInMillis();
                        }

                        inputString= inputString+btn.getText().toString();
                        if(inputString.isEmpty())
                        {
                            et.setText(redSpannable);
                        }
                        else
                        et.setText(inputString);
                        et.append(redSpannable);
                        keystroke =btn.getText().toString();
                        StopKeyTime=Calendar.getInstance().getTimeInMillis();
                        insertkeyDataExpandable = insertkeyDataExpandable+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                        //System.out.println(insertkeyData);
                       // WriteFile1(insertkeyData,MainActivity.this);
                        if(textdisplay.getText().toString().equals(inputString))
                        {
                            btnnext.setEnabled(true);
                            alertDialog(" Click NEXT for the next sentence. ","Instruction");
                            endTime=Calendar.getInstance().getTimeInMillis();
                            insertDataExpandable = insertDataExpandable + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                            //System.out.println(insertData);
                         //   WriteFile(insertData,MainActivity.this);
                        }
                    }
                    if(label.equals("Spc"))
                    {
                        inputString= inputString+" ";
                        if(inputString.isEmpty())
                        {
                            et.setText(redSpannable);
                        }
                        else
                        et.setText(inputString);
                        et.append(redSpannable);
                        keystroke ="Spc";
                        StopKeyTime=Calendar.getInstance().getTimeInMillis();
                        insertkeyDataExpandable = insertkeyDataExpandable+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                        //System.out.println(insertkeyData);
                       // WriteFile1(insertkeyData,MainActivity.this);
                        if(textdisplay.getText().toString().equals(inputString))
                        {
                            btnnext.setEnabled(true);
                            alertDialog(" Click NEXT for the next sentence. ","Instruction");
                            endTime=Calendar.getInstance().getTimeInMillis();
                            insertDataExpandable = insertDataExpandable + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                            //System.out.println(insertData);
                         //   WriteFile(insertData,MainActivity.this);
                        }

                    }
                    if(label.equals("\u232b"))
                    {
                        String str;
                        if(et.getText().equals(""))
                        {
                            str=redSpannable.toString();
                        }
                        else
                        str = et.getText().toString();
                        System.out.println("String for backspace:"+str);
                        text = backspace(str);
                        inputString=text;
                        if(inputString.isEmpty())
                        {
                            et.setText("");
                        }
                        else
                        et.setText(inputString);
                        et.append(redSpannable);
                        keystroke ="Bsp";
                        StopKeyTime=Calendar.getInstance().getTimeInMillis();
                        insertkeyDataExpandable = insertkeyDataExpandable+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                        //System.out.println(insertkeyData);
                        //WriteFile1(insertkeyData,MainActivity.this);
                        if(textdisplay.getText().toString().equals(inputString))
                        {
                            btnnext.setEnabled(true);
                            alertDialog(" Click NEXT for the next sentence. ","Instruction");
                            endTime=Calendar.getInstance().getTimeInMillis();
                            insertDataExpandable = insertDataExpandable + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                            //System.out.println(insertData);
                          //  WriteFile(insertData,MainActivity.this);
                        }
                    }
                    if(label.equals("Ent"))
                    {
                        inputString= inputString+"\n";
                        if(inputString.isEmpty())
                        {
                            et.setText(redSpannable);
                        }
                        else
                        et.setText(inputString);
                        et.append(redSpannable);
                        keystroke ="Ent";
                        StopKeyTime=Calendar.getInstance().getTimeInMillis();
                        insertkeyDataExpandable = insertkeyDataExpandable+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                        //System.out.println(insertkeyData);
                       // WriteFile1(insertkeyData,MainActivity.this);
                        if(textdisplay.getText().toString().equals(inputString))
                        {
                            btnnext.setEnabled(true);
                            alertDialog(" Click NEXT for the next sentence. ","Instruction");
                            endTime=Calendar.getInstance().getTimeInMillis();
                            insertDataExpandable = insertDataExpandable + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                            //System.out.println(insertData);
                         //   WriteFile(insertData,MainActivity.this);
                        }
                    }

                }
            });

        }
        return label;
    }
    private void ExpandableKeyboard()
    {
        float fingerX = EndX;
        float fingerY = EndY;

        Button btn = new Button(getApplicationContext());
        RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(150, 100);
        System.out.println("FingerX: "+fingerX);
        System.out.println("FingerY: "+fingerY);
        if(fingerY>1020)
        {
            bp.leftMargin =(int) 1196-150;
            bp.topMargin = (int) 1020+100;
        }
        else
        {
            bp.leftMargin =(int) fingerX-150;
            bp.topMargin = (int) fingerY+100;
        }

        btn.setLayoutParams(bp);
        text = expandKey.get(0);
        btn.setTextSize(20);
        btn.setText(text.toLowerCase());
        btn.setAllCaps(false);
        rl.addView(btn);

        Button btn1 = new Button(getApplicationContext());
        RelativeLayout.LayoutParams bp1 = new RelativeLayout.LayoutParams(150, 100);
        if(fingerY>1020)
        {
            bp1.leftMargin =(int) 1196-150;
            bp1.topMargin = (int) 1020+210;
        }
        else
        {
            bp1.leftMargin =(int) fingerX-150;
            bp1.topMargin = (int) fingerY+210;
        }

        btn1.setLayoutParams(bp1);
        text = expandKey.get(1);
        btn1.setTextSize(20);
        btn1.setText(text.toLowerCase());
        btn1.setAllCaps(false);
        rl.addView(btn1);

        Button btn2 = new Button(getApplicationContext());
        RelativeLayout.LayoutParams bp2 = new RelativeLayout.LayoutParams(150, 100);
        if(fingerY>1020)
        {
            bp2.leftMargin  =(int) 1196-150;
            bp2.topMargin = (int) 1020+320;
        }
        else{
            bp2.leftMargin =(int) fingerX-150;
            bp2.topMargin = (int) fingerY+320;
        }

        btn2.setLayoutParams(bp2);
        text = expandKey.get(2);
        btn2.setText(text.toLowerCase());
        btn2.setTextSize(20);
        btn2.setAllCaps(false);
        rl.addView(btn2);

        Button btn3 = new Button(getApplicationContext());
        RelativeLayout.LayoutParams bp3 = new RelativeLayout.LayoutParams(150, 100);
        if(fingerY>1020)
        {
            bp3.leftMargin  =(int) 1196-150;
            bp3.topMargin = (int) 1020+430;
        }
        else
        {
            bp3.leftMargin =(int) fingerX-150;
            bp3.topMargin = (int) fingerY+430;
        }


        btn3.setLayoutParams(bp3);
        text = expandKey.get(3);
        btn3.setText(text.toLowerCase());
        btn3.setTextSize(20);
        btn3.setAllCaps(false);
        rl.addView(btn3);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    repeatKey();
                    ExpandableKeyboard();
                    if(btn.getText().equals("q-p"))
                    {
                        firstRow();
                      }
                }
            });
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    repeatKey();
                    ExpandableKeyboard();
                    if(btn1.getText().equals("a-l"))
                    {
                        secondRow();
                    }
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    repeatKey();
                    ExpandableKeyboard();
                    if(btn2.getText().equals("z-m"))
                    {
                        thirdRow();
                    }
                }
            });

            btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repeatKey();

                if(btn3.getText().equals("CAP"))
                {
                    CapExpandableKeyboard();
                    fourthRow();
                }
                if(btn3.getText().equals("#?2"))
                {
                    SymBolExpandableKeyboard();
                    fourthRow();
                    btn3.setText("abc");
                }
                else
                {
                    ExpandableKeyboard();
                    btn3.setText("ctrl");
                    fourthRow();
                }
            }
            });
    }
//=====================================================================================================================
    private void repeatKey()
    {
        for(i=0;i<10;i++)
        {
            ClearRadius();
        }
    }
//==================================================================================================================
    private void LinearKeyboard()
    {
        int intTotalSize=1200;
        int buttonwidth1 =intTotalSize/intTotalButtonOnFirstRow;
        int buttonwidth2 =intTotalSize/intTotalButtonSecondRow;
        int buttonwidth3 =intTotalSize/intTotalButtonThirdRow;

        for(i=0;i<intTotalButtonOnFirstRow;i++)
        {
            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(buttonwidth1, 100);
            bp.leftMargin =(int) i*buttonwidth1+5;
            bp.topMargin = (int) 1220;
            btn.setLayoutParams(bp);

            text = childlistFirstRow.get(i);
            btn.setTextSize(20);
            btn.setText(text.toLowerCase());
            btn.setAllCaps(false);
            rl.addView(btn);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataLinear = insertkeyDataLinear+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                   // WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataLinear = insertDataLinear + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                     //   WriteFile(insertData,MainActivity.this);
                    }
                }
            });
        }
        for(i=0;i<intTotalButtonSecondRow;i++)
        {
            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(buttonwidth2, 100);
            bp.leftMargin =(int) i*buttonwidth2+5;
            bp.topMargin = (int) 1620-300;
            btn.setLayoutParams(bp);

            text = childlistSecondRow.get(i);
            btn.setTextSize(20);
            btn.setText(text.toLowerCase());
            btn.setAllCaps(false);
            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println("Startime:"+startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }
                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataLinear = insertkeyDataLinear+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                   // WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataLinear = insertDataLinear + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                     //   WriteFile(insertData,MainActivity.this);
                    }
                }
            });
        }
        for(i=0;i<intTotalButtonThirdRow;i++)
        {
            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(buttonwidth3, 100);
            bp.leftMargin =(int) i*buttonwidth3+5;
            bp.topMargin = (int) 1620-200;
            btn.setLayoutParams(bp);

            text = childlistThirdRow.get(i);
            btn.setTextSize(20);
            btn.setText(text.toLowerCase());
            btn.setAllCaps(false);
            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }
                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    String sentence = textdisplay.getText().toString();
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataLinear = insertkeyDataLinear+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                  //  WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataLinear = insertDataLinear + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                    //    WriteFile(insertData,MainActivity.this);
                    }
                }
            });
        }
        for(i=0;i<intTotalButtonFourRow;i++)
        {
            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(buttonwidth3, 100);
            bp.leftMargin =(int) i*buttonwidth3+5;
            bp.topMargin = (int) 1620-100;
            btn.setLayoutParams(bp);

            text = childlistFourdRow.get(i);
            btn.setTextSize(20);
            btn.setText(text);
           // btn.setAllCaps(false);
            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(btn.getText().equals("CAP"))
                    {
                            LinearCapKeyboard();
                    }
                    if(btn.getText().equals("#?2") || btn.getText().equals("abc"))
                    {
                        if(btn.getText().equals("abc"))
                        {
                            LinearKeyboard();
                            btn.setText("#?2");
                        }
                        else
                        {
                            btn.setText("abc");
                            btn.setAllCaps(false);
                            LineraSymbolkey();
                        }

                    }
                    if(btn.getText().equals("."))
                    {
                        inputString= inputString+btn.getText().toString();
                        if(inputString.isEmpty())
                        {
                            et.setText(redSpannable);
                        }
                        else
                        et.setText(inputString);
                        et.append(redSpannable);
                        keystroke =btn.getText().toString();
                        StopKeyTime=Calendar.getInstance().getTimeInMillis();
                        insertkeyDataLinear = insertkeyDataLinear+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                        //System.out.println(insertkeyData);
                       // WriteFile1(insertkeyData,MainActivity.this);
                        if(textdisplay.getText().toString().equals(inputString))
                        {
                            btnnext.setEnabled(true);
                            alertDialog(" Click NEXT for the next sentence. ","Instruction");
                            endTime=Calendar.getInstance().getTimeInMillis();
                            insertDataLinear = insertDataLinear + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                           // System.out.println(insertData);
                         //   WriteFile(insertData,MainActivity.this);
                        }
                    }
                    if(btn.getText().equals(","))
                    {
                        inputString= inputString+btn.getText().toString();
                        if(inputString.isEmpty())
                        {
                            et.setText(redSpannable);
                        }
                        else
                        et.setText(inputString);
                        et.append(redSpannable);
                        keystroke =btn.getText().toString();
                        StopKeyTime=Calendar.getInstance().getTimeInMillis();
                        insertkeyDataLinear = insertkeyDataLinear+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                        //System.out.println(insertkeyData);
                      //  WriteFile1(insertkeyData,MainActivity.this);
                        if(textdisplay.getText().toString().equals(inputString))
                        {
                            btnnext.setEnabled(true);
                            alertDialog(" Click NEXT for the next sentence. ","Instruction");
                            endTime=Calendar.getInstance().getTimeInMillis();
                            insertDataLinear = insertDataLinear + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                            System.out.println(insertData);
                        //    WriteFile(insertData,MainActivity.this);
                        }
                    }
                    if(btn.getText().equals("Spc"))
                    {
                        inputString= inputString+" ";
                        if(inputString.isEmpty())
                        {
                            et.setText(redSpannable);
                        }
                        else
                        et.setText(inputString);
                        et.append(redSpannable);
                        keystroke ="Spc";
                        StopKeyTime=Calendar.getInstance().getTimeInMillis();
                        insertkeyDataLinear = insertkeyDataLinear+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                        //System.out.println(insertkeyData);
                       // WriteFile1(insertkeyData,MainActivity.this);
                        if(textdisplay.getText().toString().equals(inputString))
                        {
                            btnnext.setEnabled(true);
                            alertDialog(" Click NEXT for the next sentence. ","Instruction");
                            endTime=Calendar.getInstance().getTimeInMillis();
                        }
                    }
                    else if(btn.getText().equals("\u232b"))
                    {
                        String str;
                        if(et.getText().equals(""))
                        {
                            str=redSpannable.toString();
                        }
                        else
                        str = et.getText().toString();
                        System.out.println("String for backspace:"+str);
                        text = backspace(str);
                        inputString=text;
                        if(inputString.isEmpty())
                        {
                            et.setText("");
                        }
                        else
                        et.setText(inputString);
                        et.append(redSpannable);
                        keystroke ="Bsp";
                        StopKeyTime=Calendar.getInstance().getTimeInMillis();
                        insertkeyDataLinear = insertkeyDataLinear+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                        System.out.println(insertkeyData);
                       // WriteFile1(insertkeyData,MainActivity.this);
                    }
                    else if(btn.getText().equals("Ent"))
                    {
                        inputString= inputString+"\n";
                        if(inputString.isEmpty())
                        {
                            et.setText(redSpannable);
                        }
                        else
                        et.setText(inputString);
                        et.append(redSpannable);
                        keystroke ="Ent";
                        StopKeyTime=Calendar.getInstance().getTimeInMillis();
                        insertkeyDataLinear = insertkeyDataLinear+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                        System.out.println(insertkeyData);
                       // WriteFile1(insertkeyData,MainActivity.this);
                    }
                    else
                        System.out.println("The text :"+et.getText().length());
                }
            });
        }
    }
//=======================================================================================================================
    private void leftFirstRow()
    {

        double dblArcAngle = (90/intTotalButtonOnFirstRowLeft);

        for(int i=0;i<intTotalButtonOnFirstRowLeft;i++)
        {
            double dblButtonAngle = dblArcAngle * i;
            int w = (int)Math.sqrt((2* LeftfloatRadius* LeftfloatRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));

            //get button position X and Y
            int intButtonX = (int) ( LeftfloatRadius-x);
            int intButtonY = intHeight - y;

            //create and place button at X and Y
            int intButtonWidth = intButtonDistanceLeft/intTotalButtonOnFirstRowLeft;
            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intButtonWidth, 100);
            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(90-dblButtonAngle));
            text = LeftchildlistFirstRow.get(i);
            btn.setText(text.toLowerCase());
            btn.setAllCaps(false);
            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataExpandable = insertkeyDataExpandable+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                   // WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataExpandable = insertDataExpandable + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                       // WriteFile(insertData,MainActivity.this);
                    }

                }
            });

        }
    }
    private void leftSecondRow()
    {
        int intSecondRadius = (int)  LeftfloatRadius;
        int intSecondButtonWidth = ((intButtonDistanceLeft-100)/intTotalButtonSecondRowLeft);
        double dblArcAngleSecond = (90/intTotalButtonSecondRowLeft);

        for(int i=0;i<intTotalButtonSecondRowLeft;i++)
        {
            double dblButtonAngle = dblArcAngleSecond * i;
            int w = (int)Math.sqrt((2*intSecondRadius*intSecondRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));

            //get button position X and Y
            int intButtonX = (int) (intSecondRadius-x);
            int intButtonY = intHeight - y;

            //create and place button at X and Y

            Button btn = new Button(getApplicationContext());

            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intSecondButtonWidth, 100);

            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(90-dblButtonAngle));
            text = LeftchildlistSecondRow.get(i);
            btn.setText(text.toLowerCase());
            btn.setAllCaps(false);
            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataExpandable = insertkeyDataExpandable+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                   // WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataExpandable = insertDataExpandable + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                     //   WriteFile(insertData,MainActivity.this);
                    }
                }
            });

        }
    }
    private void leftThirdRow()
    {
        int intThirdRadius = (int)  LeftfloatRadius;
        int intThirdButtonWidth = ((intButtonDistanceLeft-200)/intTotalButtonThirdRowLeft);
        double dblArcAngleThird=(90/intTotalButtonThirdRowLeft);

        for(int i=0;i<intTotalButtonThirdRowLeft;i++)
        {
            double dblButtonAngle = dblArcAngleThird * i;
            int w = (int)Math.sqrt((2*intThirdRadius*intThirdRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));

            //get button position X and Y
            int intButtonX = (int) (intThirdRadius-x);
            int intButtonY = intHeight - y;

            //create and place button at X and Y

            Button btn = new Button(getApplicationContext());
            text = LeftchildlistThirdRow.get(i);

            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intThirdButtonWidth, 100);

            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(90-dblButtonAngle));
            btn.setText(text.toLowerCase());
            btn.setAllCaps(false);

            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataExpandable = insertkeyDataExpandable+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                   // WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataExpandable = insertDataExpandable + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                     //   WriteFile(insertData,MainActivity.this);
                    }
                }
            });

        }

    }
    private void leftFourRow()
    {
        int intThirdRadius = (int)  LeftfloatRadius;
        int intThirdButtonWidth = ((intButtonDistanceLeft-200)/intTotalButtonThirdRowLeft);
        double dblArcAngleThird=(90/intTotalButtonThirdRowLeft);

        for(int i=0;i<intTotalButtonThirdRowLeft;i++)
        {
            double dblButtonAngle = dblArcAngleThird * i;
            int w = (int)Math.sqrt((2*intThirdRadius*intThirdRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));

            //get button position X and Y
            int intButtonX = (int) (intThirdRadius-x);
            int intButtonY = intHeight - y;

            //create and place button at X and Y

            Button btn = new Button(getApplicationContext());
            text = LeftchildlistFourRow.get(i);

            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intThirdButtonWidth, 100);

            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(90-dblButtonAngle));
            btn.setText(text.toLowerCase());
            btn.setAllCaps(false);

            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    label = btn.getText().toString();
                    if(label.equals("cap"))
                    {
                        repeatKey();
                        leftCapExpandableKeyboard();

                    }
                    if(label.equals("#?2"))
                    {
                        repeatKey();
                        btn.setText("abc");
                        leftSymBolExpandableKeyboard();

                    }
                    if(label.equals("abc"))
                    {
                        repeatKey();
                        btn.setText("abc");
                        leftExpandableKeyboard();

                    }
                    if(label.equals("."))
                    {
                        if(et.getText().toString().equals("|"))
                        {
                            startTime=Calendar.getInstance().getTimeInMillis();
                           // System.out.println(startTime);
                            startKeyTimes = Calendar.getInstance().getTimeInMillis();
                        }

                        inputString= inputString+btn.getText().toString();
                        if(inputString.isEmpty())
                        {
                            et.setText(redSpannable);
                        }
                        else
                            et.setText(inputString);
                        et.append(redSpannable);
                        keystroke =btn.getText().toString();
                        StopKeyTime=Calendar.getInstance().getTimeInMillis();
                        insertkeyDataExpandable = insertkeyDataExpandable+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                        //System.out.println(insertkeyData);
                        // WriteFile1(insertkeyData,MainActivity.this);
                        if(textdisplay.getText().toString().equals(inputString))
                        {
                            btnnext.setEnabled(true);
                            alertDialog(" Click NEXT for the next sentence. ","Instruction");
                            endTime=Calendar.getInstance().getTimeInMillis();
                            insertDataExpandable = insertDataExpandable + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                            //System.out.println(insertData);
                            //   WriteFile(insertData,MainActivity.this);
                        }
                    }
                    if(label.equals(","))
                    {
                        if(et.getText().toString().equals("|"))
                        {
                            startTime=Calendar.getInstance().getTimeInMillis();
                            //System.out.println(startTime);
                            startKeyTimes = Calendar.getInstance().getTimeInMillis();
                        }

                        inputString= inputString+btn.getText().toString();
                        if(inputString.isEmpty())
                        {
                            et.setText(redSpannable);
                        }
                        else
                            et.setText(inputString);
                        et.append(redSpannable);
                        keystroke =btn.getText().toString();
                        StopKeyTime=Calendar.getInstance().getTimeInMillis();
                        insertkeyDataExpandable = insertkeyDataExpandable+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                        //System.out.println(insertkeyData);
                        // WriteFile1(insertkeyData,MainActivity.this);
                        if(textdisplay.getText().toString().equals(inputString))
                        {
                            btnnext.setEnabled(true);
                            alertDialog(" Click NEXT for the next sentence. ","Instruction");
                            endTime=Calendar.getInstance().getTimeInMillis();
                            insertDataExpandable = insertDataExpandable + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                            //System.out.println(insertData);
                            //   WriteFile(insertData,MainActivity.this);
                        }
                    }
                    if(label.equals("Spc"))
                    {
                        inputString= inputString+" ";
                        if(inputString.isEmpty())
                        {
                            et.setText(redSpannable);
                        }
                        else
                            et.setText(inputString);
                        et.append(redSpannable);
                        keystroke ="Spc";
                        StopKeyTime=Calendar.getInstance().getTimeInMillis();
                        insertkeyDataExpandable = insertkeyDataExpandable+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                        //System.out.println(insertkeyData);
                        // WriteFile1(insertkeyData,MainActivity.this);
                        if(textdisplay.getText().toString().equals(inputString))
                        {
                            btnnext.setEnabled(true);
                            alertDialog(" Click NEXT for the next sentence. ","Instruction");
                            endTime=Calendar.getInstance().getTimeInMillis();
                            insertDataExpandable = insertDataExpandable + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                            //System.out.println(insertData);
                            //   WriteFile(insertData,MainActivity.this);
                        }

                    }
                    if(label.equals("\u232b"))
                    {
                        String str;
                        if(et.getText().equals(""))
                        {
                            str=redSpannable.toString();
                        }
                        else
                            str = et.getText().toString();
                        System.out.println("String for backspace:"+str);
                        text = backspace(str);
                        inputString=text;
                        if(inputString.isEmpty())
                        {
                            et.setText("");
                        }
                        else
                            et.setText(inputString);
                        et.append(redSpannable);
                        keystroke ="Bsp";
                        StopKeyTime=Calendar.getInstance().getTimeInMillis();
                        insertkeyDataExpandable = insertkeyDataExpandable+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                        //System.out.println(insertkeyData);
                        //WriteFile1(insertkeyData,MainActivity.this);
                        if(textdisplay.getText().toString().equals(inputString))
                        {
                            btnnext.setEnabled(true);
                            alertDialog(" Click NEXT for the next sentence. ","Instruction");
                            endTime=Calendar.getInstance().getTimeInMillis();
                            insertDataExpandable = insertDataExpandable + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                            //System.out.println(insertData);
                            //  WriteFile(insertData,MainActivity.this);
                        }

                    }
                    if(label.equals("Ent"))
                    {

                        inputString= inputString+"\n";
                        if(inputString.isEmpty())
                        {
                            et.setText(redSpannable);
                        }
                        else
                            et.setText(inputString);
                        et.append(redSpannable);
                        keystroke ="Ent";
                        StopKeyTime=Calendar.getInstance().getTimeInMillis();
                        insertkeyDataExpandable = insertkeyDataExpandable+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                        //System.out.println(insertkeyData);
                        // WriteFile1(insertkeyData,MainActivity.this);
                        if(textdisplay.getText().toString().equals(inputString))
                        {
                            btnnext.setEnabled(true);
                            alertDialog(" Click NEXT for the next sentence. ","Instruction");
                            endTime=Calendar.getInstance().getTimeInMillis();
                            insertDataExpandable = insertDataExpandable + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                            //System.out.println(insertData);
                            //   WriteFile(insertData,MainActivity.this);
                        }
                    }

                }
            });

        }

    }
    private void leftExpandableKeyboard() {
        float fingerX = EndX;
        float fingerY = EndY;

        Button btn = new Button(getApplicationContext());
        RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(150, 100);
        if(fingerY>1020)
        {
            bp.leftMargin = 0;
            bp.topMargin = (int) 1020 + 100;
        }
        else
        {
            bp.leftMargin = 0;
            bp.topMargin = (int) fingerY + 100;
        }

        btn.setLayoutParams(bp);
        text = expandKey.get(0);
        btn.setText(text.toLowerCase());
        btn.setAllCaps(false);
        rl.addView(btn);

        Button btn1 = new Button(getApplicationContext());
        RelativeLayout.LayoutParams bp1 = new RelativeLayout.LayoutParams(150, 100);
        if(fingerY>1020)
        {
            bp1.leftMargin = 0;
            bp1.topMargin = (int) 1020 + 210;
        }
        else
        {
            bp1.leftMargin = 0;
            bp1.topMargin = (int) fingerY + 210;
        }


        btn1.setLayoutParams(bp1);

        text = expandKey.get(1);
        btn1.setText(text.toLowerCase());
        btn1.setAllCaps(false);
        rl.addView(btn1);

        Button btn2 = new Button(getApplicationContext());
        RelativeLayout.LayoutParams bp2 = new RelativeLayout.LayoutParams(150, 100);
        if(fingerY>1020)
        {
            bp2.leftMargin = 0;
            bp2.topMargin = (int) 1020 + 320;
        }
        else
        {
            bp2.leftMargin = 0;
            bp2.topMargin = (int) fingerY + 320;
        }

        btn2.setLayoutParams(bp2);
        text = expandKey.get(2);
        btn2.setText(text.toLowerCase());
        btn2.setAllCaps(false);
        rl.addView(btn2);

        Button btn3 = new Button(getApplicationContext());
        RelativeLayout.LayoutParams bp3 = new RelativeLayout.LayoutParams(150, 100);
        if(fingerY>1020)
        {
            bp3.leftMargin = 0;
            bp3.topMargin = (int) 1020+ 430;
        }
        else
        {
            bp3.leftMargin = 0;
            bp3.topMargin = (int) fingerY + 430;
        }

        btn3.setLayoutParams(bp3);
        text = expandKey.get(3);
        btn3.setText(text.toLowerCase());
        btn3.setAllCaps(false);
        rl.addView(btn3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftrepeatkey();
                leftExpandableKeyboard();
                leftFirstRow();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftrepeatkey();
                leftExpandableKeyboard();
                    leftSecondRow();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftrepeatkey();
                leftExpandableKeyboard();
                leftThirdRow();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftrepeatkey();
                leftFourRow();
            }
        });
    }
//===================================================================================================
    private void leftCapFirstRow()
    {

    double dblArcAngle = (90/intTotalButtonOnFirstRowLeft);

    for(int i=0;i<intTotalButtonOnFirstRowLeft;i++)
    {
        double dblButtonAngle = dblArcAngle * i;
        int w = (int)Math.sqrt((2* LeftfloatRadius* LeftfloatRadius)*(1-getThetaInRadian(dblButtonAngle)));
        double t1 = 90-(dblButtonAngle/2);
        int x = (int)( w*getThetaInRadian(t1));
        int y = (int)Math.sqrt((w*w)-(x*x));

        //get button position X and Y
        int intButtonX = (int) ( LeftfloatRadius-x);
        int intButtonY = intHeight - y;

        //create and place button at X and Y
        int intButtonWidth = intButtonDistanceLeft/intTotalButtonOnFirstRowLeft;
        Button btn = new Button(getApplicationContext());
        RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intButtonWidth, 100);
        bp.leftMargin =(int) intButtonX;
        bp.topMargin = (int) intButtonY;
        btn.setLayoutParams(bp);
        btn.setRotation((float)(90-dblButtonAngle));
        text = LeftchildlistFirstRow.get(i);
        btn.setText(text.toUpperCase());

        rl.addView(btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et.getText().toString().equals("|"))
                {
                    startTime=Calendar.getInstance().getTimeInMillis();
                    //System.out.println(startTime);
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                }

                inputString= inputString+btn.getText().toString();
                if(inputString.isEmpty())
                {
                    et.setText(redSpannable);
                }
                else
                    et.setText(inputString);
                et.append(redSpannable);
                keystroke =btn.getText().toString();
                StopKeyTime=Calendar.getInstance().getTimeInMillis();
                insertkeyDataExpandable = insertkeyDataExpandable+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                startKeyTimes = Calendar.getInstance().getTimeInMillis();
                //System.out.println(insertkeyData);
                // WriteFile1(insertkeyData,MainActivity.this);
                if(textdisplay.getText().toString().equals(inputString))
                {
                    btnnext.setEnabled(true);
                    alertDialog(" Click NEXT for the next sentence. ","Instruction");
                    endTime=Calendar.getInstance().getTimeInMillis();
                    insertDataExpandable = insertDataExpandable + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                    //System.out.println(insertData);
                    // WriteFile(insertData,MainActivity.this);
                }
                leftExpandableKeyboard();
            }
        });
    }
}
    private void leftCapSecondRow()
    {
        int intSecondRadius = (int)  LeftfloatRadius;
        int intSecondButtonWidth = ((intButtonDistanceLeft-100)/intTotalButtonSecondRowLeft);
        double dblArcAngleSecond = (90/intTotalButtonSecondRowLeft);

        for(int i=0;i<intTotalButtonSecondRowLeft;i++)
        {
            double dblButtonAngle = dblArcAngleSecond * i;
            int w = (int)Math.sqrt((2*intSecondRadius*intSecondRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));

            //get button position X and Y
            int intButtonX = (int) (intSecondRadius-x);
            int intButtonY = intHeight - y;

            //create and place button at X and Y
            // int intButtonWidth = intButtonDistance/inTotalButtonOnRow;
            Button btn = new Button(getApplicationContext());

            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intSecondButtonWidth, 100);

            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(90-dblButtonAngle));
            text = LeftchildlistSecondRow.get(i);
            btn.setText(text.toUpperCase());
            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                        et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataExpandable = insertkeyDataExpandable+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                    // WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataExpandable = insertDataExpandable + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                        //   WriteFile(insertData,MainActivity.this);
                    }
                    leftExpandableKeyboard();
                }
            });
        }
    }
    private void leftCapThirdRow()
    {
        int intThirdRadius = (int)  LeftfloatRadius;
        int intThirdButtonWidth = ((intButtonDistanceLeft-200)/intTotalButtonThirdRowLeft);
        double dblArcAngleThird=(90/intTotalButtonThirdRowLeft);

        for(int i=0;i<intTotalButtonThirdRowLeft;i++)
        {
            double dblButtonAngle = dblArcAngleThird * i;
            int w = (int)Math.sqrt((2*intThirdRadius*intThirdRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));

            //get button position X and Y
            int intButtonX = (int) (intThirdRadius-x);
            int intButtonY = intHeight - y;

            //create and place button at X and Y
            // int intButtonWidth = intButtonDistance/inTotalButtonOnRow;
            Button btn = new Button(getApplicationContext());
            text = LeftchildlistThirdRow.get(i);

            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intThirdButtonWidth, 100);

            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(90-dblButtonAngle));
            btn.setText(text.toUpperCase());

            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                       // System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                        et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataExpandable = insertkeyDataExpandable+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                    // WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataExpandable = insertDataExpandable + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                        //   WriteFile(insertData,MainActivity.this);
                    }
                    leftExpandableKeyboard();
                }
            });
        }
    }

    private void leftCapExpandableKeyboard() {
        float fingerX = EndX;
        float fingerY = EndY;

        Button btn = new Button(getApplicationContext());
        RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(150, 100);
        if(fingerY>1020)
        {
            bp.leftMargin = 0;
            bp.topMargin = (int) 1020 + 100;
        }
        else
        {
            bp.leftMargin = 0;
            bp.topMargin = (int) fingerY + 100;
        }

        btn.setLayoutParams(bp);
        text = expandKey.get(0);
        btn.setText(text.toUpperCase());
        rl.addView(btn);

        Button btn1 = new Button(getApplicationContext());
        RelativeLayout.LayoutParams bp1 = new RelativeLayout.LayoutParams(150, 100);
        if(fingerY>1020)
        {
            bp1.leftMargin = 0;
            bp1.topMargin = (int) 1020 + 210;
        }
        else{
            bp1.leftMargin = 0;
            bp1.topMargin = (int) fingerY + 210;
        }

        btn1.setLayoutParams(bp1);

        text = expandKey.get(1);
        btn1.setText(text.toUpperCase());
        btn1.setAllCaps(false);
        rl.addView(btn1);

        Button btn2 = new Button(getApplicationContext());
        RelativeLayout.LayoutParams bp2 = new RelativeLayout.LayoutParams(150, 100);
        if(fingerY>1020)
        {
            bp2.leftMargin = 0;
            bp2.topMargin = (int) 1020 + 320;
        }
        else
        {
            bp2.leftMargin = 0;
            bp2.topMargin = (int) fingerY + 320;
        }

        btn2.setLayoutParams(bp2);
        text = expandKey.get(2);
        btn2.setText(text.toUpperCase());
        rl.addView(btn2);

        Button btn3 = new Button(getApplicationContext());
        RelativeLayout.LayoutParams bp3 = new RelativeLayout.LayoutParams(150, 100);
        if(fingerY>1020)
        {
            bp3.leftMargin = 0;
            bp3.topMargin = (int) 1020 + 430;
        }
        else
        {
            bp3.leftMargin = 0;
            bp3.topMargin = (int) fingerY + 430;
        }

        btn3.setLayoutParams(bp3);
        text = expandKey.get(3);
        btn3.setText(text.toUpperCase());
        rl.addView(btn3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftrepeatkey();
                leftCapExpandableKeyboard();
                leftCapFirstRow();

            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftrepeatkey();
                leftCapExpandableKeyboard();
                leftCapSecondRow();

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftrepeatkey();
                leftCapExpandableKeyboard();
                leftCapThirdRow();

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftrepeatkey();
                fourthRow();
            }
        });
    }
//=================================================================================================================
    private void leftSymbolFirstRow()
    {
        double dblArcAngle = (90/intTotalButtonOnFirstRowLeft);

        for(int i=0;i<intTotalButtonOnFirstRowLeft;i++)
        {
            double dblButtonAngle = dblArcAngle * i;
            int w = (int)Math.sqrt((2* LeftfloatRadius* LeftfloatRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));

            //get button position X and Y
            int intButtonX = (int) ( LeftfloatRadius-x);
            int intButtonY = intHeight - y;
            System.out.println("ButtonX: "+intButtonX+" ButtonY: "+intButtonY);
            //create and place button at X and Y
            int intButtonWidth = intButtonDistanceLeft/intTotalButtonOnFirstRowLeft;
            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intButtonWidth, 100);
            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(90-dblButtonAngle));
            text = LeftchildlistNumber.get(i);
            btn.setText(text.toUpperCase());

            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                        et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataExpandable = insertkeyDataExpandable+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                    // WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataExpandable = insertDataExpandable + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                        // WriteFile(insertData,MainActivity.this);
                    }
                }
            });
        }
    }
    private void leftSymbolSecondRow()
    {
        int intSecondRadius = (int)  LeftfloatRadius;
        int intSecondButtonWidth = ((intButtonDistanceLeft-100)/intTotalButtonSecondRowLeft);
        double dblArcAngleSecond = (90/intTotalButtonSecondRowLeft);

        for(int i=0;i<intTotalButtonSecondRowLeft;i++)
        {
            double dblButtonAngle = dblArcAngleSecond * i;
            int w = (int)Math.sqrt((2*intSecondRadius*intSecondRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));

            //get button position X and Y
            int intButtonX = (int) (intSecondRadius-x);
            int intButtonY = intHeight - y;
            System.out.println("ButtonX: "+intButtonX+" ButtonY: "+intButtonY);
            //create and place button at X and Y
            // int intButtonWidth = intButtonDistance/inTotalButtonOnRow;
            Button btn = new Button(getApplicationContext());

            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intSecondButtonWidth, 100);

            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(90-dblButtonAngle));
            text = LeftchildlistSymbol.get(i);
            btn.setText(text.toUpperCase());
            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                        et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataExpandable = insertkeyDataExpandable+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                    // WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataExpandable = insertDataExpandable + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                        //   WriteFile(insertData,MainActivity.this);
                    }
                }
            });
        }
    }
    private void leftSymbolThirdRow()
    {
        int intThirdRadius = (int)  LeftfloatRadius;
        int intThirdButtonWidth = ((intButtonDistanceLeft-200)/intTotalButtonThirdRowLeft);
        double dblArcAngleThird=(90/intTotalButtonThirdRowLeft);

        for(int i=0;i<intTotalButtonThirdRowLeft;i++)
        {
            double dblButtonAngle = dblArcAngleThird * i;
            int w = (int)Math.sqrt((2*intThirdRadius*intThirdRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));

            //get button position X and Y
            int intButtonX = (int) (intThirdRadius-x);
            int intButtonY = intHeight - y;
            //System.out.println("ButtonX: "+intButtonX+" ButtonY: "+intButtonY);
            //create and place button at X and Y
            // int intButtonWidth = intButtonDistance/inTotalButtonOnRow;
            Button btn = new Button(getApplicationContext());
            text = LeftchildlistSymbolSecond.get(i);

            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intThirdButtonWidth, 100);

            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(90-dblButtonAngle));
            btn.setText(text.toUpperCase());

            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                        et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataExpandable = insertkeyDataExpandable+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                    // WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataExpandable = insertDataExpandable + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        System.out.println(insertData);
                        //   WriteFile(insertData,MainActivity.this);
                    }
                }
            });
        }
    }

    private void leftSymBolExpandableKeyboard() {
        float fingerX = EndX;
        float fingerY = EndY;

        Button btn = new Button(getApplicationContext());
        RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(150, 100);
        if(fingerY>1020)
        {
            bp.leftMargin = 0;
            bp.topMargin = (int) 1020 + 100;
        }
        else
        {
            bp.leftMargin = 0;
            bp.topMargin = (int) fingerY + 100;
        }

        btn.setLayoutParams(bp);
        text = "0-9";
        btn.setText(text.toLowerCase());
        btn.setAllCaps(false);
        rl.addView(btn);

        Button btn1 = new Button(getApplicationContext());
        RelativeLayout.LayoutParams bp1 = new RelativeLayout.LayoutParams(150, 100);
        if(fingerY>1020)
        {
            bp1.leftMargin = 0;
            bp1.topMargin = (int) 1020 + 210;
        }
        else
        {
            bp1.leftMargin = 0;
            bp1.topMargin = (int) fingerY + 210;
        }

        btn1.setLayoutParams(bp1);

        text = "!-*";
        btn1.setText(text.toLowerCase());
        btn1.setAllCaps(false);
        rl.addView(btn1);

        Button btn2 = new Button(getApplicationContext());
        RelativeLayout.LayoutParams bp2 = new RelativeLayout.LayoutParams(150, 100);
        if(fingerY>1020)
        {
            bp2.leftMargin = 0;
            bp2.topMargin = (int) 1020 + 320;
        }
        else
        {
            bp2.leftMargin = 0;
            bp2.topMargin = (int) fingerY + 320;
        }

        btn2.setLayoutParams(bp2);
        text = "{-?";
        btn2.setText(text.toUpperCase());
        rl.addView(btn2);

        Button btn3 = new Button(getApplicationContext());
        RelativeLayout.LayoutParams bp3 = new RelativeLayout.LayoutParams(150, 100);
        if(fingerY>1020)
        {
            bp3.leftMargin = 0;
            bp3.topMargin = (int) 1020+ 430;
        }
        else
        {
            bp3.leftMargin = 0;
            bp3.topMargin = (int) fingerY + 430;
        }

        btn3.setLayoutParams(bp3);
        text = expandKey.get(3);
        btn3.setText(text.toLowerCase());
        btn3.setAllCaps(false);
        rl.addView(btn3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftrepeatkey();
                leftSymBolExpandableKeyboard();
                leftSymbolFirstRow();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftrepeatkey();
                leftSymBolExpandableKeyboard();
                leftSymbolSecondRow();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftrepeatkey();
                leftSymBolExpandableKeyboard();
                leftSymbolThirdRow();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftrepeatkey();
                btn3.setText(label);
                if (btn3.getText().equals("CAP")) {
                    leftCapExpandableKeyboard();
                    fourthRow();
                }
                if (btn3.getText().equals("#?2")) {
                    leftSymBolExpandableKeyboard();
                    fourthRow();
                } else {
                    ExpandableKeyboard();
                    fourthRow();
                }
            }
        });
    }
    //=============================================================================================================
    private void leftrepeatkey()
    {
        for(i=0;i<10;i++)
        {
            ClearRadius();
        }
        leftExpandableKeyboard();
    }
//============================================================================================================
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(parent.getItemAtPosition(position).toString().equals("Set_Handedness"))
        {
            for(i=0;i<50;i++)
            {
                ClearRadius();
            }
            alertDialog("Please select the Hand side(Right/Left)\n For eg: Right hand person would select handside as Right and vice versa","HCIProject");
            btnradius.setEnabled(false);
            keySpinner.setEnabled(false);
            btnnext.setEnabled(false);
            et.setEnabled(false);
            textdisplay.setEnabled(false);
        }
        else if(parent.getItemAtPosition(position).toString().equals("Left") )
        {
            Handside =parent.getItemAtPosition(position).toString();
            HandSide = parent.getItemAtPosition(position).toString();
            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(30, 30);
            for(int i=0;i<50;i++)
             {
                ClearRadius();
             }
            bp.leftMargin = 0;
            bp.topMargin = 1620;
            btn.setLayoutParams(bp);
            rl.addView(btn);
            alertDialog("Click Get Radius To measure the radius of the accessible area of Thumb ","HCIProject");
            Modeleft = true;
            Moderight =false;
            btnradius.setEnabled(true);
        }
        else if(parent.getItemAtPosition(position).toString().equals("Right") )
        {
            Handside =parent.getItemAtPosition(position).toString();
            HandSide = parent.getItemAtPosition(position).toString();
            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(30, 30);
            for(int i=0;i<50;i++)
            {
                ClearRadius();
            }
            bp.leftMargin = 1175;
            bp.topMargin = 1620;
            btn.setLayoutParams(bp);
            rl.addView(btn);
            Moderight=true;
            Modeleft=false;
            btnradius.setEnabled(true);
            alertDialog("Click Get Radius To measure the radius of the accessible area of Thumb ","HCIProject");
        }
        else if(parent.getItemAtPosition(position).toString().equals("Linear Keyboard"))
        {
            KeyboardTpe = parent.getItemAtPosition(position).toString();
            for(i=0;i<50;i++)
            {
                ClearRadius();
            }
            LinearKeyboard();
            String red = "|";
            SpannableString redSpannable= new SpannableString(red);
            redSpannable.setSpan(new ForegroundColorSpan(Color.RED), 0, red.length(), 0);
            et.setText(redSpannable);
            inputString="";
        }
        else if(parent.getItemAtPosition(position).toString().equals("Custom KeyBoard"))
        {
            KeyboardTpe = parent.getItemAtPosition(position).toString();
            for(i=0;i<50;i++)
            {
                ClearRadius();
            }
            if(Handside.equals("Left"))
            {
                LeftDrawKeyboard();
                String red = "|";
                SpannableString redSpannable= new SpannableString(red);
                redSpannable.setSpan(new ForegroundColorSpan(Color.RED), 0, red.length(), 0);
                et.setText(redSpannable);
                inputString="";
            }
            else
            {
                DrawKeyboard();
                String red = "|";
                SpannableString redSpannable= new SpannableString(red);
                redSpannable.setSpan(new ForegroundColorSpan(Color.RED), 0, red.length(), 0);
                et.setText(redSpannable);
                inputString="";
            }

        }
        else if(parent.getItemAtPosition(position).toString().equals("Expandable"))
        {
            KeyboardTpe = parent.getItemAtPosition(position).toString();
            for(i=0;i<50;i++)
            {
                ClearRadius();
            }
            if(Handside.equals("Left"))
            {
                leftExpandableKeyboard();
                String red = "|";
                SpannableString redSpannable= new SpannableString(red);
                redSpannable.setSpan(new ForegroundColorSpan(Color.RED), 0, red.length(), 0);
                et.setText(redSpannable);
                inputString="";
            }
            else
            {
                ExpandableKeyboard();
                String red = "|";
                SpannableString redSpannable= new SpannableString(red);
                redSpannable.setSpan(new ForegroundColorSpan(Color.RED), 0, red.length(), 0);
                et.setText(redSpannable);
                inputString="";
            }

        }
        else if(parent.getItemAtPosition(position).toString().equals("Select"))
        {
            for(i=0;i<50;i++)
            {
                ClearRadius();
            }
        }
        else
        {
            seqoption=parent.getItemAtPosition(position).toString();
        }
    }
//========================================================================================================================
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
//================================================================================================================
    private void CapKeyboard()
    {

        int intSecondRadius = (int) floatRadius-110;
        int intThirdRadius = (int) floatRadius-220;
        int intSecondButtonWidth = ((intButtonDistance-100)/intTotalButtonSecondRow);
        int intThirdButtonWidth = ((intButtonDistance-200)/intTotalButtonThirdRow);

        double dblArcAngle = (90/intTotalButtonOnFirstRow);
        double dblArcAngleSecond = (90/intTotalButtonSecondRow);
        double dblArcAngleThird=(90/intTotalButtonThirdRow);

        for(int i=0;i<intTotalButtonOnFirstRow;i++)
        {
            double dblButtonAngle = dblArcAngle * i;
            int w = (int)Math.sqrt((2*floatRadius*floatRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));

            //get button position X and Y
            int intButtonX = (int) (intWidth - floatRadius+x);
            int intButtonY = intHeight - y;

            //create and place button at X and Y
            int intButtonWidth = intButtonDistance/intTotalButtonOnFirstRow;
            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intButtonWidth, 100);
            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(dblButtonAngle-90));
            text = childlistFirstRow.get(i);
            btn.setTextSize(20);
            btn.setText(text.toUpperCase());
            btn.setAllCaps(true);

            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataCustom = insertkeyDataCustom+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                   // WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataCustom = insertDataCustom + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                     //   WriteFile(insertData,MainActivity.this);

                    }
                    DrawKeyboard();
                    }
            });
        }
        for(int i=0;i<intTotalButtonSecondRow;i++)
        {
            double dblButtonAngle = dblArcAngleSecond * i;
            int w = (int)Math.sqrt((2*intSecondRadius*intSecondRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));

            //get button position X and Y
            int intButtonX = (int) (intWidth - intSecondRadius+x);
            int intButtonY = intHeight - y;

            //create and place button at X and Y

            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intSecondButtonWidth, 100);
            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(dblButtonAngle-90));
            text = childlistSecondRow.get(i);
            btn.setTextSize(20);
            btn.setText(text.toUpperCase());
            btn.setAllCaps(true);
            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataCustom = insertkeyDataCustom+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                  //  WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataCustom = insertDataCustom + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                    //    WriteFile(insertData,MainActivity.this);

                    }
                    DrawKeyboard();
                }
            });
        }
        for(int i=0;i<intTotalButtonThirdRow;i++)
        {
            double dblButtonAngle = dblArcAngleThird * i;
            int w = (int)Math.sqrt((2*intThirdRadius*intThirdRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));

            //get button position X and Y
            int intButtonX = (int) (intWidth - intThirdRadius+x);
            int intButtonY = intHeight - y;

            //create and place button at X and Y

            Button btn = new Button(getApplicationContext());
            text = childlistThirdRow.get(i);

            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intThirdButtonWidth, 100);

            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(dblButtonAngle-90));
            btn.setTextSize(20);
            btn.setText(text.toUpperCase());
            btn.setAllCaps(true);

            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataCustom = insertkeyDataCustom+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                   // WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataCustom = insertDataCustom + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                       // System.out.println(insertData);
                     //   WriteFile(insertData,MainActivity.this);

                    }
                    DrawKeyboard();
                }
            });
        }
    }
    private void NumKey()
    {

        int intSecondRadius = (int) floatRadius-110;
        int intThirdRadius = (int) floatRadius-220;
        int intSecondButtonWidth = ((intButtonDistance-100)/intTotalButtonSecondRow);
        int intThirdButtonWidth = ((intButtonDistance-200)/intTotalButtonThirdRow);
        double dblArcAngle = (90/intTotalButtonOnFirstRow);
        double dblArcAngleSecond = (90/intTotalButtonSecondRow);
        double dblArcAngleThird=(90/intTotalButtonThirdRow);

        for(int i=0;i<intTotalButtonOnFirstRow;i++)
        {
            double dblButtonAngle = dblArcAngle * i;
            int w = (int)Math.sqrt((2*floatRadius*floatRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));
            //get button position X and Y
            int intButtonX = (int) (intWidth - floatRadius+x);
            int intButtonY = intHeight - y;

            //create and place button at X and Y
            int intButtonWidth = intButtonDistance/intTotalButtonOnFirstRow;
            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intButtonWidth, 100);
            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(dblButtonAngle-90));
            text = childlistNumber.get(i);
            btn.setTextSize(20);
            btn.setText(text.toLowerCase());
            btn.setAllCaps(false);

            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataCustom = insertkeyDataCustom+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                  //  WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataCustom = insertDataCustom + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                    //    WriteFile(insertData,MainActivity.this);
                    }
                }
            });
        }
        for(int i=0;i<intTotalButtonSecondRow;i++)
        {
            double dblButtonAngle = dblArcAngleSecond * i;
            int w = (int)Math.sqrt((2*intSecondRadius*intSecondRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));

            //get button position X and Y
            int intButtonX = (int) (intWidth - intSecondRadius+x);
            int intButtonY = intHeight - y;

            //create and place button at X and Y
            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intSecondButtonWidth, 100);
            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(dblButtonAngle-90));
            text = childlistSymbol.get(i);
            btn.setText(text.toLowerCase());
            btn.setTextSize(20);
            btn.setAllCaps(false);
            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataCustom = insertkeyDataCustom+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                   // WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataCustom = insertDataCustom + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                     //   WriteFile(insertData,MainActivity.this);
                    }
                }
            });
        }
        for(int i=0;i<intTotalButtonThirdRow;i++)
        {
            double dblButtonAngle = dblArcAngleThird * i;
            int w = (int)Math.sqrt((2*intThirdRadius*intThirdRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));
            //get button position X and Y
            int intButtonX = (int) (intWidth - intThirdRadius+x);
            int intButtonY = intHeight - y;

            //create and place button at X and Y
            Button btn = new Button(getApplicationContext());
            text = childlistSymbolSecond.get(i);

            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intThirdButtonWidth, 100);

            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(dblButtonAngle-90));
            btn.setTextSize(20);
            btn.setText(text.toLowerCase());
            btn.setAllCaps(false);
            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataCustom = insertkeyDataCustom+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                   // WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataCustom = insertDataCustom + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                      //  WriteFile(insertData,MainActivity.this);
                    }
                }
            });
        }
    }
//===================================================================================================================
    private void LineraSymbolkey()
    {
        int intTotalSize=1200;
        int buttonwidth1 =intTotalSize/intTotalButtonOnFirstRow;
        int buttonwidth2 =intTotalSize/intTotalButtonSecondRow;
        int buttonwidth3 =intTotalSize/intTotalButtonThirdRow;

        for(i=0;i<intTotalButtonOnFirstRow;i++)
        {
            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(buttonwidth1, 100);
            bp.leftMargin =(int) i*buttonwidth1+5;
            bp.topMargin = (int) 1220;
            btn.setLayoutParams(bp);

            text = childlistNumber.get(i);
            btn.setTextSize(20);
            btn.setText(text.toLowerCase());
            btn.setAllCaps(false);
            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }
                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataLinear = insertkeyDataLinear+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                   // WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataLinear = insertDataLinear + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                      //  WriteFile(insertData,MainActivity.this);
                    }
                }
            });
        }
        for(i=0;i<intTotalButtonSecondRow;i++)
        {
            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(buttonwidth2, 100);
            bp.leftMargin =(int) i*buttonwidth2+5;
            bp.topMargin = (int) 1620-300;
            btn.setLayoutParams(bp);

            text = childlistSymbol.get(i);
            btn.setTextSize(20);
            btn.setText(text.toLowerCase());
            btn.setAllCaps(false);
            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }
                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataLinear = insertkeyDataLinear+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                   // WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataLinear = insertDataLinear + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        System.out.println(insertData);
                       // WriteFile(insertData,MainActivity.this);
                    }
                }
            });
        }
        for(i=0;i<intTotalButtonThirdRow;i++)
        {
            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(buttonwidth3, 100);
            bp.leftMargin =(int) i*buttonwidth3+5;
            bp.topMargin = (int) 1620-200;
            btn.setLayoutParams(bp);

            text = childlistSymbolSecond.get(i);
            btn.setTextSize(20);
            btn.setText(text.toLowerCase());
            btn.setAllCaps(false);
            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }
                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataLinear = insertkeyDataLinear+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                  //  WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataLinear = insertDataLinear + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                      //  WriteFile(insertData,MainActivity.this);
                    }
                }
            });
        }
    }
    private void LinearCapKeyboard()
    {
        int intTotalSize=1200;
        int buttonwidth1 =intTotalSize/intTotalButtonOnFirstRow;
        int buttonwidth2 =intTotalSize/intTotalButtonSecondRow;
        int buttonwidth3 =intTotalSize/intTotalButtonThirdRow;

        for(i=0;i<intTotalButtonOnFirstRow;i++)
        {
            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(buttonwidth1, 100);
            bp.leftMargin =(int) i*buttonwidth1+5;
            bp.topMargin = (int) 1220;
            btn.setLayoutParams(bp);

            text = childlistFirstRow.get(i);
            btn.setTextSize(20);
            btn.setText(text.toUpperCase());
            btn.setAllCaps(true);
            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }
                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataLinear = insertkeyDataLinear+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                 //   WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataLinear = insertDataLinear + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                      //  WriteFile(insertData,MainActivity.this);
                    }
                    LinearKeyboard();
                }
            });
        }
        for(i=0;i<intTotalButtonSecondRow;i++)
        {
            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(buttonwidth2, 100);
            bp.leftMargin =(int) i*buttonwidth2+5;
            bp.topMargin = (int) 1620-300;
            btn.setLayoutParams(bp);

            text = childlistSecondRow.get(i);
            btn.setTextSize(20);
            btn.setText(text.toUpperCase());
            btn.setAllCaps(true);
            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }
                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataLinear = insertkeyDataLinear+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                  //  WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataLinear = insertDataLinear + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                      //  WriteFile(insertData,MainActivity.this);
                    }
                    LinearKeyboard();
                }
            });
        }
        for(i=0;i<intTotalButtonThirdRow;i++)
        {
            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(buttonwidth3, 100);
            bp.leftMargin =(int) i*buttonwidth3+5;
            bp.topMargin = (int) 1620-200;
            btn.setLayoutParams(bp);

            text = childlistThirdRow.get(i);
            btn.setTextSize(20);
            btn.setText(text.toUpperCase());
            btn.setAllCaps(true);
            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }
                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataLinear = insertkeyDataLinear+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                  //  WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataLinear = insertDataLinear + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                       // System.out.println(insertData);
                    //    WriteFile(insertData,MainActivity.this);
                    }
                    LinearKeyboard();
                }
            });
        }

    }
//================================================================================================================
    private void CapExpandableKeyboard()
    {
        float fingerX = EndX;
        float fingerY = EndY;

        Button btn = new Button(getApplicationContext());
        RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(150, 100);
        if(fingerY>1020)
        {
            bp.leftMargin =(int) 1196-150;
            bp.topMargin = (int) 1020+100;
        }
        else
        {
            bp.leftMargin =(int) fingerX-150;
            bp.topMargin = (int) fingerY+100;
        }

        btn.setLayoutParams(bp);
        text = expandKey.get(0);
        btn.setTextSize(20);
        btn.setText(text.toUpperCase());
        rl.addView(btn);

        Button btn1 = new Button(getApplicationContext());
        RelativeLayout.LayoutParams bp1 = new RelativeLayout.LayoutParams(150, 100);
        if(fingerY>1020)
        {
            bp1.leftMargin =(int) 1196-150;
            bp1.topMargin = (int) 1020+210;
        }
        else
        {
            bp1.leftMargin =(int) fingerX-150;
            bp1.topMargin = (int) fingerY+210;
        }

        btn1.setLayoutParams(bp1);
        btn1.setTextSize(20);
        text = expandKey.get(1);
        btn1.setText(text.toUpperCase());
        rl.addView(btn1);

        Button btn2 = new Button(getApplicationContext());
        RelativeLayout.LayoutParams bp2 = new RelativeLayout.LayoutParams(150, 100);
        if(fingerY>1020)
        {
            bp2.leftMargin =(int) 1196-150;
            bp2.topMargin = (int) 1020+320;
        }
        else
        {
            bp2.leftMargin =(int) fingerX-150;
            bp2.topMargin = (int) fingerY+320;
        }
        btn2.setLayoutParams(bp2);
        text = expandKey.get(2);
        btn2.setTextSize(20);
        btn2.setText(text.toUpperCase());
        rl.addView(btn2);

        Button btn3 = new Button(getApplicationContext());
        RelativeLayout.LayoutParams bp3 = new RelativeLayout.LayoutParams(150, 100);
        if(fingerY>1020)
        {
            bp3.leftMargin =(int) 1196-150;
            bp3.topMargin = (int) 1020+430;
        }
        else
        {
            bp3.leftMargin =(int) fingerX-150;
            bp3.topMargin = (int) fingerY+430;
        }

        btn3.setLayoutParams(bp3);
        btn3.setTextSize(20);
        text = expandKey.get(3);
        btn3.setText(text.toUpperCase());
        rl.addView(btn3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repeatKey();
                CapExpandableKeyboard();
                CapfirstRow();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repeatKey();
                CapExpandableKeyboard();
                CapsecondRow();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repeatKey();
                CapExpandableKeyboard();
                CapthirdRow();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repeatKey();
                btn3.setText(label);
                if (btn3.getText().equals("CAP")) {
                    CapExpandableKeyboard();
                    fourthRow();
                }
                if (btn3.getText().equals("#?2")) {
                    SymBolExpandableKeyboard();
                    fourthRow();
                } else {
                    ExpandableKeyboard();
                    fourthRow();
                }
            }

        });
    }
    private void CapfirstRow() {

        double dblArcAngle = (90 / intTotalButtonOnFirstRow);

        for (int i = 0; i < intTotalButtonOnFirstRow; i++) {
            double dblButtonAngle = dblArcAngle * i;
            int w = (int) Math.sqrt((2 * floatRadius * floatRadius) * (1 - getThetaInRadian(dblButtonAngle)));
            double t1 = 90 - (dblButtonAngle / 2);
            int x = (int) (w * getThetaInRadian(t1));
            int y = (int) Math.sqrt((w * w) - (x * x));

            //get button position X and Y
            int intButtonX = (int) (intWidth - floatRadius + x);
            int intButtonY = intHeight - y;

            //create and place button at X and Y
            int intButtonWidth = intButtonDistance / intTotalButtonOnFirstRow;
            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intButtonWidth, 100);
            bp.leftMargin = (int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float) (dblButtonAngle - 90));
            btn.setTextSize(20);
            text = childlistFirstRow.get(i);
            btn.setText(text.toUpperCase());
            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataExpandable = insertkeyDataExpandable+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                   // System.out.println(insertkeyData);
                  //  WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataExpandable = insertDataExpandable + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                      //  WriteFile(insertData,MainActivity.this);

                    }
                    ExpandableKeyboard();
                }
            });
        }
    }
    private void CapsecondRow() {

        int intSecondRadius = (int) floatRadius;
        int intSecondButtonWidth = ((intButtonDistance) / intTotalButtonSecondRow);
        double dblArcAngleSecond = (90 / intTotalButtonSecondRow);

        for(int i=0;i<intTotalButtonSecondRow;i++)
        {
            double dblButtonAngle = dblArcAngleSecond * i;
            int w = (int)Math.sqrt((2*intSecondRadius*intSecondRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));

            //get button position X and Y
            int intButtonX = (int) (intWidth - intSecondRadius+x);
            int intButtonY = intHeight - y;

            //create and place button at X and Y

            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intSecondButtonWidth, 100);
            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(dblButtonAngle-90));
            text = childlistSecondRow.get(i);
            btn.setTextSize(20);
            btn.setText(text);
            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataExpandable = insertkeyDataExpandable+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                   // WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataExpandable = insertDataExpandable + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                      //  WriteFile(insertData,MainActivity.this);

                    }
                    ExpandableKeyboard();
                }
            });
        }
    }
    private void CapthirdRow() {
        int intThirdRadius = (int) floatRadius;
        int intThirdButtonWidth = ((intButtonDistance) / intTotalButtonThirdRow);
        double dblArcAngleThird = (90 / intTotalButtonThirdRow);

        for(int i=0;i<intTotalButtonThirdRow;i++)
        {
            double dblButtonAngle = dblArcAngleThird * i;
            int w = (int)Math.sqrt((2*intThirdRadius*intThirdRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));
            System.out.println("w: "+w+" t1: "+t1);
            System.out.println("x: "+x+" y: "+y);
            //get button position X and Y
            int intButtonX = (int) (intWidth - intThirdRadius+x);
            int intButtonY = intHeight - y;

            //create and place button at X and Y
            // int intButtonWidth = intButtonDistance/inTotalButtonOnRow;
            Button btn = new Button(getApplicationContext());
            text = childlistThirdRow.get(i);

            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intThirdButtonWidth, 100);

            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(dblButtonAngle-90));
            btn.setTextSize(20);
            btn.setText(text);

            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataExpandable = insertkeyDataExpandable+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                  //  WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataExpandable = insertDataExpandable + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                      //  WriteFile(insertData,MainActivity.this);
                    }
                    ExpandableKeyboard();
                }
            });
        }
    }

//=============================================================================================================
    private void SymBolExpandableKeyboard()
    {
        float fingerX = EndX;
        float fingerY = EndY;

        Button btn = new Button(getApplicationContext());
        RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(150, 100);
        if(fingerY>1020)
        {
            bp.leftMargin =(int) 1196-150;
            bp.topMargin = (int) 1020+100;
        }
        else
        {
            bp.leftMargin =(int) fingerX-150;
            bp.topMargin = (int) fingerY+100;
        }

        btn.setLayoutParams(bp);
        btn.setTextSize(20);
        text = "0-9";
        btn.setText(text.toUpperCase());
        rl.addView(btn);

        Button btn1 = new Button(getApplicationContext());
        RelativeLayout.LayoutParams bp1 = new RelativeLayout.LayoutParams(150, 100);
        if(fingerY>1020)
        {
            bp1.leftMargin =(int) 1196-150;
            bp1.topMargin = (int) 1020+210;
        }
        else
        {
            bp1.leftMargin =(int) fingerX-150;
            bp1.topMargin = (int) fingerY+210;
        }

        btn1.setLayoutParams(bp1);
        btn1.setTextSize(20);
        text = "!-*";
        btn1.setText(text.toUpperCase());
        rl.addView(btn1);

        Button btn2 = new Button(getApplicationContext());
        RelativeLayout.LayoutParams bp2 = new RelativeLayout.LayoutParams(150, 100);
        if(fingerY>1020)
        {
            bp2.leftMargin =(int) 1196-150;
            bp2.topMargin = (int) 1020+320;
        }
        else
        {
            bp2.leftMargin =(int) fingerX-150;
            bp2.topMargin = (int) fingerY+320;
        }

        btn2.setLayoutParams(bp2);
        btn2.setTextSize(20);
        text = "{-?";
        btn2.setText(text.toUpperCase());
        rl.addView(btn2);

        Button btn3 = new Button(getApplicationContext());
        RelativeLayout.LayoutParams bp3 = new RelativeLayout.LayoutParams(150, 100);
        if(fingerY>1020)
        {
            bp3.leftMargin =(int) 1196-150;
            bp3.topMargin = (int) 1020+430;
        }
        else
        {
            bp3.leftMargin =(int) fingerX-150;
            bp3.topMargin = (int) fingerY+430;
        }

        btn3.setLayoutParams(bp3);
        btn3.setTextSize(20);
        text = "#?2";
        btn3.setText(text.toUpperCase());
        rl.addView(btn3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repeatKey();
                SymBolExpandableKeyboard();
                SymfirstRow();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repeatKey();
                SymBolExpandableKeyboard();
                SymsecondRow();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repeatKey();
                SymBolExpandableKeyboard();
                SymthirdRow();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v)
           {
               repeatKey();
               if (btn3.getText().equals("CAP")) {
                   CapExpandableKeyboard();
                   fourthRow();
               }
               if (btn3.getText().equals("?2")) {
                   SymBolExpandableKeyboard();

                   fourthRow();
               } else {
                   ExpandableKeyboard();
                   fourthRow();
               }
               btn3.setText("abc");
           }
        });
    }
    private void SymfirstRow() {

        double dblArcAngle = (90 / intTotalButtonOnFirstRow);

        for (int i = 0; i < intTotalButtonOnFirstRow; i++) {
            double dblButtonAngle = dblArcAngle * i;
            int w = (int) Math.sqrt((2 * floatRadius * floatRadius) * (1 - getThetaInRadian(dblButtonAngle)));
            double t1 = 90 - (dblButtonAngle / 2);
            int x = (int) (w * getThetaInRadian(t1));
            int y = (int) Math.sqrt((w * w) - (x * x));

            //get button position X and Y
            int intButtonX = (int) (intWidth - floatRadius + x);
            int intButtonY = intHeight - y;

            //create and place button at X and Y
            int intButtonWidth = intButtonDistance / intTotalButtonOnFirstRow;
            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intButtonWidth, 100);
            bp.leftMargin = (int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float) (dblButtonAngle - 90));
            text = childlistNumber.get(i);
            btn.setTextSize(20);
            btn.setText(text.toUpperCase());
            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataExpandable = insertkeyDataExpandable+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                  //  WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataExpandable = insertDataExpandable + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                      //  WriteFile(insertData,MainActivity.this);
                    }
                    ExpandableKeyboard();
                }
            });
        }
    }
    private void SymsecondRow() {

        int intSecondRadius = (int) floatRadius;
        int intSecondButtonWidth = ((intButtonDistance) / intTotalButtonSecondRow);
        double dblArcAngleSecond = (90 / intTotalButtonSecondRow);

        for(int i=0;i<intTotalButtonSecondRow;i++)
        {
            double dblButtonAngle = dblArcAngleSecond * i;
            int w = (int)Math.sqrt((2*intSecondRadius*intSecondRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));

            //get button position X and Y
            int intButtonX = (int) (intWidth - intSecondRadius+x);
            int intButtonY = intHeight - y;

            //create and place button at X and Y

            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intSecondButtonWidth, 100);
            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(dblButtonAngle-90));
            text = childlistSymbol.get(i);
            btn.setTextSize(20);
            btn.setText(text);
            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataExpandable = insertkeyDataExpandable+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                  //  WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataExpandable = insertDataExpandable + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                      //  WriteFile(insertData,MainActivity.this);

                    }
                    ExpandableKeyboard();
                }
            });
        }
    }
    private void SymthirdRow() {
        int intThirdRadius = (int) floatRadius;
        int intThirdButtonWidth = ((intButtonDistance) / intTotalButtonThirdRow);
        double dblArcAngleThird = (90 / intTotalButtonThirdRow);

        for(int i=0;i<intTotalButtonThirdRow;i++)
        {
            double dblButtonAngle = dblArcAngleThird * i;
            int w = (int)Math.sqrt((2*intThirdRadius*intThirdRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));

            //get button position X and Y
            int intButtonX = (int) (intWidth - intThirdRadius+x);
            int intButtonY = intHeight - y;

            //create and place button at X and Y

            Button btn = new Button(getApplicationContext());
            text = childlistSymbolSecond.get(i);

            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intThirdButtonWidth, 100);

            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(dblButtonAngle-90));
            btn.setTextSize(20);
            btn.setText(text);

            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                    et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataExpandable = insertkeyDataExpandable+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                  //  WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataExpandable = insertDataExpandable + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                      //  WriteFile(insertData,MainActivity.this);
                    }
                    ExpandableKeyboard();
                }
            });
        }
    }
//=============================================================================================================
    private void LeftDrawKeyboard()
    {
    int intarcheight=0;
    int intarcwidth=0;
    int intSecondRadius = (int)  LeftfloatRadius-110;
    int intThirdRadius = (int)  LeftfloatRadius-220;
    int intFourRadius = (int)  LeftfloatRadius-310;
    int intSecondButtonWidth = ((intButtonDistanceLeft-100)/intTotalButtonSecondRowLeft);
    int intThirdButtonWidth = ((intButtonDistanceLeft-200)/intTotalButtonThirdRowLeft);
    int intFourthButtonWidth = ((intButtonDistanceLeft-300)/intTotalButtonFourRowLeft);
    double dblArcAngle = (90/intTotalButtonOnFirstRowLeft);
    double dblArcAngleSecond = (90/intTotalButtonSecondRowLeft);
    double dblArcAngleThird=(90/intTotalButtonThirdRowLeft);
    double dblArcAngleFour=(90/intTotalButtonFourRowLeft);

    for(int i=0;i<intTotalButtonOnFirstRowLeft;i++)
    {
        double dblButtonAngle = dblArcAngle * i;
        int w = (int)Math.sqrt((2* LeftfloatRadius* LeftfloatRadius)*(1-getThetaInRadian(dblButtonAngle)));
        double t1 = 90-(dblButtonAngle/2);
        int x = (int)( w*getThetaInRadian(t1));
        int y = (int)Math.sqrt((w*w)-(x*x));

        //get button position X and Y
        int intButtonX = (int) ( LeftfloatRadius-x);
        int intButtonY = intHeight - y;
        System.out.println("ButtonX: "+intButtonX+" ButtonY: "+intButtonY);
        //create and place button at X and Y
        int intButtonWidth = intButtonDistanceLeft/intTotalButtonOnFirstRowLeft;
        Button btn = new Button(getApplicationContext());
        RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intButtonWidth, 100);
        bp.leftMargin =(int) intButtonX;
        bp.topMargin = (int) intButtonY;
        btn.setLayoutParams(bp);
        btn.setRotation((float)(90-dblButtonAngle));
        text = LeftchildlistFirstRow.get(i);
        btn.setText(text.toLowerCase());
        btn.setTextSize(20);
        btn.setAllCaps(false);

        rl.addView(btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et.getText().toString().equals("|"))
                {
                    startTime=Calendar.getInstance().getTimeInMillis();
                    //System.out.println(startTime);
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                }

                inputString= inputString+btn.getText().toString();
                if(inputString.isEmpty())
                {
                    et.setText(redSpannable);
                }
                else
                et.setText(inputString);
                et.append(redSpannable);
                keystroke =btn.getText().toString();
                StopKeyTime=Calendar.getInstance().getTimeInMillis();
                insertkeyDataCustom = insertkeyDataCustom+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                startKeyTimes = Calendar.getInstance().getTimeInMillis();
               // System.out.println(insertkeyData);
              //  WriteFile1(insertkeyData,MainActivity.this);
                if(textdisplay.getText().toString().equals(inputString))
                {
                    btnnext.setEnabled(true);
                    alertDialog(" Click NEXT for the next sentence. ","Instruction");
                    endTime=Calendar.getInstance().getTimeInMillis();
                    insertDataCustom = insertDataCustom + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                    //System.out.println(insertData);
                  //  WriteFile(insertData,MainActivity.this);
                }
            }
        });
    }
    for(int i=0;i<intTotalButtonSecondRowLeft;i++)
    {
        double dblButtonAngle = dblArcAngleSecond * i;
        int w = (int)Math.sqrt((2*intSecondRadius*intSecondRadius)*(1-getThetaInRadian(dblButtonAngle)));
        double t1 = 90-(dblButtonAngle/2);
        int x = (int)( w*getThetaInRadian(t1));
        int y = (int)Math.sqrt((w*w)-(x*x));

        //get button position X and Y
        int intButtonX = (int) (intSecondRadius-x);
        int intButtonY = intHeight - y;
        System.out.println("ButtonX: "+intButtonX+" ButtonY: "+intButtonY);
        //create and place button at X and Y
        // int intButtonWidth = intButtonDistance/inTotalButtonOnRow;
        Button btn = new Button(getApplicationContext());

        RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intSecondButtonWidth, 100);

        bp.leftMargin =(int) intButtonX;
        bp.topMargin = (int) intButtonY;
        btn.setLayoutParams(bp);
        btn.setRotation((float)(90-dblButtonAngle));
        text = LeftchildlistSecondRow.get(i);
        btn.setText(text.toLowerCase());
        btn.setTextSize(20);
        btn.setAllCaps(false);
        rl.addView(btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et.getText().toString().equals("|"))
                {
                    startTime=Calendar.getInstance().getTimeInMillis();
                    //System.out.println(startTime);
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                }

                inputString= inputString+btn.getText().toString();
                if(inputString.isEmpty())
                {
                    et.setText(redSpannable);
                }
                else
                et.setText(inputString);
                et.append(redSpannable);
                keystroke =btn.getText().toString();
                StopKeyTime=Calendar.getInstance().getTimeInMillis();
                insertkeyDataCustom = insertkeyDataCustom+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                startKeyTimes = Calendar.getInstance().getTimeInMillis();
                //System.out.println(insertkeyData);
              //  WriteFile1(insertkeyData,MainActivity.this);
                if(textdisplay.getText().toString().equals(inputString))
                {
                    btnnext.setEnabled(true);
                    alertDialog(" Click NEXT for the next sentence. ","Instruction");
                    endTime=Calendar.getInstance().getTimeInMillis();
                    insertDataCustom = insertDataCustom + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                   // System.out.println(insertData);
                  //  WriteFile(insertData,MainActivity.this);
                }
            }
        });
    }
    for(int i=0;i<intTotalButtonThirdRowLeft;i++)
    {
        double dblButtonAngle = dblArcAngleThird * i;
        int w = (int)Math.sqrt((2*intThirdRadius*intThirdRadius)*(1-getThetaInRadian(dblButtonAngle)));
        double t1 = 90-(dblButtonAngle/2);
        int x = (int)( w*getThetaInRadian(t1));
        int y = (int)Math.sqrt((w*w)-(x*x));
        System.out.println("w: "+w+" t1: "+t1);
        System.out.println("x: "+x+" y: "+y);
        //get button position X and Y
        int intButtonX = (int) (intThirdRadius-x);
        int intButtonY = intHeight - y;
        System.out.println("ButtonX: "+intButtonX+" ButtonY: "+intButtonY);
        //create and place button at X and Y
        // int intButtonWidth = intButtonDistance/inTotalButtonOnRow;
        Button btn = new Button(getApplicationContext());
        text = LeftchildlistThirdRow.get(i);

        RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intThirdButtonWidth, 100);

        bp.leftMargin =(int) intButtonX;
        bp.topMargin = (int) intButtonY;
        btn.setLayoutParams(bp);
        btn.setRotation((float)(90-dblButtonAngle));
        btn.setText(text.toLowerCase());
        btn.setTextSize(20);
        btn.setAllCaps(false);

        rl.addView(btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et.getText().toString().equals("|"))
                {
                    startTime=Calendar.getInstance().getTimeInMillis();
                    //System.out.println(startTime);
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                }

                inputString= inputString+btn.getText().toString();
                if(inputString.isEmpty())
                {
                    et.setText(redSpannable);
                }
                else
                et.setText(inputString);
                et.append(redSpannable);
                keystroke =btn.getText().toString();
                StopKeyTime=Calendar.getInstance().getTimeInMillis();
                insertkeyDataCustom = insertkeyDataCustom+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                startKeyTimes = Calendar.getInstance().getTimeInMillis();
                //System.out.println(insertkeyData);
              //  WriteFile1(insertkeyData,MainActivity.this);
                if(textdisplay.getText().toString().equals(inputString))
                {
                    btnnext.setEnabled(true);
                    alertDialog(" Click NEXT for the next sentence. ","Instruction");
                    endTime=Calendar.getInstance().getTimeInMillis();
                    insertDataCustom = insertDataCustom + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                    //System.out.println(insertData);
                  //  WriteFile(insertData,MainActivity.this);
                }
            }
        });
    }
    for(int i=0;i<intTotalButtonFourRowLeft;i++) {

        double dblButtonAngle = dblArcAngleFour * i;
        int w = (int)Math.sqrt((2*intFourRadius*intFourRadius)*(1-getThetaInRadian(dblButtonAngle)));
        double t1 = 90-(dblButtonAngle/2);
        int x = (int)( w*getThetaInRadian(t1));
        int y = (int)Math.sqrt((w*w)-(x*x));
        System.out.println("w: "+w+" t1: "+t1);
        System.out.println("x: "+x+" y: "+y);
        //get button position X and Y
        int intButtonX = (int) (intFourRadius-x);
        int intButtonY = intHeight - y;
        System.out.println("ButtonX: "+intButtonX+" ButtonY: "+intButtonY);
        //create and place button at X and Y
        // int intButtonWidth = intButtonDistance/inTotalButtonOnRow;
        Button btn = new Button(getApplicationContext());
        text = LeftchildlistFourRow.get(i);

        RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intFourthButtonWidth, 100);
        bp.leftMargin =(int) intButtonX;
        bp.topMargin = (int) intButtonY;
        btn.setLayoutParams(bp);
        btn.setRotation((float)(90-dblButtonAngle));
        btn.setText(text);
        btn.setTextSize(15);

        rl.addView(btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn.getText().equals("CAP"))
                {
                    LeftCapDrawKeyboard();
                }
                if(btn.getText().equals("#?2") || btn.getText().equals("abc"))
                {
                    if(btn.getText().equals("abc"))
                    {
                        LeftDrawKeyboard();
                        btn.setText("#?2");
                    }
                    else
                    {
                        btn.setText("abc");
                        btn.setAllCaps(false);
                        LeftSymbolKeyboard();
                    }

                }
                if(btn.getText().equals("."))
                {
                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                        et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataCustom = insertkeyDataCustom+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                    // WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataCustom = insertDataCustom + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                        //   WriteFile(insertData,MainActivity.this);
                    }
                }
                if(btn.getText().equals(","))
                {
                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                        et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataCustom = insertkeyDataCustom+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                    //  WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataCustom = insertDataCustom + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                        //    WriteFile(insertData,MainActivity.this);
                    }
                }
                if(btn.getText().equals("Spc"))
                {
                    inputString= inputString+" ";
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                        et.setText(inputString);
                    et.append(redSpannable);
                    keystroke ="Spc";
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataCustom = insertkeyDataCustom+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                    // WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                    }
                }
                else if(btn.getText().equals("\u232b"))
                {
                    String str;
                    if(et.getText().equals(""))
                    {
                        str=redSpannable.toString();
                    }
                    else
                        str = et.getText().toString();
                    System.out.println("String for backspace:"+str);
                    text = backspace(str);
                    inputString=text;
                    if(inputString.isEmpty())
                    {
                        et.setText("");
                    }
                    else
                        et.setText(inputString);
                    et.append(redSpannable);
                    keystroke ="Bsp";
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataCustom = insertkeyDataCustom+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                    // WriteFile1(insertkeyData,MainActivity.this);
                }
                else if(btn.getText().equals("Ent"))
                {
                    inputString= inputString+"\n";
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                        et.setText(inputString);
                    et.append(redSpannable);
                    keystroke ="Ent";
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataCustom = insertkeyDataCustom+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                   //System.out.println(insertkeyData);
                    // WriteFile1(insertkeyData,MainActivity.this);
                }
                else
                    System.out.println("The text :"+et.getText().length());
            }
        });

    }

}
    private void LeftCapDrawKeyboard()
    {
        int intarcheight=0;
        int intarcwidth=0;
        int intSecondRadius = (int)  LeftfloatRadius-110;
        int intThirdRadius = (int)  LeftfloatRadius-220;
        int intFourRadius = (int)  LeftfloatRadius-310;
        int intSecondButtonWidth = ((intButtonDistanceLeft-100)/intTotalButtonSecondRowLeft);
        int intThirdButtonWidth = ((intButtonDistanceLeft-200)/intTotalButtonThirdRowLeft);
        int intFourthButtonWidth = ((intButtonDistanceLeft-300)/intTotalButtonFourRowLeft);
        double dblArcAngle = (90/intTotalButtonOnFirstRowLeft);
        double dblArcAngleSecond = (90/intTotalButtonSecondRowLeft);
        double dblArcAngleThird=(90/intTotalButtonThirdRowLeft);
        double dblArcAngleFour=(90/intTotalButtonFourRowLeft);

        for(int i=0;i<intTotalButtonOnFirstRowLeft;i++)
        {
            double dblButtonAngle = dblArcAngle * i;
            int w = (int)Math.sqrt((2* LeftfloatRadius* LeftfloatRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));

            //get button position X and Y
            int intButtonX = (int) ( LeftfloatRadius-x);
            int intButtonY = intHeight - y;
            System.out.println("ButtonX: "+intButtonX+" ButtonY: "+intButtonY);
            //create and place button at X and Y
            int intButtonWidth = intButtonDistanceLeft/intTotalButtonOnFirstRowLeft;
            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intButtonWidth, 100);
            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(90-dblButtonAngle));
            text = LeftchildlistFirstRow.get(i);
            btn.setText(text.toUpperCase());
            btn.setTextSize(20);

            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                        et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataCustom = insertkeyDataCustom+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                    //  WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataCustom = insertDataCustom + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                        //  WriteFile(insertData,MainActivity.this);
                    }
                    LeftDrawKeyboard();
                }
            });
        }
        for(int i=0;i<intTotalButtonSecondRowLeft;i++)
        {
            double dblButtonAngle = dblArcAngleSecond * i;
            int w = (int)Math.sqrt((2*intSecondRadius*intSecondRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));

            //get button position X and Y
            int intButtonX = (int) (intSecondRadius-x);
            int intButtonY = intHeight - y;
            System.out.println("ButtonX: "+intButtonX+" ButtonY: "+intButtonY);
            //create and place button at X and Y
            // int intButtonWidth = intButtonDistance/inTotalButtonOnRow;
            Button btn = new Button(getApplicationContext());

            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intSecondButtonWidth, 100);

            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(90-dblButtonAngle));
            text = LeftchildlistSecondRow.get(i);
            btn.setText(text.toUpperCase());
            btn.setTextSize(20);

            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }
                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                        et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataCustom = insertkeyDataCustom+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                    //  WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataCustom = insertDataCustom + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                        //  WriteFile(insertData,MainActivity.this);
                    }
                    LeftDrawKeyboard();
                }
            });
        }
        for(int i=0;i<intTotalButtonThirdRowLeft;i++)
        {
            double dblButtonAngle = dblArcAngleThird * i;
            int w = (int)Math.sqrt((2*intThirdRadius*intThirdRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));

            //get button position X and Y
            int intButtonX = (int) (intThirdRadius-x);
            int intButtonY = intHeight - y;
            System.out.println("ButtonX: "+intButtonX+" ButtonY: "+intButtonY);
            //create and place button at X and Y
            // int intButtonWidth = intButtonDistance/inTotalButtonOnRow;
            Button btn = new Button(getApplicationContext());
            text = LeftchildlistThirdRow.get(i);

            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intThirdButtonWidth, 100);

            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(90-dblButtonAngle));
            btn.setText(text.toUpperCase());
            btn.setTextSize(20);

            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                        et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataCustom = insertkeyDataCustom+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                    //  WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataCustom = insertDataCustom + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                        //  WriteFile(insertData,MainActivity.this);
                    }
                    LeftDrawKeyboard();
                }
            });
        }
    }
    private void  LeftSymbolKeyboard()
    {
        int intarcheight=0;
        int intarcwidth=0;
        int intSecondRadius = (int)  LeftfloatRadius-110;
        int intThirdRadius = (int)  LeftfloatRadius-220;
        int intFourRadius = (int)  LeftfloatRadius-310;
        int intSecondButtonWidth = ((intButtonDistanceLeft-100)/intTotalButtonSecondRowLeft);
        int intThirdButtonWidth = ((intButtonDistanceLeft-200)/intTotalButtonThirdRowLeft);
        int intFourthButtonWidth = ((intButtonDistanceLeft-300)/intTotalButtonFourRowLeft);
        double dblArcAngle = (90/intTotalButtonOnFirstRowLeft);
        double dblArcAngleSecond = (90/intTotalButtonSecondRowLeft);
        double dblArcAngleThird=(90/intTotalButtonThirdRowLeft);
        double dblArcAngleFour=(90/intTotalButtonFourRowLeft);

        for(int i=0;i<intTotalButtonOnFirstRowLeft;i++)
        {
            double dblButtonAngle = dblArcAngle * i;
            int w = (int)Math.sqrt((2* LeftfloatRadius* LeftfloatRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));
            System.out.println("w: "+w+" t1: "+t1);
            System.out.println("x: "+x+" y: "+y);
            //get button position X and Y
            int intButtonX = (int) ( LeftfloatRadius-x);
            int intButtonY = intHeight - y;
            System.out.println("ButtonX: "+intButtonX+" ButtonY: "+intButtonY);
            //create and place button at X and Y
            int intButtonWidth = intButtonDistanceLeft/intTotalButtonOnFirstRowLeft;
            Button btn = new Button(getApplicationContext());
            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intButtonWidth, 100);
            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(90-dblButtonAngle));
            text = LeftchildlistNumber.get(i);
            btn.setText(text.toUpperCase());
            btn.setTextSize(20);

            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                        et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataCustom = insertkeyDataCustom+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                    //  WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString)) {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime = Calendar.getInstance().getTimeInMillis();
                        insertDataCustom = insertDataCustom + HandSide + "," + KeyboardTpe + "," + sentence + "," + intsentence + "," + startTime + "," + endTime + "," + ErrorCount + "\n";
                        //System.out.println(insertData);
                        //  WriteFile(insertData,MainActivity.this);
                    }
                }
            });
        }
        for(int i=0;i<intTotalButtonSecondRowLeft;i++)
        {
            double dblButtonAngle = dblArcAngleSecond * i;
            int w = (int)Math.sqrt((2*intSecondRadius*intSecondRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));

            //get button position X and Y
            int intButtonX = (int) (intSecondRadius-x);
            int intButtonY = intHeight - y;
            System.out.println("ButtonX: "+intButtonX+" ButtonY: "+intButtonY);
            //create and place button at X and Y
            // int intButtonWidth = intButtonDistance/inTotalButtonOnRow;
            Button btn = new Button(getApplicationContext());

            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intSecondButtonWidth, 100);

            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(90-dblButtonAngle));
            text = LeftchildlistSymbol.get(i);
            btn.setText(text.toUpperCase());
            btn.setTextSize(20);

            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                        et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataCustom = insertkeyDataCustom+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                    //  WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataCustom = insertDataCustom + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                        //  WriteFile(insertData,MainActivity.this);
                    }
                }
            });
        }
        for(int i=0;i<intTotalButtonThirdRowLeft;i++)
        {
            double dblButtonAngle = dblArcAngleThird * i;
            int w = (int)Math.sqrt((2*intThirdRadius*intThirdRadius)*(1-getThetaInRadian(dblButtonAngle)));
            double t1 = 90-(dblButtonAngle/2);
            int x = (int)( w*getThetaInRadian(t1));
            int y = (int)Math.sqrt((w*w)-(x*x));
            System.out.println("w: "+w+" t1: "+t1);
            System.out.println("x: "+x+" y: "+y);
            //get button position X and Y
            int intButtonX = (int) (intThirdRadius-x);
            int intButtonY = intHeight - y;
            System.out.println("ButtonX: "+intButtonX+" ButtonY: "+intButtonY);
            //create and place button at X and Y
            // int intButtonWidth = intButtonDistance/inTotalButtonOnRow;
            Button btn = new Button(getApplicationContext());
            text = LeftchildlistSymbolSecond.get(i);

            RelativeLayout.LayoutParams bp = new RelativeLayout.LayoutParams(intThirdButtonWidth, 100);

            bp.leftMargin =(int) intButtonX;
            bp.topMargin = (int) intButtonY;
            btn.setLayoutParams(bp);
            btn.setRotation((float)(90-dblButtonAngle));
            btn.setText(text.toUpperCase());
            btn.setTextSize(20);

            rl.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("|"))
                    {
                        startTime=Calendar.getInstance().getTimeInMillis();
                        //System.out.println(startTime);
                        startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    }

                    inputString= inputString+btn.getText().toString();
                    if(inputString.isEmpty())
                    {
                        et.setText(redSpannable);
                    }
                    else
                        et.setText(inputString);
                    et.append(redSpannable);
                    keystroke =btn.getText().toString();
                    StopKeyTime=Calendar.getInstance().getTimeInMillis();
                    insertkeyDataCustom = insertkeyDataCustom+Handside+","+KeyboardTpe+","+sentence + ","+intsentence + "," + keystroke + "," + startKeyTimes +","+StopKeyTime+"," + ErrorCount+"\n";
                    startKeyTimes = Calendar.getInstance().getTimeInMillis();
                    //System.out.println(insertkeyData);
                    //  WriteFile1(insertkeyData,MainActivity.this);
                    if(textdisplay.getText().toString().equals(inputString))
                    {
                        btnnext.setEnabled(true);
                        alertDialog(" Click NEXT for the next sentence. ","Instruction");
                        endTime=Calendar.getInstance().getTimeInMillis();
                        insertDataCustom = insertDataCustom + HandSide +","+KeyboardTpe+","+ sentence + "," + intsentence + "," + startTime + "," + endTime+","+ErrorCount+"\n";
                        //System.out.println(insertData);
                        //  WriteFile(insertData,MainActivity.this);
                    }
                }
            });

        }
    }
    private void WriteFile(String text, Context context)
    {
        File file = new File(context.getExternalFilesDir(
                Environment.DIRECTORY_DOWNLOADS), filename);
        if (!file.mkdirs()) {
            System.out.println("Directory not created");

        }
        try {

            File gpxfile = new File(file, filename);
            FileWriter writer = new FileWriter(gpxfile);
            FileOutputStream fileinput = new FileOutputStream(gpxfile, true);
            writer.append(text);
            writer.close();

            System.out.println("File saved successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void WriteFile1(String text, Context context)
    {
        File file = new File(context.getExternalFilesDir(
                Environment.DIRECTORY_DOWNLOADS), filename1);
        if (!file.mkdirs()) {
            System.out.println("Directory not created");

        }
        try {

            File gpxfile = new File(file, filename1);
            FileWriter writer = new FileWriter(gpxfile);
            FileOutputStream fileinput = new FileOutputStream(gpxfile, true);
            writer.append(text);

            writer.close();

            System.out.println("File saved successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}