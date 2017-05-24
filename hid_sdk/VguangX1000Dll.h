
// The following ifdef block is the standard way of creating macros which make exporting 
// from a DLL simpler. All files within this DLL are compiled with the VGUANGX1000DLL_EXPORTS
// symbol defined on the command line. this symbol should not be defined on any project
// that uses this DLL. This way any other project whose source files include this file see 
// VGUANGX1000DLL_API functions as being imported from a DLL, wheras this DLL sees symbols
// defined with this macro as being exported.
#ifdef VGUANGX1000DLL_EXPORTS
#define VGUANGX1000DLL_API __declspec(dllexport)
#else
#define VGUANGX1000DLL_API __declspec(dllimport)
#endif

//连接设备,返回值>=0成功，<0失败
VGUANGX1000DLL_API int __stdcall connectDevice(void);
//断开设备,返回值>=0成功，<0失败
VGUANGX1000DLL_API int __stdcall disconnectDevice(void);
//设置码制，返回值>=0成功，<0失败; 
//         参数barcodeFormat：0-无，1-QR, 2-DM, 4-一维码, 
//                             3-QR&DM, 5-QR&一维码, 6-DM&一维码, 
//                             7-QR&DM&一维码
VGUANGX1000DLL_API int __stdcall setBarcodeFormat(int barcodeFormat);
//得到扫码或NFC信息，返回值>=0成功，<0失败; 
//            参数result-信息内容字符串；
//            参数length-信息内容长度；
//            参数maxlen-信息内容最大长度；
//            参数timeout-超时时间，单位秒,0~65535,缺省为5
VGUANGX1000DLL_API int __stdcall getResultStr(char *result, int *length, int maxlen, int timeout);
//开灯，返回值>=0成功，<0失败;
VGUANGX1000DLL_API int __stdcall lightOn(void);
//关灯，返回值>=0成功，<0失败;
VGUANGX1000DLL_API int __stdcall lightOff(void);
//得到设备版本号，返回值>=0成功，<0失败;
//            参数result-信息内容字符串；
//            参数length-信息内容长度；
VGUANGX1000DLL_API int __stdcall getDeviceVer(char *result, int *length);
