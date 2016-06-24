package com.example.mac.whoseturntopay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mac on 6/12/2016.
 */
public class LogItemAdapter extends ArrayAdapter<LogItem> {

    private ArrayList<LogItem> _logs;
    Context _context;
    public LogItemAdapter(Context context, int textViewResourceId, ArrayList<LogItem> logs) {
        super(context, textViewResourceId, logs);
        this._logs = logs;
        this._context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_item, parent, false);
    }
        LogItem log = _logs.get(position);
        if (log != null) {
            TextView restaurant = (TextView) v.findViewById(R.id.restaurant_list);
            TextView amount = (TextView) v.findViewById(R.id.amount_list);
            TextView date = (TextView) v.findViewById(R.id.date_list);
            ImageView whoPaid = (ImageView) v.findViewById(R.id.avatar);
            if (restaurant != null) {
                restaurant.setText(log.restaurant);
            }
            if(amount != null) {
                amount.setText(log.amount);
            }
            if (date != null) {
                date.setText(log.date);
            }
            if (whoPaid != null)
            {
                if (log.whoPaid.startsWith("Mahmoud"))
                    whoPaid.setImageResource(R.drawable.icon_m);
                else if (log.whoPaid.startsWith("Omar"))
                    whoPaid.setImageResource(R.drawable.icon_o);
                else
                    whoPaid.setImageResource(R.drawable.icon_mo);
            }
        }
        return v;
    }
}
