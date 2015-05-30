package com.example.harshitha.contacts_app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MainActivity extends Activity {

    ListView Lv;
    Context context;
    ToggleButton Tgle;
    EditText name;
    Button search;

    public static int [] contactImages={R.mipmap.anne,R.mipmap.beyonce,R.mipmap.clooney,R.mipmap.decaprio,R.mipmap.halle,R.mipmap.johnydepp,R.mipmap.juliaroberts,R.mipmap.natalieportman,R.mipmap.oprah,R.mipmap.robertdowneyjr,R.mipmap.sandra,R.mipmap.taylorswift,R.mipmap.tomcruise,R.mipmap.tomhanks,R.mipmap.willsmith};
    public static String [] contactNameList={"Anne Hathaway","Beyonce","Clooney","Decaprio","Halle Berry","Johny Depp","Julia Roberts","Natalie Portman","Oprah","Robert Downey Jr.","Sandra Bullock","Taylorswift","Tom Cruise","Tom Hanks","Will Smith"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this;
        search=(Button)findViewById(R.id.button);
        Tgle =(ToggleButton)findViewById(R.id.toggleButton);
        name=(EditText)findViewById(R.id.editText);
        Lv=(ListView) findViewById(R.id.listView);
        Lv.setAdapter(new CustomAdapter(this, contactNameList,contactImages));
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<String> list = Arrays.asList(contactNameList);
                if(list.contains(name.getText().toString())) {
                    Toast.makeText(MainActivity.this,"Contact found :"+name.getText().toString(), Toast.LENGTH_SHORT).show();
                    Log.d("search","in if,Life is good");
                }
                 else
                {Toast.makeText(MainActivity.this,"Missing", Toast.LENGTH_SHORT).show();
                   Log.d("search","in else, i'm sorry");
                }
            }

        });
    }

    public void onToggleClicked(View view) {
        boolean on = ((ToggleButton) view).isChecked();
        //Integer[] images = new Integer[contactImages.length];
        /*for(i=0;i<contactImages.length;i++)
        {
            images[i]= new Integer(contactImages[i]);
        }*/
        if (on) {
            Log.i("info", "Toggle is on!,descending");
           Arrays.sort(contactNameList, Collections.reverseOrder());
            int j;
            for(j=0;j<15;j++)
            {
                Log.d("names",contactNameList[j]);
            }
            int a, b;
            int temp;
            for (a = 0; a < contactImages.length-1; ++a) {
                for (b = 0; b <contactImages.length-1 ; ++b) {
                    if (contactImages[b] < contactImages[b + 1]) {
                        temp = contactImages[b];
                        contactImages[b] = contactImages[b + 1];
                        contactImages[b + 1] = temp;
                    }
                }
            }

            Lv=(ListView) findViewById(R.id.listView);
            Lv.setAdapter(new CustomAdapter(this, contactNameList,contactImages));
        }

        else {
            Log.i("info", "Toggle is off!,ascending");
            Arrays.sort(contactNameList);
           /* int x, y;
            String tempS;

            for ( x = 0;  x < contactNameList.length - 1;  x++ ) {
                for (y = x + 1; y < contactNameList.length; y++) {
                    if (contactNameList[x].compareToIgnoreCase(contactNameList[y]) > 0) {
                        tempS = contactNameList[x];
                        contactNameList[x] = contactNameList[y];
                        contactNameList[y] = tempS;

                    }
                }
            }*/
            int a, b;
            int temp;
            for (a = 0; a < 14; ++a) {
                for (b = 0; b < 14; ++b) {
                    if (contactImages[b] > contactImages[b + 1]) {
                        temp = contactImages[b];
                        contactImages[b] = contactImages[b + 1];
                        contactImages[b + 1] = temp;
                    }
                }
            }
        Lv=(ListView) findViewById(R.id.listView);
        Lv.setAdapter(new CustomAdapter(this, contactNameList,contactImages));
        }
    }

}
