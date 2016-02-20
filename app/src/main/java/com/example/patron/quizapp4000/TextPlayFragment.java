package com.example.patron.quizapp4000;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * Use the {@link TextPlayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TextPlayFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    private String text;

    private Button submitButton;
    private RadioGroup radGroup;
    private RadioButton radButton;

    private int numCorrect = 0;

    public TextPlayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment TextPlayFragment.
     */
    public static TextPlayFragment newInstance(String param1) {
        TextPlayFragment fragment = new TextPlayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            text = getArguments().getString(ARG_PARAM1);
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

    private void displayResults(int numCorrect){

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
                                .replace(R.id.main_fragment_container, ImagePlayFragment.newInstance())
                                .addToBackStack(null)
                                .commit();
                    }
                }).show();

    }
}
