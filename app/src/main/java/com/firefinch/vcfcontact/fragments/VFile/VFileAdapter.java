package com.firefinch.vcfcontact.fragments.VFile;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.firefinch.vcfcontact.fragments.VFile.dummy.DummyContent.DummyItem;
import com.firefinch.vcfcontact.R;
import com.firefinch.vcfcontact.models.VFile;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link VFileFragment.OnVFileListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class VFileAdapter extends RecyclerView.Adapter<VFileAdapter.ViewHolder> {

    private final List<VFile> mVFiles;
    private final VFileFragment.OnVFileListFragmentInteractionListener mListener;

    public VFileAdapter(List<VFile> items, VFileFragment.OnVFileListFragmentInteractionListener listener) {
        mVFiles = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_vfile, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
//        holder.mItem = mValues.get(position);
//        holder.mIdView.setText(mValues.get(position).id);
//        holder.mContentView.setText(mValues.get(position).content);

        holder.mIdView.setText(Integer.toString(position + 1));
        holder.mContentView.setText(mVFiles.get(position).getName());
//        holder.mView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (null != mListener) {
//                    // Notify the active callbacks interface (the activity, if the
//                    // fragment is attached to one) that an item has been selected.
//                    mListener.onListFragmentInteraction(holder.mItem);
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mVFiles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_number);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
