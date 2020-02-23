package by.nj.dusty;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static android.content.Context.VIBRATOR_SERVICE;


public class FragmentOne extends Fragment {
    private TextView TResult, TextDx, TWeigth;
    private EditText EKanv, EbeforeDx, EafterDx, EWeigth;
    private View view;
    private Button Bresult;
    private Spinner spinnerRs;
    private Vibrator vibrator;
    private FloatingActionButton floatingActionButton;

    public FragmentOne() {

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_one, container, false);

        final String[] dx_ = getResources().getStringArray(R.array.dx);


        TResult = view.findViewById(R.id.TResult);
        EKanv = view.findViewById(R.id.Ekanv);
        EbeforeDx = view.findViewById(R.id.EbeforeDx);
        EafterDx = view.findViewById(R.id.EafterDx);
        Bresult = view.findViewById(R.id.Bresult);
        spinnerRs = view.findViewById(R.id.SpinnerRs);
        TextDx = view.findViewById(R.id.TextDx);
        TWeigth = view.findViewById(R.id.TWeigth);
        EWeigth = view.findViewById(R.id.EWeigth);
        floatingActionButton = view.findViewById(R.id.FloactionButton);


        vibrator = (Vibrator) view.getContext().getSystemService(VIBRATOR_SERVICE);


        Bresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                {
                    try {
                        float a = Float.parseFloat(EKanv.getText().toString());
                        float b = Float.parseFloat(EbeforeDx.getText().toString());
                        float c = Float.parseFloat(EafterDx.getText().toString());
                        float result = ((a * b) / c);
                        vibrator.vibrate(200);
                        TResult.setText(String.format("%(.1f", result));
//                        if (Build.VERSION.SDK_INT <= 26) {
//                        } else {
//                            vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
//                            Toast.makeText(view.getContext(), "~"+Build.VERSION.SDK_INT,Toast.LENGTH_LONG).show();
//
//                        }
                    } catch (Exception e) {
                        showTast();
                    }

                }
            }

            private void showTast() {
                LayoutInflater layoutInflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.layout_toast, (ViewGroup) view.findViewById(R.id.toast_root));
                Toast toast = new Toast(view.getContext());
                toast.setGravity(Gravity.BOTTOM, 0, 32);
//                toast.setDuration((int) 3000);
                toast.setView(layout);
                toast.show();
            }
        });

        EWeigth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    float x = Float.parseFloat(EWeigth.getText().toString());
                    x = x * 0.27f;
                    TWeigth.setText(String.format("%(.3f", x));
                } catch (Exception e) {
                    showTast();
                }

            }

            private void showTast() {
                LayoutInflater layoutInflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.layout_toast, (ViewGroup) view.findViewById(R.id.toast_root));
                Toast toast = new Toast(view.getContext());
                toast.setGravity(Gravity.BOTTOM, 0, 32);
//                toast.setDuration((int) 3000);
                toast.setView(layout);
                toast.show();
            }
        });


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.rs, R.layout.spinner_view);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRs.setAdapter(adapter);


        spinnerRs.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                TextDx.setText("Vdx: " + dx_[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext(), getString(R.string.in_future).toString(),Toast.LENGTH_LONG).show();
//                startActivity(new Intent(view.getContext(), DataBaseActivity.class));
            }
        });

        return view;
    }

}