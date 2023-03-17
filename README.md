# react-native-id-qrcodeview
native view to generate and display qrcodes in native side (No needs for SVG)

#### Result
The following screen is an example of library implementation.

![Command Line Tools](doc/images/QrCode.png)

## Installation

```sh
npm install react-native-id-qrcodeview
```

```sh
yarn add react-native-id-qrcodeview
```
This library support auto-linking no extra step are required.

## Usage

```js
import { QRCodeView } from "react-native-id-qrcodeview";

    <QRCodeView
        qrCodeValue={qrCodeValue}
        backgroundColor={'#F5F7FB'}
        style={{width: 180, height: 180}}
        key="QrCodeView"
    />
```

You can check the example available withing the Repo for using.

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

Looking for help to support Fabric.

## License

MIT
