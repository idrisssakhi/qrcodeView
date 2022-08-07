#import "QRCodeView.h"

@interface QRCodeView ()

@end

@implementation QRCodeView

- (instancetype)initWithFrame:(CGRect)frame
{
  if (self = [super initWithFrame:frame]) {
    CIImage *qrImage = [self createQRForString:self.qrCodeValue];
    self.image = [UIImage imageWithCIImage:qrImage
                                     scale:[UIScreen mainScreen].scale
                               orientation:UIImageOrientationUp];

    self.clipsToBounds = true;
  }

  return self;
}

- (void)setQrCodeValue:(NSString *)qrCodeValue
{
  if (qrCodeValue && ![self.qrCodeValue isEqualToString:qrCodeValue]) {
    _qrCodeValue = qrCodeValue;
    CIImage *qrImage = [self createQRForString:self.qrCodeValue];
    self.image = [UIImage imageWithCIImage:qrImage
                                     scale:[UIScreen mainScreen].scale
                               orientation:UIImageOrientationUp];

    self.clipsToBounds = true;
  }
}

- (CIImage *)createQRForString:(NSString *)qrString {
    NSData *stringData = [qrString dataUsingEncoding: NSUTF8StringEncoding];

    CIFilter *qrFilter = [CIFilter filterWithName:@"CIQRCodeGenerator"];
    [qrFilter setValue:stringData forKey:@"inputMessage"];
    [qrFilter setValue:@"H" forKey:@"inputCorrectionLevel"];

    return qrFilter.outputImage;
}

@end
