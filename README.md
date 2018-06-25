# 银联全民付 cordova 插件

> 支持ios, android

## 通道
- 支付定支付(Alipay)
- 微信支付(Wechatpay) (未支持)
- 全民付(Qmf) (未支持)
- 银联全渠道(Uac) (未支持)

## 安装

```
cordova plugin add cordova-plugin-payments-uniondocpay --save
```
或
```
ionic cordova plugin add cordova-plugin-payments-uniondocpay
```

> 相关依赖
[cordova-plugin-cocoapod-support](https://www.npmjs.com/package/cordova-plugin-cocoapod-support)
```
cordova plugin add cordova-plugin-cocoapod-support --save
```
或
```
ionic cordova plugin add cordova-plugin-cocoapod-support
```

## 使用方法
>打开支付页面
```js
window.Uniondocpay.pay({
  channel: 'Alipay', // 通道
  string: '{"msgType":"trade.precreate","connectSys":"ALIPAY","msgSrc":"WWW.TEST.COM","merName":"仲晶晶二维码测试","mid":"898340149000005","msgId":"3194","appPayRequest":{"qrCode":"https://qr.alipay.com/bax0254776flwtwg8l6w203d"},"settleRefId":"00255100548N","tid":"88880001","srcReserve":"test001","totalAmount":1,"qrCode":"https://qr.alipay.com/bax0254776flwtwg8l6w203d","targetMid":"2015061000120322","responseTimestamp":"2018-06-25 21:18:02","errCode":"SUCCESS","targetStatus":"10000","seqId":"00255100548N","merOrderId":"3194676990","status":"NEW_ORDER","targetSys":"Alipay 2.0","sign":"E880CB77904BEC754AA508DD16AD88B5"}',
}, () => {
  console.log('成功');
}, e => {
  console.error(e);
});

```

## IONIC Wrap
[https://github.com/yc-ionic/uniondocpay](https://github.com/yc-ionic/uniondocpay)

## 代码捐献

非常期待您的代码捐献。