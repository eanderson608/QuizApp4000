package com.example.patron.quizapp4000;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;



/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TextPlayFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TextPlayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TextPlayFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String text;
    private String mParam2;

    private Button submitButton;
    private RadioGroup radGroup;
    private RadioButton radButton;

    private int numCorrect = 0;

    private OnFragmentInteractionListener mListener;

    public TextPlayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TextPlayFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TextPlayFragment newInstance(String param1, String param2) {
        TextPlayFragment fragment = new TextPlayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            text = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = null;
        view = inflater.inflate(R.layout.fragment_text_play, container, false);

        submitButton = (Button) view.findViewById(R.id.get_results_button);
        radGroup = (RadioGroup) view.findViewById(R.id.radio_choice);

        return view;
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        //different way of implementing click interaction.
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = radGroup.getCheckedRadioButtonId();
                radButton = (RadioButton) view.findViewById(selectedId);

                if (text.equals("dog")) {
                    numCorrect++;
                }
                if (radButton.getText().equals("all of the above")) {
                    numCorrect++;
                }

                displayResults(numCorrect);
            }
        });
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void displayResults(int numCorrect){

        //TODO finish implementing this AlertDialog

        // display results
        new AlertDialog.Builder(getActivity())
                .setCancelable(false)
                .setTitle("Number Correct:")
                .setMessage(String.valueOf(numCorrect))
                .setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // go back to first question
                        getFragmentManager()
                                .beginTransaction()
                                .replace(R.id.main_fragment_container, ImagePlayFragment.newInstance(null, null))
                                .addToBackStack(null)
                                .commit();
                    }
                })
                .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //exit
                        System.exit(0);
                    }
                })
                .show();

    }
}
