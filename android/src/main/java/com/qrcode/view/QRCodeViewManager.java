package com.qrcode.view;

import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

public class QRCodeViewManager extends SimpleViewManager<QRCodeView> {
    public static final String REACT_CLASS = "QRCodeView";

    private final @Nullable
    ReactApplicationContext mCallerContext;

    public QRCodeViewManager(@Nullable ReactApplicationContext mCallerContext) {
        this.mCallerContext = mCallerContext;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected QRCodeView createViewInstance(ThemedReactContext reactContext) {
        return new QRCodeView(reactContext, mCallerContext);
    }


    @ReactProp(name = "qrCodeValue")
    public void setQrCodeValue(QRCodeView view, @Nullable String value) {
        view.setValue(value);
    }

    @ReactProp(name = "size", defaultInt = 200)
    public void setSize(QRCodeView view, @Nullable Integer size) {
        view.setSize(size);
    }
}
