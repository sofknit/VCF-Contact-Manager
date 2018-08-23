package com.firefinch.vcfcontact.fragments.VFile;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firefinch.vcfcontact.R;
import com.firefinch.vcfcontact.Utils.Util;
import com.firefinch.vcfcontact.fragments.VFile.dummy.DummyContent;
import com.firefinch.vcfcontact.fragments.VFile.dummy.DummyContent.DummyItem;
import com.firefinch.vcfcontact.models.VFile;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnVFileListFragmentInteractionListener}
 * interface.
 */
public class VFileFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnVFileListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public VFileFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static VFileFragment newInstance(int columnCount) {
        VFileFragment fragment = new VFileFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @SuppressWarnings("unused")
    public static VFileFragment newInstance() {
        return newInstance(1);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vfile_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            //TODO: https://stackoverflow.com/questions/21724706/how-to-get-my-android-device-internal-download-folder-path
            //      Implement for external storage as well
            recyclerView.setAdapter(
                    new VFileAdapter(new ArrayList<VFile>(Arrays.asList(new VFile(Environment.getExternalStorageDirectory(), "test_vcf.vcf"))), mListener)
            );
//            For Complete Search, use this:
//            recyclerView.setAdapter(
//                    new VFileAdapter(Util.walkVFiles(Environment.getExternalStorageDirectory()), mListener)
//            );
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnVFileListFragmentInteractionListener) {
            mListener = (OnVFileListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other fragments</a> for more information.
     */
    public interface OnVFileListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}
