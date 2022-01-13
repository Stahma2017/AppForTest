package com.stas.textwathcer;

import android.text.Editable;
import android.util.Log;
import android.widget.EditText;

public class PhoneEditWatcher extends MaskedEditTextWatcher {

    private EditText phone;
    private boolean isMarked = false;
    private String beforeText = "";

    public PhoneEditWatcher(EditText phone) {
        super(phone, mask -> "+7 (###) ###-##-##");
        this.phone = phone;
        this.phone.addTextChangedListener(this);
        this.phone.setText("+7");
    }

    public String getText(boolean mask) {
        return mask ? this.phone.getText().toString()
                : this.phone.getText().toString().replaceAll("\\D", "");
    }

    public int getTextLength(boolean mask) {
        return mask ? this.phone.length()
                : this.phone.getText().toString().replaceAll("\\D", "").length();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Log.d("TEST_4", "beforeTextChanged(), s = " + s + ", phone.getText() = " + phone.getText());
        super.beforeTextChanged(s, start, count, after);
        beforeText = s.toString();
        Log.d("TEST_1", "s -> " + s + ", start = " + start + ", count = " + count + ", isMarked = " + isMarked);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s.toString().equals(beforeText)) return;
        Log.d("TEST_4", "onTextChanged(), s -> " + s + ", phone.getText() = " + phone.getText());
        Log.d("TEST_5", "s -> " + s + ", start = " + start + ", before = " + before + ", count = " + count + ", isMarked = " + isMarked);

        if (isMarked && start == 1) {
            String result = beforeText.substring(0, 4) + s.toString().substring(start, start + count) + beforeText.substring(4);
            Log.d("TEST_5", "result = " + result);
            phone.setText(result);
            phone.setSelection(result.length());
            return;
        }
        super.onTextChanged(s, start, before, count);
        isMarked = phone.getText().toString().startsWith("+7 (");
        if (!isMarked) {
            addCountryCode();
        }

        Log.d("TEST_2", "s -> " + s);
        Log.d("TEST_4", "onTextChanged(), s -> " + s + ", phone.getText() = " + phone.getText());
        /*if (getTextLength(true) < 4) {
            addCountryCode();
        }*/

    }

    @Override
    public void afterTextChanged(Editable s) {
        //Log.d("TEST_4", "afterTextChanged(), s -> " + s + ", phone.getText() = " + phone.getText());
        super.afterTextChanged(s);
        //isMarked = phone.getText().toString().startsWith("+7 (");
        Log.d("TEST_3", "s -> " + s);


        /*if (getTextLength(true) < 4) {
            addCountryCode();
        }
        if (getTextLength(true) < 4) {
            addCountryCode();
        }*/
    }

    private void addCountryCode() {
        this.phone.setText("+7 (");
        this.phone.setSelection(this.phone.getText().toString().length());
    }
}
