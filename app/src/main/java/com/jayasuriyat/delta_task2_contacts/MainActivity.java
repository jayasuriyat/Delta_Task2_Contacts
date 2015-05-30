package com.jayasuriyat.delta_task2_contacts;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;




public class MainActivity extends Activity
{


    String[] Contacts={"Ross","Mike","Phoebe","Richard","Emily","Monica","Joey","Carol","Rachel","Gunther","Janice","Chandler" };
    int[] img={R.drawable.ross,R.drawable.mike,R.drawable.phoebe,R.drawable.richard,R.drawable.emily,R.drawable.monica,R.drawable.joey,
            R.drawable.carol,R.drawable.rachel,R.drawable.gunther,R.drawable.janice,R.drawable.chandler};
    ListView listView;
    EditText t;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListAdapter JsAdapter=new CustomAdapter(this,Contacts,img);
        listView=(ListView) findViewById(R.id.listView);
        listView.setAdapter(JsAdapter);
        listView.setFastScrollEnabled(true);
        listView.setOnItemClickListener
                (
                        new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                String Players = String.valueOf(parent.getItemAtPosition(position));
                                Toast.makeText(MainActivity.this, Players, Toast.LENGTH_LONG).show();

                            }
                        }


                );





    }




    private static void BubbleSortAsc(String[] array,int[] num)
    {
        String t;
        int temp;
        for(int i=0; i<array.length; i++) {
            for(int j=0; j<array.length-1-i; j++) {
                if(array[j].compareTo(array[j+1])>0) {
                    t= array[j];
                    array[j] = array[j+1];
                    array[j+1] = t;
                    temp= num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }
            }
        }
    }


    private static void BubbleSortDsc(String[] array,int[] num)
    {
        String t;
        int temp;
        for(int i=0; i<array.length; i++) {
            for(int j=0; j<array.length-1-i; j++) {
                if(array[j].compareTo(array[j+1])<0) {
                    t= array[j];
                    array[j] = array[j+1];
                    array[j+1] = t;
                    temp= num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }
            }
        }
    }
    public void onToggleClicked(View view)
    {
        // Is the toggle on?
        boolean on = ((ToggleButton) view).isChecked();

        if (on)
        {
            BubbleSortAsc(Contacts,img);
            ListAdapter JsAdapter=new CustomAdapter(MainActivity.this,Contacts,img);
            listView=(ListView) findViewById(R.id.listView);
            listView.setAdapter(JsAdapter);
        }
        else
        {
            BubbleSortDsc(Contacts,img);
            ListAdapter JsAdapter=new CustomAdapter(MainActivity.this,Contacts,img);
            listView=(ListView) findViewById(R.id.listView);
            listView.setAdapter(JsAdapter);
        }
    }


    public void LinearSearch(String[] array)
    {
        t=(EditText)findViewById(R.id.editText);
        String input=t.getText().toString();
        int flag=0;

        for(int i=0;i<array.length;i++)
        {

            if(input.compareTo(array[i])==0)
            {
                Toast.makeText(MainActivity.this,"Contact found: "+array[i], Toast.LENGTH_LONG).show();
                flag=1;
            }

        }

        if(flag==0)
        {
            Toast.makeText(MainActivity.this, "Missing", Toast.LENGTH_LONG).show();
        }

    }


    public void Search(View v)
    {
        LinearSearch(Contacts);
    }


}
