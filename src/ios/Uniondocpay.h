#import <Cordova/CDVPlugin.h>

@interface Uniondocpay : CDVPlugin

@property (nonatomic, strong) NSString *currentCallbackId;

- (void)pay:(CDVInvokedUrlCommand *)command;

@end
