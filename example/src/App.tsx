import React, { useState } from 'react';

import {
  StyleSheet,
  View,
  Text,
  TextInput,
  TouchableOpacity,
} from 'react-native';

import QRCodeView from 'react-native-id-qrcodeview';

const App = () => {
  const [value, setValue] = useState('');
  const [qrCodeValue, setQrCodeValue] = useState<string>();

  const generateQrCode = () => {
    if (value !== '') {
      setQrCodeValue(value.trim());
    }
  };

  return (
    <View style={styles.container}>
      <Text>You can enter a value to generate qrCode</Text>
      <TextInput
        value={value}
        onChangeText={setValue}
        style={styles.inputStyle}
        placeholder={'value to generate'}
      />
      <TouchableOpacity onPress={generateQrCode} style={styles.generateButton}>
        <Text>Clic to generate</Text>
      </TouchableOpacity>
      {qrCodeValue && (
        <QRCodeView
          qrCodeValue={qrCodeValue}
          style={styles.box}
          key="QrCodeView"
          size={200}
        />
      )}
    </View>
  );
};

export default App;

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    padding: 24,
  },
  box: {
    width: 150,
    height: 150,
    marginVertical: 20,
  },
  inputStyle: {
    width: '90%',
    height: 40,
    borderWidth: 1,
    borderColor: 'grey',
    marginVertical: 12,
    borderRadius: 4,
    padding: 4,
  },
  generateButton: {
    backgroundColor: 'blue',
    marginVertical: 12,
    width: '90%',
    padding: 8,
    alignItems: 'center',
    borderRadius: 4,
  },
});
