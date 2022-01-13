package com.stas.custom;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

public class TopCropImageView extends AppCompatImageView {

    public TopCropImageView(Context context) {
        super(context);
        setScaleType(ScaleType.MATRIX);
    }

    public TopCropImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setScaleType(ScaleType.MATRIX);
    }

    public TopCropImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setScaleType(ScaleType.MATRIX);
    }

    @Override
    protected boolean setFrame(int l, int t, int r, int b) {
        if (getScaleType() != ScaleType.MATRIX || getDrawable() == null) {
            return super.setFrame(l, t, r, b);
        }

        final Matrix matrix = getImageMatrix();

        float scale;
        final int viewWidth = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
        final int viewHeight = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
        final int drawableWidth = getDrawable().getIntrinsicWidth();
        final int drawableHeight = getDrawable().getIntrinsicHeight();

        if (drawableWidth * viewHeight > drawableHeight * viewWidth) {
            scale = (float) viewHeight / (float) drawableHeight;
        } else {
            scale = (float) viewWidth / (float) drawableWidth;
        }

        matrix.setScale(scale, scale);
        matrix.postTranslate((viewWidth - (int) (drawableWidth * scale)) / 2, 0);
        setImageMatrix(matrix);

        return super.setFrame(l, t, r, b);
    }
}
