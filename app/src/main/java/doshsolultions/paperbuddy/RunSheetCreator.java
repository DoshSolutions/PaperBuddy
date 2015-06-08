package doshsolultions.paperbuddy;

/**
 * Created by Dosh for ITC303 project.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RunSheetCreator extends ArrayAdapter<Customer> {
    Context cont;
    private static ArrayList<Customer> customerList;
    private LayoutInflater mInflater;

    public RunSheetCreator(Context context, int testViewResourceID, ArrayList<Customer> runsheet) {
        super(context, testViewResourceID);
        cont = context;
        //loadArrayData();
        mInflater = LayoutInflater.from(cont);
        customerList = runsheet;
    }
    public int getCount() {
        return customerList.size();
    }
    public Customer  getItem(int position) {
        return customerList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView (int pos, View convertView, final ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.custom_row_view, null);
            holder = new ViewHolder();
            holder.txtAddress = (TextView) convertView.findViewById(R.id.address);
            holder.txtCourier = (TextView) convertView.findViewById(R.id.courier);
            holder.txtAustralian = (TextView) convertView.findViewById(R.id.australian);
            holder.txtFin = (TextView) convertView.findViewById(R.id.finreview);
            holder.txtHerald = (TextView) convertView.findViewById(R.id.sydneyherald);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtAddress.setText(customerList.get(pos).getAddress());
        holder.txtCourier.setText(customerList.get(pos).getCourier());
        holder.txtAustralian.setText(customerList.get(pos).getAustralian());
        holder.txtFin.setText(customerList.get(pos).getFinreview());
        holder.txtHerald.setText(customerList.get(pos).getSydneyHerald());

        return convertView;
    }
    static class ViewHolder {
        TextView txtAddress;
        TextView txtCourier;
        TextView txtAustralian;
        TextView txtFin;
        TextView txtHerald;
    }

    }
