package com.example.sasha.myapplication_currentcourses;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sasha.myapplication_currentcourses.model.Organizations;

import java.util.List;

/**
 * Created by sasha on 14.09.15.
 */
public class MyRecyclerBankAdapter extends RecyclerView.Adapter<MyRecyclerBankAdapter.MyViewHolder> {

    private Context mContext;
    private List<Organizations> mData;

    public MyRecyclerBankAdapter(Context _context, List<Organizations> _data) {
        mContext = _context;
        mData = _data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup _viewGroup, int _viewType) {
        final View itemView = LayoutInflater.from(mContext).inflate(R.layout.bank_info, _viewGroup, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        myViewHolder.onBind();
    }



    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView orgType;
        TextView title;
        TextView regionId;
        TextView cityId;
        TextView phone;
        TextView address;
        TextView link;

        public MyViewHolder(View itemView) {
            super(itemView);
            orgType = (TextView) itemView.findViewById(R.id.org_type);
            title = (TextView) itemView.findViewById(R.id.org_title);
            regionId = (TextView) itemView.findViewById(R.id.region_id);
            cityId = (TextView) itemView.findViewById(R.id.city_id);
            phone = (TextView) itemView.findViewById(R.id.phone);
            address = (TextView) itemView.findViewById(R.id.address);
            link = (TextView) itemView.findViewById(R.id.link);

        }

        public void onBind(){
            Organizations organizations = mData.get(getPosition());
            title.setText(organizations.getTitle());
            regionId.setText(organizations.getRegionId());
            cityId.setText(organizations.getCityId());
            phone.setText(organizations.getPhone());
            address.setText(organizations.getAddress());
            link.setText(organizations.getLink());
        }

    }
}
