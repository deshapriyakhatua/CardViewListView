package com.example.listviewcardview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] arr = new String[]{"30","20","40","30","20","10"};

        CustomAdapter adapter = new CustomAdapter(this,R.layout.card_view,arr);

        listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);


    }
    public class CustomAdapter extends ArrayAdapter<String>{


        public CustomAdapter(@NonNull Context context, int resource, @NonNull String[] objects) {
            super(context, resource, objects);
        }
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

            LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
            convertView = layoutInflater.inflate(R.layout.card_view, parent, false);

             String str = getItem(position);
             TextView tv = convertView.findViewById(R.id.textView);
             tv.setText(str+"% OFF");
             return convertView;
        }
    }
}

