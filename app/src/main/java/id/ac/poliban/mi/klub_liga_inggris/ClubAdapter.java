package id.ac.poliban.mi.klub_liga_inggris;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class ClubAdapter extends BaseAdapter {
    private List<Club> data = new ArrayList<>();

    public ClubAdapter(List<Club> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView img_klub;
        TextView tvKlubName;
        TextView tvKlubDesc;

        convertView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_klub, parent, false);

        img_klub = convertView.findViewById(R.id.img_klub);
        tvKlubName = convertView.findViewById(R.id.tv_klub_name);
        tvKlubDesc = convertView.findViewById(R.id.tv_klub_description);

        Glide.with(parent.getContext())
                .load(data.get(position).getClub())
                .apply(new RequestOptions().override(60, 60))
                .into(img_klub);
        tvKlubName.setText(data.get(position).getClubName());
        tvKlubDesc.setText(data.get(position).getClubDesc());

        return convertView;
    }
}

