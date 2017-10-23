package com.example.epoxypagingsample;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;

import com.airbnb.epoxy.ModelView;
import com.airbnb.epoxy.TextProp;

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
public class PagingView extends AppCompatTextView {

    public PagingView(Context context) {
        super(context);
    }

    @TextProp
    public void index(CharSequence index) {
        setText(index);
    }

}