# LoadingView

LoadingView is easy to implement Loading indicators for your views or layouts. 

##Screenshots
![Image](https://raw.githubusercontent.com/buraktamturk/LoadingView/master/screenshots/sample.gif)
![Image](https://raw.githubusercontent.com/buraktamturk/LoadingView/master/screenshots/sample2.gif)

## Usage Sample

You can find sample application in sample folder. However i will mention them in there.

    <org.buraktamturk.loadingview.LoadingView
            android:id="@+id/loginLoadingView"
            app:lv_title="@string/signinin"
            app:lv_loading="false"
            android:layout_height="wrap_content"
            android:layout_width="match_parent">
        <LinearLayout  android:layout_width="match_parent"
            android:orientation="vertical"
            android:layout_height="match_parent">
            <EditText
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:hint="@string/email"
                />
            <EditText
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:hint="@string/password"
                />
            <Button
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:id="@+id/login"
                android:text="@string/signin"
                />
        </LinearLayout>
    </org.buraktamturk.loadingview.LoadingView>

*lv_title* is the text that shown on bottom of the loading indicator. *lv_loading* is the default state of the LoadingView, it's true by default. But don't worry loading indicator will not shown in editing mode.

    LoadingView view = (LoadingView)findViewById(R.id.loginLoadingView);
    // ...
    view.setLoading(true); // show loading indicator instead of layout.
    // ...
    view.setLoading(false); // hide loading indicator and show layout.

## How to change default behavior

Defaults are used when no LoadingConfiguration is configured and no attr defined in LoadingView (like lv_title). Don't worry, these configs will be used when no attr found on LoadingView.

    new LoadingConfiguration()
        .setLoadingText(R.string.loading)
        // or
        .setLoadingText("Loading")
        .setLoading(false) // you'll manually call setLoading(true) to LoadingView in order to show loading indicator.
        .setDefault() // make this configuration default

# The MIT License (MIT)

Copyright (c) 2015 Burak Tamtürk

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
