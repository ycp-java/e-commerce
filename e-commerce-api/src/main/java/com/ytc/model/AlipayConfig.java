package com.ytc.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class AlipayConfig implements Serializable {

    private static final long serialVersionUID = 7903728454546159876L;
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016102500759456";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCKKR0lXomof80X5qxNKjmD0kC+YTbClFPAizND9FsSO0qkRDg65a9XriAB74PUnBzG7vGlWLxQUEJBdIC27TkJkcNxGgnMgnEfabcoFKNmfxmkFefpljhkqzGqW7+trL/zLTg7L1l5MyjyR+tIxDIdTfGL1UghJG0b1ClsHAQv+Ys8yNt4JfsY38iZsApViapkyV8y3ICs+btxn3KX6tl2sx75QNN4iFbAOEwpQovIh5LoAWdyLX2RjrVImxT6TC1w31w5kSf5zsfY5h6rV/U5WmMacNlw5KSBRX1/++pvNZDzqdf+nh9B74cKNpqvCeFuohXGQGgDZzeOXLpUHdn7AgMBAAECggEAGTWDQexMBdi73V6TlcjckbbtZU9rpHlYBsvfYMjXTS5QYkSoVebO5Zq58GB5l3OctJeos9jLE4RxcmwFiFskiyBzntF3dD9g0LCDYObTIcKTNSNiG3bzdzrdZw4ynUfmBkL7/aCYHMs+72Y8Ahz6X+p25mLWNGXnGqrNnBJImVAUMFEs2/vf2IWWN0ehlYbr8sb4pCq0G3QFKx/ZiPDjjmbdBT28vlx7Io0LaArYCN6R9yZ0lcv2IuQByZIuMrjSgtp/p7p0+BWQRQgpZ3DEVIbvVDtUTYUfUz2N90e2XFuIVxF6FiA7jOvY5njH1KS2UTd26CG+kmjiYDnIdheCwQKBgQDOYyKDx9wpy0/YofGn3SgkvlN1XIn2znJJHS8fdW1qomYf5hOdidqoI0gGrz1TGvV2QnMOt9TQYUOkIzrDfoRlcmqM8/YHf2rVO/2Yde9ESNV0JJj6Va9uQsxHMuyJov3G/z4fyvoJZw4Jj1TFxkMMgTmj1RVH52j3k6HAZthZ0QKBgQCrX2EgN2bO2pyuT7wjwxW/gHZwjnKPN8x/EI2C8aCTHC5EOKrrmco1a5E4ORrtf5KmkJEipS7ujR3LnvnSCs79pmdlrnYTXVlzOJR3USaAcYqLpNH+g/MK0gAZ5VKQn05ArBCUzQu1UmUGvjJR/RpYoe1YTblN1Ydf2p1VIPOeCwKBgB4C+G/lTjSdpfzAf92DIWVGb+hvDnjfSGstXT7b2o9ZEjStRkjwVOWCS+T88pP1JaCOxSBsxvuOSUHDBbaL3UDLRIc+qpYohyZ+1L+o1qQ9WxzKfZxZfWsxN3dbBl51XyXi0+vXnkhjvfzR5OfljrZwzCrwv2l3UyI9S5Yo3mkhAoGAMVcryq/IzOPKWrGgVJeVimZ9M1kACNYi7a6hX8Mb3V8uvvul0mGcA5dt30cpxpmFaqmS7+upQIumuXqTKPNtt0AS4wbA/kBRQchXjqbxs+d84UnaIDJzZnkiCFKrW/JSAHLJ71298j2/0pouOMbrr/snL9Zo9Mz2xhVWWS08lxMCgYEAweXmN+HxUXrsIV4xRSgYb5xa500cpZgr5HZtLMR4OjUIogq5Y5qlxQNf7ByExxgG48i4FIK/ZhCB7hseDHCXjjXIWqWpEDTBrGbDFJCXZRei1dEC+UbsOG5hWFRitDKC7g4xVg1kWb7PKRevDWzU6efuElqOredFIdjhc8+6Xqw=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。

    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuH8vik/kOKN/4BuINVSIci8v5a2t3TN8kUMo71iUhSQshm+QZhJ8C5VEN5GS3Urd58VKP56khkCBeR+NLMCExQFni4CIbprxoM4VvGf5ELI+Zhznq7F1rQxyhQoUFNY1mERkRZsJNEmGujJp26RRvYz2t1Xtff1nSFnMZyj/SlhRVP2L5bgJj7F2KGjGHliOQ+XTSLpO2W2bd9zkmKL2r35rb694hlD1ej2aqVDJncnbMPEChc2iA0PR/1/H5UkHrWNoxeGr/rWhaAn34OHwe9UD2oII6Q53duo3Z97xCpIZU3yTe/HWuf9od1J5OlcVOhGEiM4gkcwfK/fA7Q1k2QIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://kyd.free.idcfengye.com/notify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://kyd.free.idcfengye.com/returnUrl";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "D:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
