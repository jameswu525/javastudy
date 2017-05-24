package com.api;

import java.io.UnsupportedEncodingException;


import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.ptr.IntByReference;

public class Vapi {
	
	public interface Vdll extends Library {
		Vdll INSTANCE = (Vdll)Native.loadLibrary("VguangX1000Dll", Vdll.class);
		//连接设备
		public int connectDevice();
		//开灯
		public int lightOn();
		//关灯
		public int  lightOff();
		//设置码制
		public int setBarcodeFormat(int barcodeFormat);
		//关闭设备
		public int disconnectDevice();
		//得到设备版本号
		public int getDeviceVer(byte[] result_dev,IntByReference length);
		//得到扫码信息
		public int getResultStr(byte[] result_decode,IntByReference length,int maxlen,int timeout);
	   

	}
		
		//打开设备
		public boolean vbarOpen(){
			if(Vdll.INSTANCE.connectDevice() > 0){
		    	return true;
		    }
		    else
		    {
		    	return false;
		    }
	}
			
		
		//背光控制
		public void vbarBacklight(boolean bool){
			if(bool)
			{
				Vdll.INSTANCE.lightOn();
			}
			else
			{
				Vdll.INSTANCE.lightOff();
			}
		}
		//设置码制
		//参数symbol_type：0-无，1-QR, 2-DM, 4-一维码, 
		//3-QR&DM, 5-QR&一维码, 6-DM&一维码, 
		//7-QR&DM&一维码
		public boolean vbarAddSymbolType(int symbol_type){
				if(Vdll.INSTANCE.setBarcodeFormat(symbol_type)>0)
				{
					return true;
				}
				else
				{
					return false;
				}
		}

		
		//关闭设备
		public void vbarClose() {
			Vdll.INSTANCE.disconnectDevice();
		}
		byte [] result_dev = new byte[1024];
		IntByReference length = new IntByReference(256);
		//获取版本信息
		public String getDevInfo() throws UnsupportedEncodingException{
			String devinfo = null;
			if(Vdll.INSTANCE.getDeviceVer(result_dev,length) > 0)
			{
				devinfo = new String(result_dev,"UTF-8" );
				return devinfo;
			}
			else
			{
				return "获取版本失败";
			}
		}
		byte [] result_decode = new byte[1024];
		IntByReference decodelength = new IntByReference(256);
		//获取扫码结果
		public String getDecoderesult() throws UnsupportedEncodingException{
			String decoderesult = null;
			if(Vdll.INSTANCE.getResultStr(result_decode, decodelength, 1024, 2)>0)
			{
				decoderesult = new String(result_decode,"UTF-8" );
				return decoderesult;
			}
			else
			{
				return null;
			}
			
			
		}
	}


