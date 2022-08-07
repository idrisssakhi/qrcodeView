package com.qrcode.view;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.image.ReactImageView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCodeView extends ReactImageView {
    ReactApplicationContext callerContext;
    ThemedReactContext reactContext;

    private int size = 200;
    private String value;

    public QRCodeView(ThemedReactContext reactContext, ReactApplicationContext callerContext) {
        super(reactContext, Fresco.newDraweeControllerBuilder(), null, callerContext);
        this.callerContext = callerContext;
        this.reactContext = reactContext;
    }

    public void setSize(Integer size) {
        if (size != this.size) {
            this.size = size;
            this.setImageBitmap(generateQRCodeBitmap(this.value));
        }
    }

    public void setValue(String value) {
        if(this.value != value) {
            this.value = value;
            this.setImageBitmap(generateQRCodeBitmap(this.value));
        }
    }

    private Bitmap generateQRCodeBitmap(final String qrCodeValue) {
        QRCodeWriter writer = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = writer.encode(qrCodeValue, BarcodeFormat.QR_CODE, this.size, this.size);
            Bitmap bmp = Bitmap.createBitmap(this.size, this.size, Bitmap.Config.RGB_565);
            for (int x = 0; x < this.size; x++) {
                for (int y = 0; y < this.size; y++) {
                    bmp.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
                }
            }
            bmp.setDensity(0);
            return bmp;
        } catch (WriterException e) {
            Log.e("QRCodeGenerator", "Error : " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
