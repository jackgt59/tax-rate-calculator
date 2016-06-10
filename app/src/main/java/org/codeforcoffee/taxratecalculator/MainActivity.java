package org.codeforcoffee.taxratecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private static final NumberFormat CURRENCY_FORMAT = NumberFormat.getCurrencyInstance();
    private static final NumberFormat PERCENT_FORMAT = NumberFormat.getPercentInstance();

    private double mBillAmount = 0.0;
    private double percent = 0.0;
    private TextView mAmountTextView;
    private TextView mPercentTextView;
    private TextView mTaxDueTextview;
    private TextView mTotalTextview;
    private EditText mAmountEditText;
    private SeekBar mPercentSeekBar;

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
        //mAmountEditText.addTextChangedListener(amountEditTextWatcher);


    }
}
