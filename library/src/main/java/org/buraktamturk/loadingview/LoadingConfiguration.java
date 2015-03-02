package org.buraktamturk.loadingview;

/**
 * Created by buraktamturk on 01/03/15.
 */
public class LoadingConfiguration {
    private static LoadingConfiguration def;

    public int drawable;
    public int resourceStringId;
    public String loading;
    public boolean isLoading;
    public Integer textColor;

    public LoadingConfiguration() {
        resourceStringId = drawable = -1;
        isLoading = true;
    }

    public LoadingConfiguration setLoadingText(int id) {
        resourceStringId = id;
        return this;
    }

    public LoadingConfiguration setLoadingText(String text) {
        resourceStringId = -1;
        loading = text;
        return this;
    }

    public LoadingConfiguration setTextColor(Integer color) {
        textColor = color;
        return this;
    }

    public LoadingConfiguration setLoading(boolean loading) {
        isLoading = loading;
        return this;
    }

    public LoadingConfiguration clearLoadingText() {
        setLoadingText(null);
        return this;
    }

    public static LoadingConfiguration getDefault() {
        if(def == null) {
            def = new LoadingConfiguration();
        }
        return def;
    }

    public LoadingConfiguration setDefault() {
        def = this;
        return this;
    }

    public void setDefault(LoadingConfiguration configuration) {
        def = configuration;
    }
}
