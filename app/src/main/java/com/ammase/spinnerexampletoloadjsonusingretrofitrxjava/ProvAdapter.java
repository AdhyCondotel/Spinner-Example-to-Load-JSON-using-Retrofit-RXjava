package com.ammase.spinnerexampletoloadjsonusingretrofitrxjava;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ammase.spinnerexampletoloadjsonusingretrofitrxjava.model.DataItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ammase on 13/08/17.
 */

class ProvAdapter extends ArrayAdapter<DataItem> {
        private Context context;
        private int resource;
        LayoutInflater inflater;
        List<DataItem> list = new ArrayList<>();

        public ProvAdapter(@NonNull Context context, @LayoutRes int resource, List<DataItem> object) {
            super(context, resource, object);
            this.context  =context;
            this.resource = resource;
            this.list  =object;

        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view = convertView;
            ViewHolder holder ;
            if(view==null){
                holder = new ViewHolder();
                inflater = (LayoutInflater)  context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                view =  inflater.inflate(resource, parent, false);
                holder.txt = (TextView) view.findViewById(R.id.textView9);
                view.setTag(holder);
            } else holder = (ViewHolder) view.getTag();
            holder.txt.setText(list.get(position).getNama());
            return view;

        }
        @Override
        public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return getView(position, convertView, parent);
        }

        class ViewHolder{
            public TextView txt;
        }

}
