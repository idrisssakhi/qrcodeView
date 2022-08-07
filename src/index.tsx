import React, {
  requireNativeComponent,
  Platform,
  ViewProps,
} from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-qrcodeview' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo managed workflow\n';

interface QRCodeProps extends ViewProps {
  qrCodeValue: string;
  size?: number;
}

const QRCodeView = ({ qrCodeValue, size, ...restProps }: QRCodeProps) => {
  if (qrCodeValue === '') {
    throw new Error('value is required to generate QRCode');
  }

  return (
    <NativeQRCodeView
      qrCodeValue={qrCodeValue}
      size={size}
      style={[restProps?.style, { backgroundColor: 'transparent' }]}
      {...restProps}
    />
  );
};

const ComponentName = 'QRCodeView';

const NativeQRCodeView = requireNativeComponent<QRCodeProps>(ComponentName);

if (NativeQRCodeView === null) {
  throw new Error(LINKING_ERROR);
}

export default QRCodeView;
