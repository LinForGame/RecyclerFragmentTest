package a20180324.recyclerfragmenttest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by WHY on 2018/3/24.
 */

public class xxxFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter mAdapter;
    private DataProvider mData;
    private static final String TAG = "---xxxFragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mData = new DataProvider();
        mData.initDataProvider(100);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView() called with: inflater = [" + inflater + "], container = [" + container + "], savedInstanceState = [" + savedInstanceState + "]");
        View view = inflater.inflate(R.layout.recycler_layout,container,false);
            mRecyclerView = view.findViewById(R.id.recycler_layout);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecyclerView.setAdapter(new MyRecyclerViewAdapter());


        return view;
    }

    private class MyRecyclerViewAdapter extends RecyclerView.Adapter{

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Log.e(TAG, "onCreateViewHolder() called with: parent = [" + parent + "], viewType = [" + viewType + "]");
            MyViewHolder v =new  MyViewHolder(LayoutInflater.from(getActivity()).inflate(R.layout.recycler_list_item,parent,false));
            return v;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Log.d(TAG, "onBindViewHolder() called with: holder = [" + holder + "], position = [" + position + "]");
            ((MyViewHolder)holder).mString.setText(mData.getData().get(position).get("String").toString());
            ((MyViewHolder)holder).mObject.setText(mData.getData().get(position).get("Object").toString());
        }

        @Override
        public int getItemCount() {
            Log.d(TAG, "getItemCount() called");
            return mData.size();
        }
    }
    private class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mString;
        private TextView mObject;
        public MyViewHolder(View itemView) {
            super(itemView);
            mString = itemView.findViewById(R.id.textView);
            mObject = itemView.findViewById(R.id.textView2);
        }

        @Override
        public void onClick(View v) {
            Log.d(TAG, "onClick() called with: v = [" + v + "]");

        }
    }

}
