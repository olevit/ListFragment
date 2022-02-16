package com.example.listfragment;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class SingleListFragment extends ListFragment {
    final String[] catNames = new String[]{"Рижик",
            "Мурка", "Васька", "Томасина", "Христина", "Пушок", "Димок", "Кузя",
            "Кітті", "Масяня", "Сімба"};

   /* @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        MyListAdapter myListAdapter = new MyListAdapter(getActivity(),
                R.layout.listfragment_row, catNames);
        setListAdapter(myListAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.listfragment, null);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        TextView textView = (TextView) v;
        String itemText = textView.getText().toString();
        Toast.makeText(getActivity(), "Ви вибрали " + itemText, Toast.LENGTH_SHORT).show();
    }

    public class MyListAdapter extends ArrayAdapter<String>{
        private Context mContext;
        public MyListAdapter(Context context, int textViewResourceId,
                             String[] objects){
            super(context, textViewResourceId, objects);
            mContext = context;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.listfragment_row, parent,false);
            TextView catNameTextView =(TextView) row.findViewById(R.id.textViewName);
            catNameTextView.setText(catNames[position]);
            ImageView iconImageView =(ImageView) row.findViewById(R.id.imageViewIcon);
            iconImageView.setImageResource(R.drawable.ic_launcher_foreground);
            return row;

        }
    }*/
   @Override
   public void onActivityCreated(Bundle savedInstanceState) {
       super.onActivityCreated(savedInstanceState);

       ListAdapter adapter = new ArrayAdapter(getActivity(),
               android.R.layout.simple_list_item_multiple_choice, catNames);
       setListAdapter(adapter);
   }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.listfragment, null);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String prompt = "Вы вибрали: "
                + getListView().getItemAtPosition(position).toString() + "\n";

        prompt += "Вибрані елементи: \n";
        int count = getListView().getCount();
        SparseBooleanArray sparseBooleanArray = getListView()
                .getCheckedItemPositions();
        for (int i = 0; i < count; i++) {
            if (sparseBooleanArray.get(i)) {
                prompt += getListView().getItemAtPosition(i).toString() + "\n";
            }
        }
        Toast.makeText(getActivity(), prompt, Toast.LENGTH_LONG).show();
    }
}