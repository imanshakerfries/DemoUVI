package sg.edu.rp.c346.id21014919.demouvi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class UVIAdapter extends ArrayAdapter<UVI> {

    Context parent_context;
    int layout_id;
    ArrayList<UVI> al;

    public UVIAdapter(Context context, int resource, ArrayList<UVI> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        al = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tv = rowView.findViewById(R.id.tv);
        ImageView iv = rowView.findViewById(R.id.iv);

        // Obtain the Android Version information based on the position
        UVI currentUVI = al.get(position);

        return rowView;

    }
}
