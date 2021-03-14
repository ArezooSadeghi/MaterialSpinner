package com.example.materialspinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.materialspinner.databinding.ItemBinding;

import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestHolder> {
    private Context mContext;
    private List<String> mList;
    private int mLastSelectedPosition = -1;

    public TestAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public TestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TestHolder(DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.item,
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull TestHolder holder, int position) {
        holder.bind(mList.get(position));
        holder.mBinding.radioButton.setChecked(mLastSelectedPosition == position);
        holder.mBinding.radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLastSelectedPosition = position;
                notifyDataSetChanged();
                Toast.makeText(mContext, mLastSelectedPosition + "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class TestHolder extends RecyclerView.ViewHolder {
        private ItemBinding mBinding;

        public TestHolder(ItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bind(String str) {
            mBinding.txt.setText(str);
        }
    }
}
