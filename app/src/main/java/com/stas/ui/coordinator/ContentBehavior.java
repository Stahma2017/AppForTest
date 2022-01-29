package com.stas.ui.coordinator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.appbar.AppBarLayout;

public class ContentBehavior extends AppBarLayout.ScrollingViewBehavior {
    private boolean transparentBar = false;
    private int navBarHeight;
    private int tabBarHeight;

    public ContentBehavior(boolean transparentBar, int navBarHeight, int tabBarHeight) {
        super();
        this.transparentBar = transparentBar;
        this.navBarHeight = navBarHeight;
        this.tabBarHeight = tabBarHeight;
    }

    public ContentBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return super.layoutDependsOn(parent, child, dependency);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        if (transparentBar) {
            float k = tabBarHeight / (float) navBarHeight;
            float trans = dependency.getBottom() * (k - 1) - tabBarHeight;
            setPadding(child, (int) (k * dependency.getBottom()));
            child.setTranslationY(trans);
            setMargins(child, 0);
        } else {
            setPadding(child, dependency.getBottom());
            child.setTranslationY(0);
            setMargins(child, tabBarHeight);
        }
        return super.onDependentViewChanged(parent, child, dependency);
    }

    private void setPadding(View child, int value) {
        child.setPadding(child.getPaddingLeft(), child.getPaddingTop(), child.getPaddingRight(),
                value);
    }

    private void setMargins(View child, int value) {
        ViewGroup.MarginLayoutParams l = (ViewGroup.MarginLayoutParams) child.getLayoutParams();
        l.setMargins(l.leftMargin, l.topMargin, l.rightMargin, value);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return true;
    }

    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, @NonNull int[] consumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type, consumed);
//        Logger.d("dxConsumed:" + dxConsumed + " dyConsumed:" + dyConsumed + " dxUnconsumed:" + dxUnconsumed + " dyUnconsumed:" + dyUnconsumed);
    }

    @Override
    public void onNestedScrollAccepted(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        super.onNestedScrollAccepted(coordinatorLayout, child, directTargetChild, target, axes, type);
    }

    @Override
    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, float velocityX, float velocityY, boolean consumed) {
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }
}
