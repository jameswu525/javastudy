
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

//�����豸,����ֵ>=0�ɹ���<0ʧ��
VGUANGX1000DLL_API int __stdcall connectDevice(void);
//�Ͽ��豸,����ֵ>=0�ɹ���<0ʧ��
VGUANGX1000DLL_API int __stdcall disconnectDevice(void);
//�������ƣ�����ֵ>=0�ɹ���<0ʧ��; 
//         ����barcodeFormat��0-�ޣ�1-QR, 2-DM, 4-һά��, 
//                             3-QR&DM, 5-QR&һά��, 6-DM&һά��, 
//                             7-QR&DM&һά��
VGUANGX1000DLL_API int __stdcall setBarcodeFormat(int barcodeFormat);
//�õ�ɨ���NFC��Ϣ������ֵ>=0�ɹ���<0ʧ��; 
//            ����result-��Ϣ�����ַ�����
//            ����length-��Ϣ���ݳ��ȣ�
//            ����maxlen-��Ϣ������󳤶ȣ�
//            ����timeout-��ʱʱ�䣬��λ��,0~65535,ȱʡΪ5
VGUANGX1000DLL_API int __stdcall getResultStr(char *result, int *length, int maxlen, int timeout);
//���ƣ�����ֵ>=0�ɹ���<0ʧ��;
VGUANGX1000DLL_API int __stdcall lightOn(void);
//�صƣ�����ֵ>=0�ɹ���<0ʧ��;
VGUANGX1000DLL_API int __stdcall lightOff(void);
//�õ��豸�汾�ţ�����ֵ>=0�ɹ���<0ʧ��;
//            ����result-��Ϣ�����ַ�����
//            ����length-��Ϣ���ݳ��ȣ�
VGUANGX1000DLL_API int __stdcall getDeviceVer(char *result, int *length);
