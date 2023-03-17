import React from 'react';
import { ViewProps, requireNativeComponent } from 'react-native';

export interface QRCodeProps extends ViewProps {
  qrCodeValue: string;
  backgroundColor?: string;
}

export const QRCodeView = ({
  qrCodeValue,
  backgroundColor,
  ...restProps
}: QRCodeProps) => {
  if (qrCodeValue.trim() === '') {
    throw new Error('value is required to generate QRCode');
  }

  return (
    <NativeQRCodeView
      qrCodeValue={qrCodeValue}
      backgroundColor={backgroundColor}
      style={[restProps?.style]}
      {...restProps}
    />
  );
};

// requireNativeComponent automatically resolves 'QRCodeView' to 'QRCodeViewManager'
const NativeQRCodeView = requireNativeComponent<QRCodeProps>('QRCodeView');
