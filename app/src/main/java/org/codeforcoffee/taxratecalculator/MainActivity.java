package org.codeforcoffee.taxratecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private static final NumberFormat CURRENCY_FORMAT = NumberFormat.getCurrencyInstance();
    private static final NumberFormat PERCENT_FORMAT = NumberFormat.getPercentInstance();

    private double mBillAmount = 0.0;
    private double mPercent = 0.10;
    private TextView mAmountTextView;
    private TextView mPercentTextView;
    private TextView mTaxDueTextview;
    private TextView mTotalTextview;
    private EditText mAmountEditText;
    private SeekBar mPercentSeekBar;

    private void calculate() {
        mPercentTextView.setText(PERCENT_FORMAT.format(mPercent));

        double tax = mBillAmount * mPercent;
        double total = mBillAmount + tax;

        mTaxDueTextview.setText(CURRENCY_FORMAT.format(tax));
        mTotalTextview.setText(CURRENCY_FORMAT.format(total));
    }

    private SeekBar.OnSeekBarChangeListener seekBarListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            mPercent = progress / 100.0;
            calculate();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {}

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {}
    };

    private TextWatcher amountEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                mBillAmount = Double.parseDouble(s.toString()) / 100.0;
                mAmountTextView.setText(CURRENCY_FORMAT.format(mBillAmount));
            } catch (NumberFormatException ex) {
                mAmountTextView.setText("");
                mBillAmount = 0.0;
            }
            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) {}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAmountTextView = (TextView) findViewById(R.id.amountTextView);
        mPercentTextView = (TextView) findViewById(R.id.percentTextView);
        mTaxDueTextview = (TextView) findViewById(R.id.taxDueTextView);
        mTotalTextview = (TextView) findViewById(R.id.totalTextView);

        mTaxDueTextview.setText(CURRENCY_FORMAT.format(0));
        mTotalTextview.setText(CURRENCY_FORMAT.format(0));

        mAmountEditText = (EditText) findViewById(R.id.amountEditText);
        mAmountEditText.addTextChangedListener(amountEditTextWatcher);
        mPercentSeekBar = (SeekBar) findViewById(R.id.percentSeekBar);
        mPercentSeekBar.setOnSeekBarChangeListener(seekBarListener);


    }
}
