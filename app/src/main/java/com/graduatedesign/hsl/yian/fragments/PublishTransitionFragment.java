package com.graduatedesign.hsl.yian.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.graduatedesign.hsl.yian.R;

import in.srain.cube.image.CubeImageView;

/**
 * Created by Mesogene on 3/30/16.
 */
public class PublishTransitionFragment extends Fragment implements AdapterView.OnItemClickListener{
    private static final String TAG = "PublishTransitionFragment";
    private PublishAdapter mPublishAdapter;
    public static PublishTransitionFragment newInstance(){
        return new PublishTransitionFragment();
    }
    public  PublishTransitionFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        mPublishAdapter = new PublishAdapter(inflater, R.layout.item_publish_list);
        return inflater.inflate(R.layout.fragment_publish_list,container,false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ListView list = (ListView) view.findViewById(android.R.id.list);
        list.setAdapter(mPublishAdapter);
        list.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


    }
    class PublishAdapter extends BaseAdapter {

        private final LayoutInflater mLayoutInflater;
        private final int mResourceId;

        public PublishAdapter(LayoutInflater inflater, int resourceId) {
            mLayoutInflater = inflater;
            mResourceId = resourceId;
        }

        @Override
        public int getCount() {
            return Meat.MEATS.length;
        }

        @Override
        public Meat getItem(int position) {
            return Meat.MEATS[position];
        }

        @Override
        public long getItemId(int position) {
            return Meat.MEATS[position].resourceId;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final View view;
            final ViewHolder holder;
            if (null == convertView) {
                view = mLayoutInflater.inflate(mResourceId, parent, false);
                holder = new ViewHolder();
                assert view != null;
                holder.mImageview = (CubeImageView)view.findViewById(R.id.chinese_medicine_image);
                holder.image = (ImageView) view.findViewById(R.id.turn_right);
                holder.title = (TextView) view.findViewById(R.id.chinese_medicine_title);
                view.setTag(holder);
            } else {
                view = convertView;
                holder = (ViewHolder) view.getTag();
            }
            bindView(holder, position);
            return view;
        }

        public void bindView(ViewHolder holder, int position) {
            Meat meat = getItem(position);

            holder.title.setText(meat.title);
        }

        class ViewHolder {
            public CubeImageView mImageview;
            public ImageView image;
            public TextView title;
        }
    }
}
