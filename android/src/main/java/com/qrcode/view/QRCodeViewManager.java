package com.qrcode.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

public class QRCodeViewManager extends SimpleViewManager<QRCodeView> {
    private static final String REACT_CLASS = "QRCodeView";

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @NonNull
    @Override
    protected QRCodeView createViewInstance(@NonNull ThemedReactContext reactContext) {
        return new QRCodeView(reactContext);
    }

    @ReactProp(name = "qrCodeValue")
    public void setQrCodeValue(QRCodeView view, @Nullable String value) {
        view.setValue(value);
    }

    @ReactProp(name = "backgroundColor")
    public void setBackgroundColor(QRCodeView view, @Nullable String backgroundColor) {
        view.setBackgroundColor(backgroundColor);
    }
}
