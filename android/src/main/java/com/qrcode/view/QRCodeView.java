package com.qrcode.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.util.Objects;

public class QRCodeView extends View {
    private String value;
    private String backgroundColor;

    public QRCodeView(Context context) {
        super(context);
    }

    public QRCodeView(Context context, AttributeSet attributeset) {
        super(context, attributeset);
    }

    public QRCodeView(Context context, AttributeSet attributeset, int defStyleAttr) {
        super(context, attributeset, defStyleAttr);
    }

    public void setValue(String value) {
        if (!Objects.equals(this.value, value)) {
            this.value = value;
            invalidate();
        }
    }

    public void setBackgroundColor(String backgroundColor) {
        if (!Objects.equals(this.backgroundColor, backgroundColor)) {
            this.backgroundColor = backgroundColor;
            invalidate();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (value == null) {
            super.onDraw(canvas);
            return;
        }
        generateQRCodeBitmap(canvas);
    }

    private void generateQRCodeBitmap(Canvas canvas) {
        QRCodeWriter writer = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = writer.encode(value, BarcodeFormat.QR_CODE, canvas.getWidth(), canvas.getWidth());
            Bitmap bmp = Bitmap.createBitmap(bitMatrix.getWidth(), bitMatrix.getHeight(), Bitmap.Config.RGB_565);
            int backgroundColor = this.backgroundColor != null ? Color.parseColor(this.backgroundColor) : Color.WHITE;
            for (int x = 0; x < canvas.getWidth(); x++) {
                for (int y = 0; y < canvas.getWidth(); y++) {
                    bmp.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : backgroundColor);
                }
            }
            bmp.setDensity(0);
            canvas.drawBitmap(bmp, 0, 0, null);
        } catch (WriterException e) {
            Log.e("QRCodeGenerator", "Error : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
