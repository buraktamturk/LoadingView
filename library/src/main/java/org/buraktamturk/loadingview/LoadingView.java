package org.buraktamturk.loadingview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;

/**
 * Created by buraktamturk on 01/03/15.
 */
public class LoadingView extends ViewSwitcher {
    public static class InnerView extends LinearLayout {
        public InnerView(Context context) {
            super(context);
            setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            setOrientation(HORIZONTAL);
            LayoutInflater.from(context).inflate(R.layout.loadingview_layout, this, true);
        }

        public void setText(int stringResourceId) {
            ((TextView)findViewById(R.id.LoadingView_text)).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.LoadingView_text)).setText(stringResourceId);
        }

        public void setText(String loadingText) {
            if(loadingText == null) {
                ((TextView)findViewById(R.id.LoadingView_text)).setVisibility(View.GONE);
            } else {
                ((TextView)findViewById(R.id.LoadingView_text)).setVisibility(View.VISIBLE);
                ((TextView) findViewById(R.id.LoadingView_text)).setText(loadingText);
            }
        }
    }

    InnerView loadingView;
    boolean disloading;

    public LoadingView(Context context) {
        super(context);
        init(null);
    }

    public LoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        // we don't want the loading indicator appear while developing, right?
        if(!isInEditMode()) {
            loadingView = new InnerView(getContext());
            addView(loadingView);

            if(attrs != null) {
                LoadingConfiguration c = LoadingConfiguration.getDefault();
                TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.LoadingView, 0, 0);

                disloading = a.getBoolean(R.styleable.LoadingView_lv_loading, c.isLoading);

                int color = a.getColor(R.styleable.LoadingView_lv_color, c.textColor == null ? 0 : c.textColor);
                if(color != 0) {
                    ((TextView)loadingView.findViewById(R.id.LoadingView_text)).setTextColor(color);
                }

                String str = a.getString(R.styleable.LoadingView_lv_title);
                if(str == null)
                    str = c.resourceStringId != -1 ? getContext().getString(c.resourceStringId) : c.loading;

                setText(str);
            }
        }
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);

        if(getChildCount() == 2)
            setLoading(disloading);
    }

    public boolean getLoading() {
        return getCurrentView() == loadingView;
    }

    public void setLoading(boolean state) {
        if((getCurrentView() == loadingView) != state) {
            showNext();
        }
    }

    public void setText(int stringResourceId) {
        loadingView.setText(stringResourceId);
    }

    public void setText(String loadingText) {
        loadingView.setText(loadingText);
    }
}
