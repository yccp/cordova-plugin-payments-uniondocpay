#import "Uniondocpay.h"
#import "UMSPPPayUnifyPayPlugin.h"

@implementation Uniondocpay
- (void)pluginInitialize
{
}

- (void)pay:(CDVInvokedUrlCommand *)command
{
    // check arguments
    NSDictionary *params = [command.arguments objectAtIndex:0];
    if (!params)
    {
        [self.commandDelegate sendPluginResult:[CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:@"参数格式错误"] callbackId:command.callbackId];
        return ;
    }
    
    NSString* channel = params[@"channel"];
    NSString* string = params[@"string"];
    // start payment
    if ([channel isEqualToString:@"Alipay"]) {
        [UMSPPPayUnifyPayPlugin payWithPayChannel:CHANNEL_ALIPAY
                                          payData:params[@"string"]
                                    callbackBlock:^(NSString *resultCode, NSString *resultInfo) {
                                        NSLog(@"%@ %@", resultCode, resultInfo);
                                        [self.commandDelegate sendPluginResult:[CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsDictionary:@{
                                                                                                                                                           @"resultCode": resultCode,
                                                                                                                                                           @"resultInfo": resultInfo
                                                                                                                                                           }] callbackId:command.callbackId];
                                    }];
        return;
    }
}

@end
