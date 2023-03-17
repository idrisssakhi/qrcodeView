import React, {
  requireNativeComponent,
  Platform,
  ViewProps,
} from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-id-qrcodeview' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo managed workflow\n';

interface QRCodeProps extends ViewProps {
  qrCodeValue: string;
  backgroundColor?: string;
}

const QRCodeView = ({
  qrCodeValue,
  backgroundColor,
  ...restProps
}: QRCodeProps) => {
  if (qrCodeValue === '') {
    throw new Error('value is required to generate QRCode');
  }

  return (
    <NativeQRCodeView
      qrCodeValue={qrCodeValue.trim()}
      backgroundColor={backgroundColor}
      style={[restProps?.style]}
      {...restProps}
    />
  );
};

const NativeQRCodeView = requireNativeComponent<QRCodeProps>('QRCodeView');

if (NativeQRCodeView === null) {
  throw new Error(LINKING_ERROR);
}

export default QRCodeView;
