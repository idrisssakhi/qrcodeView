#import <React/RCTViewManager.h>
#import "QRCodeView.h"

@interface QRCodeViewManager : RCTViewManager
@end

@implementation QRCodeViewManager

RCT_EXPORT_MODULE(QRCodeView)

- (UIView *)view
{
    return [[QRCodeView alloc] init];
}

+ (BOOL)requiresMainQueueSetup {
    return YES;
}

RCT_EXPORT_VIEW_PROPERTY(qrCodeValue, NSString);

@end
